package org.wang.common.shiro;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.jsonwebtoken.Claims;
import jakarta.annotation.Resource;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.wang.common.enums.ResultEnum;
import org.wang.common.exception.BaseException;
import org.wang.user.entity.User;
import org.wang.user.service.IUserService;
import org.wang.user.vo.LoginUser;

/**
 * Author: 18615
 * Date: 2024/4/9 20:27
 */
@Component
public class AccountRealm extends AuthorizingRealm {

    @Resource
    private JwtUtil jwtUtil;

    @Resource
    private IUserService userService;

    /**
     * 多重写一个support
     * 标识这个Realm是专门用来验证JwtToken
     * 不负责验证其他的token（UsernamePasswordToken）
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String jwt = (String) authenticationToken.getCredentials();
        // 获取jwt中关于用户名
        String username = jwtUtil.getClaimsByToken(jwt).getSubject();
        // 查询用户
        User user = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getUsername, username));
        if (user == null) {
            throw new BaseException(ResultEnum.BAD_REQUEST, "用户不存在");
        }
        if (user.getEnabled() != 0) {
            throw new BaseException(ResultEnum.BAD_REQUEST, "用户被锁定");
        }
        LoginUser loginUser = new LoginUser();
        BeanUtils.copyProperties(user, loginUser);

        Claims claims = jwtUtil.getClaimsByToken(jwt);
        if (jwtUtil.isTokenExpired(claims.getExpiration())) {
            throw new BaseException(ResultEnum.BAD_REQUEST, "token过期，请重新登录");
        }
        return new SimpleAuthenticationInfo(loginUser, jwt, getName());
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}
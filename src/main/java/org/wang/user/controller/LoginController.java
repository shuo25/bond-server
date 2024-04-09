package org.wang.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.shiro.SecurityUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.wang.common.enums.ResultEnum;
import org.wang.common.response.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.wang.common.shiro.JwtUtil;
import org.wang.user.dto.UserLoginDTO;
import org.wang.user.entity.User;
import org.wang.user.service.IUserService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangshuo
 * @create 2024/4/2 10:12
 */
@RestController
public class LoginController {
    @Resource
    private JwtUtil jwtUtil;

    @Resource
    private IUserService userService;
    @PostMapping("/login")
    public Result<?> login(@RequestBody @Validated UserLoginDTO userLoginDTO, HttpServletResponse response){
        String username = userLoginDTO.getUsername();
        String password = userLoginDTO.getPassword();
        User user = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getUsername, userLoginDTO.getUsername()));
        if (user == null) {
            return Result.error(ResultEnum.ERROR.getCode(), "用户名不存在");
        }

        if (!user.getPassword().equals(password)) {
            return Result.error(ResultEnum.ERROR.getCode(), "用户名或密码错误");
        }

        String token = jwtUtil.generateToken(username);
        response.setHeader(JwtUtil.HEADER, token);
        response.setHeader("Access-control-Expost-Headers", JwtUtil.HEADER);
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        return Result.ok(map);
    }

    @PostMapping("/logout")
    public Result<?>  logout() {
        // 退出登录
        SecurityUtils.getSubject().logout();
        return Result.ok("退出成功！");
    }

}

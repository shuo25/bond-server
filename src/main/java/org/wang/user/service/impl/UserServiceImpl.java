package org.wang.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.wang.common.enums.ResultEnum;
import org.wang.common.response.Result;
import org.wang.user.entity.User;
import org.wang.user.mapper.UserMapper;
import org.wang.user.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: 18615
 * Date: 2024/3/18 20:37
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Override
    public User findByAccount(String username) {
        List<User> userList = baseMapper.selectList(new QueryWrapper<User>().lambda().eq(User::getUsername, username).eq(User::getDelFlag, 0));
        if (!userList.isEmpty()){
            return userList.get(0);
        }
        return null;
    }

    @Override
    public Result<User> addData(User user) {
        /*判断该账号是否存在*/
        if(this.findByAccount(user.getUsername()) != null){
            log.error(user.getUsername() + "已经存在！");
            return Result.error(ResultEnum.ACCOUNT_EXIST.getCode(),ResultEnum.ACCOUNT_EXIST.getMessage());
        }

        baseMapper.insert(user);

        return Result.ok(user);
    }
}

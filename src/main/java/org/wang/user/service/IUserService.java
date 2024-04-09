package org.wang.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.wang.common.response.Result;
import org.wang.user.entity.User;

/**
 * Author: 18615
 * Date: 2024/3/18 20:36
 */
public interface IUserService extends IService<User> {
    User findByAccount(String username);

    Result<User> addData(User user);
}

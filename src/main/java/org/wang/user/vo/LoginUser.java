package org.wang.user.vo;

import lombok.Data;

/**
 * 用户信息
 * Author: 18615
 * Date: 2024/4/13 17:06
 */
@Data
public class LoginUser {
    private String id;
    /**
     * 登录账号
     */
    private String username;
    /**
     * 姓名
     */
    private String name;
    /**
     * 手机号
     * */
    private String phone;

}

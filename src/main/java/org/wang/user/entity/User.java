package org.wang.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表实体
 * Author: 18615
 * Date: 2024/3/18 20:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
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
     * 密码
     */
    private String password;
    /**
     * 手机号
     * */
    private String phone;

    /**
     * 性别
     * */
    private Integer gender;
    /**
     * 是否启用
     * */
    private Integer enabled;

    /**
     * 上次登录时间
     * */
    private Date lastLoginTime;

    /**
     * 删除状态
     * */
    @TableLogic
    private Integer delFlag;
}

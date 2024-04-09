package org.wang.user.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Author: 18615
 * Date: 2024/4/9 20:33
 */
@Data
public class UserLoginDTO implements Serializable {

    private static final long serialVersionUID = -1L;

    private String username;
    private String password;
}

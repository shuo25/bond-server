package org.wang.user.controller;

import org.wang.common.enums.ResultEnum;
import org.wang.common.response.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @author wangshuo
 * @create 2024/4/2 10:12
 */
public class LoginController {
    @PostMapping("/login")
    public Result<?> login(@RequestBody Map<String,String> map){
        return Result.ok(null);
    }
}

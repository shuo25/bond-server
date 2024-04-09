package org.wang.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.wang.common.response.Result;
import org.wang.user.entity.User;
import org.wang.user.service.IUserService;
import org.springframework.web.bind.annotation.*;

/**
 * Author: ws
 * Date: 2024/3/18 19:42
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;

    /**
     * 分页获取所有用户信息
     * @param user 用户信息
     * @param pageNo 第几页
     * @param pageSize 每页有几条数据
     * @param request
     * */
    @GetMapping(value = "/page")
    public Result<?> getPageList(User user,
                                 @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                 @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                 HttpServletRequest request){
        Page<User> page = new Page<>(pageNo, pageSize);
        IPage<User> pageList = userService.page(page, new QueryWrapper<User>().lambda().like(user.getName() != null, User::getName, user.getName()));
        return Result.ok(pageList);
    }

    /**
     * 新增用户
     * */
    @PostMapping(value = "/save")
    public Result<?> saveData(@RequestBody User user){
        return userService.addData(user);
    }

    /**
     * 修改用户
     * */
    @PutMapping(value = "/update")
    public Result<?> updateData(@RequestBody User user){
        userService.updateById(user);
        return Result.ok("修改成功");
    }

    /**
     * 删除用户
     * */
    @DeleteMapping(value = "/by_id")
    public Result<?> deleteById(@RequestParam(name = "id") String id){
        userService.removeById(id);
        return Result.ok("删除成功");
    }

    /**
     * 根据id获取用户信息
     * @param id id
     * */
    @GetMapping(value = "/by_id")
    public Result<?> getUserById(@RequestParam String id){
        User user = userService.getById(id);
        return Result.ok(user);
    }


}

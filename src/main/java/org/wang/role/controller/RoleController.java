package org.wang.role.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import org.wang.common.response.Result;
import org.wang.role.entity.Role;
import org.wang.role.service.IRoleService;

/**
 * Author: 18615
 * Date: 2024/4/9 11:02
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Resource
    private IRoleService roleService;

    /**
     * 分页获取所有角色信息
     * @param role 角色信息
     * @param pageNo 第几页
     * @param pageSize 每页有几条数据
     * @param request
     * */
    @GetMapping(value = "/page")
    public Result<?> getPageList(Role role,
                                 @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                 @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                 HttpServletRequest request){
        Page<Role> page = new Page<>(pageNo, pageSize);
        IPage<Role> pageList = roleService.page(page, new QueryWrapper<Role>().lambda().like(role.getName() != null, Role::getName, role.getName()));
        return Result.ok(pageList);
    }
    /**
     * 新增用户
     * */
    @PostMapping(value = "/save")
    public Result<?> saveData(@RequestBody Role role){
        boolean save = roleService.save(role);
        return Result.ok("添加成功");
    }

    /**
     * 修改用户
     * */
    @PutMapping(value = "/update")
    public Result<?> updateData(@RequestBody Role role){
        roleService.updateById(role);
        return Result.ok("修改成功");
    }

    /**
     * 删除用户
     * */
    @DeleteMapping(value = "/by_id")
    public Result<?> deleteById(@RequestParam(name = "id") String id){
        roleService.removeById(id);
        return Result.ok("删除成功");
    }

    /**
     * 根据id获取用户信息
     * @param id id
     * */
    @GetMapping(value = "/by_id")
    public Result<?> getUserById(@RequestParam String id){
        Role role = roleService.getById(id);
        return Result.ok(role);
    }



}

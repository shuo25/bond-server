package org.wang.permission.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import org.wang.common.response.Result;
import org.wang.permission.entity.Permission;
import org.wang.permission.service.IPermissionService;

/**
 * <p>
 * 系统权限表 前端控制器
 * </p>
 *
 * @author wangshuo
 * @since 2024-04-09
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Resource
    private IPermissionService permissionService;

    /**
     * 分页获取所有权限信息
     * @param permission 权限信息
     * @param pageNo 第几页
     * @param pageSize 每页有几条数据
     * @param request 请求
     * */
    @GetMapping(value = "/page")
    public Result<?> getPageList(Permission permission,
                                 @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                 @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                 HttpServletRequest request){
        Page<Permission> page = new Page<>(pageNo, pageSize);
        IPage<Permission> pageList = permissionService.page(page, new QueryWrapper<Permission>().lambda().like(permission.getName() != null, Permission::getName, permission.getName()));
        return Result.ok(pageList);
    }
    /**
     * 新增用户
     * */
    @PostMapping(value = "/save")
    public Result<?> saveData(@RequestBody Permission permission){
        boolean save = permissionService.save(permission);
        return Result.ok("添加成功");
    }

    /**
     * 修改用户
     * */
    @PutMapping(value = "/update")
    public Result<?> updateData(@RequestBody Permission permission){
        permissionService.updateById(permission);
        return Result.ok("修改成功");
    }

    /**
     * 删除用户
     * */
    @DeleteMapping(value = "/by_id")
    public Result<?> deleteById(@RequestParam(name = "id") String id){
        permissionService.removeById(id);
        return Result.ok("删除成功");
    }

    /**
     * 根据id获取用户信息
     * @param id id
     * */
    @GetMapping(value = "/by_id")
    public Result<?> getUserById(@RequestParam String id){
        Permission permission = permissionService.getById(id);
        return Result.ok(permission);
    }

}

package org.wang.role.service.impl;

import org.wang.role.entity.RolePermission;
import org.wang.role.mapper.RolePermissionMapper;
import org.wang.role.service.IRolePermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色-权限关联表 服务实现类
 * </p>
 *
 * @author wangshuo
 * @since 2024-04-09
 */
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements IRolePermissionService {

}

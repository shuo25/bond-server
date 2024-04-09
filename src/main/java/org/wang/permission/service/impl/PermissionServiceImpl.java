package org.wang.permission.service.impl;

import org.wang.permission.entity.Permission;
import org.wang.permission.mapper.PermissionMapper;
import org.wang.permission.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统权限表 服务实现类
 * </p>
 *
 * @author wangshuo
 * @since 2024-04-09
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}

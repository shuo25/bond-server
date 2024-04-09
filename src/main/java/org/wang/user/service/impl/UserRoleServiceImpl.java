package org.wang.user.service.impl;

import org.wang.user.entity.UserRole;
import org.wang.user.mapper.UserRoleMapper;
import org.wang.user.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户-角色关系表表 服务实现类
 * </p>
 *
 * @author wangshuo
 * @since 2024-04-09
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}

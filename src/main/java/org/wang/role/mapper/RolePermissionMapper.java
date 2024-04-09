package org.wang.role.mapper;

import org.wang.role.entity.RolePermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 角色-权限关联表 Mapper 接口
 * </p>
 *
 * @author wangshuo
 * @since 2024-04-09
 */
@Mapper
public interface RolePermissionMapper extends BaseMapper<RolePermission> {

}

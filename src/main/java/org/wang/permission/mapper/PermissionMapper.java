package org.wang.permission.mapper;

import org.wang.permission.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 系统权限表 Mapper 接口
 * </p>
 *
 * @author wangshuo
 * @since 2024-04-09
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

}

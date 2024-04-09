package org.wang.user.mapper;

import org.wang.user.entity.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户-角色关系表表 Mapper 接口
 * </p>
 *
 * @author wangshuo
 * @since 2024-04-09
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {

}

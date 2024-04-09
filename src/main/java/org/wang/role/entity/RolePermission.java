package org.wang.role.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.*;

/**
 * <p>
 * 角色-权限关联表
 * </p>
 *
 * @author wangshuo
 * @since 2024-04-09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_role_permission")
public class RolePermission implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 权限id
     */
    private String permissionId;
}

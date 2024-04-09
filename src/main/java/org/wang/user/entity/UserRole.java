package org.wang.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 用户-角色关系表表
 * </p>
 *
 * @author wangshuo
 * @since 2024-04-09
 */
@Getter
@Setter
@TableName("t_user_role")
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 角色id，数据来源于role表的主键
     */
    private String roleId;

    /**
     * 用户id，数据来源于user表的主键
     */
    private String userId;
}

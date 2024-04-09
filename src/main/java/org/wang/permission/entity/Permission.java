package org.wang.permission.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.*;

/**
 * <p>
 * 系统权限表
 * </p>
 *
 * @author wangshuo
 * @since 2024-04-09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_permission")
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 接口路径
     */
    private String url;

    /**
     * 请求方式（0-get；1-post）
     */
    private Byte method;

    /**
     * 服务名
     */
    private String service;

    /**
     * 父级权限id
     */
    private String parentId;

    /**
     * 删除状态
     */
    @TableLogic
    private Integer delFlag;
}

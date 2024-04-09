package org.wang.role.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Author: 18615
 * Date: 2024/4/9 10:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_role")
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 名称
     */
    private String name;
    /**
     * 备注
     */
    private String remark;
    /**
     * 删除状态
     * */
    @TableLogic
    private Integer delFlag;
}

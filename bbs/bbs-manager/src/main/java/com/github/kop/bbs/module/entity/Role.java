package com.github.kop.bbs.module.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * @author root
 * @since 2022-08-15
 */
@Getter
@Setter
@TableName("bbs_role")
public class Role implements Serializable {

  private static final long serialVersionUID = 1L;

  /** 角色主键 */
  @TableId(value = "role_id", type = IdType.AUTO)
  private Long roleId;

  /** 角色名称 */
  @TableField("role_name")
  private String roleName;

  /** 角色code */
  @TableField("role_code")
  private String roleCode;

  /** 是否删除 0 为未删除、1 为已删除 */
  @TableField("deleted")
  private Integer deleted;
}

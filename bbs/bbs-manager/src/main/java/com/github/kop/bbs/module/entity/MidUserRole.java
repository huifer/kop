package com.github.kop.bbs.module.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.*;

/**
 * 用户角色中间表
 *
 * @author ahxiaoqi
 * @since 2022-08-13
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("bbs_mid_user_role")
public class MidUserRole implements Serializable {

  private static final long serialVersionUID = 1L;

  /** 中间表主键 */
  @TableId(value = "mid_role_id", type = IdType.AUTO)
  private Long midRoleId;

  /** 用户id */
  @TableField("user_id")
  private Long userId;

  /** 角色id */
  @TableField("role_id")
  private Long roleId;

  /** 角色code */
  @TableField("role_code")
  private String roleCode;

  /** 是否删除 0 为未删除、1 为已删除 */
  @TableField("deleted")
  private Integer deleted;
}

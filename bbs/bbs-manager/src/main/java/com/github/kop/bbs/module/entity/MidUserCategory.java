package com.github.kop.bbs.module.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.*;

/**
 * 版主与分类的中间表
 *
 * @author ahxiaoqi
 * @since 2022-08-13
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("bbs_mid_user_category")
public class MidUserCategory implements Serializable {

  private static final long serialVersionUID = 1L;

  /** 主键 */
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  /** 用户id */
  @TableField("user_id")
  private Long userId;

  /** 版块id */
  @TableField("category_id")
  private Long categoryId;

  /** 是否删除 0 为未删除、1 为已删除 */
  @TableField("deleted")
  private Integer deleted;
}

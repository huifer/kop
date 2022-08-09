package com.github.kop.customer.module.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户动态表
 *
 * @author root
 * @since 2022-08-03
 */
@Getter
@Setter
@TableName("customer_user_dynamic")
public class CustomerUserDynamic implements Serializable {

  private static final long serialVersionUID = 1L;

  /** 主键 */
  @TableId("id")
  private Long id;

  /** 创建时间 */
  @TableField(value = "create_time", fill = FieldFill.INSERT)
  private LocalDateTime createTime;

  /** 逻辑删除标记位 */
  @TableField("deleted")
  private Integer deleted;

  /** 用户id */
  @TableField("user_id")
  private Long userId;

  /** 动态内容 */
  @TableField("content")
  private String content;
}

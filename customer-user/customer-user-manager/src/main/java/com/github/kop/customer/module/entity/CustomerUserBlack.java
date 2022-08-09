package com.github.kop.customer.module.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户拉黑表
 *
 * @author root
 * @since 2022-08-03
 */
@Getter
@Setter
@TableName("customer_user_black")
public class CustomerUserBlack implements Serializable {

  private static final long serialVersionUID = 1L;

  /** 主键 */
  @TableId("id")
  private Long id;

  /** 用户id */
  @TableField("user_id")
  private Long userId;

  /** 被拉黑的用户id */
  @TableField("black_user_id")
  private Long blackUserId;
}

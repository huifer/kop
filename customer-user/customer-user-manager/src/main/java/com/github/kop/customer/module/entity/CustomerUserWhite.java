package com.github.kop.customer.module.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户关注表
 *
 * @author root
 * @since 2022-08-03
 */
@Getter
@Setter
@TableName("customer_user_white")
public class CustomerUserWhite implements Serializable {

  private static final long serialVersionUID = 1L;

  /** 主键 */
  @TableId("id")
  private Long id;

  /** 用户id */
  @TableField("user_id")
  private Long userId;

  /** 关注的用户id */
  @TableField("white_user_id")
  private Long whiteUserId;
}

package com.github.kop.customer.module.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户信息表
 *
 * @author root
 * @since 2022-08-03
 */
@Getter
@Setter
@TableName("customer_user")
public class CustomerUser implements Serializable {

  private static final long serialVersionUID = 1L;

  /** 主键 */
  @TableId("id")
  private Long id;

  /** 逻辑删除标记位 */
  @TableField("deleted")
  private Integer deleted;

  /** 乐观锁 */
  @TableField("version")
  private Long version;

  /** 姓名 */
  @TableField("name")
  private String name;

  /** 联系方式 */
  @TableField("phone")
  private String phone;

  /** 性别 */
  @TableField("grade")
  private Integer grade;

  /** 密码 */
  @TableField("password")
  private String password;

  /** 注册时间 */
  @TableField("register_time")
  private LocalDateTime registerTime;
}

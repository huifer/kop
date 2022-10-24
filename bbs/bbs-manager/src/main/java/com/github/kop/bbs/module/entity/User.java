package com.github.kop.bbs.module.entity;

import com.baomidou.mybatisplus.annotation.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 用户表 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_user")
public class User implements Serializable {
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  /** 用户名 */
  @TableField(value = "username")
  private String username;

  /** 密码 */
  @TableField(value = "`password`")
  private String password;

  /** salt */
  @TableField(value = "salt")
  private String salt;

  /** 用户头像 */
  @TableField(value = "avatar")
  private String avatar;

  /** 昵称 */
  @TableField(value = "nickname")
  private String nickname;

  /** 注册时间 */
  @TableField(value = "register_time", fill = FieldFill.INSERT)
  private LocalDateTime registerTime;

  private static final long serialVersionUID = 1L;
}

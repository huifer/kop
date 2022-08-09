package com.github.kop.bbs.module.req.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CreateUserReq {
  /** 用户名 */
  @ApiModelProperty(value = "用户名")
  private String username;

  /**
   * 密码
   */
  @ApiModelProperty(value = "密码")
  private String password;

  /**
   * 用户头像
   */
  @ApiModelProperty(value = "用户头像")
  private String avatar;

  /**
   * 昵称
   */
  @ApiModelProperty(value = "昵称")
  private String nickname;
}

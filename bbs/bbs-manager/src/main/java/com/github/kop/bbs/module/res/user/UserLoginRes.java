package com.github.kop.bbs.module.res.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "登录返回结果")
public class UserLoginRes {

  /** 用户名 */
  @ApiModelProperty(value = "用户名")
  private String username;

  @ApiModelProperty("token")
  private String token;

  /** 用户头像 */
  @ApiModelProperty(value = "用户头像")
  private String avatar;

  /** 昵称 */
  @ApiModelProperty(value = "昵称")
  private String nickname;
}

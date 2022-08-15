package com.github.kop.bbs.module.req.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @auth ahxiaoqi
 * @desc 更新用户
 * @time 2022/8/9 22:49
 */
@ApiModel("更新用户的参数")
@Data
public class UpdateUserReq {

  private Long id;

  /** 密码 */
  @ApiModelProperty(value = "密码")
  private String password;

  /** 用户头像 */
  @ApiModelProperty(value = "用户头像")
  private String avatar;

  /** 昵称 */
  @ApiModelProperty(value = "昵称")
  private String nickname;
}

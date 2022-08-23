package com.github.kop.bbs.module.res.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("用户关注查询返回值")
@Data
public class UserRelationResp {

  @ApiModelProperty("用户id")
  private Long userId;
  @ApiModelProperty("用户名")
  private String userName;
  @ApiModelProperty("头像")
  private String avatar;
  @ApiModelProperty("昵称")
  private String nickname;

}

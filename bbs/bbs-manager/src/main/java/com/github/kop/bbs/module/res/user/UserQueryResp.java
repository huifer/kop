package com.github.kop.bbs.module.res.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import lombok.Data;

@ApiModel("用户查询返回对象")
@Data
public class UserQueryResp {

  @ApiModelProperty("用户id")
  private Long id;

  @ApiModelProperty("用户名称")
  private String username;

  @ApiModelProperty("头像")
  private String avatar;

  @ApiModelProperty("昵称")
  private String nickname;

  @ApiModelProperty("注册时间")
  private LocalDateTime registerTime;

}

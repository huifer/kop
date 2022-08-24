package com.github.kop.bbs.module.req.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import lombok.Data;

@ApiModel("用户查询参数")
@Data
public class UserQueryReq {

  @ApiModelProperty("用户名称")
  private String username;

  @ApiModelProperty("用户昵称")
  private String nickname;

  @ApiModelProperty("注册开始时间")
  private LocalDateTime registerStartTime;
  @ApiModelProperty("注册结束时间")
  private LocalDateTime registerEndTime;


}

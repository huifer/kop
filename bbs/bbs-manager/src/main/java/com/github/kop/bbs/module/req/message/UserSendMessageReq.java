package com.github.kop.bbs.module.req.message;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("用户发消息参数")
@Data
public class UserSendMessageReq {

  @ApiModelProperty(value = "消息内容")
  private String content;

  @ApiModelProperty(value = "接收人id")
  private Long sendToUserId;
}

package com.github.kop.bbs.module.res.message;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("消息实体")
public class MessageResp {
  @ApiModelProperty(value = "通知类型")
  private Integer messageType;

  @ApiModelProperty(value = "产生消息的对应内容的主键")
  private Long messageEventId;

  @ApiModelProperty(value = "发送发用户ID")
  private Long senderUserId;

  @ApiModelProperty(value = "发送人名称")
  private String senderUserName;

  @ApiModelProperty(value = "摘要说明")
  private String brief;

  @ApiModelProperty(value = "详细内容")
  private String content;

}

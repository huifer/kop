package com.github.kop.bbs.module.req.topic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("话题审核参数")
@Data
public class TopicAuditReq {
  @ApiModelProperty("话题id")
  private Long topicId;

  @ApiModelProperty("审核意见")
  private boolean pass;

  @ApiModelProperty("审核意见文本")
  private String context;
}

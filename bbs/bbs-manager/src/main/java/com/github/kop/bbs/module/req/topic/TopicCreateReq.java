package com.github.kop.bbs.module.req.topic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("话题创建参数")
@Data
public class TopicCreateReq {

  @ApiModelProperty("话题标题")
  private String topicTitle;

  @ApiModelProperty("话题内容")
  private String topicContent;
}

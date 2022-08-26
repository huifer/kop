package com.github.kop.bbs.module.res.topic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("话题查询返回值")
@Data
public class TopicQueryResp {

  @ApiModelProperty("话题id")
  private Long topicId;
  @ApiModelProperty("话题标题")
  private String topicTitle;
  @ApiModelProperty("话题内容")
  private String topicContent;

}

package com.github.kop.bbs.module.req.topic;

import com.github.kop.bbs.module.enums.TopicStatusEnum;
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

  @ApiModelProperty("话题状态")
  private Integer topicStatus;

  private TopicStatusEnum topicStatusEnum;

  public void setTopicStatus(Integer topicStatus) {
    this.topicStatus = topicStatus;
    this.topicStatusEnum = TopicStatusEnum.conv(topicStatus);
  }
}

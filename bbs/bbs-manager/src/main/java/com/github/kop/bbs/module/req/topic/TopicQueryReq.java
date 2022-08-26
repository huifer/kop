package com.github.kop.bbs.module.req.topic;

import com.github.kop.bbs.module.enums.AuditStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("话题查询参数")
@Data
public class TopicQueryReq {

  @ApiModelProperty("话题标题")
  private String topicTitle;

  @ApiModelProperty("话题内容")
  private String topicContent;

  @ApiModelProperty("话题状态")
  private Integer topicStatus;

  private AuditStatusEnum auditStatusEnum;

  public void setTopicStatus(Integer topicStatus) {
    this.topicStatus = topicStatus;
    this.auditStatusEnum = AuditStatusEnum.conv(topicStatus);
  }
}

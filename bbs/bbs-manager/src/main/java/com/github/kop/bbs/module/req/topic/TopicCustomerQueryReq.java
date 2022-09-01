package com.github.kop.bbs.module.req.topic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("话题查询参数")
@Data
public class TopicCustomerQueryReq {

  @ApiModelProperty("话题标题")
  private String topicTitle;


  @ApiModelProperty("排序类型 1 创建时间 2 热度")
  private Integer topicSortType;


}

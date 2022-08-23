package com.github.kop.bbs.module.req.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("创建动态")
public class UserDynamicCreateReq {

  @ApiModelProperty("话题主键")
  private Long topicId;

  @ApiModelProperty("详细内容")
  private String content;

}

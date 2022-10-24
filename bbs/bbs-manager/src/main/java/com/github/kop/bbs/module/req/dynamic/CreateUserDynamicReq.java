package com.github.kop.bbs.module.req.dynamic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("用户创建动态参数")
@Data
public class CreateUserDynamicReq {

  @ApiModelProperty("话题id")
  private Long topicId;
}

package com.github.kop.bbs.module.req;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Api("创建反馈参数")
public class FeedBackReq {
  @ApiModelProperty("反馈内容")
  private String feedbackText;
}

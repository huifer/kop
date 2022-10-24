package com.github.kop.bbs.module.res;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FeedBackResp {

  @ApiModelProperty("反馈内容")
  private String feedbackText;

  @ApiModelProperty("用户id")
  private Long userId;

  @ApiModelProperty("用户名")
  private String userName;

  @ApiModelProperty("用户昵称")
  private String nickName;
}

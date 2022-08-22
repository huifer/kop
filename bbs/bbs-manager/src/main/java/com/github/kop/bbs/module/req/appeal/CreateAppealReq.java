package com.github.kop.bbs.module.req.appeal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "创建申诉参数")
@Data
public class CreateAppealReq {

  @ApiModelProperty(value = "申诉类别")
  private Long appealType;

  @ApiModelProperty(value = "申诉标题")
  private String appealTitle;

  @ApiModelProperty(value = "申诉描述")
  private String appealText;

  @ApiModelProperty(value = "申诉附件")
  private String appealFile;

}

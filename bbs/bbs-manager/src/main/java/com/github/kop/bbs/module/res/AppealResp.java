package com.github.kop.bbs.module.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;

@Data
@ApiModel("申诉详情")
public class AppealResp {

  @ApiModelProperty("申诉类别")
  private Integer appealType;
  @ApiModelProperty("申诉类别名称")
  private String  appealTypeString;

  @ApiModelProperty("申诉标题")
  private String appealTitle;

  @ApiModelProperty("申诉描述")
  private String appealText;

  @ApiModelProperty("申诉人")
  private Long appealUserId;
  @ApiModelProperty("申诉人名称")
  private String appealUserName;

  @ApiModelProperty("申诉附件")
  private String appealFile;

  @ApiModelProperty("创建时间")
  private LocalDateTime createTime;


}

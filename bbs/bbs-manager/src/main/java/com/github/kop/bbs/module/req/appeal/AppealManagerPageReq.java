package com.github.kop.bbs.module.req.appeal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/9/6 21:03
 */
@ApiModel("管理员查询申诉列表参数")
@Data
public class AppealManagerPageReq {

  @ApiModelProperty("申诉状态")
  private Integer appealStatus;

  @ApiModelProperty("申诉类别")
  private Integer appealType;
}

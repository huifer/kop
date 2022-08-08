package com.github.kop.rbac.module.req.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "应用更新请求参数")
public class UpdateAppReq {
  @ApiModelProperty(value = "主键")
  private Long id;

  @ApiModelProperty(value = "应用名称")
  private String name;
}

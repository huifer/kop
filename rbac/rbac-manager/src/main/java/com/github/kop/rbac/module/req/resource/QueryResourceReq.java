package com.github.kop.rbac.module.req.resource;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QueryResourceReq {

  @ApiModelProperty(value = "编码")
  private String code;

  @ApiModelProperty(value = "名称")
  private String name;

  @ApiModelProperty(value = "类型")
  private String type;
}

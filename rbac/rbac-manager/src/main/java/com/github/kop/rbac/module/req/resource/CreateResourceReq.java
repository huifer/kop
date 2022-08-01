package com.github.kop.rbac.module.req.resource;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CreateResourceReq {
  @ApiModelProperty(value = "资源编码")
  private String code;

  @ApiModelProperty(value = "资源名称")
  private String name;

  @ApiModelProperty(value = "资源类型")
  private String type;
}

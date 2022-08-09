package com.github.kop.rbac.module.res.resource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "")
public class ResourceQueryRes {
  private Long id;

  @ApiModelProperty(value = "资源编码")
  private String code;

  @ApiModelProperty(value = "资源名称")
  private String name;

  @ApiModelProperty(value = "资源类型")
  private String type;

  @ApiModelProperty(value = "应用id")
  private Long appId;

}

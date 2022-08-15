package com.github.kop.rbac.module.req.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "应用查询请求参数")
public class QueryAppReq {
  @ApiModelProperty(value = "应用名称")
  private String name;

  @ApiModelProperty(value = "应用编码")
  private String code;

  private Long id;
}

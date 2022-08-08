package com.github.kop.rbac.module.req.post;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QueryPostReq {

  @ApiModelProperty(value = "岗位名称")
  private String postName;

  @ApiModelProperty(value = "部门id")
  private Long deptId;

}

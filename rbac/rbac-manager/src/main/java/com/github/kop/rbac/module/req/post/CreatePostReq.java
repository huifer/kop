package com.github.kop.rbac.module.req.post;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CreatePostReq {

  @ApiModelProperty(value = "岗位名称")
  private String name;

  @ApiModelProperty(value = "部门id")
  private Long deptId;

  @ApiModelProperty(value = "企业id")
  private Long companyId;
}

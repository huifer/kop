package com.github.kop.rbac.module.res.post;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "岗位查询响应参数")
public class PostQueryRes {

  @ApiModelProperty(value = "岗位名称")
  private String name;

  @ApiModelProperty(value = "部门id")
  private Long deptId;

  @ApiModelProperty(value = "企业id")
  private Long companyId;

  @ApiModelProperty(value = "部门名称")
  private String deptName;

  @ApiModelProperty(value = "企业名称")
  private String companyName;
}

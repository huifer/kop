package com.github.kop.rbac.module.res.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "部门查询响应参数")
public class UserQueryRes {
  @ApiModelProperty(value = "主键")
  private Long id;

  @ApiModelProperty(value = "用户名称")
  private String userName;

  @ApiModelProperty(value = "部门名称")
  private String deptName;

  @ApiModelProperty(value = "联系电话")
  private String phone;

  @ApiModelProperty(value = "企业名称")
  private String companyName;

  @ApiModelProperty(value = "主岗位名称")
  private String mainPostName;
}

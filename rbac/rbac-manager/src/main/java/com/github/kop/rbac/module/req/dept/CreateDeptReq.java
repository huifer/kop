package com.github.kop.rbac.module.req.dept;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "部门创建请求参数")
public class CreateDeptReq {
  @ApiModelProperty(value = "部门名称")
  private String name;

  @ApiModelProperty(value = "部门介绍")
  private String desc;

  @ApiModelProperty(value = "排序号")
  private Integer sort = 0;

  @ApiModelProperty(value = "父级id")
  private Long pid;
}

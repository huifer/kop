package com.github.kop.rbac.module.res.dept;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;

@Data
@ApiModel(value = "部门查询响应参数")
public class DeptQueryRes {
  @ApiModelProperty(value = "主键")
  private Long id;

  @ApiModelProperty(value = "部门名称")
  private String name;

  @ApiModelProperty(value = "部门介绍")
  private String desc;

  @ApiModelProperty(value = "排序号")
  private Integer sort;

  @ApiModelProperty(value = "父级id")
  private Long pid;

  @ApiModelProperty(value = "父部门名称")
  private String pName;

  @ApiModelProperty(value = "子部门列表")
  private List<DeptQueryRes> child;
}

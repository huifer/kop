package com.github.kop.rbac.module.req.dept;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "部门更新请求参数")
public class UpdateDeptReq {
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

}

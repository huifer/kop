package com.github.kop.rbac.module.req.dept;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "部门查询请求参数")
public class QueryDeptReq {
    @ApiModelProperty(value = "部门名称")
    private String name;

    @ApiModelProperty(value = "部门介绍")
    private String desc;


    @ApiModelProperty(value = "企业名称")
    private String companyName;


}

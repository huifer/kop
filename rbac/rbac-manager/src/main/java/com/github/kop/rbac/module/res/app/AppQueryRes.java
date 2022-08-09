package com.github.kop.rbac.module.res.app;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AppQueryRes {
    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "应用名称")
    private String name;
    @ApiModelProperty(value = "应用编码")
    private String code;


}

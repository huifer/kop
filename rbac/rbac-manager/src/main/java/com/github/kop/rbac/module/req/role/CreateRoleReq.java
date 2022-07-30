package com.github.kop.rbac.module.req.role;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CreateRoleReq {

  @ApiModelProperty(value = "角色编码")
  private String code;

  @ApiModelProperty(value = "角色名称")
  private String name;

  @ApiModelProperty(value = "角色描述")
  private String desc;


}

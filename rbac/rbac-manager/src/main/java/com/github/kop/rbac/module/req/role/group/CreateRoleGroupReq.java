package com.github.kop.rbac.module.req.role.group;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CreateRoleGroupReq {
  @ApiModelProperty(value = "角色组名称")
  private String name;
}

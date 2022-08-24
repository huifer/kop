package com.github.kop.bbs.module.res.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("角色列表响应")
@Data
public class RoleListResp {

  @ApiModelProperty("角色id")
  private Long roleId;

  @ApiModelProperty("角色名称")
  private String roleName;

  @ApiModelProperty("角色编码")
  private String roleCode;


}

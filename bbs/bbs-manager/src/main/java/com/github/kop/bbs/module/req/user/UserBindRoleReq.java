package com.github.kop.bbs.module.req.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;

@ApiModel("用户角色绑定参数")
@Data
public class UserBindRoleReq {

  @ApiModelProperty("角色id")
  private List<Long> roleIds;

  @ApiModelProperty("用户id")
  private Long userId;
}

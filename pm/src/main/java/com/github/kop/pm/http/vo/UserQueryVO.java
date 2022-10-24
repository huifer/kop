package com.github.kop.pm.http.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
@ApiModel("自定义查询 用户表")
public class UserQueryVO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;

  /** 用户名 */
  @ApiModelProperty("用户名")
  private String username;

  /** 密码 */
  @ApiModelProperty("密码")
  private String password;
}

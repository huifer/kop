package com.github.kop.pm.http.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.Data;


@Data
@ApiModel("保存 用户表")
public class UserVO implements Serializable {

  private static final long serialVersionUID = 1L;

  @javax.validation.constraints.NotNull(message = "id can not null")
  @NotNull(message = "id can not null")
  private Integer id;


  /**
   * 用户名
   */
  @ApiModelProperty("用户名")
  private String username;


  /**
   * 密码
   */
  @ApiModelProperty("密码")
  private String password;

}

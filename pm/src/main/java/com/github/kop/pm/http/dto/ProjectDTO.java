package com.github.kop.pm.http.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
@ApiModel("项目")
public class ProjectDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  /** 主键 */
  @ApiModelProperty("主键")
  private Integer id;

  /** 项目名称 */
  @ApiModelProperty("项目名称")
  private String name;
}

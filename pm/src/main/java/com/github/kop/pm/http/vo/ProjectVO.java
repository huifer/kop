package com.github.kop.pm.http.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.Data;


@Data
@ApiModel("保存 项目")
public class ProjectVO implements Serializable {

  private static final long serialVersionUID = 1L;


  /**
   * 主键
   */
  @javax.validation.constraints.NotNull(message = "id can not null")
  @NotNull(message = "id can not null")
  @ApiModelProperty("主键")
  private Integer id;


  /**
   * 项目名称
   */
  @ApiModelProperty("项目名称")
  private String name;

}

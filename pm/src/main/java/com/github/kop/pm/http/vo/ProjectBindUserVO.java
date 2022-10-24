package com.github.kop.pm.http.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.Data;


@Data
@ApiModel("保存 项目和人")
public class ProjectBindUserVO implements Serializable {

  private static final long serialVersionUID = 1L;

  @javax.validation.constraints.NotNull(message = "id can not null")
  @NotNull(message = "id can not null")
  private Integer id;


  /**
   * 项目id
   */
  @ApiModelProperty("项目id")
  private Integer projectId;


  /**
   * 人员id
   */
  @ApiModelProperty("人员id")
  private Integer userId;

}

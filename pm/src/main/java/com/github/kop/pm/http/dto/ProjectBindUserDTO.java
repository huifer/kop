package com.github.kop.pm.http.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
@ApiModel("项目和人")
public class ProjectBindUserDTO implements Serializable {

  private static final long serialVersionUID = 1L;
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

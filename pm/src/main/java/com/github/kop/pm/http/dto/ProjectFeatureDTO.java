package com.github.kop.pm.http.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
@ApiModel("项目功能")
public class ProjectFeatureDTO implements Serializable {

  private static final long serialVersionUID = 1L;
  private Integer id;


  /**
   * 项目id
   */
  @ApiModelProperty("项目id")
  private Integer projectId;


  /**
   * 版本id
   */
  @ApiModelProperty("版本id")
  private Integer projectEditionId;


  /**
   * 功能名称
   */
  @ApiModelProperty("功能名称")
  private String name;


  /**
   * 功能描述
   */
  @ApiModelProperty("功能描述")
  private String desc;


  /**
   * 外部链接
   */
  @ApiModelProperty("外部链接")
  private String link;

}

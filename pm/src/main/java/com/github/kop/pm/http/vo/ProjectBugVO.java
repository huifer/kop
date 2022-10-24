package com.github.kop.pm.http.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.Data;


@Data
@ApiModel("保存 项目bug")
public class ProjectBugVO implements Serializable {

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
   * 版本id
   */
  @ApiModelProperty("版本id")
  private Integer projectEditionId;


  /**
   * bug名称
   */
  @ApiModelProperty("bug名称")
  private String name;


  /**
   * bug描述
   */
  @ApiModelProperty("bug描述")
  private String desc;


  /**
   * 功能id
   */
  @ApiModelProperty("功能id")
  private Integer projectFeatureId;

}

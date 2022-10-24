package com.github.kop.pm.http.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
@ApiModel("自定义查询 项目bug")
public class ProjectBugQueryVO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;

  /** 项目id */
  @ApiModelProperty("项目id")
  private Integer projectId;

  /** 版本id */
  @ApiModelProperty("版本id")
  private Integer projectEditionId;

  /** bug名称 */
  @ApiModelProperty("bug名称")
  private String name;

  /** bug描述 */
  @ApiModelProperty("bug描述")
  private String desc;

  /** 功能id */
  @ApiModelProperty("功能id")
  private Integer projectFeatureId;
}

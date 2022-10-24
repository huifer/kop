package com.github.kop.pm.http.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
@ApiModel("任务协作人")
public class ProjectTaskCollaboratorDTO implements Serializable {

  private static final long serialVersionUID = 1L;
  private Integer id;

  /** 项目任务 */
  @ApiModelProperty("项目任务")
  private Integer projectTaskId;

  /** 协作人id */
  @ApiModelProperty("协作人id")
  private Integer userId;

  /** 项目id */
  @ApiModelProperty("项目id")
  private Integer projectId;

  /** 版本id */
  @ApiModelProperty("版本id")
  private Integer projectEditionId;
}

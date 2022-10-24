package com.github.kop.pm.http.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.Data;


@Data
@ApiModel("保存 任务协作人")
public class ProjectTaskCollaboratorVO implements Serializable {

  private static final long serialVersionUID = 1L;

  @javax.validation.constraints.NotNull(message = "id can not null")
  @NotNull(message = "id can not null")
  private Integer id;


  /**
   * 项目任务
   */
  @ApiModelProperty("项目任务")
  private Integer projectTaskId;


  /**
   * 协作人id
   */
  @ApiModelProperty("协作人id")
  private Integer userId;


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

}

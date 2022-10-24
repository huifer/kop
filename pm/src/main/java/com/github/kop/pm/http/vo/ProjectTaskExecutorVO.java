package com.github.kop.pm.http.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@ApiModel("保存 任务执行人")
public class ProjectTaskExecutorVO implements Serializable {

  private static final long serialVersionUID = 1L;

  @javax.validation.constraints.NotNull(message = "id can not null")
  @NotNull(message = "id can not null")
  private Integer id;

  /** 项目任务 */
  @ApiModelProperty("项目任务")
  private Integer projectTaskId;

  /** 执行人 */
  @ApiModelProperty("执行人")
  private Integer userId;
}

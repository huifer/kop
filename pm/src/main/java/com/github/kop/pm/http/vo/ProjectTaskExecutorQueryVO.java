package com.github.kop.pm.http.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
@ApiModel("自定义查询 任务执行人")
public class ProjectTaskExecutorQueryVO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;


  /**
   * 项目任务
   */
  @ApiModelProperty("项目任务")
  private Integer projectTaskId;


  /**
   * 执行人
   */
  @ApiModelProperty("执行人")
  private Integer userId;

}
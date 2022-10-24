package com.github.kop.pm.http.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import lombok.Data;


@Data
@ApiModel("保存 项目任务执行历史")
public class ProjectTaskHistoryVO implements Serializable {

  private static final long serialVersionUID = 1L;

  @javax.validation.constraints.NotNull(message = "id can not null")
  @NotNull(message = "id can not null")
  private Integer id;


  /**
   * 任务id
   */
  @ApiModelProperty("任务id")
  private Integer projectTaskId;


  /**
   * 开始时间
   */
  @ApiModelProperty("开始时间")
  private LocalDateTime startTime;


  /**
   * 结束时间
   */
  @ApiModelProperty("结束时间")
  private LocalDateTime endTime;


  /**
   * 用户id
   */
  @ApiModelProperty("用户id")
  private Integer userId;


  /**
   * 备注
   */
  @ApiModelProperty("备注")
  private String note;

}

package com.github.kop.pm.http.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@ApiModel("项目任务")
public class ProjectTaskDTO implements Serializable {

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
   * 任务名称
   */
  @ApiModelProperty("任务名称")
  private String name;


  /**
   * 任务描述
   */
  @ApiModelProperty("任务描述")
  private String desc;


  /**
   * 父任务
   */
  @ApiModelProperty("父任务")
  private Integer pid;


  /**
   * 任务类型
   */
  @ApiModelProperty("任务类型")
  private Integer type;


  /**
   * 外部链接
   */
  @ApiModelProperty("外部链接")
  private String link;


  /**
   * 实际开始时间
   */
  @ApiModelProperty("实际开始时间")
  private LocalDateTime startTime;


  /**
   * 实际结束时间
   */
  @ApiModelProperty("实际结束时间")
  private LocalDateTime endTime;


  /**
   * 期望开始时间
   */
  @ApiModelProperty("期望开始时间")
  private LocalDateTime expectedStartTime;


  /**
   * 期望结束时间
   */
  @ApiModelProperty("期望结束时间")
  private LocalDateTime expectedEndTime;


  /**
   * 消耗时间（小时）
   */
  @ApiModelProperty("消耗时间（小时）")
  private BigDecimal tims;


  /**
   * 是否完成
   */
  @ApiModelProperty("是否完成")
  private Integer compile;

}

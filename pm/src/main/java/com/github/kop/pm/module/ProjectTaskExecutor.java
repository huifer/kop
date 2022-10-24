package com.github.kop.pm.module;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

/**
 * 任务执行人
 */
@Accessors(chain = true)
@ApiModel("任务执行人")
@Data
@Entity
@Table(name = "project_task_executor")
@org.hibernate.annotations.Table(appliesTo = "project_task_executor", comment = "任务执行人")
@FieldNameConstants
public class ProjectTaskExecutor implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  /**
   * 项目任务
   */
  @ApiModelProperty("项目任务")
  @Column(name = "project_task_id")
  private Integer projectTaskId;

  /**
   * 执行人
   */
  @ApiModelProperty("执行人")
  @Column(name = "user_id")
  private Integer userId;

  /**
   * 项目id
   */
  @ApiModelProperty("项目id")
  @Column(name = "project_id")
  private Integer projectId;

  /**
   * 版本id
   */
  @ApiModelProperty("版本id")
  @Column(name = "project_edition_id")
  private Integer projectEditionId;

}

package com.github.kop.pm.module;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * 项目任务执行历史
 */
@Data
@Entity
@Table(name = "project_task_history")
public class ProjectTaskHistory implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  /**
   * 任务id
   */
  @Column(name = "project_task_id")
  private Integer projectTaskId;

  /**
   * 开始时间
   */
  @Column(name = "start_time")
  private LocalDateTime startTime;

  /**
   * 结束时间
   */
  @Column(name = "end_time")
  private LocalDateTime endTime;

  /**
   * 用户id
   */
  @Column(name = "user_id")
  private Integer userId;

  /**
   * 备注
   */
  @Column(name = "note")
  private String note;

}

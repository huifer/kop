package com.github.kop.pm.module;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * 任务执行人
 */
@Data
@Entity
@Table(name = "project_task_executor")
public class ProjectTaskExecutor implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  /**
   * 项目任务
   */
  @Column(name = "project_task_id")
  private Integer projectTaskId;

  /**
   * 执行人
   */
  @Column(name = "user_id")
  private Integer userId;

}

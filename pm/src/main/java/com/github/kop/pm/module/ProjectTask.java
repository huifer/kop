package com.github.kop.pm.module;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * 项目任务
 */
@Data
@Entity
@Table(name = "project_task")
public class ProjectTask implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  /**
   * 项目id
   */
  @Column(name = "project_id")
  private Integer projectId;

  /**
   * 版本id
   */
  @Column(name = "project_edition_id")
  private Integer projectEditionId;

  /**
   * 任务名称
   */
  @Column(name = "name")
  private String name;

  /**
   * 任务描述
   */
  @Column(name = "desc")
  private String desc;

  /**
   * 父任务
   */
  @Column(name = "pid")
  private Integer pid;

  /**
   * 任务类型
   */
  @Column(name = "type")
  private Integer type;

  /**
   * 外部链接
   */
  @Column(name = "link")
  private String link;

  /**
   * 实际开始时间
   */
  @Column(name = "start_time")
  private LocalDateTime startTime;

  /**
   * 实际结束时间
   */
  @Column(name = "end_time")
  private LocalDateTime endTime;

  /**
   * 期望开始时间
   */
  @Column(name = "expected_start_time")
  private LocalDateTime expectedStartTime;

  /**
   * 期望结束时间
   */
  @Column(name = "expected_end_time")
  private LocalDateTime expectedEndTime;

  /**
   * 消耗时间（小时）
   */
  @Column(name = "tims")
  private BigDecimal tims;

  /**
   * 是否完成
   */
  @Column(name = "compile")
  private Integer compile;

}

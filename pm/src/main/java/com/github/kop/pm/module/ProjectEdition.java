package com.github.kop.pm.module;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * 项目版本
 */
@Data
@Entity
@Table(name = "project_edition")
public class ProjectEdition implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  /**
   * 版本
   */
  @Column(name = "edition")
  private String edition;

  /**
   * 开始时间
   */
  @Column(name = "start_time")
  private LocalDate startTime;

  /**
   * 结束时间
   */
  @Column(name = "end_time")
  private LocalDate endTime;

}

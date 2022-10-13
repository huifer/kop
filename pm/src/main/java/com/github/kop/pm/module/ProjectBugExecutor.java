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
 * 项目bug处理人
 */
@Data
@Entity
@Table(name = "project_bug_executor")
public class ProjectBugExecutor implements Serializable {

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
   * 项目bug_id
   */
  @Column(name = "project_bug_id")
  private Integer projectBugId;

  /**
   * 用户
   */
  @Column(name = "user_id")
  private Integer userId;

}

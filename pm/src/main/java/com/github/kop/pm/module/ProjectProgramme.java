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
 * 工程
 */
@Data
@Entity
@Table(name = "project_programme")
public class ProjectProgramme implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  /**
   * 工程名称
   */
  @Column(name = "name")
  private String name;

  /**
   * 工程仓库
   */
  @Column(name = "git_url")
  private String gitUrl;

  /**
   * 项目id
   */
  @Column(name = "project_id")
  private Integer projectId;

}

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
 * 项目bug
 */
@Data
@Entity
@Table(name = "project_bug")
public class ProjectBug implements Serializable {

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
   * bug名称
   */
  @Column(name = "name")
  private String name;

  /**
   * bug描述
   */
  @Column(name = "desc")
  private String desc;

  /**
   * 功能id
   */
  @Column(name = "project_feature_id")
  private Integer projectFeatureId;

}

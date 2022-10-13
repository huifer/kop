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
 * 项目功能参与人
 */
@Data
@Entity
@Table(name = "project_feature_user")
public class ProjectFeatureUser implements Serializable {

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
   * 功能id
   */
  @Column(name = "project_feature_id")
  private Integer projectFeatureId;

  /**
   * 用户id
   */
  @Column(name = "user_id")
  private Integer userId;

}

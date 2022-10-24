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
 * 项目bug
 */
@Accessors(chain = true)
@ApiModel("项目bug")
@Data
@Entity
@Table(name = "project_bug")
@org.hibernate.annotations.Table(appliesTo = "project_bug", comment = "项目bug")
@FieldNameConstants
public class ProjectBug implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

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

  /**
   * bug名称
   */
  @ApiModelProperty("bug名称")
  @Column(name = "name")
  private String name;

  /**
   * bug描述
   */
  @ApiModelProperty("bug描述")
  @Column(name = "desc")
  private String desc;

  /**
   * 功能id
   */
  @ApiModelProperty("功能id")
  @Column(name = "project_feature_id")
  private Integer projectFeatureId;

}

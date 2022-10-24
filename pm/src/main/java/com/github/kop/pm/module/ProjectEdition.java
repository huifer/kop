package com.github.kop.pm.module;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

/** 项目版本 */
@Accessors(chain = true)
@ApiModel("项目版本")
@Data
@Entity
@Table(name = "project_edition")
@org.hibernate.annotations.Table(appliesTo = "project_edition", comment = "项目版本")
@FieldNameConstants
public class ProjectEdition implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  /** 版本 */
  @ApiModelProperty("版本")
  @Column(name = "edition")
  private String edition;
  /** 项目id */
  @ApiModelProperty("项目id")
  @Column(name = "project_id")
  private Integer projectId;

  /** 开始时间 */
  @ApiModelProperty("开始时间")
  @Column(name = "start_time")
  private LocalDate startTime;

  /** 结束时间 */
  @ApiModelProperty("结束时间")
  @Column(name = "end_time")
  private LocalDate endTime;
}

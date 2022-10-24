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

/** 项目文件 */
@Accessors(chain = true)
@ApiModel("项目文件")
@Data
@Entity
@Table(name = "project_file")
@org.hibernate.annotations.Table(appliesTo = "project_file", comment = "项目文件")
@FieldNameConstants
public class ProjectFile implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  /** 文件名称 */
  @ApiModelProperty("文件名称")
  @Column(name = "name")
  private String name;

  /** 文件地址 */
  @ApiModelProperty("文件地址")
  @Column(name = "path")
  private String path;

  /** 文件描述 */
  @ApiModelProperty("文件描述")
  @Column(name = "`desc`")
  private String desc;

  /** 项目id */
  @ApiModelProperty("项目id")
  @Column(name = "project_id")
  private Integer projectId;
}

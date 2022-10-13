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
 * 项目文件
 */
@Data
@Entity
@Table(name = "project_file")
public class ProjectFile implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  /**
   * 文件名称
   */
  @Column(name = "name")
  private String name;

  /**
   * 文件地址
   */
  @Column(name = "path")
  private String path;

  /**
   * 文件描述
   */
  @Column(name = "desc")
  private String desc;

  /**
   * 项目id
   */
  @Column(name = "project_id")
  private Integer projectId;

}

package com.github.kop.pm.module;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

/**
 * 项目
 */
@Data
@Entity
@Table(name = "project")
@org.hibernate.annotations.Table(appliesTo = "project", comment = "项目")
@FieldNameConstants
public class Project implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 主键
   */
  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  /**
   * 项目名称
   */
  @Column(name = "name")
  private String name;

}

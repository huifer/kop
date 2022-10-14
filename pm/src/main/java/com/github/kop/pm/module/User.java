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
 * 用户表
 */
@Data
@Entity
@Table(name = "user")
@FieldNameConstants
@org.hibernate.annotations.Table(appliesTo = "user", comment = "用户表")
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  /**
   * 用户名
   */
  @Column(name = "username")
  private String username;

  /**
   * 密码
   */
  @Column(name = "password")
  private String password;

}

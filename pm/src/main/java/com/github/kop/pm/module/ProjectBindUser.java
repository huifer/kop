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
 * 项目和人
 */
@Accessors(chain = true)
@ApiModel("项目和人")
@Data
@Entity
@Table(name = "project_bind_user")

@org.hibernate.annotations.Table(appliesTo = "project_bind_user", comment = "项目和人")
@FieldNameConstants
public class ProjectBindUser implements Serializable {

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
   * 人员id
   */
  @ApiModelProperty("人员id")
  @Column(name = "user_id")
  private Integer userId;

}

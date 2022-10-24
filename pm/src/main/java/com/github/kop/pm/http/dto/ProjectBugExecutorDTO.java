package com.github.kop.pm.http.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
@ApiModel("项目bug处理人")
public class ProjectBugExecutorDTO implements Serializable {

  private static final long serialVersionUID = 1L;
  private Integer id;


  /**
   * 项目id
   */
  @ApiModelProperty("项目id")
  private Integer projectId;


  /**
   * 版本id
   */
  @ApiModelProperty("版本id")
  private Integer projectEditionId;


  /**
   * 项目bug_id
   */
  @ApiModelProperty("项目bug_id")
  private Integer projectBugId;


  /**
   * 用户
   */
  @ApiModelProperty("用户")
  private Integer userId;

}

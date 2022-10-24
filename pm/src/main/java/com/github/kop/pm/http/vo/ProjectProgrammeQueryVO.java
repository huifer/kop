package com.github.kop.pm.http.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
@ApiModel("自定义查询 工程")
public class ProjectProgrammeQueryVO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;

  /** 工程名称 */
  @ApiModelProperty("工程名称")
  private String name;

  /** 工程仓库 */
  @ApiModelProperty("工程仓库")
  private String gitUrl;

  /** 项目id */
  @ApiModelProperty("项目id")
  private Integer projectId;
}

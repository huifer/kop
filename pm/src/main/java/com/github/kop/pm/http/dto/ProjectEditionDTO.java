package com.github.kop.pm.http.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

@Data
@ApiModel("项目版本")
public class ProjectEditionDTO implements Serializable {

  private static final long serialVersionUID = 1L;
  private Integer id;

  /** 版本 */
  @ApiModelProperty("版本")
  private String edition;

  /** 开始时间 */
  @ApiModelProperty("开始时间")
  private LocalDate startTime;

  /** 结束时间 */
  @ApiModelProperty("结束时间")
  private LocalDate endTime;
}

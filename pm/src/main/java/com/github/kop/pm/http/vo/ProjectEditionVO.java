package com.github.kop.pm.http.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import lombok.Data;


@Data
@ApiModel("保存 项目版本")
public class ProjectEditionVO implements Serializable {

  private static final long serialVersionUID = 1L;

  @javax.validation.constraints.NotNull(message = "id can not null")
  @NotNull(message = "id can not null")
  private Integer id;


  /**
   * 版本
   */
  @ApiModelProperty("版本")
  private String edition;

  @ApiModelProperty("项目id")
  private Integer projectId;


  /**
   * 开始时间
   */
  @ApiModelProperty("开始时间")
  private LocalDate startTime;


  /**
   * 结束时间
   */
  @ApiModelProperty("结束时间")
  private LocalDate endTime;

}

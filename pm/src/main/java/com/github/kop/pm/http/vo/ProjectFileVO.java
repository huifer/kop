package com.github.kop.pm.http.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.Data;


@Data
@ApiModel("保存 项目文件")
public class ProjectFileVO implements Serializable {

  private static final long serialVersionUID = 1L;

  @javax.validation.constraints.NotNull(message = "id can not null")
  @NotNull(message = "id can not null")
  private Integer id;


  /**
   * 文件名称
   */
  @ApiModelProperty("文件名称")
  private String name;


  /**
   * 文件地址
   */
  @ApiModelProperty("文件地址")
  private String path;


  /**
   * 文件描述
   */
  @ApiModelProperty("文件描述")
  private String desc;


  /**
   * 项目id
   */
  @ApiModelProperty("项目id")
  private Integer projectId;

}

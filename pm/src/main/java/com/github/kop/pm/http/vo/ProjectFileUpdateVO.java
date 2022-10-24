package com.github.kop.pm.http.vo;


import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@ApiModel("更新 项目文件")
@EqualsAndHashCode(callSuper = false)
public class ProjectFileUpdateVO extends ProjectFileVO implements Serializable {

  private static final long serialVersionUID = 1L;

}

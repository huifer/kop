package com.github.kop.pm.http.vo;


import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@ApiModel("更新 项目功能参与人")
@EqualsAndHashCode(callSuper = false)
public class ProjectFeatureUserUpdateVO extends ProjectFeatureUserVO implements Serializable {

  private static final long serialVersionUID = 1L;

}

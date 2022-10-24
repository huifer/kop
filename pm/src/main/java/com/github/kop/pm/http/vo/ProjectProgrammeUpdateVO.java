package com.github.kop.pm.http.vo;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@ApiModel("更新 工程")
@EqualsAndHashCode(callSuper = false)
public class ProjectProgrammeUpdateVO extends ProjectProgrammeVO implements Serializable {

  private static final long serialVersionUID = 1L;
}

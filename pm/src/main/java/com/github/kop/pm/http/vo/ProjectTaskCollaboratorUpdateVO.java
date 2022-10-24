package com.github.kop.pm.http.vo;


import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@ApiModel("更新 任务协作人")
@EqualsAndHashCode(callSuper = false)
public class ProjectTaskCollaboratorUpdateVO extends ProjectTaskCollaboratorVO implements
    Serializable {

  private static final long serialVersionUID = 1L;

}

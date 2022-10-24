package com.github.kop.pm.http.vo;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@ApiModel("更新 项目任务执行历史")
@EqualsAndHashCode(callSuper = false)
public class ProjectTaskHistoryUpdateVO extends ProjectTaskHistoryVO implements Serializable {

  private static final long serialVersionUID = 1L;
}

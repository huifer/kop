package com.github.kop.pm.http.vo;


import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@ApiModel("更新 用户表")
@EqualsAndHashCode(callSuper = false)
public class UserUpdateVO extends UserVO implements Serializable {

  private static final long serialVersionUID = 1L;

}

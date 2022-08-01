package com.github.kop.rbac.utils;

import com.github.kop.rbac.module.enums.AppHttpCodeEnum;
import com.github.kop.rbac.module.ex.ValidateException;

public interface UpdateValidate<U> extends Validate {

  default void idValidate(Long id) throws ValidateException {
    if (id == null) {
      throw new ValidateException(AppHttpCodeEnum.UPDATE_ID_ERROR);
    }
  }

  void updateValidate(U u) throws ValidateException;
}

package com.github.kop.bbs.utils;

import com.github.kop.bbs.module.AppHttpCodeEnum;
import com.github.kop.bbs.module.ex.ValidateException;

public interface UpdateValidate<U> extends Validate {

  default void idValidate(Long id) throws ValidateException {
    if (id == null) {
      throw new ValidateException(AppHttpCodeEnum.UPDATE_ID_ERROR);
    }
  }

  void updateValidate(U u) throws ValidateException;
}

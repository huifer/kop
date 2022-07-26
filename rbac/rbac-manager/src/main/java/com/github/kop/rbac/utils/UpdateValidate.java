package com.github.kop.rbac.utils;

import com.github.kop.rbac.module.ex.ValidateException;

public interface UpdateValidate<U> extends Validate {
  void updateValidate(U u) throws ValidateException;
}

package com.github.kop.rbac.utils;

import com.github.kop.rbac.module.ex.ValidateException;

public interface CreateValidate<C> extends Validate {
  void createValidate(C c) throws ValidateException;
}

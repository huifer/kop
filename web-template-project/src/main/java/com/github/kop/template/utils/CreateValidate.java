package com.github.kop.template.utils;

import com.github.kop.template.module.ex.ValidateException;

public interface CreateValidate<C> extends Validate {
  void createValidate(C c) throws ValidateException;
}

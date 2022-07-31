package com.github.kop.blob.utils;

import com.github.kop.blob.module.ex.ValidateException;

public interface CreateValidate<C> extends Validate {
  void createValidate(C c) throws ValidateException;
}

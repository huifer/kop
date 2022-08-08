package com.github.kop.bbs.utils;


import com.github.kop.bbs.module.ex.ValidateException;

public interface CreateValidate<C> extends Validate {
  void createValidate(C c) throws ValidateException;
}

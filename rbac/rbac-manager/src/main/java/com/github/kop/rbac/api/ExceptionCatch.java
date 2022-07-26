package com.github.kop.rbac.api;

import com.github.kop.rbac.module.NoceException;
import com.github.kop.rbac.module.res.RespVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
@RestController
public class ExceptionCatch {

  public static final String ERROR_MSG = "error_msg";

  @ExceptionHandler(Exception.class)
  public RespVO<String> exception(Exception e) {
    log.error(e.getMessage());
    e.printStackTrace();
    return RespVO.error(e.getMessage());
  }

  @ExceptionHandler(NoceException.class)
  public RespVO<String> leadExceptionHandler(NoceException nsException) {
    nsException.printStackTrace();
    return RespVO.error(nsException.getCode(), nsException.getMessage());
  }
}

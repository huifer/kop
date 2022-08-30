package com.example.entertainment.config;

import com.example.entertainment.module.RespVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerController {


  @ExceptionHandler(Exception.class)
  public RespVO<String> handleException(Exception e) {
    log.error("系统发生错误", e);
    return RespVO.error(e.getMessage());
  }

}

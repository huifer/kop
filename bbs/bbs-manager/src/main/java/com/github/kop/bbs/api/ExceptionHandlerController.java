package com.github.kop.bbs.api;

import com.github.kop.bbs.module.ex.NoceException;
import com.github.kop.bbs.module.ex.ValidateException;
import com.github.kop.bbs.module.res.RespVO;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/9 23:45
 */
@RestControllerAdvice
@Slf4j
public class ExceptionHandlerController {

  @ExceptionHandler(Exception.class)
  public RespVO<String> handleException(Exception e) {
    log.error("系统发生错误-------{}", e);
    return RespVO.error("系统错误,请稍后重试");
  }

  @ExceptionHandler(NoceException.class)
  public RespVO<String> handleNoceException(NoceException e) {
    return RespVO.error(e.getMsg());
  }

  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  public RespVO<String> handleHttpRequestMethodNotSupportedException(
      HttpRequestMethodNotSupportedException e) {
    return RespVO.error("页面不存在");
  }

  @ExceptionHandler(ValidateException.class)
  public RespVO<String> handleValidateException(ValidateException e) {
    log.error("参数异常{}", e);
    return RespVO.error("参数异常:" + e.getMsg());
  }

  @ExceptionHandler(ExpiredJwtException.class)
  public RespVO<String> handleValidateException(ExpiredJwtException e) {
    return RespVO.error("请重新登录!");
  }
}

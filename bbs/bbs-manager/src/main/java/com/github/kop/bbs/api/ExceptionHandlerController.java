package com.github.kop.bbs.api;

import com.github.kop.bbs.module.ex.NoceException;
import com.github.kop.bbs.module.res.RespVO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/9 23:45
 */
@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(NoceException.class)
    public RespVO<String> handleMethodArgumentNotValidException(NoceException e) {
        return RespVO.error(e.getMsg());
    }

}

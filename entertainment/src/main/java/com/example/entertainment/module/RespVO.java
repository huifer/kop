package com.example.entertainment.module;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(value = "统一返回对象", description = "统一返回对象")
@Data
public class RespVO<T> {

  private int code;
  private String message;
  private T data;

  public static <T> RespVO<T> error() {
    RespVO<T> tRespVO = new RespVO<>();
    tRespVO.setCode(4001);
    tRespVO.setMessage("处理异常");
    return tRespVO;
  }


  public static <T> RespVO<T> error(String msg) {
    RespVO<T> tRespVO = new RespVO<>();
    tRespVO.setCode(4001);
    tRespVO.setMessage(msg);
    return tRespVO;
  }

  public static <T> RespVO<T> error(Integer code, String msg) {
    RespVO<T> tRespVO = new RespVO<>();
    tRespVO.setCode(code);
    tRespVO.setMessage(msg);
    return tRespVO;
  }

  public static <T> RespVO<T> success() {
    RespVO<T> tRespVO = new RespVO<>();
    tRespVO.setCode(20000);
    tRespVO.setMessage("处理成功");
    return tRespVO;
  }

  public static <T> RespVO<T> success(T data) {
    RespVO<T> tRespVO = new RespVO<>();
    tRespVO.setCode(20000);
    tRespVO.setMessage("处理成功");
    tRespVO.setData(data);
    return tRespVO;
  }
}

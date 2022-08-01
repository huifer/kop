package com.github.kop.template.module.res;

import com.github.kop.template.module.enums.AppHttpCodeEnum;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(value = "统一返回对象", description = "统一返回对象")
@Data
public class RespVO<T> {
  private int code;
  private String msg;
  private T data;

  public static <T> RespVO<T> error() {
    RespVO<T> tRespVO = new RespVO<>();
    tRespVO.setCode(4001);
    tRespVO.setMsg("处理异常");
    return tRespVO;
  }

  public static <T> RespVO<T> error(AppHttpCodeEnum appHttpCodeEnum) {
    return error(appHttpCodeEnum.getMsg());
  }

  public static <T> RespVO<T> error(String msg) {
    RespVO<T> tRespVO = new RespVO<>();
    tRespVO.setCode(4001);
    tRespVO.setMsg(msg);
    return tRespVO;
  }

  public static <T> RespVO<T> error(Integer code, String msg) {
    RespVO<T> tRespVO = new RespVO<>();
    tRespVO.setCode(code);
    tRespVO.setMsg(msg);
    return tRespVO;
  }

  public static <T> RespVO<T> success() {
    RespVO<T> tRespVO = new RespVO<>();
    tRespVO.setCode(2001);
    tRespVO.setMsg("处理成功");
    return tRespVO;
  }

  public static <T> RespVO<T> success(T data) {
    RespVO<T> tRespVO = new RespVO<>();
    tRespVO.setCode(2001);
    tRespVO.setMsg("处理成功");
    tRespVO.setData(data);
    return tRespVO;
  }
}

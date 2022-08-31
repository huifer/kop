package com.example.entertainment.ctr.manager;

import com.example.entertainment.module.RespVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("管理端-订单接口")
@RestController
@RequestMapping("/manager/order")
public class ManagerOrderCtr {

  @ApiOperation("订单列表")
  @GetMapping("/page")
  public RespVO<Boolean> page() {
    return null;
  }
}

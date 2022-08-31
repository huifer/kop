package com.example.entertainment.ctr.customer;

import com.example.entertainment.module.RespVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("消费者端-订单接口")
@RestController
@RequestMapping("/customer/order")
public class CustomerOrderCtr {


  @ApiOperation("创建订单")
  @PostMapping("/create")
  public RespVO<Boolean> create() {
    return null;
  }
  @ApiOperation("取消订单")
  @PostMapping("/cancel")
  public RespVO<Boolean> cancel() {
    return null;
  }
  @ApiOperation("订单列表")
  @PostMapping("/page")
  public RespVO<Boolean> page() {
    return null;
  }

  @ApiOperation("订单支付")
  @PostMapping("/pay")
  public RespVO<Boolean> pay() {
    return null;
  }

}

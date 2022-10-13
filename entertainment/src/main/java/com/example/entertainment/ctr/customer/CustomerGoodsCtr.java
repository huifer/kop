package com.example.entertainment.ctr.customer;

import com.example.entertainment.module.RespVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("消费者端-商品接口")
@RestController
@RequestMapping("/customer/goods")
public class CustomerGoodsCtr {

  @ApiOperation("查看商品信息")
  @GetMapping("/info/{id}")
  public RespVO info(
      @PathVariable("id") Long id
  ) {

    return null;
  }

  @ApiOperation("出售商品")
  @PostMapping("/sell")
  public RespVO<Boolean> sell() {
    return null;
  }

  @ApiOperation("转赠商品")
  @PostMapping("/transfer")
  public RespVO transfer() {
    return null;
  }

  @PostMapping("/goumai")
  @ApiOperation("购买")
  public RespVO goumai() {
    return null;
  }
}

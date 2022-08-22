package com.github.kop.bbs.api.customer;

import com.github.kop.bbs.module.res.RespVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "消费者-论坛申诉")
@RestController
@RequestMapping("customer/appeal")
public class CustomerAppealController {


  @ApiOperation(value = "发起申诉")
  @PostMapping("/")
  public RespVO<Boolean> appeal(){

  }



}

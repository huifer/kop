package com.example.entertainment.ctr.customer;

import com.example.entertainment.module.RespVO;
import com.example.entertainment.module.customer.req.user.CustomerLoginUserReq;
import com.example.entertainment.module.customer.req.user.CustomerRegisterUserReq;
import com.example.entertainment.module.customer.req.user.CustomerUpdateUserReq;
import com.example.entertainment.module.customer.req.user.CustomerUserVerifiedReq;
import com.example.entertainment.module.customer.resp.user.CustomerUserInfoResp;
import com.example.entertainment.service.customer.CustomerUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("消费者端-用户接口")
@RestController
@RequestMapping("/customer/user")
public class CustomerUserCtr {

  @Autowired
  private CustomerUserService customerUserService;

  @ApiOperation("注册")
  @PostMapping("/register")
  public RespVO<Boolean> register(
      @RequestBody CustomerRegisterUserReq req
  ) {
    return RespVO.success(customerUserService.register(req));
  }

  @ApiOperation("登陆")
  public RespVO<CustomerUserInfoResp> login(
      @RequestBody CustomerLoginUserReq req
  ) {
    return RespVO.success(customerUserService.login(req));
  }

  @ApiOperation("个人信息")
  public RespVO<CustomerUserInfoResp> userInfo(
      @RequestHeader("x-token") String token
  ) {
    return RespVO.success(customerUserService.userInfo(token));

  }

  @ApiOperation("修改个人信息")
  public RespVO<Boolean> update(
      @RequestHeader("x-token") String token,
      @RequestBody CustomerUpdateUserReq req) {
    return RespVO.success(this.customerUserService.update(token ,req));
  }

  @ApiOperation("实名认证")
  public RespVO<Boolean> author(
      @RequestBody CustomerUserVerifiedReq req

  ) {
    return RespVO.success(this.customerUserService.author(req));
  }
}

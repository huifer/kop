package com.example.entertainment.ctr.customer;

import com.example.entertainment.module.customer.req.user.CustomerLoginUserReq;
import com.example.entertainment.module.customer.req.user.CustomerRegisterUserReq;
import com.example.entertainment.module.customer.req.user.CustomerUpdateUserReq;
import com.example.entertainment.module.customer.req.user.CustomerUserVerifiedReq;
import com.example.entertainment.module.customer.resp.user.CustomerUserInfoResp;
import com.example.entertainment.service.customer.CustomerUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<Boolean> register(
      @RequestBody CustomerRegisterUserReq req
  ) {
    return ResponseEntity.ok(customerUserService.register(req));
  }

  @ApiOperation("登陆")
  public ResponseEntity<CustomerUserInfoResp> login(
      @RequestBody CustomerLoginUserReq req
  ) {
    return ResponseEntity.ok(customerUserService.login(req));
  }

  @ApiOperation("个人信息")
  public ResponseEntity<CustomerUserInfoResp> userInfo(
      @RequestHeader("x-token") String token
  ) {
    return ResponseEntity.ok(customerUserService.userInfo(token));

  }

  @ApiOperation("修改个人信息")
  public ResponseEntity<Boolean> update(
      @RequestHeader("x-token") String token,
      @RequestBody CustomerUpdateUserReq req) {
    return ResponseEntity.ok(this.customerUserService.update(token ,req));
  }

  @ApiOperation("实名认证")
  public ResponseEntity<Boolean> author(
      @RequestBody CustomerUserVerifiedReq req

  ) {
    return ResponseEntity.ok(this.customerUserService.author(req));
  }
}

package com.github.kop.bbs.api.customer;

import com.github.kop.bbs.module.req.user.CreateUserReq;
import com.github.kop.bbs.module.req.user.LoginUserReq;
import com.github.kop.bbs.module.res.RespVO;
import com.github.kop.bbs.module.res.user.UserLoginRes;
import com.github.kop.bbs.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Api(tags = "消费者-用户接口")
@RestController()
@RequestMapping("customer/user")
public class CustomerUserController {
  @Resource
  private UserService userService;
  @ApiOperation(value = "用户注册")
  @PostMapping("/")
  public RespVO<Boolean> register(
      @RequestBody CreateUserReq req
  ) {
    return RespVO.success(this.userService.create(req));
  }

  @ApiOperation(value = "用户登录")
  @PostMapping("/login")
  public RespVO<UserLoginRes> login(
      @RequestBody LoginUserReq req
  ) {
    return RespVO.success(this.userService.login(req));
  }
}

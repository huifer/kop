package com.github.kop.bbs.api.open;

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

/**
 * @auth ahxiaoqi
 * @desc 开放控制器
 * @time 2022/8/14 17:42
 */
@Api(tags = "无token限制接口")
@RestController
@RequestMapping("/open")
public class OpenController {

  @Resource private UserService userService;

  @ApiOperation(value = "用户注册")
  @PostMapping("/user/create")
  public RespVO<Boolean> create(@RequestBody CreateUserReq req) {
    return RespVO.success(userService.createCustomerUser(req));
  }

  @ApiOperation(value = "用户登录")
  @PostMapping("/user/login")
  public RespVO<UserLoginRes> byId(@RequestBody LoginUserReq req) {
    return RespVO.success(userService.login(req));
  }
}

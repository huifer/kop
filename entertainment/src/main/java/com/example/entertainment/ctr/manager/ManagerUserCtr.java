package com.example.entertainment.ctr.manager;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.entertainment.module.RespVO;
import com.example.entertainment.module.entity.Users;
import com.example.entertainment.module.manager.req.user.ManagerUserQueryReq;
import com.example.entertainment.module.manager.resp.user.ManagerUserInfoResp;
import com.example.entertainment.module.manager.resp.user.ManagerUserResp;
import com.example.entertainment.service.manager.ManagerUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("管理端-用户接口")
@RestController
@RequestMapping("/manager/user")
public class ManagerUserCtr {

  @Autowired
  private ManagerUserService managerUserService;

  @ApiOperation("登陆")
  @PostMapping("/login")
  public RespVO<ManagerUserInfoResp> login(@RequestBody Users users) {
    ManagerUserInfoResp userInfoResp = this.managerUserService.login(users);
    return RespVO.success(userInfoResp);
  }

  @ApiOperation("创建用户")
  @PostMapping("/create")
  public RespVO<Boolean> create(@RequestBody Users users) {
    return RespVO.success(managerUserService.create(users));
  }

  @ApiOperation("修改用户")
  @PostMapping("/update")
  public RespVO<Boolean> update(@RequestBody Users users) {
    return RespVO.success(managerUserService.update(users));

  }

  @GetMapping("/byId")
  @ApiOperation("查看用户信息")
  public RespVO<ManagerUserResp> byId(int userId) {
    return RespVO.success(managerUserService.byId(userId));

  }

  @ApiOperation("查询")
  @GetMapping("/page/{page}/{size}")
  public RespVO<IPage<ManagerUserResp>> query(
      @PathVariable("page") int page,
      @PathVariable("size") int size,

      ManagerUserQueryReq req
  ) {
    return RespVO.success(managerUserService.query(page, size, req));

  }
}

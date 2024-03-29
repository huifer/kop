package com.github.kop.rbac.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.rbac.module.req.user.CreateUserReq;
import com.github.kop.rbac.module.req.user.QueryUserReq;
import com.github.kop.rbac.module.req.user.UpdateUserReq;
import com.github.kop.rbac.module.res.RespVO;
import com.github.kop.rbac.module.res.user.UserQueryRes;
import com.github.kop.rbac.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "用户接口")
@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired private UserService userService;

  @ApiOperation(value = "创建用户")
  @PostMapping("/")
  public RespVO<Boolean> create(@RequestBody CreateUserReq req) {
    return RespVO.success(userService.create(req) > 0);
  }

  @ApiOperation(value = "修改用户")
  @PutMapping("/{id}")
  public RespVO<Boolean> update(
      @PathVariable(value = "id") Long id, @RequestBody UpdateUserReq req) {
    req.setId(id);
    return RespVO.success(userService.update(req) > 0);
  }

  @ApiOperation(value = "获取用户信息")
  @GetMapping("/{id}")
  public RespVO<UserQueryRes> byId(@PathVariable(value = "id") Long id) {
    return RespVO.success(userService.byId(id));
  }

  @ApiOperation(value = "删除用户")
  @DeleteMapping("/{id}")
  public RespVO<Boolean> deleteById(@PathVariable(value = "id") Long id) {

    return RespVO.success(userService.deleteById(id) > 0);
  }

  @ApiOperation(value = "用户查询分页信息")
  @GetMapping("/{page}/{size}")
  public RespVO<IPage<UserQueryRes>> page(
      @PathVariable(value = "page") Long page,
      @PathVariable(value = "size") Long size,
      @RequestBody QueryUserReq req) {

    return RespVO.success(userService.page(page, size, req));
  }

  @ApiOperation(value = "用户列表")
  @GetMapping("/list")
  public RespVO<List<UserQueryRes>> list(@RequestBody QueryUserReq req) {

    return RespVO.success(userService.list(req));
  }
}

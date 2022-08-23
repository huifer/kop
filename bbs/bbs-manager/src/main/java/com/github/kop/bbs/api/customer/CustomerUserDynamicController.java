package com.github.kop.bbs.api.customer;

import com.github.kop.bbs.module.req.user.UserDynamicCreateReq;
import com.github.kop.bbs.module.res.RespVO;
import com.github.kop.bbs.service.user.dynamic.UserDynamicService;
import com.github.kop.bbs.utils.UserInfoThread;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("消费者-用户动态接口")
@RestController()
@RequestMapping("customer/user/dynamic")
public class CustomerUserDynamicController {

  @Autowired
  private UserDynamicService userDynamicService;

  @PostMapping("/create")
  @ApiOperation("发布动态")
  public RespVO<Boolean> create(
      @RequestBody UserDynamicCreateReq req
  ) {
    return RespVO.success(userDynamicService.create(req));
  }


  @PostMapping("/page/{user_id}/{page}/{size}")
  @ApiOperation("动态列表")
  public RespVO<Boolean> page(
      @PathVariable("user_id") Long userId,
      @PathVariable("page") Long page,
      @PathVariable("size") Long size
  ) {
    return RespVO.success(userDynamicService.page(userId, page, size));
  }

  @DeleteMapping("/{id}")
  @ApiOperation("删除一条动态")
  public RespVO<Boolean> page(
      @PathVariable("id") Long id
  ) {

    return RespVO.success(userDynamicService.page(UserInfoThread.getUserId(), id));
  }

}

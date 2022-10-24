package com.github.kop.bbs.api.customer;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.res.RespVO;
import com.github.kop.bbs.module.res.user.UserRelationResp;
import com.github.kop.bbs.service.user.relation.UserBlackListService;
import com.github.kop.bbs.service.user.relation.UserFollowerListService;
import com.github.kop.bbs.utils.UserInfoThread;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("用户关系操作接口")
@RestController
@RequestMapping("/customer/user/operation")
public class CustomerUserOperationController {

  @Autowired private UserFollowerListService userFollowerListService;
  @Autowired private UserBlackListService userBlackListService;

  @ApiOperation("关注")
  @PostMapping("/subscribe/{user_id}")
  public RespVO<Boolean> subscribe(
      @ApiParam(name = "bisKey", value = "被操作的用户id", required = true)
          @PathVariable(value = "user_id")
          Long targetUserId) {
    return RespVO.success(
        userFollowerListService.subscribe(UserInfoThread.getUserId(), targetUserId));
  }

  @ApiOperation("关注列表")
  @GetMapping("/subscribe/list/{page}/{size}")
  public RespVO<IPage<UserRelationResp>> subscribeList(
      @PathVariable("page") Long page, @PathVariable("size") Long size) {
    return RespVO.success(userFollowerListService.page(UserInfoThread.getUserId(), page, size));
  }

  @ApiOperation("取消关注")
  @PostMapping("/un_subscribe/{user_id}")
  public RespVO<Boolean> unSubscribe(@PathVariable(value = "user_id") Long targetUserId) {
    return RespVO.success(
        userFollowerListService.unSubscribe(UserInfoThread.getUserId(), targetUserId));
  }

  @ApiOperation("拉黑")
  @PostMapping("/pull_black/{user_id}")
  public RespVO<Boolean> pullBlack(@PathVariable(value = "user_id") Long targetUserId) {
    return RespVO.success(userBlackListService.pullBlack(UserInfoThread.getUserId(), targetUserId));
  }

  @ApiOperation("拉黑列表")
  @GetMapping("/black/list/{page}/{size}")
  public RespVO<IPage<UserRelationResp>> blackList(
      @PathVariable("page") Long page, @PathVariable("size") Long size) {
    return RespVO.success(userBlackListService.page(UserInfoThread.getUserId(), page, size));
  }

  @ApiOperation("取消拉黑")
  @PostMapping("/cancel_black/{user_id}")
  public RespVO<Boolean> cancelBlock(@PathVariable(value = "user_id") Long targetUserId) {
    return RespVO.success(
        userBlackListService.cancelBlock(UserInfoThread.getUserId(), targetUserId));
  }
  // TODO: 2022/8/26 绑定第三方登陆

}

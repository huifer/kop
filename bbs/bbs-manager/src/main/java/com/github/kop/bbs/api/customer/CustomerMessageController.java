package com.github.kop.bbs.api.customer;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.req.message.MessageQueryReq;
import com.github.kop.bbs.module.req.message.UserSendMessageReq;
import com.github.kop.bbs.module.res.RespVO;
import com.github.kop.bbs.module.res.message.MessageResp;
import com.github.kop.bbs.service.message.MessageService;
import com.github.kop.bbs.utils.UserInfoThread;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("消费端-消息接口")
@RestController
@RequestMapping("/customer/message")
public class CustomerMessageController {

  @Autowired private MessageService messageService;

  /** 给人发私信 */
  @ApiOperation(value = "登陆人给指定人员发消息")
  @PostMapping("/send")
  public RespVO<Boolean> sendMessage(@RequestBody UserSendMessageReq userSendMessageReq) {
    Long userId = UserInfoThread.getUserId();
    return RespVO.success(messageService.sendPrivateMessage(userId, userSendMessageReq));
  }

  /** 一键已读 */
  @ApiOperation(value = "一键已读")
  @PostMapping("/read_all")
  public RespVO<Boolean> readAll() {
    Long userId = UserInfoThread.getUserId();
    return RespVO.success(messageService.readAll(userId));
  }

  @ApiOperation(value = "个人消息列表")
  @GetMapping("/page/{page}/{size}")
  public RespVO<IPage<MessageResp>> page(
      @PathVariable("page") Long page,
      @PathVariable("size") Long size,
      @RequestBody MessageQueryReq req) {
    Long userId = UserInfoThread.getUserId();
    return RespVO.success(messageService.page(page, size, req, userId));
  }

  @ApiOperation(value = "个人消息列表")
  @GetMapping("/page/{id}")
  public RespVO<MessageResp> byId(@PathVariable("id") Long id) {
    Long userId = UserInfoThread.getUserId();
    return RespVO.success(messageService.byId(id, userId));
  }
}

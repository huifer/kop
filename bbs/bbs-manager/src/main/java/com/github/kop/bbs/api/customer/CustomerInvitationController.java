package com.github.kop.bbs.api.customer;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.req.invitation.InvitationCommentReq;
import com.github.kop.bbs.module.req.invitation.InvitationCreateReq;
import com.github.kop.bbs.module.res.RespVO;
import com.github.kop.bbs.module.res.invitation.customer.InvitationQueryResp;
import com.github.kop.bbs.service.invitation.InvitationCommentService;
import com.github.kop.bbs.service.invitation.InvitationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("消费端-论坛帖子接口")
@RestController
@RequestMapping("/customer/invitation")
public class CustomerInvitationController {

  @Autowired private InvitationService invitationService;

  @Resource private InvitationCommentService invitationCommentService;

  @ApiOperation("发帖")
  @PostMapping("/")
  public RespVO<Boolean> create(@RequestBody InvitationCreateReq req) {
    return RespVO.success(invitationService.create(req));
  }

  @ApiOperation("帖子分页")
  @GetMapping("/page/{category_id}/{page}/{size}")
  public RespVO<IPage<InvitationQueryResp>> page(
      @PathVariable("category_id") Long categoryId,
      @PathVariable("page") Long page,
      @PathVariable("size") Long size) {
    return RespVO.success(this.invitationService.page(categoryId, page, size));
  }

  @ApiOperation("帖子评论")
  @PostMapping("/comment")
  public RespVO<Boolean> createInvitationComment(@RequestBody InvitationCommentReq req) {
    return RespVO.success(invitationCommentService.create(req));
  }
}

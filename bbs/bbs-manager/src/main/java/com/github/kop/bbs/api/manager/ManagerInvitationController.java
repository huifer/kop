package com.github.kop.bbs.api.manager;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.aop.role.RoleApi;
import com.github.kop.bbs.module.enums.role.RoleEnum;
import com.github.kop.bbs.module.req.invitation.InvitationAuditReq;
import com.github.kop.bbs.module.res.RespVO;
import com.github.kop.bbs.module.res.invitation.manager.InvitationAuditRes;
import com.github.kop.bbs.service.invitation.InvitationService;
import com.github.kop.bbs.utils.UserInfoThread;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api("管理端-帖子接口")
@RestController
@RequestMapping("/manager/invitation")
public class ManagerInvitationController {

  @Autowired private InvitationService invitationService;

  @RoleApi(roles = {RoleEnum.AUDIT})
  @ApiOperation("审核")
  @PostMapping("/audit")
  public RespVO<Boolean> audit(@RequestBody InvitationAuditReq req) {
    return RespVO.success(invitationService.audit(UserInfoThread.getUserId(), req));
  }

  @RoleApi(roles = {RoleEnum.AUDIT})
  @ApiOperation("待审核列表")
  @PostMapping("/audit/list/{page}/{pageSize}")
  public RespVO<IPage<InvitationAuditRes>> auditList(
      @PathVariable Long page, @PathVariable Long pageSize, @RequestBody Long categoryId) {
    return RespVO.success(invitationService.auditList(categoryId, page, pageSize));
  }
}

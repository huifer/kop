package com.github.kop.bbs.service.invitation;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.req.invitation.InvitationAuditReq;
import com.github.kop.bbs.module.req.invitation.InvitationCreateReq;
import com.github.kop.bbs.module.res.invitation.customer.InvitationQueryResp;
import com.github.kop.bbs.module.res.invitation.manager.InvitationAuditRes;

public interface InvitationService {

  boolean create(InvitationCreateReq req);

  IPage<InvitationQueryResp> page(Long categoryId, Long page, Long size);

  /**
   * 审核
   * @param userId 审核人
   * @param req 审核参数
   */
  boolean audit(Long userId, InvitationAuditReq req);

  /**
   * 审核帖子列表
   * @param categoryId
   * @param page
   * @param pageSize
   * @return
   */
  IPage<InvitationAuditRes> auditList(Long categoryId, Long page, Long pageSize);

    int updateAuditStatus(int auditUserCount, Integer auditThreshold, Long invitationId);
}

package com.github.kop.bbs.service.invitation;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.req.invitation.InvitationAuditReq;
import com.github.kop.bbs.module.req.invitation.InvitationCreateReq;
import com.github.kop.bbs.module.res.invitation.InvitationQueryResp;

public interface InvitationService {

  boolean create(InvitationCreateReq req);

  IPage<InvitationQueryResp> page(Long categoryId, Long page, Long size);

  /**
   * 审核
   * @param userId 审核人
   * @param req 审核参数
   */
  boolean audit(Long userId, InvitationAuditReq req);
}

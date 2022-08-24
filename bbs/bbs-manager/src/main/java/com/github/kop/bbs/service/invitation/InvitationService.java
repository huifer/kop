package com.github.kop.bbs.service.invitation;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.req.invitation.InvitationCreateReq;
import com.github.kop.bbs.module.res.invitation.InvitationQueryResp;

public interface InvitationService {

  boolean create(InvitationCreateReq req);

  IPage<InvitationQueryResp> page(Long categoryId, Long page, Long size);
}

package com.github.kop.bbs.service.invitation.impl;

import com.github.kop.bbs.module.entity.InvitationAuditLog;
import com.github.kop.bbs.repo.InvitationAuditLogRepository;
import com.github.kop.bbs.service.invitation.InvitationAuditLogService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class InvitationAuditLogServiceImpl implements InvitationAuditLogService {

  @Resource private InvitationAuditLogRepository invitationAuditLogRepository;

  @Override
  public int insert(InvitationAuditLog build) {
    return invitationAuditLogRepository.insert(build);
  }
}

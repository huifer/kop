package com.github.kop.bbs.service.invitation;

import com.github.kop.bbs.module.entity.InvitationAuditLog;
import com.baomidou.mybatisplus.extension.service.IService;
public interface InvitationAuditLogService{


    int insert(InvitationAuditLog build);
}

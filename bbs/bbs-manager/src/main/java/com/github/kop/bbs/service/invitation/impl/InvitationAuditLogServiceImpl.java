package com.github.kop.bbs.service.invitation.impl;

import com.github.kop.bbs.repo.InvitationAuditLogRepository;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.kop.bbs.module.entity.InvitationAuditLog;
import com.github.kop.bbs.repo.mapper.InvitationAuditLogMapper;
import com.github.kop.bbs.service.invitation.InvitationAuditLogService;
@Service
public class InvitationAuditLogServiceImpl  implements InvitationAuditLogService{


    @Resource
    private InvitationAuditLogRepository invitationAuditLogRepository;

    @Override
    public int insert(InvitationAuditLog build) {
        return invitationAuditLogRepository.insert(build);
    }
}

package com.github.kop.bbs.repo.impl;

import com.github.kop.bbs.module.entity.InvitationAuditLog;
import com.github.kop.bbs.repo.InvitationAuditLogRepository;
import com.github.kop.bbs.repo.mapper.InvitationAuditLogMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/9/4 22:06
 */
@Repository
public class InvitationAuditLogRepositoryImpl implements InvitationAuditLogRepository {

    @Resource
    private InvitationAuditLogMapper invitationAuditLogMapper;

    @Override
    public int insert(InvitationAuditLog build) {
        return invitationAuditLogMapper.insert(build);
    }
}

package com.github.kop.bbs.event.invitation;

import com.github.kop.bbs.config.BbsConfiguration;
import com.github.kop.bbs.module.bo.InvitationAuditEventBo;
import com.github.kop.bbs.module.entity.Invitation;
import com.github.kop.bbs.module.entity.InvitationAuditLog;
import com.github.kop.bbs.module.entity.MidUserRole;
import com.github.kop.bbs.module.enums.AuditStatusEnum;
import com.github.kop.bbs.module.enums.DeletedEnum;
import com.github.kop.bbs.module.enums.role.RoleEnum;
import com.github.kop.bbs.service.invitation.InvitationAuditLogService;
import com.github.kop.bbs.service.invitation.InvitationService;
import com.github.kop.bbs.service.user.MidUserRoleService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/9/4 22:27
 */
@Component
public class InvitationAuditListener implements ApplicationListener<InvitationAudit> {


    @Resource
    private BbsConfiguration bbsConfiguration;

    @Resource
    private InvitationService invitationService;

    @Resource
    private MidUserRoleService midUserRoleService;

    @Resource
    private InvitationAuditLogService invitationAuditLogService;



    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void onApplicationEvent(InvitationAudit event) {

        InvitationAuditEventBo invitationAuditEventBo = event.getInvitationAuditEventBo();

        // 更新帖子审核状态
        if (AuditStatusEnum.PASS.getCode().equals(invitationAuditEventBo.getAuditStatusEnum().getCode())){
            // 根据状态和id获取帖子,如果帖子已经审核通过了,就不需要执行了
            Invitation invitation = invitationService.findByIdAndAuditStatus(invitationAuditEventBo.getSid(),AuditStatusEnum.PASS.getCode());
            if(ObjectUtils.isNotEmpty(invitation)){
                return;
            }
            List<MidUserRole> auditUserList =  midUserRoleService.findByRole(RoleEnum.AUDIT.getRoleCode());
            // 当前可以审核的人员数量
            int auditUserCount = auditUserList.stream().map(MidUserRole::getUserId).collect(Collectors.toSet()).size();
            invitationService.updateAuditStatus(auditUserCount, bbsConfiguration.getAuditThreshold(),invitationAuditEventBo.getSid());
        }
        invitationAuditLogService.insert(InvitationAuditLog.builder()
                .invitationId(invitationAuditEventBo.getSid())
                .articleStatus(invitationAuditEventBo.getAuditStatusEnum().getCode())
                .auditContent(invitationAuditEventBo.getNote())
                .deleted(DeletedEnum.FALSE.getCode())
                .build());


    }
}

package com.github.kop.bbs.module.bo;

import com.github.kop.bbs.module.enums.AuditStatusEnum;
import lombok.Data;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/9/4 22:32
 */
@Data
public class InvitationAuditEventBo {

    private Long userId;

    private Long sid;

    private AuditStatusEnum auditStatusEnum;

    private String note;
}

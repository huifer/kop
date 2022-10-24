package com.github.kop.bbs.service.audit;

import com.github.kop.bbs.module.enums.AuditStatusEnum;
import com.github.kop.bbs.module.enums.AuditTypeEnum;

/**
 * 审核服务 主体
 *
 * @param <S> 主体, 根据审核类型发生变化
 */
public interface AuditService<S> {

  /**
   * 审核
   *
   * @param userId 审核人
   * @param sid 主体id
   * @param auditStatusEnum 审核结果
   * @param note 备注
   */
  boolean audit(Long userId, Long sid, AuditStatusEnum auditStatusEnum, String note);

  /** 审核类型 */
  AuditTypeEnum type();
}

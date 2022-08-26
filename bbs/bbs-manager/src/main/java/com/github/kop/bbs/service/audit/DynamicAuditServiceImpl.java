package com.github.kop.bbs.service.audit;

import com.github.kop.bbs.module.entity.UserDynamic;
import com.github.kop.bbs.module.enums.AuditStatusEnum;
import com.github.kop.bbs.module.enums.AuditTypeEnum;
import org.springframework.stereotype.Service;

/**
 * 动态审核服务
 *
 * @param <S> UserDynamic
 */
@Service
public class DynamicAuditServiceImpl<S> implements AuditService<UserDynamic> {

  @Override
  public boolean audit(Long userId, Long sid, AuditStatusEnum auditStatusEnum, String note) {
    return false;
  }

  @Override
  public AuditTypeEnum type() {
    return AuditTypeEnum.DYNAMIC;
  }
}

package com.github.kop.bbs.service.audit;

import com.github.kop.bbs.module.enums.AuditTypeEnum;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AuditServiceFactory implements InitializingBean {

  private final ApplicationContext context;
  Map<AuditTypeEnum, AuditService<?>> auditServiceMap = new HashMap<>();

  public AuditServiceFactory(ApplicationContext context) {
    this.context = context;
  }

  /** 根据审核类型获取审核服务 */
  public AuditService<?> factory(AuditTypeEnum auditTypeEnum) {
    return auditServiceMap.get(auditTypeEnum);
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    // 审核服务
    Map<String, AuditService> beansOfType = context.getBeansOfType(AuditService.class);
    beansOfType.forEach(
        (k, v) -> {
          auditServiceMap.put(v.type(), v);
        });
  }
}

package com.github.kop.bbs.repo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.entity.Invitation;

public interface InvitationRepository {

  IPage<Invitation> page(Long categoryId, Long articleStatus,Long page, Long size);

  int  create(Invitation invitation);

  /**
   * 计算审核状态
   * @param auditUserCount
   * @param auditThreshold
   * @param invitationId
   * @return
   */
    int updateAuditStatus( int auditUserCount, Integer auditThreshold, Long invitationId);
}

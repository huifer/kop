package com.github.kop.bbs.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.kop.bbs.module.entity.Invitation;
import com.github.kop.bbs.repo.InvitationRepository;
import com.github.kop.bbs.repo.mapper.InvitationMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class InvitationRepositoryImpl implements InvitationRepository {

  @Autowired
  private InvitationMapper invitationMapper;

  @Override
  public IPage<Invitation> page(Long categoryId,Long articleStatus ,Long page, Long size) {
    QueryWrapper<Invitation> queryWrapper = new QueryWrapper<>();
    LambdaQueryWrapper<Invitation> eq = queryWrapper.lambda()
            .eq(Invitation::getCategoryId, categoryId);
    if (ObjectUtils.isNotEmpty(articleStatus)){
      eq.eq(Invitation::getArticleStatus,articleStatus);
    }
    return this.invitationMapper.selectPage(new Page<>(page, size), queryWrapper);
  }

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public int create(Invitation invitation) {
    return invitationMapper.insert(invitation);
  }

  /**
   * 计算审核状态
   *
   * @param auditUserCount
   * @param auditThreshold
   * @param invitationId
   * @return
   */
  @Override
  public int updateAuditStatus( int auditUserCount, Integer auditThreshold, Long invitationId) {
    return invitationMapper.updateAuditStatus(auditUserCount,auditThreshold,invitationId);
  }
}

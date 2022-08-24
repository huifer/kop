package com.github.kop.bbs.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.kop.bbs.module.entity.Invitation;
import com.github.kop.bbs.repo.InvitationRepository;
import com.github.kop.bbs.repo.mapper.InvitationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InvitationRepositoryImpl implements InvitationRepository {

  @Autowired
  private InvitationMapper invitationMapper;

  @Override
  public IPage<Invitation> page(Long categoryId, Long page, Long size) {
    QueryWrapper<Invitation> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda()
        .eq(Invitation::getCategoryId, categoryId);
    return this.invitationMapper.selectPage(new Page<>(page, size), queryWrapper);
  }

  @Override
  public int create(Invitation invitation) {
    return invitationMapper.insert(invitation);
  }

}

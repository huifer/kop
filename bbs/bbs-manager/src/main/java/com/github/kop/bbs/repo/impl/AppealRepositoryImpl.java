package com.github.kop.bbs.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.kop.bbs.module.entity.Appeal;
import com.github.kop.bbs.module.req.appeal.AppealManagerPageReq;
import com.github.kop.bbs.repo.AppealRepository;
import com.github.kop.bbs.repo.mapper.AppealMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppealRepositoryImpl implements AppealRepository {

  @Autowired private AppealMapper appealMapper;

  @Override
  public int create(Appeal appeal) {
    return appealMapper.insert(appeal);
  }

  @Override
  public IPage<Appeal> page(Long page, Long size, Long userId) {
    QueryWrapper<Appeal> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda().eq(ObjectUtils.isNotEmpty(userId), Appeal::getAppealUserId, userId);
    return appealMapper.selectPage(new Page<>(page, size), queryWrapper);
  }

  @Override
  public IPage<Appeal> page(Long page, Long size, AppealManagerPageReq req) {
    QueryWrapper<Appeal> queryWrapper = new QueryWrapper<>();
    queryWrapper
        .lambda()
        .eq(ObjectUtils.isNotEmpty(req.getAppealType()), Appeal::getAppealType, req.getAppealType())
        .eq(
            ObjectUtils.isNotEmpty(req.getAppealStatus()),
            Appeal::getAppealStatus,
            req.getAppealStatus());
    return appealMapper.selectPage(new Page<>(page, size), queryWrapper);
  }

  @Override
  public Appeal findById(Long appealId) {
    return appealMapper.selectById(appealId);
  }
}

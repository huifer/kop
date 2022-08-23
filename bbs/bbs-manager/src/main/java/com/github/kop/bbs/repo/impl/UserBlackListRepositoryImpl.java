package com.github.kop.bbs.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.kop.bbs.module.entity.UserBlackList;
import com.github.kop.bbs.repo.UserBlackListRepository;
import com.github.kop.bbs.repo.mapper.UserBlackListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserBlackListRepositoryImpl implements UserBlackListRepository {

  @Autowired
  private UserBlackListMapper userBlackListMapper;

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public int create(UserBlackList userBlackList) {
    return userBlackListMapper.insert(userBlackList);
  }

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public int deleteByUserIdAndTargetUserId(Long userId, Long targetUserId) {
    QueryWrapper<UserBlackList> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda()
        .eq(UserBlackList::getCreateUserId, userId)
        .eq(UserBlackList::getBlackUserId, targetUserId);
    return userBlackListMapper.delete(queryWrapper);
  }

  @Override
  public IPage<UserBlackList> page(Long userId, Long page, Long size) {
    QueryWrapper<UserBlackList> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda()
        .eq(UserBlackList::getCreateUserId, userId);

    return userBlackListMapper.selectPage(new Page<>(page, size), queryWrapper);
  }
}

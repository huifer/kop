package com.github.kop.bbs.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.kop.bbs.module.entity.UserDynamic;
import com.github.kop.bbs.repo.UserDynamicRepository;
import com.github.kop.bbs.repo.mapper.UserDynamicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDynamicRepositoryImpl implements UserDynamicRepository {

  @Autowired
  private UserDynamicMapper userDynamicMapper;

  @Override
  public int create(UserDynamic userDynamic) {
    return userDynamicMapper.insert(userDynamic);
  }

  @Override
  public IPage<UserDynamic> page(Long userId, Long page, Long size) {
    QueryWrapper<UserDynamic> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda()
        .eq(UserDynamic::getCreateUserId, userId);
    return userDynamicMapper.selectPage(new Page<>(page, size), queryWrapper);
  }

  @Override
  public int delete(Long userId, Long id) {
    QueryWrapper<UserDynamic> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda()
        .eq(UserDynamic::getCreateUserId, userId)
        .eq(UserDynamic::getPostNewId, id);
    return userDynamicMapper.delete(queryWrapper);
  }
}

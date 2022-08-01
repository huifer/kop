package com.github.kop.rbac.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.kop.rbac.module.entity.RbacUserBindPost;
import com.github.kop.rbac.repo.UserBindPostRepository;
import com.github.kop.rbac.repo.mapper.RbacUserBindPostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserBindPostRepositoryImpl implements UserBindPostRepository {
  @Autowired private RbacUserBindPostMapper userBindPostMapper;

  @Override
  public RbacUserBindPost getBind(Long userId, Long companyId) {
    QueryWrapper<RbacUserBindPost> queryWrapper = new QueryWrapper<>();
    queryWrapper
        .lambda()
        .eq(RbacUserBindPost::getMain, 1)
        .eq(RbacUserBindPost::getUserId, userId)
        .eq(RbacUserBindPost::getCompanyId, companyId);
    return userBindPostMapper.selectOne(queryWrapper);
  }
}

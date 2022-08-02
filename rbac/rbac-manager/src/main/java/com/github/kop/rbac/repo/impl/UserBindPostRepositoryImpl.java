package com.github.kop.rbac.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.kop.rbac.module.entity.RbacUserBindPost;
import com.github.kop.rbac.repo.UserBindPostRepository;
import com.github.kop.rbac.repo.mapper.RbacUserBindPostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

  @Override
  public boolean hashMainPost(long userID, long companyId) {
    QueryWrapper<RbacUserBindPost> queryWrapper = new QueryWrapper<>();
    queryWrapper
        .lambda()
        .eq(RbacUserBindPost::getMain, 1)
        .eq(RbacUserBindPost::getUserId, userID)
        .eq(RbacUserBindPost::getCompanyId, companyId);
    return this.userBindPostMapper.exists(queryWrapper);
  }

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public int create(long userID, long companyId, long postId, boolean main) {
    RbacUserBindPost entity = new RbacUserBindPost();
    entity.setUserId(userID);
    entity.setPostId(postId);
    entity.setCompanyId(companyId);
    entity.setMain(main ? 1 : 0);
    return this.userBindPostMapper.insert(entity);
  }

  @Override
  public boolean delete(long userID, long companyId, long postId) {
    QueryWrapper<RbacUserBindPost> queryWrapper = new QueryWrapper<>();
    queryWrapper
        .lambda()
        .eq(RbacUserBindPost::getUserId, userID)
        .eq(RbacUserBindPost::getCompanyId, companyId)
        .eq(RbacUserBindPost::getPostId, postId);
    return this.userBindPostMapper.delete(queryWrapper) > 0;
  }
}

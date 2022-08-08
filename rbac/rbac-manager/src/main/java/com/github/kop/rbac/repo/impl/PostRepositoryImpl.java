package com.github.kop.rbac.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.kop.rbac.module.entity.RbacPost;
import com.github.kop.rbac.module.req.post.QueryPostReq;
import com.github.kop.rbac.repo.PostRepository;
import com.github.kop.rbac.repo.mapper.RbacPostMapper;
import com.github.kop.rbac.utils.UserInfoThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostRepositoryImpl implements PostRepository {

  @Autowired
  private RbacPostMapper postMapper;

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public int delete(Long id) {
    return postMapper.deleteById(id);
  }

  @Override
  public IPage<RbacPost> page(Long page, Long size, QueryPostReq req) {

    QueryWrapper<RbacPost> queryWrapper = new QueryWrapper<>();
    queryWrapper
            .lambda()
            .eq(RbacPost::getCompanyId, UserInfoThread.getCompanyId())
            .eq(req.getDeptId() != null, RbacPost::getDeptId, req.getDeptId());

    return this.postMapper.selectPage(new Page<>(page, size), queryWrapper);
  }

  @Override
  public List<RbacPost> list(QueryPostReq req) {
    QueryWrapper<RbacPost> queryWrapper = new QueryWrapper<>();
    queryWrapper
            .lambda()
            .eq(RbacPost::getCompanyId, UserInfoThread.getCompanyId())
            .eq(RbacPost::getDeptId, req.getDeptId());
    return postMapper.selectList(queryWrapper);
  }

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public int create(RbacPost rbacPost) {
    return postMapper.insert(rbacPost);
  }

  @Override
  public RbacPost byId(Long id) {
    return postMapper.selectById(id);
  }

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public int update(RbacPost rbacPost) {
    return postMapper.updateById(rbacPost);
  }
}

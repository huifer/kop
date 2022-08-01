package com.github.kop.rbac.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.kop.rbac.module.entity.RbacPost;
import com.github.kop.rbac.module.req.post.QueryPostReq;
import com.github.kop.rbac.repo.DeptRepository;
import com.github.kop.rbac.repo.PostRepository;
import com.github.kop.rbac.repo.mapper.RbacPostMapper;
import com.github.kop.rbac.utils.UserInfoThread;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostRepositoryImpl implements PostRepository {

  @Autowired private RbacPostMapper postMapper;
  @Autowired private DeptRepository deptRepository;

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public int delete(Long id) {
    return postMapper.deleteById(id);
  }

  @Override
  public IPage<RbacPost> page(Long page, Long size, QueryPostReq req) {

    List<Long> deptIds = deptRepository.findByName(req.getDeptName());
    QueryWrapper<RbacPost> queryWrapper = new QueryWrapper<>();
    queryWrapper
        .lambda()
        .eq(RbacPost::getCompanyId, UserInfoThread.getCompanyId())
        .in(CollectionUtils.isNotEmpty(deptIds), RbacPost::getDeptId, deptIds);

    return this.postMapper.selectPage(new Page<>(page, size), queryWrapper);
  }

  @Override
  public List<RbacPost> list(QueryPostReq req) {
    List<Long> deptIds = deptRepository.findByName(req.getDeptName());
    QueryWrapper<RbacPost> queryWrapper = new QueryWrapper<>();
    queryWrapper
        .lambda()
        .eq(RbacPost::getCompanyId, UserInfoThread.getCompanyId())
        .in(CollectionUtils.isNotEmpty(deptIds), RbacPost::getDeptId, deptIds);
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

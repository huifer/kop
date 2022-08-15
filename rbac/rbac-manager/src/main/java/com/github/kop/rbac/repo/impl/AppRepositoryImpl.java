package com.github.kop.rbac.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.kop.rbac.module.entity.RbacApp;
import com.github.kop.rbac.module.req.app.QueryAppReq;
import com.github.kop.rbac.repo.AppRepository;
import com.github.kop.rbac.repo.mapper.RbacAppMapper;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppRepositoryImpl implements AppRepository {
  @Autowired private RbacAppMapper rbacAppMapper;

  @Override
  public int create(RbacApp rbacApp) {
    return rbacAppMapper.insert(rbacApp);
  }

  @Override
  public RbacApp byId(Long id) {
    return rbacAppMapper.selectById(id);
  }

  @Override
  public int update(RbacApp rbacApp) {
    return rbacAppMapper.updateById(rbacApp);
  }

  @Override
  public int delete(Long id) {
    return rbacAppMapper.deleteById(id);
  }

  @Override
  public List<RbacApp> list(QueryAppReq req) {
    QueryWrapper<RbacApp> queryWrapper = new QueryWrapper<>();
    queryWrapper
        .lambda()
        .like(StringUtils.isNoneBlank(req.getCode()), RbacApp::getCode, req.getCode())
        .like(StringUtils.isNoneBlank(req.getName()), RbacApp::getName, req.getName());

    return rbacAppMapper.selectList(queryWrapper);
  }

  @Override
  public boolean hasCode(String code) {
    QueryWrapper<RbacApp> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda().eq(RbacApp::getCode, code);
    return this.rbacAppMapper.exists(queryWrapper);
  }

  @Override
  public IPage<RbacApp> page(Long page, Long size, QueryAppReq req) {

    QueryWrapper<RbacApp> queryWrapper = new QueryWrapper<>();
    queryWrapper
        .lambda()
        .like(StringUtils.isNoneBlank(req.getCode()), RbacApp::getCode, req.getCode())
        .like(StringUtils.isNoneBlank(req.getName()), RbacApp::getName, req.getName());

    return rbacAppMapper.selectPage(new Page<>(page, size), queryWrapper);
  }
}

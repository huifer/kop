package com.github.kop.rbac.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.kop.rbac.module.entity.RbacResource;
import com.github.kop.rbac.module.req.resource.QueryResourceReq;
import com.github.kop.rbac.repo.ResourceRepository;
import com.github.kop.rbac.repo.mapper.RbacResourceMapper;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ResourceRepositoryImpl implements ResourceRepository {
  @Autowired private RbacResourceMapper rbacResourceMapper;

  @Override
  public int update(RbacResource rbacResource) {
    return this.rbacResourceMapper.updateById(rbacResource);
  }

  @Override
  public RbacResource byId(Long id) {
    return this.rbacResourceMapper.selectById(id);
  }

  @Override
  public int deleteById(Long id) {
    return this.rbacResourceMapper.deleteById(id);
  }

  @Override
  public int create(RbacResource rbacResource) {
    return this.rbacResourceMapper.insert(rbacResource);
  }

  @Override
  public IPage<RbacResource> page(Long page, Long size, QueryResourceReq req) {
    QueryWrapper<RbacResource> queryWrapper = new QueryWrapper<>();
    queryWrapper
        .lambda()
        .like(StringUtils.isNotBlank(req.getCode()), RbacResource::getCode, req.getCode())
        .like(StringUtils.isNotBlank(req.getName()), RbacResource::getName, req.getName())
        .eq(StringUtils.isNotBlank(req.getType()), RbacResource::getType, req.getType());
    return this.rbacResourceMapper.selectPage(new Page<>(page, size), queryWrapper);
  }

  @Override
  public List<RbacResource> list(QueryResourceReq req) {
    QueryWrapper<RbacResource> queryWrapper = new QueryWrapper<>();
    queryWrapper
        .lambda()
        .like(StringUtils.isNotBlank(req.getCode()), RbacResource::getCode, req.getCode())
        .like(StringUtils.isNotBlank(req.getName()), RbacResource::getName, req.getName())
        .eq(StringUtils.isNotBlank(req.getType()), RbacResource::getType, req.getType());
    return null;
  }
}

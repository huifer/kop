package com.github.kop.rbac.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.kop.rbac.module.entity.RbacRole;
import com.github.kop.rbac.module.req.role.QueryRoleReq;
import com.github.kop.rbac.repo.RoleRepository;
import com.github.kop.rbac.repo.mapper.RbacRoleMapper;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

  @Autowired
  private RbacRoleMapper rbacRoleMapper;

  @Override
  public boolean exists(String code) {
    QueryWrapper<RbacRole> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda().eq(RbacRole::getCode, code);
    return rbacRoleMapper.exists(queryWrapper);
  }

  @Override
  public RbacRole byId(Long id) {
    return this.rbacRoleMapper.selectById(id);
  }

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public int create(RbacRole rbacRole) {
    return this.rbacRoleMapper.insert(rbacRole);
  }

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public int update(RbacRole rbacRole) {
    return this.rbacRoleMapper.updateById(rbacRole);
  }

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public int delete(Long id) {
    return this.rbacRoleMapper.deleteById(id);
  }

  @Override
  public List<RbacRole> list(QueryRoleReq req) {
    QueryWrapper<RbacRole> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda()
        .like(StringUtils.isNotBlank(req.getName()), RbacRole::getName, req.getName())
        .like(StringUtils.isNotBlank(req.getDesc()), RbacRole::getDesc, req.getDesc())
        .like(StringUtils.isNotBlank(req.getCode()), RbacRole::getCode, req.getCode())
    ;
    return this.rbacRoleMapper.selectList(queryWrapper);
  }

  @Override
  public IPage<RbacRole> page(Long page, Long size, QueryRoleReq req) {
    QueryWrapper<RbacRole> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda()
        .like(StringUtils.isNotBlank(req.getName()), RbacRole::getName, req.getName())
        .like(StringUtils.isNotBlank(req.getDesc()), RbacRole::getDesc, req.getDesc())
        .like(StringUtils.isNotBlank(req.getCode()), RbacRole::getCode, req.getCode())
    ;
    return this.rbacRoleMapper.selectPage(new Page<>(page, size), queryWrapper);
  }
}

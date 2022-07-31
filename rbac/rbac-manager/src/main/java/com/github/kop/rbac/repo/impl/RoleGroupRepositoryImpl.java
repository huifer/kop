package com.github.kop.rbac.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.kop.rbac.module.entity.RbacRoleGroup;
import com.github.kop.rbac.module.req.role.group.QueryRoleGroupReq;
import com.github.kop.rbac.repo.RoleGroupRepository;
import com.github.kop.rbac.repo.mapper.RbacRoleGroupMapper;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RoleGroupRepositoryImpl implements RoleGroupRepository {

  @Autowired
  private RbacRoleGroupMapper rbacRoleGroupMapper;

  @Override
  public boolean exists(String name) {
    QueryWrapper<RbacRoleGroup> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda()
        .eq(RbacRoleGroup::getName, name);
    return rbacRoleGroupMapper.exists(queryWrapper);
  }

  @Override
  public RbacRoleGroup byId(Long id) {
    return this.rbacRoleGroupMapper.selectById(id);
  }

  @Transactional(rollbackFor = Exception.class)
  @Override
  public int create(RbacRoleGroup rbacRoleGroup) {
    return this.rbacRoleGroupMapper.insert(rbacRoleGroup);
  }

  @Transactional(rollbackFor = Exception.class)
  @Override
  public int update(RbacRoleGroup rbacRoleGroup) {
    return this.rbacRoleGroupMapper.updateById(rbacRoleGroup);
  }

  @Transactional(rollbackFor = Exception.class)
  @Override
  public int delete(Long id) {
    return this.rbacRoleGroupMapper.deleteById(id);
  }


  @Override
  public IPage<RbacRoleGroup> page(Long page, Long size, QueryRoleGroupReq req) {
    QueryWrapper<RbacRoleGroup> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda()
        .like(StringUtils.isNotBlank(req.getName()), RbacRoleGroup::getName, req.getName());
    return this.rbacRoleGroupMapper.selectPage(new Page<>(page, size), queryWrapper);
  }

  @Override
  public List<RbacRoleGroup> list(QueryRoleGroupReq req) {
    QueryWrapper<RbacRoleGroup> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda()
        .like(StringUtils.isNotBlank(req.getName()), RbacRoleGroup::getName, req.getName());
    return this.rbacRoleGroupMapper.selectList(queryWrapper);
  }

}

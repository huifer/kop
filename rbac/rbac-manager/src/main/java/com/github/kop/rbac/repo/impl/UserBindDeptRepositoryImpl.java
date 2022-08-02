package com.github.kop.rbac.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.kop.rbac.module.entity.RbacUserBindDept;
import com.github.kop.rbac.repo.UserBindDeptRepository;
import com.github.kop.rbac.repo.mapper.RbacUserBindDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserBindDeptRepositoryImpl implements UserBindDeptRepository {
  @Autowired private RbacUserBindDeptMapper userBindDeptMapper;

  @Override
  public RbacUserBindDept getBind(Long userId, Long companyId) {
    QueryWrapper<RbacUserBindDept> queryWrapper = new QueryWrapper<>();
    queryWrapper
        .lambda()
        .eq(RbacUserBindDept::getUserId, userId)
        .eq(RbacUserBindDept::getCompanyId, companyId);
    return userBindDeptMapper.selectOne(queryWrapper);
  }

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public int create(RbacUserBindDept rbacUserBindDept) {
    return this.userBindDeptMapper.insert(rbacUserBindDept);
  }

  @Override
  public boolean hash(long userId, long deptId, long companyId) {
    QueryWrapper<RbacUserBindDept> queryWrapper = new QueryWrapper<>();
    queryWrapper
        .lambda()
        .eq(RbacUserBindDept::getUserId, userId)
        .eq(RbacUserBindDept::getCompanyId, companyId)
        .eq(RbacUserBindDept::getDeptId, deptId);

    return this.userBindDeptMapper.exists(queryWrapper);
  }

  @Override
  public boolean delete(long userId, long companyId, long deptId) {
    QueryWrapper<RbacUserBindDept> queryWrapper = new QueryWrapper<>();
    queryWrapper
        .lambda()
        .eq(RbacUserBindDept::getUserId, userId)
        .eq(RbacUserBindDept::getCompanyId, companyId)
        .eq(RbacUserBindDept::getDeptId, deptId);
    return userBindDeptMapper.delete(queryWrapper) > 0;
  }
}

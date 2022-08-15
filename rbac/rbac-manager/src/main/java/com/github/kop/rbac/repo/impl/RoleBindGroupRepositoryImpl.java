package com.github.kop.rbac.repo.impl;

import com.github.kop.rbac.module.entity.RbacRoleBindGroup;
import com.github.kop.rbac.repo.RoleBindGroupRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class RoleBindGroupRepositoryImpl implements RoleBindGroupRepository {
  @Override
  public int create(RbacRoleBindGroup rbacRoleBindGroup) {
    return 0;
  }

  @Override
  public int delete(RbacRoleBindGroup rbacRoleBindGroup) {
    return 0;
  }

  @Override
  public List<Long> findRoleIds(Long roleGroupId) {
    return null;
  }

  @Override
  public List<Long> findRoleIds(List<Long> roleGroupIds) {
    return null;
  }
}

package com.github.kop.rbac.repo;

import com.github.kop.rbac.module.entity.RbacRoleBindGroup;
import java.util.List;

public interface RoleBindGroupRepository {
  int create(RbacRoleBindGroup rbacRoleBindGroup);

  int delete(RbacRoleBindGroup rbacRoleBindGroup);

  List<Long> findRoleIds(Long roleGroupId);

  List<Long> findRoleIds(List<Long> roleGroupIds);
}

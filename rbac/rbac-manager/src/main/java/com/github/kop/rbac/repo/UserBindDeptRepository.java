package com.github.kop.rbac.repo;

import com.github.kop.rbac.module.entity.RbacUserBindDept;

public interface UserBindDeptRepository {
  RbacUserBindDept getBind(Long userId, Long companyId);

  int create(RbacUserBindDept rbacUserBindDept);

  boolean hash(long userId, long deptId, long companyId);

  boolean delete(long userId, long companyId, long deptId);
}

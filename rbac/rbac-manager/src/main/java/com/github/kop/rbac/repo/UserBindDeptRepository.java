package com.github.kop.rbac.repo;

import com.github.kop.rbac.module.entity.RbacUserBindDept;

public interface UserBindDeptRepository {
  RbacUserBindDept getBind(Long userId, Long companyId);
}

package com.github.kop.rbac.repo;

import com.github.kop.rbac.module.entity.RbacUserBindPost;

public interface UserBindPostRepository {
  RbacUserBindPost getBind(Long userId, Long companyId);
}

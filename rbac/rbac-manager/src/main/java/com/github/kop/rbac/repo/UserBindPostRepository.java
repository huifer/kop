package com.github.kop.rbac.repo;

import com.github.kop.rbac.module.entity.RbacUserBindPost;

public interface UserBindPostRepository {
  RbacUserBindPost getBind(Long userId, Long companyId);

  boolean hashMainPost(long userID, long companyId);

  int create(long userID, long companyId, long postId, boolean main);

  boolean delete(long userID, long companyId, long postId);
}

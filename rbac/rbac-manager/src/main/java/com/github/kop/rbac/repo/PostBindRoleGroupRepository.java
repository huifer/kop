package com.github.kop.rbac.repo;

import com.github.kop.rbac.module.entity.RbacPostBindRoleGroup;
import java.util.List;

public interface PostBindRoleGroupRepository {
  int create(RbacPostBindRoleGroup rbacPostBindRoleGroup);

  int delete(RbacPostBindRoleGroup rbacPostBindRoleGroup);

  boolean create(List<RbacPostBindRoleGroup> ins);

  List<Long> findRoleGroupIds(Long postId);
}

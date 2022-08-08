package com.github.kop.rbac.repo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.rbac.module.entity.RbacUser;
import com.github.kop.rbac.module.req.user.QueryUserReq;

import java.util.List;

public interface UserRepository {
  int create(RbacUser rbacUser);

  RbacUser byId(Long id);

  int update(RbacUser rbacUser);

  List<RbacUser> list(QueryUserReq req);

  IPage<RbacUser> page(Long page, Long size, QueryUserReq req);

  int delete(Long id);

  RbacUser findByUsernameAndPassword(String username, String password);

  boolean existsName(String name);

  boolean existsPhone(String phone);
}

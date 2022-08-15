package com.github.kop.rbac.repo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.rbac.module.entity.RbacApp;
import com.github.kop.rbac.module.req.app.QueryAppReq;
import java.util.List;

public interface AppRepository {
  int create(RbacApp rbacApp);

  RbacApp byId(Long id);

  int update(RbacApp rbacApp);

  int delete(Long id);

  List<RbacApp> list(QueryAppReq req);

  boolean hasCode(String code);

  IPage<RbacApp> page(Long page, Long size, QueryAppReq req);
}

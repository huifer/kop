package com.github.kop.rbac.repo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.rbac.module.entity.RbacPost;
import com.github.kop.rbac.module.req.post.QueryPostReq;
import java.util.List;

public interface PostRepository {

  int delete(Long id);

  IPage<RbacPost> page(Long page, Long size, QueryPostReq req);

  List<RbacPost> list(QueryPostReq req);

  int create(RbacPost rbacPost);

  RbacPost byId(Long id);

  int update(RbacPost rbacPost);
}

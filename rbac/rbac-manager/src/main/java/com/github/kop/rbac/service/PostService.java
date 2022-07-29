package com.github.kop.rbac.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.rbac.module.req.post.CreatePostReq;
import com.github.kop.rbac.module.req.post.QueryPostReq;
import com.github.kop.rbac.module.req.post.UpdatePostReq;
import com.github.kop.rbac.module.res.post.PostQueryRes;
import java.util.List;

public interface PostService {
  int create(CreatePostReq req);

  int update(UpdatePostReq req);

  PostQueryRes byId(Long id);

  int deleteById(Long id);

  IPage<PostQueryRes> page(Long page, Long size, QueryPostReq req);

  List<PostQueryRes> list(QueryPostReq req);
}

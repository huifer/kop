package com.github.kop.rbac.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.rbac.module.req.post.CreatePostReq;
import com.github.kop.rbac.module.req.post.QueryPostReq;
import com.github.kop.rbac.module.req.post.UpdatePostReq;
import com.github.kop.rbac.module.res.post.PostQueryRes;
import com.github.kop.rbac.service.PostService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
  @Override
  public int create(CreatePostReq req) {
    return 0;
  }

  @Override
  public int update(UpdatePostReq req) {
    return 0;
  }

  @Override
  public PostQueryRes byId(Long id) {
    return null;
  }

  @Override
  public int deleteById(Long id) {
    return 0;
  }

  @Override
  public IPage<PostQueryRes> page(Long page, Long size, QueryPostReq req) {
    return null;
  }

  @Override
  public List<PostQueryRes> list(QueryPostReq req) {
    return null;
  }
}

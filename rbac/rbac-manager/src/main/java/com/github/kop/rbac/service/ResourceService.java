package com.github.kop.rbac.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.rbac.module.req.resource.CreateResourceReq;
import com.github.kop.rbac.module.req.resource.QueryResourceReq;
import com.github.kop.rbac.module.req.resource.UpdateResourceReq;
import com.github.kop.rbac.module.res.resource.ResourceQueryRes;
import java.util.List;

public interface ResourceService {
  int create(CreateResourceReq req);

  int update(UpdateResourceReq req);

  ResourceQueryRes byId(Long id);

  int deleteById(Long id);

  IPage<ResourceQueryRes> page(Long page, Long size, QueryResourceReq req);

  List<ResourceQueryRes> list(QueryResourceReq req);
}

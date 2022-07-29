package com.github.kop.rbac.repo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.rbac.module.entity.RbacResource;
import com.github.kop.rbac.module.req.resource.QueryResourceReq;

import java.util.List;

public interface ResourceRepository {
    int update(RbacResource rbacResource);

    RbacResource byId(Long id);

    int deleteById(Long id);

    int create(RbacResource rbacResource);

    IPage<RbacResource> page(Long page, Long size, QueryResourceReq req);

    List<RbacResource> list(QueryResourceReq req);
}

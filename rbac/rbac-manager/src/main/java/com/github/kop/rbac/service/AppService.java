package com.github.kop.rbac.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.rbac.module.req.app.CreateAppReq;
import com.github.kop.rbac.module.req.app.QueryAppReq;
import com.github.kop.rbac.module.req.app.UpdateAppReq;
import com.github.kop.rbac.module.res.app.AppQueryRes;

import java.util.List;

public interface AppService {
    int create(CreateAppReq req);

    int update(UpdateAppReq req);

    AppQueryRes byId(Long id);

    int deleteById(Long id);

    IPage<AppQueryRes> page(Long page, Long size, QueryAppReq req);

    List<AppQueryRes> list(QueryAppReq req);
}

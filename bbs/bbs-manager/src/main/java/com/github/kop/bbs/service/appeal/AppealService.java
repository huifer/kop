package com.github.kop.bbs.service.appeal;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.req.appeal.CreateAppealReq;
import com.github.kop.bbs.module.res.AppealResp;

public interface AppealService {

  boolean create(CreateAppealReq req);

  IPage<AppealResp> page(Long page, Long size);
}

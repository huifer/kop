package com.github.kop.bbs.service.appeal;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.entity.Appeal;
import com.github.kop.bbs.module.req.appeal.AppealManagerPageReq;
import com.github.kop.bbs.module.req.appeal.CreateAppealReq;
import com.github.kop.bbs.module.res.appeal.AppealResp;

public interface AppealService {

  boolean create(CreateAppealReq req);

  IPage<AppealResp> page(Long page, Long size, Long userId);

  IPage<AppealResp> page(Long page, Long size, AppealManagerPageReq req);

  Appeal findById(Long appealId);
}

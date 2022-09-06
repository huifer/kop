package com.github.kop.bbs.repo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.entity.Appeal;
import com.github.kop.bbs.module.req.appeal.AppealManagerPageReq;

public interface AppealRepository {

  int create(Appeal appeal);

  IPage<Appeal> page(Long page, Long size,Long userId);


  IPage<Appeal> page(Long page, Long size, AppealManagerPageReq req);

    Appeal findById(Long appealId);
}

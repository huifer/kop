package com.github.kop.bbs.service.user.dynamic;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.req.user.UserDynamicCreateReq;
import com.github.kop.bbs.module.res.user.UserDynamicResp;

/** 用户动态 */
public interface UserDynamicService {

  boolean create(UserDynamicCreateReq req, Long userId);

  IPage<UserDynamicResp> page(Long userId, Long page, Long size);

  boolean delete(Long userId, Long id);
}

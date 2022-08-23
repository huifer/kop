package com.github.kop.bbs.service.user.dynamic;

import com.github.kop.bbs.module.req.user.UserDynamicCreateReq;

/** 用户动态 */
public interface UserDynamicService {

  boolean create(UserDynamicCreateReq req);
}

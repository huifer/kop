package com.github.kop.customer.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.customer.module.req.RegisterUserReq;
import com.github.kop.customer.module.res.UserInfoRes;

import java.util.List;

public interface UserService {
    boolean register(RegisterUserReq req);

    UserInfoRes userInfo(long userId);

    IPage<UserInfoRes> page(long cur, long size, long curUserId);

    IPage<UserInfoRes> pageFromUserIds(long cur, long size, List<Long> uids);
}

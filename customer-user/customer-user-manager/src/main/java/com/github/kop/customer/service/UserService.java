package com.github.kop.customer.service;

import com.github.kop.customer.module.req.RegisterUserReq;
import com.github.kop.customer.module.res.RegisterUserRes;

public interface UserService {
    boolean register(RegisterUserReq req);

    RegisterUserRes userInfo(long userId);
}

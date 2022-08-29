package com.github.kop.rbac.service;


import com.github.kop.rbac.module.req.login.LoginReq;
import com.github.kop.rbac.module.res.user.UserLoginRes;

public interface LoginService {

    UserLoginRes login(LoginReq loginReq);
}

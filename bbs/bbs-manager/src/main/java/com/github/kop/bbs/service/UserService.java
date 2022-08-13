package com.github.kop.bbs.service;

import com.github.kop.bbs.module.req.user.CreateUserReq;
import com.github.kop.bbs.module.req.user.LoginUserReq;
import com.github.kop.bbs.module.req.user.UpdateUserReq;
import com.github.kop.bbs.module.res.user.UserLoginRes;

public interface UserService {



    /**
     * 添加用户
     * @param req
     * @return
     */
    Boolean create(CreateUserReq req);

    /**
     * 更新用户
     * @param req
     * @return
     */
    Boolean updateUser(UpdateUserReq req);

    /**
     * 登录
     * @param req
     * @return
     */
    UserLoginRes login(LoginUserReq req);
}



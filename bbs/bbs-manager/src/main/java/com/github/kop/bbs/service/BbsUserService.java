package com.github.kop.bbs.service;

import java.util.List;
import com.github.kop.bbs.module.entity.BbsUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.kop.bbs.module.req.user.CreateUserReq;
import com.github.kop.bbs.module.req.user.UpdateUserReq;

public interface BbsUserService extends IService<BbsUser> {


    int updateBatchSelective(List<BbsUser> list);

    int batchInsert(List<BbsUser> list);

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
}



package com.github.kop.bbs.service;

import java.util.List;
import com.github.kop.bbs.module.entity.BbsUser;
import com.baomidou.mybatisplus.extension.service.IService;

public interface BbsUserService extends IService<BbsUser> {


    int updateBatchSelective(List<BbsUser> list);

    int batchInsert(List<BbsUser> list);

}



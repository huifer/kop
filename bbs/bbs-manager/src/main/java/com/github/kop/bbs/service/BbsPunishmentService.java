package com.github.kop.bbs.service;

import com.github.kop.bbs.module.entity.BbsPunishment;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;

public interface BbsPunishmentService extends IService<BbsPunishment> {


    int updateBatchSelective(List<BbsPunishment> list);

    int batchInsert(List<BbsPunishment> list);

}



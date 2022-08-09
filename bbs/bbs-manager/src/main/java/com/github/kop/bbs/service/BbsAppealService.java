package com.github.kop.bbs.service;

import com.github.kop.bbs.module.entity.BbsAppeal;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;

public interface BbsAppealService extends IService<BbsAppeal> {


    int updateBatchSelective(List<BbsAppeal> list);

    int batchInsert(List<BbsAppeal> list);

}




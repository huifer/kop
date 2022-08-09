package com.github.kop.bbs.service;

import com.github.kop.bbs.module.entity.BbsCollectionLog;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;

public interface BbsCollectionLogService extends IService<BbsCollectionLog> {


    int updateBatchSelective(List<BbsCollectionLog> list);

    int batchInsert(List<BbsCollectionLog> list);

}



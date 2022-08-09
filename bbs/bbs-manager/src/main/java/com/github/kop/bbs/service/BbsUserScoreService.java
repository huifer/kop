package com.github.kop.bbs.service;

import java.util.List;
import com.github.kop.bbs.module.entity.BbsUserScore;
import com.baomidou.mybatisplus.extension.service.IService;

public interface BbsUserScoreService extends IService<BbsUserScore> {


    int updateBatchSelective(List<BbsUserScore> list);

    int batchInsert(List<BbsUserScore> list);

}


package com.github.kop.bbs.service;

import java.util.List;
import com.github.kop.bbs.module.entity.BbsScoreLog;
import com.baomidou.mybatisplus.extension.service.IService;
public interface BbsScoreLogService extends IService<BbsScoreLog>{


    int updateBatchSelective(List<BbsScoreLog> list);

    int batchInsert(List<BbsScoreLog> list);

}

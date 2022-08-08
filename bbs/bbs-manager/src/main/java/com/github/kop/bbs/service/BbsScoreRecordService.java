package com.github.kop.bbs.service;

import java.util.List;
import com.github.kop.bbs.module.entity.BbsScoreRecord;
import com.baomidou.mybatisplus.extension.service.IService;
public interface BbsScoreRecordService extends IService<BbsScoreRecord>{


    int updateBatchSelective(List<BbsScoreRecord> list);

    int batchInsert(List<BbsScoreRecord> list);

}

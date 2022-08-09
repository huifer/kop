package com.github.kop.bbs.service;

import java.util.List;
import com.github.kop.bbs.module.entity.BbsFeedbackRecord;
import com.baomidou.mybatisplus.extension.service.IService;
public interface BbsFeedbackRecordService extends IService<BbsFeedbackRecord>{


    int updateBatchSelective(List<BbsFeedbackRecord> list);

    int batchInsert(List<BbsFeedbackRecord> list);

}

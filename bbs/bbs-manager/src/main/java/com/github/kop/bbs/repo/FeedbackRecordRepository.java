package com.github.kop.bbs.repo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.entity.FeedbackRecord;

public interface FeedbackRecordRepository {

  IPage<FeedbackRecord> page(Long page, Long size);

  int  create(FeedbackRecord feedbackRecord);
}

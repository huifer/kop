package com.github.kop.bbs.service.feedback;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.req.FeedBackReq;
import com.github.kop.bbs.module.res.FeedBackResp;

public interface FeedbackRecordService {

  boolean create(FeedBackReq req);

  IPage<FeedBackResp> page(Long page, Long size);
}

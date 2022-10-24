package com.github.kop.bbs.service.feedback.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.entity.FeedbackRecord;
import com.github.kop.bbs.module.entity.User;
import com.github.kop.bbs.module.req.FeedBackReq;
import com.github.kop.bbs.module.res.FeedBackResp;
import com.github.kop.bbs.repo.FeedbackRecordRepository;
import com.github.kop.bbs.service.feedback.FeedbackRecordService;
import com.github.kop.bbs.service.user.UserService;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackRecordServiceImpl implements FeedbackRecordService {

  @Autowired private FeedbackRecordRepository feedbackRecordRepository;
  @Autowired private UserService userService;

  @Override
  public boolean create(FeedBackReq req) {
    FeedbackRecord feedbackRecord = new FeedbackRecord();
    return feedbackRecordRepository.create(feedbackRecord) > 0;
  }

  @Override
  public IPage<FeedBackResp> page(Long page, Long size) {
    IPage<FeedbackRecord> pageRes = this.feedbackRecordRepository.page(page, size);
    return pageRes.convert(
        new Function<FeedbackRecord, FeedBackResp>() {
          @Override
          public FeedBackResp apply(FeedbackRecord feedbackRecord) {
            FeedBackResp feedBackResp = new FeedBackResp();
            feedBackResp.setFeedbackText(feedbackRecord.getFeedbackText());
            Long createUserId = feedbackRecord.getCreateUserId();
            User user = userService.byUserId(createUserId);

            feedBackResp.setUserId(user.getId());
            feedBackResp.setUserName(user.getUsername());
            feedBackResp.setNickName(user.getNickname());

            return feedBackResp;
          }
        });
  }
}

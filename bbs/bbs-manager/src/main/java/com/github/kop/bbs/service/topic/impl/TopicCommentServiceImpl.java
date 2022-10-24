package com.github.kop.bbs.service.topic.impl;

import com.github.kop.bbs.module.entity.TopicComment;
import com.github.kop.bbs.module.enums.DeletedEnum;
import com.github.kop.bbs.module.ex.ValidateException;
import com.github.kop.bbs.module.req.topic.TopicCommentReq;
import com.github.kop.bbs.repo.TopicCommentRepository;
import com.github.kop.bbs.service.IpLocationService;
import com.github.kop.bbs.service.topic.TopicCommentService;
import com.github.kop.bbs.utils.CreateValidate;
import com.github.kop.bbs.utils.UserInfoThread;
import javax.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

@Service
public class TopicCommentServiceImpl implements TopicCommentService {

  @Resource private TopicCommentRepository topicCommentRepository;

  @Resource private IpLocationService ipLocationService;

  private final TopicCommentServiceImpl.TopicCreateAndUpdateValidate topicCreateAndUpdateValidate =
      new TopicCommentServiceImpl.TopicCreateAndUpdateValidate();

  /**
   * 话题评论
   *
   * @param req
   * @return
   */
  @Override
  public Boolean create(TopicCommentReq req) {
    topicCreateAndUpdateValidate.createValidate(req);
    return topicCommentRepository.insert(
            TopicComment.builder()
                .topicCommentType(req.getTopicCommentType())
                .pid(req.getPid())
                .topId(req.getTopId())
                .thumbsCont(0L)
                .commentContent(req.getCommentContent())
                .ip(UserInfoThread.getIp())
                .ipLoc(ipLocationService.getLocation(UserInfoThread.getIp()))
                .deleted(DeletedEnum.FALSE.getCode())
                .version(0L)
                .refId(req.getRefId())
                .build())
        > 0;
  }

  protected class TopicCreateAndUpdateValidate implements CreateValidate<TopicCommentReq> {

    @Override
    public void createValidate(TopicCommentReq req) throws ValidateException {

      if (ObjectUtils.isEmpty(req.getRefId())) {
        throw new ValidateException("评论主体不能为空");
      }
      if (ObjectUtils.isEmpty(req.getTopicCommentType())) {
        throw new ValidateException("评论类别不能为空");
      }
      if (ObjectUtils.isEmpty(req.getCommentContent())) {
        throw new ValidateException("评论内容不能为空");
      }
    }
  }
}

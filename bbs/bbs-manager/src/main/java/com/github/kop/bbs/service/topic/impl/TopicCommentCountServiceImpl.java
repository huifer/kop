package com.github.kop.bbs.service.topic.impl;

import com.github.kop.bbs.module.bo.TopicCommentUpdateBo;
import com.github.kop.bbs.repo.TopicCommentCountRepository;
import com.github.kop.bbs.service.topic.TopicCommentCountService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopicCommentCountServiceImpl implements TopicCommentCountService {

  @Resource private TopicCommentCountRepository topicCommentCountRepository;

  /**
   * 批量更新评论数量
   *
   * @param updateBoArrayList
   */
  @Override
  @Transactional(rollbackFor = Exception.class)
  public void updateCommentCount(List<TopicCommentUpdateBo> updateBoArrayList) {
    topicCommentCountRepository.updateCommentCount(updateBoArrayList);
  }
}

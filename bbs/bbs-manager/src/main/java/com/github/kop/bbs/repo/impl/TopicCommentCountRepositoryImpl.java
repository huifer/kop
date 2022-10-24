package com.github.kop.bbs.repo.impl;

import com.github.kop.bbs.module.bo.TopicCommentUpdateBo;
import com.github.kop.bbs.repo.TopicCommentCountRepository;
import com.github.kop.bbs.repo.mapper.TopicCommentCountMapper;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/9/1 23:44
 */
@Repository
public class TopicCommentCountRepositoryImpl implements TopicCommentCountRepository {
  @Resource private TopicCommentCountMapper topicCommentCountMapper;

  /**
   * 批量更新评论数量
   *
   * @param updateBoArrayList
   */
  @Override
  public void updateCommentCount(List<TopicCommentUpdateBo> updateBoArrayList) {
    topicCommentCountMapper.updateCommentCount(updateBoArrayList);
  }
}

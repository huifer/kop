package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.bo.TopicCommentUpdateBo;
import com.github.kop.bbs.module.entity.TopicCommentCount;
import java.util.List;

public interface TopicCommentCountMapper extends BaseMapper<TopicCommentCount> {
  /**
   * 批量更新评论数量
   *
   * @param updateBoArrayList
   */
  void updateCommentCount(List<TopicCommentUpdateBo> updateBoArrayList);
}

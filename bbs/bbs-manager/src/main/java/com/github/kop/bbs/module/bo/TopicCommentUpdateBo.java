package com.github.kop.bbs.module.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/9/1 23:46
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TopicCommentUpdateBo {

  /** 话题id */
  private Long topicId;

  /** 投票票数 */
  private Long commentCount;
}

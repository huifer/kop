package com.github.kop.bbs.service.score;

import java.time.LocalDateTime;

public interface ScoreRecordService {

  LocalDateTime firstGetScore(Long roleId, Long userId);

  /**
   * 计算时间范围内用户获取的单个积分规则的总量
   *
   * @param scoreRuleId 积分规则id
   * @param userId 用户id
   * @param startTime 开始时间
   * @param endTime 结束时间
   * @return 积分总量
   */
  Long sumScoreByRule(Long scoreRuleId, Long userId, LocalDateTime startTime, LocalDateTime endTime);

  /**
   * 发放积分
   *
   * @param userId 用户id
   * @param roleId
   * @param score
   * @return
   */
  boolean grant(Long userId, Long roleId, Long score);
}

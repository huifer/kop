package com.github.kop.bbs.service.score.impl;

import com.github.kop.bbs.module.entity.ScoreRecord;
import com.github.kop.bbs.repo.ScoreRecordRepository;
import com.github.kop.bbs.service.score.ScoreRecordService;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreRecordServiceImpl implements ScoreRecordService {

  @Autowired private ScoreRecordRepository scoreRecordRepository;

  @Override
  public LocalDateTime firstGetScore(Long roleId, Long userId) {
    ScoreRecord scoreRecord =
        this.scoreRecordRepository.findByRoleIdAndUserIdAndMinCreateAt(roleId, userId);
    return scoreRecord.getCreateTime();
  }

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public boolean grant(Long userId, Long scoreRuleId, Long score) {

    ScoreRecord scoreRecord = new ScoreRecord();
    scoreRecord.setScoreRuleId(scoreRuleId);
    scoreRecord.setScoreCount(score);
    scoreRecord.setUserId(userId);
    scoreRecord.setCreateTime(LocalDateTime.now());

    return scoreRecordRepository.create(scoreRecord);
  }

  @Override
  public Long sumScoreByRule(
      Long scoreRuleId, Long userId, LocalDateTime startTime, LocalDateTime endTime) {
    return scoreRecordRepository.sumScoreByRole(scoreRuleId, userId, startTime, endTime);
  }
}

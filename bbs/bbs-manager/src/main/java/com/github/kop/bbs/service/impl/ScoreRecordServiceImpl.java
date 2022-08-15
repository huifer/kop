package com.github.kop.bbs.service.impl;

import com.github.kop.bbs.module.entity.ScoreRecord;
import com.github.kop.bbs.repo.ScoreRecordRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.kop.bbs.service.ScoreRecordService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreRecordServiceImpl implements ScoreRecordService {

  @Autowired
  private ScoreRecordRepository scoreRecordRepository;

  @Override
  public LocalDateTime firstGetScore(Long roleId, Long userId) {
    ScoreRecord scoreRecord = this.scoreRecordRepository.findByRoleIdAndUserIdAndMinCreateAt(roleId,
        userId);
    return scoreRecord.getCreateTime();
  }

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public boolean grant(Long userId, Long roleId, Long score) {

    ScoreRecord scoreRecord = new ScoreRecord();
    scoreRecord.setRoleId(roleId);
    scoreRecord.setScoreCount(score);
    scoreRecord.setUserId(userId);
    scoreRecord.setCreateTime(LocalDateTime.now());

    return scoreRecordRepository.create(scoreRecord);
  }

  @Override
  public Long sumScoreByRole(Long roleId, Long userId, LocalDateTime startTime,
      LocalDateTime endTime) {
    return scoreRecordRepository.sumScoreByRole(roleId, userId, startTime, endTime);
  }
}

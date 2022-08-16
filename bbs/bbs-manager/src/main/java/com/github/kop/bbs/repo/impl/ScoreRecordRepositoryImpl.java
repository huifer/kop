package com.github.kop.bbs.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.kop.bbs.module.entity.ScoreRecord;
import com.github.kop.bbs.repo.ScoreRecordRepository;
import com.github.kop.bbs.repo.mapper.ScoreRecordMapper;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ScoreRecordRepositoryImpl implements ScoreRecordRepository {

  @Autowired private ScoreRecordMapper scoreRecordMapper;

  @Override
  public ScoreRecord findByRoleIdAndUserIdAndMinCreateAt(Long scoreRuleId, Long userId) {
    QueryWrapper<ScoreRecord> queryWrapper = new QueryWrapper<>();
    queryWrapper
        .lambda()
        .eq(ScoreRecord::getScoreRuleId, scoreRuleId)
        .eq(ScoreRecord::getUserId, userId)
        .orderByAsc(ScoreRecord::getCreateTime)
        .last("limit 1");

    return this.scoreRecordMapper.selectOne(queryWrapper);
  }

  @Override
  public Long sumScoreByRole(
      Long scoreRuleId, Long userId, LocalDateTime startTime, LocalDateTime endTime) {
    return scoreRecordMapper.sumScoreByRule(scoreRuleId, userId, startTime, endTime);
  }

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public boolean create(ScoreRecord scoreRecord) {
    return this.scoreRecordMapper.insert(scoreRecord) > 0;
  }
}

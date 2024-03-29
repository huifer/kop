package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.ScoreRecord;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ScoreRecordMapper extends BaseMapper<ScoreRecord> {

  int updateBatchSelective(List<ScoreRecord> list);

  int batchInsert(@Param("list") List<ScoreRecord> list);

  Long sumScoreByRule(
      @Param("scoreRuleId") Long scoreRuleId,
      @Param("userId") Long userId,
      @Param("startTime") LocalDateTime startTime,
      @Param("endTime") LocalDateTime endTime);
}

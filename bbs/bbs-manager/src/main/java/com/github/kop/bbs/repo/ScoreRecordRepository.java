package com.github.kop.bbs.repo;

import com.github.kop.bbs.module.entity.ScoreRecord;
import java.time.LocalDateTime;

public interface ScoreRecordRepository {

  ScoreRecord findByRoleIdAndUserIdAndMinCreateAt(Long roleId, Long userId);

  Long sumScoreByRole(Long roleId, Long userId, LocalDateTime startTime, LocalDateTime endTime);

  boolean create(ScoreRecord scoreRecord);

}

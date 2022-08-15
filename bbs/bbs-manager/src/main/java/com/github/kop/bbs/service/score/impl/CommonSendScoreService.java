package com.github.kop.bbs.service.score.impl;

import com.github.kop.bbs.event.point.PointEvent;
import com.github.kop.bbs.module.entity.ScoreRole;
import com.github.kop.bbs.service.score.ScoreRecordService;
import com.github.kop.bbs.service.score.ScoreRoleService;
import com.github.kop.bbs.service.score.SendScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** 公共的积分发放类 */
@Service
public class CommonSendScoreService implements SendScoreService {

  @Autowired private ScoreRoleService scoreRoleService;
  @Autowired private ScoreRecordService scoreRecordService;

  @Transactional
  @Override
  public boolean send(PointEvent event) {
    // 当前用户是否符合积分规则
    ScoreRole scoreRole = scoreRoleService.exceededMax(event.type(), event.getUserId());

    if (scoreRole != null) {
      return this.scoreRecordService.grant(
          event.getUserId(), scoreRole.getRoleId(), scoreRole.getScore());
    }
    return false;
  }
}

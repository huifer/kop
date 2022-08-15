package com.github.kop.bbs.service.point.impl;

import com.github.kop.bbs.event.point.PointEvent;
import com.github.kop.bbs.module.entity.ScoreRole;
import com.github.kop.bbs.service.ScoreRecordService;
import com.github.kop.bbs.service.ScoreRoleService;
import com.github.kop.bbs.service.point.SendPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 公共的积分发放类
 */
@Service
public class CommonSendPointService implements SendPointService {

  @Autowired
  private ScoreRoleService scoreRoleService;
  @Autowired
  private ScoreRecordService scoreRecordService;

  @Transactional
  @Override
  public boolean send(PointEvent event) {
    // 当前用户是否符合积分规则
    ScoreRole scoreRole = scoreRoleService.exceededMax(event.type(), event.getUserId());

    if (scoreRole != null) {
      return this.scoreRecordService.grant(event.getUserId(), scoreRole.getRoleId(),
          scoreRole.getScore());
    }
    return false;
  }



}

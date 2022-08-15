package com.github.kop.bbs.service.score;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.entity.ScoreRole;
import com.github.kop.bbs.module.enums.ScoreTypeEnums;
import com.github.kop.bbs.module.req.score.CreateScoreRoleReq;
import com.github.kop.bbs.module.req.score.PageListScoreRoleReq;
import com.github.kop.bbs.module.req.score.UpdateScoreRoleReq;
import com.github.kop.bbs.module.res.score.ScorePageListRes;

public interface ScoreRoleService {

  Boolean create(CreateScoreRoleReq req);

  Boolean update(UpdateScoreRoleReq req);

  Boolean delete(Long id);

  IPage<ScorePageListRes> pageList(PageListScoreRoleReq pageListScoreRoleReq, Long page, Long size);

  /**
   * 当前用户是否符合积分规则
   *
   * @param type 积分类型
   * @param userId 用户id
   * @return 符合返回对应积分规则
   */
  ScoreRole exceededMax(ScoreTypeEnums type, Long userId);
}

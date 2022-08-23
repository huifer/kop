package com.github.kop.bbs.service.user.relation;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.res.user.UserRelationResp;

public interface UserFollowerListService {

  /**
   * 关注
   *
   * @param userId       当前登陆人
   * @param targetUserId 需要关注的人
   */
  boolean subscribe(Long userId, Long targetUserId);

  /**
   * 取消关注
   *
   * @param userId       当前登陆人
   * @param targetUserId 需要取消关注的人
   */
  boolean unSubscribe(Long userId, Long targetUserId);

  IPage<UserRelationResp> page(Long userId, Long page, Long size);
}

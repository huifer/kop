package com.github.kop.bbs.service.user.relation;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.res.user.UserRelationResp;

public interface UserBlackListService {

  /**
   * 拉黑
   * @param userId 当前登陆人
   * @param targetUserId 需要拉黑的人
   */
  boolean pullBlack(Long userId, Long targetUserId);

  /**
   * 拉黑
   * @param userId 当前登陆人
   * @param targetUserId 需要取消拉黑的人
   */
  boolean cancelBlock(Long userId, Long targetUserId);

  IPage<UserRelationResp> page(Long userId, Long page, Long size);
}

package com.github.kop.bbs.repo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.entity.UserBlackList;

public interface UserBlackListRepository {

  int create(UserBlackList userBlackList);

  int deleteByUserIdAndTargetUserId(Long userId, Long targetUserId);

  IPage<UserBlackList> page(Long userId, Long page, Long size);
}

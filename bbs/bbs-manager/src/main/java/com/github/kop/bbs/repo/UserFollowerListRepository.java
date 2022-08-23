package com.github.kop.bbs.repo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.entity.UserFollowerList;

public interface UserFollowerListRepository {

  int  create(UserFollowerList userFollowerList);

  int  deleteByUserIdAndTargetUserId(Long userId, Long targetUserId);

  IPage<UserFollowerList> page(Long userId, Long page, Long size);

}

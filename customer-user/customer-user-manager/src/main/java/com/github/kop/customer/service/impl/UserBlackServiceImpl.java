package com.github.kop.customer.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.customer.module.res.UserInfoRes;
import com.github.kop.customer.repo.UserBlackRepository;
import com.github.kop.customer.service.UserBlackService;
import com.github.kop.customer.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBlackServiceImpl implements UserBlackService {
  @Autowired private UserBlackRepository userBlackRepository;

  @Override
  public boolean add(long selfUserId, long opUserId) {
    return userBlackRepository.create(selfUserId, opUserId) > 0;
  }

  @Override
  public boolean remove(long selfUserId, long opUserId) {
    return userBlackRepository.delete(selfUserId, opUserId) > 0;
  }

  @Override
  public List<Long> blackIds(long userId) {
    return this.userBlackRepository.blackIds(userId);
  }

  @Autowired private UserService userService;

  @Override
  public boolean isBlack(long curUserId, Long targetUserId) {
    return userBlackRepository.exists(curUserId, targetUserId);
  }

  @Override
  public IPage<UserInfoRes> blackList(long userId, long cur, long size) {
    List<Long> uids = this.blackIds(userId);

    return userService.pageFromUserIds(cur, size, uids);
  }
}

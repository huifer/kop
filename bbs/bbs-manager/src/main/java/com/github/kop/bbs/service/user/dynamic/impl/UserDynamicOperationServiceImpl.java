package com.github.kop.bbs.service.user.dynamic.impl;

import com.github.kop.bbs.service.user.dynamic.UserDynamicOperationService;
import org.springframework.stereotype.Service;

@Service
public class UserDynamicOperationServiceImpl implements UserDynamicOperationService {

  @Override
  public boolean like(Long userId, Long id) {
    return false;
  }

  @Override
  public boolean cancelLike(Long userId, Long id) {
    return false;
  }

  @Override
  public boolean dislike(Long userId, Long id) {
    return false;
  }

  @Override
  public boolean cancelDislike(Long userId, Long id) {
    return false;
  }
}

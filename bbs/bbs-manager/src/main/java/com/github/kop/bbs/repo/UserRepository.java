package com.github.kop.bbs.repo;

import com.github.kop.bbs.module.entity.BbsUser;

public interface UserRepository {

  long insert(BbsUser build);

  BbsUser selectById(Long id);

  BbsUser findByName(String username);

  int updateById(BbsUser bbsUser);

  boolean existsUserName(String name);
}

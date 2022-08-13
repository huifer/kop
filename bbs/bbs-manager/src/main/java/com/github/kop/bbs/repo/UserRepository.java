package com.github.kop.bbs.repo;

import com.github.kop.bbs.module.entity.User;

public interface UserRepository {

  long insert(User build);

  User selectById(Long id);

  User findByName(String username);

  int updateById(User user);

  boolean existsUserName(String name);
}

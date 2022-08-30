package com.github.kop.bbs.repo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.entity.User;
import com.github.kop.bbs.module.req.user.UserQueryReq;

import java.util.List;

public interface UserRepository {

  long insert(User build);

  User selectById(Long id);

  User findByName(String username);

  int updateById(User user);

  boolean existsUserName(String name);

  IPage<User> page(Long page, Long size, UserQueryReq req);

    List<User> findByUserIds(List<Long> userIdList);
}

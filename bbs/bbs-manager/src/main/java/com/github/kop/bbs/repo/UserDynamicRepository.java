package com.github.kop.bbs.repo;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.entity.UserDynamic;

public interface UserDynamicRepository {

  int  create(UserDynamic userDynamic);

  IPage<UserDynamic> page(Long userId, Long page, Long size);

  int  delete(Long userId, Long id);
}

package com.github.kop.customer.repo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.customer.module.entity.CustomerUserDynamic;

public interface UserDynamicRepository {
  int create(CustomerUserDynamic customerUserDynamic);

  int delete(long id);

  IPage<CustomerUserDynamic> page(long cur, long size, long userId);
}

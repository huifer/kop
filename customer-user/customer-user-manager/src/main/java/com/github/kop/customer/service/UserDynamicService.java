package com.github.kop.customer.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.customer.module.res.DynamicListRes;

public interface UserDynamicService {
    boolean create(long userId, String msg);

    boolean remove(long id);

    IPage<DynamicListRes> page(long cur , long size, long userId);
}

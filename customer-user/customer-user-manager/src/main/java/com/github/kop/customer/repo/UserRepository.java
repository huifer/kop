package com.github.kop.customer.repo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.customer.module.entity.CustomerUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {
    int create(CustomerUser customerUser);

    CustomerUser byId(long userId);

    IPage<CustomerUser> page(long cur, long size);

    /**
     *
     * @param cur
     * @param size
     * @param uids 用户id
     * @return
     */
    IPage<CustomerUser> page(long cur, long size, List<Long> uids);
}

package com.github.kop.customer.repo;

import com.github.kop.customer.module.entity.CustomerUser;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    int create(CustomerUser customerUser);

    CustomerUser byId(long userId);
}

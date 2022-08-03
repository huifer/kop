package com.github.kop.customer.repo;

import org.springframework.stereotype.Repository;

public interface UserBlackRepository {
    int create(long selfUserId, long opUserId);

    int delete(long selfUserId, long opUserId);
}

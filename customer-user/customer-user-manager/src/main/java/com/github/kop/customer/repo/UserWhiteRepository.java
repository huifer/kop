package com.github.kop.customer.repo;

public interface UserWhiteRepository {
    int create(long selfUserId, long opUserId);

    int delete(long selfUserId, long opUserId);
}

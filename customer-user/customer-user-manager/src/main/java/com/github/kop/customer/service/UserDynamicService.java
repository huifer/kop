package com.github.kop.customer.service;

public interface UserDynamicService {
    boolean create(long userId, String msg);

    boolean remove(long id);
}

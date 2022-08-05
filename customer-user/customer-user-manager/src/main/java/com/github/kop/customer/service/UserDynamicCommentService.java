package com.github.kop.customer.service;

public interface UserDynamicCommentService {

    boolean create(Long userId, String msg, Long dynamicId, Long pid);
}

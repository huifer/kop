package com.github.kop.customer.repo.impl;

import com.github.kop.customer.module.entity.CustomerUserDynamicComment;
import com.github.kop.customer.repo.UserDynamicCommentRepository;
import com.github.kop.customer.repo.mapper.CustomerUserDynamicCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDynamicCommentRepositoryImpl implements UserDynamicCommentRepository {
    @Autowired
    private CustomerUserDynamicCommentMapper dynamicCommentMapper;

    @Override
    public int create(CustomerUserDynamicComment customerUserDynamicComment) {
        return dynamicCommentMapper.insert(customerUserDynamicComment);
    }
}

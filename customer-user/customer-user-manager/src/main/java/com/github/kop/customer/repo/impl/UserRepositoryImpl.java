package com.github.kop.customer.repo.impl;

import com.github.kop.customer.module.entity.CustomerUser;
import com.github.kop.customer.repo.UserRepository;
import com.github.kop.customer.repo.mapper.CustomerUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private CustomerUserMapper userMapper;

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public int create(CustomerUser customerUser) {
        return userMapper.insert(customerUser);
    }

    @Override
    public CustomerUser byId(long userId) {
        return this.userMapper.selectById(userId);
    }

}

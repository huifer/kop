package com.github.kop.customer.service.impl;

import com.github.kop.customer.repo.UserBlackRepository;
import com.github.kop.customer.service.UserBlackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBlackServiceImpl implements UserBlackService {
    @Autowired
    private UserBlackRepository userBlackRepository;

    @Override
    public boolean add(long selfUserId, long opUserId) {
        return userBlackRepository.create(selfUserId, opUserId) > 0;
    }

    @Override
    public boolean remove(long selfUserId, long opUserId) {
        return userBlackRepository.delete(selfUserId, opUserId) > 0;

    }
}

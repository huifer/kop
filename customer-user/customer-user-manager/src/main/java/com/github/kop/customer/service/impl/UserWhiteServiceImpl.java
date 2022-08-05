package com.github.kop.customer.service.impl;

import com.github.kop.customer.repo.UserWhiteRepository;
import com.github.kop.customer.service.UserWhiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserWhiteServiceImpl implements UserWhiteService {
    @Autowired
    private UserWhiteRepository userWhiteRepository;

    @Override
    public boolean add(long selfUserId, long opUserId) {
        return userWhiteRepository.create(selfUserId, opUserId) > 0;
    }

    @Override
    public boolean remove(long selfUserId, long opUserId) {
        return userWhiteRepository.delete(selfUserId, opUserId) > 0;
    }

    @Override
    public List<Long> whiteIds(long userId) {
        return userWhiteRepository.whiteIds(userId);
    }

    @Override
    public boolean isFollow(long curUserId, Long targetUserId) {
     return    this.userWhiteRepository.exists(curUserId,targetUserId);
    }
}

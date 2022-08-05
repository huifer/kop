package com.github.kop.customer.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.kop.customer.module.entity.CustomerUserWhite;
import com.github.kop.customer.repo.UserWhiteRepository;
import com.github.kop.customer.repo.mapper.CustomerUserWhiteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserWhiteRepositoryImpl implements UserWhiteRepository {
    @Autowired
    private CustomerUserWhiteMapper userWhiteMapper;

    @Override
    public int create(long selfUserId, long opUserId) {
        CustomerUserWhite entity = new CustomerUserWhite();
        entity.setUserId(selfUserId);
        entity.setWhiteUserId(opUserId);
        return userWhiteMapper.insert(entity);
    }

    @Override
    public int delete(long selfUserId, long opUserId) {
        QueryWrapper<CustomerUserWhite> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(CustomerUserWhite::getUserId, selfUserId)
                .eq(CustomerUserWhite::getWhiteUserId, opUserId);
        return this.userWhiteMapper.delete(queryWrapper);
    }

    @Override
    public List<Long> whiteIds(long userId) {
        return userWhiteMapper.whiteIds(userId);
    }

    @Override
    public boolean exists(long curUserId, Long targetUserId) {
        QueryWrapper<CustomerUserWhite> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(CustomerUserWhite::getUserId, curUserId)
                .eq(CustomerUserWhite::getWhiteUserId, targetUserId);
        return this.userWhiteMapper.exists(queryWrapper);
    }
}

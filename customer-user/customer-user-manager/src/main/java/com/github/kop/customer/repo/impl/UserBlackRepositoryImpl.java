package com.github.kop.customer.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.kop.customer.module.entity.CustomerUserBlack;
import com.github.kop.customer.repo.UserBlackRepository;
import com.github.kop.customer.repo.mapper.CustomerUserBlackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBlackRepositoryImpl implements UserBlackRepository {
    @Autowired
    private CustomerUserBlackMapper userBlackMapper;

    @Override
    public int create(long selfUserId, long opUserId) {
        CustomerUserBlack entity = new CustomerUserBlack();
        entity.setUserId(selfUserId);
        entity.setBlackUserId(opUserId);
        return userBlackMapper.insert(entity);
    }

    @Override
    public int delete(long selfUserId, long opUserId) {
        QueryWrapper<CustomerUserBlack> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(CustomerUserBlack::getUserId, selfUserId).eq(CustomerUserBlack::getBlackUserId, opUserId);
        return userBlackMapper.delete(queryWrapper);
    }

    @Override
    public List<Long> blackIds(long userId) {
        return this.userBlackMapper.blackIds(userId);
    }

    @Override
    public boolean exists(long curUserId, Long targetUserId) {
        QueryWrapper<CustomerUserBlack> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(CustomerUserBlack::getUserId, curUserId).eq(CustomerUserBlack::getBlackUserId, targetUserId);
        return this.userBlackMapper.exists(queryWrapper);
    }
}

package com.github.kop.customer.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.kop.customer.module.entity.CustomerUserDynamic;
import com.github.kop.customer.repo.UserDynamicRepository;
import com.github.kop.customer.repo.mapper.CustomerUserDynamicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(rollbackFor = {Exception.class})
public class UserDynamicRepositoryImpl implements UserDynamicRepository {
    @Autowired
    private CustomerUserDynamicMapper userDynamicMapper;

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public int create(CustomerUserDynamic customerUserDynamic) {
        return userDynamicMapper.insert(customerUserDynamic);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public int delete(long id) {
        return userDynamicMapper.deleteById(id);
    }

    @Override
    public IPage<CustomerUserDynamic> page(long cur, long size, long userId) {
        QueryWrapper<CustomerUserDynamic> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(CustomerUserDynamic::getUserId, userId);
        return this.userDynamicMapper.selectPage(new Page<>(cur, size), queryWrapper);
    }
}


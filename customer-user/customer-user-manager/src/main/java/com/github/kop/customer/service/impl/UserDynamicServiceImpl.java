package com.github.kop.customer.service.impl;

import com.github.kop.customer.repo.UserDynamicRepository;
import com.github.kop.customer.service.UserDynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDynamicServiceImpl implements UserDynamicService {

    @Autowired
    private UserDynamicRepository userDynamicRepository;


    @Override
    public boolean create(long userId, String msg) {
        return false;
    }

    @Override
    public boolean remove(long id) {
        return false;
    }
}

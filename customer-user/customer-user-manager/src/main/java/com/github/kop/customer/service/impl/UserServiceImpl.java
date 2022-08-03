package com.github.kop.customer.service.impl;

import com.github.kop.customer.module.entity.CustomerUser;
import com.github.kop.customer.module.req.RegisterUserReq;
import com.github.kop.customer.module.res.RegisterUserRes;
import com.github.kop.customer.repo.UserRepository;
import com.github.kop.customer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean register(RegisterUserReq req) {
        CustomerUser customerUser = new CustomerUser();
        customerUser.setName(req.getName());
        customerUser.setPhone(req.getPhone());
        customerUser.setGrade(req.getGrade());
        customerUser.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes(StandardCharsets.UTF_8)));
        customerUser.setRegisterTime(LocalDateTime.now());

        return userRepository.create(customerUser) > 0;
    }

    @Override
    public RegisterUserRes userInfo(long userId) {
        CustomerUser customerUser = this.userRepository.byId(userId);
        if (customerUser != null) {
            RegisterUserRes registerUserRes = new RegisterUserRes();
            registerUserRes.setName(customerUser.getName());
            registerUserRes.setPhone(customerUser.getPhone());
            registerUserRes.setGrade(customerUser.getGrade());

            return registerUserRes;
        }
        return null;
    }

}

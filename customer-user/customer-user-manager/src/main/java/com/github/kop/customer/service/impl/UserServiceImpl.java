package com.github.kop.customer.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.customer.module.entity.CustomerUser;
import com.github.kop.customer.module.req.RegisterUserReq;
import com.github.kop.customer.module.res.UserInfoRes;
import com.github.kop.customer.repo.UserRepository;
import com.github.kop.customer.service.UserBlackService;
import com.github.kop.customer.service.UserService;
import com.github.kop.customer.service.UserWhiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;

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

    @Autowired
    private UserWhiteService userWhiteService;
    @Autowired
    private UserBlackService userBlackService;

    @Override
    public UserInfoRes userInfo(long userId) {
        CustomerUser customerUser = this.userRepository.byId(userId);
        if (customerUser != null) {
            return conv(customerUser);
        }
        return null;
    }

    private UserInfoRes conv(CustomerUser customerUser) {
        UserInfoRes registerUserRes = new UserInfoRes();
        registerUserRes.setUserId(customerUser.getId());
        registerUserRes.setName(customerUser.getName());
        registerUserRes.setPhone(customerUser.getPhone());
        registerUserRes.setGrade(customerUser.getGrade());

        return registerUserRes;
    }

    @Override
    public IPage<UserInfoRes> page(long cur, long size, long curUserId) {
        IPage<CustomerUser> customerUserIPage = this.userRepository.page(cur, size);
        return customerUserIPage.convert(new Function<CustomerUser, UserInfoRes>() {
            @Override
            public UserInfoRes apply(CustomerUser customerUser) {
                UserInfoRes conv = conv(customerUser);

                conv.setFollow(userWhiteService.isFollow(curUserId, customerUser.getId()));
                conv.setBlack(userBlackService.isBlack(curUserId, customerUser.getId()));
                return conv;
            }
        });
    }

    @Override
    public IPage<UserInfoRes> pageFromUserIds(long cur, long size, List<Long> uids) {
        IPage<CustomerUser> customerUserIPage = this.userRepository.page(cur, size, uids);
        return customerUserIPage.convert(this::conv);
    }
}

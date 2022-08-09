package com.github.kop.customer.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.customer.module.entity.CustomerUserDynamic;
import com.github.kop.customer.module.res.DynamicListRes;
import com.github.kop.customer.module.res.UserInfoRes;
import com.github.kop.customer.repo.UserDynamicRepository;
import com.github.kop.customer.service.UserDynamicService;
import com.github.kop.customer.service.UserService;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDynamicServiceImpl implements UserDynamicService {

  @Autowired private UserDynamicRepository userDynamicRepository;

  @Autowired private UserService userService;

  @Override
  public boolean create(long userId, String msg) {
    CustomerUserDynamic customerUserDynamic = new CustomerUserDynamic();
    customerUserDynamic.setCreateTime(LocalDateTime.now());
    customerUserDynamic.setUserId(userId);
    customerUserDynamic.setContent(msg);

    return userDynamicRepository.create(customerUserDynamic) > 0;
  }

  @Override
  public boolean remove(long id) {
    return this.userDynamicRepository.delete(id) > 0;
  }

  @Override
  public IPage<DynamicListRes> page(long cur, long size, long userId) {
    IPage<CustomerUserDynamic> customerUserDynamicIPage =
        this.userDynamicRepository.page(cur, size, userId);
    return customerUserDynamicIPage.convert(
        customerUserDynamic -> {
          DynamicListRes dynamicListRes = new DynamicListRes();
          UserInfoRes userInfoRes = userService.userInfo(customerUserDynamic.getUserId());
          if (userInfoRes != null) {
            dynamicListRes.setUserName(userInfoRes.getName());
          }

          dynamicListRes.setUserId(customerUserDynamic.getUserId());
          dynamicListRes.setMsg(customerUserDynamic.getContent());
          dynamicListRes.setPushTime(customerUserDynamic.getCreateTime());

          return dynamicListRes;
        });
  }
}

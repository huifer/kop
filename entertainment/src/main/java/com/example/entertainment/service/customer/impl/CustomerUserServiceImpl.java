package com.example.entertainment.service.customer.impl;

import com.example.entertainment.module.customer.req.user.CustomerLoginUserReq;
import com.example.entertainment.module.customer.req.user.CustomerRegisterUserReq;
import com.example.entertainment.module.customer.req.user.CustomerUpdateUserReq;
import com.example.entertainment.module.customer.req.user.CustomerUserVerifiedReq;
import com.example.entertainment.module.customer.resp.user.CustomerUserInfoResp;
import com.example.entertainment.module.entity.Users;
import com.example.entertainment.module.enums.UserRoleEnums;
import com.example.entertainment.repo.UserRepository;
import com.example.entertainment.service.common.TokenService;
import com.example.entertainment.service.common.UserInvitationCodeService;
import com.example.entertainment.service.common.UserPasswordService;
import com.example.entertainment.service.customer.CustomerUserService;
import java.util.UUID;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerUserServiceImpl implements CustomerUserService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private UserInvitationCodeService userInvitationCodeService;
  @Autowired
  private UserPasswordService userPasswordService;
  @Autowired
  private TokenService tokenService;

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public boolean register(CustomerRegisterUserReq req) {

    Users users = new Users();
    users.setMember(req.getPhone());
    users.setNickName(UUID.randomUUID().toString());
    users.setPhone(req.getPhone());
    if (req.getUuid() != null) {

      // 查询邀请用户
      Users upUser = userRepository.findByUuid(req.getUuid());
      if (upUser != null) {
        users.setParentPhone(upUser.getPhone());
        users.setParentMember(upUser.getId());

      }
    }

    users.setRoleId(UserRoleEnums.ACCOUNT.getCode());
    String salt = userPasswordService.genSalt();
    users.setPassword(userPasswordService.genPwd(req.getPassword(), salt));
    users.setSalt(salt);
    users.setUuid(userInvitationCodeService.generator());

    return userRepository.create(users) > 0;
  }

  @Override
  public CustomerUserInfoResp login(CustomerLoginUserReq req) {

    Users users = this.userRepository.findByPhone(req.getPhone());
    if (users == null) {
      throw new RuntimeException("用户不存在");
    }
    String salt = users.getSalt();
    if (this.userPasswordService.eq(req.getPassword(), users.getPassword(), salt)) {
      CustomerUserInfoResp customerUserInfoResp = new CustomerUserInfoResp();
      BeanUtils.copyProperties(users, customerUserInfoResp);
      customerUserInfoResp.setToken(this.tokenService.genToken(users.getId()));
      return customerUserInfoResp;
    } else {

      throw new RuntimeException("密码错误");
    }
  }

  @Override
  public CustomerUserInfoResp userInfo(String token) {
    int userId = this.tokenService.convUserId(token);
    Users users = this.userRepository.findById(userId);
    if (users != null) {
      CustomerUserInfoResp customerUserInfoResp = new CustomerUserInfoResp();
      BeanUtils.copyProperties(users, customerUserInfoResp);
      return customerUserInfoResp;
    }

    throw new RuntimeException("无用户信息");

  }

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public boolean author(CustomerUserVerifiedReq req) {
    return false;
  }

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public boolean update(String token, CustomerUpdateUserReq req) {
    int userId = this.tokenService.convUserId(token);
    Users users = this.userRepository.findById(userId);
    if (users != null) {
      users.setNickName(req.getNickName());
      users.setHeadImage(req.getHeadImage());
      users.setPassword(this.userPasswordService.genPwd(req.getPassword(), users.getSalt()));
      return this.userRepository.updateById(users) > 0 ;
    }
    return false;
  }
}

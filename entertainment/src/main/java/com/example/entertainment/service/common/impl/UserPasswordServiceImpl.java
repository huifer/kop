package com.example.entertainment.service.common.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import com.example.entertainment.service.common.UserPasswordService;
import org.springframework.stereotype.Service;

@Service
public class UserPasswordServiceImpl implements UserPasswordService {

  @Override
  public String genSalt() {
    return SecureUtil.md5(RandomUtil.randomStringUpper(10));
  }

  @Override
  public String genPwd(String pwd, String salt) {
    return SecureUtil.md5(pwd + salt);
  }

  @Override
  public boolean eq(String reqPwd, String dbPwd, String salt) {
    return SecureUtil.md5(reqPwd + salt).equals(dbPwd);
  }
}

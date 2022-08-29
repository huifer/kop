package com.example.entertainment.service.common.impl;

import cn.hutool.core.util.RandomUtil;
import com.example.entertainment.repo.UserRepository;
import com.example.entertainment.service.common.UserInvitationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInvitationCodeServiceImpl implements UserInvitationCodeService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public String generator() {
    String code = RandomUtil.randomStringUpper(5);

    while (true) {
      boolean b = userRepository.hasInvitationCode(code);
      if (!b) {
        break;
      } else {
        code = RandomUtil.randomStringUpper(5);

      }
    }

    return code;
  }
}

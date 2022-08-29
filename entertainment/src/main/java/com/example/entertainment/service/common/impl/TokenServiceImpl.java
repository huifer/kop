package com.example.entertainment.service.common.impl;

import com.example.entertainment.service.common.TokenService;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

  @Override
  public String genToken(int userId) {
    return String.valueOf(userId);
  }

  @Override
  public int convUserId(String token) {
    return Integer.valueOf(token);
  }
}

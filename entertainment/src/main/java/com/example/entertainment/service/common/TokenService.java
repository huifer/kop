package com.example.entertainment.service.common;

public interface TokenService {

  /**
   * 根据用户id生成token
   */
  String genToken(int userId);

  /**
   * 从token中获取用户id
   */
  int convUserId(String token);
}

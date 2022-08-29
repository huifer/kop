package com.example.entertainment.service.common;

public interface UserPasswordService {

  String genSalt();

  String genPwd(String pwd, String salt);

  /**
   * 对比密码
   * @param reqPwd 请求密码
   * @param dbPwd 数据库密码
   * @param salt 数据库盐
   */
  boolean eq(String reqPwd, String dbPwd, String salt);

}

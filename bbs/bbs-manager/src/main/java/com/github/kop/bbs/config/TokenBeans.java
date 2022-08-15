package com.github.kop.bbs.config;

import com.github.kop.bbs.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TokenBeans {

  @Value("${bbs.expireSec}")
  private long expireSec;

  @Value("${bbs.secret}")
  private String secret;

  @Bean
  public JwtTokenUtil jwtTokenUtil() {
    return new JwtTokenUtil(expireSec, secret);
  }
}

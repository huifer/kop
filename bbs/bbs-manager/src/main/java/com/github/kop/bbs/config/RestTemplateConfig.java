package com.github.kop.bbs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/31 23:05
 */
@Configuration
public class RestTemplateConfig {

  @Bean
  public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
    return new RestTemplate(factory);
  }

  @Bean
  public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
    SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
    factory.setReadTimeout(150000); // ms
    factory.setConnectTimeout(150000); // ms
    return factory;
  }
}

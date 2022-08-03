package com.github.kop.customer.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CtxUtil implements ApplicationContextAware {
  public static ApplicationContext applicationContext;

  public static <T> T get(Class<T> clazz) {
    return applicationContext.getBean(clazz);
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }
}

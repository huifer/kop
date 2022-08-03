package com.github.kop.customer.beans;

import com.github.kop.customer.service.DatabaseService;
import com.github.kop.customer.service.impl.DatabaseServiceImpl;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@Order(value = 1)
public class ShardingJdbcBeans {

  @Bean
  public DatabaseService d(@Autowired DataSource dataSource) {

    return new DatabaseServiceImpl(dataSource);
  }
}

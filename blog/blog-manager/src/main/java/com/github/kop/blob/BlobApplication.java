package com.github.kop.blob;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/7/31 15:11
 */
@SpringBootApplication(scanBasePackages = {"com.github.kop.blob"})
@EnableTransactionManagement
@MapperScan(basePackages = {"com.github.kop.blob.repo.mapper"})
public class BlobApplication {

  private static final Logger logger = LoggerFactory.getLogger(BlobApplication.class);

  public static void main(String[] args) {
    ConfigurableApplicationContext run = SpringApplication.run(BlobApplication.class, args);
    logger.info("blog项目启动成功");
  }
}

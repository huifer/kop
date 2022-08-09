package com.github.kop.bbs;

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
 * @time 2022/8/8 21:38
 */
@SpringBootApplication(scanBasePackages = {"com.github.kop.bbs"})
@EnableTransactionManagement
@MapperScan(basePackages = {"com.github.kop.bbs.repo.mapper"})
public class BbsApplication {

  private static final Logger logger = LoggerFactory.getLogger(BbsApplication.class);

  public static void main(String[] args) {
    ConfigurableApplicationContext run = SpringApplication.run(BbsApplication.class, args);
    logger.info("bbs项目启动成功");
    logger.info("  _                   _      _          \n" +
            " | |                 | |    | |         \n" +
            " | | __ ___   _ __   | |__  | |__   ___ \n" +
            " | |/ // _ \\ | '_ \\  | '_ \\ | '_ \\ / __|\n" +
            " |   <| (_) || |_) | | |_) || |_) |\\__ \\\n" +
            " |_|\\_\\\\___/ | .__/  |_.__/ |_.__/ |___/\n" +
            "             | |                        \n" +
            "             |_|                        ");
  }
}

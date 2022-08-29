package com.example.entertainment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.entertainment.repo.mapper")
public class EntertainmentApplication {

  public static void main(String[] args) {
    SpringApplication.run(EntertainmentApplication.class, args);
  }

}

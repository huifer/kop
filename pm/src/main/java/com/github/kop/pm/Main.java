package com.github.kop.pm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EntityScan(basePackages = {"com.github.kop.pm.module"})
@EnableJpaRepositories
public class Main {

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }


}

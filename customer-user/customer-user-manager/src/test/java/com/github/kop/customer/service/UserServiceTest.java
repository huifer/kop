package com.github.kop.customer.service;

import static org.junit.jupiter.api.Assertions.*;

import com.github.kop.customer.UserApp;
import com.github.kop.customer.module.req.RegisterUserReq;
import com.github.kop.customer.module.res.UserInfoRes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {UserApp.class})
class UserServiceTest {

  @Autowired private UserService userService;

  @Test
  void register() {
    RegisterUserReq req = new RegisterUserReq();
    req.setName("admin");
    req.setPhone("123");
    req.setGrade(0);
    req.setPassword("admin");

    boolean register = userService.register(req);
    assertTrue(register);
  }

  @Test
  void userInfo() {
    UserInfoRes registerUserRes = this.userService.userInfo(1554755298906869761L);
    System.out.println();
  }
}

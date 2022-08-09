package com.github.kop.customer.service;

import com.github.kop.customer.UserApp;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {UserApp.class})
class UserBlackServiceTest {
  @Autowired private UserBlackService userBlackService;

  @Test
  void add() {
    for (int i = 0; i < 10; i++) {

      userBlackService.add(1, i + 1);
    }
  }

  @Test
  void remove() {}

  @Test
  void blackIds() {
    List<Long> longs = userBlackService.blackIds(1);
    System.out.println(longs);
  }
}

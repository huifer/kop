package com.github.kop.customer.repo.mapper;

import com.github.kop.customer.UserApp;
import com.github.kop.customer.module.entity.CustomerUser;
import com.github.kop.customer.module.entity.CustomerUserBlack;
import com.github.kop.customer.module.entity.CustomerUserDynamic;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {UserApp.class})
class CustomerUserMapperTest {
  @Autowired private CustomerUserMapper userMapper;
  @Autowired private CustomerUserDynamicMapper customerUserDynamicMapper;
  @Autowired private CustomerUserBlackMapper userBlackMapper;

  @Test
  void d() {
    for (int i = 0; i < 10; i++) {

      CustomerUserBlack entity = new CustomerUserBlack();
      entity.setUserId(1L);
      entity.setBlackUserId(0L);

      userBlackMapper.insert(entity);
    }
  }

  @Test
  void i() {
    CustomerUserDynamic entity = new CustomerUserDynamic();
    entity.setId(0L);
    entity.setCreateTime(LocalDateTime.now());
    entity.setDeleted(0);
    entity.setUserId(0L);
    entity.setContent("");

    customerUserDynamicMapper.insert(entity);
  }

  @Test
  void insert() {

    for (int i = 0; i < 10; i++) {

      CustomerUser entity = new CustomerUser();
      entity.setName("user-" + i);

      userMapper.insert(entity);
    }
  }
}

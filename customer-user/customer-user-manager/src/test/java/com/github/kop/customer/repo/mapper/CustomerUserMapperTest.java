package com.github.kop.customer.repo.mapper;

import com.github.kop.customer.UserApp;
import com.github.kop.customer.module.entity.CustomerUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {UserApp.class})
class CustomerUserMapperTest {
    @Autowired
    private CustomerUserMapper userMapper;

    @Test
    void insert() {

        for (int i = 0; i < 10; i++) {

            CustomerUser entity = new CustomerUser();
            entity.setName("user-" + i);

            userMapper.insert(entity);
        }
    }

}
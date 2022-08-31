package com.github.kop.rbac.service;

import com.github.kop.rbac.RbacApplication;
import com.github.kop.rbac.module.req.user.CreateUserReq;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {RbacApplication.class})
public class UserServlceTest {

    @Autowired private UserService userService;

    @org.junit.jupiter.api.Test
    void createUser(){
        CreateUserReq createUserReq=new CreateUserReq();
        createUserReq.setCompanyId(1564898952862621698L);
        createUserReq.setName("xiezhihao1@qq.com");
        createUserReq.setPassword("zhihaoAKB48");
        createUserReq.setPhone("12356555");
         int i = userService.createUser(createUserReq);


        Assertions.assertTrue(i > 0);
    }

    @org.junit.jupiter.api.Test
    void byId() {}
}

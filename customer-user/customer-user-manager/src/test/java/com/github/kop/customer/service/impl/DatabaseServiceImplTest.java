package com.github.kop.customer.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import com.github.kop.customer.UserApp;
import com.github.kop.customer.service.DatabaseService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {UserApp.class})
class DatabaseServiceImplTest {
  @Autowired private DatabaseService databaseService;

  @Test
  void tables() {
    List<String> tables = databaseService.tables(null);
    String customer_user = databaseService.getCreateTableSql("customer_user");
  }

  @Test
  void getCreateTableSql() {}
}

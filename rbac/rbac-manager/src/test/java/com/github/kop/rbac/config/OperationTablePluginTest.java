package com.github.kop.rbac.config;

import com.github.kop.plugin.otp.CrudTemplate;
import com.github.kop.rbac.RbacApplication;
import com.github.kop.rbac.module.entity.RbacCompany;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {RbacApplication.class})
class OperationTablePluginTest {

  @Autowired private CrudTemplate crudTemplate;

  @Test
  void crudTemplate() throws ReflectiveOperationException {
    RbacCompany data = new RbacCompany();
    data.setName("1");
    data.setAddress("1");
    data.setSocialCreditCode("1");
    Long aLong = crudTemplate.create(data);
    RbacCompany company = crudTemplate.byId(aLong, RbacCompany.class);
    company.setName("update");
    crudTemplate.update(company);
    crudTemplate.delete(company.getId(), RbacCompany.class);
  }
}

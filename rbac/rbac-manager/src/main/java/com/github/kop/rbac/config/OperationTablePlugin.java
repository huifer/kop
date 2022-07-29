package com.github.kop.rbac.config;

import com.github.kop.plugin.otp.CrudTemplate;
import com.github.kop.rbac.module.entity.RbacCompany;
import com.github.kop.rbac.repo.mapper.RbacCompanyMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OperationTablePlugin {

  @Bean
  public CrudTemplate crudTemplate(@Autowired SqlSession sqlSession) {
    CrudTemplate crudTemplate =
        new CrudTemplate("insert", "updateById", "selectById", "deleteById", sqlSession);
    crudTemplate.put(RbacCompany.class, RbacCompanyMapper.class);
    return crudTemplate;
  }
}

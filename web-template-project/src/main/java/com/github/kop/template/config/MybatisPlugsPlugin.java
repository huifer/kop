package com.github.kop.template.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.github.kop.rbac.utils.UserInfoThread;
import java.time.LocalDateTime;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MybatisPlugsPlugin implements MetaObjectHandler {
  @Bean
  public MybatisPlusInterceptor mybatisPlusInterceptor() {
    MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
    interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
    interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
    return interceptor;
  }

  // MP添加时执行
  @Override
  public void insertFill(MetaObject metaObject) {
    // 根据名称设置属性值
    this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
    this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
    this.setFieldValByName("createUserId", UserInfoThread.getUserId(), metaObject);
    this.setFieldValByName("updateUserId", UserInfoThread.getUserId(), metaObject);
  }

  // MP修改时执行
  @Override
  public void updateFill(MetaObject metaObject) {
    this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
    this.setFieldValByName("updateUserId", UserInfoThread.getUserId(), metaObject);
  }
}

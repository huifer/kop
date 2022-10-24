package com.github.kop.bbs.aop.role;

import com.github.kop.bbs.module.enums.role.RoleEnum;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.web.bind.annotation.Mapping;

/** 管理端API标注 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface RoleApi {

  /** 需要拥有的角色 */
  RoleEnum[] roles();
}

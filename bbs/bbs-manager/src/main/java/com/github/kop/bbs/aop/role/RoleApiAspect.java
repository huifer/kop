package com.github.kop.bbs.aop.role;

import com.github.kop.bbs.service.role.RoleService;
import com.github.kop.bbs.service.user.UserService;
import com.github.kop.bbs.utils.UserInfoThread;
import java.lang.reflect.Method;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RoleApiAspect {

  @Autowired
  private UserService userService;

  public static void main(String[] args) {
    RoleApi annotation = AnnotationUtils.findAnnotation(C.class, RoleApi.class);
  }

  @Pointcut("@annotation(com.github.kop.bbs.aop.role.RoleApi)")
  public void pointFn() {

  }

  @Around("pointFn()")
  public Object check(ProceedingJoinPoint joinPoint) throws Throwable {

    // 定位类
    Object target = joinPoint.getTarget();
    MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
    // 定位方法
    Method method = methodSignature.getMethod();
    RoleApi roleApi = null;

    roleApi = AnnotationUtils.findAnnotation(target.getClass(), RoleApi.class);
    if (roleApi == null) {
      roleApi = AnnotationUtils.findAnnotation(method, RoleApi.class);

    }
    if (roleApi != null) {
      boolean b = userService.hasRoles(UserInfoThread.getUserId(), roleApi.roles());
    }

    Object object = joinPoint.proceed();
    return object;
  }

}

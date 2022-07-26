package com.github.kop.rbac.utils;

/** 用户相关线程对象 */
public class UserInfoThread {
  private static final ThreadLocal<Long> threadUserId = new InheritableThreadLocal<>();

  public static Long getUserId() {
    return threadUserId.get();
  }

  public static void setUserId(Long userId) {
    threadUserId.remove();
    threadUserId.set(userId);
  }
}

package com.github.kop.template.utils;

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

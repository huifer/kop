package com.github.kop.bbs.utils;

/** 用户相关线程对象 */
public class UserInfoThread {

  private static final ThreadLocal<Long> threadUserId = new InheritableThreadLocal<>();

  private static final ThreadLocal<String> thread_ip = new InheritableThreadLocal<>();

  public static String getIp() {
    return thread_ip.get();
  }

  public static void setIp(String ip) {
    thread_ip.remove();
    thread_ip.set(ip);
  }

  public static Long getUserId() {
    return threadUserId.get();
  }

  public static void setUserId(Long userId) {
    threadUserId.remove();
    threadUserId.set(userId);
  }
}

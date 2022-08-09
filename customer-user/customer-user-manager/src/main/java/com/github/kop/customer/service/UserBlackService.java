package com.github.kop.customer.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.customer.module.res.UserInfoRes;
import java.util.List;

public interface UserBlackService {
  /**
   * 添加黑名单
   *
   * @param selfUserId 当前人
   * @param opUserId 操作目标
   */
  boolean add(long selfUserId, long opUserId);
  /**
   * 移除黑名单
   *
   * @param selfUserId 当前人
   * @param opUserId 操作目标
   */
  boolean remove(long selfUserId, long opUserId);

  /** 根据用户id查询黑名单用户id */
  List<Long> blackIds(long userId);

  /**
   * 是否拉黑
   *
   * @param curUserId 当前人
   * @param targetUserId 勘测目标人
   */
  boolean isBlack(long curUserId, Long targetUserId);

  /** 黑名单列表 */
  IPage<UserInfoRes> blackList(long userId, long cur, long size);
}

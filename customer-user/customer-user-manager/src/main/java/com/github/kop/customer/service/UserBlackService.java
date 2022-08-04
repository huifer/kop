package com.github.kop.customer.service;

import java.util.List;

public interface UserBlackService {
    /**
     * 添加黑名单
     * @param selfUserId 当前人
     * @param opUserId 操作目标
     */
    boolean add(long selfUserId, long opUserId);
    /**
     * 移除黑名单
     * @param selfUserId 当前人
     * @param opUserId 操作目标
     */
    boolean remove(long selfUserId, long opUserId);

    /**
     * 根据用户id查询黑名单用户id
     */
    List<Long> blackIds(long userId);
}

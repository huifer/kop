package com.github.kop.customer.service;

public interface UserWhiteService {
    /**
     * 添加关注
     * @param selfUserId 当前人
     * @param opUserId 操作目标
     */
    boolean add(long selfUserId, long opUserId);
    /**
     * 移除关注
     * @param selfUserId 当前人
     * @param opUserId 操作目标
     */
    boolean remove(long selfUserId, long opUserId);
}

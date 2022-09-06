package com.github.kop.bbs.repo;

import com.github.kop.bbs.module.entity.AppealReceipt;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/9/5 22:49
 */
public interface AppealReceiptRepository {
    AppealReceipt findById(Long appealReceiptId);

    int create(AppealReceipt build);

    AppealReceipt findByOrderAndAppealId(int order, Long appealId);

    /**
     * 获取最新的回复
     * @param appealId
     * @return
     */
    AppealReceipt getLastReply(Long appealId);

    void updateManagerContent(Long appealReceiptId, String content);

    void updateCustomerContent(Long appealReceiptId, String content);
}

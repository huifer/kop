package com.github.kop.bbs.service.appeal;

import com.github.kop.bbs.module.req.appeal.ReplyAppealReq;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/9/5 22:48
 */
public interface AppealReceiptService {

    Boolean managerReplyAppeal(Long appealId, Long appealReceiptId, ReplyAppealReq req);

    Boolean customerReplyAppeal(Long appealId, Long appealReceiptId, ReplyAppealReq req);
}

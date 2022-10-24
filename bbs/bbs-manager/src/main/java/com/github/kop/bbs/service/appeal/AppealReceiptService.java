package com.github.kop.bbs.service.appeal;

import com.github.kop.bbs.module.req.appeal.ReplyAppealReq;
import com.github.kop.bbs.module.res.appeal.AppealReceiptResp;
import java.util.List;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/9/5 22:48
 */
public interface AppealReceiptService {

  Boolean managerReplyAppeal(Long appealId, Long appealReceiptId, ReplyAppealReq req);

  Boolean customerReplyAppeal(Long appealId, Long appealReceiptId, ReplyAppealReq req);

  /**
   * 申诉回执列表
   *
   * @param appealId
   * @return
   */
  List<AppealReceiptResp> receiptList(Long appealId);
}

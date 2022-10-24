package com.github.kop.bbs.service.appeal.impl;

import com.github.kop.bbs.event.appeal.CustomerAppealReplyEvent;
import com.github.kop.bbs.module.bo.CustomerAppealReplyBo;
import com.github.kop.bbs.module.entity.Appeal;
import com.github.kop.bbs.module.entity.AppealReceipt;
import com.github.kop.bbs.module.ex.NoceException;
import com.github.kop.bbs.module.req.appeal.ReplyAppealReq;
import com.github.kop.bbs.module.res.appeal.AppealReceiptResp;
import com.github.kop.bbs.repo.AppealReceiptRepository;
import com.github.kop.bbs.service.appeal.AppealReceiptService;
import com.github.kop.bbs.service.appeal.AppealService;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/9/5 22:48
 */
@Service
public class AppealReceiptImpl implements AppealReceiptService {

  @Resource private AppealService appealService;

  @Resource private AppealReceiptRepository appealReceiptRepository;

  @Resource private ApplicationEventPublisher applicationEventPublisher;

  /**
   * 管理员回复申诉
   *
   * @param appealId
   * @param appealReceiptId
   * @param req
   * @return
   */
  @Transactional(rollbackFor = Exception.class)
  @Override
  public Boolean managerReplyAppeal(Long appealId, Long appealReceiptId, ReplyAppealReq req) {
    Appeal appeal = appealService.findById(appealId);
    if (ObjectUtils.isEmpty(appeal)) {
      throw new NoceException("申诉不存在");
    }
    // 有回复流程主键表示正在进行中,没有就新建一个
    if (ObjectUtils.isNotEmpty(appealReceiptId)) {
      AppealReceipt appealReceipt = appealReceiptRepository.findById(appealReceiptId);
      if (ObjectUtils.isEmpty(appealReceipt)) throw new NoceException("当前流程不存在");
      appealReceiptRepository.updateManagerContent(appealReceiptId, req.getContent());
    } else {
      AppealReceipt lastReply = appealReceiptRepository.getLastReply(appealId);
      int order = ObjectUtils.isEmpty(lastReply) ? 1 : lastReply.getOrder() + 1;
      AppealReceipt appealReceipt = appealReceiptRepository.findByOrderAndAppealId(order, appealId);
      if (ObjectUtils.isNotEmpty(appealReceipt)) {
        throw new NoceException("当前申诉已被回复");
      }
      appealReceiptRepository.create(
          AppealReceipt.builder()
              .appealId(appealId)
              .order(order)
              .appealOfficialReply(req.getContent())
              .build());
    }

    applicationEventPublisher.publishEvent(
        new CustomerAppealReplyEvent(
            CustomerAppealReplyBo.builder()
                .appealReceiptId(appealReceiptId)
                .userId(appeal.getAppealUserId())
                .build()));
    return true;
  }

  @Override
  public Boolean customerReplyAppeal(Long appealId, Long appealReceiptId, ReplyAppealReq req) {
    Appeal appeal = appealService.findById(appealId);
    if (ObjectUtils.isEmpty(appeal)) {
      throw new NoceException("申诉不存在");
    }
    if (ObjectUtils.isEmpty(appealReceiptId)) {
      throw new NoceException("当前流程不存在");
    }
    AppealReceipt appealReceipt = appealReceiptRepository.findById(appealReceiptId);
    if (ObjectUtils.isEmpty(appealReceipt)) throw new NoceException("当前流程不存在");
    AppealReceipt appealReceiptVerify = appealReceiptRepository.verifyCustomer(appealReceiptId);
    if (ObjectUtils.isNotEmpty(appealReceiptVerify)) {
      throw new NoceException("当前流程已经回复");
    }
    appealReceiptRepository.updateCustomerContent(appealReceiptId, req.getContent());
    return null;
  }

  /**
   * 申诉回执列表
   *
   * @param appealId
   * @return
   */
  @Override
  public List<AppealReceiptResp> receiptList(Long appealId) {
    List<AppealReceipt> appealReceiptList = appealReceiptRepository.findByAppealId(appealId);
    return appealReceiptList
        .stream()
        .map(
            v ->
                AppealReceiptResp.builder()
                    .appealUserReply(v.getAppealUserReply())
                    .appealId(v.getAppealId())
                    .order(v.getOrder())
                    .appealOfficialReply(v.getAppealOfficialReply())
                    .appealUserReply(v.getAppealUserReply())
                    .updateTime(v.getUpdateTime())
                    .build())
        .collect(Collectors.toList());
  }
}

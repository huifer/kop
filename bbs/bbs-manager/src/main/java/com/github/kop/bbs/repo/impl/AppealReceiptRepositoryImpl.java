package com.github.kop.bbs.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.kop.bbs.module.entity.AppealReceipt;
import com.github.kop.bbs.repo.AppealReceiptRepository;
import com.github.kop.bbs.repo.mapper.AppealReceiptMapper;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Repository;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/9/5 22:49
 */
@Repository
public class AppealReceiptRepositoryImpl implements AppealReceiptRepository {

  @Resource private AppealReceiptMapper appealReceiptMapper;

  @Override
  public AppealReceipt findById(Long appealReceiptId) {
    return appealReceiptMapper.selectById(appealReceiptId);
  }

  @Override
  public int create(AppealReceipt build) {
    AppealReceipt byOrderAndAppealId =
        findByOrderAndAppealId(build.getOrder(), build.getAppealId());
    if (ObjectUtils.isNotEmpty(byOrderAndAppealId)) {
      throw new NullPointerException("当前流程已经被回复");
    }
    return appealReceiptMapper.insert(build);
  }

  @Override
  public AppealReceipt findByOrderAndAppealId(int order, Long appealId) {
    QueryWrapper<AppealReceipt> queryWrapper = new QueryWrapper<>();
    queryWrapper
        .lambda()
        .eq(AppealReceipt::getAppealId, appealId)
        .eq(AppealReceipt::getOrder, order);
    return appealReceiptMapper.selectOne(queryWrapper);
  }

  /**
   * 获取最新的回复
   *
   * @param appealId
   * @return
   */
  @Override
  public AppealReceipt getLastReply(Long appealId) {
    return appealReceiptMapper.getLastReply(appealId);
  }

  @Override
  public void updateManagerContent(Long appealReceiptId, String content) {
    UpdateWrapper<AppealReceipt> updateWrapper = new UpdateWrapper<>();
    updateWrapper.lambda().eq(AppealReceipt::getAppealReceiptId, appealReceiptId);
    appealReceiptMapper.update(
        AppealReceipt.builder().appealOfficialReply(content).build(), updateWrapper);
  }

  @Override
  public void updateCustomerContent(Long appealReceiptId, String content) {
    UpdateWrapper<AppealReceipt> updateWrapper = new UpdateWrapper<>();
    updateWrapper.lambda().eq(AppealReceipt::getAppealReceiptId, appealReceiptId);
    appealReceiptMapper.update(
        AppealReceipt.builder().appealUserReply(content).build(), updateWrapper);
  }

  @Override
  public List<AppealReceipt> findByAppealId(Long appealId) {
    QueryWrapper<AppealReceipt> queryWrapper = new QueryWrapper<>();
    queryWrapper
        .lambda()
        .eq(AppealReceipt::getAppealId, appealId)
        .orderByDesc(AppealReceipt::getOrder);
    return appealReceiptMapper.selectList(queryWrapper);
  }

  @Override
  public AppealReceipt verifyCustomer(Long appealReceiptId) {
    QueryWrapper<AppealReceipt> queryWrapper = new QueryWrapper<>();
    queryWrapper
        .lambda()
        .eq(AppealReceipt::getAppealReceiptId, appealReceiptId)
        .isNotNull(AppealReceipt::getAppealUserReply);
    return appealReceiptMapper.selectOne(queryWrapper);
  }
}

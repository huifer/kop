package com.github.kop.bbs.service.category.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.entity.UserCategoryVoteSetting;
import com.github.kop.bbs.module.enums.DeletedEnum;
import com.github.kop.bbs.module.ex.NoceException;
import com.github.kop.bbs.module.ex.ValidateException;
import com.github.kop.bbs.module.req.category.UserCategoryVoteSettingReq;
import com.github.kop.bbs.module.req.category.voteSettingListReq;
import com.github.kop.bbs.module.res.category.customer.CustomerUserCategoryVoteSettingRes;
import com.github.kop.bbs.module.res.category.manager.VoteSettingListRes;
import com.github.kop.bbs.repo.UserCategoryVoteSettingRepository;
import com.github.kop.bbs.service.category.UserCategoryVoteSettingService;
import com.github.kop.bbs.utils.CreateValidate;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserCategoryVoteSettingServiceImpl implements UserCategoryVoteSettingService {

  private VoteSettingAndUpdateValidate voteSettingAndUpdateValidate =
      new VoteSettingAndUpdateValidate();

  @Resource private UserCategoryVoteSettingRepository userCategoryVoteSettingRepository;

  @Override
  public UserCategoryVoteSetting verifyByVoteId(Long voteSettingId) {
    UserCategoryVoteSetting categoryVoteSetting =
        userCategoryVoteSettingRepository.findById(voteSettingId);
    if (ObjectUtils.isEmpty(categoryVoteSetting)) {
      throw new NoceException("该投票不存在!");
    }
    LocalDateTime now = LocalDateTime.now();
    if (categoryVoteSetting.getApplyStartTime().isBefore(now)) {
      throw new NoceException("申请时间还没到!");
    }
    // 申请时间结束了
    if (categoryVoteSetting.getApplyEndTime().isAfter(now)) {
      throw new NoceException("申请时间已过!");
    }
    // 申请人数已满
    if (categoryVoteSetting.getApplicationCount() > 0
        && Objects.equals(
            categoryVoteSetting.getAlreadyCount(), categoryVoteSetting.getApplicationCount())) {
      throw new NoceException("申请人数已满!");
    }
    return categoryVoteSetting;
  }

  @Override
  public void verifyTicketTime(Long voteSettingId) {
    UserCategoryVoteSetting categoryVoteSetting =
        userCategoryVoteSettingRepository.findById(voteSettingId);
    if (ObjectUtils.isEmpty(categoryVoteSetting)) {
      throw new NoceException("该投票不存在!");
    }
    LocalDateTime now = LocalDateTime.now();
    // 申请时间结束了
    if (categoryVoteSetting.getVoteStartTime().isBefore(now)) {
      throw new NoceException("投票还未开始!");
    }
    if (categoryVoteSetting.getVoteStartTime().isAfter(now)) {
      throw new NoceException("投票已经结束了!");
    }
  }

  @Override
  public void updateApplyCount(Long voteSettingId) {
    userCategoryVoteSettingRepository.updateApplyCount(voteSettingId);
  }

  @Override
  public IPage<VoteSettingListRes> voteSettingList(
      voteSettingListReq req, Integer page, Integer pageSize) {
    if (ObjectUtils.isEmpty(req.getOrderType())) {
      req.setOrderType(voteSettingListReq.voteSettingListOrderType.APPLY_TIME.getCode());
    }
    IPage<UserCategoryVoteSetting> pageData =
        userCategoryVoteSettingRepository.voteSettingList(
            req.getCategoryId(), req.getOrderType(), page, pageSize);
    return pageData.convert(this::entity2voteSettingListRes);
  }

  private VoteSettingListRes entity2voteSettingListRes(UserCategoryVoteSetting item) {
    VoteSettingListRes voteSettingListRes = new VoteSettingListRes();
    voteSettingListRes.setCategoryId(item.getCategoryId());
    voteSettingListRes.setApplicationCount(
        item.getApplicationCount() == 0 ? "不限制" : item.getApplicationCount() + "人");
    voteSettingListRes.setAlreadyCount(item.getAlreadyCount());
    voteSettingListRes.setApplyStartTime(item.getApplyStartTime());
    voteSettingListRes.setApplyEndTime(item.getApplyEndTime());
    voteSettingListRes.setVoteStartTime(item.getVoteStartTime());
    voteSettingListRes.setVoteEndTime(item.getVoteEndTime());
    return voteSettingListRes;
  }

  @Override
  public UserCategoryVoteSetting findVoteStartSetting(Long categoryId) {
    return userCategoryVoteSettingRepository.findVoteStartSetting(categoryId);
  }

  @Override
  public UserCategoryVoteSetting findApplyStartSetting(Long categoryId) {
    return userCategoryVoteSettingRepository.findApplyStartSetting(categoryId);
  }

  @Override
  public CustomerUserCategoryVoteSettingRes getApplyStartSetting(Long categoryId) {
    UserCategoryVoteSetting startSetting = findApplyStartSetting(categoryId);
    return entity2CustomerUserCategoryVoteSettingRes(startSetting);
  }

  private CustomerUserCategoryVoteSettingRes entity2CustomerUserCategoryVoteSettingRes(
      UserCategoryVoteSetting userCategoryVoteSetting) {
    if (ObjectUtils.isEmpty(userCategoryVoteSetting)) {
      return null;
    }
    CustomerUserCategoryVoteSettingRes res = new CustomerUserCategoryVoteSettingRes();
    res.setCategoryId(userCategoryVoteSetting.getCategoryId());
    res.setApplicationCount(
        userCategoryVoteSetting.getApplicationCount() == 0
            ? "不限制"
            : userCategoryVoteSetting.getApplicationCount() + "人");
    res.setAlreadyCount(userCategoryVoteSetting.getAlreadyCount());
    res.setApplyStartTime(userCategoryVoteSetting.getApplyStartTime());
    res.setApplyEndTime(userCategoryVoteSetting.getApplyEndTime());
    res.setVoteStartTime(userCategoryVoteSetting.getVoteStartTime());
    res.setVoteEndTime(userCategoryVoteSetting.getVoteEndTime());
    return res;
  }

  /**
   * 创建版主投票
   *
   * @param req
   * @return
   */
  @Override
  @Transactional(rollbackFor = Exception.class)
  public Boolean create(UserCategoryVoteSettingReq req) {
    UserCategoryVoteSetting startSetting = findVoteStartSetting(req.getCategoryId());
    if (ObjectUtils.isNotEmpty(startSetting)) {
      throw new NoceException("当前版块有正在进行中的投票!");
    }
    voteSettingAndUpdateValidate.createValidate(req);
    return userCategoryVoteSettingRepository.insert(
            UserCategoryVoteSetting.builder()
                .categoryId(req.getCategoryId())
                .applicationCount(req.getApplicationCount())
                .alreadyCount(0L)
                .applyStartTime(req.getApplyStartTime())
                .applyEndTime(req.getApplyEndTime())
                .voteStartTime(req.getVoteStartTime())
                .voteEndTime(req.getVoteEndTime())
                .deleted(DeletedEnum.FALSE.getCode())
                .build())
        > 0;
  }

  protected class VoteSettingAndUpdateValidate
      implements CreateValidate<UserCategoryVoteSettingReq> {

    @Override
    public void createValidate(UserCategoryVoteSettingReq req) throws ValidateException {
      if (ObjectUtils.isEmpty(req.getCategoryId())) {
        throw new ValidateException("版块id不能为空");
      }
      if (ObjectUtils.isEmpty(req.getApplicationCount())) {
        throw new ValidateException("申请人数限制不能为空");
      }
      if (ObjectUtils.isEmpty(req.getApplyStartTime())) {
        throw new ValidateException("申请开始时间不能为空");
      }
      if (LocalDateTime.now().isAfter(req.getApplyStartTime())) {
        throw new ValidateException("申请时间需大于当前时间");
      }
      if (ObjectUtils.isEmpty(req.getApplyEndTime())) {
        throw new ValidateException("申请结束时间不能为空");
      }
      if (req.getApplyEndTime().isAfter(req.getApplyStartTime())) {
        throw new ValidateException("申请结束时间需大于开始时间");
      }
      if (ObjectUtils.isEmpty(req.getVoteStartTime())) {
        throw new ValidateException("投票开始时间不能为空");
      }
      if (req.getVoteStartTime().isAfter(req.getApplyEndTime())) {
        throw new ValidateException("投票开始时间需大于申请结束时间");
      }
      if (ObjectUtils.isEmpty(req.getVoteEndTime())) {
        throw new ValidateException("投票结束时间不能为空");
      }
      if (req.getVoteEndTime().isAfter(req.getVoteStartTime())) {
        throw new ValidateException("投票结束时间需大于开始时间");
      }
    }
  }
}

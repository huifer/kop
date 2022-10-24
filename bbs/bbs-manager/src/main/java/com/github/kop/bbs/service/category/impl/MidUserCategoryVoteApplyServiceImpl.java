package com.github.kop.bbs.service.category.impl;

import com.github.kop.bbs.module.entity.MidUserCategoryVoteApply;
import com.github.kop.bbs.module.entity.User;
import com.github.kop.bbs.module.entity.UserCategoryVoteSetting;
import com.github.kop.bbs.module.entity.VoteTicketCount;
import com.github.kop.bbs.module.enums.DeletedEnum;
import com.github.kop.bbs.module.ex.NoceException;
import com.github.kop.bbs.module.res.category.customer.CategoryVoteListRes;
import com.github.kop.bbs.repo.MidUserCategoryVoteApplyRepository;
import com.github.kop.bbs.repo.VoteTicketCountRepository;
import com.github.kop.bbs.service.category.MidUserCategoryVoteApplyService;
import com.github.kop.bbs.service.category.UserCategoryVoteSettingService;
import com.github.kop.bbs.service.category.VoteTicketLogService;
import com.github.kop.bbs.service.user.UserService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/28 21:53
 */
@Service
public class MidUserCategoryVoteApplyServiceImpl implements MidUserCategoryVoteApplyService {

  @Resource private MidUserCategoryVoteApplyRepository midUserCategoryVoteApplyRepository;

  @Resource private UserCategoryVoteSettingService userCategoryVoteSettingService;

  @Resource private VoteTicketCountRepository voteTicketCountRepository;

  @Resource private UserService userService;

  @Resource private VoteTicketLogService voteTicketLogService;

  @Override
  @Transactional(rollbackFor = Exception.class)
  public boolean applyVote(Long voteSettingId, Long userId) {
    UserCategoryVoteSetting userCategoryVoteSetting =
        userCategoryVoteSettingService.verifyByVoteId(voteSettingId);
    // 插入投票记录
    MidUserCategoryVoteApply midUserCategoryVoteApply =
        MidUserCategoryVoteApply.builder()
            .voteSettingId(voteSettingId)
            .categoryId(userCategoryVoteSetting.getCategoryId())
            .userId(userId)
            .deleted(DeletedEnum.FALSE.getCode())
            .build();
    int insert = midUserCategoryVoteApplyRepository.insert(midUserCategoryVoteApply);
    // 插入投票数量记录
    if (insert > 0) {
      // 版主投票设置理论上比申请要少很多,暂时申请人数不做分表处理
      userCategoryVoteSettingService.updateApplyCount(voteSettingId);
      return voteTicketCountRepository.insert(
              VoteTicketCount.builder()
                  .applyId(midUserCategoryVoteApply.getApplyId())
                  .ticketCount(0L)
                  .deleted(DeletedEnum.FALSE.getCode())
                  .build())
          > 0;
    }
    throw new NoceException("版主申请异常,请稍后重试!");
  }

  /**
   * 验证投票开始时间
   *
   * @param applyId
   */
  @Override
  public MidUserCategoryVoteApply verifyByApplyId(Long applyId) {
    MidUserCategoryVoteApply byApplyId = midUserCategoryVoteApplyRepository.findByApplyId(applyId);
    if (ObjectUtils.isEmpty(byApplyId)) {
      throw new NoceException("当前版主申请不存在");
    }
    return byApplyId;
  }

  /**
   * 根据分类获取进行中的版主投票列表
   *
   * @param categoryId
   * @param userId
   * @return
   */
  @Override
  public CategoryVoteListRes getCategoryVoteList(Long categoryId, Long userId) {
    UserCategoryVoteSetting userCategoryVoteSetting =
        userCategoryVoteSettingService.findVoteStartSetting(categoryId);
    List<MidUserCategoryVoteApply> applyList =
        midUserCategoryVoteApplyRepository.findByVoteSettingId(
            userCategoryVoteSetting.getVoteSettingId());
    if (ObjectUtils.isEmpty(applyList)) {
      return CategoryVoteListRes.builder()
          .VoteApplyList(Collections.emptyList())
          .canTicket(0)
          .build();
    }
    List<Long> userIdList =
        applyList.stream().map(MidUserCategoryVoteApply::getUserId).collect(Collectors.toList());
    List<Long> applyIdList =
        applyList.stream().map(MidUserCategoryVoteApply::getApplyId).collect(Collectors.toList());
    List<VoteTicketCount> voteTicketCountList =
        voteTicketCountRepository.findTicketByApplyIds(applyIdList);
    Map<Long, Long> ticketCountMap =
        voteTicketCountList
            .stream()
            .collect(
                Collectors.toMap(VoteTicketCount::getApplyId, VoteTicketCount::getTicketCount));
    List<User> userList = userService.findByUserIds(userIdList);
    Map<Long, String> userNameMap =
        userList.stream().collect(Collectors.toMap(User::getId, User::getNickname));
    Boolean hasTicket = voteTicketLogService.checkByUserIdAndApplyIdList(applyIdList, userId);
    List<CategoryVoteListRes.VoteApplyItem> VoteApplyList = new ArrayList<>();
    for (MidUserCategoryVoteApply midUserCategoryVoteApply : applyList) {
      VoteApplyList.add(
          CategoryVoteListRes.VoteApplyItem.builder()
              .userId(midUserCategoryVoteApply.getUserId())
              .userName(userNameMap.getOrDefault(midUserCategoryVoteApply.getUserId(), ""))
              .ticketCount(ticketCountMap.getOrDefault(midUserCategoryVoteApply.getApplyId(), 0L))
              .build());
    }
    return CategoryVoteListRes.builder()
        .VoteApplyList(VoteApplyList)
        .canTicket(hasTicket ? 0 : 1)
        .build();
  }
}

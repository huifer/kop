package com.github.kop.bbs.service.invitation.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.event.invitation.InvitationCreated;
import com.github.kop.bbs.module.entity.Invitation;
import com.github.kop.bbs.module.entity.User;
import com.github.kop.bbs.module.enums.AuditStatusEnum;
import com.github.kop.bbs.module.enums.AuditTypeEnum;
import com.github.kop.bbs.module.enums.invitation.InvitationArticleStatus;
import com.github.kop.bbs.module.req.invitation.InvitationAuditReq;
import com.github.kop.bbs.module.req.invitation.InvitationCreateReq;
import com.github.kop.bbs.module.res.invitation.InvitationQueryResp;
import com.github.kop.bbs.repo.InvitationRepository;
import com.github.kop.bbs.service.IpLocationService;
import com.github.kop.bbs.service.audit.AuditServiceFactory;
import com.github.kop.bbs.service.invitation.InvitationService;
import com.github.kop.bbs.service.user.UserService;
import com.github.kop.bbs.utils.UserInfoThread;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class InvitationServiceImpl implements InvitationService {

  @Autowired
  private InvitationRepository invitationRepository;
  @Autowired
  private UserService userService;
  @Autowired
  private ApplicationEventPublisher eventPublisher;

  @Resource
  private IpLocationService ipLocationService;

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public boolean create(InvitationCreateReq req) {
    Invitation invitation = new Invitation();
    invitation.setTextType(req.getTextType());
    invitation.setCategoryId(req.getCategoryId());
    invitation.setText(req.getText());
    invitation.setArticleStatus(InvitationArticleStatus.PENDING_REVIEW.getCode());
    invitation.setTagStr(req.tagStrings());
    invitation.setIp(UserInfoThread.getIp());
    invitation.setIpLoc(ipLocationService.getLocation(UserInfoThread.getIp()));

    boolean b = invitationRepository.create(invitation) > 0;
    if (b) {
      // 触发帖子创建事件
      this.eventPublisher.publishEvent(new InvitationCreated(invitation.getInvitationId()));
    }
    return b;
  }

  @Override
  public IPage<InvitationQueryResp> page(Long categoryId, Long page, Long size) {
    IPage<Invitation> invitationIPage = this.invitationRepository.page(categoryId, page, size);
    Map<Long,String> userNameMap = Collections.emptyMap();
    if(ObjectUtils.isNotEmpty(invitationIPage.getRecords())){
      List<Long> userIds = invitationIPage.getRecords().stream().map(Invitation::getCreateUserId).collect(Collectors.toList());
      List<User> byUserIds = userService.findByUserIds(userIds);
      userNameMap = byUserIds.stream().collect(Collectors.toMap(User::getId,User::getNickname));
    }
    Map<Long, String> finalUserNameMap = userNameMap;
    return invitationIPage.convert(invitation ->InvitationQueryResp.builder()
            .createUserName(finalUserNameMap.getOrDefault(invitation.getCreateUserId(),""))
            .createUserId(invitation.getCreateUserId())
            .categoryId(invitation.getCategoryId())
            .isEssence(invitation.getIsEssence())
            .isLock(invitation.getIsLock())
            .latestRepliedOn(invitation.getLatestRepliedOn())
            .tags(ObjectUtils.isEmpty(invitation.getTagStr())? Collections.emptyList() : Arrays.asList(invitation.getTagStr().split(",")) )
            .viewsCount(invitation.getViewsCount())
            .commentsCount(invitation.getCommentsCount())
            .build() );
  }

  @Autowired
  private AuditServiceFactory auditServiceFactory;

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public boolean audit(Long userId, InvitationAuditReq req) {
    // TODO: 2022/8/24 审核流程优化，一个人审核改为多人审核

    return auditServiceFactory.factory(AuditTypeEnum.INVITATION)
        .audit(userId, req.getInvitationId(), AuditStatusEnum.conv(req.isPass()), req.getContext());
  }
}

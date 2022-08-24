package com.github.kop.bbs.service.invitation.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.event.invitation.InvitationCreated;
import com.github.kop.bbs.module.entity.Invitation;
import com.github.kop.bbs.module.enums.InvitationArticleStatus;
import com.github.kop.bbs.module.req.invitation.InvitationCreateReq;
import com.github.kop.bbs.module.res.invitation.InvitationQueryResp;
import com.github.kop.bbs.repo.InvitationRepository;
import com.github.kop.bbs.service.invitation.InvitationService;
import com.github.kop.bbs.service.user.UserService;
import com.github.kop.bbs.utils.UserInfoThread;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class InvitationServiceImpl implements InvitationService {

  @Autowired
  private InvitationRepository invitationRepository;
  @Autowired
  private UserService userService;
  @Autowired
  private ApplicationEventPublisher eventPublisher;

  @Override
  public boolean create(InvitationCreateReq req) {
    Invitation invitation = new Invitation();
    invitation.setTextType(req.getTextType());
    invitation.setCategoryId(req.getCategoryId());
    invitation.setText(req.getText());
    invitation.setArticleStatus(InvitationArticleStatus.PENDING_REVIEW.getCode());
    invitation.setTagStr(req.tagStrings());
    invitation.setIp(UserInfoThread.getIp());
    // TODO: 2022/8/24 ip归属地填写
//    invitation.setIpLoc();

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
    return invitationIPage.convert(new Function<Invitation, InvitationQueryResp>() {
      @Override
      public InvitationQueryResp apply(Invitation invitation) {
        return null;
      }

    });
  }
}

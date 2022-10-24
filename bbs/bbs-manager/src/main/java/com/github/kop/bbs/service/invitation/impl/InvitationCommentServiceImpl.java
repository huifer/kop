package com.github.kop.bbs.service.invitation.impl;

import com.github.kop.bbs.module.entity.InvitationComment;
import com.github.kop.bbs.module.enums.DeletedEnum;
import com.github.kop.bbs.module.ex.ValidateException;
import com.github.kop.bbs.module.req.invitation.InvitationCommentReq;
import com.github.kop.bbs.repo.InvitationCommentRepository;
import com.github.kop.bbs.service.IpLocationService;
import com.github.kop.bbs.service.invitation.InvitationCommentService;
import com.github.kop.bbs.utils.CreateValidate;
import com.github.kop.bbs.utils.UserInfoThread;
import javax.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

@Service
public class InvitationCommentServiceImpl implements InvitationCommentService {

  @Resource private InvitationCommentRepository invitationCommentRepository;

  @Resource private IpLocationService ipLocationService;

  private final InvitationCommentCreateAndUpdateValidate invitationCommentCreateAndUpdateValidate =
      new InvitationCommentCreateAndUpdateValidate();

  /**
   * 帖子评论
   *
   * @param req
   * @return
   */
  @Override
  public Boolean create(InvitationCommentReq req) {
    invitationCommentCreateAndUpdateValidate.createValidate(req);
    return invitationCommentRepository.insert(
            InvitationComment.builder()
                .invitationCommentType(req.getInvitationCommentType())
                .pid(req.getPid())
                .topId(req.getTopId())
                .thumbsCont(0L)
                .commentContent(req.getCommentContent())
                .ip(UserInfoThread.getIp())
                .ipLoc(ipLocationService.getLocation(UserInfoThread.getIp()))
                .deleted(DeletedEnum.FALSE.getCode())
                .version(0L)
                .refId(req.getRefId())
                .build())
        > 0;
  }

  protected class InvitationCommentCreateAndUpdateValidate
      implements CreateValidate<InvitationCommentReq> {

    @Override
    public void createValidate(InvitationCommentReq req) throws ValidateException {

      if (ObjectUtils.isEmpty(req.getRefId())) {
        throw new ValidateException("评论主体不能为空");
      }
      if (ObjectUtils.isEmpty(req.getInvitationCommentType())) {
        throw new ValidateException("评论类别不能为空");
      }
      if (ObjectUtils.isEmpty(req.getCommentContent())) {
        throw new ValidateException("评论内容不能为空");
      }
    }
  }
}

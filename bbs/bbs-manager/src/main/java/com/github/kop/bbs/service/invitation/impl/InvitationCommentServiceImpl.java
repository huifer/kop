package com.github.kop.bbs.service.invitation.impl;

import com.github.kop.bbs.module.entity.InvitationComment;
import com.github.kop.bbs.module.enums.DeletedEnum;
import com.github.kop.bbs.module.ex.NoceException;
import com.github.kop.bbs.module.ex.ValidateException;
import com.github.kop.bbs.module.req.category.CreateMidUserCategoryReq;
import com.github.kop.bbs.module.req.invitation.InvitationCommentReq;
import com.github.kop.bbs.repo.InvitationCommentRepository;
import com.github.kop.bbs.service.category.impl.MidUserCategoryServiceImpl;
import com.github.kop.bbs.service.invitation.InvitationCommentService;
import com.github.kop.bbs.utils.CreateValidate;
import com.github.kop.bbs.utils.IpUtil;
import com.github.kop.bbs.utils.UserInfoThread;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class InvitationCommentServiceImpl implements InvitationCommentService {

    @Resource
    private InvitationCommentRepository invitationCommentRepository;


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
        return invitationCommentRepository.insert(InvitationComment.builder()
                        .invitationCommentType(req.getInvitationCommentType())
                        .pid(req.getPid())
                        .topId(req.getTopId())
                // todo levelPath 拼接
                        .thumbsCont(0L)
                        .ip(UserInfoThread.getIp())
//                        .ipLoc()
                        .deleted(DeletedEnum.FALSE.getCode())
                        .version(0L)
                        .refId(req.getRefId())
                .build()) > 0;
    }


    protected class InvitationCommentCreateAndUpdateValidate
            implements CreateValidate<InvitationCommentReq> {

        @Override
        public void createValidate(InvitationCommentReq req)
                throws ValidateException {

            if (ObjectUtils.isEmpty(req.getRefId()) ) {
                throw new ValidateException("评论主体不能为空");
            }
            if (ObjectUtils.isEmpty(req.getInvitationCommentType())) {
                throw new ValidateException("评论类别不能为空");
            }
        }
    }
}


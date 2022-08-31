package com.github.kop.bbs.service.invitation;

import com.github.kop.bbs.module.req.invitation.InvitationCommentReq;

/** 帖子评论、点赞、踩 */
public interface InvitationCommentService {

    /**
     * 帖子评论
     * @param req
     * @return
     */
    Boolean create(InvitationCommentReq req);
}

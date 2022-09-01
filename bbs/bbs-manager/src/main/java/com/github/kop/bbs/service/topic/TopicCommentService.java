package com.github.kop.bbs.service.topic;

import com.github.kop.bbs.module.req.topic.TopicCommentReq;

public interface TopicCommentService{

    /**
     * 评论
     * @param req
     * @return
     */
    Boolean create(TopicCommentReq req);
}

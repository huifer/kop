package com.github.kop.bbs.service.topic;

import com.github.kop.bbs.module.bo.TopicCommentUpdateBo;

import java.util.List;

public interface TopicCommentCountService {


    void updateCommentCount(List<TopicCommentUpdateBo> updateBoArrayList);
}


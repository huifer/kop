package com.github.kop.bbs.repo;

import com.github.kop.bbs.module.bo.TopicCommentUpdateBo;

import java.util.List;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/9/1 23:44
 */
public interface TopicCommentCountRepository {
    void updateCommentCount(List<TopicCommentUpdateBo> updateBoArrayList);
}

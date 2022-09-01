package com.github.kop.bbs.repo.impl;

import com.github.kop.bbs.module.entity.TopicComment;
import com.github.kop.bbs.repo.TopicCommentRepository;
import com.github.kop.bbs.repo.mapper.TopicCommentMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/9/1 23:04
 */
@Repository
public class TopicCommentRepositoryImpl implements TopicCommentRepository {

    @Resource
    private TopicCommentMapper topicCommentMapper;

    @Override
    public int insert(TopicComment build) {
        return topicCommentMapper.insert(build);
    }
}

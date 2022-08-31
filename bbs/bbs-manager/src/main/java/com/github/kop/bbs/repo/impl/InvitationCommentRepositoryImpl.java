package com.github.kop.bbs.repo.impl;

import com.github.kop.bbs.module.entity.InvitationComment;
import com.github.kop.bbs.repo.InvitationCommentRepository;
import com.github.kop.bbs.repo.mapper.InvitationCommentMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/31 21:12
 */
@Repository
public class InvitationCommentRepositoryImpl implements InvitationCommentRepository {

    @Resource
    private InvitationCommentMapper invitationCommentMapper;

    @Override
    public int insert(InvitationComment build) {
        return invitationCommentMapper.insert(build);
    }
}

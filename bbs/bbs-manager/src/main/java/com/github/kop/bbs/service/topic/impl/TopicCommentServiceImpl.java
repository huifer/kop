package com.github.kop.bbs.service.topic.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.kop.bbs.module.entity.TopicComment;
import com.github.kop.bbs.repo.mapper.TopicCommentMapper;
import com.github.kop.bbs.service.topic.TopicCommentService;
@Service
public class TopicCommentServiceImpl extends ServiceImpl<TopicCommentMapper, TopicComment> implements TopicCommentService{

}

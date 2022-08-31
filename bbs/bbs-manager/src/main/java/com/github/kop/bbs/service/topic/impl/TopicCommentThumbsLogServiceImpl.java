package com.github.kop.bbs.service.topic.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.kop.bbs.module.entity.TopicCommentThumbsLog;
import com.github.kop.bbs.repo.mapper.TopicCommentThumbsLogMapper;
import com.github.kop.bbs.service.topic.TopicCommentThumbsLogService;
@Service
public class TopicCommentThumbsLogServiceImpl extends ServiceImpl<TopicCommentThumbsLogMapper, TopicCommentThumbsLog> implements TopicCommentThumbsLogService{

}

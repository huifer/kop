package com.github.kop.bbs.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.kop.bbs.module.entity.Topic;
import com.github.kop.bbs.module.enums.AuditStatusEnum;
import com.github.kop.bbs.module.req.topic.TopicQueryReq;
import com.github.kop.bbs.repo.TopicRepository;
import com.github.kop.bbs.repo.mapper.TopicMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(rollbackFor = {Exception.class})
public class TopicRepositoryImpl implements TopicRepository {

  @Autowired
  private TopicMapper topicMapper;

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public int create(Topic topic) {
    return topicMapper.insert(topic);
  }

  @Override
  public IPage<Topic> page(Long page, Long size, TopicQueryReq req) {
    QueryWrapper<Topic> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda()
        .like(StringUtils.isNotBlank(req.getTopicTitle()), Topic::getTopicTitle,
            req.getTopicTitle())
        .like(StringUtils.isNotBlank(req.getTopicContent()), Topic::getTopicContent,
            req.getTopicContent())
        .eq(Topic::getTopicStatus, req.getAuditStatusEnum().getCode());

    return this.topicMapper.selectPage(new Page<>(page, size), queryWrapper);

  }

  @Override
  public IPage<Topic> pagePass(Long page, Long size) {

    // TODO: 2022/8/26 话题热度排序
    QueryWrapper<Topic> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda()
        .eq(Topic::getTopicStatus, AuditStatusEnum.PASS.getCode());
    return this.topicMapper.selectPage(new Page<>(page, size), queryWrapper);
  }
}

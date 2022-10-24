package com.github.kop.bbs.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.kop.bbs.module.entity.Message;
import com.github.kop.bbs.module.enums.message.MessageStatusEnum;
import com.github.kop.bbs.module.req.message.MessageQueryReq;
import com.github.kop.bbs.repo.MessageRepository;
import com.github.kop.bbs.repo.mapper.MessageMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MessageRepositoryImpl implements MessageRepository {

  @Autowired private MessageMapper mapper;

  @Transactional(rollbackFor = Exception.class)
  @Override
  public boolean create(Message message) {
    return mapper.insert(message) > 0;
  }

  @Transactional(rollbackFor = Exception.class)
  @Override
  public boolean updateToRead(Long userId) {
    return this.mapper.updateToRead(userId, MessageStatusEnum.READ);
  }

  @Override
  public Message byId(Long id, Long userId) {
    QueryWrapper<Message> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda().eq(Message::getMessageId, id).eq(Message::getReceiverUserId, userId);
    return mapper.selectOne(queryWrapper);
  }

  @Override
  public IPage<Message> page(Long page, Long size, MessageQueryReq req, Long userId) {
    QueryWrapper<Message> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda().eq(Message::getReceiverUserId, userId);

    return this.mapper.selectPage(new Page<>(page, size), queryWrapper);
  }

  @Override
  public void batchInsert(List<Message> messageList) {
    mapper.batchInsert(messageList);
  }
}

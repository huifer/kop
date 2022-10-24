package com.github.kop.bbs.repo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.entity.Message;
import com.github.kop.bbs.module.req.message.MessageQueryReq;
import java.util.List;

public interface MessageRepository {

  boolean create(Message message);

  boolean updateToRead(Long userId);

  Message byId(Long id, Long userId);

  IPage<Message> page(Long page, Long size, MessageQueryReq req, Long userId);

  void batchInsert(List<Message> messageList);
}

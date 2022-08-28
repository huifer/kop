package com.github.kop.bbs.service.message.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.entity.Message;
import com.github.kop.bbs.module.entity.User;
import com.github.kop.bbs.module.enums.MessageStatusEnum;
import com.github.kop.bbs.module.enums.MessageTypeEnum;
import com.github.kop.bbs.module.req.message.MessageQueryReq;
import com.github.kop.bbs.module.req.message.UserSendMessageReq;
import com.github.kop.bbs.module.res.message.MessageResp;
import com.github.kop.bbs.repo.MessageRepository;
import com.github.kop.bbs.service.message.MessageService;
import com.github.kop.bbs.service.user.UserService;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

  @Autowired
  private MessageRepository messageRepository;
  @Autowired
  private UserService userService;

  @Override
  public boolean sendPrivateMessage(Long fromUserId, UserSendMessageReq userSendMessageReq) {
    // TODO: 2022/8/26 检查是否拉黑，拉黑不允许发送
    Message message = new Message();
    message.setMessageType(MessageTypeEnum.PRIVATE_MESSAGE.getCode());
    message.setSenderUserId(fromUserId);
    message.setReceiverUserId(userSendMessageReq.getSendToUserId());
    message.setBrief(null);
    message.setContent(userSendMessageReq.getContent());
    message.setMessageStatus(MessageStatusEnum.NOT_READ.getCode());

    return messageRepository.create(message);
  }

  @Override
  public boolean readAll(Long userId) {
    return this.messageRepository.updateToRead(userId);
  }

  @Override
  public IPage<MessageResp> page(Long page, Long size, MessageQueryReq req, Long userId) {

    IPage<Message> queryRes = this.messageRepository.page(page, size, req, userId);

    return queryRes.convert(new Function<Message, MessageResp>() {
      @Override
      public MessageResp apply(Message message) {
        return conv(message);
      }
    });
  }

  @Override
  public MessageResp byId(Long id, Long userId) {
    Message msg = this.messageRepository.byId(id, userId);
    if (msg != null) {

      return conv(msg);
    }
    return null;
  }

  @NotNull
  private MessageResp conv(Message msg) {
    MessageResp messageResp = new MessageResp();
    messageResp.setMessageType(msg.getMessageType());
    messageResp.setMessageEventId(msg.getMessageEventId());
    messageResp.setSenderUserId(msg.getSenderUserId());

    User user = userService.byUserId(msg.getSenderUserId());

    messageResp.setSenderUserName(user.getUsername());
    messageResp.setBrief(msg.getBrief());
    messageResp.setContent(msg.getContent());

    return messageResp;
  }
}

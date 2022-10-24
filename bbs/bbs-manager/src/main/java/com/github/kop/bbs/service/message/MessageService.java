package com.github.kop.bbs.service.message;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.req.message.MessageQueryReq;
import com.github.kop.bbs.module.req.message.UserSendMessageReq;
import com.github.kop.bbs.module.res.message.MessageResp;
import java.util.List;

public interface MessageService {

  /**
   * 给人发私信
   *
   * @param fromUserId 发送人
   * @param userSendMessageReq 消息实体
   * @return 是否发送成功
   */
  boolean sendPrivateMessage(Long fromUserId, UserSendMessageReq userSendMessageReq);

  /**
   * 一键已读
   *
   * @param userId 用户id
   * @return 是否一键已读成功
   */
  boolean readAll(Long userId);

  IPage<MessageResp> page(Long page, Long size, MessageQueryReq req, Long userId);

  MessageResp byId(Long id, Long userId);

  void batchSendMessage(Long fromUserId, List<Long> userIds, int code, String content);
}

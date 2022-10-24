package com.github.kop.bbs.event.topic;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/** 话题创建完成事件 1. 通知审核人员进行审核 */
@Getter
public class TopicCreatedEvent extends ApplicationEvent {

  private final Long topicId;

  public TopicCreatedEvent(Long topicId) {
    super(topicId);
    this.topicId = topicId;
  }
}

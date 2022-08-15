package com.github.kop.bbs.module.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 论坛的消息 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_message")
public class Message implements Serializable {
  /** 消息主键 */
  @TableId(value = "message_id", type = IdType.AUTO)
  private Long messageId;

  /** 通知类型，1动态，2评论，3回复，4私信，99系统通知 */
  @TableField(value = "tips_type")
  private Integer tipsType;

  /** 产生消息的对应内容的主键 */
  @TableField(value = "message_event_id")
  private Long messageEventId;

  /** 接收方用户ID */
  @TableField(value = "sender_user_id")
  private Long senderUserId;

  /** 接收方用户ID */
  @TableField(value = "receiver_user_id")
  private Long receiverUserId;

  /** 摘要说明 */
  @TableField(value = "brief")
  private String brief;

  /** 详细内容 */
  @TableField(value = "content")
  private String content;

  /** 状态 0 未读 1 已读 */
  @TableField(value = "tips_status")
  private Integer tipsStatus;

  /** 创建时间 */
  @TableField(value = "create_time")
  private LocalDateTime createTime;

  /** 逻辑删除标记位 */
  @TableField(value = "deleted")
  @TableLogic
  private Integer deleted;

  private static final long serialVersionUID = 1L;
}

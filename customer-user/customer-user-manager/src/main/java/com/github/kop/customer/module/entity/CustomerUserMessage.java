package com.github.kop.customer.module.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 用户私信表
 * </p>
 *
 * @author root
 * @since 2022-08-03
 */
@Getter
@Setter
@TableName("customer_user_message")
public class CustomerUserMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("id")
    private Long id;

    /**
     * 发送人id
     */
    @TableField("from_user_id")
    private Long fromUserId;

    /**
     * 动态内容
     */
    @TableField("content")
    private String content;

    /**
     * 接收人id
     */
    @TableField("to_user_id")
    private Long toUserId;


}

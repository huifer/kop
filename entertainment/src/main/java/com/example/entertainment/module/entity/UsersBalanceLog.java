package com.example.entertainment.module.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 用户余额操作历史
 * </p>
 *
 * @author root
 * @since 2022-08-31
 */
@Getter
@Setter
@TableName("ent_users_balance_log")
public class UsersBalanceLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 操作类型，1支出，2收入
     */
    @TableField("type")
    private Integer type;

    /**
     * 余额主键
     */
    @TableField("user_balance_id")
    private Integer userBalanceId;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 操作内容
     */
    @TableField("op")
    private String op;


}

package com.example.entertainment.module.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 用户余额表
 * </p>
 *
 * @author root
 * @since 2022-08-31
 */
@Getter
@Setter
@TableName("ent_users_balance")
public class UsersBalance implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    @TableField("user_id")
    private String userId;

    /**
     * 币种
     */
    @TableField("currency")
    private String currency;

    /**
     * 余额
     */
    @TableField("balance")
    private BigDecimal balance;


}

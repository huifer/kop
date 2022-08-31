package com.example.entertainment.module.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 转赠表
 * </p>
 *
 * @author root
 * @since 2022-08-31
 */
@Getter
@Setter
@TableName("ent_goods_transfer")
public class GoodsTransfer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 转增会员信息
     */
    @TableField("from_user_id")
    private Integer fromUserId;

    /**
     * 受赠会员信息
     */
    @TableField("to_user_id")
    private Integer toUserId;

    /**
     * 商品作者id
     */
    @TableField("goods_users_id")
    private Integer goodsUsersId;

    /**
     * 商品id
     */
    @TableField("goods_id")
    private Integer goodsId;

    /**
     * 作品价值
     */
    @TableField("price")
    private BigDecimal price;

    /**
     * 转增时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;


}

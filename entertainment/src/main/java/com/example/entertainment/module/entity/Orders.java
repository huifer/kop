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
 * 用户订单，商家市场，二级市场的订单
 * </p>
 *
 * @author root
 * @since 2022-08-31
 */
@Getter
@Setter
@TableName("ent_orders")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品订单号
     */
    @TableField("order_num")
    private String orderNum;

    /**
     * 拍品编号
     */
    @TableField("goods_num")
    private String goodsNum;

    /**
     * 商品信息
     */
    @TableField("goods_id")
    private Integer goodsId;

    /**
     * 出售会员
     */
    @TableField("sale_uid")
    private Integer saleUid;

    /**
     * 购买会员
     */
    @TableField("buy_uid")
    private Integer buyUid;

    /**
     * 订单价格
     */
    @TableField("price")
    private BigDecimal price;

    /**
     * 订单状态:1=待付款,2=已付款,3=已取消
     */
    @TableField("status")
    private Integer status;

    /**
     * 支付类型:0=待支付,1=余额抵扣,2=支付宝APP支付,3=微信APP支付,4=支付宝H5支付,5=微信H5支付,6=微信小程序支付
     */
    @TableField("pay_type")
    private Integer payType;

    /**
     * 订单支付时间
     */
    @TableField("pay_time")
    private LocalDateTime payTime;

    /**
     * 订单支付结束时间
     */
    @TableField("pay_end_time")
    private LocalDateTime payEndTime;

    /**
     * 下单时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 删除装填:0=未删除,1=已删除
     */
    @TableField("is_del")
    private Integer isDel;

    /**
     * 订单类型:1=平台订单,2=二手交易订单
     */
    @TableField("order_type")
    private Integer orderType;


}

package com.example.entertainment.module.entity;

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
 * 系列商品表
 * </p>
 *
 * @author root
 * @since 2022-08-29
 */
@Getter
@Setter
@TableName("ent_goods")
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品名字
     */
    @TableField("name")
    private String name;

    /**
     * 商品标题
     */
    @TableField("title")
    private String title;

    /**
     * 商品展示图
     */
    @TableField("image")
    private String image;

    /**
     * 商品轮播图
     */
    @TableField("images")
    private String images;

    /**
     * 商品售价
     */
    @TableField("price")
    private BigDecimal price;

    /**
     * 商品介绍
     */
    @TableField("content")
    private String content;

    /**
     * 排序值
     */
    @TableField("order")
    private Integer order;

    /**
     * 开始售卖时间
     */
    @TableField("start_time")
    private LocalDateTime startTime;

    /**
     * 结束结束时间
     */
    @TableField("end_time")
    private LocalDateTime endTime;

    /**
     * 总份额
     */
    @TableField("stock")
    private Integer stock;

    /**
     * 销售量
     */
    @TableField("sales")
    private Integer sales;

    /**
     * 剩余份额
     */
    @TableField("surplus")
    private Integer surplus;

    /**
     * 公司名称
     */
    @TableField("company_name")
    private String companyName;

    /**
     * 公司头像
     */
    @TableField("company_image")
    private String companyImage;

    /**
     * 创作者
     */
    @TableField("creator")
    private String creator;

    /**
     * 是否展示:0=未展示,1=展示
     */
    @TableField("is_show")
    private Integer isShow;

    /**
     * 是否删除:0=未删除,1=已删除
     */
    @TableField("is_del")
    private Integer isDel;

    /**
     * 作品标签
     */
    @TableField("label")
    private String label;

    /**
     * 所属分类
     */
    @TableField("goods_category_id")
    private Integer goodsCategoryId;




}

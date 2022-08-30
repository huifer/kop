package com.example.entertainment.module.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 系列表
 * </p>
 *
 * @author root
 * @since 2022-08-29
 */
@Getter
@Setter
@TableName("ent_goods_category")
public class GoodsCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "`id`", type = IdType.AUTO)
    private Integer id;

    /**
     * 系列名称
     */
    @TableField("`name`")
    private String name;

    /**
     * 系列图片
     */
    @TableField("`image`")
    private String image;

    /**
     * 排序值
     */
    @TableField("`order`")
    private Integer order;

    /**
     * 是否展示:0=隐藏,1=展示
     */
    @TableField("`is_show`")
    private Integer isShow;

    /**
     * 删除状态:0=未删除,1=已删除
     */
    @TableField("`is_del`")
    @TableLogic
    private Integer isDel;


}

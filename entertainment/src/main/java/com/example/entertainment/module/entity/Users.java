package com.example.entertainment.module.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author root
 * @since 2022-08-29
 */
@Getter
@Setter
@TableName("ent_users")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 会员账号
     */
    @TableField("member")
    private String member;

    /**
     * 昵称
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * 头像
     */
    @TableField("head_image")
    private String headImage;

    /**
     * 手机号
     */
    @TableField("phone")
    private String phone;

    /**
     * 上级会员手机号
     */
    @TableField("parent_phone")
    private String parentPhone;

    /**
     * 会员级别
     */
    @TableField("rank_id")
    private Integer rankId;

    /**
     * 会员角色
     */
    @TableField("role_id")
    private Integer roleId;

    /**
     * 会员状态:0=冻结,1=正常
     */
    @TableField("status")
    private Integer status =1 ;

    /**
     * 登录密码
     */
    @TableField("password")
    private String password;

    /**
     * 密码盐
     */
    @TableField("salt")
    private String salt;

    /**
     * 邀请码
     */
    @TableField("uuid")
    private String uuid;

    /**
     * 直推会员人数
     */
    @TableField("total_direct")
    private Integer totalDirect;

    /**
     * 会员登录时间
     */
    @TableField("login_time")
    private LocalDateTime loginTime;

    /**
     * 推荐人id
     */
    @TableField("parent_member")
    private Integer parentMember;

    /**
     * 注册时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 删除状态:0=未删除,1=已删除
     */
    @TableField("is_del")
    @Deprecated
    private Integer isDel;

    /**
     * 实名认证:0=未认证,1=已认证
     */
    @TableField("is_auth")
    private Integer isAuth;

    /**
     * 真实姓名
     */
    @TableField("name")
    private String name;

    /**
     * 身份证号
     */
    @TableField("card")
    private String card;

    /**
     * 身份证正面照片
     */
    @TableField("card_front_image")
    private String cardFrontImage;

    /**
     * 身份证反面照片
     */
    @TableField("card_back_image")
    private String cardBackImage;


}

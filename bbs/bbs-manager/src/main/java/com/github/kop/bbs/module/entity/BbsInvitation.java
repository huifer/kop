package com.github.kop.bbs.module.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 论坛的帖子
    */
@ApiModel(value="论坛的帖子")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_invitation")
public class BbsInvitation implements Serializable {
    /**
     * 帖子主键
     */
    @TableId(value = "invitation_id", type = IdType.AUTO)
    @ApiModelProperty(value="帖子主键")
    private Long invitationId;

    /**
     * 帖子正文类型  1 富文本 2 md
     */
    @TableField(value = "text_type")
    @ApiModelProperty(value="帖子正文类型  1 富文本 2 md")
    private Integer textType;

    /**
     * 论坛类别
     */
    @TableField(value = "category_id")
    @ApiModelProperty(value="论坛类别")
    private Long categoryId;

    /**
     * 帖子类型：0动态、1板块内容
     */
    @TableField(value = "`type`")
    @ApiModelProperty(value="帖子类型：0动态、1板块内容")
    private Integer type;

    /**
     * 帖子正文
     */
    @TableField(value = "`text`")
    @ApiModelProperty(value="帖子正文")
    private String text;

    /**
     * 文章状态 0 待审核 1 审核通过
     */
    @TableField(value = "article_status")
    @ApiModelProperty(value="文章状态 0 待审核 1 审核通过")
    private Integer articleStatus;

    /**
     * 是否置顶
     */
    @TableField(value = "is_top")
    @ApiModelProperty(value="是否置顶")
    private Integer isTop;

    /**
     * 是否精华
     */
    @TableField(value = "is_essence")
    @ApiModelProperty(value="是否精华")
    private Integer isEssence;

    /**
     * 是否锁定
     */
    @TableField(value = "is_lock")
    @ApiModelProperty(value="是否锁定")
    private Integer isLock;

    /**
     * 最新回复时间
     */
    @TableField(value = "latest_replied_on")
    @ApiModelProperty(value="最新回复时间")
    private Long latestRepliedOn;

    /**
     * tag字符串,逗号隔开
     */
    @TableField(value = "tag_str")
    @ApiModelProperty(value="tag字符串,逗号隔开")
    private String tagStr;

    /**
     * IP地址
     */
    @TableField(value = "ip")
    @ApiModelProperty(value="IP地址")
    private String ip;

    /**
     * IP城市地址
     */
    @TableField(value = "ip_loc")
    @ApiModelProperty(value="IP城市地址")
    private String ipLoc;

    /**
     * 点赞数
     */
    @TableField(value = "thumbs_cont")
    @ApiModelProperty(value="点赞数")
    private Long thumbsCont;

    /**
     * 收藏数
     */
    @TableField(value = "collection_cont")
    @ApiModelProperty(value="收藏数")
    private Long collectionCont;

    /**
     * 浏览数
     */
    @TableField(value = "views_count")
    @ApiModelProperty(value="浏览数")
    private Long viewsCount;

    /**
     * 评论数
     */
    @TableField(value = "comments_count")
    @ApiModelProperty(value="评论数")
    private Long commentsCount;

    /**
     * 评论开关
     */
    @TableField(value = "comments_status")
    @ApiModelProperty(value="评论开关")
    private Integer commentsStatus;

    /**
     * 文章可见类型 0 全部可见 1 仅我可见 2 粉丝可见 
     */
    @TableField(value = "visible_status")
    @ApiModelProperty(value="文章可见类型 0 全部可见 1 仅我可见 2 粉丝可见 ")
    private Integer visibleStatus;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 创建用户
     */
    @TableField(value = "create_user_id")
    @ApiModelProperty(value="创建用户")
    private Long createUserId;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value="更新时间")
    private Date updateTime;

    /**
     * 更新用户
     */
    @TableField(value = "update_user_id")
    @ApiModelProperty(value="更新用户")
    private Long updateUserId;

    /**
     * 逻辑删除标记位
     */
    @TableField(value = "deleted")
    @ApiModelProperty(value="逻辑删除标记位")
    private Integer deleted;

    /**
     * 乐观锁
     */
    @TableField(value = "version")
    @ApiModelProperty(value="乐观锁")
    private Long version;

    private static final long serialVersionUID = 1L;
}
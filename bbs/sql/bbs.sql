/*
 Navicat Premium Data Transfer

 Source Server         : 42.193.114.160
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : 42.193.114.160:53306
 Source Schema         : bbs

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 23/08/2022 16:53:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bbs_appeal
-- ----------------------------
DROP TABLE IF EXISTS `bbs_appeal`;
CREATE TABLE `bbs_appeal`  (
  `appeal_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '申诉主键',
  `appeal_type` tinyint(4) NOT NULL COMMENT '申诉类别 1 账号申诉 2 帖子申诉',
  `appeal_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '申诉标题',
  `appeal_text` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '申诉描述',
  `appeal_file` varchar(800) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '申诉附件',
  `deleted` tinyint(4) NULL DEFAULT 0 COMMENT '逻辑删除标记位',
  `version` bigint(20) NULL DEFAULT 0 COMMENT '乐观锁',
  `appeal_user_id` bigint(20) NULL DEFAULT NULL COMMENT '申诉人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`appeal_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '论坛的申诉' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for bbs_appeal_receipt
-- ----------------------------
DROP TABLE IF EXISTS `bbs_appeal_receipt`;
CREATE TABLE `bbs_appeal_receipt`  (
  `appeal_receipt_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '申诉回执主键',
  `appeal_id` bigint(20) NOT NULL COMMENT '申诉主键',
  `order` int(11) NOT NULL COMMENT '申诉回执顺序',
  `appeal_official_reply` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '官方回复',
  `appeal_user_reply` varchar(800) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户回复',
  `deleted` tinyint(4) NULL DEFAULT 0 COMMENT '逻辑删除标记位',
  `version` bigint(20) NULL DEFAULT 0 COMMENT '乐观锁',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`appeal_receipt_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '申诉回执' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for bbs_category
-- ----------------------------
DROP TABLE IF EXISTS `bbs_category`;
CREATE TABLE `bbs_category`  (
  `category_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '论坛主键',
  `category_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '分类名称',
  `category_icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '分类图标',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '上级id',
  `view_permissions` tinyint(4) NULL DEFAULT 0 COMMENT '分类查看权限 0 全部 1 登录用户 2 支付积分(会员免费积分查看可以视为直接支付过积分) 4 会员',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '更新用户',
  `deleted` tinyint(4) NULL DEFAULT 0 COMMENT '逻辑删除标记位',
  `version` bigint(20) NULL DEFAULT 0 COMMENT '乐观锁',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '论坛的板块' ROW_FORMAT = DYNAMIC;


-- ----------------------------
-- Table structure for bbs_collection_log
-- ----------------------------
DROP TABLE IF EXISTS `bbs_collection_log`;
CREATE TABLE `bbs_collection_log`  (
  `collection_log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '积分收藏主键',
  `invitation_id` bigint(20) NOT NULL COMMENT '帖子主键',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建用户',
  `deleted` tinyint(4) NULL DEFAULT 0 COMMENT '逻辑删除标记位',
  `version` bigint(20) NULL DEFAULT 0 COMMENT '乐观锁',
  PRIMARY KEY (`collection_log_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '论坛的收藏日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bbs_comment
-- ----------------------------
DROP TABLE IF EXISTS `bbs_invitation_comment`;
CREATE TABLE `bbs_invitation_comment`  (
  `invitation_comment_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '帖子评论主键',
  `invitation_comment_type` tinyint(4) NOT NULL COMMENT '评论类别 1 帖子 2 帖子评论',
  `pid` bigint(20) NOT NULL COMMENT '上级id',
  `top_id` bigint(20) NULL DEFAULT NULL COMMENT '最上级id',
  `level_path` bigint(20) NOT NULL COMMENT '层级路径',
  `thumbs_cont` bigint(20) NULL DEFAULT NULL COMMENT '点赞数',
  `ip` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'IP地址',
  `ip_loc` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'IP城市地址',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建用户',
  `deleted` tinyint(4) NULL DEFAULT 0 COMMENT '逻辑删除标记位',
  `version` bigint(20) NULL DEFAULT 0 COMMENT '乐观锁',
  `ref_id` bigint(20) NULL DEFAULT NULL COMMENT '主体id',
  PRIMARY KEY (`invitation_comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '论坛的帖子评论' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for bbs_comment_thumbs_log
-- ----------------------------
DROP TABLE IF EXISTS `bbs_invitation_comment_thumbs_log`;
CREATE TABLE `bbs_invitation_comment_thumbs_log`  (
  `ic_thumbs_log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '帖子评论点赞日志主键',
  `invitation_comment_id` bigint(20) NOT NULL COMMENT '帖子评论主键',
  `thumbs_type` tinyint(4) NULL DEFAULT NULL COMMENT '点赞类型 1 点赞 2踩',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建用户',
  `deleted` tinyint(4) NULL DEFAULT 0 COMMENT '逻辑删除标记位',
  `version` bigint(20) NULL DEFAULT 0 COMMENT '乐观锁',
  PRIMARY KEY (`ic_thumbs_log_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '帖子评论点赞日志主键' ROW_FORMAT = DYNAMIC;


DROP TABLE IF EXISTS `bbs_topic_comment`;
CREATE TABLE `bbs_topic_comment`  (
  `topic_comment_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '话题评论主键',
  `topic_comment_type` tinyint(4) NOT NULL COMMENT '评论类别 1 话题 2 话题评论',
  `pid` bigint(20) NOT NULL COMMENT '上级id',
  `top_id` bigint(20) NULL DEFAULT NULL COMMENT '最上级id',
  `level_path` bigint(20) NOT NULL COMMENT '层级路径',
  `thumbs_cont` bigint(20) NULL DEFAULT NULL COMMENT '点赞数',
  `ip` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'IP地址',
  `ip_loc` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'IP城市地址',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建用户',
  `deleted` tinyint(4) NULL DEFAULT 0 COMMENT '逻辑删除标记位',
  `version` bigint(20) NULL DEFAULT 0 COMMENT '乐观锁',
  `ref_id` bigint(20) NULL DEFAULT NULL COMMENT '主体id',
  PRIMARY KEY (`topic_comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '论坛的话题评论' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for bbs_comment_thumbs_log
-- ----------------------------
DROP TABLE IF EXISTS `bbs_topic_comment_thumbs_log`;
CREATE TABLE `bbs_topic_comment_thumbs_log`  (
  `tc_thumbs_log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '话题评论点赞日志主键',
  `topic_comment_id` bigint(20) NOT NULL COMMENT '话题评论主键',
  `thumbs_type` tinyint(4) NULL DEFAULT NULL COMMENT '点赞类型 1 点赞 2踩',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建用户',
  `deleted` tinyint(4) NULL DEFAULT 0 COMMENT '逻辑删除标记位',
  `version` bigint(20) NULL DEFAULT 0 COMMENT '乐观锁',
  PRIMARY KEY (`tc_thumbs_log_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '话题评论点赞日志主键' ROW_FORMAT = DYNAMIC;




-- ----------------------------
-- Table structure for bbs_feedback_record
-- ----------------------------
DROP TABLE IF EXISTS `bbs_feedback_record`;
CREATE TABLE `bbs_feedback_record`  (
  `feedback_record_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户反馈主键',
  `feedback_text` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '反馈内容',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建用户',
  PRIMARY KEY (`feedback_record_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户反馈' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for bbs_invitation
-- ----------------------------
DROP TABLE IF EXISTS `bbs_invitation`;
CREATE TABLE `bbs_invitation`  (
  `invitation_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '帖子主键',
  `text_type` tinyint(4) NOT NULL COMMENT '帖子正文类型  1 富文本 2 md',
  `top_category_id` bigint(20) NOT NULL COMMENT 'top论坛类别',
  `category_id` bigint(20) NOT NULL COMMENT '论坛类别',
  `type` tinyint(4) NOT NULL COMMENT '帖子类型：0动态、1板块内容',
  `topic_id` bigint(20) NULL DEFAULT NULL COMMENT '话题主键 动态可以选择加话题',
  `text` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '帖子正文',
  `article_status` tinyint(4) NULL DEFAULT 0 COMMENT '文章状态 0 待审核 1 审核通过',
  `is_top` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否置顶',
  `is_essence` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否精华',
  `is_lock` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否锁定',
  `latest_replied_on` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '最新回复时间',
  `tag_str` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'tag字符串,逗号隔开',
  `ip` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'IP地址',
  `ip_loc` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'IP城市地址',
  `views_count` bigint(20) NULL DEFAULT NULL COMMENT '浏览数',
  `comments_count` bigint(20) NULL DEFAULT NULL COMMENT '评论数',
  `comments_status` tinyint(4) NULL DEFAULT NULL COMMENT '评论开关',
  `visible_status` tinyint(4) NULL DEFAULT NULL COMMENT '文章可见类型 0 全部可见 1 仅我可见 2 粉丝可见 ',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '更新用户',
  `deleted` tinyint(4) NULL DEFAULT 0 COMMENT '逻辑删除标记位',
  `version` bigint(20) NULL DEFAULT 0 COMMENT '乐观锁',
  PRIMARY KEY (`invitation_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '论坛的帖子' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for bbs_message
-- ----------------------------
DROP TABLE IF EXISTS `bbs_message`;
CREATE TABLE `bbs_message`  (
  `message_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '消息主键',
  `message_type` tinyint(4) NOT NULL COMMENT ' 通知类型，1动态，2评论，3帖子回复通知，4评论回复通知 5私信，99系统通知',
  `message_event_id` bigint(20) NOT NULL COMMENT '产生消息的对应内容的主键',
  `sender_user_id` bigint(20) NOT NULL COMMENT '发送发用户ID',
  `receiver_user_id` bigint(20) NOT NULL COMMENT '接收方用户ID',
  `brief` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '摘要说明',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '详细内容',
  `message_status` tinyint(4) NOT NULL COMMENT '状态 0 未读 1 已读',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `deleted` tinyint(4) NULL DEFAULT 0 COMMENT '逻辑删除标记位',
  PRIMARY KEY (`message_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '论坛的消息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for bbs_mid_user_category
-- ----------------------------
DROP TABLE IF EXISTS `bbs_mid_user_category`;
CREATE TABLE `bbs_mid_user_category`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `category_id` bigint(20) NOT NULL COMMENT '版块id',
  `deleted` tinyint(3) NOT NULL COMMENT '是否删除 0 为未删除、1 为已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '版主与分类的中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bbs_category_vote_setting
-- ----------------------------
DROP TABLE IF EXISTS `bbs_user_category_vote_setting`;
CREATE TABLE `bbs_user_category_vote_setting`  (
  `vote_setting_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `category_id` bigint(20) NOT NULL COMMENT '版块id',
  `application_count` bigint(20) UNSIGNED NOT NULL COMMENT '申请人数限制 0 不限制 ',
  `already_count` bigint(20) UNSIGNED NOT NULL COMMENT '已经申请的人  ',
  `apply_start_time` datetime NULL DEFAULT NULL COMMENT '申请开始时间(时间范围内允许申请)',
  `apply_end_time` datetime NULL DEFAULT NULL COMMENT '申请结束时间',
  `vote_start_time` datetime NULL DEFAULT NULL COMMENT '投票开始时间(时间范围内允许投票)',
  `vote_end_time` datetime NULL DEFAULT NULL COMMENT '投票结束时间',
  `deleted` tinyint(3) NOT NULL COMMENT '是否删除 0 为未删除、1 为已删除',
  PRIMARY KEY (`vote_setting_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '版主投票设置表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for bbs_mid_user_category_vote_apply
-- ----------------------------
DROP TABLE IF EXISTS `bbs_mid_user_category_vote_apply`;
CREATE TABLE `bbs_mid_user_category_vote_apply`  (
  `apply_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `vote_setting_id` bigint(20) UNSIGNED NOT NULL COMMENT '版主投票表主键',
  `category_id` bigint(20) NOT NULL COMMENT '版块id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `ticket_count` bigint(20) NOT NULL COMMENT '投票票数(结束时间后持久化,投票开始时间内不维护)',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `deleted` tinyint(3) NOT NULL COMMENT '是否删除 0 为未删除、1 为已删除',
  PRIMARY KEY (`apply_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '版主投票申请表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for bbs_vote_ticket_count
-- ----------------------------

DROP TABLE IF EXISTS `bbs_vote_ticket_count`;
CREATE TABLE `bbs_vote_ticket_count`  (
                                                     `ticket_count_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
                                                     `apply_id` bigint(20) UNSIGNED NOT NULL COMMENT '申请表主键',
                                                     `ticket_count` bigint(20) NOT NULL COMMENT '投票票数',
                                                     `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                                     `deleted` tinyint(3) NOT NULL COMMENT '是否删除 0 为未删除、1 为已删除',
                                                     PRIMARY KEY (`ticket_count_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '版主票数记录表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for bbs_vote_ticket_log
-- ----------------------------

DROP TABLE IF EXISTS `bbs_vote_ticket_log`;
CREATE TABLE `bbs_vote_ticket_log`  (
                                          `ticket_count_log_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
                                          `apply_id` bigint(20) UNSIGNED NOT NULL COMMENT '申请表主键',
                                          `user_id` bigint(20) NOT NULL COMMENT '用户id',
                                          `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                          `deleted` tinyint(3) NOT NULL COMMENT '是否删除 0 为未删除、1 为已删除',
                                          PRIMARY KEY (`ticket_count_log_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '版主票数记录表' ROW_FORMAT = DYNAMIC;



-- ----------------------------
-- Table structure for bbs_mid_user_role
-- ----------------------------
DROP TABLE IF EXISTS `bbs_mid_user_role`;
CREATE TABLE `bbs_mid_user_role`  (
  `mid_role_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '中间表主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `role_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色code',
  `deleted` tinyint(3) NOT NULL COMMENT '是否删除 0 为未删除、1 为已删除',
  PRIMARY KEY (`mid_role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bbs_punishment
-- ----------------------------
DROP TABLE IF EXISTS `bbs_punishment`;
CREATE TABLE `bbs_punishment`  (
  `punishment_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '积分惩罚主键',
  `user_id` bigint(20) NOT NULL COMMENT '惩罚用户id',
  `punishment_basis` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '惩罚依据',
  `score_count` int(11) NOT NULL COMMENT '惩罚分数',
  `punishment_status` tinyint(4) NOT NULL COMMENT '惩罚状态 0 未惩罚 1 已惩罚 3 已撤销',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '更新用户',
  `deleted` tinyint(4) NULL DEFAULT 0 COMMENT '逻辑删除标记位',
  `version` bigint(20) NULL DEFAULT 0 COMMENT '乐观锁',
  PRIMARY KEY (`punishment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '论坛的惩罚' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for bbs_role
-- ----------------------------
DROP TABLE IF EXISTS `bbs_role`;
CREATE TABLE `bbs_role`  (
  `role_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '角色主键',
  `role_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `role_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色code',
  `deleted` tinyint(3) NULL DEFAULT NULL COMMENT '是否删除 0 为未删除、1 为已删除',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bbs_score_record
-- ----------------------------
DROP TABLE IF EXISTS `bbs_score_record`;
CREATE TABLE `bbs_score_record`  (
  `score_record_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '积分日志主键',
  `role_id` bigint(20) NOT NULL COMMENT '积分规则',
  `score_count` int(11) NOT NULL COMMENT '具体加的分数 ',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建用户',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `score_cycle` tinyint(4) NULL DEFAULT NULL COMMENT '积分周期类型(周期内只能得一次分) 0 没有周期(即不限制得分)  1 天 2 周 3 月 4 年 ',
  `cycle_count` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '积分周期数',
  PRIMARY KEY (`score_record_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '论坛的积分记录' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for bbs_score_role
-- ----------------------------
DROP TABLE IF EXISTS `bbs_score_role`;
CREATE TABLE `bbs_score_role`  (
  `score_role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '积分规则主键',
  `rule_type` tinyint(4) NOT NULL COMMENT '积分类型  1 签到积分 2 发帖积分 3 评论积分 4 惩罚积分',
  `add_type` tinyint(4) NOT NULL COMMENT '增减类型  0 减少 1 增加',
  `score` bigint(20) NULL DEFAULT NULL COMMENT '可获得的积分数量',
  `score_cycle` tinyint(4) NOT NULL COMMENT '积分周期(周期内只能得一次分) 0 没有周期(即不限制得分)  1 天 2 周 3 月 4 年 ',
  `effect_time` datetime NULL DEFAULT NULL COMMENT '生效时间,表示此规则什么时候生效',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '更新用户',
  `deleted` tinyint(4) NULL DEFAULT 0 COMMENT '逻辑删除标记位',
  `version` bigint(20) NULL DEFAULT 0 COMMENT '乐观锁',
  `cycle_num` int(11) NULL DEFAULT NULL COMMENT '周期数字（N天，N周,N年）',
  `max_score` bigint(11) NULL DEFAULT NULL COMMENT '周期内最多获取的积分数量（ 0 不限 ）',
  PRIMARY KEY (`score_role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '论坛的积分规则配置' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for bbs_tag
-- ----------------------------
DROP TABLE IF EXISTS `bbs_tag`;
CREATE TABLE `bbs_tag`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '标签ID',
  `user_id` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建者ID',
  `tag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标签名',
  `quote_num` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '引用数',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `deleted_time` datetime NOT NULL COMMENT '删除时间',
  `version` bigint(20) NULL DEFAULT 0 COMMENT '乐观锁',
  `deleted` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除 0 为未删除、1 为已删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_tag`(`tag`) USING BTREE,
  INDEX `idx_user`(`user_id`) USING BTREE,
  INDEX `idx_num`(`quote_num`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '标签' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for bbs_thumbs_log
-- ----------------------------
DROP TABLE IF EXISTS `bbs_thumbs_log`;
CREATE TABLE `bbs_thumbs_log`  (
  `thumbs_log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '点赞日志主键',
  `invitation_id` bigint(20) NOT NULL COMMENT '帖子主键',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建用户',
  `deleted` tinyint(4) NULL DEFAULT 0 COMMENT '逻辑删除标记位',
  `version` bigint(20) NULL DEFAULT 0 COMMENT '乐观锁',
  PRIMARY KEY (`thumbs_log_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '论坛的点赞日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bbs_topic
-- ----------------------------
DROP TABLE IF EXISTS `bbs_topic`;
CREATE TABLE `bbs_topic`  (
  `topic_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '话题主键',
  `topic_title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '话题标题',
  `topic_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '话题内容',
  `topic_status` tinyint(4) NULL DEFAULT 0 COMMENT '话题状态 0 待审核  1 审核通过 2 审核不通过 ',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建用户',
  PRIMARY KEY (`topic_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '话题' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for bbs_user
-- ----------------------------
DROP TABLE IF EXISTS `bbs_user`;
CREATE TABLE `bbs_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `salt` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'salt',
  `avatar` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '用户头像',
  `nickname` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '昵称',
  `register_time` datetime NOT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for bbs_user_black_list
-- ----------------------------
DROP TABLE IF EXISTS `bbs_user_black_list`;
CREATE TABLE `bbs_user_black_list`  (
  `black_list_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '黑名单主键',
  `black_user_id` bigint(20) NOT NULL COMMENT '拉黑的人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建用户',
  PRIMARY KEY (`black_list_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户黑名单' ROW_FORMAT = DYNAMIC;


-- ----------------------------
-- Table structure for bbs_user_dynamic
-- ----------------------------
DROP TABLE IF EXISTS `bbs_user_dynamic`;
CREATE TABLE `bbs_user_dynamic`  (
  `user_dynamic_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '动态主键',
  `topic_id` bigint(20) NULL DEFAULT NULL COMMENT '话题主键 动态可以选择加话题',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '详细内容',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `deleted` tinyint(4) NULL DEFAULT 0 COMMENT '逻辑删除标记位',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建用户',
  PRIMARY KEY (`user_dynamic_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '论坛的动态' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for bbs_user_follower_list
-- ----------------------------
DROP TABLE IF EXISTS `bbs_user_follower_list`;
CREATE TABLE `bbs_user_follower_list`  (
  `follower_list_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '关注主键',
  `follower_user_id` bigint(20) NOT NULL COMMENT '拉黑的人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建用户',
  PRIMARY KEY (`follower_list_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户关注名单' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for bbs_user_score
-- ----------------------------
DROP TABLE IF EXISTS `bbs_user_score`;
CREATE TABLE `bbs_user_score`  (
  `score_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户总分主键',
  `sum_score` bigint(20) UNSIGNED NOT NULL COMMENT '总分',
  `current_score` bigint(20) UNSIGNED NOT NULL COMMENT '当前的分数',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '更新用户',
  PRIMARY KEY (`score_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户积分' ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;

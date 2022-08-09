/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : bbs

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 09/08/2022 19:39:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bbs_appeal
-- ----------------------------
DROP TABLE IF EXISTS `bbs_appeal`;
CREATE TABLE `bbs_appeal`  (
                               `appeal_id` bigint NOT NULL AUTO_INCREMENT COMMENT '申诉主键',
                               `appeal_type` bigint NOT NULL COMMENT '申诉类别 1 账号申诉 2 帖子申诉',
                               `appeal_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8_general_ci NOT NULL COMMENT '申诉标题',
                               `appeal_text` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8_general_ci NOT NULL COMMENT '申诉描述',
                               `appeal_file` varchar(800) CHARACTER SET utf8mb4 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申诉附件',
                               `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                               `create_user_id` bigint NULL DEFAULT NULL COMMENT '创建用户',
                               `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
                               `update_user_id` bigint NULL DEFAULT NULL COMMENT '更新用户',
                               `deleted` tinyint NULL DEFAULT 0 COMMENT '逻辑删除标记位',
                               `version` bigint NULL DEFAULT 0 COMMENT '乐观锁',
                               PRIMARY KEY (`appeal_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4  COMMENT = '论坛的申诉' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bbs_category
-- ----------------------------
DROP TABLE IF EXISTS `bbs_category`;
CREATE TABLE `bbs_category`  (
                                 `category_id` bigint NOT NULL AUTO_INCREMENT COMMENT '论坛主键',
                                 `category_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8_general_ci NOT NULL COMMENT '分类名称',
                                 `category_icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8_general_ci NOT NULL COMMENT '分类图标',
                                 `parent_id` bigint NULL DEFAULT NULL COMMENT '上级id',
                                 `view_permissions` tinyint NULL DEFAULT 0 COMMENT '分类查看权限 0 全部 1 登录用户 2 支付积分(会员免费积分查看可以视为直接支付过积分) 4 会员',
                                 `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                 `create_user_id` bigint NULL DEFAULT NULL COMMENT '创建用户',
                                 `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
                                 `update_user_id` bigint NULL DEFAULT NULL COMMENT '更新用户',
                                 `deleted` tinyint NULL DEFAULT 0 COMMENT '逻辑删除标记位',
                                 `version` bigint NULL DEFAULT 0 COMMENT '乐观锁',
                                 PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4  COMMENT = '论坛的板块' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bbs_comment
-- ----------------------------
DROP TABLE IF EXISTS `bbs_comment`;
CREATE TABLE `bbs_comment`  (
                                `comment_id` bigint NOT NULL AUTO_INCREMENT COMMENT '帖子评论主键',
                                `comment_type` tinyint NOT NULL COMMENT '评论类别 1 帖子 2 评论 3 话题',
                                `event_id` bigint NOT NULL COMMENT '回复的内容对应级别的id',
                                `event_level_path` bigint NOT NULL COMMENT '回复帖子为空如果是回复评论,整个评论id的层级路径',
                                `thumbs_cont` bigint NULL DEFAULT NULL COMMENT '点赞数',
                                `ip` varchar(64) CHARACTER SET utf8mb4mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'IP地址',
                                `ip_loc` varchar(64) CHARACTER SET utf8mb4mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'IP城市地址',
                                `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                `create_user_id` bigint NULL DEFAULT NULL COMMENT '创建用户',
                                `deleted` tinyint NULL DEFAULT 0 COMMENT '逻辑删除标记位',
                                `version` bigint NULL DEFAULT 0 COMMENT '乐观锁',
                                PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4  COMMENT = '论坛的帖子评论' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bbs_comment_thumbs_log
-- ----------------------------
DROP TABLE IF EXISTS `bbs_comment_thumbs_log`;
CREATE TABLE `bbs_comment_thumbs_log`  (
                                           `thumbs_log_id` bigint NOT NULL AUTO_INCREMENT COMMENT '点赞日志主键',
                                           `comment_id` bigint NOT NULL COMMENT '帖子评论主键',
                                           `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                           `create_user_id` bigint NULL DEFAULT NULL COMMENT '创建用户',
                                           `deleted` tinyint NULL DEFAULT 0 COMMENT '逻辑删除标记位',
                                           `version` bigint NULL DEFAULT 0 COMMENT '乐观锁',
                                           PRIMARY KEY (`thumbs_log_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4  COMMENT = '评论的点赞日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bbs_feedback_record
-- ----------------------------
DROP TABLE IF EXISTS `bbs_feedback_record`;
CREATE TABLE `bbs_feedback_record`  (
                                        `feedback_record_id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户反馈主键',
                                        `feedback_text` text CHARACTER SET utf8mb4 COLLATE utf8_general_ci NOT NULL COMMENT '反馈内容',
                                        `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                        `create_user_id` bigint NULL DEFAULT NULL COMMENT '创建用户',
                                        PRIMARY KEY (`feedback_record_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4  COMMENT = '用户反馈' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bbs_invitation
-- ----------------------------
DROP TABLE IF EXISTS `bbs_invitation`;
CREATE TABLE `bbs_invitation`  (
                                   `invitation_id` bigint NOT NULL AUTO_INCREMENT COMMENT '帖子主键',
                                   `text_type` tinyint NOT NULL COMMENT '帖子正文类型  1 富文本 2 md',
                                   `category_id` bigint NOT NULL COMMENT '论坛类别',
                                   `type` tinyint NOT NULL COMMENT '帖子类型：0动态、1板块内容',
                                   `text` text CHARACTER SET utf8mb4 COLLATE utf8_general_ci NOT NULL COMMENT '帖子正文',
                                   `article_status` tinyint NULL DEFAULT 0 COMMENT '文章状态 0 待审核 1 审核通过',
                                   `is_top` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否置顶',
                                   `is_essence` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否精华',
                                   `is_lock` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否锁定',
                                   `latest_replied_on` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '最新回复时间',
                                   `tag_str` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT 'tag字符串,逗号隔开',
                                   `ip` varchar(64) CHARACTER SET utf8mb4mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'IP地址',
                                   `ip_loc` varchar(64) CHARACTER SET utf8mb4mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'IP城市地址',
                                   `thumbs_cont` bigint NULL DEFAULT NULL COMMENT '点赞数',
                                   `collection_cont` bigint NULL DEFAULT NULL COMMENT '收藏数',
                                   `views_count` bigint NULL DEFAULT NULL COMMENT '浏览数',
                                   `comments_count` bigint NULL DEFAULT NULL COMMENT '评论数',
                                   `comments_status` tinyint NULL DEFAULT NULL COMMENT '评论开关',
                                   `visible_status` tinyint NULL DEFAULT NULL COMMENT '文章可见类型 0 全部可见 1 仅我可见 2 粉丝可见 ',
                                   `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                   `create_user_id` bigint NULL DEFAULT NULL COMMENT '创建用户',
                                   `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
                                   `update_user_id` bigint NULL DEFAULT NULL COMMENT '更新用户',
                                   `deleted` tinyint NULL DEFAULT 0 COMMENT '逻辑删除标记位',
                                   `version` bigint NULL DEFAULT 0 COMMENT '乐观锁',
                                   PRIMARY KEY (`invitation_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4  COMMENT = '论坛的帖子' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bbs_invitation_collection_log
-- ----------------------------
DROP TABLE IF EXISTS `bbs_invitation_collection_log`;
CREATE TABLE `bbs_invitation_collection_log`  (
                                                  `collection_log_id` bigint NOT NULL AUTO_INCREMENT COMMENT '收藏主键',
                                                  `event_id` bigint NOT NULL COMMENT '收藏内容的逐渐',
                                                  `collection_type` tinyint NULL DEFAULT 0 COMMENT '收藏类型 1 帖子 2 板块 3 用户动态',
                                                  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                                  `create_user_id` bigint NULL DEFAULT NULL COMMENT '创建用户',
                                                  `deleted` tinyint NULL DEFAULT 0 COMMENT '逻辑删除标记位',
                                                  `version` bigint NULL DEFAULT 0 COMMENT '乐观锁',
                                                  PRIMARY KEY (`collection_log_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4  COMMENT = '论坛的收藏日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bbs_invitation_thumbs_log
-- ----------------------------
DROP TABLE IF EXISTS `bbs_invitation_thumbs_log`;
CREATE TABLE `bbs_invitation_thumbs_log`  (
                                              `thumbs_log_id` bigint NOT NULL AUTO_INCREMENT COMMENT '点赞日志主键',
                                              `invitation_id` bigint NOT NULL COMMENT '帖子主键',
                                              `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                              `create_user_id` bigint NULL DEFAULT NULL COMMENT '创建用户',
                                              `deleted` tinyint NULL DEFAULT 0 COMMENT '逻辑删除标记位',
                                              `version` bigint NULL DEFAULT 0 COMMENT '乐观锁',
                                              PRIMARY KEY (`thumbs_log_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4  COMMENT = '论坛的点赞日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bbs_message
-- ----------------------------
DROP TABLE IF EXISTS `bbs_message`;
CREATE TABLE `bbs_message`  (
                                `message_id` bigint NOT NULL AUTO_INCREMENT COMMENT '消息主键',
                                `tpis_type` tinyint NOT NULL COMMENT ' 通知类型，1动态，2评论，3回复，4私信，99系统通知',
                                `message_event_id` bigint NOT NULL COMMENT '产生消息的对应内容的主键',
                                `sender_user_id` bigint NOT NULL COMMENT '接收方用户ID',
                                `receiver_user_id` bigint NOT NULL COMMENT '接收方用户ID',
                                `brief` varchar(255) CHARACTER SET utf8mb4mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '摘要说明',
                                `content` varchar(255) CHARACTER SET utf8mb4mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '详细内容',
                                `tips_status` tinyint NOT NULL COMMENT '状态 0 未读 1 已读',
                                `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                `deleted` tinyint NULL DEFAULT 0 COMMENT '逻辑删除标记位',
                                PRIMARY KEY (`message_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4  COMMENT = '论坛的消息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bbs_punishment
-- ----------------------------
DROP TABLE IF EXISTS `bbs_punishment`;
CREATE TABLE `bbs_punishment`  (
                                   `punishment_id` bigint NOT NULL AUTO_INCREMENT COMMENT '积分惩罚主键',
                                   `user_id` bigint NOT NULL COMMENT '惩罚用户id',
                                   `punishment_basis` text CHARACTER SET utf8mb4 COLLATE utf8_general_ci NOT NULL COMMENT '惩罚依据',
                                   `score_count` int NOT NULL COMMENT '惩罚分数',
                                   `punishment_status` tinyint NOT NULL COMMENT '惩罚状态 0 未惩罚 1 已惩罚 3 已撤销',
                                   `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                   `create_user_id` bigint NULL DEFAULT NULL COMMENT '创建用户',
                                   `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
                                   `update_user_id` bigint NULL DEFAULT NULL COMMENT '更新用户',
                                   `deleted` tinyint NULL DEFAULT 0 COMMENT '逻辑删除标记位',
                                   `version` bigint NULL DEFAULT 0 COMMENT '乐观锁',
                                   PRIMARY KEY (`punishment_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4  COMMENT = '论坛的惩罚' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bbs_score_log
-- ----------------------------
DROP TABLE IF EXISTS `bbs_score_log`;
CREATE TABLE `bbs_score_log`  (
                                  `score_log_id` bigint NOT NULL AUTO_INCREMENT COMMENT '积分日志主键',
                                  `role_id` bigint NOT NULL COMMENT '积分规则',
                                  `score_count` int NULL DEFAULT NULL COMMENT '具体加的分数 ',
                                  `event_id` bigint NOT NULL COMMENT '事件id',
                                  `return_msg` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8_general_ci NOT NULL COMMENT '返回内容',
                                  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                  `create_user_id` bigint NULL DEFAULT NULL COMMENT '创建用户',
                                  PRIMARY KEY (`score_log_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4  COMMENT = '论坛的积分日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bbs_score_record
-- ----------------------------
DROP TABLE IF EXISTS `bbs_score_record`;
CREATE TABLE `bbs_score_record`  (
                                     `score_record_id` bigint NOT NULL AUTO_INCREMENT COMMENT '积分日志主键',
                                     `role_id` bigint NOT NULL COMMENT '积分规则',
                                     `score_count` int NULL DEFAULT NULL COMMENT '具体加的分数 ',
                                     `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                     `create_user_id` bigint NULL DEFAULT NULL COMMENT '创建用户',
                                     PRIMARY KEY (`score_record_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4  COMMENT = '论坛的积分记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bbs_score_role
-- ----------------------------
DROP TABLE IF EXISTS `bbs_score_role`;
CREATE TABLE `bbs_score_role`  (
                                   `role_id` bigint NOT NULL AUTO_INCREMENT COMMENT '积分规则主键',
                                   `role_type` tinyint NOT NULL COMMENT '积分类型  1 签到积分 2 发帖积分 3 评论积分 4 惩罚积分',
                                   `add_type` tinyint NOT NULL COMMENT '增减类型  0 减少 1 增加',
                                   `score` int NULL DEFAULT NULL COMMENT '积分数量 0 不限 ',
                                   `score_cycle` tinyint NOT NULL COMMENT '积分周期(周期内只能得一次分) 0 没有周期(即不限制得分)  1 天 2 周 3 月 4 年 ',
                                   `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                   `create_user_id` bigint NULL DEFAULT NULL COMMENT '创建用户',
                                   `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
                                   `update_user_id` bigint NULL DEFAULT NULL COMMENT '更新用户',
                                   `deleted` tinyint NULL DEFAULT 0 COMMENT '逻辑删除标记位',
                                   `version` bigint NULL DEFAULT 0 COMMENT '乐观锁',
                                   PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4  COMMENT = '论坛的积分规则配置' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bbs_tag
-- ----------------------------
DROP TABLE IF EXISTS `bbs_tag`;
CREATE TABLE `bbs_tag`  (
                            `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '标签ID',
                            `user_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建者ID',
                            `tag` varchar(255) CHARACTER SET utf8mb4mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标签名',
                            `quote_num` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '引用数',
                            `create_time` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
                            `update_time` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '修改时间',
                            `deleted_time` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '删除时间',
                            `deleted` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除 0 为未删除、1 为已删除',
                            PRIMARY KEY (`id`) USING BTREE,
                            UNIQUE INDEX `idx_tag`(`tag` ASC) USING BTREE,
                            INDEX `idx_user`(`user_id` ASC) USING BTREE,
                            INDEX `idx_num`(`quote_num` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4mb4 COLLATE = utf8mb4_general_ci COMMENT = '标签' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bbs_topic
-- ----------------------------
DROP TABLE IF EXISTS `bbs_topic`;
CREATE TABLE `bbs_topic`  (
                              `topic_id` bigint NOT NULL AUTO_INCREMENT COMMENT '话题主键',
                              `topic_title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8_general_ci NOT NULL COMMENT '话题标题',
                              `topic_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8_general_ci NOT NULL COMMENT '话题内容',
                              `topic_status` tinyint NULL DEFAULT 0 COMMENT '话题状态 0 待审核  1 审核通过 2 审核不通过 ',
                              `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                              `create_user_id` bigint NULL DEFAULT NULL COMMENT '创建用户',
                              PRIMARY KEY (`topic_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4  COMMENT = '话题' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bbs_user
-- ----------------------------
DROP TABLE IF EXISTS `bbs_user`;
CREATE TABLE `bbs_user`  (
                             `id` bigint NOT NULL,
                             `username` varchar(32) CHARACTER SET utf8mb4mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
                             `password` varchar(32) CHARACTER SET utf8mb4mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
                             `salt` varchar(32) CHARACTER SET utf8mb4mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'salt',
                             `avatar` varchar(255) CHARACTER SET utf8mb4mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '用户头像',
                             `nickname` varchar(32) CHARACTER SET utf8mb4mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '昵称',
                             `register_time` datetime NOT NULL COMMENT '注册时间',
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bbs_user_black_list
-- ----------------------------
DROP TABLE IF EXISTS `bbs_user_black_list`;
CREATE TABLE `bbs_user_black_list`  (
                                        `black_list_id` bigint NOT NULL AUTO_INCREMENT COMMENT '黑名单主键',
                                        `black_user_id` bigint NOT NULL COMMENT '拉黑的人',
                                        `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                        `create_user_id` bigint NULL DEFAULT NULL COMMENT '创建用户',
                                        PRIMARY KEY (`black_list_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4  COMMENT = '用户黑名单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bbs_user_follower_list
-- ----------------------------
DROP TABLE IF EXISTS `bbs_user_follower_list`;
CREATE TABLE `bbs_user_follower_list`  (
                                           `follower_list_id` bigint NOT NULL AUTO_INCREMENT COMMENT '黑名单主键',
                                           `follower_user_id` bigint NOT NULL COMMENT '拉黑的人',
                                           `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                           `create_user_id` bigint NULL DEFAULT NULL COMMENT '创建用户',
                                           PRIMARY KEY (`follower_list_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4  COMMENT = '用户关注名单' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

/*
 Navicat Premium Data Transfer

 Source Server         : 腾讯云
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : 42.193.114.160:53306
 Source Schema         : bbs

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 15/08/2022 22:11:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bbs_appeal
-- ----------------------------
DROP TABLE IF EXISTS `bbs_appeal`;
CREATE TABLE `bbs_appeal` (
                              `appeal_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '申诉主键',
                              `appeal_type` bigint(20) NOT NULL COMMENT '申诉类别 1 账号申诉 2 帖子申诉',
                              `appeal_title` varchar(255) NOT NULL COMMENT '申诉标题',
                              `appeal_text` varchar(500) NOT NULL COMMENT '申诉描述',
                              `appeal_file` varchar(800) DEFAULT NULL COMMENT '申诉附件',
                              `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                              `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户',
                              `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                              `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新用户',
                              `deleted` tinyint(4) DEFAULT '0' COMMENT '逻辑删除标记位',
                              `version` bigint(20) DEFAULT '0' COMMENT '乐观锁',
                              PRIMARY KEY (`appeal_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='论坛的申诉';

-- ----------------------------
-- Table structure for bbs_category
-- ----------------------------
DROP TABLE IF EXISTS `bbs_category`;
CREATE TABLE `bbs_category` (
                                `category_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '论坛主键',
                                `category_name` varchar(255) NOT NULL COMMENT '分类名称',
                                `category_icon` varchar(255) NOT NULL COMMENT '分类图标',
                                `parent_id` bigint(20) DEFAULT NULL COMMENT '上级id',
                                `view_permissions` tinyint(4) DEFAULT '0' COMMENT '分类查看权限 0 全部 1 登录用户 2 支付积分(会员免费积分查看可以视为直接支付过积分) 4 会员',
                                `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户',
                                `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新用户',
                                `deleted` tinyint(4) DEFAULT '0' COMMENT '逻辑删除标记位',
                                `version` bigint(20) DEFAULT '0' COMMENT '乐观锁',
                                PRIMARY KEY (`category_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='论坛的板块';

-- ----------------------------
-- Table structure for bbs_collection_log
-- ----------------------------
DROP TABLE IF EXISTS `bbs_collection_log`;
CREATE TABLE `bbs_collection_log` (
                                      `collection_log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '积分收藏主键',
                                      `invitation_id` bigint(20) NOT NULL COMMENT '帖子主键',
                                      `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                      `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户',
                                      `deleted` tinyint(4) DEFAULT '0' COMMENT '逻辑删除标记位',
                                      `version` bigint(20) DEFAULT '0' COMMENT '乐观锁',
                                      PRIMARY KEY (`collection_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='论坛的收藏日志';

-- ----------------------------
-- Table structure for bbs_comment
-- ----------------------------
DROP TABLE IF EXISTS `bbs_comment`;
CREATE TABLE `bbs_comment` (
                               `comment_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '帖子评论主键',
                               `comment_type` tinyint(4) NOT NULL COMMENT '评论类别 1 帖子 2 评论 3 话题',
                               `pid` bigint(20) NOT NULL COMMENT '上级id',
                               `top_id` bigint(20) DEFAULT NULL COMMENT '最上级id',
                               `level_path` bigint(20) NOT NULL COMMENT '层级路径',
                               `thumbs_cont` bigint(20) DEFAULT NULL COMMENT '点赞数',
                               `ip` varchar(64) NOT NULL DEFAULT '' COMMENT 'IP地址',
                               `ip_loc` varchar(64) NOT NULL DEFAULT '' COMMENT 'IP城市地址',
                               `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                               `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户',
                               `deleted` tinyint(4) DEFAULT '0' COMMENT '逻辑删除标记位',
                               `version` bigint(20) DEFAULT '0' COMMENT '乐观锁',
                               PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='论坛的帖子评论';

-- ----------------------------
-- Table structure for bbs_comment_thumbs_log
-- ----------------------------
DROP TABLE IF EXISTS `bbs_comment_thumbs_log`;
CREATE TABLE `bbs_comment_thumbs_log` (
                                          `thumbs_log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '点赞日志主键',
                                          `comment_id` bigint(20) NOT NULL COMMENT '帖子评论主键',
                                          `thumbs_type` tinyint(4) DEFAULT NULL COMMENT '点赞类型 1 点赞 2踩',
                                          `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                          `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户',
                                          `deleted` tinyint(4) DEFAULT '0' COMMENT '逻辑删除标记位',
                                          `version` bigint(20) DEFAULT '0' COMMENT '乐观锁',
                                          PRIMARY KEY (`thumbs_log_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='评论的点赞日志';

-- ----------------------------
-- Table structure for bbs_feedback_record
-- ----------------------------
DROP TABLE IF EXISTS `bbs_feedback_record`;
CREATE TABLE `bbs_feedback_record` (
                                       `feedback_record_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户反馈主键',
                                       `feedback_text` text NOT NULL COMMENT '反馈内容',
                                       `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                       `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户',
                                       PRIMARY KEY (`feedback_record_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='用户反馈';

-- ----------------------------
-- Table structure for bbs_invitation
-- ----------------------------
DROP TABLE IF EXISTS `bbs_invitation`;
CREATE TABLE `bbs_invitation` (
                                  `invitation_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '帖子主键',
                                  `text_type` tinyint(4) NOT NULL COMMENT '帖子正文类型  1 富文本 2 md',
                                  `category_id` bigint(20) NOT NULL COMMENT '论坛类别',
                                  `type` tinyint(4) NOT NULL COMMENT '帖子类型：0动态、1板块内容',
                                  `topic_id` bigint(20) DEFAULT NULL COMMENT '话题主键 动态可以选择加话题',
                                  `text` text NOT NULL COMMENT '帖子正文',
                                  `article_status` tinyint(4) DEFAULT '0' COMMENT '文章状态 0 待审核 1 审核通过',
                                  `is_top` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否置顶',
                                  `is_essence` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否精华',
                                  `is_lock` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否锁定',
                                  `latest_replied_on` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最新回复时间',
                                  `tag_str` varchar(64) NOT NULL DEFAULT '' COMMENT 'tag字符串,逗号隔开',
                                  `ip` varchar(64) NOT NULL DEFAULT '' COMMENT 'IP地址',
                                  `ip_loc` varchar(64) NOT NULL DEFAULT '' COMMENT 'IP城市地址',
                                  `views_count` bigint(20) DEFAULT NULL COMMENT '浏览数',
                                  `comments_count` bigint(20) DEFAULT NULL COMMENT '评论数',
                                  `comments_status` tinyint(4) DEFAULT NULL COMMENT '评论开关',
                                  `visible_status` tinyint(4) DEFAULT NULL COMMENT '文章可见类型 0 全部可见 1 仅我可见 2 粉丝可见 ',
                                  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户',
                                  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新用户',
                                  `deleted` tinyint(4) DEFAULT '0' COMMENT '逻辑删除标记位',
                                  `version` bigint(20) DEFAULT '0' COMMENT '乐观锁',
                                  PRIMARY KEY (`invitation_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='论坛的帖子';

-- ----------------------------
-- Table structure for bbs_message
-- ----------------------------
DROP TABLE IF EXISTS `bbs_message`;
CREATE TABLE `bbs_message` (
                               `message_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '消息主键',
                               `tips_type` tinyint(4) NOT NULL COMMENT ' 通知类型，1动态，2评论，3帖子回复通知，4评论回复通知 5私信，99系统通知',
                               `message_event_id` bigint(20) NOT NULL COMMENT '产生消息的对应内容的主键',
                               `sender_user_id` bigint(20) NOT NULL COMMENT '发送发用户ID',
                               `receiver_user_id` bigint(20) NOT NULL COMMENT '接收方用户ID',
                               `brief` varchar(255) NOT NULL DEFAULT '' COMMENT '摘要说明',
                               `content` varchar(255) NOT NULL DEFAULT '' COMMENT '详细内容',
                               `tips_status` tinyint(4) NOT NULL COMMENT '状态 0 未读 1 已读',
                               `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                               `deleted` tinyint(4) DEFAULT '0' COMMENT '逻辑删除标记位',
                               PRIMARY KEY (`message_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='论坛的消息';

-- ----------------------------
-- Table structure for bbs_mid_user_category
-- ----------------------------
DROP TABLE IF EXISTS `bbs_mid_user_category`;
CREATE TABLE `bbs_mid_user_category` (
                                         `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
                                         `user_id` bigint(20) NOT NULL COMMENT '用户id',
                                         `category_id` bigint(20) NOT NULL COMMENT '版块id',
                                         `deleted` tinyint(3) NOT NULL COMMENT '是否删除 0 为未删除、1 为已删除',
                                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COMMENT='版主与分类的中间表';




-- ----------------------------
-- Table structure for bbs_mid_user_category_vote
-- ----------------------------
DROP TABLE IF EXISTS `bbs_mid_user_category_vote`;
CREATE TABLE `bbs_mid_user_category_vote` (
                                         `vote_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
                                         `category_id` bigint(20) NOT NULL COMMENT '版块id',
                                         `apply_start_time` datetime DEFAULT NULL COMMENT '申请开始时间(时间范围内允许申请)',
                                         `apply_end_time` datetime DEFAULT NULL COMMENT '申请结束时间',
                                         `vote_start_time` datetime DEFAULT NULL COMMENT '投票开始时间(时间范围内允许投票)',
                                         `vote_end_time` datetime DEFAULT NULL COMMENT '投票结束时间',
                                         `deleted` tinyint(3) NOT NULL COMMENT '是否删除 0 为未删除、1 为已删除',
                                         PRIMARY KEY (`vote_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COMMENT='版主投票表';

-- ----------------------------
-- Table structure for bbs_mid_user_category_vote_apply
-- ----------------------------
DROP TABLE IF EXISTS `bbs_mid_user_category_vote_apply`;
CREATE TABLE `bbs_mid_user_category_vote_apply` (
                                              `apply_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
                                              `category_id` bigint(20) NOT NULL COMMENT '版块id',
                                              `user_id` bigint(20) NOT NULL COMMENT '用户id',
                                              `ticket_count` bigint(20) NOT NULL COMMENT '投票票数',
                                              `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                              `deleted` tinyint(3) NOT NULL COMMENT '是否删除 0 为未删除、1 为已删除',
                                              PRIMARY KEY (`apply_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COMMENT='版主投票申请表';

-- ----------------------------
-- Table structure for bbs_category_vote_apply_log
-- ----------------------------
DROP TABLE IF EXISTS `bbs_category_vote_apply_log`;
CREATE TABLE `bbs_category_vote_apply_log` (
                                    `vote_apply_log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '版主投票记录主键',
                                    `apply_id` bigint(20) unsigned NOT NULL COMMENT '版主投票申请表主键',
                                    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                    `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户',
                                    PRIMARY KEY (`vote_apply_log_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='版主投票记录表';


-- ----------------------------
-- Table structure for bbs_user_category_apply
-- ----------------------------
DROP TABLE IF EXISTS `bbs_user_category_apply`;
CREATE TABLE `bbs_user_category_apply` (
                                         `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
                                         `user_id` bigint(20) NOT NULL COMMENT '用户id',
                                         `status` tinyint(4) NOT NULL COMMENT '状态 0 待审核 1 审核通过 2 审核不通过',
                                         `category_id` bigint(20) NOT NULL COMMENT '版块id',
                                         `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                         `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                         `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新用户',
                                         `deleted` tinyint(4) DEFAULT '0' COMMENT '逻辑删除标记位',
                                         `version` bigint(20) DEFAULT '0' COMMENT '乐观锁',
                                         PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COMMENT='版主申请表';


-- ----------------------------
-- Table structure for bbs_mid_user_role
-- ----------------------------
DROP TABLE IF EXISTS `bbs_mid_user_role`;
CREATE TABLE `bbs_mid_user_role` (
                                     `mid_role_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '中间表主键',
                                     `user_id` bigint(20) NOT NULL COMMENT '用户id',
                                     `role_id` bigint(20) NOT NULL COMMENT '角色id',
                                     `role_code` varchar(20) NOT NULL COMMENT '角色code',
                                     `deleted` tinyint(3) NOT NULL COMMENT '是否删除 0 为未删除、1 为已删除',
                                     PRIMARY KEY (`mid_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='用户角色中间表';

-- ----------------------------
-- Table structure for bbs_punishment
-- ----------------------------
DROP TABLE IF EXISTS `bbs_punishment`;
CREATE TABLE `bbs_punishment` (
                                  `punishment_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '积分惩罚主键',
                                  `user_id` bigint(20) NOT NULL COMMENT '惩罚用户id',
                                  `punishment_basis` text NOT NULL COMMENT '惩罚依据',
                                  `score_count` int(11) NOT NULL COMMENT '惩罚分数',
                                  `punishment_status` tinyint(4) NOT NULL COMMENT '惩罚状态 0 未惩罚 1 已惩罚 3 已撤销',
                                  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户',
                                  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新用户',
                                  `deleted` tinyint(4) DEFAULT '0' COMMENT '逻辑删除标记位',
                                  `version` bigint(20) DEFAULT '0' COMMENT '乐观锁',
                                  PRIMARY KEY (`punishment_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='论坛的惩罚';

-- ----------------------------
-- Table structure for bbs_role
-- ----------------------------
DROP TABLE IF EXISTS `bbs_role`;
CREATE TABLE `bbs_role` (
                            `role_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '角色主键',
                            `role_name` varchar(50) DEFAULT NULL COMMENT '角色名称',
                            `role_code` varchar(20) DEFAULT NULL COMMENT '角色code',
                            `deleted` tinyint(3) DEFAULT NULL COMMENT '是否删除 0 为未删除、1 为已删除',
                            PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for bbs_score_record
-- ----------------------------
DROP TABLE IF EXISTS `bbs_score_record`;
CREATE TABLE `bbs_score_record` (
                                    `score_record_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '积分日志主键',
                                    `score_role_id` bigint(20) NOT NULL COMMENT '积分规则',
                                    `score_count` int(11) NOT NULL COMMENT '具体加的分数 ',
                                    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                    `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户',
                                    `user_id` bigint(20) NOT NULL COMMENT '用户id',
                                    `score_cycle` tinyint(4) DEFAULT NULL COMMENT '积分周期类型(周期内只能得一次分) 0 没有周期(即不限制得分)  1 天 2 周 3 月 4 年 ',
                                    `cycle_count` int(11) unsigned DEFAULT NULL COMMENT '积分周期数',
                                    PRIMARY KEY (`score_record_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='论坛的积分记录';

-- ----------------------------
-- Table structure for bbs_score_role
-- ----------------------------
DROP TABLE IF EXISTS `bbs_score_role`;
CREATE TABLE `bbs_score_role` (
                                  `score_role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '积分规则主键',
                                  `rule_type` tinyint(4) NOT NULL COMMENT '积分类型  1 签到积分 2 发帖积分 3 评论积分 4 惩罚积分',
                                  `add_type` tinyint(4) NOT NULL COMMENT '增减类型  0 减少 1 增加',
                                  `score` bigint(20) DEFAULT NULL COMMENT '可获得的积分数量',
                                  `score_cycle` tinyint(4) NOT NULL COMMENT '积分周期(周期内只能得一次分) 0 没有周期(即不限制得分)  1 天 2 周 3 月 4 年 ',
                                  `effect_time` datetime DEFAULT NULL COMMENT '生效时间,表示此规则什么时候生效,(即周期计算的开始时间)',
                                  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户',
                                  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新用户',
                                  `deleted` tinyint(4) DEFAULT '0' COMMENT '逻辑删除标记位',
                                  `version` bigint(20) DEFAULT '0' COMMENT '乐观锁',
                                  `cycle_num` int(11) DEFAULT NULL COMMENT '周期数字（N天，N周,N年）',
                                  `max_score` bigint(11) DEFAULT NULL COMMENT '周期内最多获取的积分数量（ 0 不限 ）',
                                  PRIMARY KEY (`score_role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='论坛的积分规则配置';

-- ----------------------------
-- Table structure for bbs_tag
-- ----------------------------
DROP TABLE IF EXISTS `bbs_tag`;
CREATE TABLE `bbs_tag` (
                           `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '标签ID',
                           `user_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建者ID',
                           `tag` varchar(255) NOT NULL COMMENT '标签名',
                           `quote_num` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '引用数',
                           `create_time` datetime NOT NULL COMMENT '创建时间',
                           `update_time` datetime NOT NULL COMMENT '修改时间',
                           `deleted_time` datetime NOT NULL COMMENT '删除时间',
                           `deleted` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除 0 为未删除、1 为已删除',
                           PRIMARY KEY (`id`) USING BTREE,
                           UNIQUE KEY `idx_tag` (`tag`) USING BTREE,
                           KEY `idx_user` (`user_id`) USING BTREE,
                           KEY `idx_num` (`quote_num`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='标签';

-- ----------------------------
-- Table structure for bbs_thumbs_log
-- ----------------------------
DROP TABLE IF EXISTS `bbs_thumbs_log`;
CREATE TABLE `bbs_thumbs_log` (
                                  `thumbs_log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '点赞日志主键',
                                  `invitation_id` bigint(20) NOT NULL COMMENT '帖子主键',
                                  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户',
                                  `deleted` tinyint(4) DEFAULT '0' COMMENT '逻辑删除标记位',
                                  `version` bigint(20) DEFAULT '0' COMMENT '乐观锁',
                                  PRIMARY KEY (`thumbs_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='论坛的点赞日志';

-- ----------------------------
-- Table structure for bbs_topic
-- ----------------------------
DROP TABLE IF EXISTS `bbs_topic`;
CREATE TABLE `bbs_topic` (
                             `topic_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '话题主键',
                             `topic_title` varchar(100) NOT NULL COMMENT '话题标题',
                             `topic_content` varchar(255) NOT NULL COMMENT '话题内容',
                             `topic_status` tinyint(4) DEFAULT '0' COMMENT '话题状态 0 待审核  1 审核通过 2 审核不通过 ',
                             `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                             `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户',
                             PRIMARY KEY (`topic_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='话题';

-- ----------------------------
-- Table structure for bbs_user
-- ----------------------------
DROP TABLE IF EXISTS `bbs_user`;
CREATE TABLE `bbs_user` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT,
                            `username` varchar(32) NOT NULL COMMENT '用户名',
                            `password` varchar(32) NOT NULL COMMENT '密码',
                            `salt` varchar(32) NOT NULL COMMENT 'salt',
                            `avatar` varchar(500) NOT NULL DEFAULT '' COMMENT '用户头像',
                            `nickname` varchar(32) NOT NULL DEFAULT '' COMMENT '昵称',
                            `register_time` datetime NOT NULL COMMENT '注册时间',
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='用户表';

-- ----------------------------
-- Table structure for bbs_user_black_list
-- ----------------------------
DROP TABLE IF EXISTS `bbs_user_black_list`;
CREATE TABLE `bbs_user_black_list` (
                                       `black_list_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '黑名单主键',
                                       `black_user_id` bigint(20) NOT NULL COMMENT '拉黑的人',
                                       `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                       `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户',
                                       PRIMARY KEY (`black_list_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='用户黑名单';

-- ----------------------------
-- Table structure for bbs_user_follower_list
-- ----------------------------
DROP TABLE IF EXISTS `bbs_user_follower_list`;
CREATE TABLE `bbs_user_follower_list` (
                                          `follower_list_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '关注主键',
                                          `follower_user_id` bigint(20) NOT NULL COMMENT '拉黑的人',
                                          `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                          `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户',
                                          PRIMARY KEY (`follower_list_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='用户关注名单';

-- ----------------------------
-- Table structure for bbs_user_score
-- ----------------------------
DROP TABLE IF EXISTS `bbs_user_score`;
CREATE TABLE `bbs_user_score` (
                                  `score_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户总分主键',
                                  `sum_score` bigint(20) unsigned NOT NULL COMMENT '总分',
                                  `current_score` bigint(20) unsigned NOT NULL COMMENT '当前的分数',
                                  `user_id` bigint(20) NOT NULL COMMENT '用户id',
                                  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户',
                                  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新用户',
                                  PRIMARY KEY (`score_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='用户积分';

SET FOREIGN_KEY_CHECKS = 1;

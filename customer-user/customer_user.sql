/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1(root@root123@）
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : customer_user

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 03/08/2022 17:14:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for customer_user
-- ----------------------------
DROP TABLE IF EXISTS `customer_user`;
CREATE TABLE `customer_user` (
  `id` bigint NOT NULL COMMENT '主键',
  `deleted` tinyint DEFAULT '0' COMMENT '逻辑删除标记位',
  `version` bigint DEFAULT '0' COMMENT '乐观锁',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '姓名',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '联系方式',
  `grade` tinyint DEFAULT NULL COMMENT '性别',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `register_time` datetime DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户信息表';

-- ----------------------------
-- Table structure for customer_user_0
-- ----------------------------
DROP TABLE IF EXISTS `customer_user_0`;
CREATE TABLE `customer_user_0` (
  `id` bigint NOT NULL COMMENT '主键',
  `deleted` tinyint DEFAULT '0' COMMENT '逻辑删除标记位',
  `version` bigint DEFAULT '0' COMMENT '乐观锁',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '姓名',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '联系方式',
  `grade` tinyint DEFAULT NULL COMMENT '性别',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `register_time` datetime DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户信息表';

-- ----------------------------
-- Table structure for customer_user_1
-- ----------------------------
DROP TABLE IF EXISTS `customer_user_1`;
CREATE TABLE `customer_user_1` (
  `id` bigint NOT NULL COMMENT '主键',
  `deleted` tinyint DEFAULT '0' COMMENT '逻辑删除标记位',
  `version` bigint DEFAULT '0' COMMENT '乐观锁',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '姓名',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '联系方式',
  `grade` tinyint DEFAULT NULL COMMENT '性别',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `register_time` datetime DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户信息表';

-- ----------------------------
-- Table structure for customer_user_2
-- ----------------------------
DROP TABLE IF EXISTS `customer_user_2`;
CREATE TABLE `customer_user_2` (
  `id` bigint NOT NULL COMMENT '主键',
  `deleted` tinyint DEFAULT '0' COMMENT '逻辑删除标记位',
  `version` bigint DEFAULT '0' COMMENT '乐观锁',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '姓名',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '联系方式',
  `grade` tinyint DEFAULT NULL COMMENT '性别',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `register_time` datetime DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户信息表';

-- ----------------------------
-- Table structure for customer_user_black
-- ----------------------------
DROP TABLE IF EXISTS `customer_user_black`;
CREATE TABLE `customer_user_black` (
  `id` bigint NOT NULL COMMENT '主键',
  `user_id` bigint DEFAULT NULL COMMENT '用户id',
  `black_user_id` bigint DEFAULT NULL COMMENT '被拉黑的用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户拉黑表';

-- ----------------------------
-- Table structure for customer_user_black_0
-- ----------------------------
DROP TABLE IF EXISTS `customer_user_black_0`;
CREATE TABLE `customer_user_black_0` (
  `id` bigint NOT NULL COMMENT '主键',
  `user_id` bigint DEFAULT NULL COMMENT '用户id',
  `black_user_id` bigint DEFAULT NULL COMMENT '被拉黑的用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户拉黑表';

-- ----------------------------
-- Table structure for customer_user_black_1
-- ----------------------------
DROP TABLE IF EXISTS `customer_user_black_1`;
CREATE TABLE `customer_user_black_1` (
  `id` bigint NOT NULL COMMENT '主键',
  `user_id` bigint DEFAULT NULL COMMENT '用户id',
  `black_user_id` bigint DEFAULT NULL COMMENT '被拉黑的用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户拉黑表';

-- ----------------------------
-- Table structure for customer_user_black_2
-- ----------------------------
DROP TABLE IF EXISTS `customer_user_black_2`;
CREATE TABLE `customer_user_black_2` (
  `id` bigint NOT NULL COMMENT '主键',
  `user_id` bigint DEFAULT NULL COMMENT '用户id',
  `black_user_id` bigint DEFAULT NULL COMMENT '被拉黑的用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户拉黑表';

-- ----------------------------
-- Table structure for customer_user_dynamic
-- ----------------------------
DROP TABLE IF EXISTS `customer_user_dynamic`;
CREATE TABLE `customer_user_dynamic` (
  `id` bigint NOT NULL COMMENT '主键',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `deleted` tinyint DEFAULT '0' COMMENT '逻辑删除标记位',
  `user_id` bigint DEFAULT NULL COMMENT '用户id',
  `content` varchar(255) DEFAULT NULL COMMENT '动态内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户动态表';

-- ----------------------------
-- Table structure for customer_user_message
-- ----------------------------
DROP TABLE IF EXISTS `customer_user_message`;
CREATE TABLE `customer_user_message` (
  `id` bigint NOT NULL COMMENT '主键',
  `from_user_id` bigint DEFAULT NULL COMMENT '发送人id',
  `content` varchar(255) DEFAULT NULL COMMENT '动态内容',
  `to_user_id` bigint DEFAULT NULL COMMENT '接收人id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户私信表';

-- ----------------------------
-- Table structure for customer_user_white
-- ----------------------------
DROP TABLE IF EXISTS `customer_user_white`;
CREATE TABLE `customer_user_white` (
  `id` bigint NOT NULL COMMENT '主键',
  `user_id` bigint DEFAULT NULL COMMENT '用户id',
  `white_user_id` bigint DEFAULT NULL COMMENT '关注的用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户关注表';

-- ----------------------------
-- Table structure for customer_user_white_0
-- ----------------------------
DROP TABLE IF EXISTS `customer_user_white_0`;
CREATE TABLE `customer_user_white_0` (
  `id` bigint NOT NULL COMMENT '主键',
  `user_id` bigint DEFAULT NULL COMMENT '用户id',
  `white_user_id` bigint DEFAULT NULL COMMENT '关注的用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户关注表';

-- ----------------------------
-- Table structure for customer_user_white_1
-- ----------------------------
DROP TABLE IF EXISTS `customer_user_white_1`;
CREATE TABLE `customer_user_white_1` (
  `id` bigint NOT NULL COMMENT '主键',
  `user_id` bigint DEFAULT NULL COMMENT '用户id',
  `white_user_id` bigint DEFAULT NULL COMMENT '关注的用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户关注表';

-- ----------------------------
-- Table structure for customer_user_white_2
-- ----------------------------
DROP TABLE IF EXISTS `customer_user_white_2`;
CREATE TABLE `customer_user_white_2` (
  `id` bigint NOT NULL COMMENT '主键',
  `user_id` bigint DEFAULT NULL COMMENT '用户id',
  `white_user_id` bigint DEFAULT NULL COMMENT '关注的用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户关注表';

SET FOREIGN_KEY_CHECKS = 1;

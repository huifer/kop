/*
 Navicat Premium Data Transfer

 Source Server         : 42.193.114.160
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : 42.193.114.160:53306
 Source Schema         : questionnaire

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 07/09/2022 19:24:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `survey_history_id` int(11) NULL DEFAULT NULL COMMENT '问卷历史id',
  `question_id` int(11) NULL DEFAULT NULL COMMENT '问题id',
  `option_id` int(11) NULL DEFAULT NULL COMMENT '选项id',
  `option_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '选项内容',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '答题人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '问卷结果表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for option
-- ----------------------------
DROP TABLE IF EXISTS `option`;
CREATE TABLE `option`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `survey_id` int(11) NULL DEFAULT NULL COMMENT '问卷id',
  `question_id` int(11) NULL DEFAULT NULL COMMENT '问题表',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '选项名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '问题选项表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for option_image
-- ----------------------------
DROP TABLE IF EXISTS `option_image`;
CREATE TABLE `option_image`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `survey_id` int(11) NULL DEFAULT NULL COMMENT '问卷id',
  `question_id` int(11) NULL DEFAULT NULL COMMENT '问题表',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '选项名称',
  `source_id` int(11) NULL DEFAULT NULL COMMENT '选项表id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '问题选项表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `survey_id` int(11) NULL DEFAULT NULL COMMENT '问卷id',
  `type` tinyint(2) NULL DEFAULT NULL COMMENT '1 单选 2多选 3填空',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '题目名称',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序号',
  `require` tinyint(4) NULL DEFAULT NULL COMMENT '是否必填',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '问题表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for question_image
-- ----------------------------
DROP TABLE IF EXISTS `question_image`;
CREATE TABLE `question_image`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `survey_id` int(11) NULL DEFAULT NULL COMMENT '问卷id',
  `type` tinyint(2) NULL DEFAULT NULL COMMENT '1 单选 2多选 3填空',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '题目名称',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序号',
  `require` tinyint(4) NULL DEFAULT NULL COMMENT '是否必填',
  `source_id` int(11) NULL DEFAULT NULL COMMENT '问题表id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '问题表镜像' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for survey
-- ----------------------------
DROP TABLE IF EXISTS `survey`;
CREATE TABLE `survey`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '1发布 2 未发布',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '问卷表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for survey_history
-- ----------------------------
DROP TABLE IF EXISTS `survey_history`;
CREATE TABLE `survey_history`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sv` int(255) NULL DEFAULT NULL,
  `survey_id` int(255) NULL DEFAULT NULL,
  `used` tinyint(2) NULL DEFAULT NULL COMMENT '1. 使用\r\n0. 未使用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '问卷历史表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

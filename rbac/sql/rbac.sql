/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1(root@root123@）
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : rbac

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 02/08/2022 17:10:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for rbac_app
-- ----------------------------
DROP TABLE IF EXISTS `rbac_app`;
CREATE TABLE `rbac_app` (
  `id` bigint NOT NULL COMMENT '主键',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint DEFAULT NULL COMMENT '更新用户',
  `deleted` tinyint DEFAULT '0' COMMENT '逻辑删除标记位',
  `version` bigint DEFAULT '0' COMMENT '乐观锁',
  `name` varchar(255) DEFAULT NULL COMMENT '应用名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for rbac_company
-- ----------------------------
DROP TABLE IF EXISTS `rbac_company`;
CREATE TABLE `rbac_company` (
  `id` bigint NOT NULL COMMENT '主键',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint DEFAULT NULL COMMENT '更新用户',
  `deleted` tinyint DEFAULT '0' COMMENT '逻辑删除标记位',
  `version` bigint DEFAULT '0' COMMENT '乐观锁',
  `name` varchar(255) NOT NULL COMMENT '企业名称',
  `address` varchar(255) DEFAULT NULL COMMENT '企业地址',
  `social_credit_code` varchar(255) DEFAULT NULL COMMENT '社会信用编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='企业表';

-- ----------------------------
-- Table structure for rbac_dept
-- ----------------------------
DROP TABLE IF EXISTS `rbac_dept`;
CREATE TABLE `rbac_dept` (
  `id` bigint NOT NULL COMMENT '主键',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint DEFAULT NULL COMMENT '更新用户',
  `deleted` tinyint DEFAULT '0' COMMENT '逻辑删除标记位',
  `version` bigint DEFAULT '0' COMMENT '乐观锁',
  `name` varchar(255) DEFAULT NULL COMMENT '部门名称',
  `desc` varchar(255) DEFAULT NULL COMMENT '部门介绍',
  `sort` int DEFAULT NULL COMMENT '排序号',
  `pid` bigint DEFAULT NULL COMMENT '父级id',
  `company_id` bigint DEFAULT NULL COMMENT '企业id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='部门表';

-- ----------------------------
-- Table structure for rbac_post
-- ----------------------------
DROP TABLE IF EXISTS `rbac_post`;
CREATE TABLE `rbac_post` (
  `id` bigint NOT NULL COMMENT '主键',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint DEFAULT NULL COMMENT '更新用户',
  `deleted` tinyint DEFAULT '0' COMMENT '逻辑删除标记位',
  `version` bigint DEFAULT '0' COMMENT '乐观锁',
  `name` varchar(255) DEFAULT NULL COMMENT '岗位名称',
  `dept_id` bigint DEFAULT NULL COMMENT '部门id',
  `company_id` bigint DEFAULT NULL COMMENT '企业id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='岗位表';

-- ----------------------------
-- Table structure for rbac_resource
-- ----------------------------
DROP TABLE IF EXISTS `rbac_resource`;
CREATE TABLE `rbac_resource` (
  `id` bigint NOT NULL COMMENT '主键',
  `code` varchar(255) DEFAULT NULL COMMENT '资源编码',
  `name` varchar(255) DEFAULT NULL COMMENT '资源名称',
  `type` varchar(255) DEFAULT NULL COMMENT '资源类型(1,菜单，2接口，3按钮',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint DEFAULT NULL COMMENT '更新用户',
  `deleted` tinyint DEFAULT '0' COMMENT '逻辑删除标记位',
  `version` bigint DEFAULT '0' COMMENT '乐观锁',
  `app_id` bigint DEFAULT NULL COMMENT '应用id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='资源表';

-- ----------------------------
-- Table structure for rbac_role
-- ----------------------------
DROP TABLE IF EXISTS `rbac_role`;
CREATE TABLE `rbac_role` (
  `id` bigint NOT NULL COMMENT '主键',
  `code` varchar(255) DEFAULT NULL COMMENT '角色编码',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `desc` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint DEFAULT NULL COMMENT '更新用户',
  `deleted` tinyint DEFAULT '0' COMMENT '逻辑删除标记位',
  `version` bigint DEFAULT '0' COMMENT '乐观锁',
  `company_id` bigint DEFAULT NULL COMMENT '企业id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色';

-- ----------------------------
-- Table structure for rbac_role_bind_group
-- ----------------------------
DROP TABLE IF EXISTS `rbac_role_bind_group`;
CREATE TABLE `rbac_role_bind_group` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` bigint DEFAULT NULL COMMENT '角色表id',
  `role_group_id` bigint DEFAULT NULL COMMENT '角色组表id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint DEFAULT NULL COMMENT '更新用户',
  `deleted` tinyint DEFAULT '0' COMMENT '逻辑删除标记位',
  `version` bigint DEFAULT '0' COMMENT '乐观锁',
  `company_id` bigint DEFAULT NULL COMMENT '企业id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色与角色组关系表，N:N';

-- ----------------------------
-- Table structure for rbac_role_bind_resource
-- ----------------------------
DROP TABLE IF EXISTS `rbac_role_bind_resource`;
CREATE TABLE `rbac_role_bind_resource` (
  `id` bigint NOT NULL,
  `role_id` bigint DEFAULT NULL COMMENT '角色表id',
  `resource_id` bigint DEFAULT NULL COMMENT '资源表id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint DEFAULT NULL COMMENT '更新用户',
  `deleted` tinyint DEFAULT '0' COMMENT '逻辑删除标记位',
  `version` bigint DEFAULT '0' COMMENT '乐观锁',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色与资源关系表';

-- ----------------------------
-- Table structure for rbac_role_bind_view
-- ----------------------------
DROP TABLE IF EXISTS `rbac_role_bind_view`;
CREATE TABLE `rbac_role_bind_view` (
  `id` bigint NOT NULL COMMENT '主键',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint DEFAULT NULL COMMENT '更新用户',
  `deleted` tinyint DEFAULT '0' COMMENT '逻辑删除标记位',
  `version` bigint DEFAULT '0' COMMENT '乐观锁',
  `role_id` bigint DEFAULT NULL COMMENT '角色id',
  `view_id` bigint DEFAULT NULL COMMENT '视图id',
  `resource_id` bigint DEFAULT NULL COMMENT '资源id',
  `company_id` bigint DEFAULT NULL COMMENT '企业id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='角色实体图绑定表';

-- ----------------------------
-- Table structure for rbac_role_group
-- ----------------------------
DROP TABLE IF EXISTS `rbac_role_group`;
CREATE TABLE `rbac_role_group` (
  `id` bigint NOT NULL COMMENT '主键',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint DEFAULT NULL COMMENT '更新用户',
  `deleted` tinyint DEFAULT '0' COMMENT '逻辑删除标记位',
  `version` bigint DEFAULT '0' COMMENT '乐观锁',
  `name` varchar(255) DEFAULT NULL COMMENT '角色组名称',
  `company_id` bigint DEFAULT NULL COMMENT '企业id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色组表';

-- ----------------------------
-- Table structure for rbac_user
-- ----------------------------
DROP TABLE IF EXISTS `rbac_user`;
CREATE TABLE `rbac_user` (
  `id` bigint NOT NULL COMMENT '主键',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint DEFAULT NULL COMMENT '更新用户',
  `deleted` tinyint DEFAULT '0' COMMENT '逻辑删除标记位',
  `version` bigint DEFAULT '0' COMMENT '乐观锁',
  `name` varchar(10) DEFAULT NULL COMMENT '姓名',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系方式',
  `grade` tinyint DEFAULT NULL COMMENT '性别',
  `company_id` bigint DEFAULT NULL COMMENT '企业id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';

-- ----------------------------
-- Table structure for rbac_user_bind_dept
-- ----------------------------
DROP TABLE IF EXISTS `rbac_user_bind_dept`;
CREATE TABLE `rbac_user_bind_dept` (
  `id` bigint NOT NULL COMMENT '主键',
  `user_id` bigint DEFAULT NULL COMMENT '用户id',
  `dept_Id` bigint DEFAULT NULL COMMENT '部门id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint DEFAULT NULL COMMENT '更新用户',
  `deleted` tinyint DEFAULT '0' COMMENT '逻辑删除标记位',
  `version` bigint DEFAULT '0' COMMENT '乐观锁',
  `company_id` bigint DEFAULT NULL COMMENT '企业id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户部门绑定表';

-- ----------------------------
-- Table structure for rbac_user_bind_post
-- ----------------------------
DROP TABLE IF EXISTS `rbac_user_bind_post`;
CREATE TABLE `rbac_user_bind_post` (
  `id` bigint NOT NULL COMMENT '主键',
  `user_id` bigint DEFAULT NULL COMMENT '用户id',
  `post_id` bigint DEFAULT NULL COMMENT '岗位id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint DEFAULT NULL COMMENT '更新用户',
  `deleted` tinyint DEFAULT '0' COMMENT '逻辑删除标记位',
  `version` bigint DEFAULT '0' COMMENT '乐观锁',
  `company_id` bigint DEFAULT NULL COMMENT '企业id',
  `main` tinyint DEFAULT NULL COMMENT '主职',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户与岗位关系表';

-- ----------------------------
-- Table structure for rbac_user_bind_role
-- ----------------------------
DROP TABLE IF EXISTS `rbac_user_bind_role`;
CREATE TABLE `rbac_user_bind_role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL COMMENT '用户表id',
  `role_id` bigint DEFAULT NULL COMMENT '角色表id',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint DEFAULT NULL COMMENT '更新用户',
  `deleted` tinyint DEFAULT '0' COMMENT '逻辑删除标记位',
  `version` bigint DEFAULT '0' COMMENT '乐观锁',
  `company_id` bigint DEFAULT NULL COMMENT '企业id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户和角色表，区别于角色组关系表，这里是不满足的情况下进行使用';

-- ----------------------------
-- Table structure for rbac_user_bind_role_group
-- ----------------------------
DROP TABLE IF EXISTS `rbac_user_bind_role_group`;
CREATE TABLE `rbac_user_bind_role_group` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL COMMENT '用户表id',
  `role_group_id` bigint DEFAULT NULL COMMENT '角色组id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint DEFAULT NULL COMMENT '更新用户',
  `deleted` tinyint DEFAULT '0' COMMENT '逻辑删除标记位',
  `version` bigint DEFAULT '0' COMMENT '乐观锁',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户与角色组关联表';

-- ----------------------------
-- Table structure for rbac_view
-- ----------------------------
DROP TABLE IF EXISTS `rbac_view`;
CREATE TABLE `rbac_view` (
  `id` bigint NOT NULL COMMENT '主键',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint DEFAULT NULL COMMENT '更新用户',
  `deleted` tinyint DEFAULT '0' COMMENT '逻辑删除标记位',
  `version` bigint DEFAULT '0' COMMENT '乐观锁',
  `name` varchar(255) DEFAULT NULL COMMENT '视图名称',
  `value` varchar(255) DEFAULT NULL COMMENT '视图值',
  `company_id` bigint DEFAULT NULL COMMENT '企业id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='视图表';

SET FOREIGN_KEY_CHECKS = 1;

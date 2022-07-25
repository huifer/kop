/*
 Navicat Premium Data Transfer

 Source Server         : 106.12.117.221_3306
 Source Server Type    : MariaDB
 Source Server Version : 100803
 Source Host           : 106.12.117.221:3306
 Source Schema         : rbac

 Target Server Type    : MariaDB
 Target Server Version : 100803
 File Encoding         : 65001

 Date: 25/07/2022 15:38:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for rbac_company
-- ----------------------------
DROP TABLE IF EXISTS `rbac_company`;
CREATE TABLE `rbac_company` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新用户',
  `deleted` tinyint(4) DEFAULT 0 COMMENT '逻辑删除标记位',
  `version` bigint(20) DEFAULT 0 COMMENT '乐观锁',
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
  `id` bigint(20) NOT NULL COMMENT '主键',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新用户',
  `deleted` tinyint(4) DEFAULT 0 COMMENT '逻辑删除标记位',
  `version` bigint(20) DEFAULT 0 COMMENT '乐观锁',
  `name` varchar(255) DEFAULT NULL COMMENT '部门名称',
  `desc` varchar(255) DEFAULT NULL COMMENT '部门介绍',
  `sort` int(11) DEFAULT NULL COMMENT '排序号',
  `pid` bigint(20) DEFAULT NULL COMMENT '父级id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='部门表';

-- ----------------------------
-- Table structure for rbac_post
-- ----------------------------
DROP TABLE IF EXISTS `rbac_post`;
CREATE TABLE `rbac_post` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新用户',
  `deleted` tinyint(4) DEFAULT 0 COMMENT '逻辑删除标记位',
  `version` bigint(20) DEFAULT 0 COMMENT '乐观锁',
  `name` varchar(255) DEFAULT NULL COMMENT '岗位名称',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='岗位表';

-- ----------------------------
-- Table structure for rbac_resource
-- ----------------------------
DROP TABLE IF EXISTS `rbac_resource`;
CREATE TABLE `rbac_resource` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `code` varchar(255) DEFAULT NULL COMMENT '资源编码',
  `name` varchar(255) DEFAULT NULL COMMENT '资源名称',
  `type` varchar(255) DEFAULT NULL COMMENT '资源类型(1,菜单，2接口，3按钮',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新用户',
  `deleted` tinyint(4) DEFAULT 0 COMMENT '逻辑删除标记位',
  `version` bigint(20) DEFAULT 0 COMMENT '乐观锁',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='资源表';

-- ----------------------------
-- Table structure for rbac_role
-- ----------------------------
DROP TABLE IF EXISTS `rbac_role`;
CREATE TABLE `rbac_role` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `code` varchar(255) DEFAULT NULL COMMENT '角色编码',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `desc` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新用户',
  `deleted` tinyint(4) DEFAULT 0 COMMENT '逻辑删除标记位',
  `version` bigint(20) DEFAULT 0 COMMENT '乐观锁',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色';

-- ----------------------------
-- Table structure for rbac_role_bind_group
-- ----------------------------
DROP TABLE IF EXISTS `rbac_role_bind_group`;
CREATE TABLE `rbac_role_bind_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色表id',
  `role_group_id` bigint(20) DEFAULT NULL COMMENT '角色组表id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新用户',
  `deleted` tinyint(4) DEFAULT 0 COMMENT '逻辑删除标记位',
  `version` bigint(20) DEFAULT 0 COMMENT '乐观锁',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色与角色组关系表，N:N';

-- ----------------------------
-- Table structure for rbac_role_bind_resource
-- ----------------------------
DROP TABLE IF EXISTS `rbac_role_bind_resource`;
CREATE TABLE `rbac_role_bind_resource` (
  `id` bigint(20) NOT NULL,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色表id',
  `resource_id` bigint(20) DEFAULT NULL COMMENT '资源表id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新用户',
  `deleted` tinyint(4) DEFAULT 0 COMMENT '逻辑删除标记位',
  `version` bigint(20) DEFAULT 0 COMMENT '乐观锁',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色与资源关系表';

-- ----------------------------
-- Table structure for rbac_role_bind_view
-- ----------------------------
DROP TABLE IF EXISTS `rbac_role_bind_view`;
CREATE TABLE `rbac_role_bind_view` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新用户',
  `deleted` tinyint(4) DEFAULT 0 COMMENT '逻辑删除标记位',
  `version` bigint(20) DEFAULT 0 COMMENT '乐观锁',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  `view_id` bigint(20) DEFAULT NULL COMMENT '视图id',
  `resource_id` bigint(20) DEFAULT NULL COMMENT '资源id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='角色实体图绑定表';

-- ----------------------------
-- Table structure for rbac_role_group
-- ----------------------------
DROP TABLE IF EXISTS `rbac_role_group`;
CREATE TABLE `rbac_role_group` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新用户',
  `deleted` tinyint(4) DEFAULT 0 COMMENT '逻辑删除标记位',
  `version` bigint(20) DEFAULT 0 COMMENT '乐观锁',
  `name` varchar(255) DEFAULT NULL COMMENT '角色组名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色组表';

-- ----------------------------
-- Table structure for rbac_user
-- ----------------------------
DROP TABLE IF EXISTS `rbac_user`;
CREATE TABLE `rbac_user` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新用户',
  `deleted` tinyint(4) DEFAULT 0 COMMENT '逻辑删除标记位',
  `version` bigint(20) DEFAULT 0 COMMENT '乐观锁',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- ----------------------------
-- Table structure for rbac_user_bind_dept
-- ----------------------------
DROP TABLE IF EXISTS `rbac_user_bind_dept`;
CREATE TABLE `rbac_user_bind_dept` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `dept_Id` bigint(20) DEFAULT NULL COMMENT '部门id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新用户',
  `deleted` tinyint(4) DEFAULT 0 COMMENT '逻辑删除标记位',
  `version` bigint(20) DEFAULT 0 COMMENT '乐观锁',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户部门绑定表';

-- ----------------------------
-- Table structure for rbac_user_bind_post
-- ----------------------------
DROP TABLE IF EXISTS `rbac_user_bind_post`;
CREATE TABLE `rbac_user_bind_post` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `post_id` bigint(20) DEFAULT NULL COMMENT '岗位id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新用户',
  `deleted` tinyint(4) DEFAULT 0 COMMENT '逻辑删除标记位',
  `version` bigint(20) DEFAULT 0 COMMENT '乐观锁',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户与岗位关系表';

-- ----------------------------
-- Table structure for rbac_user_bind_role
-- ----------------------------
DROP TABLE IF EXISTS `rbac_user_bind_role`;
CREATE TABLE `rbac_user_bind_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户表id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色表id',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新用户',
  `deleted` tinyint(4) DEFAULT 0 COMMENT '逻辑删除标记位',
  `version` bigint(20) DEFAULT 0 COMMENT '乐观锁',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COMMENT='用户和角色表，区别于角色组关系表，这里是不满足的情况下进行使用';

-- ----------------------------
-- Table structure for rbac_user_bind_role_group
-- ----------------------------
DROP TABLE IF EXISTS `rbac_user_bind_role_group`;
CREATE TABLE `rbac_user_bind_role_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户表id',
  `role_group_id` bigint(20) DEFAULT NULL COMMENT '角色组id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新用户',
  `deleted` tinyint(4) DEFAULT 0 COMMENT '逻辑删除标记位',
  `version` bigint(20) DEFAULT 0 COMMENT '乐观锁',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户与角色组关联表';

-- ----------------------------
-- Table structure for rbac_view
-- ----------------------------
DROP TABLE IF EXISTS `rbac_view`;
CREATE TABLE `rbac_view` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新用户',
  `deleted` tinyint(4) DEFAULT 0 COMMENT '逻辑删除标记位',
  `version` bigint(20) DEFAULT 0 COMMENT '乐观锁',
  `name` varchar(255) DEFAULT NULL COMMENT '视图名称',
  `value` varchar(255) DEFAULT NULL COMMENT '视图值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='视图表';

SET FOREIGN_KEY_CHECKS = 1;

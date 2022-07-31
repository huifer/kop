DROP TABLE
IF
	EXISTS `blog_category`;
CREATE TABLE `blog_category` (
	`category_id` BIGINT ( 20 ) AUTO_INCREMENT NOT NULL COMMENT '分类主键',
	`category_name` VARCHAR ( 255 ) NOT NULL COMMENT '分类名称',
	`category_icon` VARCHAR ( 255 ) NOT NULL COMMENT '分类图标',
	`parent_id` BIGINT ( 20 ) DEFAULT NULL COMMENT '上级id',
	`create_time` datetime DEFAULT NULL COMMENT '创建时间',
	`create_user_id` BIGINT ( 20 ) DEFAULT NULL COMMENT '创建用户',
	`update_time` datetime DEFAULT NULL COMMENT '更新时间',
	`update_user_id` BIGINT ( 20 ) DEFAULT NULL COMMENT '更新用户',
	`deleted` TINYINT ( 4 ) DEFAULT 0 COMMENT '逻辑删除标记位',
	`version` BIGINT ( 20 ) DEFAULT 0 COMMENT '乐观锁',
PRIMARY KEY ( `category_id` ) 
) ENGINE = INNODB DEFAULT CHARSET = utf8mb3 COMMENT = '博客的分类';
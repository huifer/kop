DROP TABLE
IF
	EXISTS `blog_special_column`;
CREATE TABLE `blog_special_column` (
	`special_column_id` BIGINT ( 20 ) AUTO_INCREMENT NOT NULL COMMENT '专栏主键',
	`special_column_title` VARCHAR ( 100 ) NOT NULL COMMENT '专栏标题',
	`special_column_desc` VARCHAR ( 100 ) NOT NULL COMMENT '专栏简介',
	`parent_id` BIGINT ( 20 ) COMMENT '父级id',
	`level_path` VARCHAR ( 255 ) COMMENT '层级路径',
	`img` VARCHAR ( 255 ) COMMENT '专栏图片',
	`comments_count` BIGINT ( 20 ) COMMENT '订阅数量',
	`create_time` datetime DEFAULT NULL COMMENT '创建时间',
	`create_user_id` BIGINT ( 20 ) DEFAULT NULL COMMENT '创建用户',
	`update_time` datetime DEFAULT NULL COMMENT '更新时间',
	`update_user_id` BIGINT ( 20 ) DEFAULT NULL COMMENT '更新用户',
	`deleted` TINYINT ( 4 ) DEFAULT 0 COMMENT '逻辑删除标记位',
	`version` BIGINT ( 20 ) DEFAULT 0 COMMENT '乐观锁',
PRIMARY KEY ( `special_column_id` ) 
) ENGINE = INNODB DEFAULT CHARSET = utf8mb3 COMMENT = '博客的专栏';
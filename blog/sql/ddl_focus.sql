DROP TABLE
IF
EXISTS `blog_focus`;
CREATE TABLE `blog_focus` (
	`focus_id` BIGINT ( 20 ) AUTO_INCREMENT NOT NULL COMMENT '关注主键',
	`id_to_type` BIGINT ( 20 ) NOT NULL COMMENT '关注的对应类型的主键',
	`focus_type` TINYINT ( 4 )  COMMENT '关注的类型 1 人 2 文章 3 专栏',
	`create_time` datetime DEFAULT NULL COMMENT '创建时间',
	`create_user_id` BIGINT ( 20 ) DEFAULT NULL COMMENT '创建用户',
	`update_time` datetime DEFAULT NULL COMMENT '更新时间',
	`update_user_id` BIGINT ( 20 ) DEFAULT NULL COMMENT '更新用户',
	`deleted` TINYINT ( 4 ) DEFAULT 0 COMMENT '逻辑删除标记位',
	`version` BIGINT ( 20 ) DEFAULT 0 COMMENT '乐观锁',
PRIMARY KEY ( `focus_id` ) 
) ENGINE = INNODB DEFAULT CHARSET = utf8mb3 COMMENT = '博客的关注';
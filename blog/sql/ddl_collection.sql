DROP TABLE
IF
EXISTS `blog_collection`;
CREATE TABLE `blog_collection` (
	`collection_id` BIGINT ( 20 ) AUTO_INCREMENT NOT NULL COMMENT '收藏主键',
	`article_id` BIGINT ( 20 ) NOT NULL COMMENT '文章的主键',
	`create_time` datetime DEFAULT NULL COMMENT '创建时间',
	`create_user_id` BIGINT ( 20 ) DEFAULT NULL COMMENT '创建用户',
	`update_time` datetime DEFAULT NULL COMMENT '更新时间',
	`update_user_id` BIGINT ( 20 ) DEFAULT NULL COMMENT '更新用户',
	`deleted` TINYINT ( 4 ) DEFAULT 0 COMMENT '逻辑删除标记位',
	`version` BIGINT ( 20 ) DEFAULT 0 COMMENT '乐观锁',
PRIMARY KEY ( `collection_id` ) 
) ENGINE = INNODB DEFAULT CHARSET = utf8mb3 COMMENT = '博客的收藏';
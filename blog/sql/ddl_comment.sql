DROP TABLE
IF
EXISTS `blog_comment`;
CREATE TABLE `blog_comment` (
	`comment_id` BIGINT ( 20 ) AUTO_INCREMENT NOT NULL COMMENT '评论主键',
	`article_id` BIGINT ( 20 ) NOT NULL COMMENT '文章id',
	`comment_content` VARCHAR ( 200 ) NOT NULL COMMENT '评论内容',
	`ip_belonging` VARCHAR ( 200 ) NOT NULL COMMENT 'ip归属',
	`thumbs_cont` BIGINT ( 20 ) COMMENT '点赞数',
	`placed_top_status` TINYINT ( 4 ) DEFAULT 0 COMMENT '是否置顶 0 否 1 是',
	`create_time` datetime DEFAULT NULL COMMENT '创建时间',
	`create_user_id` BIGINT ( 20 ) DEFAULT NULL COMMENT '创建用户',
	`update_time` datetime DEFAULT NULL COMMENT '更新时间',
	`update_user_id` BIGINT ( 20 ) DEFAULT NULL COMMENT '更新用户',
	`deleted` TINYINT ( 4 ) DEFAULT 0 COMMENT '逻辑删除标记位',
	`version` BIGINT ( 20 ) DEFAULT 0 COMMENT '乐观锁',
PRIMARY KEY ( `comment_id` ) 
) ENGINE = INNODB DEFAULT CHARSET = utf8mb3 COMMENT = '博客的评论';
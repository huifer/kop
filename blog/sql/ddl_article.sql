DROP TABLE
IF
	EXISTS `blog_article`;
CREATE TABLE `blog_article` (
	`article_id` BIGINT ( 20 ) AUTO_INCREMENT NOT NULL COMMENT '文章主键',
	`article_title` VARCHAR ( 100 ) NOT NULL COMMENT '文章标题',
	`article_content` text COMMENT '文章内容',
	`article_status` TINYINT ( 4 ) DEFAULT 0 COMMENT '文章状态 0 待审核 1 审核通过',
	`thumbs_cont` BIGINT ( 20 ) COMMENT '点赞数',
	`views_count` BIGINT ( 20 ) COMMENT '浏览数',
	`comments_count` BIGINT ( 20 ) COMMENT '评论数',
	`comments_status` TINYINT ( 4 ) COMMENT '评论开关',
	`visible_status` TINYINT ( 4 ) COMMENT '文章可见类型 0 全部可见 1 仅我可见 2 粉丝可见',
	`create_time` datetime DEFAULT NULL COMMENT '创建时间',
	`create_user_id` BIGINT ( 20 ) DEFAULT NULL COMMENT '创建用户',
	`update_time` datetime DEFAULT NULL COMMENT '更新时间',
	`update_user_id` BIGINT ( 20 ) DEFAULT NULL COMMENT '更新用户',
	`deleted` TINYINT ( 4 ) DEFAULT 0 COMMENT '逻辑删除标记位',
	`version` BIGINT ( 20 ) DEFAULT 0 COMMENT '乐观锁',
	PRIMARY KEY ( `article_id` ) 
) ENGINE = INNODB DEFAULT CHARSET = utf8mb3 COMMENT = '博客的文章';
DROP TABLE
IF
	EXISTS `blog_article_history`;
CREATE TABLE `blog_article_history` (
	`history_id` BIGINT ( 20 ) NOT NULL COMMENT '文章主键',
	`article_id` BIGINT ( 20 ) NOT NULL COMMENT '文章主键',
	`article_title` VARCHAR ( 100 ) NOT NULL COMMENT '文章标题',
	`article_content` text COMMENT '文章内容',
	`comments_statu` TINYINT ( 4 ) COMMENT '评论开关',
	`visible_status` TINYINT ( 4 ) COMMENT '文章可见类型 0 全部可见 1 仅我可见 2 粉丝可见',
	`history_create_time` datetime DEFAULT NULL COMMENT '历史版本创建时间',
	`history_create_user_id` BIGINT ( 20 ) DEFAULT NULL COMMENT '历史版本创建用户',
	`history_update_time` datetime DEFAULT NULL COMMENT '历史版本更新时间',
	`history_update_user_id` BIGINT ( 20 ) DEFAULT NULL COMMENT '历史版本更新用户',
	`create_time` datetime DEFAULT NULL COMMENT '创建时间',
	`create_user_id` BIGINT ( 20 ) DEFAULT NULL COMMENT '创建用户',
	`update_time` datetime DEFAULT NULL COMMENT '更新时间',
	`update_user_id` BIGINT ( 20 ) DEFAULT NULL COMMENT '更新用户',
	`deleted` TINYINT ( 4 ) DEFAULT 0 COMMENT '逻辑删除标记位',
	`version` BIGINT ( 20 ) DEFAULT 0 COMMENT '乐观锁',
PRIMARY KEY ( `history_id` ) 
) ENGINE = INNODB DEFAULT CHARSET = utf8mb3 COMMENT = '博客文章修改历史';
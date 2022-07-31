DROP TABLE IF EXISTS `blog_tag`;
CREATE TABLE `blog_tag`
(
   `tag_id`                 bigint(20) AUTO_INCREMENT   NOT NULL COMMENT '标签主键',
   `tag_name`               varchar(50) NOT NULL COMMENT '标签名称',
         `create_time`        datetime     DEFAULT NULL COMMENT '创建时间',
   `create_user_id`     bigint(20)   DEFAULT NULL COMMENT '创建用户',
   `update_time`        datetime     DEFAULT NULL COMMENT '更新时间',
   `update_user_id`     bigint(20)   DEFAULT NULL COMMENT '更新用户',
   `deleted`            tinyint(4)   DEFAULT 0 COMMENT '逻辑删除标记位',
   `version`            bigint(20)   DEFAULT 0 COMMENT '乐观锁',
   PRIMARY KEY (`tag_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb3 COMMENT ='博客的标签';
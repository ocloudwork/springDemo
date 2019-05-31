/*
MySQL - 5.7.25
*********************************************************************
*/
/*表结构插入*/
DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `id` VARCHAR(64) NOT NULL,
  `url` VARCHAR(256) DEFAULT NULL COMMENT 'url地址',
  `name` VARCHAR(256) DEFAULT NULL COMMENT 'url描述',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Table structure for table `u_role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` VARCHAR(64) NOT NULL,
  `name` VARCHAR(256) DEFAULT NULL COMMENT '角色名称',
  `type` VARCHAR(256) DEFAULT NULL COMMENT '角色类型',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Table structure for table `u_role_permission` */

DROP TABLE IF EXISTS `role_permission`;

CREATE TABLE `role_permission` (
  `rid` VARCHAR(64) DEFAULT NULL COMMENT '角色ID',
  `pid` VARCHAR(64) DEFAULT NULL COMMENT '权限ID'
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `u_user` */

DROP TABLE IF EXISTS `user_account`;

CREATE TABLE `user_account` (
  `id` VARCHAR(64) NOT NULL,
  `nick_name` VARCHAR(256) DEFAULT NULL COMMENT '用户昵称',
  `email` VARCHAR(256) DEFAULT NULL COMMENT '邮箱|登录帐号',
  `password` VARCHAR(32) DEFAULT NULL COMMENT '密码',
  `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  `last_login_time` DATETIME DEFAULT NULL COMMENT '最后登录时间',
  `status` BIGINT(1) DEFAULT '1' COMMENT '1:有效，0:禁止登录',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Table structure for table `u_user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `uid` VARCHAR(64) DEFAULT NULL COMMENT '用户ID',
  `rid` VARCHAR(64) DEFAULT NULL COMMENT '角色ID'
) ENGINE=INNODB DEFAULT CHARSET=utf8;
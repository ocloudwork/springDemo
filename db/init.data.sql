/*
SQLyog 企业版 - MySQL GUI v7.14 
MySQL - 5.6.16-log : Database - i_wenyiba_com
*********************************************************************
*/

/*所有的表数据插入*/

/*Data for the table `u_permission` */

insert  into `permission`(`id`,`url`,`name`) values ('47b45b8681b211e9b14094c691d60e17','/permission/index.shtml','权限列表'),
('59e261dd81b211e9b14094c691d60e17','/permission/addPermission.shtml','权限添加'),
('adeb5e5481b211e9b14094c691d60e17','/permission/deletePermissionById.shtml','权限删除'),
('bf2278e081b211e9b14094c691d60e17','/member/list.shtml','用户列表'),
('cd8c164881b211e9b14094c691d60e17','/member/online.shtml','在线用户'),
('dc82127b81b211e9b14094c691d60e17','/member/changeSessionStatus.shtml','用户Session踢出'),
('ed558d9081b211e9b14094c691d60e17','/member/forbidUserById.shtml','用户激活&禁止'),
('ff2f7d1c81b211e9b14094c691d60e17','/member/deleteUserById.shtml','用户删除'),
('14d2450a81b311e9b14094c691d60e17','/permission/addPermission2Role.shtml','权限分配'),
('2031d19f81b311e9b14094c691d60e17','/role/clearRoleByUserIds.shtml','用户角色分配清空'),
('83bf6d2281b311e9b14094c691d60e17','/role/addRole2User.shtml','角色分配保存'),
('8f960e9881b311e9b14094c691d60e17','/role/deleteRoleById.shtml','角色列表删除'),
('9c3e4a1e81b311e9b14094c691d60e17','/role/addRole.shtml','角色列表添加'),
('aa19e27e81b311e9b14094c691d60e17','/role/index.shtml','角色列表'),
('b71aa82681b311e9b14094c691d60e17','/permission/allocation.shtml','权限分配'),
('c26f99df81b311e9b14094c691d60e17','/role/allocation.shtml','角色分配');

/*Data for the table `u_role` */

insert  into `role`(`id`,`name`,`type`) values ('5a2d65a081b111e9b14094c691d60e17','系统管理员','888888'),
('631682fb81b111e9b14094c691d60e17','权限角色','100003'),
('67ff2f2d81b111e9b14094c691d60e17','用户中心','100002');

/*Data for the table `u_role_permission` */

insert  into `role_permission`(`rid`,`pid`) values 
('67ff2f2d81b111e9b14094c691d60e17','bf2278e081b211e9b14094c691d60e17'),
('67ff2f2d81b111e9b14094c691d60e17','cd8c164881b211e9b14094c691d60e17'),
('67ff2f2d81b111e9b14094c691d60e17','dc82127b81b211e9b14094c691d60e17'),
('67ff2f2d81b111e9b14094c691d60e17','ed558d9081b211e9b14094c691d60e17'),
('67ff2f2d81b111e9b14094c691d60e17','ff2f7d1c81b211e9b14094c691d60e17'),
('631682fb81b111e9b14094c691d60e17','47b45b8681b211e9b14094c691d60e17'),
('631682fb81b111e9b14094c691d60e17','59e261dd81b211e9b14094c691d60e17'),
('631682fb81b111e9b14094c691d60e17','adeb5e5481b211e9b14094c691d60e17'),
('631682fb81b111e9b14094c691d60e17','14d2450a81b311e9b14094c691d60e17'),
('631682fb81b111e9b14094c691d60e17','2031d19f81b311e9b14094c691d60e17'),
('631682fb81b111e9b14094c691d60e17','83bf6d2281b311e9b14094c691d60e17'),
('631682fb81b111e9b14094c691d60e17','8f960e9881b311e9b14094c691d60e17'),
('631682fb81b111e9b14094c691d60e17','9c3e4a1e81b311e9b14094c691d60e17'),
('631682fb81b111e9b14094c691d60e17','aa19e27e81b311e9b14094c691d60e17'),
('631682fb81b111e9b14094c691d60e17','b71aa82681b311e9b14094c691d60e17'),
('631682fb81b111e9b14094c691d60e17','c26f99df81b311e9b14094c691d60e17'),
('5a2d65a081b111e9b14094c691d60e17','47b45b8681b211e9b14094c691d60e17'),
('5a2d65a081b111e9b14094c691d60e17','59e261dd81b211e9b14094c691d60e17'),
('5a2d65a081b111e9b14094c691d60e17','adeb5e5481b211e9b14094c691d60e17'),
('5a2d65a081b111e9b14094c691d60e17','bf2278e081b211e9b14094c691d60e17'),
('5a2d65a081b111e9b14094c691d60e17','cd8c164881b211e9b14094c691d60e17'),
('5a2d65a081b111e9b14094c691d60e17','dc82127b81b211e9b14094c691d60e17'),
('5a2d65a081b111e9b14094c691d60e17','ed558d9081b211e9b14094c691d60e17'),
('5a2d65a081b111e9b14094c691d60e17','ff2f7d1c81b211e9b14094c691d60e17'),
('5a2d65a081b111e9b14094c691d60e17','14d2450a81b311e9b14094c691d60e17'),
('5a2d65a081b111e9b14094c691d60e17','2031d19f81b311e9b14094c691d60e17'),
('5a2d65a081b111e9b14094c691d60e17','83bf6d2281b311e9b14094c691d60e17'),
('5a2d65a081b111e9b14094c691d60e17','8f960e9881b311e9b14094c691d60e17'),
('5a2d65a081b111e9b14094c691d60e17','9c3e4a1e81b311e9b14094c691d60e17'),
('5a2d65a081b111e9b14094c691d60e17','aa19e27e81b311e9b14094c691d60e17'),
('5a2d65a081b111e9b14094c691d60e17','b71aa82681b311e9b14094c691d60e17'),
('5a2d65a081b111e9b14094c691d60e17','c26f99df81b311e9b14094c691d60e17');

/*Data for the table `u_user` */

insert  into `user_account`(`id`,`nickname`,`email`,`pswd`,`create_time`,`last_login_time`,`status`) values 
('d1b843fc81b011e9b14094c691d60e17','管理员','admin','57eb72e6b78a87a12d46a7f5e9315138','2016-06-16 11:15:33','2016-06-16 11:24:10',1),
('1fa6b2f781b111e9b14094c691d60e17','soso','8446666@qq.com','d57ffbe486910dd5b26d0167d034f9ad','2016-05-26 20:50:54','2016-06-16 11:24:35',1),
('2d1f033981b111e9b14094c691d60e17','8446666','8446666','4afdc875a67a55528c224ce088be2ab8','2016-05-27 22:34:19','2016-06-15 17:03:16',1);

/*Data for the table `u_user_role` */

insert  into `user_role`(`uid`,`rid`) values ('2d1f033981b111e9b14094c691d60e17','67ff2f2d81b111e9b14094c691d60e17'),('1fa6b2f781b111e9b14094c691d60e17','631682fb81b111e9b14094c691d60e17'),('1fa6b2f781b111e9b14094c691d60e17','67ff2f2d81b111e9b14094c691d60e17'),('d1b843fc81b011e9b14094c691d60e17','5a2d65a081b111e9b14094c691d60e17');


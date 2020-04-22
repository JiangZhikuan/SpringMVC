/*
Navicat MySQL Data Transfer

Source Server         : 192.168.64.128
Source Server Version : 50729
Source Host           : 192.168.64.131:3306
Source Database       : carrent

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-04-22 21:43:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bus_car
-- ----------------------------
DROP TABLE IF EXISTS `bus_car`;
CREATE TABLE `bus_car` (
  `carnumber` varchar(255) NOT NULL,
  `cartype` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  `rentprice` double(10,2) DEFAULT NULL,
  `deposit` double DEFAULT NULL,
  `isrenting` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `carimg` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`carnumber`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bus_car
-- ----------------------------
INSERT INTO `bus_car` VALUES ('鄂A66666', 'SUV', '白色', '280000.00', '500.00', '5000', '0', '宝马X1', 'images/001.png', '2019-05-07 14:52:15');
INSERT INTO `bus_car` VALUES ('鄂A77777', 'SUV', '白色', '350000.00', '1500.00', '12000', '0', '宝马X3', 'images/002.png', '2019-05-07 14:52:15');
INSERT INTO `bus_car` VALUES ('鄂A88888', '轿车', '黑色', '880000.00', '1000.00', '10000', '0', '保时捷 卡宴', 'images/003.png', '2019-05-07 14:52:15');
INSERT INTO `bus_car` VALUES ('鄂A99999', '渣土车', '黄', '500000.00', '3000.00', '20000', '1', '动力强劲', 'images/defaultcarimage.jpg', '2019-06-10 14:50:12');

-- ----------------------------
-- Table structure for bus_check
-- ----------------------------
DROP TABLE IF EXISTS `bus_check`;
CREATE TABLE `bus_check` (
  `checkid` varchar(255) NOT NULL,
  `checkdate` datetime DEFAULT NULL,
  `checkdesc` varchar(255) DEFAULT NULL,
  `problem` varchar(255) DEFAULT NULL,
  `paymoney` double(255,0) DEFAULT NULL,
  `opername` varchar(255) DEFAULT NULL,
  `rentid` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`checkid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bus_check
-- ----------------------------
INSERT INTO `bus_check` VALUES ('JC_20180612_170407_0385_63960', '2018-06-12 00:00:00', '在G50高速超速', '超速', '500', '习大大', 'CZ_20180611_171304_0732_57330', '2019-05-07 14:55:30');
INSERT INTO `bus_check` VALUES ('JC_20180612_172559_0323_71959', '2018-06-13 00:00:00', '无', '无', '0', '习大大', 'CZ_20180612_164747_0573_26177', '2019-05-07 14:55:30');
INSERT INTO `bus_check` VALUES ('JC_20180718_091454_0191_93480', '2018-07-18 00:00:00', '无', '无', '0', '习大大', 'CZ_20180718_091206_0365_62161', '2019-05-07 14:55:30');
INSERT INTO `bus_check` VALUES ('JC_20181024_170206_355_7589', '2018-10-24 17:02:06', '无', '无', '0', '超级管理员', 'CZ_20181024_102327_735_9111', '2019-05-07 14:55:30');
INSERT INTO `bus_check` VALUES ('JC_20181201_105333_218_89516', '2018-12-02 00:00:00', '1231321', '111122', '200', '超级管理员', 'CZ_20180612_164808_0385_37625', '2019-05-07 14:55:30');
INSERT INTO `bus_check` VALUES ('JC_20181201_111951_947_77152', '2018-12-03 00:00:00', '无', '无', '0', '超级管理员', 'CZ_20181201_111936_383_31565', '2019-05-07 14:55:30');
INSERT INTO `bus_check` VALUES ('JC_2018_0901_175053_57325085', '2018-09-01 00:00:00', '在G50  1127-1130段超速20%未达50%', '有违章未处理', '500', '超级管理员', 'CZ_2018_0901_175000_97637709', '2019-05-07 14:55:30');
INSERT INTO `bus_check` VALUES ('JC_20190322_142814_147_8624', '2019-03-22 14:28:14', '222', '11', '100', '超级管理员', 'CZ_20190320_141553_303_8141', '2019-05-07 14:55:30');
INSERT INTO `bus_check` VALUES ('JC_20190611_111021_41215259', '2019-06-11 11:10:21', '没有1', '无1', '0', '超级管理员', 'CZ_20190611_094617_32192683', '2019-06-11 11:10:32');
INSERT INTO `bus_check` VALUES ('JC_20190727_173816_738_26810', '2019-07-27 17:38:16', '无1', '无1', '1', '超级管理员', 'CZ_20190727_152634_863_83662', '2019-07-27 17:38:24');

-- ----------------------------
-- Table structure for bus_customer
-- ----------------------------
DROP TABLE IF EXISTS `bus_customer`;
CREATE TABLE `bus_customer` (
  `identity` varchar(255) NOT NULL COMMENT '身份证',
  `custname` varchar(255) DEFAULT NULL COMMENT '姓名',
  `sex` int(255) DEFAULT NULL COMMENT '性别',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `phone` varchar(255) DEFAULT NULL COMMENT '电话',
  `career` varchar(255) DEFAULT NULL COMMENT '职位',
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`identity`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bus_customer
-- ----------------------------
INSERT INTO `bus_customer` VALUES ('421087133414144412', '张小明', '1', '武昌', '13456788987', '程序员', '2019-05-07 14:52:24');
INSERT INTO `bus_customer` VALUES ('43131334113331131', '习大大', '1', '武昌', '13888888888', '国家最高领导人', '2019-05-07 14:52:24');
INSERT INTO `bus_customer` VALUES ('431321199291331131', '张三', '1', '武昌', '13431334113', '程序员', '2019-05-07 14:52:24');
INSERT INTO `bus_customer` VALUES ('431321199291331132', '孙中山', '1', '汉口', '134131314131', '总统', '2019-05-07 14:52:24');
INSERT INTO `bus_customer` VALUES ('431341134191311311', '李四', '0', '汉阳', '13451313113', 'CEO', '2019-05-07 14:52:24');
INSERT INTO `bus_customer` VALUES ('431341134191311314', '王小明', '1', '汉口', '13413131113', 'CEO', '2019-05-07 14:52:24');

-- ----------------------------
-- Table structure for bus_rent
-- ----------------------------
DROP TABLE IF EXISTS `bus_rent`;
CREATE TABLE `bus_rent` (
  `rentid` varchar(255) NOT NULL,
  `price` double(10,2) DEFAULT NULL,
  `begindate` datetime DEFAULT NULL,
  `returndate` datetime DEFAULT NULL,
  `rentflag` int(11) DEFAULT NULL,
  `identity` varchar(255) DEFAULT NULL,
  `carnumber` varchar(255) DEFAULT NULL,
  `opername` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`rentid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bus_rent
-- ----------------------------
INSERT INTO `bus_rent` VALUES ('CZ_20180611_171304_0732_57330', '1600.00', '2017-01-01 00:00:00', '2017-06-18 00:00:00', '1', '421087133414144412', '鄂A77777', '李四', '2017-01-01 00:00:00');
INSERT INTO `bus_rent` VALUES ('CZ_20180612_164747_0573_26177', '500.00', '2018-01-13 00:00:00', '2018-06-23 00:00:00', '1', '431321199291331131', '鄂A66666', '李四', '2018-01-13 00:00:00');
INSERT INTO `bus_rent` VALUES ('CZ_20180612_164808_0385_37625', '1000.00', '2018-03-13 00:00:00', '2018-06-15 00:00:00', '1', '421087133414144412', '鄂A88888', '王五', '2018-03-13 00:00:00');
INSERT INTO `bus_rent` VALUES ('CZ_20180718_091206_0365_62161', '500.00', '2018-05-18 00:00:00', '2018-07-21 00:00:00', '1', '421087133414144412', '鄂A66666', '张三', '2018-05-18 00:00:00');
INSERT INTO `bus_rent` VALUES ('CZ_20181024_102327_735_9111', '500.00', '2018-07-23 10:23:27', '2018-10-31 10:23:29', '1', '421087133414144412', '鄂A66666', '李四', '2018-07-23 10:23:27');
INSERT INTO `bus_rent` VALUES ('CZ_20181201_111936_383_31565', '1500.00', '2018-09-01 00:00:00', '2018-12-29 00:00:00', '1', '43131334113331131', '鄂A77777', '王五', '2018-09-01 00:00:00');
INSERT INTO `bus_rent` VALUES ('CZ_2018_0901_175000_97637709', '500.00', '2018-12-01 00:00:00', '2018-09-10 00:00:00', '1', '431321199291331131', '鄂A66666', '李四', '2018-12-01 00:00:00');
INSERT INTO `bus_rent` VALUES ('CZ_20190611_094617_32192683', '500.00', '2019-06-11 09:46:17', '2019-06-15 09:46:19', '1', '43131334113331131', '鄂A66666', '超级管理员', '2019-06-11 09:46:25');
INSERT INTO `bus_rent` VALUES ('CZ_20190727_152634_863_83662', '500.00', '2019-07-27 15:26:34', '2019-07-31 00:00:00', '1', '43131334113331131', '鄂A66666', '超级管理员', '2019-07-27 15:26:40');

-- ----------------------------
-- Table structure for sys_log_login
-- ----------------------------
DROP TABLE IF EXISTS `sys_log_login`;
CREATE TABLE `sys_log_login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(255) DEFAULT NULL,
  `loginip` varchar(255) DEFAULT NULL,
  `logintime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=224 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_log_login
-- ----------------------------
INSERT INTO `sys_log_login` VALUES ('5', '超级管理员-admin', '127.0.0.1', '2019-06-10 10:18:31');
INSERT INTO `sys_log_login` VALUES ('6', '超级管理员-admin', '127.0.0.1', '2019-06-10 10:21:26');
INSERT INTO `sys_log_login` VALUES ('7', '超级管理员-admin', '127.0.0.1', '2019-06-10 10:22:20');
INSERT INTO `sys_log_login` VALUES ('8', '超级管理员-admin', '127.0.0.1', '2019-06-10 11:01:47');
INSERT INTO `sys_log_login` VALUES ('9', '超级管理员-admin', '127.0.0.1', '2019-06-10 11:12:34');
INSERT INTO `sys_log_login` VALUES ('10', '超级管理员-admin', '127.0.0.1', '2019-06-10 14:42:41');
INSERT INTO `sys_log_login` VALUES ('11', '超级管理员-admin', '127.0.0.1', '2019-06-10 14:53:57');
INSERT INTO `sys_log_login` VALUES ('12', '超级管理员-admin', '127.0.0.1', '2019-06-10 15:35:46');
INSERT INTO `sys_log_login` VALUES ('13', '超级管理员-admin', '127.0.0.1', '2019-06-10 15:35:51');
INSERT INTO `sys_log_login` VALUES ('14', '超级管理员-admin', '127.0.0.1', '2019-06-10 15:41:25');
INSERT INTO `sys_log_login` VALUES ('15', '超级管理员-admin', '127.0.0.1', '2019-06-10 16:15:34');
INSERT INTO `sys_log_login` VALUES ('16', '超级管理员-admin', '127.0.0.1', '2019-06-10 16:38:44');
INSERT INTO `sys_log_login` VALUES ('17', '超级管理员-admin', '127.0.0.1', '2019-06-10 16:53:20');
INSERT INTO `sys_log_login` VALUES ('18', '超级管理员-admin', '127.0.0.1', '2019-06-11 09:19:33');
INSERT INTO `sys_log_login` VALUES ('19', '超级管理员-admin', '127.0.0.1', '2019-06-11 09:41:54');
INSERT INTO `sys_log_login` VALUES ('20', '超级管理员-admin', '127.0.0.1', '2019-06-11 10:57:54');
INSERT INTO `sys_log_login` VALUES ('21', '超级管理员-admin', '127.0.0.1', '2019-06-11 11:07:57');
INSERT INTO `sys_log_login` VALUES ('22', '超级管理员-admin', '127.0.0.1', '2019-06-11 11:10:04');
INSERT INTO `sys_log_login` VALUES ('23', '超级管理员-admin', '127.0.0.1', '2019-06-11 11:30:00');
INSERT INTO `sys_log_login` VALUES ('24', '超级管理员-admin', '127.0.0.1', '2019-06-11 11:38:28');
INSERT INTO `sys_log_login` VALUES ('25', '超级管理员-admin', '127.0.0.1', '2019-06-11 14:22:43');
INSERT INTO `sys_log_login` VALUES ('26', '超级管理员-admin', '127.0.0.1', '2019-06-11 14:37:13');
INSERT INTO `sys_log_login` VALUES ('27', '超级管理员-admin', '127.0.0.1', '2019-06-11 14:45:35');
INSERT INTO `sys_log_login` VALUES ('28', '超级管理员-admin', '127.0.0.1', '2019-06-11 15:57:16');
INSERT INTO `sys_log_login` VALUES ('29', '超级管理员-admin', '127.0.0.1', '2019-06-11 16:42:55');
INSERT INTO `sys_log_login` VALUES ('30', '超级管理员-admin', '127.0.0.1', '2019-06-11 17:01:10');
INSERT INTO `sys_log_login` VALUES ('31', '超级管理员-admin', '127.0.0.1', '2019-06-12 09:35:50');
INSERT INTO `sys_log_login` VALUES ('32', '超级管理员-admin', '127.0.0.1', '2019-06-12 09:54:09');
INSERT INTO `sys_log_login` VALUES ('33', '超级管理员-admin', '127.0.0.1', '2019-06-12 09:59:20');
INSERT INTO `sys_log_login` VALUES ('34', '超级管理员-admin', '127.0.0.1', '2019-06-12 09:59:43');
INSERT INTO `sys_log_login` VALUES ('35', '超级管理员-admin', '127.0.0.1', '2019-06-12 10:00:13');
INSERT INTO `sys_log_login` VALUES ('36', '超级管理员-admin', '127.0.0.1', '2019-06-12 10:00:44');
INSERT INTO `sys_log_login` VALUES ('37', '超级管理员-admin', '127.0.0.1', '2019-06-12 10:02:29');
INSERT INTO `sys_log_login` VALUES ('38', '超级管理员-admin', '127.0.0.1', '2019-06-12 10:05:57');
INSERT INTO `sys_log_login` VALUES ('39', '超级管理员-admin', '127.0.0.1', '2019-06-12 10:16:26');
INSERT INTO `sys_log_login` VALUES ('40', '超级管理员-admin', '127.0.0.1', '2019-06-12 10:20:36');
INSERT INTO `sys_log_login` VALUES ('41', '超级管理员-admin', '127.0.0.1', '2019-06-12 10:24:14');
INSERT INTO `sys_log_login` VALUES ('42', '超级管理员-admin', '127.0.0.1', '2019-06-12 11:17:46');
INSERT INTO `sys_log_login` VALUES ('43', '超级管理员-admin', '127.0.0.1', '2019-06-12 11:32:29');
INSERT INTO `sys_log_login` VALUES ('44', '超级管理员-admin', '127.0.0.1', '2019-06-12 11:35:05');
INSERT INTO `sys_log_login` VALUES ('45', '超级管理员-admin', '127.0.0.1', '2019-06-12 11:51:48');
INSERT INTO `sys_log_login` VALUES ('46', '超级管理员-admin', '127.0.0.1', '2019-06-12 14:31:34');
INSERT INTO `sys_log_login` VALUES ('47', '超级管理员-admin', '127.0.0.1', '2019-06-12 15:01:15');
INSERT INTO `sys_log_login` VALUES ('48', '超级管理员-admin', '127.0.0.1', '2019-06-12 15:26:55');
INSERT INTO `sys_log_login` VALUES ('49', '超级管理员-admin', '127.0.0.1', '2019-06-12 15:31:17');
INSERT INTO `sys_log_login` VALUES ('50', '超级管理员-admin', '127.0.0.1', '2019-06-12 15:40:38');
INSERT INTO `sys_log_login` VALUES ('51', '超级管理员-admin', '127.0.0.1', '2019-06-12 15:40:52');
INSERT INTO `sys_log_login` VALUES ('52', '超级管理员-admin', '127.0.0.1', '2019-06-12 15:44:41');
INSERT INTO `sys_log_login` VALUES ('53', '超级管理员-admin', '127.0.0.1', '2019-06-12 15:44:50');
INSERT INTO `sys_log_login` VALUES ('54', '超级管理员-admin', '127.0.0.1', '2019-06-12 15:44:53');
INSERT INTO `sys_log_login` VALUES ('55', '超级管理员-admin', '127.0.0.1', '2019-06-12 15:45:59');
INSERT INTO `sys_log_login` VALUES ('56', '超级管理员-admin', '127.0.0.1', '2019-06-12 15:45:59');
INSERT INTO `sys_log_login` VALUES ('57', '超级管理员-admin', '127.0.0.1', '2019-06-12 15:47:29');
INSERT INTO `sys_log_login` VALUES ('58', '超级管理员-admin', '127.0.0.1', '2019-06-12 15:48:56');
INSERT INTO `sys_log_login` VALUES ('59', '超级管理员-admin', '127.0.0.1', '2019-06-14 09:10:49');
INSERT INTO `sys_log_login` VALUES ('60', '超级管理员-admin', '127.0.0.1', '2019-06-14 09:37:03');
INSERT INTO `sys_log_login` VALUES ('61', '超级管理员-admin', '127.0.0.1', '2019-06-14 09:38:45');
INSERT INTO `sys_log_login` VALUES ('62', '超级管理员-admin', '127.0.0.1', '2019-06-14 09:39:08');
INSERT INTO `sys_log_login` VALUES ('63', '超级管理员-admin', '127.0.0.1', '2019-06-14 09:41:16');
INSERT INTO `sys_log_login` VALUES ('64', '超级管理员-admin', '127.0.0.1', '2019-06-14 10:49:01');
INSERT INTO `sys_log_login` VALUES ('65', '超级管理员-admin', '127.0.0.1', '2019-06-14 10:56:58');
INSERT INTO `sys_log_login` VALUES ('66', '超级管理员-admin', '127.0.0.1', '2019-06-14 11:03:40');
INSERT INTO `sys_log_login` VALUES ('67', '超级管理员-admin', '127.0.0.1', '2019-06-14 11:06:35');
INSERT INTO `sys_log_login` VALUES ('68', '超级管理员-admin', '127.0.0.1', '2019-06-14 11:19:40');
INSERT INTO `sys_log_login` VALUES ('69', '超级管理员-admin', '127.0.0.1', '2019-06-14 11:21:08');
INSERT INTO `sys_log_login` VALUES ('70', '超级管理员-admin', '127.0.0.1', '2019-06-14 11:22:51');
INSERT INTO `sys_log_login` VALUES ('71', '超级管理员-admin', '127.0.0.1', '2019-06-14 11:23:07');
INSERT INTO `sys_log_login` VALUES ('72', '超级管理员-admin', '127.0.0.1', '2019-06-14 11:27:18');
INSERT INTO `sys_log_login` VALUES ('120', '习大大-xdd', '127.0.0.1', '2019-07-23 15:58:24');
INSERT INTO `sys_log_login` VALUES ('121', '习大大-xdd', '127.0.0.1', '2019-07-23 16:15:51');
INSERT INTO `sys_log_login` VALUES ('122', '习大大-xdd', '127.0.0.1', '2019-07-23 16:21:10');
INSERT INTO `sys_log_login` VALUES ('123', '习大大-xdd', '127.0.0.1', '2019-07-23 16:21:29');
INSERT INTO `sys_log_login` VALUES ('124', '习大大-xdd', '127.0.0.1', '2019-07-23 16:25:45');
INSERT INTO `sys_log_login` VALUES ('125', '习大大-xdd', '127.0.0.1', '2019-07-23 16:29:54');
INSERT INTO `sys_log_login` VALUES ('126', '习大大-xdd', '127.0.0.1', '2019-07-23 16:34:37');
INSERT INTO `sys_log_login` VALUES ('127', '习大大-xdd', '127.0.0.1', '2019-07-23 16:36:28');
INSERT INTO `sys_log_login` VALUES ('128', '习大大-xdd', '127.0.0.1', '2019-07-23 16:36:40');
INSERT INTO `sys_log_login` VALUES ('129', '习大大-xdd', '127.0.0.1', '2019-07-23 16:52:14');
INSERT INTO `sys_log_login` VALUES ('130', '习大大-xdd', '127.0.0.1', '2019-07-23 16:54:47');
INSERT INTO `sys_log_login` VALUES ('131', '习大大-xdd', '127.0.0.1', '2019-07-23 17:00:09');
INSERT INTO `sys_log_login` VALUES ('132', '习大大-xdd', '127.0.0.1', '2019-07-23 17:00:29');
INSERT INTO `sys_log_login` VALUES ('133', '超级管理员-admin', '127.0.0.1', '2019-07-24 09:03:14');
INSERT INTO `sys_log_login` VALUES ('134', '超级管理员-admin', '127.0.0.1', '2019-07-24 10:05:49');
INSERT INTO `sys_log_login` VALUES ('135', '超级管理员-admin', '127.0.0.1', '2019-07-24 10:08:04');
INSERT INTO `sys_log_login` VALUES ('136', '超级管理员-admin', '127.0.0.1', '2019-07-24 10:08:47');
INSERT INTO `sys_log_login` VALUES ('137', '超级管理员-admin', '127.0.0.1', '2019-07-24 11:44:27');
INSERT INTO `sys_log_login` VALUES ('138', '超级管理员-admin', '127.0.0.1', '2019-07-24 11:44:57');
INSERT INTO `sys_log_login` VALUES ('139', '超级管理员-admin', '127.0.0.1', '2019-07-24 11:45:42');
INSERT INTO `sys_log_login` VALUES ('140', '超级管理员-admin', '127.0.0.1', '2019-07-24 11:48:08');
INSERT INTO `sys_log_login` VALUES ('141', '超级管理员-admin', '127.0.0.1', '2019-07-24 11:49:07');
INSERT INTO `sys_log_login` VALUES ('142', '超级管理员-admin', '127.0.0.1', '2019-07-24 11:50:09');
INSERT INTO `sys_log_login` VALUES ('143', '超级管理员-admin', '127.0.0.1', '2019-07-24 11:50:19');
INSERT INTO `sys_log_login` VALUES ('144', '超级管理员-admin', '127.0.0.1', '2019-07-25 09:33:38');
INSERT INTO `sys_log_login` VALUES ('145', '超级管理员-admin', '127.0.0.1', '2019-07-25 09:33:52');
INSERT INTO `sys_log_login` VALUES ('146', '超级管理员-admin', '127.0.0.1', '2019-07-25 09:34:06');
INSERT INTO `sys_log_login` VALUES ('147', '超级管理员-admin', '127.0.0.1', '2019-07-25 09:54:03');
INSERT INTO `sys_log_login` VALUES ('148', '超级管理员-admin', '127.0.0.1', '2019-07-25 09:54:23');
INSERT INTO `sys_log_login` VALUES ('149', '超级管理员-admin', '127.0.0.1', '2019-07-25 10:11:30');
INSERT INTO `sys_log_login` VALUES ('150', '超级管理员-admin', '127.0.0.1', '2019-07-25 10:13:11');
INSERT INTO `sys_log_login` VALUES ('151', '超级管理员-admin', '127.0.0.1', '2019-07-25 10:28:31');
INSERT INTO `sys_log_login` VALUES ('152', '超级管理员-admin', '127.0.0.1', '2019-07-25 10:36:34');
INSERT INTO `sys_log_login` VALUES ('153', '超级管理员-admin', '127.0.0.1', '2019-07-25 10:42:21');
INSERT INTO `sys_log_login` VALUES ('154', '超级管理员-admin', '127.0.0.1', '2019-07-25 10:50:50');
INSERT INTO `sys_log_login` VALUES ('155', '超级管理员-admin', '127.0.0.1', '2019-07-25 10:53:32');
INSERT INTO `sys_log_login` VALUES ('156', '超级管理员-admin', '127.0.0.1', '2019-07-25 11:01:51');
INSERT INTO `sys_log_login` VALUES ('157', '超级管理员-admin', '127.0.0.1', '2019-07-25 11:37:32');
INSERT INTO `sys_log_login` VALUES ('158', '超级管理员-admin', '127.0.0.1', '2019-07-25 11:41:40');
INSERT INTO `sys_log_login` VALUES ('159', '超级管理员-admin', '127.0.0.1', '2019-07-25 14:06:26');
INSERT INTO `sys_log_login` VALUES ('160', '超级管理员-admin', '127.0.0.1', '2019-07-25 14:14:47');
INSERT INTO `sys_log_login` VALUES ('161', '超级管理员-admin', '127.0.0.1', '2019-07-25 14:21:50');
INSERT INTO `sys_log_login` VALUES ('162', '超级管理员-admin', '127.0.0.1', '2019-07-25 14:24:28');
INSERT INTO `sys_log_login` VALUES ('163', '超级管理员-admin', '127.0.0.1', '2019-07-27 09:09:17');
INSERT INTO `sys_log_login` VALUES ('164', '超级管理员-admin', '127.0.0.1', '2019-07-27 09:10:16');
INSERT INTO `sys_log_login` VALUES ('165', '超级管理员-admin', '127.0.0.1', '2019-07-27 09:10:43');
INSERT INTO `sys_log_login` VALUES ('166', '超级管理员-admin', '127.0.0.1', '2019-07-27 09:30:29');
INSERT INTO `sys_log_login` VALUES ('167', '超级管理员-admin', '127.0.0.1', '2019-07-27 09:30:55');
INSERT INTO `sys_log_login` VALUES ('168', '超级管理员-admin', '127.0.0.1', '2019-07-27 10:07:16');
INSERT INTO `sys_log_login` VALUES ('169', '超级管理员-admin', '127.0.0.1', '2019-07-27 10:20:13');
INSERT INTO `sys_log_login` VALUES ('170', '超级管理员-admin', '127.0.0.1', '2019-07-27 11:02:10');
INSERT INTO `sys_log_login` VALUES ('171', '超级管理员-admin', '127.0.0.1', '2019-07-27 11:20:13');
INSERT INTO `sys_log_login` VALUES ('172', '超级管理员-admin', '127.0.0.1', '2019-07-27 11:20:17');
INSERT INTO `sys_log_login` VALUES ('173', '超级管理员-admin', '127.0.0.1', '2019-07-27 11:20:53');
INSERT INTO `sys_log_login` VALUES ('174', '超级管理员-admin', '127.0.0.1', '2019-07-27 11:21:51');
INSERT INTO `sys_log_login` VALUES ('175', '超级管理员-admin', '127.0.0.1', '2019-07-27 11:57:34');
INSERT INTO `sys_log_login` VALUES ('176', '超级管理员-admin', '127.0.0.1', '2019-07-27 11:57:34');
INSERT INTO `sys_log_login` VALUES ('177', '超级管理员-admin', '127.0.0.1', '2019-07-27 11:57:55');
INSERT INTO `sys_log_login` VALUES ('178', '超级管理员-admin', '127.0.0.1', '2019-07-27 12:00:42');
INSERT INTO `sys_log_login` VALUES ('179', '超级管理员-admin', '127.0.0.1', '2019-07-27 12:15:17');
INSERT INTO `sys_log_login` VALUES ('180', '超级管理员-admin', '127.0.0.1', '2019-07-27 12:15:25');
INSERT INTO `sys_log_login` VALUES ('181', '超级管理员-admin', '127.0.0.1', '2019-07-27 15:06:34');
INSERT INTO `sys_log_login` VALUES ('182', '超级管理员-admin', '127.0.0.1', '2019-07-27 15:23:37');
INSERT INTO `sys_log_login` VALUES ('183', '超级管理员-admin', '127.0.0.1', '2019-07-27 15:24:02');
INSERT INTO `sys_log_login` VALUES ('184', '超级管理员-admin', '127.0.0.1', '2019-07-27 15:57:34');
INSERT INTO `sys_log_login` VALUES ('185', '超级管理员-admin', '127.0.0.1', '2019-07-27 15:58:10');
INSERT INTO `sys_log_login` VALUES ('186', '超级管理员-admin', '127.0.0.1', '2019-07-27 16:57:37');
INSERT INTO `sys_log_login` VALUES ('187', '超级管理员-admin', '127.0.0.1', '2019-07-27 16:57:56');
INSERT INTO `sys_log_login` VALUES ('188', '超级管理员-admin', '127.0.0.1', '2019-07-27 17:36:53');
INSERT INTO `sys_log_login` VALUES ('189', '超级管理员-admin', '127.0.0.1', '2019-07-27 17:52:43');
INSERT INTO `sys_log_login` VALUES ('190', '超级管理员-admin', '127.0.0.1', '2019-07-27 17:53:07');
INSERT INTO `sys_log_login` VALUES ('191', '超级管理员-admin', '127.0.0.1', '2019-07-27 17:54:45');
INSERT INTO `sys_log_login` VALUES ('192', '超级管理员-admin', '127.0.0.1', '2019-07-27 17:54:59');
INSERT INTO `sys_log_login` VALUES ('193', '超级管理员-admin', '127.0.0.1', '2019-07-27 18:03:40');
INSERT INTO `sys_log_login` VALUES ('194', '超级管理员-admin', '127.0.0.1', '2019-07-27 18:03:43');
INSERT INTO `sys_log_login` VALUES ('195', '超级管理员-admin', '127.0.0.1', '2019-07-27 18:04:12');
INSERT INTO `sys_log_login` VALUES ('196', '超级管理员-admin', '127.0.0.1', '2019-07-28 11:02:51');
INSERT INTO `sys_log_login` VALUES ('197', '超级管理员-admin', '127.0.0.1', '2019-07-28 12:08:57');
INSERT INTO `sys_log_login` VALUES ('198', '超级管理员-admin', '127.0.0.1', '2019-07-28 12:10:29');
INSERT INTO `sys_log_login` VALUES ('199', '超级管理员-admin', '127.0.0.1', '2019-07-28 12:11:00');
INSERT INTO `sys_log_login` VALUES ('200', '超级管理员-admin', '127.0.0.1', '2019-07-28 12:22:41');
INSERT INTO `sys_log_login` VALUES ('201', '超级管理员-admin', '127.0.0.1', '2019-07-28 15:36:26');
INSERT INTO `sys_log_login` VALUES ('202', '超级管理员-admin', '127.0.0.1', '2019-07-28 15:54:23');
INSERT INTO `sys_log_login` VALUES ('203', '超级管理员-admin', '127.0.0.1', '2019-07-28 15:54:42');
INSERT INTO `sys_log_login` VALUES ('204', '超级管理员-admin', '127.0.0.1', '2019-07-28 16:04:00');
INSERT INTO `sys_log_login` VALUES ('205', '超级管理员-admin', '127.0.0.1', '2019-07-28 16:05:22');
INSERT INTO `sys_log_login` VALUES ('206', '超级管理员-admin', '127.0.0.1', '2019-07-28 17:11:54');
INSERT INTO `sys_log_login` VALUES ('207', '超级管理员-admin', '127.0.0.1', '2019-07-28 17:11:54');
INSERT INTO `sys_log_login` VALUES ('208', '超级管理员-admin', '127.0.0.1', '2019-07-28 17:12:14');
INSERT INTO `sys_log_login` VALUES ('209', '超级管理员-admin', '127.0.0.1', '2019-07-28 17:14:41');
INSERT INTO `sys_log_login` VALUES ('210', '超级管理员-admin', '127.0.0.1', '2019-07-28 17:16:02');
INSERT INTO `sys_log_login` VALUES ('211', '超级管理员-admin', '127.0.0.1', '2019-07-28 17:16:16');
INSERT INTO `sys_log_login` VALUES ('212', '超级管理员-admin', '127.0.0.1', '2019-07-28 17:16:20');
INSERT INTO `sys_log_login` VALUES ('213', '超级管理员-admin', '127.0.0.1', '2019-07-28 17:17:35');
INSERT INTO `sys_log_login` VALUES ('214', '超级管理员-admin', '127.0.0.1', '2019-07-28 17:24:40');
INSERT INTO `sys_log_login` VALUES ('215', '超级管理员-admin', '127.0.0.1', '2019-07-28 17:33:56');
INSERT INTO `sys_log_login` VALUES ('216', '超级管理员-admin', '127.0.0.1', '2019-07-28 18:08:42');
INSERT INTO `sys_log_login` VALUES ('217', '超级管理员-admin', '127.0.0.1', '2019-07-29 11:09:19');
INSERT INTO `sys_log_login` VALUES ('218', '超级管理员-admin', '127.0.0.1', '2019-07-30 10:23:21');
INSERT INTO `sys_log_login` VALUES ('219', '超级管理员-admin', '127.0.0.1', '2019-07-30 10:27:41');
INSERT INTO `sys_log_login` VALUES ('220', '超级管理员-admin', '127.0.0.1', '2019-07-30 21:25:43');
INSERT INTO `sys_log_login` VALUES ('221', '超级管理员-admin', '127.0.0.1', '2019-08-01 15:02:28');
INSERT INTO `sys_log_login` VALUES ('222', '超级管理员-admin', '127.0.0.1', '2019-09-07 09:31:40');
INSERT INTO `sys_log_login` VALUES ('223', '超级管理员-admin', '127.0.0.1', '2019-09-07 09:39:27');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `href` varchar(255) DEFAULT NULL,
  `spread` int(255) DEFAULT NULL COMMENT '0不展开1展开',
  `target` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `available` int(255) DEFAULT NULL COMMENT '0不可用1可用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', '汽车出租系统', null, '1', null, '&#xe68e;', '1');
INSERT INTO `sys_menu` VALUES ('2', '1', '基础管理', '', '1', '', '&#xe653;', '1');
INSERT INTO `sys_menu` VALUES ('3', '1', '业务管理', '', '1', '', '&#xe663;', '1');
INSERT INTO `sys_menu` VALUES ('4', '1', '系统管理', '', '0', '', '&#xe716;', '1');
INSERT INTO `sys_menu` VALUES ('5', '1', '统计分析', null, '0', null, '&#xe629;', '1');
INSERT INTO `sys_menu` VALUES ('6', '2', '客户管理', '../bus/toCustomerManager.action', '0', '', '&#xe770;', '1');
INSERT INTO `sys_menu` VALUES ('7', '2', '车辆管理', '../bus/toCarManager.action', '0', '', '&#xe657;', '1');
INSERT INTO `sys_menu` VALUES ('8', '3', '汽车出租', '../bus/toRentCarManager.action', '0', '', '&#xe65b;', '1');
INSERT INTO `sys_menu` VALUES ('9', '3', '出租单管理', '../bus/toRentManager.action', '0', '', '&#xe6b2;', '1');
INSERT INTO `sys_menu` VALUES ('10', '3', '汽车入库', '../bus/toCheckCarManager.action', '0', '', '&#xe65a;', '1');
INSERT INTO `sys_menu` VALUES ('11', '3', '检查单管理', '../bus/toCheckManager.action', '0', '', '&#xe705;', '1');
INSERT INTO `sys_menu` VALUES ('12', '4', '菜单管理', '../sys/toMenuManager.action', '0', null, '&#xe60f;', '1');
INSERT INTO `sys_menu` VALUES ('13', '4', '角色管理', '../sys/toRoleManager.action', '0', '', '&#xe66f;', '1');
INSERT INTO `sys_menu` VALUES ('14', '4', '用户管理', '../sys/toUserManager.action', '0', '', '&#xe770;', '1');
INSERT INTO `sys_menu` VALUES ('15', '4', '日志管理', '../sys/toLogInfoManager.action', '0', '', '&#xe655;', '1');
INSERT INTO `sys_menu` VALUES ('16', '4', '公告管理', '../sys/toNewsManager.action', '0', '', '&#xe645;', '1');
INSERT INTO `sys_menu` VALUES ('17', '4', '数据源监控', '../druid/', '0', '', '&#xe857;', '1');
INSERT INTO `sys_menu` VALUES ('18', '5', '客户地区统计', '../stat/toCustomerAreaStat.action', '0', '', '&#xe63c;', '1');
INSERT INTO `sys_menu` VALUES ('19', '5', '公司年度月份销售额', '../stat/toCompanyYearGradeStat.action', '0', '', '&#xe62c;', '1');
INSERT INTO `sys_menu` VALUES ('20', '5', '业务员年度销售额', '../stat/toOpernameYearGradeStat.action', '0', '', '&#xe62d;', '1');

-- ----------------------------
-- Table structure for sys_news
-- ----------------------------
DROP TABLE IF EXISTS `sys_news`;
CREATE TABLE `sys_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(4000) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `opername` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_news
-- ----------------------------
INSERT INTO `sys_news` VALUES ('5', '关于系统V1.0发布公告', '<p>关于系统V1.5升级公告关于系统V1.5升级公告关于系统V1.5升级公告关于系统V1.5升级公告关于系统V1.5升级公告			</p>', '2018-06-14 18:05:22', '习大大');
INSERT INTO `sys_news` VALUES ('6', '关于系统V1.3升级公告', '<p>12312312312312312312</p>', '2019-03-19 14:10:11', '超级管理员');
INSERT INTO `sys_news` VALUES ('7', '关于系统V1.4升级公告', '<p>312312312</p>', '2019-06-11 11:30:15', '超级管理员');
INSERT INTO `sys_news` VALUES ('12', '关于系统V1.5升级公告', '<p>关于系统V1.5升级公告</p>', '2019-07-23 16:30:18', '习大大');
INSERT INTO `sys_news` VALUES ('16', '关于车牌号A11111未正常入库相关人员的处理意见', '<p>关于车牌号A11111未正常入库相关人员的处理意见关于车牌号A11111未正常入库相关人员的处理意见关于车牌号A11111未正常入库相关人员的处理意见</p>', '2019-07-27 11:21:49', '超级管理员');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(255) DEFAULT NULL,
  `roledesc` varchar(255) DEFAULT NULL,
  `available` int(11) DEFAULT NULL,
  PRIMARY KEY (`roleid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级管理员', '拥有所有菜单权限', '1');
INSERT INTO `sys_role` VALUES ('2', '业务管理员', '拥有所以业务菜单', '1');
INSERT INTO `sys_role` VALUES ('3', '系统管理员', '管理系统', '1');
INSERT INTO `sys_role` VALUES ('4', '数据统计管理员', '数据统计管理员', '1');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `rid` int(11) NOT NULL,
  `mid` int(11) NOT NULL,
  PRIMARY KEY (`rid`,`mid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('1', '1');
INSERT INTO `sys_role_menu` VALUES ('1', '2');
INSERT INTO `sys_role_menu` VALUES ('1', '3');
INSERT INTO `sys_role_menu` VALUES ('1', '4');
INSERT INTO `sys_role_menu` VALUES ('1', '5');
INSERT INTO `sys_role_menu` VALUES ('1', '6');
INSERT INTO `sys_role_menu` VALUES ('1', '7');
INSERT INTO `sys_role_menu` VALUES ('1', '8');
INSERT INTO `sys_role_menu` VALUES ('1', '9');
INSERT INTO `sys_role_menu` VALUES ('1', '10');
INSERT INTO `sys_role_menu` VALUES ('1', '11');
INSERT INTO `sys_role_menu` VALUES ('1', '12');
INSERT INTO `sys_role_menu` VALUES ('1', '13');
INSERT INTO `sys_role_menu` VALUES ('1', '14');
INSERT INTO `sys_role_menu` VALUES ('1', '15');
INSERT INTO `sys_role_menu` VALUES ('1', '16');
INSERT INTO `sys_role_menu` VALUES ('1', '17');
INSERT INTO `sys_role_menu` VALUES ('1', '18');
INSERT INTO `sys_role_menu` VALUES ('1', '19');
INSERT INTO `sys_role_menu` VALUES ('1', '20');
INSERT INTO `sys_role_menu` VALUES ('2', '1');
INSERT INTO `sys_role_menu` VALUES ('2', '2');
INSERT INTO `sys_role_menu` VALUES ('2', '3');
INSERT INTO `sys_role_menu` VALUES ('2', '6');
INSERT INTO `sys_role_menu` VALUES ('2', '7');
INSERT INTO `sys_role_menu` VALUES ('2', '8');
INSERT INTO `sys_role_menu` VALUES ('2', '9');
INSERT INTO `sys_role_menu` VALUES ('2', '10');
INSERT INTO `sys_role_menu` VALUES ('2', '11');
INSERT INTO `sys_role_menu` VALUES ('3', '1');
INSERT INTO `sys_role_menu` VALUES ('3', '4');
INSERT INTO `sys_role_menu` VALUES ('3', '12');
INSERT INTO `sys_role_menu` VALUES ('3', '13');
INSERT INTO `sys_role_menu` VALUES ('3', '14');
INSERT INTO `sys_role_menu` VALUES ('3', '15');
INSERT INTO `sys_role_menu` VALUES ('3', '16');
INSERT INTO `sys_role_menu` VALUES ('3', '17');
INSERT INTO `sys_role_menu` VALUES ('4', '1');
INSERT INTO `sys_role_menu` VALUES ('4', '5');
INSERT INTO `sys_role_menu` VALUES ('4', '18');
INSERT INTO `sys_role_menu` VALUES ('4', '19');
INSERT INTO `sys_role_menu` VALUES ('4', '20');

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `uid` int(11) NOT NULL,
  `rid` int(11) NOT NULL,
  PRIMARY KEY (`uid`,`rid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------
INSERT INTO `sys_role_user` VALUES ('3', '1');
INSERT INTO `sys_role_user` VALUES ('4', '2');
INSERT INTO `sys_role_user` VALUES ('5', '3');
INSERT INTO `sys_role_user` VALUES ('6', '4');
INSERT INTO `sys_role_user` VALUES ('7', '3');
INSERT INTO `sys_role_user` VALUES ('7', '4');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(255) DEFAULT NULL,
  `identity` varchar(255) DEFAULT NULL,
  `realname` varchar(255) DEFAULT NULL,
  `sex` int(255) DEFAULT NULL COMMENT '0女1男',
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `type` int(255) DEFAULT '2' COMMENT '1，超级管理员,2，系统用户',
  `available` int(255) DEFAULT NULL,
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '4313341334413', '超级管理员', '1', '武汉', '134441331311', 'e10adc3949ba59abbe56e057f20f883e', 'CEO', '1', '1');
INSERT INTO `sys_user` VALUES ('3', 'zhangsan', '3413334134131131', '张三', '1', '武汉', '134131313111', 'e10adc3949ba59abbe56e057f20f883e', 'BA', '2', '1');
INSERT INTO `sys_user` VALUES ('4', 'ls', '43311341311314341', '李四', '1', '武汉', '1341314113131', 'e10adc3949ba59abbe56e057f20f883e', '扫地的', '2', '1');
INSERT INTO `sys_user` VALUES ('5', 'ww', '4313133131331312', '王五', '1', '武汉', '13413131131', 'e10adc3949ba59abbe56e057f20f883e', '领导', '2', '1');
INSERT INTO `sys_user` VALUES ('6', 'xm', '45113141331131131', '小明', '0', '武昌', '13451333131', 'e10adc3949ba59abbe56e057f20f883e', '扫地地', '2', '1');
INSERT INTO `sys_user` VALUES ('7', 'xdd', '41113113331133', '习大大', '1', '北京', '13511333113', 'e10adc3949ba59abbe56e057f20f883e', '主席', '2', '1');

-- ----------------------------
-- Table structure for system_menu
-- ----------------------------
DROP TABLE IF EXISTS `system_menu`;
CREATE TABLE `system_menu` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `pid` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '父ID',
  `title` varchar(100) NOT NULL DEFAULT '' COMMENT '名称',
  `icon` varchar(100) NOT NULL DEFAULT '' COMMENT '菜单图标',
  `href` varchar(100) NOT NULL DEFAULT '' COMMENT '链接',
  `target` varchar(20) NOT NULL DEFAULT '_self' COMMENT '链接打开方式',
  `sort` int(11) DEFAULT '0' COMMENT '菜单排序',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态(0:禁用,1:启用)',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `create_at` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `delete_at` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`),
  KEY `title` (`title`),
  KEY `href` (`href`)
) ENGINE=InnoDB AUTO_INCREMENT=250 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='系统菜单表';

-- ----------------------------
-- Records of system_menu
-- ----------------------------

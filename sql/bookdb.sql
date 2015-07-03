/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : bookdb

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2015-07-03 20:46:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `isbn` varchar(50) NOT NULL COMMENT '书号',
  `title` varchar(50) DEFAULT NULL COMMENT '书名',
  `publisherName` varchar(200) DEFAULT NULL COMMENT '出版社名称',
  `price` decimal(9,2) DEFAULT NULL COMMENT '书籍单价',
  `pubDt` date DEFAULT NULL COMMENT '出版日期',
  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('010102023', '亲，我怎么又成炮灰了', '滨州出版社', '250.00', '2015-07-03');
INSERT INTO `books` VALUES ('0130284181', 'Perl How to Program', '清华大学出版社', '70.00', '2014-01-01');
INSERT INTO `books` VALUES ('0130284190', 'e-Business and e-Commerce How to Program', '清华大学出版社', '70.00', '2013-02-01');
INSERT INTO `books` VALUES ('0130829277', 'The Complete Java Training Course (Java 1.1)', '人民邮电出版社', '100.00', '2014-01-01');
INSERT INTO `books` VALUES ('0130829288', '这次我真的是书名，我好伤心- -!!', '滨州出版社', '250.00', '2015-07-03');
INSERT INTO `books` VALUES ('0132220566', '哎，哎，我就是个炮灰，别理我- -', '滨院出版社', '250.00', '2015-07-03');
INSERT INTO `books` VALUES ('0992932', '我是炮灰', '痘痘出版社', '189.00', '2015-07-03');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '微机编码，自动增长',
  `uname` varchar(20) DEFAULT NULL,
  `zipcode` varchar(10) DEFAULT NULL COMMENT '订单状态：1付款未发货，2已经发货，3已经收货，4已经结束',
  `card` varchar(40) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `total` decimal(20,2) DEFAULT NULL COMMENT '总金额',
  `uid` int(4) DEFAULT NULL COMMENT '用户的id，外键',
  PRIMARY KEY (`id`),
  KEY `fk_uid` (`uid`),
  CONSTRAINT `fk_uid` FOREIGN KEY (`uid`) REFERENCES `userinfo` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', 'zs', '25600', '123467', '15762186339', '250.00', '1');

-- ----------------------------
-- Table structure for sysuser
-- ----------------------------
DROP TABLE IF EXISTS `sysuser`;
CREATE TABLE `sysuser` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '微机编码，自动增长',
  `uname` varchar(50) DEFAULT NULL COMMENT '管理员用户名',
  `upass` varchar(50) DEFAULT NULL COMMENT '管理员密码',
  `uqx` varchar(50) DEFAULT NULL COMMENT '管理员权限',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_uname` (`uname`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of sysuser
-- ----------------------------
INSERT INTO `sysuser` VALUES ('1', 'gxs', 'gxs', 'super');
INSERT INTO `sysuser` VALUES ('2', 'tgy', '123', 'admin');
INSERT INTO `sysuser` VALUES ('3', 'sf', 'sf', null);

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '微机编码，自动增长',
  `uname` varchar(50) NOT NULL COMMENT '用户名',
  `realname` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `upass` varchar(50) DEFAULT NULL COMMENT '密码',
  `phone` varchar(50) DEFAULT NULL COMMENT '电话',
  `address` varchar(50) DEFAULT NULL COMMENT '地址',
  `account` decimal(9,2) DEFAULT NULL COMMENT '用户账户余额',
  `zipcode` varchar(50) DEFAULT NULL COMMENT '邮政编码',
  `creditCard` varchar(50) DEFAULT NULL COMMENT '卡号',
  `createDt` varchar(255) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_uname` (`uname`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', 'ls', '李四', 'ls', '111111', '滨州学院办公楼', '5000.00', '256600', '121111111', '2014-12-1');
INSERT INTO `userinfo` VALUES ('2', 'sf', '宋锋', 'sf', '222222', '滨州学院信息楼', '5000.00', '256600', '121111122', '2014-12-4');
INSERT INTO `userinfo` VALUES ('3', 'zs', '张三', 'zs', '333333', '滨州学院工科楼', '5000.00', '256600', '121111133', '2014-12-5');
INSERT INTO `userinfo` VALUES ('4', 'gxs', 'gxs', '123', '123', '123', '123.00', '123', '123', '2014-12-2');

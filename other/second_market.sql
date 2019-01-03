/*
Navicat MySQL Data Transfer

Source Server         : mess
Source Server Version : 50718
Source Host           : cdb-6usc5wvj.gz.tencentcdb.com:10034
Source Database       : second_market

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2019-01-03 10:52:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_announcement
-- ----------------------------
DROP TABLE IF EXISTS `t_announcement`;
CREATE TABLE `t_announcement` (
  `id` varchar(32) NOT NULL,
  `titlle` varchar(20) DEFAULT NULL COMMENT '标题',
  `content` varchar(500) DEFAULT NULL COMMENT '内容',
  `picture_id` varchar(32) DEFAULT NULL COMMENT '图片id',
  `creat_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `state` varchar(20) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公告信息表';

-- ----------------------------
-- Records of t_announcement
-- ----------------------------

-- ----------------------------
-- Table structure for t_commodity
-- ----------------------------
DROP TABLE IF EXISTS `t_commodity`;
CREATE TABLE `t_commodity` (
  `id` varchar(32) NOT NULL,
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `category` varchar(50) DEFAULT NULL COMMENT '类别',
  `info` varchar(500) DEFAULT NULL COMMENT '描述',
  `pop` int(11) DEFAULT NULL COMMENT '人气',
  `picture_id` varchar(32) DEFAULT NULL COMMENT '照片id',
  `price` double DEFAULT NULL COMMENT '原价',
  `secprice` double DEFAULT NULL COMMENT '二手价',
  `conditions` varchar(20) DEFAULT NULL COMMENT '新旧程度',
  `message_id` varchar(32) DEFAULT NULL COMMENT '评论信息id',
  `num` int(11) DEFAULT NULL COMMENT '数量',
  `seller_id` varchar(32) DEFAULT NULL COMMENT '卖家',
  `buyer_id` varchar(32) DEFAULT NULL COMMENT '买家',
  `creart_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `closing_time` bigint(20) DEFAULT NULL COMMENT '成交时间',
  `state` varchar(20) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品信息表';

-- ----------------------------
-- Records of t_commodity
-- ----------------------------
INSERT INTO `t_commodity` VALUES ('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `t_commodity` VALUES ('10', '10', '10', '10', '10', '10', '10', '10', '10', '10', '10', '10', '10', '10', '10', '10');
INSERT INTO `t_commodity` VALUES ('11', '11', '11', '11', '11', '11', '11', '11', '11', '11', '11', '11', '11', '11', '11', '11');
INSERT INTO `t_commodity` VALUES ('12', '12', '12', '12', '12', '12', '12', '12', '12', '12', '12', '12', '12', '12', '12', '12');
INSERT INTO `t_commodity` VALUES ('13', '13', '13', '13', '13', '13', '13', '13', '13', '13', '13', '13', '13', '13', '13', '13');
INSERT INTO `t_commodity` VALUES ('14', '14', '14', '14', '14', '14', '14', '14', '14', '14', '14', '14', '14', '14', '14', '14');
INSERT INTO `t_commodity` VALUES ('15', '15', '15', '15', '15', '15', '15', '15', '15', '15', '15', '15', '15', '15', '15', '15');
INSERT INTO `t_commodity` VALUES ('16', '16', '16', '16', '16', '16', '16', '16', '16', '16', '16', '16', '16', '16', '16', '16');
INSERT INTO `t_commodity` VALUES ('17', '17', '17', '17', '17', '17', '17', '17', '17', '17', '17', '17', '17', '17', '17', '17');
INSERT INTO `t_commodity` VALUES ('18', '18', '18', '18', '18', '18', '18', '18', '18', '18', '18', '18', '18', '18', '18', '18');
INSERT INTO `t_commodity` VALUES ('19', '19', '19', '19', '19', '19', '19', '19', '19', '19', '19', '19', '19', '19', '19', '19');
INSERT INTO `t_commodity` VALUES ('2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2');
INSERT INTO `t_commodity` VALUES ('20', '20', '20', '20', '20', '20', '20', '20', '20', '20', '20', '20', '20', '20', '20', '20');
INSERT INTO `t_commodity` VALUES ('21', '21', '21', '21', '21', '21', '21', '21', '21', '21', '21', '21', '21', '21', '21', '21');
INSERT INTO `t_commodity` VALUES ('3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3');
INSERT INTO `t_commodity` VALUES ('4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4');
INSERT INTO `t_commodity` VALUES ('5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5');
INSERT INTO `t_commodity` VALUES ('6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6');
INSERT INTO `t_commodity` VALUES ('7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7');
INSERT INTO `t_commodity` VALUES ('8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8');
INSERT INTO `t_commodity` VALUES ('9', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9');

-- ----------------------------
-- Table structure for t_message
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message` (
  `id` varchar(32) NOT NULL,
  `owner_id` varchar(32) DEFAULT NULL COMMENT '楼主id',
  `owner_name` varchar(20) DEFAULT NULL COMMENT '楼主姓名',
  `passersby_id` varchar(32) DEFAULT NULL COMMENT '回复者id',
  `answer_id` varchar(32) DEFAULT NULL COMMENT '被回复id，下一条评论',
  `commodity_id` varchar(32) DEFAULT NULL COMMENT '商品id',
  `content` text COMMENT '回复内容',
  `time` bigint(20) DEFAULT NULL COMMENT '回复事件',
  `passersby_name` varchar(20) DEFAULT NULL COMMENT '回复者姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='留言信息表';

-- ----------------------------
-- Records of t_message
-- ----------------------------

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` varchar(32) NOT NULL,
  `commodity_id` varchar(50) DEFAULT NULL COMMENT '物品id',
  `picture_id` varchar(32) DEFAULT NULL COMMENT '照片id',
  `price` double DEFAULT NULL COMMENT '成交价',
  `num` int(11) DEFAULT NULL COMMENT '数量',
  `seller_id` varchar(32) DEFAULT NULL COMMENT '卖家',
  `buyer_id` varchar(32) DEFAULT NULL COMMENT '买家',
  `creart_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `pay_time` bigint(20) DEFAULT NULL COMMENT '付款时间',
  `state` varchar(20) DEFAULT NULL COMMENT '状态',
  `address` varchar(200) DEFAULT NULL COMMENT '地址',
  `is_sign` smallint(6) DEFAULT NULL COMMENT '是否签收',
  `is_pay` smallint(6) DEFAULT NULL COMMENT '是否付款',
  `logistics_code` varchar(20) DEFAULT NULL COMMENT '物流id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单信息表';

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(32) NOT NULL,
  `account` varchar(20) DEFAULT NULL COMMENT '账号',
  `username` varchar(20) DEFAULT NULL COMMENT '名字',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `user_email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `avatar` varchar(500) DEFAULT NULL COMMENT '头像',
  `tel` varchar(20) DEFAULT NULL COMMENT '电话',
  `sex` varchar(10) DEFAULT NULL COMMENT '性别',
  `school` varchar(40) DEFAULT NULL COMMENT '学校',
  `address` varchar(200) DEFAULT NULL COMMENT '地址',
  `creat_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `last_time` bigint(20) DEFAULT NULL COMMENT '最后登录时间',
  `login_ip` varchar(50) DEFAULT NULL COMMENT '最后登录ip',
  `is_admin` smallint(6) DEFAULT NULL COMMENT '是否管理员',
  `state` smallint(6) DEFAULT NULL COMMENT '状态',
  `lng` double DEFAULT NULL COMMENT '经度',
  `lat` double DEFAULT NULL COMMENT '纬度',
  `qq` varchar(20) DEFAULT NULL COMMENT 'QQ',
  `wechat` varchar(20) DEFAULT NULL COMMENT '微信',
  `alipay` varchar(20) DEFAULT NULL COMMENT '支付宝',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员信息表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '1', '1', 'c4ca4238a0b923820dcc509a6f75849b', '1', '1', '1', '1', '1', '1', '1546066670', '1546066670', '1', '1', '1', '1', '1', '1', '1', '1');

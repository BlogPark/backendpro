/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : yongming

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2020-02-04 09:58:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for systemmenu
-- ----------------------------
DROP TABLE IF EXISTS `systemmenu`;
CREATE TABLE `systemmenu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `fatherid` int(11) DEFAULT NULL COMMENT '父级ID',
  `menuname` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `menutype` int(11) DEFAULT NULL COMMENT '菜单类型(1 菜单 2  按钮)',
  `menucontrollers` varchar(1000) DEFAULT NULL COMMENT '菜单控制器',
  `menurouter` varchar(255) DEFAULT NULL COMMENT '菜单路由',
  `menuicon` varchar(255) DEFAULT NULL COMMENT '菜单徽标',
  `menustatus` int(11) DEFAULT NULL COMMENT '菜单状态(1 正常 2 删除)',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of systemmenu
-- ----------------------------
INSERT INTO `systemmenu` VALUES ('1', '0', '导航一', '1', null, null, 'el-icon-s-operation', '1', '2020-02-01 14:43:21');
INSERT INTO `systemmenu` VALUES ('2', '0', '导航二', '1', null, null, 'el-icon-s-grid', '1', '2020-02-01 14:43:48');
INSERT INTO `systemmenu` VALUES ('3', '0', '导航三', '1', null, null, 'el-icon-s-marketing', '1', '2020-02-01 14:44:15');
INSERT INTO `systemmenu` VALUES ('4', '1', '子导航一', '1', '', '', '', '1', '2020-02-01 14:43:21');
INSERT INTO `systemmenu` VALUES ('5', '2', '子导航二', '1', '', '', '', '1', '2020-02-01 14:43:48');
INSERT INTO `systemmenu` VALUES ('6', '3', '子导航三', '1', '', '', '', '1', '2020-02-01 14:44:15');

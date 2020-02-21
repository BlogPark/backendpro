/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50724
Source Host           : 127.0.0.1:3306
Source Database       : yongming

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2020-02-17 14:24:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for drools_entity
-- ----------------------------
DROP TABLE IF EXISTS `drools_entity`;
CREATE TABLE `drools_entity` (
  `id` int(11) NOT NULL,
  `entityname` varchar(500) DEFAULT NULL COMMENT '实体名字',
  `entitypackage` varchar(500) DEFAULT NULL COMMENT '实体所在包名',
  `entitydesc` varchar(500) DEFAULT NULL COMMENT '实体描述',
  `eneityremark` varchar(500) DEFAULT NULL COMMENT '实体备注',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `groupid` int(11) DEFAULT NULL COMMENT '分组id',
  `groupname` varchar(255) DEFAULT NULL COMMENT '分组名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='实体表';

-- ----------------------------
-- Records of drools_entity
-- ----------------------------

-- ----------------------------
-- Table structure for drools_entitydetail
-- ----------------------------
DROP TABLE IF EXISTS `drools_entitydetail`;
CREATE TABLE `drools_entitydetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `entityid` int(11) DEFAULT NULL COMMENT '实体ID',
  `entityname` varchar(500) DEFAULT NULL COMMENT '实体名称',
  `fieldname` varchar(500) DEFAULT NULL COMMENT '字段名称',
  `usageexample` varchar(500) DEFAULT NULL COMMENT '使用示例',
  `fielddesc` varchar(500) DEFAULT NULL COMMENT '字段描述',
  `fieldtype` varchar(255) DEFAULT NULL COMMENT '字段类型',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='实体描述表';

-- ----------------------------
-- Records of drools_entitydetail
-- ----------------------------

-- ----------------------------
-- Table structure for drools_function
-- ----------------------------
DROP TABLE IF EXISTS `drools_function`;
CREATE TABLE `drools_function` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `functionname` varchar(500) DEFAULT NULL COMMENT '函数名称',
  `functiondesc` varchar(500) DEFAULT NULL COMMENT '函数描述',
  `functioncontent` varchar(2000) DEFAULT NULL COMMENT '函数内容',
  `quoteentities` varchar(500) DEFAULT NULL COMMENT '函数引用实体集合',
  `returntype` varchar(500) DEFAULT NULL COMMENT '函数返回值类型',
  `functionparamterdesc` varchar(2000) DEFAULT NULL COMMENT '函数参数描述',
  `usageexample` varchar(2000) DEFAULT NULL COMMENT '使用示例',
  `groupid` int(11) DEFAULT NULL COMMENT '分组id',
  `groupname` varchar(255) DEFAULT NULL COMMENT '分组名称',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='函数表';

-- ----------------------------
-- Records of drools_function
-- ----------------------------

-- ----------------------------
-- Table structure for drools_group
-- ----------------------------
DROP TABLE IF EXISTS `drools_group`;
CREATE TABLE `drools_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `groupname` varchar(255) DEFAULT NULL COMMENT '分组名称',
  `groupdesc` varchar(255) DEFAULT NULL COMMENT '分组描述',
  `grouptype` int(11) DEFAULT NULL COMMENT '分组类型',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='分组信息表';

-- ----------------------------
-- Records of drools_group
-- ----------------------------

-- ----------------------------
-- Table structure for drools_product
-- ----------------------------
DROP TABLE IF EXISTS `drools_product`;
CREATE TABLE `drools_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productcode` varchar(255) DEFAULT NULL COMMENT '产品编码',
  `productname` varchar(255) DEFAULT NULL COMMENT '产品名称',
  `versioncode` varchar(255) DEFAULT NULL COMMENT '版本号',
  `rulefilepath` varchar(255) DEFAULT NULL COMMENT '规则文件存放位置',
  `quoterules` varchar(255) DEFAULT NULL COMMENT '引用规则列表',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of drools_product
-- ----------------------------

-- ----------------------------
-- Table structure for drools_rules
-- ----------------------------
DROP TABLE IF EXISTS `drools_rules`;
CREATE TABLE `drools_rules` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `rulecode` varchar(500) DEFAULT NULL COMMENT '规则编码',
  `rulegroup` varchar(500) DEFAULT NULL COMMENT '规则组名',
  `templateid` int(11) DEFAULT NULL COMMENT '引用模板ID',
  `rulecontent` varchar(2000) DEFAULT NULL COMMENT '规则内容',
  `quoteentities` varchar(500) DEFAULT NULL COMMENT '引用实体集合',
  `quotefunctions` varchar(500) DEFAULT NULL COMMENT '引用函数集合',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='规则表';

-- ----------------------------
-- Records of drools_rules
-- ----------------------------

-- ----------------------------
-- Table structure for drools_templates
-- ----------------------------
DROP TABLE IF EXISTS `drools_templates`;
CREATE TABLE `drools_templates` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `templatename` varchar(500) DEFAULT NULL COMMENT '模板名称',
  `templatedesc` varchar(500) DEFAULT NULL COMMENT '模板描述',
  `quoteentities` varchar(255) DEFAULT NULL COMMENT '引用实体',
  `canchanged` int(11) DEFAULT NULL COMMENT '是否可以改动',
  `templatecontent` varchar(2000) DEFAULT NULL COMMENT '模板内容',
  `quotefunctions` varchar(255) DEFAULT NULL COMMENT '引用函数',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='模板信息表';

-- ----------------------------
-- Records of drools_templates
-- ----------------------------

-- ----------------------------
-- Table structure for pinboard
-- ----------------------------
DROP TABLE IF EXISTS `pinboard`;
CREATE TABLE `pinboard` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `title` varchar(255) DEFAULT NULL COMMENT '标签标题',
  `content` varchar(1000) DEFAULT NULL COMMENT '标签内容',
  `remind` int(11) DEFAULT NULL COMMENT '是否提醒',
  `remindtime` datetime DEFAULT NULL COMMENT '提醒时间',
  `cacleremind` int(11) DEFAULT NULL COMMENT '取消提醒',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `userid` int(11) DEFAULT NULL COMMENT '用户ID',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `pinstatus` int(11) DEFAULT NULL COMMENT '标签状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='标签表';

-- ----------------------------
-- Records of pinboard
-- ----------------------------
INSERT INTO `pinboard` VALUES ('1', 'HTML5 文档类型', 'Bootstrap 使用到的某些 HTML 元素和 CSS 属性需要将页面设置为 HTML5 文档类型。在你项目中的每个页面都要参照下面的格式进行设置。', '0', null, null, '2020-02-09 22:45:12', '1', '管理员', '1');
INSERT INTO `pinboard` VALUES ('2', 'Normalize.css', '为了增强跨浏览器表现的一致性，我们使用了 Normalize.css，这是由 Nicolas Gallagher 和 Jonathan Neal 维护的一个CSS 重置样式库。', '1', null, null, '2020-02-09 22:46:15', '1', '管理员', '1');

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
INSERT INTO `systemmenu` VALUES ('4', '1', '子导航一', '1', '', '/order', '', '1', '2020-02-01 14:43:21');
INSERT INTO `systemmenu` VALUES ('5', '2', '子导航二', '1', '', '/orderdetail', '', '1', '2020-02-01 14:43:48');
INSERT INTO `systemmenu` VALUES ('6', '3', '子导航三', '1', '', '/pinboard', '', '1', '2020-02-01 14:44:15');

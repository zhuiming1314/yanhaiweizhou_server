/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : localhost:3306
 Source Schema         : user

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 11/05/2021 13:30:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_estonian_ci NOT NULL COMMENT '用户id',
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_estonian_ci NOT NULL COMMENT '电话号码',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_estonian_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_estonian_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for user's production
-- ----------------------------
DROP TABLE IF EXISTS `user_production`;
CREATE TABLE `user_production`  (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '作品id',
  `uid` varchar(100) CHARACTER SET utf8 COLLATE utf8_estonian_ci NOT NULL COMMENT '所属用户id',
  `production` text DEFAULT NULL COMMENT '用户作品',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;


-- ----------------------------
-- Table structure for user's materials used recently 
-- materials应该只需要存储material_url？
-- ----------------------------
DROP TABLE IF EXISTS `user_lib`;
CREATE TABLE `user_lib`  (
  `id` int(5) NOT NULL AUTO_INCREMENT  COMMENT '最近使用元素id',
  `uname` varchar(100) CHARACTER SET utf8 COLLATE utf8_estonian_ci NOT NULL COMMENT '所属用户',
  `materials` text DEFAULT NULL COMMENT '用户最近使用元素',
  `time` TIMESTAMP DEFAULT NULL COMMENT '使用该元素时间戳',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;
-- ----------------------------
-- Table structure for public_material
-- ----------------------------
DROP TABLE IF EXISTS `public_material`;
CREATE TABLE `public_material`  (
  `pid` varchar(100) CHARACTER SET utf8 COLLATE utf8_estonian_ci NOT NULL COMMENT '素材id',
  `thumbnail_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_estonian_ci NULL DEFAULT NULL COMMENT '缩略图地址',
  `picture_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_estonian_ci NULL DEFAULT NULL COMMENT '素材地址',
  `category` varchar(20) CHARACTER SET utf8 COLLATE utf8_estonian_ci NULL DEFAULT NULL COMMENT '类别',
  `count` int COLLATE utf8_estonian_ci NULL DEFAULT NULL COMMENT '数量',
  `md5` varchar(255) CHARACTER SET utf8 COLLATE utf8_estonian_ci NULL DEFAULT NULL COMMENT 'MD5',
  PRIMARY KEY (`pid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_estonian_ci ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `public_template`;
CREATE TABLE `public_template`  (
  `pid` varchar(100) CHARACTER SET utf8 COLLATE utf8_estonian_ci NOT NULL COMMENT '模板id',
  `template_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_estonian_ci NULL DEFAULT NULL COMMENT '模板地址',
  `category` varchar(20) CHARACTER SET utf8 COLLATE utf8_estonian_ci NULL DEFAULT NULL COMMENT '类别',
  `count` int COLLATE utf8_estonian_ci NULL DEFAULT NULL COMMENT '数量',
  `md5` varchar(255) CHARACTER SET utf8 COLLATE utf8_estonian_ci NULL DEFAULT NULL COMMENT 'MD5',
  PRIMARY KEY (`pid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_estonian_ci ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `detail_template`;
CREATE TABLE `detail_template`  (
  `pid` varchar(100) CHARACTER SET utf8 COLLATE utf8_estonian_ci NOT NULL COMMENT 'id',
  `category` varchar(20) CHARACTER SET utf8 COLLATE utf8_estonian_ci NULL DEFAULT NULL COMMENT '类别',
  `tpid` varchar(100) CHARACTER SET utf8 COLLATE utf8_estonian_ci NOT NULL COMMENT '所属模板id',
  `tindex` int COLLATE utf8_estonian_ci NULL DEFAULT NULL COMMENT '在所属模板中的序号',
  `objs` text DEFAULT NULL COMMENT 'objs',
  `element` varchar(255) CHARACTER SET utf8 COLLATE utf8_estonian_ci NULL DEFAULT NULL COMMENT '元素描述',
  `md5` varchar(255) CHARACTER SET utf8 COLLATE utf8_estonian_ci NULL DEFAULT NULL COMMENT 'MD5',
  PRIMARY KEY (`pid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_estonian_ci ROW_FORMAT = Dynamic;

/**
insert into public_material(pid, thumbnail_url, picture_url, category, count, md5) values ('5', 'test', '/Users/zhuiming/Documents/yanhai/material/botany/', 'botany', 14, 'md5test');
insert into public_material(pid, thumbnail_url, picture_url, category, count, md5) values ('2', 'test', '/Users/zhuiming/Documents/yanhai/material/cloud/', 'cloud', 11, 'md5test');
insert into public_material(pid, thumbnail_url, picture_url, category, count, md5) values ('3', 'test', '/Users/zhuiming/Documents/yanhai/material/person/', 'person', 11, 'md5test');
insert into public_material(pid, thumbnail_url, picture_url, category, count, md5) values ('4', 'test', '/Users/zhuiming/Documents/yanhai/material/animal/', 'animal', 9, 'md5test');
insert into public_template(pid, template_url, category, count, md5) values ('1', '/Users/zhuiming/Documents/yanhai/template/simple/', 'simple', 1, 'md5test');
**/
-- ----------------------------
-- Table structure for user_picture
-- ----------------------------
DROP TABLE IF EXISTS `user_picture`;
CREATE TABLE `user_picture`  (
  `pid` varchar(100) CHARACTER SET utf8 COLLATE utf8_estonian_ci NOT NULL COMMENT '图片id',
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_estonian_ci NOT NULL COMMENT '用户id',
  `thumbnail_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_estonian_ci NULL DEFAULT NULL COMMENT '缩略图地址',
  `file_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_estonian_ci NULL DEFAULT NULL COMMENT '文件地址',
  PRIMARY KEY (`pid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

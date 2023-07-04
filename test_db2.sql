/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 50735
 Source Host           : localhost:3306
 Source Schema         : test_db2

 Target Server Type    : MySQL
 Target Server Version : 50735
 File Encoding         : 65001

 Date: 04/07/2023 17:57:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for db_user2
-- ----------------------------
DROP TABLE IF EXISTS `db_user2`;
CREATE TABLE `db_user2`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `describes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_user2
-- ----------------------------
INSERT INTO `db_user2` VALUES (1, '李四', '这是数据库db2的数据');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '住址',
  `describes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '刘亦菲', 18, '女', '上海闵行', '这是db2的用户');
INSERT INTO `user` VALUES (2, '杨幂', 20, '女', '北京朝阳', '这是db2的用户');
INSERT INTO `user` VALUES (3, '彭于晏', 30, '男', '河北邯郸', '这是db2的用户');
INSERT INTO `user` VALUES (4, '胡歌', 22, '男', '江西南昌', '这是db2的用户');
INSERT INTO `user` VALUES (5, '刘德华', 30, '男', '香港新界', '这是db2的用户');

SET FOREIGN_KEY_CHECKS = 1;

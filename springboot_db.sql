/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 50735
 Source Host           : localhost:3306
 Source Schema         : springboot_db

 Target Server Type    : MySQL
 Target Server Version : 50735
 File Encoding         : 65001

 Date: 04/07/2023 17:57:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cat
-- ----------------------------
DROP TABLE IF EXISTS `cat`;
CREATE TABLE `cat`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `color` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cat
-- ----------------------------
INSERT INTO `cat` VALUES (4, 'red', '波斯猫', 30);
INSERT INTO `cat` VALUES (5, 'blue', '蓝猫', 50);
INSERT INTO `cat` VALUES (6, 'green', '蓝白', 80);
INSERT INTO `cat` VALUES (7, 'pink', '粉色猫', 90);

-- ----------------------------
-- Table structure for db_user
-- ----------------------------
DROP TABLE IF EXISTS `db_user`;
CREATE TABLE `db_user`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `describes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_user
-- ----------------------------
INSERT INTO `db_user` VALUES ('2', '黄忠', '这是黄忠的个人信息描述');

-- ----------------------------
-- Table structure for flyway_schema_history
-- ----------------------------
DROP TABLE IF EXISTS `flyway_schema_history`;
CREATE TABLE `flyway_schema_history`  (
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `script` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `checksum` int(11) NULL DEFAULT NULL,
  `installed_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `installed_on` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`) USING BTREE,
  INDEX `flyway_schema_history_s_idx`(`success`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of flyway_schema_history
-- ----------------------------
INSERT INTO `flyway_schema_history` VALUES (1, '1.0', 'INIT DB', 'SQL', 'V1.0__INIT_DB.sql', 1598008518, 'root', '2023-06-14 14:02:52', 51, 1);

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade`  (
  `id` int(11) NOT NULL COMMENT '自增id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级名称',
  `student_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES (1, '六年纪1班', 1, '2021-11-26 14:56:43', '2021-11-26 14:56:46');
INSERT INTO `grade` VALUES (2, '六年纪1班', 2, '2021-11-26 14:57:01', '2021-11-26 14:57:04');
INSERT INTO `grade` VALUES (3, '五年级1班', 3, '2021-11-26 14:57:21', '2021-11-26 14:57:24');
INSERT INTO `grade` VALUES (4, '四年级6班', 4, '2021-11-26 14:57:36', '2021-11-26 14:57:38');
INSERT INTO `grade` VALUES (5, '一年级1班', 5, '2021-11-26 14:58:07', '2021-11-26 14:58:10');
INSERT INTO `grade` VALUES (6, '二年级1班', 5, '2021-11-26 14:58:07', '2021-11-26 14:58:10');
INSERT INTO `grade` VALUES (7, '三年级1班', 5, '2021-11-26 14:58:07', '2021-11-26 14:58:10');

-- ----------------------------
-- Table structure for log_info
-- ----------------------------
DROP TABLE IF EXISTS `log_info`;
CREATE TABLE `log_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'url',
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ip',
  `query` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '查询参数',
  `response_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口返回状态码',
  `spend_time` bigint(255) NULL DEFAULT NULL COMMENT '消耗时间',
  `body` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求体',
  `exception` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '异常信息',
  `log_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日志类型',
  `operate_time` datetime(0) NULL DEFAULT NULL COMMENT '请求时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 367 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log_info
-- ----------------------------
INSERT INTO `log_info` VALUES (1, '/user/getUser-by-id', '0:0:0:0:0:0:0:1', 'userId=2', '200', 0, NULL, NULL, '查询日志', '2022-01-25 17:09:15');
INSERT INTO `log_info` VALUES (2, '/user/getUser-by-id', '0:0:0:0:0:0:0:1', 'userId=2', '200', 0, NULL, NULL, '查询日志', '2022-01-25 17:14:58');
INSERT INTO `log_info` VALUES (3, '/user/getUser-by-id', '0:0:0:0:0:0:0:1', 'userId=3', '200', 0, NULL, NULL, '查询日志', '2022-01-25 17:36:19');
INSERT INTO `log_info` VALUES (4, '/user/get-users-by-sex', '0:0:0:0:0:0:0:1', 'sex=%E7%94%B7', '200', 0, NULL, NULL, NULL, '2022-01-26 11:52:44');
INSERT INTO `log_info` VALUES (69, '/user/import', '0:0:0:0:0:0:0:1', 'file', '200', 1, NULL, NULL, NULL, '2022-02-21 10:59:15');
INSERT INTO `log_info` VALUES (70, '/user/import-for-sheets', '0:0:0:0:0:0:0:1', 'file', '200', 1, NULL, NULL, NULL, '2022-02-21 11:12:30');
INSERT INTO `log_info` VALUES (73, '/user/export-for-sheets', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-02-21 16:06:30');
INSERT INTO `log_info` VALUES (74, '/user/export-for-sheets', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-02-21 16:06:56');
INSERT INTO `log_info` VALUES (75, '/user/export-for-sheets', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-02-21 16:16:00');
INSERT INTO `log_info` VALUES (76, '/user/export-for-sheets', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-02-21 16:16:38');
INSERT INTO `log_info` VALUES (77, '/user/export-for-sheets', '0:0:0:0:0:0:0:1', NULL, '200', 214, NULL, NULL, NULL, '2022-02-21 16:17:44');
INSERT INTO `log_info` VALUES (78, '/user/export-for-sheets', '0:0:0:0:0:0:0:1', NULL, '200', 5, NULL, NULL, NULL, '2022-02-21 16:29:41');
INSERT INTO `log_info` VALUES (79, '/user/export', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-02-21 16:30:17');
INSERT INTO `log_info` VALUES (80, '/user/export-for-sheets', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-02-21 16:31:12');
INSERT INTO `log_info` VALUES (81, '/user/export-for-sheets', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-02-21 16:37:20');
INSERT INTO `log_info` VALUES (82, '/user/export-for-sheets', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-02-21 17:27:31');
INSERT INTO `log_info` VALUES (83, '/user/export-for-pdf', '0:0:0:0:0:0:0:1', NULL, '200', 45, NULL, NULL, NULL, '2022-02-22 13:59:15');
INSERT INTO `log_info` VALUES (84, '/user/export-for-sheets', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-02-22 14:00:30');
INSERT INTO `log_info` VALUES (85, '/user/export-for-pdf', '0:0:0:0:0:0:0:1', NULL, '200', 44, NULL, NULL, NULL, '2022-02-22 14:01:03');
INSERT INTO `log_info` VALUES (86, '/user/export-for-pdf', '0:0:0:0:0:0:0:1', NULL, '200', 51, NULL, NULL, NULL, '2022-02-22 14:03:17');
INSERT INTO `log_info` VALUES (87, '/user/export-for-pdf', '0:0:0:0:0:0:0:1', NULL, '200', 53, NULL, NULL, NULL, '2022-02-22 14:03:17');
INSERT INTO `log_info` VALUES (88, '/user/export-for-pdf', '0:0:0:0:0:0:0:1', NULL, '200', 29, NULL, NULL, NULL, '2022-02-22 14:04:16');
INSERT INTO `log_info` VALUES (89, '/user/export-for-pdf', '0:0:0:0:0:0:0:1', NULL, '200', 1, NULL, NULL, NULL, '2022-02-22 14:18:59');
INSERT INTO `log_info` VALUES (90, '/user/export-for-pdf', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-02-22 14:21:52');
INSERT INTO `log_info` VALUES (91, '/user/export-for-pdf', '0:0:0:0:0:0:0:1', NULL, '200', 2, NULL, NULL, NULL, '2022-02-22 14:23:08');
INSERT INTO `log_info` VALUES (92, '/user/export-for-pdf', '0:0:0:0:0:0:0:1', NULL, '200', 1, NULL, NULL, NULL, '2022-02-22 14:49:13');
INSERT INTO `log_info` VALUES (93, '/user/export-for-pdf', '0:0:0:0:0:0:0:1', NULL, '200', 1, NULL, NULL, NULL, '2022-02-22 15:20:07');
INSERT INTO `log_info` VALUES (94, '/user/export-for-pdf', '0:0:0:0:0:0:0:1', NULL, '200', 31, NULL, NULL, NULL, '2022-02-22 15:41:52');
INSERT INTO `log_info` VALUES (95, '/user/export-for-pdf', '0:0:0:0:0:0:0:1', NULL, '200', 1, NULL, NULL, NULL, '2022-02-22 15:43:15');
INSERT INTO `log_info` VALUES (96, '/user/export-for-pdf', '0:0:0:0:0:0:0:1', NULL, '200', 1, NULL, NULL, NULL, '2022-02-22 15:45:28');
INSERT INTO `log_info` VALUES (97, '/user/export-word-all', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-02-22 15:47:48');
INSERT INTO `log_info` VALUES (98, '/user/export-for-pdf', '0:0:0:0:0:0:0:1', NULL, '200', 1, NULL, NULL, NULL, '2022-02-22 15:55:49');
INSERT INTO `log_info` VALUES (99, '/user/export-word-all', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-02-22 15:56:44');
INSERT INTO `log_info` VALUES (100, '/user/export-for-pdf', '0:0:0:0:0:0:0:1', NULL, '200', 2, NULL, NULL, NULL, '2022-02-22 16:01:48');
INSERT INTO `log_info` VALUES (101, '/user/export-word-all', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-02-22 16:12:13');
INSERT INTO `log_info` VALUES (102, '/user/export-for-pdf', '0:0:0:0:0:0:0:1', NULL, '200', 1, NULL, NULL, NULL, '2022-02-22 16:14:42');
INSERT INTO `log_info` VALUES (103, '/user/export', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-02-22 16:17:25');
INSERT INTO `log_info` VALUES (104, '/user/export-for-pdf', '0:0:0:0:0:0:0:1', NULL, '200', 1, NULL, NULL, NULL, '2022-02-22 16:19:02');
INSERT INTO `log_info` VALUES (105, '/user/export-for-pdf', '0:0:0:0:0:0:0:1', NULL, '200', 1, NULL, NULL, NULL, '2022-02-22 16:21:53');
INSERT INTO `log_info` VALUES (106, '/user/export-for-pdf', '0:0:0:0:0:0:0:1', NULL, '200', 1, NULL, NULL, NULL, '2022-02-22 16:23:59');
INSERT INTO `log_info` VALUES (107, '/user/export-for-pdf', '0:0:0:0:0:0:0:1', NULL, '200', 4, NULL, NULL, NULL, '2022-02-22 16:28:40');
INSERT INTO `log_info` VALUES (108, '/user/export-for-pdf', '0:0:0:0:0:0:0:1', NULL, '200', 4, NULL, NULL, NULL, '2022-02-22 16:34:58');
INSERT INTO `log_info` VALUES (109, '/user/export-for-pdf', '0:0:0:0:0:0:0:1', NULL, '200', 5, NULL, NULL, NULL, '2022-02-22 16:37:32');
INSERT INTO `log_info` VALUES (110, '/user/export-for-pdf', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-02-22 16:38:26');
INSERT INTO `log_info` VALUES (111, '/user/getUser-by-ids', '0:0:0:0:0:0:0:1', NULL, '200', 3, NULL, NULL, NULL, '2022-02-24 16:29:28');
INSERT INTO `log_info` VALUES (112, '/user/update-user-by-id', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-02-24 16:40:10');
INSERT INTO `log_info` VALUES (113, '/user/get-user-list', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-03-01 14:13:42');
INSERT INTO `log_info` VALUES (114, '/user/getUser-by-id', '0:0:0:0:0:0:0:1', 'userId=3', '200', 0, NULL, NULL, '查询日志', '2022-03-01 14:14:26');
INSERT INTO `log_info` VALUES (115, '/user/getUser-by-id', '0:0:0:0:0:0:0:1', 'userId=3', '200', 0, NULL, NULL, '查询日志', '2022-03-01 14:15:16');
INSERT INTO `log_info` VALUES (116, '/user/getUser-by-id', '0:0:0:0:0:0:0:1', 'userId=3', '200', 0, NULL, NULL, '查询日志', '2022-03-01 14:15:29');
INSERT INTO `log_info` VALUES (117, '/user/getUser-by-id', '0:0:0:0:0:0:0:1', 'userId=3', '200', 0, NULL, NULL, '查询日志', '2022-03-01 14:16:07');
INSERT INTO `log_info` VALUES (118, '/user/export-for-pdf', '0:0:0:0:0:0:0:1', NULL, '200', 11, NULL, NULL, NULL, '2022-03-01 15:34:40');
INSERT INTO `log_info` VALUES (119, '/user/export-for-pdf', '0:0:0:0:0:0:0:1', NULL, '200', 4, NULL, NULL, NULL, '2022-03-01 15:35:50');
INSERT INTO `log_info` VALUES (120, '/user/export-for-pdf', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-03-01 15:36:26');
INSERT INTO `log_info` VALUES (121, '/user/preview1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-03-01 15:38:33');
INSERT INTO `log_info` VALUES (122, '/user/preview', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-03-01 15:42:33');
INSERT INTO `log_info` VALUES (123, '/user/preview', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-03-01 15:42:49');
INSERT INTO `log_info` VALUES (124, '/user/preview', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-03-01 15:44:15');
INSERT INTO `log_info` VALUES (125, '/user/export-for-pdf', '0:0:0:0:0:0:0:1', NULL, '200', 7, NULL, NULL, NULL, '2022-03-01 15:47:21');
INSERT INTO `log_info` VALUES (126, '/user/preview', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-03-02 09:37:27');
INSERT INTO `log_info` VALUES (127, '/user/preview', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-03-02 09:39:07');
INSERT INTO `log_info` VALUES (128, '/db/get-db-columns', '0:0:0:0:0:0:0:1', NULL, '200', 5, NULL, NULL, NULL, '2022-08-30 16:57:57');
INSERT INTO `log_info` VALUES (129, '/db/get-db-columns', '0:0:0:0:0:0:0:1', NULL, '200', 3, NULL, NULL, NULL, '2022-08-30 16:58:47');
INSERT INTO `log_info` VALUES (130, '/db/get-db-columns', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-08-30 16:59:07');
INSERT INTO `log_info` VALUES (131, '/db/find-db-info', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-08-30 16:59:15');
INSERT INTO `log_info` VALUES (132, '/db/find-db-info', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-08-30 16:59:27');
INSERT INTO `log_info` VALUES (133, '/db/get-db-columns', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-08-30 17:00:16');
INSERT INTO `log_info` VALUES (134, '/db/find-db-info', '0:0:0:0:0:0:0:1', NULL, '200', 20, NULL, NULL, NULL, '2022-08-30 17:09:18');
INSERT INTO `log_info` VALUES (135, '/db/find-db-info-by-page', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-08-30 17:12:36');
INSERT INTO `log_info` VALUES (136, '/db/find-db-info-by-page', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-08-30 17:16:13');
INSERT INTO `log_info` VALUES (137, '/db/find-db-info', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-08-30 17:24:01');
INSERT INTO `log_info` VALUES (138, '/db/find-db-info-by-page', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-08-30 17:28:12');
INSERT INTO `log_info` VALUES (139, '/db/find-db-info', '0:0:0:0:0:0:0:1', NULL, '200', 57, NULL, NULL, NULL, '2022-08-30 17:28:16');
INSERT INTO `log_info` VALUES (140, '/db/find-db-info-by-page', '0:0:0:0:0:0:0:1', NULL, '200', 71, NULL, NULL, NULL, '2022-08-30 17:29:29');
INSERT INTO `log_info` VALUES (141, '/db/find-db-info', '0:0:0:0:0:0:0:1', NULL, '200', 438, NULL, NULL, NULL, '2022-08-31 09:59:30');
INSERT INTO `log_info` VALUES (142, '/db/get-db-columns', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-08-31 10:15:44');
INSERT INTO `log_info` VALUES (143, '/db/find-db-info', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-08-31 11:07:18');
INSERT INTO `log_info` VALUES (144, '/file/export-csv', '0:0:0:0:0:0:0:1', NULL, '200', 66, NULL, NULL, NULL, '2022-09-23 14:22:21');
INSERT INTO `log_info` VALUES (145, '/user/export', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-03 09:41:27');
INSERT INTO `log_info` VALUES (146, '/user/export', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-03 09:41:29');
INSERT INTO `log_info` VALUES (147, '/user/export', '0:0:0:0:0:0:0:1', NULL, '200', 29, NULL, NULL, NULL, '2022-11-03 09:43:54');
INSERT INTO `log_info` VALUES (148, '/user/export', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-03 10:01:51');
INSERT INTO `log_info` VALUES (149, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-17 11:35:05');
INSERT INTO `log_info` VALUES (150, '/test/demo2', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-17 11:35:08');
INSERT INTO `log_info` VALUES (151, '/test/demo2', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-17 11:37:40');
INSERT INTO `log_info` VALUES (152, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-17 11:37:52');
INSERT INTO `log_info` VALUES (153, '/test/demo2', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-17 11:39:44');
INSERT INTO `log_info` VALUES (154, '/test/demo2', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-17 11:41:22');
INSERT INTO `log_info` VALUES (155, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-17 11:49:53');
INSERT INTO `log_info` VALUES (156, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-17 11:50:57');
INSERT INTO `log_info` VALUES (157, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-17 11:54:48');
INSERT INTO `log_info` VALUES (158, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-17 12:42:27');
INSERT INTO `log_info` VALUES (159, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-17 12:44:29');
INSERT INTO `log_info` VALUES (160, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-17 12:46:33');
INSERT INTO `log_info` VALUES (161, '/test/demo2', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-17 12:46:51');
INSERT INTO `log_info` VALUES (162, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-17 14:37:15');
INSERT INTO `log_info` VALUES (163, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-17 14:41:57');
INSERT INTO `log_info` VALUES (164, '/test/demo2', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-17 14:42:42');
INSERT INTO `log_info` VALUES (165, '/test/demo2', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-17 15:13:23');
INSERT INTO `log_info` VALUES (166, '/test/demo2', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-17 15:13:32');
INSERT INTO `log_info` VALUES (167, '/test/demo', '0:0:0:0:0:0:0:1', 'a=1&b=0', '200', 0, NULL, NULL, NULL, '2022-11-17 15:27:21');
INSERT INTO `log_info` VALUES (168, '/test/demo', '0:0:0:0:0:0:0:1', 'a=0&b=1', '200', 0, NULL, NULL, NULL, '2022-11-17 15:28:12');
INSERT INTO `log_info` VALUES (169, '/test/demo', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-17 15:28:55');
INSERT INTO `log_info` VALUES (170, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-17 17:01:12');
INSERT INTO `log_info` VALUES (171, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-17 17:01:22');
INSERT INTO `log_info` VALUES (172, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 09:57:24');
INSERT INTO `log_info` VALUES (173, '/test/demo', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 09:57:52');
INSERT INTO `log_info` VALUES (174, '/test/demo', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 09:58:10');
INSERT INTO `log_info` VALUES (175, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 14:50:56');
INSERT INTO `log_info` VALUES (176, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 14:51:01');
INSERT INTO `log_info` VALUES (177, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:23');
INSERT INTO `log_info` VALUES (178, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:23');
INSERT INTO `log_info` VALUES (179, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:24');
INSERT INTO `log_info` VALUES (180, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:24');
INSERT INTO `log_info` VALUES (181, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:24');
INSERT INTO `log_info` VALUES (182, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:24');
INSERT INTO `log_info` VALUES (183, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:24');
INSERT INTO `log_info` VALUES (184, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:24');
INSERT INTO `log_info` VALUES (185, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:26');
INSERT INTO `log_info` VALUES (186, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:26');
INSERT INTO `log_info` VALUES (187, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:27');
INSERT INTO `log_info` VALUES (188, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:27');
INSERT INTO `log_info` VALUES (189, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:27');
INSERT INTO `log_info` VALUES (190, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:34');
INSERT INTO `log_info` VALUES (191, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:34');
INSERT INTO `log_info` VALUES (192, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:34');
INSERT INTO `log_info` VALUES (193, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:34');
INSERT INTO `log_info` VALUES (194, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:34');
INSERT INTO `log_info` VALUES (195, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:34');
INSERT INTO `log_info` VALUES (196, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:35');
INSERT INTO `log_info` VALUES (197, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:37');
INSERT INTO `log_info` VALUES (198, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:37');
INSERT INTO `log_info` VALUES (199, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:37');
INSERT INTO `log_info` VALUES (200, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:37');
INSERT INTO `log_info` VALUES (201, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:37');
INSERT INTO `log_info` VALUES (202, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:37');
INSERT INTO `log_info` VALUES (203, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:38');
INSERT INTO `log_info` VALUES (204, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:38');
INSERT INTO `log_info` VALUES (205, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:38');
INSERT INTO `log_info` VALUES (206, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:38');
INSERT INTO `log_info` VALUES (207, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:38');
INSERT INTO `log_info` VALUES (208, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:39');
INSERT INTO `log_info` VALUES (209, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:51');
INSERT INTO `log_info` VALUES (210, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:51');
INSERT INTO `log_info` VALUES (211, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:51');
INSERT INTO `log_info` VALUES (212, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:51');
INSERT INTO `log_info` VALUES (213, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:52');
INSERT INTO `log_info` VALUES (214, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:52');
INSERT INTO `log_info` VALUES (215, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:52');
INSERT INTO `log_info` VALUES (216, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:52');
INSERT INTO `log_info` VALUES (217, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:52');
INSERT INTO `log_info` VALUES (218, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:52');
INSERT INTO `log_info` VALUES (219, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:53');
INSERT INTO `log_info` VALUES (220, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:53');
INSERT INTO `log_info` VALUES (221, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:53');
INSERT INTO `log_info` VALUES (222, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:53');
INSERT INTO `log_info` VALUES (223, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:53');
INSERT INTO `log_info` VALUES (224, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:53');
INSERT INTO `log_info` VALUES (225, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:54');
INSERT INTO `log_info` VALUES (226, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:54');
INSERT INTO `log_info` VALUES (227, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:54');
INSERT INTO `log_info` VALUES (228, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:54');
INSERT INTO `log_info` VALUES (229, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:54');
INSERT INTO `log_info` VALUES (230, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:27:54');
INSERT INTO `log_info` VALUES (231, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:35:50');
INSERT INTO `log_info` VALUES (232, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:35:51');
INSERT INTO `log_info` VALUES (233, '/test/demo1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-18 15:35:51');
INSERT INTO `log_info` VALUES (234, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:35:53');
INSERT INTO `log_info` VALUES (235, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:35:53');
INSERT INTO `log_info` VALUES (236, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:35:53');
INSERT INTO `log_info` VALUES (237, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:35:53');
INSERT INTO `log_info` VALUES (238, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:35:53');
INSERT INTO `log_info` VALUES (239, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:35:54');
INSERT INTO `log_info` VALUES (240, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:35:54');
INSERT INTO `log_info` VALUES (241, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:35:54');
INSERT INTO `log_info` VALUES (242, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:35:54');
INSERT INTO `log_info` VALUES (243, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:35:54');
INSERT INTO `log_info` VALUES (244, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:35:54');
INSERT INTO `log_info` VALUES (245, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:35:55');
INSERT INTO `log_info` VALUES (246, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:35:55');
INSERT INTO `log_info` VALUES (247, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:35:55');
INSERT INTO `log_info` VALUES (248, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:35:55');
INSERT INTO `log_info` VALUES (249, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:35:55');
INSERT INTO `log_info` VALUES (250, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:35:56');
INSERT INTO `log_info` VALUES (251, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:35:56');
INSERT INTO `log_info` VALUES (252, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:35:56');
INSERT INTO `log_info` VALUES (253, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:35:56');
INSERT INTO `log_info` VALUES (254, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:35:56');
INSERT INTO `log_info` VALUES (255, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:35:56');
INSERT INTO `log_info` VALUES (256, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:35:57');
INSERT INTO `log_info` VALUES (257, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:56:27');
INSERT INTO `log_info` VALUES (258, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:56:28');
INSERT INTO `log_info` VALUES (259, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:56:28');
INSERT INTO `log_info` VALUES (260, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:56:28');
INSERT INTO `log_info` VALUES (261, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:56:29');
INSERT INTO `log_info` VALUES (262, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:56:29');
INSERT INTO `log_info` VALUES (263, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:56:29');
INSERT INTO `log_info` VALUES (264, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:56:29');
INSERT INTO `log_info` VALUES (265, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:56:29');
INSERT INTO `log_info` VALUES (266, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:56:30');
INSERT INTO `log_info` VALUES (267, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:56:30');
INSERT INTO `log_info` VALUES (268, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:56:30');
INSERT INTO `log_info` VALUES (269, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:56:31');
INSERT INTO `log_info` VALUES (270, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:56:31');
INSERT INTO `log_info` VALUES (271, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:56:31');
INSERT INTO `log_info` VALUES (272, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:56:31');
INSERT INTO `log_info` VALUES (273, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:56:32');
INSERT INTO `log_info` VALUES (274, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:56:32');
INSERT INTO `log_info` VALUES (275, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:56:32');
INSERT INTO `log_info` VALUES (276, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:56:32');
INSERT INTO `log_info` VALUES (277, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 15:56:33');
INSERT INTO `log_info` VALUES (278, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 16:01:40');
INSERT INTO `log_info` VALUES (279, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 16:01:40');
INSERT INTO `log_info` VALUES (280, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 16:01:40');
INSERT INTO `log_info` VALUES (281, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 16:01:40');
INSERT INTO `log_info` VALUES (282, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 16:01:41');
INSERT INTO `log_info` VALUES (283, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 16:01:41');
INSERT INTO `log_info` VALUES (284, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 16:01:41');
INSERT INTO `log_info` VALUES (285, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 16:01:41');
INSERT INTO `log_info` VALUES (286, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 16:01:42');
INSERT INTO `log_info` VALUES (287, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 16:01:42');
INSERT INTO `log_info` VALUES (288, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 16:01:42');
INSERT INTO `log_info` VALUES (289, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 16:01:42');
INSERT INTO `log_info` VALUES (290, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 16:01:42');
INSERT INTO `log_info` VALUES (291, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 16:01:43');
INSERT INTO `log_info` VALUES (292, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 16:01:43');
INSERT INTO `log_info` VALUES (293, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 16:01:43');
INSERT INTO `log_info` VALUES (294, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 16:01:43');
INSERT INTO `log_info` VALUES (295, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 16:01:43');
INSERT INTO `log_info` VALUES (296, '/test/demo2', '0:0:0:0:0:0:0:1', 'a=1&b=1', '200', 0, NULL, NULL, NULL, '2022-11-18 16:01:44');
INSERT INTO `log_info` VALUES (297, '/log/get-logs', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-21 09:43:55');
INSERT INTO `log_info` VALUES (298, '/log/get-logs', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-21 09:50:04');
INSERT INTO `log_info` VALUES (299, '/log/get-logs', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-21 09:51:08');
INSERT INTO `log_info` VALUES (300, '/user/get-user-list', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-21 10:06:20');
INSERT INTO `log_info` VALUES (301, '/user/get-users1', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-21 10:06:26');
INSERT INTO `log_info` VALUES (302, '/log/get-logs', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-11-21 10:07:51');
INSERT INTO `log_info` VALUES (303, '/user/get-user-for-id', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-12-07 16:41:52');
INSERT INTO `log_info` VALUES (304, '/user/get-user-for-id', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-12-07 16:42:07');
INSERT INTO `log_info` VALUES (305, '/user/get-user-for-id', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-12-07 16:51:20');
INSERT INTO `log_info` VALUES (306, '/user/get-user-for-id', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-12-07 16:51:23');
INSERT INTO `log_info` VALUES (307, '/user/get-user-for-id', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-12-07 16:53:39');
INSERT INTO `log_info` VALUES (308, '/user/get-user-for-id', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-12-07 16:53:41');
INSERT INTO `log_info` VALUES (309, '/user/get-user-for-id', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-12-07 16:56:37');
INSERT INTO `log_info` VALUES (310, '/user/get-user-for-id', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-12-07 16:56:42');
INSERT INTO `log_info` VALUES (311, '/user/get-user-for-id', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-12-07 16:56:45');
INSERT INTO `log_info` VALUES (312, '/user/get-user-for-id', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-12-07 16:56:48');
INSERT INTO `log_info` VALUES (313, '/user/get-user-for-id', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-12-07 16:57:54');
INSERT INTO `log_info` VALUES (314, '/user/get-user-for-id', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-12-07 16:57:58');
INSERT INTO `log_info` VALUES (315, '/user/get-user-for-id', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-12-07 16:58:00');
INSERT INTO `log_info` VALUES (316, '/user/get-user-for-id', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-12-07 16:58:03');
INSERT INTO `log_info` VALUES (317, '/user/get-user-for-id', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-12-07 17:00:42');
INSERT INTO `log_info` VALUES (318, '/user/get-user-for-id', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-12-07 17:01:02');
INSERT INTO `log_info` VALUES (319, '/user/get-user-for-id', '0:0:0:0:0:0:0:1', NULL, '200', 0, NULL, NULL, NULL, '2022-12-07 17:01:24');
INSERT INTO `log_info` VALUES (320, '/user/get-user-for-id', '127.0.0.1', 'id=1', '200', 0, NULL, NULL, NULL, '2022-12-07 17:40:56');
INSERT INTO `log_info` VALUES (321, '/user/get-user-for-id', '127.0.0.1', 'id=3', '200', 0, NULL, NULL, NULL, '2022-12-07 17:41:16');
INSERT INTO `log_info` VALUES (322, '/cache/save-user', '127.0.0.1', NULL, '200', 0, NULL, NULL, NULL, '2022-12-15 15:12:45');
INSERT INTO `log_info` VALUES (323, '/cache/save-user', '127.0.0.1', NULL, '200', 0, NULL, NULL, NULL, '2022-12-15 15:23:50');
INSERT INTO `log_info` VALUES (324, '/cache/get-user-by-id', '127.0.0.1', 'id=51', '200', 0, NULL, NULL, NULL, '2022-12-15 15:27:49');
INSERT INTO `log_info` VALUES (325, '/cache/get-user-by-id', '127.0.0.1', 'id=51', '200', 0, NULL, NULL, NULL, '2022-12-15 15:28:30');
INSERT INTO `log_info` VALUES (326, '/cache/get-user-by-id', '127.0.0.1', 'id=51', '200', 0, NULL, NULL, NULL, '2022-12-15 15:28:32');
INSERT INTO `log_info` VALUES (327, '/cache/get-user-by-id', '127.0.0.1', 'id=51', '200', 0, NULL, NULL, NULL, '2022-12-15 15:28:33');
INSERT INTO `log_info` VALUES (328, '/cache/get-user-by-id', '127.0.0.1', 'id=51', '200', 0, NULL, NULL, NULL, '2022-12-15 15:28:33');
INSERT INTO `log_info` VALUES (329, '/cache/get-user-by-id', '127.0.0.1', 'id=51', '200', 0, NULL, NULL, NULL, '2022-12-15 15:28:33');
INSERT INTO `log_info` VALUES (330, '/cache/save-user', '127.0.0.1', NULL, '200', 0, NULL, NULL, NULL, '2022-12-15 15:31:55');
INSERT INTO `log_info` VALUES (331, '/cache/save-user', '127.0.0.1', NULL, '200', 0, NULL, NULL, NULL, '2022-12-15 15:35:25');
INSERT INTO `log_info` VALUES (332, '/cache/get-user-by-id', '127.0.0.1', 'id=52', '200', 0, NULL, NULL, NULL, '2022-12-15 15:38:03');
INSERT INTO `log_info` VALUES (333, '/cache/save-user', '127.0.0.1', NULL, '200', 0, NULL, NULL, NULL, '2022-12-15 15:39:06');
INSERT INTO `log_info` VALUES (334, '/cache/save-user', '127.0.0.1', NULL, '200', 0, NULL, NULL, NULL, '2022-12-15 15:43:58');
INSERT INTO `log_info` VALUES (335, '/cache/get-user-by-id', '127.0.0.1', 'id=55', '200', 0, NULL, NULL, NULL, '2022-12-15 15:47:05');
INSERT INTO `log_info` VALUES (336, '/cache/save-user', '127.0.0.1', NULL, '200', 0, NULL, NULL, NULL, '2022-12-15 15:47:10');
INSERT INTO `log_info` VALUES (337, '/cache/get-user-by-id', '127.0.0.1', 'id=56', '200', 0, NULL, NULL, NULL, '2022-12-15 15:47:16');
INSERT INTO `log_info` VALUES (338, '/cache/get-user-by-id', '127.0.0.1', 'id=55', '200', 0, NULL, NULL, NULL, '2022-12-15 15:47:54');
INSERT INTO `log_info` VALUES (339, '/cache/get-user-by-id', '127.0.0.1', 'id=56', '200', 0, NULL, NULL, NULL, '2022-12-15 15:47:56');
INSERT INTO `log_info` VALUES (340, '/cache/get-user-by-id', '127.0.0.1', 'id=56', '200', 0, NULL, NULL, NULL, '2022-12-15 15:48:12');
INSERT INTO `log_info` VALUES (341, '/cache/get-user-by-id', '127.0.0.1', 'id=56', '200', 0, NULL, NULL, NULL, '2022-12-15 15:48:13');
INSERT INTO `log_info` VALUES (342, '/cache/get-user-by-id', '127.0.0.1', 'id=56', '200', 0, NULL, NULL, NULL, '2022-12-15 15:48:14');
INSERT INTO `log_info` VALUES (343, '/cache/get-user-by-id', '127.0.0.1', 'id=56', '200', 0, NULL, NULL, NULL, '2022-12-15 15:48:14');
INSERT INTO `log_info` VALUES (344, '/cache/get-user-by-id', '127.0.0.1', 'id=56', '200', 0, NULL, NULL, NULL, '2022-12-15 15:48:14');
INSERT INTO `log_info` VALUES (345, '/cache/get-user-by-id', '127.0.0.1', 'id=56', '200', 0, NULL, NULL, NULL, '2022-12-15 15:48:14');
INSERT INTO `log_info` VALUES (346, '/cache/get-user-by-id', '127.0.0.1', 'id=56', '200', 0, NULL, NULL, NULL, '2022-12-15 15:48:21');
INSERT INTO `log_info` VALUES (347, '/cache/save-user', '127.0.0.1', NULL, '200', 0, NULL, NULL, NULL, '2022-12-15 15:49:39');
INSERT INTO `log_info` VALUES (348, '/cache/get-user-by-id', '127.0.0.1', 'id=57', '200', 0, NULL, NULL, NULL, '2022-12-15 15:49:49');
INSERT INTO `log_info` VALUES (349, '/cache/get-user-by-id', '127.0.0.1', 'id=57', '200', 0, NULL, NULL, NULL, '2022-12-15 15:50:33');
INSERT INTO `log_info` VALUES (350, '/cache/get-user-by-id', '127.0.0.1', 'id=57', '200', 0, NULL, NULL, NULL, '2022-12-15 15:50:50');
INSERT INTO `log_info` VALUES (351, '/cache/get-user-by-id', '127.0.0.1', 'id=57', '200', 0, NULL, NULL, NULL, '2022-12-15 15:59:48');
INSERT INTO `log_info` VALUES (352, '/cache/get-user-by-id', '127.0.0.1', 'id=57', '200', 0, NULL, NULL, NULL, '2022-12-15 16:00:01');
INSERT INTO `log_info` VALUES (353, '/cache/delete-user-by-id', '127.0.0.1', 'id=57', '200', 0, NULL, NULL, NULL, '2022-12-15 16:00:06');
INSERT INTO `log_info` VALUES (354, '/cache/get-user-by-id', '127.0.0.1', 'id=57', '200', 0, NULL, NULL, NULL, '2022-12-15 16:00:12');
INSERT INTO `log_info` VALUES (355, '/cache/get-user-by-id', '127.0.0.1', 'id=57', '200', 0, NULL, NULL, NULL, '2022-12-15 16:03:32');
INSERT INTO `log_info` VALUES (356, '/cache/delete-user-by-id', '127.0.0.1', 'id=57', '200', 0, NULL, NULL, NULL, '2022-12-15 16:03:46');
INSERT INTO `log_info` VALUES (357, '/cache/get-user-by-id', '127.0.0.1', 'id=57', '200', 0, NULL, NULL, NULL, '2022-12-15 16:03:52');
INSERT INTO `log_info` VALUES (358, '/cache/get-user-by-id', '127.0.0.1', 'id=57', '200', 0, NULL, NULL, NULL, '2022-12-15 16:03:56');
INSERT INTO `log_info` VALUES (359, '/cache/save-user', '127.0.0.1', NULL, '200', 0, NULL, NULL, NULL, '2022-12-15 16:26:18');
INSERT INTO `log_info` VALUES (360, '/cache/get-user-by-id', '127.0.0.1', 'id=59', '200', 0, NULL, NULL, NULL, '2022-12-15 16:27:07');
INSERT INTO `log_info` VALUES (361, '/cache/delete-user-by-id', '127.0.0.1', 'id=59', '200', 0, NULL, NULL, NULL, '2022-12-15 16:29:30');
INSERT INTO `log_info` VALUES (362, '/cache/get-user-by-id', '127.0.0.1', 'id=59', '200', 0, NULL, NULL, NULL, '2022-12-15 16:30:48');
INSERT INTO `log_info` VALUES (363, '/websocket/page', '127.0.0.1', NULL, '200', 0, NULL, NULL, NULL, '2023-01-04 15:09:15');
INSERT INTO `log_info` VALUES (364, '/websocket/page', '127.0.0.1', NULL, '200', 0, NULL, NULL, NULL, '2023-01-04 15:10:48');
INSERT INTO `log_info` VALUES (365, '/websocket/push/1', '127.0.0.1', 'message=22', '200', 0, NULL, NULL, NULL, '2023-01-04 16:27:32');
INSERT INTO `log_info` VALUES (366, '/websocket/push/1', '127.0.0.1', 'message=2', '200', 0, NULL, NULL, NULL, '2023-01-04 16:28:17');

-- ----------------------------
-- Table structure for people
-- ----------------------------
DROP TABLE IF EXISTS `people`;
CREATE TABLE `people`  (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(2) NULL DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of people
-- ----------------------------
INSERT INTO `people` VALUES (1, 'A', '', '', 60);
INSERT INTO `people` VALUES (2, 'B', '', '', 70);
INSERT INTO `people` VALUES (3, 'C', '', '', 50);
INSERT INTO `people` VALUES (4, 'D', '', '', 30);

-- ----------------------------
-- Table structure for scdc_drug_fast_data
-- ----------------------------
DROP TABLE IF EXISTS `scdc_drug_fast_data`;
CREATE TABLE `scdc_drug_fast_data`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `drug_fast_identifier` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编号',
  `agentia` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '抗生素/药物名称',
  `agentia_en` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '英文简称',
  `bacterial_strain_identifier` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菌株编号',
  `agentia_consistence` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '导入值/录入值',
  `drug_fast` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药敏/耐药',
  `drug_fast_calculate` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '计算值',
  `status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `alter_time` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  `alter_account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菌株药敏数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of scdc_drug_fast_data
-- ----------------------------
INSERT INTO `scdc_drug_fast_data` VALUES ('90caa997f1b941609df1a9bf3e34eb0b', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '>32', 'R', '0', '1', '2022-03-01 17:03:55', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('c3b61dab1bc24ddd8caa64f36015a63d', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '>64', 'R', '0', '1', '2022-03-01 17:03:55', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('d171564c11894f6bb862685803eda0cb', '', '多粘菌素E', 'CT', '013ecf416db546c38f73090843759dd0', '2', 'I', '3', '1', '2022-03-01 17:03:56', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('579321ffe709455e862210582f18ec27', '', '头孢唑林', 'CFZ', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-01 17:03:56', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('f1c349fb465b4d679afdb87367f1542b', '', '头孢噻肟', 'CTX', '013ecf416db546c38f73090843759dd0', '2', 'I', '4', '1', '2022-03-01 17:03:56', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('08db1eae4c544356a6340ba7eb7c9f07', '', '头孢西丁', 'CFX', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-01 17:03:57', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('85f655310d594e6bb3ba4391a0c19497', '', '头孢吡肟', 'CPM', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-01 17:03:57', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('6253525e8a1745beaef63e1b5f30149a', '', '头孢呋辛', 'CXM', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-01 17:03:58', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('b986f66bbcc84c40a57648746eaee327', '', '亚胺培南', 'IMP', '013ecf416db546c38f73090843759dd0', '2', 'I', '3', '1', '2022-03-01 17:03:58', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('5831aa96fefb4f5991c3c977b29d7b70', '', '头孢他啶', 'CAZ', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-01 17:03:58', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('0241c0f624944435b6e68a5a4df206ba', '', '厄他培南', 'ETP', '013ecf416db546c38f73090843759dd0', '2', 'R', '3', '1', '2022-03-01 17:03:59', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('8d433d6c006c44fe872cfea4d8fefeef', '', '庆大霉素', 'GEN', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-01 17:04:00', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('ca38cfb7055c4402b69b4401f40dc915', '', '四环素', 'TET', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-01 17:04:00', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('8209f335082b42d2b3dd45a1aa725186', '', '替加环素', 'TIG', '013ecf416db546c38f73090843759dd0', '2', 'R', '3', '1', '2022-03-01 17:04:00', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('09c60bb1c5d04b4181dbc6317fae9178', '', '左氧氟沙星', 'LEV', '013ecf416db546c38f73090843759dd0', '2', 'R', '2', '1', '2022-03-01 17:04:01', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('05a5743b22aa458f95acfb4309262fa3', '', '美罗培南', 'MEM', '013ecf416db546c38f73090843759dd0', '2', 'I', '2', '1', '2022-03-01 17:04:01', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('65aa5bcc016d4052a1e0ffee4992397a', '', '诺氟沙星', 'NOR', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-01 17:04:02', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('757435a3de524ac8ac845d51cebc8bfb', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '4', 'R', '4', '1', '2022-03-01 17:04:02', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('21c520cad36b491dba24a5651e04ef62', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '32', 'R', '2', '1', '2022-03-01 17:04:03', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('41c32bf7ba2749bcbbe72acb427190e8', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '2', 'R', '5', '1', '2022-03-01 17:04:04', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('73a47696f217462f90481c07e3e47eea', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '8', 'S', '4', '1', '2022-03-01 17:04:05', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('a722b9b026ca46c1bebbee2fa019f691', '', '环丙沙星', 'CIP', '123456789', '>32', 'R', '0', '1', '2022-03-02 09:58:07', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('ae64d7bd45224a22b87f5a00bd9dd9d3', '', '氨苄西林', 'AMP', '123456789', '>64', 'R', '0', '1', '2022-03-02 09:58:07', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('b5802f11197f4bdbb0b3099e1154390b', '', '多粘菌素E', 'CT', '123456789', '2', 'I', '3', '1', '2022-03-02 09:58:08', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('c51e1c9d217d4c01819bd6bfd533ac0a', '', '头孢唑林', 'CFZ', '123456789', '2', 'S', '5', '1', '2022-03-02 09:58:09', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('bd9d335bb049418a90044a8a94e8fe84', '', '头孢噻肟', 'CTX', '123456789', '2', 'I', '4', '1', '2022-03-02 09:58:09', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('968893dd978e41448ae088e647d1286e', '', '头孢西丁', 'CFX', '123456789', '2', 'S', '6', '1', '2022-03-02 09:58:10', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('feae49cdb905462aafc8a98e1dac6aaf', '', '头孢吡肟', 'CPM', '123456789', '2', 'S', '6', '1', '2022-03-02 09:58:10', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('bd0f1906a62c45f287a656860c9cbc24', '', '头孢呋辛', 'CXM', '123456789', '2', 'S', '5', '1', '2022-03-02 09:58:10', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('32e217be058048f99cc6105583295056', '', '亚胺培南', 'IMP', '123456789', '2', 'I', '3', '1', '2022-03-02 09:58:11', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('c75059ad87244118bd5d5aff70d66f80', '', '头孢他啶', 'CAZ', '123456789', '2', 'S', '5', '1', '2022-03-02 09:58:11', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('0352fe1388a949ad80c832175860513f', '', '厄他培南', 'ETP', '123456789', '2', 'R', '3', '1', '2022-03-02 09:58:12', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('d771fc240f8d462f9cb7015e65c8f488', '', '庆大霉素', 'GEN', '123456789', '2', 'S', '5', '1', '2022-03-02 09:58:13', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('cf405506705f46fa95ced75da6a76e2d', '', '四环素', 'TET', '123456789', '2', 'S', '5', '1', '2022-03-02 09:58:13', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('3cd4a79e42624e44a9ecf04284c0d686', '', '替加环素', 'TIG', '123456789', '2', 'R', '3', '1', '2022-03-02 09:58:14', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('02c5efe68ce24586911a54cb4f52fe85', '', '左氧氟沙星', 'LEV', '123456789', '2', 'R', '2', '1', '2022-03-02 09:58:14', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('421d83968d7d41d281fa0f9a2771d48d', '', '美罗培南', 'MEM', '123456789', '2', 'I', '2', '1', '2022-03-02 09:58:14', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('34ac5165d5ea4689984ad2d4b9422bec', '', '诺氟沙星', 'NOR', '123456789', '2', 'S', '6', '1', '2022-03-02 09:58:15', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('ae9ce0b04f2042ae947380f2560b7334', '', '环丙沙星', 'CIP', '123456789', '4', 'R', '4', '1', '2022-03-02 09:58:15', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('31c3035751c840a39fe04b2b7272cca5', '', '氨苄西林', 'AMP', '123456789', '32', 'R', '2', '1', '2022-03-02 09:58:16', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('c1d436ce9c9c48cbac6a89c566562e49', '', '环丙沙星', 'CIP', '123456789', '2', 'R', '5', '1', '2022-03-02 09:58:16', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('d7d8d140e96e4a3eae9f8f449dd4de7c', '', '氨苄西林', 'AMP', '123456789', '8', 'S', '4', '1', '2022-03-02 09:58:17', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('3ca5f8ac2967493eb75bc88e7aa7d470', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '>32', 'R', '0', '1', '2022-03-02 11:52:40', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('ed9deecfc216489892272385e86b593e', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '>64', 'R', '0', '1', '2022-03-02 11:52:40', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('79977688113b4a07bb3fb37e37cdbc47', '', '多粘菌素E', 'CT', '013ecf416db546c38f73090843759dd0', '2', 'I', '3', '1', '2022-03-02 11:52:40', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('2e9879dc5588461db798d30404706cdb', '', '头孢唑林', 'CFZ', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 11:52:41', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('57a65d018ae84c349da62d3be54b3a27', '', '头孢噻肟', 'CTX', '013ecf416db546c38f73090843759dd0', '2', 'I', '4', '1', '2022-03-02 11:52:41', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('7d3aac99af9e4c268ba5c0ef9d79b54f', '', '头孢西丁', 'CFX', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 11:52:42', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('9781c8caaf6f4e06bb141f1b291e9122', '', '头孢吡肟', 'CPM', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 11:52:42', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('486e299ecfd0481fbf6398609cc36a96', '', '头孢呋辛', 'CXM', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 11:52:42', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('5e4e482018234e689d08c53b1c13a086', '', '亚胺培南', 'IMP', '013ecf416db546c38f73090843759dd0', '2', 'I', '3', '1', '2022-03-02 11:52:43', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('7eb16ae23b854bafbc46d4b18e9005c2', '', '头孢他啶', 'CAZ', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 11:52:43', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('0c3c03f2d8f043c8b8e7fc58705e1fc1', '', '厄他培南', 'ETP', '013ecf416db546c38f73090843759dd0', '2', 'R', '3', '1', '2022-03-02 11:52:43', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('49e705f4514248e9a5c3c6885e545e0c', '', '庆大霉素', 'GEN', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 11:52:44', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('c8f71b9de6ca47a3bd9e0cc34e49ad91', '', '四环素', 'TET', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 11:52:45', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('544a7cc87b2049ab946f883569a491a6', '', '替加环素', 'TIG', '013ecf416db546c38f73090843759dd0', '2', 'R', '3', '1', '2022-03-02 11:52:45', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('ed3f0f8a277641a2b6a202e1de895d92', '', '左氧氟沙星', 'LEV', '013ecf416db546c38f73090843759dd0', '2', 'R', '2', '1', '2022-03-02 11:52:45', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('e789d9cf40c349ddbf25270428d4dcad', '', '美罗培南', 'MEM', '013ecf416db546c38f73090843759dd0', '2', 'I', '2', '1', '2022-03-02 11:52:46', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('a072ae6091c044509f94c8e8009dee85', '', '诺氟沙星', 'NOR', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 11:52:46', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('bdbae48cb41b4903bbdf3c8ce127e9d1', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '4', 'R', '4', '1', '2022-03-02 11:52:47', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('cb3301f094a9453c9624b788c454ed34', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '32', 'R', '2', '1', '2022-03-02 11:52:47', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('303fcb4dd48546de8ef82f6e6eb5e93e', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '2', 'R', '5', '1', '2022-03-02 11:52:47', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('d101668d7ff640f2a5f5f0ef22edcb0b', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '8', 'S', '4', '1', '2022-03-02 11:52:48', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('928bdc576e1348b890e12fa9fef4c90b', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '>32', 'R', '0', '1', '2022-03-02 11:56:02', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('70868c36be7244faa747e3acd87d9a74', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '>64', 'R', '0', '1', '2022-03-02 11:56:03', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('a199474bb8e04e44928f91599780dc3c', '', '多粘菌素E', 'CT', '013ecf416db546c38f73090843759dd0', '2', 'I', '3', '1', '2022-03-02 11:56:03', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('bc44559de0af492694ef387f9a9c5b81', '', '头孢唑林', 'CFZ', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 11:56:04', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('ccca72196a044c63befa0bde570f046b', '', '头孢噻肟', 'CTX', '013ecf416db546c38f73090843759dd0', '2', 'I', '4', '1', '2022-03-02 11:56:04', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('d817ed4dd0e44245a05d689e430bb2be', '', '头孢西丁', 'CFX', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 11:56:04', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('3d9e61db8aac43ea97040ce5fee86526', '', '头孢吡肟', 'CPM', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 11:56:05', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('506776ec853a4a9da7f0fa46b611f9f6', '', '头孢呋辛', 'CXM', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 11:56:05', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('1c82c0d91a0447e59e54c930d02c3260', '', '亚胺培南', 'IMP', '013ecf416db546c38f73090843759dd0', '2', 'I', '3', '1', '2022-03-02 11:56:06', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('09e559555a47440fbd754045042cc062', '', '头孢他啶', 'CAZ', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 11:56:06', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('53cb38da3f704d6e94e92887b59ae4df', '', '厄他培南', 'ETP', '013ecf416db546c38f73090843759dd0', '2', 'R', '3', '1', '2022-03-02 11:56:06', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('1d80b7f04339476ebee65c9f3469d417', '', '庆大霉素', 'GEN', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 11:56:07', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('4606eb6042494026ab419e3cb736aff6', '', '四环素', 'TET', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 11:56:07', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('1e834c2f6d784e1a84dc22e9a83eec5b', '', '替加环素', 'TIG', '013ecf416db546c38f73090843759dd0', '2', 'R', '3', '1', '2022-03-02 11:56:08', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('23a95222261d4ece9674ee1e176470d9', '', '左氧氟沙星', 'LEV', '013ecf416db546c38f73090843759dd0', '2', 'R', '2', '1', '2022-03-02 11:56:08', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('82e54152d8f34de9bb602d753912451a', '', '美罗培南', 'MEM', '013ecf416db546c38f73090843759dd0', '2', 'I', '2', '1', '2022-03-02 11:56:09', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('0f5f0e02e20e4fbfb3bcf0abd3f50e26', '', '诺氟沙星', 'NOR', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 11:56:09', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('baf6ea7bd30a49468787c23f0e31cc77', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '4', 'R', '4', '1', '2022-03-02 11:56:09', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('77a296e108b94d1c9a8e3965f7f6d75d', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '32', 'R', '2', '1', '2022-03-02 11:56:10', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('3d415eebb34e4974a52127509d995d33', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '2', 'R', '5', '1', '2022-03-02 11:56:10', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('c1bd0608f9424e63a27c3d52fef4fe2f', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '8', 'S', '4', '1', '2022-03-02 11:56:10', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('c38865ecfa6d4a1cb338aea26d872f37', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '>32', 'R', '0', '1', '2022-03-02 12:18:22', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('4d6f741937f14a279acfc89b9ad3bec8', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '>64', 'R', '0', '1', '2022-03-02 12:18:23', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('2865b37f708d44b1ab61b182a2f9e2c4', '', '多粘菌素E', 'CT', '013ecf416db546c38f73090843759dd0', '2', 'I', '3', '1', '2022-03-02 12:18:23', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('ca24eb69f73a4e8aacfe7b31ff50f168', '', '头孢唑林', 'CFZ', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 12:18:23', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('e6f54a38a7814dc693e3dd8dd9c9c258', '', '头孢噻肟', 'CTX', '013ecf416db546c38f73090843759dd0', '2', 'I', '4', '1', '2022-03-02 12:18:24', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('ca12b647263f40e38716c8076324e899', '', '头孢西丁', 'CFX', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 12:18:24', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('6690c98dc51f4bb590053c367834eb53', '', '头孢吡肟', 'CPM', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 12:18:25', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('6f4da861d43744d38889fb1d03c8727f', '', '头孢呋辛', 'CXM', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 12:18:25', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('b8f5ad5de10e46269ddfda5a70aedac4', '', '亚胺培南', 'IMP', '013ecf416db546c38f73090843759dd0', '2', 'I', '3', '1', '2022-03-02 12:18:25', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('7a4d4cf243784793b479f930f1cff1c7', '', '头孢他啶', 'CAZ', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 12:18:26', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('a52f02b3997440569db5501faac98873', '', '厄他培南', 'ETP', '013ecf416db546c38f73090843759dd0', '2', 'R', '3', '1', '2022-03-02 12:18:26', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('8511c7cd56be4d9ab25aa76224703fef', '', '庆大霉素', 'GEN', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 12:18:27', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('890362f458de466482e7698860347903', '', '四环素', 'TET', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 12:18:27', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('29020f3e99bc47ddaf7cd7b1dabc2e89', '', '替加环素', 'TIG', '013ecf416db546c38f73090843759dd0', '2', 'R', '3', '1', '2022-03-02 12:18:27', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('d19cccde91ea4f28b73fbc61b82bf5e8', '', '左氧氟沙星', 'LEV', '013ecf416db546c38f73090843759dd0', '2', 'R', '2', '1', '2022-03-02 12:18:28', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('72e37be089064febaa214c7d2e06d854', '', '美罗培南', 'MEM', '013ecf416db546c38f73090843759dd0', '2', 'I', '2', '1', '2022-03-02 12:18:28', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('0851b803f15646b38a6307bd40278ab6', '', '诺氟沙星', 'NOR', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 12:18:29', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('80e600b77c6143a69ac63d82ebdc60c0', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '4', 'R', '4', '1', '2022-03-02 12:18:29', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('d5c62dd700594bc1b266f309bd8e9446', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '32', 'R', '2', '1', '2022-03-02 12:18:29', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('f04fc85e5c7944b0a88e0c9610287180', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '2', 'R', '5', '1', '2022-03-02 12:18:30', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('3958102e49d64bfb843f0403bd4933cc', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '8', 'S', '4', '1', '2022-03-02 12:18:30', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('c76c7e6579144dfe934fa155dc9f564e', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '>32', 'R', '0', '1', '2022-03-02 12:28:54', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('9065d8c9d2f04af79634550e47b21921', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '>64', 'R', '0', '1', '2022-03-02 12:28:54', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('3c2682aef1e8424aad45a18041be5019', '', '多粘菌素E', 'CT', '013ecf416db546c38f73090843759dd0', '2', 'I', '3', '1', '2022-03-02 12:28:55', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('6334982edea84b9ca2a743d9b8b59db1', '', '头孢唑林', 'CFZ', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 12:28:56', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('723306bb9426427bbf3ab8e613cfcd0d', '', '头孢噻肟', 'CTX', '013ecf416db546c38f73090843759dd0', '2', 'I', '4', '1', '2022-03-02 12:28:57', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('a60a2211043544559dfa5758247cb874', '', '头孢西丁', 'CFX', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 12:28:58', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('5fb88ad5b8ef46be8c7b2430a5a4ab17', '', '头孢吡肟', 'CPM', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 12:28:58', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('05849f57a87e4d66a1bacd7814446bfa', '', '头孢呋辛', 'CXM', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 12:28:59', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('07f77fa3abd74eae9819dce4f9ef99d8', '', '亚胺培南', 'IMP', '013ecf416db546c38f73090843759dd0', '2', 'I', '3', '1', '2022-03-02 12:28:59', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('e0e63a894601484db0a8951b6e944f78', '', '头孢他啶', 'CAZ', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 12:29:00', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('fc17e526a3494eecb82f1d62d7080eb3', '', '厄他培南', 'ETP', '013ecf416db546c38f73090843759dd0', '2', 'R', '3', '1', '2022-03-02 12:29:00', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('179caf5618574a7b933b7cf210faa1ef', '', '庆大霉素', 'GEN', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 12:29:01', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('f07b624acf6647a987ccb54949431242', '', '四环素', 'TET', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 12:29:01', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('1d780190f6d9407fb27b18d72b1ff64f', '', '替加环素', 'TIG', '013ecf416db546c38f73090843759dd0', '2', 'R', '3', '1', '2022-03-02 12:29:02', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('3cf5aa11e6864d788e20e78d06bab083', '', '左氧氟沙星', 'LEV', '013ecf416db546c38f73090843759dd0', '2', 'R', '2', '1', '2022-03-02 12:29:03', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('a1dbb0e1475243e0be7e5e19bbdea2c3', '', '美罗培南', 'MEM', '013ecf416db546c38f73090843759dd0', '2', 'I', '2', '1', '2022-03-02 12:29:03', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('365bb36671e94bce9551e7bd7de7321b', '', '诺氟沙星', 'NOR', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 12:29:03', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('d08c303b7a24460a86ac8ddcfa9be995', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '4', 'R', '4', '1', '2022-03-02 12:29:04', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('b7384c78485d4e788daf3578b8a0ec37', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '32', 'R', '2', '1', '2022-03-02 12:29:04', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('081a0abb4e744969868946522acafbc3', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '2', 'R', '5', '1', '2022-03-02 12:29:05', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('351d711fe08c422880700e3a717f9214', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '8', 'S', '4', '1', '2022-03-02 12:29:05', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('3a824393ea4e4443ae79dcb26982ffe2', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '>32', 'R', '0', '1', '2022-03-02 12:29:08', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('160a5cb54a5f460cb143f8bfe351cf77', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '>64', 'R', '0', '1', '2022-03-02 12:29:08', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('401bc6ac258f45b7897653bb63549a3b', '', '多粘菌素E', 'CT', '013ecf416db546c38f73090843759dd0', '2', 'I', '3', '1', '2022-03-02 12:29:09', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('b8ae9a1d837342f2b995d4e1e8a99346', '', '头孢唑林', 'CFZ', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 12:29:09', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('9623f7e1e37740b8858bbd5fede2df7e', '', '头孢噻肟', 'CTX', '013ecf416db546c38f73090843759dd0', '2', 'I', '4', '1', '2022-03-02 12:29:09', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('5c05edbaedb043c78b4a29a20160422c', '', '头孢西丁', 'CFX', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 12:29:10', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('854d5cabe60741c1afcedee9f62cbe6f', '', '头孢吡肟', 'CPM', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 12:29:11', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('67326a496c8f4881afce58dc777ea7ba', '', '头孢呋辛', 'CXM', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 12:29:11', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('a11f46f2b61e48a295510162d8237dfb', '', '亚胺培南', 'IMP', '013ecf416db546c38f73090843759dd0', '2', 'I', '3', '1', '2022-03-02 12:29:11', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('9fb6296d69404a62869d965a2d1f7dcc', '', '头孢他啶', 'CAZ', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 12:29:12', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('974ea4a7ec5e4008b006297c93cb5bb9', '', '厄他培南', 'ETP', '013ecf416db546c38f73090843759dd0', '2', 'R', '3', '1', '2022-03-02 12:29:12', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('606263e3354a4e858679eef70625975e', '', '庆大霉素', 'GEN', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 12:29:13', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('cd2f2b4e6a93492f9e95a4e29b725f2b', '', '四环素', 'TET', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 12:29:14', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('e9dee9266142440d9d95e4fbc809f947', '', '替加环素', 'TIG', '013ecf416db546c38f73090843759dd0', '2', 'R', '3', '1', '2022-03-02 12:29:14', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('460e0671d530445792d9a5b080106189', '', '左氧氟沙星', 'LEV', '013ecf416db546c38f73090843759dd0', '2', 'R', '2', '1', '2022-03-02 12:29:15', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('bae1c44b1a13452b986aded9a57f73e9', '', '美罗培南', 'MEM', '013ecf416db546c38f73090843759dd0', '2', 'I', '2', '1', '2022-03-02 12:29:15', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('30749dc451ce4955acce83e61cfc30b3', '', '诺氟沙星', 'NOR', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 12:29:15', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('168d96a572ca4be8b6843b669d515757', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '4', 'R', '4', '1', '2022-03-02 12:29:16', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('18f98d37b8804f7b84a9e2fc31244887', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '32', 'R', '2', '1', '2022-03-02 12:29:16', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('db155ae5357443b2b3745e7f9d3508d5', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '2', 'R', '5', '1', '2022-03-02 12:29:17', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('4f82d774cd4a4abc9038c531767a3868', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '8', 'S', '4', '1', '2022-03-02 12:29:17', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('fb62cafbe6074de28d3a541ef8fd0b5e', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '>32', 'R', '0', '1', '2022-03-02 12:37:28', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('c675d8788e9f472481385a8f22a4c2db', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '>64', 'R', '0', '1', '2022-03-02 12:37:29', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('b68fc5a7fedc4956a4e078ad457a0f0d', '', '多粘菌素E', 'CT', '013ecf416db546c38f73090843759dd0', '2', 'I', '3', '1', '2022-03-02 12:37:30', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('9948012e996446d490e3ba8db221a58f', '', '头孢唑林', 'CFZ', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 12:37:31', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('593c6b76b191460d8e9172d0aeed5303', '', '头孢噻肟', 'CTX', '013ecf416db546c38f73090843759dd0', '2', 'I', '4', '1', '2022-03-02 12:37:31', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('2b72f37bf6684905ae193aa235941731', '', '头孢西丁', 'CFX', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 12:37:32', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('e4c49baffb9043378ebd86c0ac062085', '', '头孢吡肟', 'CPM', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 12:37:32', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('5bdae815c4454fadac78bc908ea3adfc', '', '头孢呋辛', 'CXM', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 12:37:32', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('ab5d717f27004f009419877d804a2493', '', '亚胺培南', 'IMP', '013ecf416db546c38f73090843759dd0', '2', 'I', '3', '1', '2022-03-02 12:37:33', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('8f91935ae6524c08bae3afe257300943', '', '头孢他啶', 'CAZ', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 12:37:33', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('69a6f84a680b4472a519761b4b6cb2ad', '', '厄他培南', 'ETP', '013ecf416db546c38f73090843759dd0', '2', 'R', '3', '1', '2022-03-02 12:37:34', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('85882511db24418db9a38328a2776b37', '', '庆大霉素', 'GEN', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 12:37:35', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('229a0426409c48d7a353fa40dcc83745', '', '四环素', 'TET', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 12:37:35', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('7e72b84ff8b94cf8b76503e4a740fdd7', '', '替加环素', 'TIG', '013ecf416db546c38f73090843759dd0', '2', 'R', '3', '1', '2022-03-02 12:37:36', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('82da350114604388a5d7cc905f6b8068', '', '左氧氟沙星', 'LEV', '013ecf416db546c38f73090843759dd0', '2', 'R', '2', '1', '2022-03-02 12:37:37', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('0787082b8c7445b98ad28ff62572dfdb', '', '美罗培南', 'MEM', '013ecf416db546c38f73090843759dd0', '2', 'I', '2', '1', '2022-03-02 12:37:37', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('e8934d4389db4bfa8c5efd66c99c0e5a', '', '诺氟沙星', 'NOR', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 12:37:38', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('cc141d80cc4b4bb48ccc251dd57fd848', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '4', 'R', '4', '1', '2022-03-02 12:37:38', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('8fd9ec1139374656be4db153b8cbde77', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '32', 'R', '2', '1', '2022-03-02 12:37:39', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('2e6b6d1bdbe04e1695bff019b07ca991', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '2', 'R', '5', '1', '2022-03-02 12:37:39', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('24075682927c4f0392eb4f6935093b01', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '8', 'S', '4', '1', '2022-03-02 12:37:39', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('0408054e75d84d2aa4ac66180bbfe52c', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '>32', 'R', '0', '1', '2022-03-02 12:41:26', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('553a405cc71e4681afcc3195b9f7c45a', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '>64', 'R', '0', '1', '2022-03-02 12:41:26', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('72c9bc717a6c4e1f8636051fcef8e313', '', '多粘菌素E', 'CT', '013ecf416db546c38f73090843759dd0', '2', 'I', '3', '1', '2022-03-02 12:41:27', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('c2fbbad382af4ac0bec6ac6eb19c6e6a', '', '头孢唑林', 'CFZ', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 12:41:28', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('8e3332ef51194fe28ac877cc536f137b', '', '头孢噻肟', 'CTX', '013ecf416db546c38f73090843759dd0', '2', 'I', '4', '1', '2022-03-02 12:41:28', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('8ebf417caf764826beec0b5bc49f25be', '', '头孢西丁', 'CFX', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 12:41:29', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('b446a4b45c7c4f4f93a66f170f845fb9', '', '头孢吡肟', 'CPM', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 12:41:30', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('1da2ed7554dc42c6a9bf0e39edb7d613', '', '头孢呋辛', 'CXM', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 12:41:32', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('9f1268f2fca541ffb6c26f4758c8003a', '', '亚胺培南', 'IMP', '013ecf416db546c38f73090843759dd0', '2', 'I', '3', '1', '2022-03-02 12:41:33', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('93ae1e1b36e04fdbb773a3f8eb3b6e8c', '', '头孢他啶', 'CAZ', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 12:41:33', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('c75284c0b2644e5db9b2d8e41d76c2b8', '', '厄他培南', 'ETP', '013ecf416db546c38f73090843759dd0', '2', 'R', '3', '1', '2022-03-02 12:41:35', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('6312dc0166784a1889ecd37f2dadb102', '', '庆大霉素', 'GEN', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 12:41:36', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('be4aaaf9c76144b98bebba2e7f790e6c', '', '四环素', 'TET', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 12:41:38', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('e0d387ba1fba451fb2eb61c8bf41d3fb', '', '替加环素', 'TIG', '013ecf416db546c38f73090843759dd0', '2', 'R', '3', '1', '2022-03-02 12:41:40', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('6bceb92ccf2149b7b679279653379e6a', '', '左氧氟沙星', 'LEV', '013ecf416db546c38f73090843759dd0', '2', 'R', '2', '1', '2022-03-02 12:41:43', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('4efa4c46187a4252b3e21cf6393c3ea4', '', '美罗培南', 'MEM', '013ecf416db546c38f73090843759dd0', '2', 'I', '2', '1', '2022-03-02 12:41:44', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('0982ae4d4b914829ac01b1dc095a9594', '', '诺氟沙星', 'NOR', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 12:41:47', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('1d4279581be446e1bc969f7875d9e332', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '4', 'R', '4', '1', '2022-03-02 12:41:50', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('79ad7bda0e3b45ddbdb654ce3ff4f9a5', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '32', 'R', '2', '1', '2022-03-02 12:41:52', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('1234d0e218a54f8b8f80b999b91a9055', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '2', 'R', '5', '1', '2022-03-02 12:41:55', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('b2ef0d395c5a49c3aee36c2ed74e3666', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '8', 'S', '4', '1', '2022-03-02 12:41:59', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('5709a6a9a8854d86b248fd853b4f7e5f', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '>32', 'R', '0', '1', '2022-03-02 13:57:04', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('0fa513c8196b46dea6987de05e686b4f', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '>64', 'R', '0', '1', '2022-03-02 13:57:04', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('0941eafacf4d4864a0ae03e99ab3c889', '', '多粘菌素E', 'CT', '013ecf416db546c38f73090843759dd0', '2', 'I', '3', '1', '2022-03-02 13:57:05', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('f611b191d3274d6fab4239446c0878ed', '', '头孢唑林', 'CFZ', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 13:57:05', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('320156d26eda40b28848d8921aa92d22', '', '头孢噻肟', 'CTX', '013ecf416db546c38f73090843759dd0', '2', 'I', '4', '1', '2022-03-02 13:57:06', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('e0f0c87579094101b6c127fc1f43cb98', '', '头孢西丁', 'CFX', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 13:57:06', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('d888f920300242c8b1b2f262669a3eca', '', '头孢吡肟', 'CPM', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 13:57:07', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('324561f41f8746c18432c71450643dbe', '', '头孢呋辛', 'CXM', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 13:57:07', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('cc324b4d10514dccb78d9c76bd6450d9', '', '亚胺培南', 'IMP', '013ecf416db546c38f73090843759dd0', '2', 'I', '3', '1', '2022-03-02 13:57:07', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('2e414e34226d402abd2fb8aab754a597', '', '头孢他啶', 'CAZ', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 13:57:08', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('cb80d6a10bf44b88a86f0885c1a41731', '', '厄他培南', 'ETP', '013ecf416db546c38f73090843759dd0', '2', 'R', '3', '1', '2022-03-02 13:57:08', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('78d58824ace647089cdcb4517e6d17f2', '', '庆大霉素', 'GEN', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 13:57:09', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('c229e65ba7754b0c9802ee3aafcf0b19', '', '四环素', 'TET', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 13:57:09', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('55fa292d949f4ba7bfc62d6e81e77b80', '', '替加环素', 'TIG', '013ecf416db546c38f73090843759dd0', '2', 'R', '3', '1', '2022-03-02 13:57:10', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('8cce2e01c65841de940af6e10916d592', '', '左氧氟沙星', 'LEV', '013ecf416db546c38f73090843759dd0', '2', 'R', '2', '1', '2022-03-02 13:57:10', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('e365357138794206b2b910da1e978348', '', '美罗培南', 'MEM', '013ecf416db546c38f73090843759dd0', '2', 'I', '2', '1', '2022-03-02 13:57:11', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('e2afa763fc824778a10c7cf70e76ae08', '', '诺氟沙星', 'NOR', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 13:57:11', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('6e10e9e6bb794f258b13d001324ce3f5', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '4', 'R', '4', '1', '2022-03-02 13:57:11', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('253e8f366d4a423892165925918d7afd', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '32', 'R', '2', '1', '2022-03-02 13:57:12', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('2e138c3e34ce4feba9a9ac8e46ebe301', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '2', 'R', '5', '1', '2022-03-02 13:57:12', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('549c35efa6e449af8e3d16647d3161b3', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '8', 'S', '4', '1', '2022-03-02 13:57:12', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('8bf07ab37b254aa38291ff05577106d7', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '>32', 'R', '0', '1', '2022-03-02 13:57:29', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('b0545606d6a1452b863d2f96eaedb260', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '>64', 'R', '0', '1', '2022-03-02 13:57:30', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('6d66270f18a64a2a96d5abf01b163fb3', '', '多粘菌素E', 'CT', '013ecf416db546c38f73090843759dd0', '2', 'I', '3', '1', '2022-03-02 13:57:30', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('64fe95c6ef0a4baeb98d23b0b2e604c4', '', '头孢唑林', 'CFZ', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 13:57:31', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('350283b30f3b4e43a53ce519c73ba9b9', '', '头孢噻肟', 'CTX', '013ecf416db546c38f73090843759dd0', '2', 'I', '4', '1', '2022-03-02 13:57:31', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('5c521ee78ef84cdd8b052f765e8b13e6', '', '头孢西丁', 'CFX', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 13:57:32', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('a4a26263efb04f18848dba1b25401b07', '', '头孢吡肟', 'CPM', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 13:57:32', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('4b79366c55034c6fb820480caae8ec0c', '', '头孢呋辛', 'CXM', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 13:57:32', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('6d354334e5f044c2b11478d9d5356302', '', '亚胺培南', 'IMP', '013ecf416db546c38f73090843759dd0', '2', 'I', '3', '1', '2022-03-02 13:57:33', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('ae35efa606db4f879b0831b6138e899d', '', '头孢他啶', 'CAZ', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 13:57:33', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('31637c1dc6a440a58e4a9f615a6d2382', '', '厄他培南', 'ETP', '013ecf416db546c38f73090843759dd0', '2', 'R', '3', '1', '2022-03-02 13:57:34', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('6d25b8f622144c0db4a764fd9731a497', '', '庆大霉素', 'GEN', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 13:57:34', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('80149b09de594fa78db64e7744e79b96', '', '四环素', 'TET', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 13:57:35', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('a7aed4c5c7854f28bd5304c4ee4713e1', '', '替加环素', 'TIG', '013ecf416db546c38f73090843759dd0', '2', 'R', '3', '1', '2022-03-02 13:57:35', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('8c32ce2d660445e7aef48d22f8fa0ce4', '', '左氧氟沙星', 'LEV', '013ecf416db546c38f73090843759dd0', '2', 'R', '2', '1', '2022-03-02 13:57:36', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('e03b8b774a9b4ee89cca93927c1d6b14', '', '美罗培南', 'MEM', '013ecf416db546c38f73090843759dd0', '2', 'I', '2', '1', '2022-03-02 13:57:36', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('a77d836ee7a44609b894d626472f3f7c', '', '诺氟沙星', 'NOR', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 13:57:36', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('dbcb26dceca34b958c9cf2d5cb8b9dc8', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '4', 'R', '4', '1', '2022-03-02 13:57:37', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('cee3150b72204a41a4f9007a4cc402fd', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '32', 'R', '2', '1', '2022-03-02 13:57:37', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('ac609d57ac5c4017908783e0a02dee36', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '2', 'R', '5', '1', '2022-03-02 13:57:38', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('aa232f80d8f3465e95a6325f44c1a368', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '8', 'S', '4', '1', '2022-03-02 13:57:38', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('07c1297fa3184319bc78b000970d026e', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '>32', 'R', '0', '1', '2022-03-02 14:03:32', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('33fc4fc7bf554e489a16ee4801f09145', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '>64', 'R', '0', '1', '2022-03-02 14:03:33', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('9f13bd1f764246649c0af0968c0c838b', '', '多粘菌素E', 'CT', '013ecf416db546c38f73090843759dd0', '2', 'I', '3', '1', '2022-03-02 14:03:33', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('8f67c29a49ef44eebd8568e27c19dcbd', '', '头孢唑林', 'CFZ', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 14:03:33', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('01569d0bffa84978bb7ab5a7d4191504', '', '头孢噻肟', 'CTX', '013ecf416db546c38f73090843759dd0', '2', 'I', '4', '1', '2022-03-02 14:03:34', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('584cf917a47340b39303ed9ffdfe4875', '', '头孢西丁', 'CFX', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 14:03:34', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('68aaf67ad85b4984bb488ed62096bf9a', '', '头孢吡肟', 'CPM', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 14:03:35', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('b3d1e8d23ad3442b9671de499097cdcd', '', '头孢呋辛', 'CXM', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 14:03:35', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('c2dff9db2cf844adaf19fc4d5fcb76a9', '', '亚胺培南', 'IMP', '013ecf416db546c38f73090843759dd0', '2', 'I', '3', '1', '2022-03-02 14:03:35', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('bf0439ecccdf487eb327a3a383db5f95', '', '头孢他啶', 'CAZ', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 14:03:36', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('207fd9d291f44af084468f146c1a3607', '', '厄他培南', 'ETP', '013ecf416db546c38f73090843759dd0', '2', 'R', '3', '1', '2022-03-02 14:03:36', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('e5f3669600eb49d49301d105dd7f496e', '', '庆大霉素', 'GEN', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 14:03:37', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('47e34580d30c48d395d6d7baf2b8c773', '', '四环素', 'TET', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 14:03:37', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('2bc167da7978488580b9a4a613edff83', '', '替加环素', 'TIG', '013ecf416db546c38f73090843759dd0', '2', 'R', '3', '1', '2022-03-02 14:03:38', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('a174a85af53545afa13e792710fb34c8', '', '左氧氟沙星', 'LEV', '013ecf416db546c38f73090843759dd0', '2', 'R', '2', '1', '2022-03-02 14:03:38', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('b52f71d0ec7844d88ba47f448b331095', '', '美罗培南', 'MEM', '013ecf416db546c38f73090843759dd0', '2', 'I', '2', '1', '2022-03-02 14:03:39', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('884e49c37c3e4ec089a937daad624bb8', '', '诺氟沙星', 'NOR', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 14:03:39', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('d85fdd104c11413bab23394bec231d2e', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '4', 'R', '4', '1', '2022-03-02 14:03:40', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('3c65f136e88745ca8483d71ad4564b43', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '32', 'R', '2', '1', '2022-03-02 14:03:40', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('8bafcc2cacef4c0aa81bde3eaec6c4ae', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '2', 'R', '5', '1', '2022-03-02 14:03:40', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('c3e524cb79dd474aa1e96cd148e3685e', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '8', 'S', '4', '1', '2022-03-02 14:03:41', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('e48b79cbe5b5447090dc8ca3a88cda31', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '>32', 'R', '0', '1', '2022-03-02 14:04:00', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('4d53f951127c43f9a84534d6454178dc', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '>64', 'R', '0', '1', '2022-03-02 14:04:01', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('7a3e21207eae47b5b0fa1746f07781b2', '', '多粘菌素E', 'CT', '013ecf416db546c38f73090843759dd0', '2', 'I', '3', '1', '2022-03-02 14:04:01', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('04dc0aec791a4f7fa3178d4cfaa2214a', '', '头孢唑林', 'CFZ', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 14:04:01', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('67913aae11c8410b8ee6c40a04ee1a21', '', '头孢噻肟', 'CTX', '013ecf416db546c38f73090843759dd0', '2', 'I', '4', '1', '2022-03-02 14:04:02', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('92b42529184548939fad5ef20a075928', '', '头孢西丁', 'CFX', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 14:04:02', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('d4a89e9b878140b0b2839549168e18f0', '', '头孢吡肟', 'CPM', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 14:04:03', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('430f71be4dc1458e8b560042a07a2ba5', '', '头孢呋辛', 'CXM', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 14:04:03', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('8c489fe9be134a58a122e84561deea06', '', '亚胺培南', 'IMP', '013ecf416db546c38f73090843759dd0', '2', 'I', '3', '1', '2022-03-02 14:04:03', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('5c87170ba03f4bc293d058bfcf2a7d7d', '', '头孢他啶', 'CAZ', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 14:04:04', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('5a54dac33b5b4dafaab138a8709cb199', '', '厄他培南', 'ETP', '013ecf416db546c38f73090843759dd0', '2', 'R', '3', '1', '2022-03-02 14:04:04', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('cee484c68f0d44429a00901b4408db2c', '', '庆大霉素', 'GEN', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 14:04:05', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('678e0a060dc94159b7f5e03cc27cb41c', '', '四环素', 'TET', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 14:04:05', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('e2931f93024948ad84e0741e112871ea', '', '替加环素', 'TIG', '013ecf416db546c38f73090843759dd0', '2', 'R', '3', '1', '2022-03-02 14:04:06', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('6c71f35e5d274f3b81e75a18fc7ca9d8', '', '左氧氟沙星', 'LEV', '013ecf416db546c38f73090843759dd0', '2', 'R', '2', '1', '2022-03-02 14:04:06', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('08f33b4c8fab4b2dac84956c732016bf', '', '美罗培南', 'MEM', '013ecf416db546c38f73090843759dd0', '2', 'I', '2', '1', '2022-03-02 14:04:07', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('d025e74317f747cc97976ee939ce9e9a', '', '诺氟沙星', 'NOR', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 14:04:07', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('10ec089fc39b47438d054caa48f74c3a', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '4', 'R', '4', '1', '2022-03-02 14:04:08', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('ca086dad79d244918d641797ae6f2942', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '32', 'R', '2', '1', '2022-03-02 14:04:08', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('284df70c1cd34d0991738e4005baa2d2', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '2', 'R', '5', '1', '2022-03-02 14:04:08', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('ed92478ffced4b0397cc462c7a8ea42d', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '8', 'S', '4', '1', '2022-03-02 14:04:09', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('d1865cd632e04e67915704b1f0776419', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '>32', 'R', '0', '1', '2022-03-02 15:05:58', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('e9d30c0d440f4cd6a6b1137735dfac03', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '>64', 'R', '0', '1', '2022-03-02 15:05:58', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('7a8d09aedc474a59bdfd1b36310332a2', '', '多粘菌素E', 'CT', '013ecf416db546c38f73090843759dd0', '2', 'I', '3', '1', '2022-03-02 15:05:59', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('269f04e966ec4a85a535b96705acf172', '', '头孢唑林', 'CFZ', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 15:06:00', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('6a1f1a10375d4a7a8070286b31b61c19', '', '头孢噻肟', 'CTX', '013ecf416db546c38f73090843759dd0', '2', 'I', '4', '1', '2022-03-02 15:06:01', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('eb0669547356424b9419c3c81a207e9b', '', '头孢西丁', 'CFX', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 15:06:02', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('71a823baca9141aa9f448771553650d2', '', '头孢吡肟', 'CPM', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 15:06:02', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('930e0f6c791546e69b609fd3cda1a1cc', '', '头孢呋辛', 'CXM', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 15:06:02', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('03c13de8cb244569a7dbc5ae5993dea2', '', '亚胺培南', 'IMP', '013ecf416db546c38f73090843759dd0', '2', 'I', '3', '1', '2022-03-02 15:06:04', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('8e73b6adc2194ceb9566cf60f1161f09', '', '头孢他啶', 'CAZ', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 15:06:07', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('301d1c9e185e4a8e8675ae9d7a0edbec', '', '厄他培南', 'ETP', '013ecf416db546c38f73090843759dd0', '2', 'R', '3', '1', '2022-03-02 15:06:08', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('fc4fc29a71324af3aa67f724c9ce0871', '', '庆大霉素', 'GEN', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 15:06:08', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('66866c891bfe4db2850d67554ca8eda4', '', '四环素', 'TET', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 15:06:09', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('17650bd7a258400984235ae781db2d0f', '', '替加环素', 'TIG', '013ecf416db546c38f73090843759dd0', '2', 'R', '3', '1', '2022-03-02 15:06:09', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('c850893f898b4c58858e6a73e8e8642d', '', '左氧氟沙星', 'LEV', '013ecf416db546c38f73090843759dd0', '2', 'R', '2', '1', '2022-03-02 15:06:10', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('6a24ba3e906847d992aa8c3b607c7f37', '', '美罗培南', 'MEM', '013ecf416db546c38f73090843759dd0', '2', 'I', '2', '1', '2022-03-02 15:06:10', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('3fbcf5af381b46128a87c341aa37407e', '', '诺氟沙星', 'NOR', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 15:06:11', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('17799c2d55034054be04fb740356d783', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '4', 'R', '4', '1', '2022-03-02 15:06:11', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('615a1bae9f3f4bc4b55b446cf381c721', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '32', 'R', '2', '1', '2022-03-02 15:06:11', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('757dc8b236f34e3594b40de33207d7cb', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '2', 'R', '5', '1', '2022-03-02 15:06:12', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('945547d705cb42a09c80266b097e33d4', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '8', 'S', '4', '1', '2022-03-02 15:06:12', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('5b076ca0933d41e4b9a1901a43c67a33', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '>32', 'R', '0', '1', '2022-03-02 15:06:47', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('9221d92282b74cf9bb2fc207562e207d', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '>64', 'R', '0', '1', '2022-03-02 15:06:48', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('c6b03ffe09764d068d71a922f7b7fe2e', '', '多粘菌素E', 'CT', '013ecf416db546c38f73090843759dd0', '2', 'I', '3', '1', '2022-03-02 15:06:48', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('c8cca3b76bc945dea10b27ce0d94df4c', '', '头孢唑林', 'CFZ', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 15:06:49', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('efe07e88f228461e951e8d4ff3b2e99c', '', '头孢噻肟', 'CTX', '013ecf416db546c38f73090843759dd0', '2', 'I', '4', '1', '2022-03-02 15:06:49', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('1eaa0d0ef6fe4ed3b57cb07a0b4fc5d0', '', '头孢西丁', 'CFX', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 15:06:50', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('3d4c6398eeba4a5b9b680e8fd961fd40', '', '头孢吡肟', 'CPM', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 15:06:50', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('0a505c0ec2ba4755ae53b5e7299e719a', '', '头孢呋辛', 'CXM', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 15:06:50', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('5bf558e5439c47b6ad413a9c08e0ddd4', '', '亚胺培南', 'IMP', '013ecf416db546c38f73090843759dd0', '2', 'I', '3', '1', '2022-03-02 15:06:51', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('ae9cb8c2f60f443ba17445a2da94ea44', '', '头孢他啶', 'CAZ', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 15:06:51', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('36890d0eddcd4a6d8c711c558d44a3fe', '', '厄他培南', 'ETP', '013ecf416db546c38f73090843759dd0', '2', 'R', '3', '1', '2022-03-02 15:06:52', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('84bdf2215e4a44889b99a942fe2bb618', '', '庆大霉素', 'GEN', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 15:06:52', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('72c63bc555bd4b4b92b07b8dbf132e7a', '', '四环素', 'TET', '013ecf416db546c38f73090843759dd0', '2', 'S', '5', '1', '2022-03-02 15:06:53', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('44d33f8c7e3345549aed32b3abb066a3', '', '替加环素', 'TIG', '013ecf416db546c38f73090843759dd0', '2', 'R', '3', '1', '2022-03-02 15:06:53', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('b8fc3d721b1d4a269e74de22188b6bed', '', '左氧氟沙星', 'LEV', '013ecf416db546c38f73090843759dd0', '2', 'R', '2', '1', '2022-03-02 15:06:54', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('bd53943b7a844abbb713748594fd5a8d', '', '美罗培南', 'MEM', '013ecf416db546c38f73090843759dd0', '2', 'I', '2', '1', '2022-03-02 15:06:54', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('9a34221118b2458c84f13ed48a417cc0', '', '诺氟沙星', 'NOR', '013ecf416db546c38f73090843759dd0', '2', 'S', '6', '1', '2022-03-02 15:06:55', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('f15a4e89079846599ad42df1727e8421', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '4', 'R', '4', '1', '2022-03-02 15:06:55', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('8de94475a22e408a97f576d4427fd30e', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '32', 'R', '2', '1', '2022-03-02 15:06:55', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('37f53af96f3241d2b44666616c3ea47b', '', '环丙沙星', 'CIP', '013ecf416db546c38f73090843759dd0', '2', 'R', '5', '1', '2022-03-02 15:06:56', '', NULL, '');
INSERT INTO `scdc_drug_fast_data` VALUES ('0ccfc4aeeb4a47b48a47be06b19ef1cc', '', '氨苄西林', 'AMP', '013ecf416db546c38f73090843759dd0', '8', 'S', '4', '1', '2022-03-02 15:06:56', '', NULL, '');

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
  `describes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 60 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '刘亦菲', 70, '女', '上海闵行', '这是db1的用户', 'bug菌.jpg');
INSERT INTO `user` VALUES (2, '杨幂', 20, '女', '北京朝阳', '这是db1的用户', './template/image/杨幂.jpg');
INSERT INTO `user` VALUES (3, '彭于晏', 30, '男', '河北邯郸', '这是db1的用户', './template/image/彭于晏.jpg');
INSERT INTO `user` VALUES (4, '胡歌', 22, '男', '江西南昌', '这是db1的用户', './template/image/胡歌.jpg');
INSERT INTO `user` VALUES (5, '刘德华', 30, '男', '香港新界', '这是db1的用户', './template/image/刘德华.jpg');
INSERT INTO `user` VALUES (44, '孙尚香', 20, '女', '上海闵行', '用户批量导入sheet1', './template/image/孙尚香.jpg');
INSERT INTO `user` VALUES (45, '后羿', 23, '男', '江西南昌', '用户批量导入sheet1', './template/image/后羿.jpg');
INSERT INTO `user` VALUES (46, '赵云', 50, '男', '上海闵行', '用户批量导入sheet2', './template/image/赵云.jpg');
INSERT INTO `user` VALUES (47, '典韦', 44, '男', '江西南昌', '用户批量导入sheet2', './template/image/典韦.jpg');
INSERT INTO `user` VALUES (59, '赣南脐橙', 999, '男', '江西赣州', '我测试新增用户', './template/image/脐橙.jpg');

SET FOREIGN_KEY_CHECKS = 1;

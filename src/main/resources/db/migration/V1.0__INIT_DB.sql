DROP TABLE IF EXISTS `cat`;
CREATE TABLE `cat`  (
                         `id` bigint(20) NOT NULL AUTO_INCREMENT,
                         `color` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `age` int(11) NULL DEFAULT NULL,
                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `cat` VALUES (4, 'red', '波斯猫', 30);
INSERT INTO `cat` VALUES (5, 'blue', '蓝猫', 50);
INSERT INTO `cat` VALUES (6, 'green', '蓝白', 80);
INSERT INTO `cat` VALUES (7, 'pink', '粉色猫', 90);
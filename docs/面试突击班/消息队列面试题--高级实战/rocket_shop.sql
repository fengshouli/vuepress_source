/*
 Navicat Premium Data Transfer

 Source Server         : MySQL5-7
 Source Server Type    : MySQL
 Source Server Version : 50740
 Source Host           : localhost:3306
 Source Schema         : rocket_shop

 Target Server Type    : MySQL
 Target Server Version : 50740
 File Encoding         : 65001

 Date: 13/09/2023 15:22:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for shop_coupon
-- ----------------------------
DROP TABLE IF EXISTS `shop_coupon`;
CREATE TABLE `shop_coupon`  (
  `coupon_id` bigint(50) NOT NULL AUTO_INCREMENT COMMENT '优惠券ID',
  `coupon_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '优惠券金额',
  `is_used` int(1) NULL DEFAULT NULL COMMENT '是否使用 0未使用 1已使用',
  `used_time` timestamp(0) NULL DEFAULT NULL COMMENT '使用时间',
  PRIMARY KEY (`coupon_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop_coupon
-- ----------------------------
INSERT INTO `shop_coupon` VALUES (1, 198.00, 1, '2023-08-31 08:57:52');
INSERT INTO `shop_coupon` VALUES (2, 111.00, 0, '2023-07-12 14:19:52');

-- ----------------------------
-- Table structure for shop_coupon_unique
-- ----------------------------
DROP TABLE IF EXISTS `shop_coupon_unique`;
CREATE TABLE `shop_coupon_unique`  (
  `order_id` bigint(50) UNSIGNED NOT NULL COMMENT '订单ID',
  UNIQUE INDEX `unique_coupon`(`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop_coupon_unique
-- ----------------------------
INSERT INTO `shop_coupon_unique` VALUES (154887);
INSERT INTO `shop_coupon_unique` VALUES (154888);

-- ----------------------------
-- Table structure for shop_goods
-- ----------------------------
DROP TABLE IF EXISTS `shop_goods`;
CREATE TABLE `shop_goods`  (
  `goods_id` bigint(50) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `goods_number` int(11) NULL DEFAULT NULL COMMENT '商品库存',
  `goods_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品价格',
  `goods_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品描述',
  `add_time` timestamp(0) NULL DEFAULT NULL COMMENT '添加时间',
  `version` int(11) NULL DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop_goods
-- ----------------------------
INSERT INTO `shop_goods` VALUES (13, '华为 HUAWEI Mate 40 RS', 98, 6999.00, '保时捷设计麒麟9000芯片 超感知徕卡电影五摄 8GB+256GB陶瓷黑5G全网通手机', '2021-05-08 10:28:58', 2);
INSERT INTO `shop_goods` VALUES (14, '诺基亚 新款105', 999, 119.00, '移动2G老人机 学生手机 备用功能机 蓝色(新105单卡) 直板按键 长待机', '2021-05-08 10:31:46', 0);

-- ----------------------------
-- Table structure for shop_goods_unique
-- ----------------------------
DROP TABLE IF EXISTS `shop_goods_unique`;
CREATE TABLE `shop_goods_unique`  (
  `order_id` bigint(50) UNSIGNED NOT NULL COMMENT '订单ID',
  UNIQUE INDEX `unique_goods`(`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop_goods_unique
-- ----------------------------
INSERT INTO `shop_goods_unique` VALUES (154864);
INSERT INTO `shop_goods_unique` VALUES (154865);
INSERT INTO `shop_goods_unique` VALUES (154866);
INSERT INTO `shop_goods_unique` VALUES (154867);
INSERT INTO `shop_goods_unique` VALUES (154868);
INSERT INTO `shop_goods_unique` VALUES (154869);
INSERT INTO `shop_goods_unique` VALUES (154870);
INSERT INTO `shop_goods_unique` VALUES (154871);
INSERT INTO `shop_goods_unique` VALUES (154872);
INSERT INTO `shop_goods_unique` VALUES (154873);
INSERT INTO `shop_goods_unique` VALUES (154874);
INSERT INTO `shop_goods_unique` VALUES (154875);
INSERT INTO `shop_goods_unique` VALUES (154876);
INSERT INTO `shop_goods_unique` VALUES (154877);
INSERT INTO `shop_goods_unique` VALUES (154878);
INSERT INTO `shop_goods_unique` VALUES (154879);
INSERT INTO `shop_goods_unique` VALUES (154880);
INSERT INTO `shop_goods_unique` VALUES (154881);
INSERT INTO `shop_goods_unique` VALUES (154882);
INSERT INTO `shop_goods_unique` VALUES (154883);
INSERT INTO `shop_goods_unique` VALUES (154884);
INSERT INTO `shop_goods_unique` VALUES (154885);
INSERT INTO `shop_goods_unique` VALUES (154886);
INSERT INTO `shop_goods_unique` VALUES (154887);
INSERT INTO `shop_goods_unique` VALUES (154888);
INSERT INTO `shop_goods_unique` VALUES (154889);
INSERT INTO `shop_goods_unique` VALUES (154890);
INSERT INTO `shop_goods_unique` VALUES (154891);
INSERT INTO `shop_goods_unique` VALUES (154892);
INSERT INTO `shop_goods_unique` VALUES (154893);

-- ----------------------------
-- Table structure for shop_order
-- ----------------------------
DROP TABLE IF EXISTS `shop_order`;
CREATE TABLE `shop_order`  (
  `order_id` bigint(50) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `user_id` bigint(50) NULL DEFAULT NULL COMMENT '用户ID',
  `order_status` int(1) NULL DEFAULT NULL COMMENT '订单状态 0未确认 1已确认 2已取消 3无效 4退款',
  `pay_status` int(1) NULL DEFAULT NULL COMMENT '支付状态 0未支付 1支付中 2已支付',
  `shipping_status` int(1) NULL DEFAULT NULL COMMENT '发货状态 0未发货 1已发货 2已收货',
  `goods_id` bigint(50) NULL DEFAULT NULL COMMENT '商品ID',
  `goods_number` int(11) NULL DEFAULT NULL COMMENT '商品数量',
  `coupon_id` bigint(50) NULL DEFAULT NULL COMMENT '优惠券ID',
  `coupon_paid` decimal(10, 2) NULL DEFAULT NULL COMMENT '优惠券',
  `add_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `confirm_time` timestamp(0) NULL DEFAULT NULL COMMENT '订单确认时间',
  `pay_time` timestamp(0) NULL DEFAULT NULL COMMENT '支付时间',
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `FK_shop_order`(`user_id`) USING BTREE,
  INDEX `FK_shop_order2`(`goods_id`) USING BTREE,
  INDEX `FK_shop_order3`(`coupon_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 154903 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop_order
-- ----------------------------
INSERT INTO `shop_order` VALUES (154900, 1, 0, 1, 0, 13, 1, 1, NULL, '2023-09-13 03:59:52', NULL, NULL);
INSERT INTO `shop_order` VALUES (154901, 1, 0, 1, 0, 13, 1, 1, NULL, '2023-09-13 04:03:18', NULL, NULL);
INSERT INTO `shop_order` VALUES (154902, 1, 0, 1, 0, 13, 1, 1, NULL, '2023-09-13 04:05:34', NULL, NULL);

-- ----------------------------
-- Table structure for shop_user
-- ----------------------------
DROP TABLE IF EXISTS `shop_user`;
CREATE TABLE `shop_user`  (
  `user_id` bigint(50) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `user_mobile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `user_reg_time` timestamp(0) NULL DEFAULT NULL COMMENT '注册时间',
  `user_money` decimal(10, 0) NULL DEFAULT NULL COMMENT '用户余额',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop_user
-- ----------------------------
INSERT INTO `shop_user` VALUES (1, 'lijin', '88888', '18888888888', '2021-05-08 10:42:36', 1680000);
INSERT INTO `shop_user` VALUES (2, 'laoyan', '88888', '18888888887', '2021-05-08 10:42:36', 680000);
INSERT INTO `shop_user` VALUES (3, 'bobo', '88888', '18888888886', '2021-05-08 10:42:36', 80000);

-- ----------------------------
-- Table structure for transaction_log
-- ----------------------------
DROP TABLE IF EXISTS `transaction_log`;
CREATE TABLE `transaction_log`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `business` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `foreign_key` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of transaction_log
-- ----------------------------
INSERT INTO `transaction_log` VALUES ('7F000001228C14DAD5DC406286070000', 'order', '154901');
INSERT INTO `transaction_log` VALUES ('7F00000135D814DAD5DC40649A040000', 'order', '154902');
INSERT INTO `transaction_log` VALUES ('7F0000014F7814DAD5DC405F61410000', 'order', '154900');

SET FOREIGN_KEY_CHECKS = 1;

/*
 Navicat MySQL Data Transfer

 Source Server         : RHEL7
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : rhel7:3306
 Source Schema         : myprice

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 14/08/2021 18:50:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_monitor_price
-- ----------------------------
DROP TABLE IF EXISTS `t_monitor_price`;
CREATE TABLE `t_monitor_price`  (
  `monitor_price_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '商品价格ID',
  `monitor_product_id` int(0) NULL DEFAULT NULL COMMENT '所监控商品信息',
  `monitor_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品价格',
  `current_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`monitor_price_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_monitor_price
-- ----------------------------

-- ----------------------------
-- Table structure for t_monitor_product
-- ----------------------------
DROP TABLE IF EXISTS `t_monitor_product`;
CREATE TABLE `t_monitor_product`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `product_id` int(0) NULL DEFAULT NULL COMMENT '产品信息',
  `current_price` int(0) NULL DEFAULT NULL COMMENT '当前价格',
  `source_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品来源URL/**查看信息时，用ifream展示商品详情*/',
  `refresh_frequency` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '刷新频率',
  `last_update_date` datetime(0) NULL DEFAULT NULL COMMENT '最后更新日期',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_monitor_product
-- ----------------------------

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product`  (
  `product_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '产品编号',
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `product_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品描述',
  `status` int(0) NULL DEFAULT NULL COMMENT '产品状态',
  `product_type_id` int(0) NULL DEFAULT NULL COMMENT '商品分类代码',
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_product
-- ----------------------------

-- ----------------------------
-- Table structure for t_product_type
-- ----------------------------
DROP TABLE IF EXISTS `t_product_type`;
CREATE TABLE `t_product_type`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `parent_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'parent_id',
  `product_type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品分类名称',
  `status` int(0) NULL DEFAULT NULL COMMENT '状态',
  `order_num` int(0) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品分类' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_product_type
-- ----------------------------
INSERT INTO `t_product_type` VALUES (1, '0', 'qq', 1, 1);
INSERT INTO `t_product_type` VALUES (2, '0', 'c', 1, 2);
INSERT INTO `t_product_type` VALUES (3, '2', '22', 1, 3);
INSERT INTO `t_product_type` VALUES (4, '3333', '11', 1, 2);
INSERT INTO `t_product_type` VALUES (6, '1', '1', 1, 1);
INSERT INTO `t_product_type` VALUES (7, '6', '啊啊啊啊', 1, 1);
INSERT INTO `t_product_type` VALUES (10, '6', '1', 1, 1);
INSERT INTO `t_product_type` VALUES (11, '10', '2', 1, 2);
INSERT INTO `t_product_type` VALUES (12, '7', '1', 1, 1);
INSERT INTO `t_product_type` VALUES (13, '7', '1', 1, 1);
INSERT INTO `t_product_type` VALUES (14, '7', '1', 1, 1);

-- ----------------------------
-- Table structure for t_sys_area
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_area`;
CREATE TABLE `t_sys_area`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增列',
  `area_code` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '区代码',
  `city_code` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父级市代码',
  `area_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '市名称',
  `short_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '简称',
  `lng` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经度',
  `lat` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '纬度',
  `sort` int(0) NULL DEFAULT NULL COMMENT '排序',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `memo` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `data_state` int(0) NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `Index_1`(`area_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2013 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '地区设置' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_sys_area
-- ----------------------------
INSERT INTO `t_sys_area` VALUES (1975, '500101', '500100', '万州区', '万州', '108.380249', '30.807808', 28, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (1976, '500102', '500100', '涪陵区', '涪陵', '107.394905', '29.703651', 11, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (1977, '500103', '500100', '渝中区', '渝中', '106.562881', '29.556742', 37, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (1978, '500104', '500100', '大渡口区', '大渡口', '106.48613', '29.481003', 6, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (1979, '500105', '500100', '江北区', '江北', '106.532845', '29.575352', 13, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (1980, '500106', '500100', '沙坪坝区', '沙坪坝', '106.454201', '29.541224', 24, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (1981, '500107', '500100', '九龙坡区', '九龙坡', '106.480988', '29.523493', 15, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (1982, '500108', '500100', '南岸区', '南岸', '106.560814', '29.523993', 18, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (1983, '500109', '500100', '北碚区', '北碚', '106.437866', '29.82543', 2, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (1984, '500112', '500100', '渝北区', '渝北', '106.512848', '29.601452', 35, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (1985, '500113', '500100', '巴南区', '巴南', '106.519424', '29.38192', 1, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (1986, '500114', '500100', '黔江区', '黔江', '108.782578', '29.527548', 21, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (1987, '500115', '500100', '长寿区', '长寿', '107.074852', '29.833672', 4, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (1988, '500222', '500100', '綦江区', '綦江', '106.651421', '29.028091', 22, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (1989, '500223', '500100', '潼南县', '潼南', '105.84182', '30.189554', 27, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (1990, '500224', '500100', '铜梁县', '铜梁', '106.054947', '29.839945', 26, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (1991, '500225', '500100', '大足区', '大足', '105.715317', '29.700499', 7, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (1992, '500226', '500100', '荣昌县', '荣昌', '105.594063', '29.403627', 23, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (1993, '500227', '500100', '璧山县', '璧山', '106.231125', '29.59358', 3, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (1994, '500228', '500100', '梁平县', '梁平', '107.800034', '30.672169', 17, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (1995, '500229', '500100', '城口县', '城口', '108.664902', '31.946293', 5, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (1996, '500230', '500100', '丰都县', '丰都', '107.732483', '29.866425', 9, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (1997, '500231', '500100', '垫江县', '垫江', '107.348694', '30.330011', 8, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (1998, '500232', '500100', '武隆县', '武隆', '107.756554', '29.323759', 29, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (1999, '500233', '500100', '忠县', '忠县', '108.037521', '30.291536', 38, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (2000, '500234', '500100', '开县', '开县', '108.413315', '31.167734', 16, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (2001, '500235', '500100', '云阳县', '云阳', '108.697701', '30.930529', 36, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (2002, '500236', '500100', '奉节县', '奉节', '109.465775', '31.019966', 10, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (2003, '500237', '500100', '巫山县', '巫山', '109.878929', '31.074842', 30, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (2004, '500238', '500100', '巫溪县', '巫溪', '109.628914', '31.396601', 31, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (2005, '500240', '500100', '石柱土家族自治县', '石柱', '108.11245', '29.998529', 25, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (2006, '500241', '500100', '秀山土家族苗族自治县', '秀山', '108.99604', '28.444773', 32, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (2007, '500242', '500100', '酉阳土家族苗族自治县', '酉阳', '108.767204', '28.839828', 34, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (2008, '500243', '500100', '彭水苗族土家族自治县', '彭水', '108.16655', '29.293856', 20, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (2009, '500381', '500100', '江津区', '江津', '106.253159', '29.283386', 14, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (2010, '500382', '500100', '合川区', '合川', '106.265556', '29.990993', 12, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (2011, '500383', '500100', '永川区', '永川', '105.894714', '29.348747', 33, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);
INSERT INTO `t_sys_area` VALUES (2012, '500384', '500100', '南川区', '南川', '107.098152', '29.156647', 19, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);

-- ----------------------------
-- Table structure for t_sys_city
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_city`;
CREATE TABLE `t_sys_city`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增列',
  `city_code` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '市代码',
  `city_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '市名称',
  `short_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '简称',
  `province_code` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省代码',
  `lng` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经度',
  `lat` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '纬度',
  `sort` int(0) NULL DEFAULT NULL COMMENT '排序',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `memo` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `data_state` int(0) NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `Index_1`(`city_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 256 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '城市设置' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_sys_city
-- ----------------------------
INSERT INTO `t_sys_city` VALUES (255, '500100', '重庆市', '重庆', '500000', '106.504959', '29.533155', 1, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);

-- ----------------------------
-- Table structure for t_sys_department
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_department`;
CREATE TABLE `t_sys_department`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `parent_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父id',
  `dept_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `leader` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门负责人',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `status` int(0) NULL DEFAULT NULL COMMENT '状态',
  `order_num` int(0) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_sys_department
-- ----------------------------
INSERT INTO `t_sys_department` VALUES (1, '0', 'v2', 'v2', '13012345678', 'v2@qq.com', 1, 1);
INSERT INTO `t_sys_department` VALUES (2, '1', '技术部门', 'x某某', '13012345678', 'v2@qq.com', 1, 2);
INSERT INTO `t_sys_department` VALUES (3, '1', 'xx', '', '', '', 1, NULL);
INSERT INTO `t_sys_department` VALUES (4, '2', '开发一小组', 'b某某', '13012345678', 'v2@qq.com', 1, 4);
INSERT INTO `t_sys_department` VALUES (5, '3', '销售部门', 'd某某', '13012345678', 'v2@qq.com', 1, 5);
INSERT INTO `t_sys_department` VALUES (6, '5', '销售一组', 'e某某', '13012345678', 'v2@qq.com', 1, 6);
INSERT INTO `t_sys_department` VALUES (7, '4', 'Team1', '', '', '', 1, NULL);
INSERT INTO `t_sys_department` VALUES (8, '4', 'Team2', '', '', '', 1, NULL);

-- ----------------------------
-- Table structure for t_sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_dict_data`;
CREATE TABLE `t_sys_dict_data`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `dict_sort` int(0) NULL DEFAULT 0 COMMENT '字典排序',
  `dict_label` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '表格回显样式',
  `is_default` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典数据表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_sys_dict_data
-- ----------------------------
INSERT INTO `t_sys_dict_data` VALUES ('331043380933038080', 1, '一般', '1', 'sys_notice_type', '', 'info', 'Y', '0', 'admin', '2019-09-09 22:15:03', 'admin', '2019-09-09 22:15:43', '');
INSERT INTO `t_sys_dict_data` VALUES ('331043525137403904', 2, '重要', '2', 'sys_notice_type', '', 'important', 'N', '0', 'admin', '2019-09-09 22:15:37', 'admin', '2020-12-27 13:57:22', '');
INSERT INTO `t_sys_dict_data` VALUES ('340080322395901952', 1, '开启', '0', 'sys_province_state', '', 'info', 'Y', '0', 'admin', '2019-10-04 20:44:37', 'admin', '2019-10-04 20:46:41', '');
INSERT INTO `t_sys_dict_data` VALUES ('340080779201744896', 2, '关闭', '-1', 'sys_province_state', '', 'important', 'N', '0', 'admin', '2019-10-04 20:46:26', 'admin', '2021-06-20 10:46:56', '');
INSERT INTO `t_sys_dict_data` VALUES ('373494384659927040', 0, 'GET请求', '1', 'sys_inter_url_type', '', 'primary', 'Y', '0', 'admin', '2020-01-05 01:40:11', 'admin', '2020-12-27 14:27:28', '');
INSERT INTO `t_sys_dict_data` VALUES ('373494483465146368', 1, 'POST请求', '2', 'sys_inter_url_type', '', 'info', 'N', '0', 'admin', '2020-01-05 01:40:34', 'admin', '2020-12-27 14:26:59', '');
INSERT INTO `t_sys_dict_data` VALUES ('506431838588375040', 0, 'DELETE请求', '3', 'sys_inter_url_type', '', 'default', 'N', '0', 'admin', '2021-01-05 13:46:10', 'admin', '2021-01-05 13:48:43', '');
INSERT INTO `t_sys_dict_data` VALUES ('506432620712824832', 0, 'PUT请求', '4', 'sys_inter_url_type', '', 'default', 'N', '0', 'admin', '2021-01-05 13:49:16', 'admin', '2021-01-05 13:49:20', '');
INSERT INTO `t_sys_dict_data` VALUES ('566543556676816896', 3, '紧急', '3', 'sys_notice_type', '2', 'default', 'Y', '1', 'admin', '2021-06-20 10:48:40', 'admin', '2021-06-20 10:49:02', '');

-- ----------------------------
-- Table structure for t_sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_dict_type`;
CREATE TABLE `t_sys_dict_type`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `dict_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `dict_type`(`dict_type`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典类型表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_sys_dict_type
-- ----------------------------
INSERT INTO `t_sys_dict_type` VALUES ('340079827459641344', '省份状态', 'sys_province_state', '0', 'admin', '2019-10-04 20:42:39', '', '2019-10-04 20:42:39', '省份状态');
INSERT INTO `t_sys_dict_type` VALUES ('373493952487231488', '拦截器类型', 'sys_inter_url_type', '0', 'admin', '2020-01-05 01:38:28', 'admin', '2020-03-29 23:23:43', '拦截器类型');
INSERT INTO `t_sys_dict_type` VALUES ('566570425459544064', 'Gender', 'sys_gender', '0', 'admin', '2021-06-20 12:35:26', 'admin', '2021-06-20 12:35:46', 'gender');
INSERT INTO `t_sys_dict_type` VALUES ('6', '通知类型', 'sys_notice_type', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2020-12-27 14:26:42', '通知类型列表');

-- ----------------------------
-- Table structure for t_sys_email
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_email`;
CREATE TABLE `t_sys_email`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '主键',
  `receivers_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '接收人电子邮件',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '邮件标题',
  `content` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT '内容',
  `send_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '发送人id',
  `send_user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '发送人账号',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '电子邮件' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_sys_email
-- ----------------------------

-- ----------------------------
-- Table structure for t_sys_file
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_file`;
CREATE TABLE `t_sys_file`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '主键',
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '文件名字',
  `bucket_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '桶名',
  `file_size` bigint(0) NULL DEFAULT NULL COMMENT '文件大小',
  `file_suffix` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '后缀',
  `create_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建人id',
  `create_user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建人名字',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改人',
  `update_user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改人名字',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '文件信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_sys_file
-- ----------------------------
INSERT INTO `t_sys_file` VALUES ('503885495013609472', '503895116063313920.png', 'v2-cloud', 48831, 'image/png', '1', 'admin', '2020-12-29 13:07:54', '1', 'admin', '2020-12-29 13:46:08');
INSERT INTO `t_sys_file` VALUES ('503885528857448448', '503895039806672896.png', 'v2-cloud', 71460, 'image/png', '1', 'admin', '2020-12-29 13:08:02', '1', 'admin', '2020-12-29 13:45:50');

-- ----------------------------
-- Table structure for t_sys_inter_url
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_inter_url`;
CREATE TABLE `t_sys_inter_url`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `inter_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '拦截名称',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '拦截url',
  `type` int(0) NULL DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '拦截url表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_sys_inter_url
-- ----------------------------
INSERT INTO `t_sys_inter_url` VALUES ('411495038321823744', '字典表新增', '/DictDataController/add', 2);
INSERT INTO `t_sys_inter_url` VALUES ('506433268967673856', '字典表修改', '/DictDataController/edit', 2);
INSERT INTO `t_sys_inter_url` VALUES ('506434978159136768', '字典表删除', '/DictDataController/remove', 3);
INSERT INTO `t_sys_inter_url` VALUES ('506435565655298048', '字典表状态修改', '/DictDataController/updateDefault', 4);
INSERT INTO `t_sys_inter_url` VALUES ('506435921147727872', '字典表状态修改2', '/DictDataController/updateEnable', 4);
INSERT INTO `t_sys_inter_url` VALUES ('506436031403397120', '字典表类型新增', '/DictTypeController/add', 2);
INSERT INTO `t_sys_inter_url` VALUES ('506436148680331264', '字典表类型修改', '/DictTypeController/edit', 2);
INSERT INTO `t_sys_inter_url` VALUES ('506436165776314368', '字典表类型删除', '/DictTypeController/remove', 3);
INSERT INTO `t_sys_inter_url` VALUES ('506436180578013184', '字典表类型状态修改', '/DictTypeController/updateEnable', 4);
INSERT INTO `t_sys_inter_url` VALUES ('506436662134444032', '邮件新增', '/EmailController/add', 2);
INSERT INTO `t_sys_inter_url` VALUES ('506436757722632192', '邮件删除', '/EmailController/remove', 3);
INSERT INTO `t_sys_inter_url` VALUES ('506437010966319104', '日志删除', '/LogController/remove', 3);
INSERT INTO `t_sys_inter_url` VALUES ('506437420099702784', 'oss新增', '/oss/bucket/', 2);
INSERT INTO `t_sys_inter_url` VALUES ('506437439112482816', 'oss删除', '/oss/bucket/', 3);
INSERT INTO `t_sys_inter_url` VALUES ('506437964436475904', '权限新增', '/PermissionController/add', 2);
INSERT INTO `t_sys_inter_url` VALUES ('506438040823140352', '权限保存', '/PermissionController/edit', 2);
INSERT INTO `t_sys_inter_url` VALUES ('506438121399914496', '权限删除', '/PermissionController/remove', 3);
INSERT INTO `t_sys_inter_url` VALUES ('506438208599494656', '权限授权', '/PermissionController/saveRolePower', 4);
INSERT INTO `t_sys_inter_url` VALUES ('506438306276446208', '权限状态修改', '/PermissionController/updateVisible', 4);
INSERT INTO `t_sys_inter_url` VALUES ('506438447226032128', '定时器新增', '/SysQuartzJobController/add', 2);
INSERT INTO `t_sys_inter_url` VALUES ('506438589874311168', ' 任务调度状态修改', '/SysQuartzJobController/changeStatus', 4);
INSERT INTO `t_sys_inter_url` VALUES ('506438725388079104', '定时器保存', '/SysQuartzJobController/edit', 2);
INSERT INTO `t_sys_inter_url` VALUES ('506438870959788032', '定时器修改', '/SysQuartzJobController/remove', 3);
INSERT INTO `t_sys_inter_url` VALUES ('506439003516571648', '定时任务日志删除', '/SysQuartzJobLogController/remove', 3);
INSERT INTO `t_sys_inter_url` VALUES ('506439171481669632', '角色新增', '/RoleController/add', 2);
INSERT INTO `t_sys_inter_url` VALUES ('506439186778296320', '角色修改', '/RoleController/edit', 4);
INSERT INTO `t_sys_inter_url` VALUES ('506439297122045952', '角色删除', '/RoleController/remove', 3);
INSERT INTO `t_sys_inter_url` VALUES ('506439669773373440', '地区新增', '/SysAreaController/add', 2);
INSERT INTO `t_sys_inter_url` VALUES ('506439687859212288', '地区修改', '/SysAreaController/edit', 2);
INSERT INTO `t_sys_inter_url` VALUES ('506439835490324480', '地区删除', '/SysAreaController/remove', 3);
INSERT INTO `t_sys_inter_url` VALUES ('506440103976112128', 'City新增', '/SysCityController/add', 2);
INSERT INTO `t_sys_inter_url` VALUES ('506440145147400192', 'City修改', ' /SysCityController/edit', 2);
INSERT INTO `t_sys_inter_url` VALUES ('506440217188765696', 'City删除', '/SysCityController/remove', 3);
INSERT INTO `t_sys_inter_url` VALUES ('506440386873528320', '部门新增', '/SysDepartmentController/add', 2);
INSERT INTO `t_sys_inter_url` VALUES ('506440448223612928', '部门修改', '/SysDepartmentController/edit', 4);
INSERT INTO `t_sys_inter_url` VALUES ('506440515110178816', '部门删除', '/SysDepartmentController/remove', 3);
INSERT INTO `t_sys_inter_url` VALUES ('506440574635741184', '部门状态', '/SysDepartmentController/updateVisible', 4);
INSERT INTO `t_sys_inter_url` VALUES ('506440668508459008', '拦截器url新增', '/SysInterUrlController/add', 2);
INSERT INTO `t_sys_inter_url` VALUES ('506440708056551424', '拦截器url修改', '/SysInterUrlController/edit', 2);
INSERT INTO `t_sys_inter_url` VALUES ('506440802856210432', '拦截器url删除', '/SysInterUrlController/remove', 3);
INSERT INTO `t_sys_inter_url` VALUES ('506441001783660544', '公告新增', '/SysNoticeController/add', 2);
INSERT INTO `t_sys_inter_url` VALUES ('506441051263864832', '公告修改', '/SysNoticeController/edit', 2);
INSERT INTO `t_sys_inter_url` VALUES ('506441105743679488', '公告删除', '/SysNoticeController/remove', 3);
INSERT INTO `t_sys_inter_url` VALUES ('506441242591236096', '职位新增', '/SysPositionController/add', 2);
INSERT INTO `t_sys_inter_url` VALUES ('506441287038275584', '职位修改', '/SysPositionController/edit', 2);
INSERT INTO `t_sys_inter_url` VALUES ('506441350200299520', '职位删除', '/SysPositionController/remove', 3);
INSERT INTO `t_sys_inter_url` VALUES ('506441420677189632', '职位状态修改', '/SysPositionController/updateVisible', 4);
INSERT INTO `t_sys_inter_url` VALUES ('506441780003213312', '省份新增', '/SysProvinceController/add', 2);
INSERT INTO `t_sys_inter_url` VALUES ('506441807383629824', '省份修改', '/SysProvinceController/edit', 2);
INSERT INTO `t_sys_inter_url` VALUES ('506441871850082304', '省份删除', '/SysProvinceController/remove', 3);
INSERT INTO `t_sys_inter_url` VALUES ('506441980012793856', '街道新增', '/SysStreetController/add', 2);
INSERT INTO `t_sys_inter_url` VALUES ('506442015706320896', '街道修改', '/SysStreetController/edit', 2);
INSERT INTO `t_sys_inter_url` VALUES ('506442092445306880', '街道删除', '/SysStreetController/remove', 3);
INSERT INTO `t_sys_inter_url` VALUES ('506442186552905728', '用户新增', '/UserController/add', 2);
INSERT INTO `t_sys_inter_url` VALUES ('506442212696002560', '用户修改', '/UserController/edit', 2);
INSERT INTO `t_sys_inter_url` VALUES ('506442271252680704', '用户修改密码', '/UserController/editPwd', 2);
INSERT INTO `t_sys_inter_url` VALUES ('506442344443285504', '用户删除', '/UserController/remove', 3);
INSERT INTO `t_sys_inter_url` VALUES ('506444610625736704', '拦截器url复制', '/SysInterUrlController/copy/', 3);

-- ----------------------------
-- Table structure for t_sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_notice`;
CREATE TABLE `t_sys_notice`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '主键',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '内容',
  `type` int(0) NULL DEFAULT NULL COMMENT '类型',
  `create_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建人name',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '发信时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '公告' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_sys_notice
-- ----------------------------
INSERT INTO `t_sys_notice` VALUES ('566542840990142464', 'test', '<img src=\"http://img.baidu.com/hi/jx2/j_0014.gif\"/>test <img src=\"http://img.baidu.com/hi/jx2/j_0014.gif\"/>', 2, '1', 'admin', '2021-06-20 10:45:49');

-- ----------------------------
-- Table structure for t_sys_notice_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_notice_user`;
CREATE TABLE `t_sys_notice_user`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `notice_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公告id',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `state` int(0) NULL DEFAULT NULL COMMENT '0未阅读 1 阅读',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '公告_用户外键' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_sys_notice_user
-- ----------------------------
INSERT INTO `t_sys_notice_user` VALUES ('330381411037089792', '330381411007729664', '1', 1);
INSERT INTO `t_sys_notice_user` VALUES ('330381411045478400', '330381411007729664', '488294747442511872', 0);
INSERT INTO `t_sys_notice_user` VALUES ('330381806375407616', '330381806358630400', '1', 1);
INSERT INTO `t_sys_notice_user` VALUES ('330381806379601920', '330381806358630400', '488294747442511872', 0);
INSERT INTO `t_sys_notice_user` VALUES ('330622143622680576', '330622143597514752', '1', 1);
INSERT INTO `t_sys_notice_user` VALUES ('330622143626874880', '330622143597514752', '488294747442511872', 0);
INSERT INTO `t_sys_notice_user` VALUES ('354984345649418240', '354984345632641024', '1', 1);
INSERT INTO `t_sys_notice_user` VALUES ('373478037158760448', '373478036928073728', '1', 1);
INSERT INTO `t_sys_notice_user` VALUES ('373478037162954752', '373478036928073728', '368026921239449600', 0);
INSERT INTO `t_sys_notice_user` VALUES ('373478037171343360', '373478036928073728', '368026937181999104', 0);
INSERT INTO `t_sys_notice_user` VALUES ('373478037175537664', '373478036928073728', '368027013392502784', 0);
INSERT INTO `t_sys_notice_user` VALUES ('373478037183926272', '373478036928073728', '368027030899527680', 0);
INSERT INTO `t_sys_notice_user` VALUES ('373478037192314880', '373478036928073728', '368027048402358272', 0);
INSERT INTO `t_sys_notice_user` VALUES ('373478037204897792', '373478036928073728', '368027066563694592', 0);
INSERT INTO `t_sys_notice_user` VALUES ('373478037213286400', '373478036928073728', '368027087866564608', 0);
INSERT INTO `t_sys_notice_user` VALUES ('373478037217480704', '373478036928073728', '368027104895438848', 0);
INSERT INTO `t_sys_notice_user` VALUES ('373478037225869312', '373478036928073728', '368027130728157184', 0);
INSERT INTO `t_sys_notice_user` VALUES ('373478037230063616', '373478036928073728', '368027151624179712', 0);
INSERT INTO `t_sys_notice_user` VALUES ('373478037238452224', '373478036928073728', '368382463233363968', 0);
INSERT INTO `t_sys_notice_user` VALUES ('502750147499921408', '502750147395063808', '1', 0);
INSERT INTO `t_sys_notice_user` VALUES ('502750147508310016', '502750147395063808', '433236479427350528', 0);
INSERT INTO `t_sys_notice_user` VALUES ('502758207983325184', '502758207907827712', '1', 0);
INSERT INTO `t_sys_notice_user` VALUES ('502758207991713792', '502758207907827712', '433236479427350528', 0);
INSERT INTO `t_sys_notice_user` VALUES ('502820822130495488', '502820822042415104', '1', 0);
INSERT INTO `t_sys_notice_user` VALUES ('502820822138884096', '502820822042415104', '433236479427350528', 0);
INSERT INTO `t_sys_notice_user` VALUES ('566542841166303232', '566542840990142464', '1', 1);
INSERT INTO `t_sys_notice_user` VALUES ('566542841204051968', '566542840990142464', '433236479427350528', 0);

-- ----------------------------
-- Table structure for t_sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_oper_log`;
CREATE TABLE `t_sys_oper_log`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '标题',
  `method` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '方法',
  `oper_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '操作人',
  `oper_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'url',
  `oper_param` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '参数',
  `error_msg` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `oper_time` date NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '日志记录表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_sys_oper_log
-- ----------------------------

-- ----------------------------
-- Table structure for t_sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_permission`;
CREATE TABLE `t_sys_permission`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名称',
  `descripion` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限描述',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '授权链接',
  `is_blank` int(0) NULL DEFAULT 0 COMMENT '是否跳转 0 不跳转 1跳转',
  `pid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父节点id',
  `perms` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限标识',
  `type` int(0) NULL DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(0) NULL DEFAULT NULL COMMENT '排序',
  `visible` int(0) NULL DEFAULT NULL COMMENT '是否可见',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_sys_permission
-- ----------------------------
INSERT INTO `t_sys_permission` VALUES ('10', '角色集合', '角色集合', '/RoleController/list', 0, '9', 'system:role:list', 2, '', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('11', '角色添加', '角色添加', '/RoleController/add', 0, '9', 'system:role:add', 2, 'entypo-plus-squared', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('12', '角色删除', '角色删除', '/RoleController/remove', 0, '9', 'system:role:remove', 2, 'entypo-trash', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('13', '角色修改', '角色修改', '/RoleController/edit', 0, '9', 'system:role:edit', 2, 'fa fa-wrench', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('14', '权限展示', '权限展示', '/PermissionController/view', 0, '411522822607867904', 'system:permission:view', 1, 'fa fa-key', 3, 0);
INSERT INTO `t_sys_permission` VALUES ('15', '权限集合', '权限集合', '/PermissionController/list', 0, '14', 'system:permission:list', 2, '', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('16', '权限添加', '权限添加', '/permissionController/add', 0, '14', 'system:permission:add', 2, 'entypo-plus-squared', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('17', '权限删除', '权限删除', '/PermissionController/remove', 0, '14', 'system:permission:remove', 2, 'entypo-trash', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('18', '权限修改', '权限修改', '/PermissionController/edit', 0, '14', 'system:permission:edit', 2, 'fa fa-wrench', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('19', '文件管理', '文件管理', '/FileController/view', 0, '592059865673760768', 'system:file:view', 1, 'fa fa-file-image-o', 4, 0);
INSERT INTO `t_sys_permission` VALUES ('20', '文件添加', '文件添加', '/FileController/add', 0, '19', 'system:file:add', 2, 'entypo-plus-squared', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('21', '文件删除', '文件删除', '/FileController/remove', 0, '19', 'system:file:remove', 2, 'entypo-trash', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('22', '文件修改', '文件修改', '/FileController/edit', 0, '19', 'system:file:edit', 2, 'fa fa-wrench', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('23', '文件集合', '文件集合', '/FileController/list', 0, '19', 'system:file:list', 2, '', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('330365026642825216', '公告管理', '公告展示', '/SysNoticeController/view', 0, '592059865673760768', 'gen:sysNotice:view', 1, 'fa fa-telegram', 10, 0);
INSERT INTO `t_sys_permission` VALUES ('3303650266428252171', '公告集合', '公告集合', '/SysNoticeController/list', 0, '330365026642825216', 'gen:sysNotice:list', 2, '', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('3303650266428252182', '公告添加', '公告添加', '/SysNoticeController/add', 0, '330365026642825216', 'gen:sysNotice:add', 2, 'entypo-plus-squared', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('3303650266428252193', '公告删除', '公告删除', '/SysNoticeController/remove', 0, '330365026642825216', 'gen:sysNotice:remove', 2, 'entypo-trash', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('3303650266428252204', '公告修改', '公告修改', '/SysNoticeController/edit', 0, '330365026642825216', 'gen:sysNotice:edit', 2, 'fa fa-wrench', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('331778807298134016', '定时器表达式', NULL, 'https://www.bejson.com/othertools/cron/', 1, '617766548966211584', '#', 1, 'layui-icon fa fa-flash', 12, 0);
INSERT INTO `t_sys_permission` VALUES ('332157860920299520', '定时任务', '定时任务调度表展示', '/SysQuartzJobController/view', 0, '592059865673760768', 'gen:sysQuartzJob:view', 1, 'fa fa-hourglass-1', 13, 0);
INSERT INTO `t_sys_permission` VALUES ('3321578609202995211', '定时任务调度表集合', '定时任务调度表集合', '/SysQuartzJobController/list', 0, '332157860920299520', 'gen:sysQuartzJob:list', 2, '', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('3321578609202995222', '定时任务调度表添加', '定时任务调度表添加', '/SysQuartzJobController/add', 0, '332157860920299520', 'gen:sysQuartzJob:add', 2, 'entypo-plus-squared', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('3321578609202995233', '定时任务调度表删除', '定时任务调度表删除', '/SysQuartzJobController/remove', 0, '332157860920299520', 'gen:sysQuartzJob:remove', 2, 'entypo-trash', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('3321578609202995244', '定时任务调度表修改', '定时任务调度表修改', '/SysQuartzJobController/edit', 0, '332157860920299520', 'gen:sysQuartzJob:edit', 2, 'fa fa-wrench', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('332857281479839744', '定时任务日志', '定时任务日志', '/SysQuartzJobLogController/view', 0, '592059865673760768', 'gen:sysQuartzJobLog:view', 1, 'fa fa-database', 14, 0);
INSERT INTO `t_sys_permission` VALUES ('3328572814798397451', '定时任务调度日志表集合', '定时任务调度日志表集合', '/SysQuartzJobLogController/list', 0, '332857281479839744', 'gen:sysQuartzJobLog:list', 2, '', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('3328572814798397473', '定时任务调度日志表删除', '定时任务调度日志表删除', '/SysQuartzJobLogController/remove', 0, '332857281479839744', 'gen:sysQuartzJobLog:remove', 2, 'entypo-trash', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('335330315113467904', 'Json工具', NULL, 'https://www.bejson.com/jsonviewernew/', 1, '617766548966211584', '#', 1, 'layui-icon fa fa-retweet', 10, 0);
INSERT INTO `t_sys_permission` VALUES ('340067579836108800', '省份管理', NULL, '', 0, '0', '', 0, 'layui-icon layui-icon layui-icon-website', 4, 0);
INSERT INTO `t_sys_permission` VALUES ('340068151804956672', '省份表管理', '省份表展示', '/SysProvinceController/view', 0, '340067579836108800', 'gen:sysProvince:view', 1, 'fa fa-quora', 2, 0);
INSERT INTO `t_sys_permission` VALUES ('3400681518049566731', '省份表集合', '省份表集合', '/SysProvinceController/list', 0, '340068151804956672', 'gen:sysProvince:list', 2, '', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('3400681518049566742', '省份表添加', '省份表添加', '/SysProvinceController/add', 0, '340068151804956672', 'gen:sysProvince:add', 2, 'entypo-plus-squared', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('3400681518049566753', '省份表删除', '省份表删除', '/SysProvinceController/remove', 0, '340068151804956672', 'gen:sysProvince:remove', 2, 'entypo-trash', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('3400681518049566764', '省份表修改', '省份表修改', '/SysProvinceController/edit', 0, '340068151804956672', 'gen:sysProvince:edit', 2, 'fa fa-wrench', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('340088022018166784', '城市表管理', '城市设置展示', '/SysCityController/view', 0, '340067579836108800', 'gen:sysCity:view', 1, 'fa fa-quora', 3, 0);
INSERT INTO `t_sys_permission` VALUES ('3400880220181667851', '城市设置集合', '城市设置集合', '/SysCityController/list', 0, '340088022018166784', 'gen:sysCity:list', 2, '', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('3400880220181667862', '城市设置添加', '城市设置添加', '/SysCityController/add', 0, '340088022018166784', 'gen:sysCity:add', 2, 'entypo-plus-squared', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('3400880220181667873', '城市设置删除', '城市设置删除', '/SysCityController/remove', 0, '340088022018166784', 'gen:sysCity:remove', 2, 'entypo-trash', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('3400880220181667884', '城市设置修改', '城市设置修改', '/SysCityController/edit', 0, '340088022018166784', 'gen:sysCity:edit', 2, 'fa fa-wrench', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('340096183135506432', '地区设置管理', '地区设置展示', '/SysAreaController/view', 0, '340067579836108800', 'gen:sysArea:view', 1, 'fa fa-quora', 4, 0);
INSERT INTO `t_sys_permission` VALUES ('3400961831355064331', '地区设置集合', '地区设置集合', '/SysAreaController/list', 0, '340096183135506432', 'gen:sysArea:list', 2, '', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('3400961831355064342', '地区设置添加', '地区设置添加', '/SysAreaController/add', 0, '340096183135506432', 'gen:sysArea:add', 2, 'entypo-plus-squared', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('3400961831355064353', '地区设置删除', '地区设置删除', '/SysAreaController/remove', 0, '340096183135506432', 'gen:sysArea:remove', 2, 'entypo-trash', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('3400961831355064364', '地区设置修改', '地区设置修改', '/SysAreaController/edit', 0, '340096183135506432', 'gen:sysArea:edit', 2, 'fa fa-wrench', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('340127412270534656', '街道设置管理', '街道设置展示', '/SysStreetController/view', 0, '340067579836108800', 'gen:sysStreet:view', 1, 'fa fa-quora', 5, 0);
INSERT INTO `t_sys_permission` VALUES ('3401274122705346571', '街道设置集合', '街道设置集合', '/SysStreetController/list', 0, '340127412270534656', 'gen:sysStreet:list', 2, '', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('3401274122705346582', '街道设置添加', '街道设置添加', '/SysStreetController/add', 0, '340127412270534656', 'gen:sysStreet:add', 2, 'entypo-plus-squared', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('3401274122705346593', '街道设置删除', '街道设置删除', '/SysStreetController/remove', 0, '340127412270534656', 'gen:sysStreet:remove', 2, 'entypo-trash', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('3401274122705346604', '街道设置修改', '街道设置修改', '/SysStreetController/edit', 0, '340127412270534656', 'gen:sysStreet:edit', 2, 'fa fa-wrench', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('340301160042860544', '省份联动', '省份联动', '/ProvinceLinkageController/view', 0, '340067579836108800', '#', 1, 'fa fa-etsy', 1, 0);
INSERT INTO `t_sys_permission` VALUES ('340381240911859712', 'JavaScript格式化', NULL, '/static/tool/htmlformat/javascriptFormat.html', 0, '617766548966211584', '#', 1, 'layui-icon layui-icon fa fa-magic', 11, 0);
INSERT INTO `t_sys_permission` VALUES ('373489907429150720', 'URL拦截管理', '拦截url表展示', '/SysInterUrlController/view', 0, '617766548966211584', 'gen:sysInterUrl:view', 1, 'fa fa-hand-stop-o', 16, 0);
INSERT INTO `t_sys_permission` VALUES ('3734899074291507211', '拦截url表集合', '拦截url表集合', '/SysInterUrlController/list', 0, '373489907429150720', 'gen:sysInterUrl:list', 2, '', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('3734899074291507222', '拦截url表添加', '拦截url表添加', '/SysInterUrlController/add', 0, '373489907429150720', 'gen:sysInterUrl:add', 2, 'entypo-plus-squared', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('3734899074291507233', '拦截url表删除', '拦截url表删除', '/SysInterUrlController/remove', 0, '373489907429150720', 'gen:sysInterUrl:remove', 2, 'entypo-trash', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('3734899074291507244', '拦截url表修改', '拦截url表修改', '/SysInterUrlController/edit', 0, '373489907429150720', 'gen:sysInterUrl:edit', 2, 'fa fa-wrench', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('4', '用户管理', '用户展示', '/UserController/view', 0, '411522822607867904', 'system:user:view', 1, 'icon icon-user', 1, 0);
INSERT INTO `t_sys_permission` VALUES ('410791701859405824', '岗位管理', '岗位展示', '/SysPositionController/view', 0, '411522822607867904', 'gen:sysPosition:view', 1, 'fa fa-vcard', 17, 0);
INSERT INTO `t_sys_permission` VALUES ('4107917018594058251', '岗位表集合', '岗位集合', '/SysPositionController/list', 0, '410791701859405824', 'gen:sysPosition:list', 2, '', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('4107917018594058262', '岗位表添加', '岗位添加', '/SysPositionController/add', 0, '410791701859405824', 'gen:sysPosition:add', 2, 'entypo-plus-squared', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('4107917018594058273', '岗位表删除', '岗位删除', '/SysPositionController/remove', 0, '410791701859405824', 'gen:sysPosition:remove', 2, 'entypo-trash', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('4107917018594058284', '岗位表修改', '岗位修改', '/SysPositionController/edit', 0, '410791701859405824', 'gen:sysPosition:edit', 2, 'fa fa-wrench', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('410989805699207168', '部门管理', '部门展示', '/SysDepartmentController/view', 0, '411522822607867904', 'gen:sysDepartment:view', 1, 'fa fa-odnoklassniki', 18, 0);
INSERT INTO `t_sys_permission` VALUES ('4109898056992071691', '部门集合', '部门集合', '/SysDepartmentController/list', 0, '410989805699207168', 'gen:sysDepartment:list', 2, '', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('4109898056992071702', '部门添加', '部门添加', '/SysDepartmentController/add', 0, '410989805699207168', 'gen:sysDepartment:add', 2, 'entypo-plus-squared', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('4109898056992071713', '部门删除', '部门删除', '/SysDepartmentController/remove', 0, '410989805699207168', 'gen:sysDepartment:remove', 2, 'entypo-trash', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('4109898056992071724', '部门修改', '部门修改', '/SysDepartmentController/edit', 0, '410989805699207168', 'gen:sysDepartment:edit', 2, 'fa fa-wrench', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('411522822607867904', '用户管理', NULL, '', 0, '0', '', 0, 'layui-icon layui-icon-user', 3, 0);
INSERT INTO `t_sys_permission` VALUES ('486690002869157888', '用户密码修改', '用户密码修改', '/UserController/editPwd', 0, '4', 'system:user:editPwd', 2, 'entypo-tools', 3, 0);
INSERT INTO `t_sys_permission` VALUES ('496126970468237312', '日志展示', '日志管理', '/LogController/view', 0, '592059865673760768', 'system:log:view', 1, 'fa fa-info', 9, 0);
INSERT INTO `t_sys_permission` VALUES ('496127240363311104', '日志删除', '日志删除', '/LogController/remove', 0, '496126970468237312', 'system:log:remove', 2, 'entypo-trash', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('496127794879660032', '日志集合', '日志集合', '/LogController/list', 0, '496126970468237312', 'system:log:list', 2, NULL, NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('5', '用户集合', '用户集合', '/UserController/list', 0, '4', 'system:user:list', 2, '', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('568588560198930432', 'productType', NULL, '', 0, '', '', 0, 'layui-icon', 7, 0);
INSERT INTO `t_sys_permission` VALUES ('568598148579201024', '产品分类管理', '产品分类展示', '/ProductTypeController/view', 0, '0', 'gen:productType:view', 1, 'layui-icon layui-icon-face-smile', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('568598148579201025', '产品分类集合', '产品分类集合', '/ProductTypeController/list', 0, '568598148579201024', 'gen:productType:list', 2, '', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('568598148579201026', '产品分类添加', '产品分类添加', '/ProductTypeController/add', 0, '568598148579201024', 'gen:productType:add', 2, 'layui-icon layui-icon-add-1', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('568598148579201027', '产品分类删除', '产品分类删除', '/ProductTypeController/remove', 0, '568598148579201024', 'gen:productType:remove', 2, 'layui-icon layui-icon-delete', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('568598148579201028', '产品分类修改', '产品分类修改', '/ProductTypeController/edit', 0, '568598148579201024', 'gen:productType:edit', 2, 'layui-icon layui-icon-edit', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('581541547099553792', 'druid监控', 'druid监控', '/druid/', 0, '617766548966211584', 'user:list', 1, 'fa fa-line-chart', 6, 0);
INSERT INTO `t_sys_permission` VALUES ('583063272123531264', 'API文档', NULL, '/doc.html', 1, '617766548966211584', '--', 1, 'layui-icon fa fa-font', 8, 0);
INSERT INTO `t_sys_permission` VALUES ('586003694080753664', '表单构建', NULL, '/static/component/code/index.html', 0, '617766548966211584', 'system:tool:view', 1, 'layui-icon layui-icon fa fa-list-alt', 5, 0);
INSERT INTO `t_sys_permission` VALUES ('587453033487532032', '后台模板', NULL, 'https://www.layui.com/doc/', 1, '617766548966211584', '', 1, 'layui-icon layui-icon fa fa-telegram', 9, 0);
INSERT INTO `t_sys_permission` VALUES ('589559748521623552', '一级菜单', NULL, '', 0, '0', '', 0, 'layui-icon layui-icon layui-icon layui-icon-face-smile', 6, 0);
INSERT INTO `t_sys_permission` VALUES ('592059865673760768', '系统管理', NULL, '', 0, '0', '', 0, 'layui-icon layui-icon-home', 1, 0);
INSERT INTO `t_sys_permission` VALUES ('592067570522128384', '测试跳转', '测试跳转', 'http://www.baidu.com', 1, '589559748521623552', '#', 1, 'fa fa-address-book', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('592167738407911424', '系统监控', '系统监控', '/ServiceController/view', 0, '617766548966211584', 'system:service:view', 1, 'fa fa-video-camera', 7, 0);
INSERT INTO `t_sys_permission` VALUES ('594691026430459904', '电子邮件管理', '电子邮件展示', '/EmailController/view', 0, '592059865673760768', 'system:email:view', 1, 'fa fa-envelope', 8, 0);
INSERT INTO `t_sys_permission` VALUES ('5946910264304599041', '电子邮件集合', '电子邮件集合', '/EmailController/list', 0, '594691026430459904', 'system:email:list', 2, '', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('5946910264304599042', '电子邮件添加', '电子邮件添加', '/EmailController/add', 0, '594691026430459904', 'system:email:add', 2, 'entypo-plus-squared', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('5946910264304599043', '电子邮件删除', '电子邮件删除', '/EmailController/remove', 0, '594691026430459904', 'system:email:remove', 2, 'entypo-trash', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('5946910264304599044', '电子邮件修改', '电子邮件修改', '/EmailController/edit', 0, '594691026430459904', 'system:email:edit', 2, 'fa fa-wrench', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('6', '用户添加', '用户添加', '/UserController/add', 0, '4', 'system:user:add', 2, 'entypo-plus-squared', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('610635485890478080', '代码生成', NULL, '', 0, '0', '', 0, 'layui-icon layui-icon layui-icon layui-icon-praise', 2, 0);
INSERT INTO `t_sys_permission` VALUES ('610635950447394816', '全局配置', '', '/autoCodeController/global', 0, '610635485890478080', 'system:autocode:global', 1, 'fa fa-university', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('617766548966211584', '系统工具', NULL, '', 0, '0', '', 0, 'layui-icon layui-icon layui-icon layui-icon layui-icon layui-icon layui-icon-util', 5, 0);
INSERT INTO `t_sys_permission` VALUES ('618918631769636864', '字典管理', '字典类型表展示', '/DictTypeController/view', 0, '592059865673760768', 'system:dictType:view', 1, 'fa fa-puzzle-piece', 11, 0);
INSERT INTO `t_sys_permission` VALUES ('6189186317738311681', '字典类型表集合', '字典类型表集合', '/DictTypeController/list', 0, '618918631769636864', 'system:dictType:list', 2, NULL, NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('6189186317948026882', '字典类型表添加', '字典类型表添加', '/DictTypeController/add', 0, '618918631769636864', 'system:dictType:add', 2, NULL, NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('6189186317948026883', '字典类型表删除', '字典类型表删除', '/DictTypeController/remove', 0, '618918631769636864', 'system:dictType:remove', 2, NULL, NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('6189186317989969924', '字典类型表修改', '字典类型表修改', '/DictTypeController/edit', 0, '618918631769636864', 'system:dictType:edit', 2, NULL, NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('6192095214866268161', '字典数据表集合', '字典数据表集合', '/DictDataController/list', 0, '618918631769636864', 'system:dictData:list', 2, NULL, NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('6192095214866268162', '字典数据表添加', '字典数据表添加', '/DictDataController/add', 0, '618918631769636864', 'system:dictData:add', 2, NULL, NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('6192095215075983363', '字典数据表删除', '字典数据表删除', '/DictDataController/remove', 0, '618918631769636864', 'system:dictData:remove', 2, NULL, NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('6192095215075983364', '字典数据表修改', '字典数据表修改', '/DictDataController/edit', 0, '618918631769636864', 'system:dictData:edit', 2, NULL, NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('619836559427895296', '字典数据视图', '字典数据视图', '/DictDataController/view', 0, '618918631769636864', 'system:dictData:view', 2, NULL, NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('7', '用户删除', '用户删除', '/UserController/remove', 0, '4', 'system:user:remove', 2, 'entypo-trash', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('8', '用户修改', '用户修改', '/UserController/edit', 0, '4', 'system:user:edit', 2, 'fa fa-wrench', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('9', '角色管理', '角色展示', '/RoleController/view', 0, '411522822607867904', 'system:role:view', 1, 'fa fa-group', 2, 0);

-- ----------------------------
-- Table structure for t_sys_permission_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_permission_role`;
CREATE TABLE `t_sys_permission_role`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色id',
  `permission_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限中间表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_sys_permission_role
-- ----------------------------
INSERT INTO `t_sys_permission_role` VALUES ('00aa760d-3104-4865-a643-c7b04149c1a2', '488243256161730560', '340381240911859712');
INSERT INTO `t_sys_permission_role` VALUES ('05bef802-9668-4f83-98d9-d4c658f2397b', '488243256161730560', '3321578609202995222');
INSERT INTO `t_sys_permission_role` VALUES ('08466a4a-2f3b-4edb-88ce-c366bcb83127', '488243256161730560', '3321578609202995244');
INSERT INTO `t_sys_permission_role` VALUES ('0b0af783-ec85-49d1-a7b9-6df4f20f481d', '488243256161730560', '16');
INSERT INTO `t_sys_permission_role` VALUES ('0d0f7f48-3b04-4316-8ce0-97e806387ae8', '488243256161730560', '410989805699207168');
INSERT INTO `t_sys_permission_role` VALUES ('120de208-9eb8-4fdf-a68b-279762c42614', '488243256161730560', '410791701859405824');
INSERT INTO `t_sys_permission_role` VALUES ('15432543-faaa-4c6b-8766-b1b0a2a32c3d', '488243256161730560', '4107917018594058273');
INSERT INTO `t_sys_permission_role` VALUES ('16207ba1-c46c-4b63-af46-f130e73f3bc1', '488243256161730560', '373489907429150720');
INSERT INTO `t_sys_permission_role` VALUES ('18029094-dec8-41d1-9e0c-22a17e743907', '488243256161730560', '610635950447394816');
INSERT INTO `t_sys_permission_role` VALUES ('18207c89-0bf6-4a30-81c8-e394f3cd832f', '488243256161730560', '6192095214866268161');
INSERT INTO `t_sys_permission_role` VALUES ('1ca7bd28-3d6d-4873-9117-6350ecb3d120', '488243256161730560', '496127240363311104');
INSERT INTO `t_sys_permission_role` VALUES ('1d861070-3213-4322-a0b5-e2c5fe6e62ff', '488243256161730560', '589559748521623552');
INSERT INTO `t_sys_permission_role` VALUES ('22f97df8-27b0-4bb0-ab7f-27cb6ef772b3', '488243256161730560', '568598148579201028');
INSERT INTO `t_sys_permission_role` VALUES ('2511760e-e8a2-45cb-a223-ed2024546ebb', '488243256161730560', '5946910264304599042');
INSERT INTO `t_sys_permission_role` VALUES ('2b549ff9-3082-4c06-8211-b22ba6b102fb', '488243256161730560', '3400681518049566731');
INSERT INTO `t_sys_permission_role` VALUES ('2b713225-83e1-4d8f-b7d1-8b5319a0d7ab', '488243256161730560', '6189186317989969924');
INSERT INTO `t_sys_permission_role` VALUES ('2d1811a0-108a-4aec-ad37-8d465abc13f4', '488243256161730560', '3401274122705346582');
INSERT INTO `t_sys_permission_role` VALUES ('2f22056a-6409-4ea1-80e4-0ccc55a0cd9f', '488243256161730560', '3734899074291507211');
INSERT INTO `t_sys_permission_role` VALUES ('35a904e6-efd4-4a62-8e5f-722045d6138b', '488243256161730560', '3400681518049566753');
INSERT INTO `t_sys_permission_role` VALUES ('3a534509-a011-45dc-8576-51e2643a69bc', '488243256161730560', '3400961831355064342');
INSERT INTO `t_sys_permission_role` VALUES ('3ae964b2-555b-4e38-b958-52d67d62a5bc', '488243256161730560', '8');
INSERT INTO `t_sys_permission_role` VALUES ('3bfd8f96-6b90-44b8-ad92-59dfb825c7ff', '488243256161730560', '3734899074291507233');
INSERT INTO `t_sys_permission_role` VALUES ('3d2c8d32-e860-40e2-9ec7-7c5486fca4cc', '488243256161730560', '6192095215075983364');
INSERT INTO `t_sys_permission_role` VALUES ('3eecc5f7-1412-4b7f-8437-578b0979c697', '488243256161730560', '3401274122705346571');
INSERT INTO `t_sys_permission_role` VALUES ('3ff179c6-ce17-4862-84f4-e352e604920d', '488243256161730560', '3400880220181667862');
INSERT INTO `t_sys_permission_role` VALUES ('412b2d17-e1f1-4241-9007-ffb97880a175', '488243256161730560', '5946910264304599041');
INSERT INTO `t_sys_permission_role` VALUES ('41ffe490-fd3c-41a4-91c1-760998cb6ffc', '488243256161730560', '7');
INSERT INTO `t_sys_permission_role` VALUES ('45182202-9e0a-4a8b-8f8d-afe622ddbca8', '488243256161730560', '335330315113467904');
INSERT INTO `t_sys_permission_role` VALUES ('4898c38a-33be-4941-8536-ef9debc1fd36', '488243256161730560', '3400961831355064331');
INSERT INTO `t_sys_permission_role` VALUES ('4e4dda51-e843-4c4f-9fa5-7377e019d8f2', '488243256161730560', '6192095215075983363');
INSERT INTO `t_sys_permission_role` VALUES ('4f650e7e-3289-4b40-aa35-4bfc4116674b', '488243256161730560', '594691026430459904');
INSERT INTO `t_sys_permission_role` VALUES ('562bf8b4-e140-45c4-824c-303a94855af4', '488243256161730560', '5946910264304599043');
INSERT INTO `t_sys_permission_role` VALUES ('5d6ef562-187a-43b5-8b58-93e2a36842ed', '488243256161730560', '6');
INSERT INTO `t_sys_permission_role` VALUES ('64ec1376-6123-4036-a958-df84960e887f', '488243256161730560', '3303650266428252193');
INSERT INTO `t_sys_permission_role` VALUES ('65a2b303-75bb-4d92-b636-7fe96e66645d', '488243256161730560', '340068151804956672');
INSERT INTO `t_sys_permission_role` VALUES ('6a1c351f-098d-4964-9bb7-6c8a75faf1c9', '488243256161730560', '5');
INSERT INTO `t_sys_permission_role` VALUES ('6b42e449-5c7c-48bb-81c5-1c19c5c72b2e', '488243256161730560', '332857281479839744');
INSERT INTO `t_sys_permission_role` VALUES ('6bd65ace-0b84-4bd6-88e7-fadf5cfb6143', '488243256161730560', '3328572814798397473');
INSERT INTO `t_sys_permission_role` VALUES ('6e916600-b246-4829-b4d1-1424e234e2d4', '488243256161730560', '12');
INSERT INTO `t_sys_permission_role` VALUES ('72a5508d-e530-44c5-a1c5-676f5462f12a', '488243256161730560', '3321578609202995233');
INSERT INTO `t_sys_permission_role` VALUES ('741f3577-fa8c-4c47-9698-bdaacf48aee2', '488243256161730560', '617766548966211584');
INSERT INTO `t_sys_permission_role` VALUES ('7544cadd-b26d-418a-8895-e1d82539aca6', '488243256161730560', '3734899074291507222');
INSERT INTO `t_sys_permission_role` VALUES ('76d10c2f-0a7d-4b82-91f9-96d68b79db05', '488243256161730560', '568598148579201026');
INSERT INTO `t_sys_permission_role` VALUES ('77258b51-639f-43b3-886d-19da13543c8a', '488243256161730560', '592059865673760768');
INSERT INTO `t_sys_permission_role` VALUES ('77a91e97-73e6-415f-b89e-9e423bf8af25', '488243256161730560', '618918631769636864');
INSERT INTO `t_sys_permission_role` VALUES ('78345950-4a40-403a-a13b-cf230fabed15', '488243256161730560', '340096183135506432');
INSERT INTO `t_sys_permission_role` VALUES ('7a20bf26-e3a8-42e3-aae9-a4ff69b0c48d', '488243256161730560', '6189186317948026883');
INSERT INTO `t_sys_permission_role` VALUES ('7d8d27a4-481f-4508-9e48-0f75cbfd8ed4', '488243256161730560', '3400880220181667851');
INSERT INTO `t_sys_permission_role` VALUES ('7fd8f2e3-9c28-480a-9ac0-6dc28b86bb68', '488243256161730560', '18');
INSERT INTO `t_sys_permission_role` VALUES ('85211778-dff1-4af0-b488-e1463da66c29', '488243256161730560', '3400961831355064353');
INSERT INTO `t_sys_permission_role` VALUES ('8e37f9af-f477-48be-bb17-6373d064c54d', '488243256161730560', '330365026642825216');
INSERT INTO `t_sys_permission_role` VALUES ('934445c8-946c-4720-b3c4-7b5a8fb5bc0b', '488243256161730560', '340088022018166784');
INSERT INTO `t_sys_permission_role` VALUES ('93de85cb-17fe-456c-9c79-6528ffd720b2', '488243256161730560', '4109898056992071691');
INSERT INTO `t_sys_permission_role` VALUES ('99d16ccf-28a3-4b99-a988-9bbbee16f276', '488243256161730560', '4109898056992071724');
INSERT INTO `t_sys_permission_role` VALUES ('9c94e9c0-c9c0-49ac-94c6-0458d5e02b9b', '488243256161730560', '568598148579201027');
INSERT INTO `t_sys_permission_role` VALUES ('9f95ebfa-5a66-4476-8088-faf8eaa4aa50', '488243256161730560', '3400880220181667873');
INSERT INTO `t_sys_permission_role` VALUES ('9fa9cd78-c93e-43bc-b635-9882bffe8805', '488243256161730560', '568598148579201024');
INSERT INTO `t_sys_permission_role` VALUES ('aaf24157-4ee4-45fc-a2b0-552a44aaadfb', '488243256161730560', '496126970468237312');
INSERT INTO `t_sys_permission_role` VALUES ('abf53f97-2485-4765-a111-5b564b3347c2', '488243256161730560', '4109898056992071702');
INSERT INTO `t_sys_permission_role` VALUES ('b13a2302-88c9-45de-985e-ad3e7bf5cea9', '488243256161730560', '4107917018594058251');
INSERT INTO `t_sys_permission_role` VALUES ('b178e391-4c64-4498-9dec-e0ad289c044c', '488243256161730560', '486690002869157888');
INSERT INTO `t_sys_permission_role` VALUES ('b46ec663-05cb-4c19-b4c1-ccdeb7f9b7e2', '488243256161730560', '3400961831355064364');
INSERT INTO `t_sys_permission_role` VALUES ('b6ce2d30-705d-47a9-b971-c38ce44b115e', '488243256161730560', '583063272123531264');
INSERT INTO `t_sys_permission_role` VALUES ('b731c86f-54dc-45ed-a437-d3db7cebd2ea', '488243256161730560', '6192095214866268162');
INSERT INTO `t_sys_permission_role` VALUES ('b753d1b0-ff45-4c35-8026-f8e1853c0cda', '488243256161730560', '332157860920299520');
INSERT INTO `t_sys_permission_role` VALUES ('b77e8233-ff96-489b-aaf8-b32d73c74577', '488243256161730560', '592067570522128384');
INSERT INTO `t_sys_permission_role` VALUES ('b7901c1a-c8cf-4470-bf17-a21795ba827e', '488243256161730560', '340067579836108800');
INSERT INTO `t_sys_permission_role` VALUES ('bb23249f-65c4-406c-947a-88d23c9c1fde', '488243256161730560', '9');
INSERT INTO `t_sys_permission_role` VALUES ('bc033101-6834-4600-9590-ad39ef5f3de5', '488243256161730560', '15');
INSERT INTO `t_sys_permission_role` VALUES ('bee62993-3640-4326-8028-a777b83c7586', '488243256161730560', '586003694080753664');
INSERT INTO `t_sys_permission_role` VALUES ('bf6f0eda-1699-4963-b1b9-05ef008edeff', '488243256161730560', '4107917018594058262');
INSERT INTO `t_sys_permission_role` VALUES ('c0815eb2-c15d-47ce-bfbf-8ce35f2e7d0c', '488243256161730560', '610635485890478080');
INSERT INTO `t_sys_permission_role` VALUES ('c279c5ab-1ecd-434a-8523-ca67c10a42d7', '488243256161730560', '581541547099553792');
INSERT INTO `t_sys_permission_role` VALUES ('c3381ec4-8b33-4128-9031-184aecec3bb9', '488243256161730560', '3400880220181667884');
INSERT INTO `t_sys_permission_role` VALUES ('c3d57698-c911-4ae7-a541-c9453667ee14', '488243256161730560', '11');
INSERT INTO `t_sys_permission_role` VALUES ('c45ee671-7a01-44ec-a4b2-ee6f795404ce', '488243256161730560', '3401274122705346604');
INSERT INTO `t_sys_permission_role` VALUES ('c482a0ba-7d0b-44a3-94db-0690900dca6e', '488243256161730560', '340301160042860544');
INSERT INTO `t_sys_permission_role` VALUES ('c5c71c25-a693-4eda-b067-d016878f8cba', '488243256161730560', '592167738407911424');
INSERT INTO `t_sys_permission_role` VALUES ('c5f7bcff-78d9-4662-b965-2c03f63c027d', '488243256161730560', '3400681518049566742');
INSERT INTO `t_sys_permission_role` VALUES ('c7afddc1-b721-4642-a7f9-237e2ebfc1a4', '488243256161730560', '4109898056992071713');
INSERT INTO `t_sys_permission_role` VALUES ('cc66cfc1-764a-4969-ac1d-bdf1284fe980', '488243256161730560', '3734899074291507244');
INSERT INTO `t_sys_permission_role` VALUES ('cd048a17-5993-491e-aaea-dff96d5b1d6b', '488243256161730560', '14');
INSERT INTO `t_sys_permission_role` VALUES ('cd3b83d0-7e1f-4ed5-8e5a-cf79488c9bb8', '488243256161730560', '20');
INSERT INTO `t_sys_permission_role` VALUES ('cfd4473e-7b31-4677-a896-c174ca0f21ec', '488243256161730560', '568598148579201025');
INSERT INTO `t_sys_permission_role` VALUES ('d0b187e7-72fc-4b2f-b9d2-08cc4f4c375b', '488243256161730560', '22');
INSERT INTO `t_sys_permission_role` VALUES ('d16b7b90-7cb7-424c-99fa-76ffd8ef763b', '488243256161730560', '619836559427895296');
INSERT INTO `t_sys_permission_role` VALUES ('d172f494-4939-4adb-be05-99899eb9058c', '488243256161730560', '3303650266428252204');
INSERT INTO `t_sys_permission_role` VALUES ('d18111b6-3486-4516-86ce-2592b0ab6d76', '488243256161730560', '5946910264304599044');
INSERT INTO `t_sys_permission_role` VALUES ('d827a885-47e2-47bb-9674-6ff9169d713e', '488243256161730560', '3303650266428252182');
INSERT INTO `t_sys_permission_role` VALUES ('d843f655-cca7-4c62-87d6-28d74c0b5b4f', '488243256161730560', '331778807298134016');
INSERT INTO `t_sys_permission_role` VALUES ('d9542cf1-edc7-498a-8b1e-12bb430a6cee', '488243256161730560', '340127412270534656');
INSERT INTO `t_sys_permission_role` VALUES ('dbe01842-6ade-45ed-8bde-d0516997275b', '488243256161730560', '3303650266428252171');
INSERT INTO `t_sys_permission_role` VALUES ('dcabf34b-52e7-4fea-99b4-a27c8895dc3a', '488243256161730560', '10');
INSERT INTO `t_sys_permission_role` VALUES ('e0810ca1-634a-4983-8b33-3a882c11ba1a', '488243256161730560', '23');
INSERT INTO `t_sys_permission_role` VALUES ('e08fb586-d89b-4336-8124-402fbbbe7c86', '488243256161730560', '17');
INSERT INTO `t_sys_permission_role` VALUES ('e24dc1a6-74b9-4ecc-abf8-f567320d4bce', '488243256161730560', '496127794879660032');
INSERT INTO `t_sys_permission_role` VALUES ('e564b82f-d235-402e-8c28-b05c265f0cf6', '488243256161730560', '13');
INSERT INTO `t_sys_permission_role` VALUES ('e59a6966-4a45-4b92-96e4-6fb924135832', '488243256161730560', '19');
INSERT INTO `t_sys_permission_role` VALUES ('e85ae718-72fc-4335-a257-68dbad04e0b6', '488243256161730560', '3328572814798397451');
INSERT INTO `t_sys_permission_role` VALUES ('e872ee0a-973e-4a4d-970c-0e03163058dd', '488243256161730560', '6189186317948026882');
INSERT INTO `t_sys_permission_role` VALUES ('eb5f53ed-4d1c-4ba0-bc0e-639e44b575c7', '488243256161730560', '4107917018594058284');
INSERT INTO `t_sys_permission_role` VALUES ('ebad2761-b34e-4445-9751-06ebc882eb84', '488243256161730560', '411522822607867904');
INSERT INTO `t_sys_permission_role` VALUES ('ed80457b-a4db-49ae-b78f-9e20731e23c5', '488243256161730560', '4');
INSERT INTO `t_sys_permission_role` VALUES ('ee1b834f-03b0-47ce-8765-4cfa9a5a35f8', '488243256161730560', '3400681518049566764');
INSERT INTO `t_sys_permission_role` VALUES ('f427b678-8f68-4cce-a876-fff137e3415a', '488243256161730560', '3401274122705346593');
INSERT INTO `t_sys_permission_role` VALUES ('f4befe3f-8ff9-4c32-8d24-1431c2bcf55d', '488243256161730560', '6189186317738311681');
INSERT INTO `t_sys_permission_role` VALUES ('f7a2e313-416a-4ef2-ab44-4c07d72b91f2', '488243256161730560', '21');
INSERT INTO `t_sys_permission_role` VALUES ('fb7820d0-092a-490d-bc73-9460ceabe721', '488243256161730560', '3321578609202995211');
INSERT INTO `t_sys_permission_role` VALUES ('ffcddcd5-6c04-4693-bb94-87c50458019a', '488243256161730560', '587453033487532032');

-- ----------------------------
-- Table structure for t_sys_position
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_position`;
CREATE TABLE `t_sys_position`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `post_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '岗位名称',
  `order_num` int(0) NULL DEFAULT NULL COMMENT '排序',
  `status` int(0) NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '岗位表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_sys_position
-- ----------------------------
INSERT INTO `t_sys_position` VALUES ('410792368778907648', '总经理', 1, 1);
INSERT INTO `t_sys_position` VALUES ('410792443127140352', '技术经理', 2, 1);
INSERT INTO `t_sys_position` VALUES ('410792478929719296', '人事经理', 3, 1);
INSERT INTO `t_sys_position` VALUES ('411477874382606336', '员工', 4, 1);

-- ----------------------------
-- Table structure for t_sys_province
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_province`;
CREATE TABLE `t_sys_province`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增列',
  `province_code` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '省份代码',
  `province_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '省份名称',
  `short_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '简称',
  `lng` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经度',
  `lat` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '纬度',
  `sort` int(0) NULL DEFAULT NULL COMMENT '排序',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `memo` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `data_state` int(0) NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `Index_1`(`province_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '省份表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_sys_province
-- ----------------------------
INSERT INTO `t_sys_province` VALUES (22, '500000', '重庆', '重庆', '106.504959', '29.533155', 22, '2019-02-28 17:16:58', '2019-02-28 17:17:05', '', 0);

-- ----------------------------
-- Table structure for t_sys_quartz_job
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_quartz_job`;
CREATE TABLE `t_sys_quartz_job`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '日志id',
  `job_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务名称',
  `job_group` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务组名',
  `invoke_target` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '调用目标字符串',
  `cron_expression` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'cron执行表达式',
  `misfire_policy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'cron计划策略',
  `concurrent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否并发执行（0允许 1禁止）',
  `status` int(0) NULL DEFAULT NULL COMMENT '任务状态（0正常 1暂停）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '定时任务调度表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_sys_quartz_job
-- ----------------------------
INSERT INTO `t_sys_quartz_job` VALUES ('332182389491109888', 'v2Task2', 'SYSTEM', 'v2Task.runTask2(1,2l,\'asa\',true,2D)', '*/5 * * * * ?', '2', '0', 1);
INSERT INTO `t_sys_quartz_job` VALUES ('566566155599351808', 'Task3', 'DEFAULT', 'v2Task.runTask3(\'\'trademe\')', '0 0 * * * ?', '1', '0', 0);

-- ----------------------------
-- Table structure for t_sys_quartz_job_log
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_quartz_job_log`;
CREATE TABLE `t_sys_quartz_job_log`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `job_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务名称',
  `job_group` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务组名',
  `invoke_target` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '调用目标字符串',
  `job_message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日志信息',
  `status` int(0) NULL DEFAULT NULL COMMENT '执行状态（0正常 1失败）',
  `exception_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '异常信息',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '定时任务调度日志表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_sys_quartz_job_log
-- ----------------------------
INSERT INTO `t_sys_quartz_job_log` VALUES ('566568776389234688', 'Task3', 'DEFAULT', 'v2Task.runTask3(\'\'trademe\')', 'Task3 总共耗时：0毫秒', 0, NULL, '2021-06-20 12:28:53', '2021-06-20 12:28:53');
INSERT INTO `t_sys_quartz_job_log` VALUES ('566568799202054144', 'v2Task2', 'SYSTEM', 'v2Task.runTask2(1,2l,\'asa\',true,2D)', 'v2Task2 总共耗时：20毫秒', 0, NULL, '2021-06-20 12:28:58', '2021-06-20 12:28:58');
INSERT INTO `t_sys_quartz_job_log` VALUES ('566938996169641984', 'Task3', 'DEFAULT', 'v2Task.runTask3(\'\'trademe\')', 'Task3 总共耗时：109毫秒', 0, NULL, '2021-06-21 13:00:00', '2021-06-21 13:00:00');
INSERT INTO `t_sys_quartz_job_log` VALUES ('566954095148142592', 'Task3', 'DEFAULT', 'v2Task.runTask3(\'\'trademe\')', 'Task3 总共耗时：1毫秒', 0, NULL, '2021-06-21 14:00:00', '2021-06-21 14:00:00');
INSERT INTO `t_sys_quartz_job_log` VALUES ('566969194621571072', 'Task3', 'DEFAULT', 'v2Task.runTask3(\'\'trademe\')', 'Task3 总共耗时：0毫秒', 0, NULL, '2021-06-21 15:00:00', '2021-06-21 15:00:00');
INSERT INTO `t_sys_quartz_job_log` VALUES ('566984294111776768', 'Task3', 'DEFAULT', 'v2Task.runTask3(\'\'trademe\')', 'Task3 总共耗时：0毫秒', 0, NULL, '2021-06-21 16:00:00', '2021-06-21 16:00:00');
INSERT INTO `t_sys_quartz_job_log` VALUES ('566999393606176768', 'Task3', 'DEFAULT', 'v2Task.runTask3(\'\'trademe\')', 'Task3 总共耗时：1毫秒', 0, NULL, '2021-06-21 17:00:00', '2021-06-21 17:00:00');
INSERT INTO `t_sys_quartz_job_log` VALUES ('567014493100576768', 'Task3', 'DEFAULT', 'v2Task.runTask3(\'\'trademe\')', 'Task3 总共耗时：1毫秒', 0, NULL, '2021-06-21 18:00:00', '2021-06-21 18:00:00');
INSERT INTO `t_sys_quartz_job_log` VALUES ('567029592611753984', 'Task3', 'DEFAULT', 'v2Task.runTask3(\'\'trademe\')', 'Task3 总共耗时：1毫秒', 0, NULL, '2021-06-21 19:00:00', '2021-06-21 19:00:00');
INSERT INTO `t_sys_quartz_job_log` VALUES ('567044692110348288', 'Task3', 'DEFAULT', 'v2Task.runTask3(\'\'trademe\')', 'Task3 总共耗时：0毫秒', 0, NULL, '2021-06-21 20:00:00', '2021-06-21 20:00:00');
INSERT INTO `t_sys_quartz_job_log` VALUES ('568403648376344576', 'Task3', 'DEFAULT', 'v2Task.runTask3(\'\'trademe\')', 'Task3 总共耗时：362毫秒', 0, NULL, '2021-06-25 14:00:00', '2021-06-25 14:00:00');
INSERT INTO `t_sys_quartz_job_log` VALUES ('568418746100748288', 'Task3', 'DEFAULT', 'v2Task.runTask3(\'\'trademe\')', 'Task3 总共耗时：0毫秒', 0, NULL, '2021-06-25 15:00:00', '2021-06-25 15:00:00');
INSERT INTO `t_sys_quartz_job_log` VALUES ('568433845574176768', 'Task3', 'DEFAULT', 'v2Task.runTask3(\'\'trademe\')', 'Task3 总共耗时：0毫秒', 0, NULL, '2021-06-25 16:00:00', '2021-06-25 16:00:00');
INSERT INTO `t_sys_quartz_job_log` VALUES ('568448945089548288', 'Task3', 'DEFAULT', 'v2Task.runTask3(\'\'trademe\')', 'Task3 总共耗时：1毫秒', 0, NULL, '2021-06-25 17:00:00', '2021-06-25 17:00:00');
INSERT INTO `t_sys_quartz_job_log` VALUES ('568464044579753984', 'Task3', 'DEFAULT', 'v2Task.runTask3(\'\'trademe\')', 'Task3 总共耗时：0毫秒', 0, NULL, '2021-06-25 18:00:00', '2021-06-25 18:00:00');
INSERT INTO `t_sys_quartz_job_log` VALUES ('568479144061571072', 'Task3', 'DEFAULT', 'v2Task.runTask3(\'\'trademe\')', 'Task3 总共耗时：1毫秒', 0, NULL, '2021-06-25 19:00:00', '2021-06-25 19:00:00');
INSERT INTO `t_sys_quartz_job_log` VALUES ('568494243555971072', 'Task3', 'DEFAULT', 'v2Task.runTask3(\'\'trademe\')', 'Task3 总共耗时：0毫秒', 0, NULL, '2021-06-25 20:00:00', '2021-06-25 20:00:00');
INSERT INTO `t_sys_quartz_job_log` VALUES ('568509343062953984', 'Task3', 'DEFAULT', 'v2Task.runTask3(\'\'trademe\')', 'Task3 总共耗时：0毫秒', 0, NULL, '2021-06-25 21:00:00', '2021-06-25 21:00:00');
INSERT INTO `t_sys_quartz_job_log` VALUES ('568524442540576768', 'Task3', 'DEFAULT', 'v2Task.runTask3(\'\'trademe\')', 'Task3 总共耗时：0毫秒', 0, NULL, '2021-06-25 22:00:00', '2021-06-25 22:00:00');
INSERT INTO `t_sys_quartz_job_log` VALUES ('568539542030782464', 'Task3', 'DEFAULT', 'v2Task.runTask3(\'\'trademe\')', 'Task3 总共耗时：0毫秒', 0, NULL, '2021-06-25 23:00:00', '2021-06-25 23:00:00');
INSERT INTO `t_sys_quartz_job_log` VALUES ('568554641529376768', 'Task3', 'DEFAULT', 'v2Task.runTask3(\'\'trademe\')', 'Task3 总共耗时：0毫秒', 0, NULL, '2021-06-26 00:00:00', '2021-06-26 00:00:00');
INSERT INTO `t_sys_quartz_job_log` VALUES ('568569741040553984', 'Task3', 'DEFAULT', 'v2Task.runTask3(\'\'trademe\')', 'Task3 总共耗时：0毫秒', 0, NULL, '2021-06-26 01:00:00', '2021-06-26 01:00:00');
INSERT INTO `t_sys_quartz_job_log` VALUES ('568584840539148288', 'Task3', 'DEFAULT', 'v2Task.runTask3(\'\'trademe\')', 'Task3 总共耗时：0毫秒', 0, NULL, '2021-06-26 02:00:00', '2021-06-26 02:00:00');
INSERT INTO `t_sys_quartz_job_log` VALUES ('568599940113240064', 'Task3', 'DEFAULT', 'v2Task.runTask3(\'\'trademe\')', 'Task3 总共耗时：3毫秒', 0, NULL, '2021-06-26 03:00:00', '2021-06-26 03:00:00');
INSERT INTO `t_sys_quartz_job_log` VALUES ('568615039611834368', 'Task3', 'DEFAULT', 'v2Task.runTask3(\'\'trademe\')', 'Task3 总共耗时：4毫秒', 0, NULL, '2021-06-26 04:00:00', '2021-06-26 04:00:00');
INSERT INTO `t_sys_quartz_job_log` VALUES ('568720736055857152', 'Task3', 'DEFAULT', 'v2Task.runTask3(\'\'trademe\')', 'Task3 总共耗时：3毫秒', 0, NULL, '2021-06-26 11:00:00', '2021-06-26 11:00:00');
INSERT INTO `t_sys_quartz_job_log` VALUES ('568735836171014144', 'Task3', 'DEFAULT', 'v2Task.runTask3(\'\'trademe\')', 'Task3 总共耗时：133毫秒', 0, NULL, '2021-06-26 12:00:00', '2021-06-26 12:00:00');
INSERT INTO `t_sys_quartz_job_log` VALUES ('568750934960771072', 'Task3', 'DEFAULT', 'v2Task.runTask3(\'\'trademe\')', 'Task3 总共耗时：1毫秒', 0, NULL, '2021-06-26 13:00:00', '2021-06-26 13:00:00');
INSERT INTO `t_sys_quartz_job_log` VALUES ('569007626650783744', 'Task3', 'DEFAULT', 'v2Task.runTask3(\'\'trademe\')', 'Task3 总共耗时：8毫秒', 0, NULL, '2021-06-27 06:00:00', '2021-06-27 06:00:00');
INSERT INTO `t_sys_quartz_job_log` VALUES ('569022725901914112', 'Task3', 'DEFAULT', 'v2Task.runTask3(\'\'trademe\')', 'Task3 总共耗时：1毫秒', 0, NULL, '2021-06-27 07:00:00', '2021-06-27 07:00:00');
INSERT INTO `t_sys_quartz_job_log` VALUES ('571650038590214144', 'Task3', 'DEFAULT', 'v2Task.runTask3(\'\'trademe\')', 'Task3 总共耗时：146毫秒', 0, NULL, '2021-07-04 13:00:00', '2021-07-04 13:00:00');
INSERT INTO `t_sys_quartz_job_log` VALUES ('571665137421914112', 'Task3', 'DEFAULT', 'v2Task.runTask3(\'\'trademe\')', 'Task3 总共耗时：0毫秒', 0, NULL, '2021-07-04 14:00:00', '2021-07-04 14:00:00');

-- ----------------------------
-- Table structure for t_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_sys_role
-- ----------------------------
INSERT INTO `t_sys_role` VALUES ('488243256161730560', '管理员');
INSERT INTO `t_sys_role` VALUES ('488289006124007424', '用户');
INSERT INTO `t_sys_role` VALUES ('488305788310257664', '能修改用户密码角色');

-- ----------------------------
-- Table structure for t_sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role_user`;
CREATE TABLE `t_sys_role_user`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sys_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `sys_role_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色中间表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_sys_role_user
-- ----------------------------
INSERT INTO `t_sys_role_user` VALUES ('353711021275353089', '353711021275353088', '488289006124007424');
INSERT INTO `t_sys_role_user` VALUES ('353714370687143936', '488294747442511872', '488289006124007424');
INSERT INTO `t_sys_role_user` VALUES ('354984037766533120', '354984005751410688', '488243256161730560');
INSERT INTO `t_sys_role_user` VALUES ('354988722443390977', '354988722443390976', '488243256161730560');
INSERT INTO `t_sys_role_user` VALUES ('354989789679849472', '354989789675655168', '488305788310257664');
INSERT INTO `t_sys_role_user` VALUES ('495571139645542400', '1', '488243256161730560');
INSERT INTO `t_sys_role_user` VALUES ('612107905532952576', '612107905532952576', '488289006124007424');
INSERT INTO `t_sys_role_user` VALUES ('612107905537146880', '612107905532952576', '488305788310257664');

-- ----------------------------
-- Table structure for t_sys_street
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_street`;
CREATE TABLE `t_sys_street`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增列',
  `street_code` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '街道代码',
  `area_code` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父级区代码',
  `street_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '街道名称',
  `short_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '简称',
  `lng` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经度',
  `lat` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '纬度',
  `sort` int(0) NULL DEFAULT NULL COMMENT '排序',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `memo` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `data_state` int(0) NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `Index_1`(`street_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '街道设置' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_sys_street
-- ----------------------------
INSERT INTO `t_sys_street` VALUES (1, '', '500101', 'No.6 building Xindeyuan', '33', '33', '3', 2, NULL, NULL, NULL, 0);
INSERT INTO `t_sys_street` VALUES (2, '', '500101', '4444', '3', '3', '', NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for t_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '主键',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '昵称',
  `dep_id` int(0) NULL DEFAULT NULL COMMENT '部门id',
  `pos_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '岗位id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_sys_user
-- ----------------------------
INSERT INTO `t_sys_user` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', '管理员', 2, '410792368778907648');
INSERT INTO `t_sys_user` VALUES ('433236479427350528', 'CC', '21232f297a57a5a743894a0e4a801fc3', 'cc', 4, '410792443127140352');

-- ----------------------------
-- Table structure for t_test
-- ----------------------------
DROP TABLE IF EXISTS `t_test`;
CREATE TABLE `t_test`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `age` int(0) NULL DEFAULT NULL COMMENT '年龄',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `b_c_update` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `t_cb_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '写个字符串',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '测试表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_test
-- ----------------------------
INSERT INTO `t_test` VALUES ('457067146405613568', '管理员', 2, '1', '2021-01-14 16:00:00', '2021-01-15 16:00:00', '7');
INSERT INTO `t_test` VALUES ('457067174939463680', '法院用户', 2, '1', '2021-01-12 16:00:00', '2021-01-18 16:00:00', '');
INSERT INTO `t_test` VALUES ('457067196175224832', 'guest', 1, '3', '2021-01-02 16:00:00', '2021-01-16 16:00:00', '');
INSERT INTO `t_test` VALUES ('457067220279889920', 'helloword', 1, '3', '2021-01-03 16:00:00', '2021-01-25 16:00:00', '');

SET FOREIGN_KEY_CHECKS = 1;

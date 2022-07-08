/*
 Navicat Premium Data Transfer

 Source Server         : mysql docker 123456
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : cloudplatform

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 08/07/2022 17:06:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for adminUser
-- ----------------------------
DROP TABLE IF EXISTS `adminUser`;
CREATE TABLE `adminUser` (
  `id` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for commonUser
-- ----------------------------
DROP TABLE IF EXISTS `commonUser`;
CREATE TABLE `commonUser` (
  `id` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `isactive` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '是否激活\n',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `id` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文件名',
  `uploaddate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '上传时间',
  `size` double NOT NULL COMMENT '文件大小',
  `userid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '所属用户id',
  `catalogueid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '父目录id',
  `isfile` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '是否为文件:1是文件，0不是文件',
  `isshow` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for ide
-- ----------------------------
DROP TABLE IF EXISTS `ide`;
CREATE TABLE `ide` (
  `id` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `port` int NOT NULL,
  `userid` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for job
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
  `id` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `jobname` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务名称',
  `starttime` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务开始时间',
  `stoptime` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务结束时间',
  `workcount` int NOT NULL DEFAULT '1' COMMENT '总任务数',
  `workdonecount` int NOT NULL DEFAULT '0' COMMENT '运行完成数',
  `workinlinecount` int NOT NULL COMMENT '排队中',
  `cpucount` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT 'cpu使用量',
  `memcount` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '内存使用量',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '状态：执行中/已完成/排队中',
  `userid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '所属用户的id',
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

SET FOREIGN_KEY_CHECKS = 1;

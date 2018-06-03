/*
Navicat Oracle Data Transfer
Oracle Client Version : 11.2.0.4.0

Source Server         : scott
Source Server Version : 110200
Source Host           : WIN-1V0BJOHAUB9:1521
Source Schema         : SCOTT

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2018-06-03 09:59:06
*/


-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE "SCOTT"."product";
CREATE TABLE "SCOTT"."product" (
"proId" NUMBER(19) NULL ,
"proName" VARCHAR2(50 CHAR) NULL ,
"dirName" VARCHAR2(50 CHAR) NULL ,
"supplier" VARCHAR2(50 CHAR) NULL ,
"brand" VARCHAR2(50 CHAR) NULL ,
"count" NUMBER NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO "SCOTT"."product" VALUES ('160003', '《数据挖掘技术与应用》', '图书音像', '当当网', '清华大学出版社', '160');
INSERT INTO "SCOTT"."product" VALUES ('160002', '《智能革命》', '图书音像', '百度', '中信出版集团', '240');
INSERT INTO "SCOTT"."product" VALUES ('160004', '《物联网设计》', '图书音像', '当当网', '人民邮电出版社', '170');
INSERT INTO "SCOTT"."product" VALUES ('120001', '美的挂机空调', '家用电器', '美的', '美的', '45');
INSERT INTO "SCOTT"."product" VALUES ('160005', '《人间失格》', '图书音像', '天津出版传媒集团', '天津人民出版社', '170');
INSERT INTO "SCOTT"."product" VALUES ('110003', '营养快线升级版', '食品酒水', '哇哈哈', '哇哈哈', '500');
INSERT INTO "SCOTT"."product" VALUES ('110004', '农夫山泉', '食品酒水', '农夫山泉', '农夫山泉', '180');
INSERT INTO "SCOTT"."product" VALUES ('130001', '罗技G102', '电脑办公', '罗技', '罗技', '122');
INSERT INTO "SCOTT"."product" VALUES ('130002', '罗技M100', '电脑办公', '罗技', '罗技', '70');
INSERT INTO "SCOTT"."product" VALUES ('130003', '罗技M115', '电脑办公', '罗技', '罗技', '80');
INSERT INTO "SCOTT"."product" VALUES ('170001', '水果刀', '生活用品', '十八子作', '十八子作', '200');
INSERT INTO "SCOTT"."product" VALUES ('160001', '《一只特立独行的猪》', '图书音像', '长江文艺出版社', '长江文艺出版社', '200');
INSERT INTO "SCOTT"."product" VALUES ('110002', '卫龙辣条', '食品酒水', '卫龙', '卫龙', '460');
INSERT INTO "SCOTT"."product" VALUES ('160008', '《大数据技术原理与应用》', '图书音像', '京东', '人民邮电出版社', '160');
INSERT INTO "SCOTT"."product" VALUES ('160007', '《云计算》', '图书音像', '京东', '电子工业出版社', '200');
INSERT INTO "SCOTT"."product" VALUES ('110001', '可口可乐', '食品酒水', '可口可乐', '可口可乐', '200');
INSERT INTO "SCOTT"."product" VALUES ('160009', '《算法设计与分析》', '图书音像', '京东', '清华大学出版社', '190');

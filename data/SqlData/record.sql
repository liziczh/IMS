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

Date: 2018-06-03 10:00:05
*/


-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE "SCOTT"."record";
CREATE TABLE "SCOTT"."record" (
"date" VARCHAR2(254 CHAR) NULL ,
"proId" NUMBER NULL ,
"proName" VARCHAR2(254 CHAR) NULL ,
"count" NUMBER NULL ,
"register" VARCHAR2(254 CHAR) NULL ,
"recordType" VARCHAR2(254 CHAR) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO "SCOTT"."record" VALUES ('2018-01-01', '110001', '可口可乐', '20', '关羽', 'out');
INSERT INTO "SCOTT"."record" VALUES ('2018-06-03', '130002', '罗技M100', '20', '张飞', 'in');
INSERT INTO "SCOTT"."record" VALUES ('2018-01-01', '130001', '罗技G102', '20', '斩三', 'out');
INSERT INTO "SCOTT"."record" VALUES ('2018-01-01', '130001', '罗技G102', '20', '斩三', 'out');
INSERT INTO "SCOTT"."record" VALUES ('2018-06-03', '160001', '《一只特立独行的猪》', '20', '张三', 'out');
INSERT INTO "SCOTT"."record" VALUES ('2018-01-01', '130001', '罗技G102', '20', '斩三', 'out');
INSERT INTO "SCOTT"."record" VALUES ('2018-01-01', '110001', '可口可乐', '20', '关羽', 'out');
INSERT INTO "SCOTT"."record" VALUES ('2018-01-01', '110001', '可口可乐', '20', '关羽', 'out');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-26', '110003', '营养快线升级版', '500', 'Stark', 'in');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-27', '160003', '《数据挖掘技术与应用》', '20', '赵本山', 'out');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-15', '160005', '《人间失格》', '200', '张三丰', 'in');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-30', '160009', '《算法设计与分析》', '10', 'Mark', 'out');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-13', '130001', '罗技G102', '20', 'lizi', 'in');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-21', '110004', '农夫山泉', '200', '吕奉先', 'in');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-31', '130001', '罗技G102', '1', '123', 'out');
INSERT INTO "SCOTT"."record" VALUES ('2018-06-01', '110001', '可口可乐', '20', '刘备', 'in');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-27', '130001', '罗技G102', '20', '王五', 'out');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-28', '130003', '罗技M115', '20', '张三', 'out');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-22', '160008', '《大数据技术原理与应用》', '200', '张无忌', 'in');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-23', '160003', '《数据挖掘技术与应用》', '200', '一灯大师', 'in');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-24', '160007', '《云计算》', '200', '杨过', 'in');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-14', '130001', '罗技G102', '12', '王五', 'in');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-25', '160004', '《物联网设计》', '10', 'Mark', 'out');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-17', '160003', '《数据挖掘技术与应用》', '20', 'lizi', 'out');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-26', '130001', '罗技G102', '40', '张三', 'out');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-30', '110001', '可口可乐', '200', '张三', 'in');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-31', '130001', '罗技G102', '1', '123', 'out');
INSERT INTO "SCOTT"."record" VALUES ('2018-06-01', '130001', '罗技G102', '20', '斩三', 'out');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-13', '120001', '美的挂机空调', '50', '张三丰', 'in');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-16', '160004', '《物联网设计》', '200', '欧阳锋', 'in');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-12', '160009', '《算法设计与分析》', '200', '黄老邪', 'in');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-11', '170001', '水果刀', '200', '张三', 'in');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-15', '130001', '罗技G102', '20', '张三', 'in');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-31', '130001', '罗技G102', '1', '123', 'in');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-31', '130001', '罗技G102', '2', '123', 'in');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-11', '130001', '罗技G102', '40', '陈浩南', 'in');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-11', '130002', '罗技M100', '60', '山鸡', 'in');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-12', '130003', '罗技M115', '100', '李寻欢', 'in');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-12', '110001', '可口可乐', '20', '陆小凤', 'in');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-12', '110002', '卫龙辣条', '200', '2009', 'in');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-12', '170001', '水果刀', '20', 'Pc冷冷', 'in');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-14', '160004', '《物联网设计》', '20', 'Peter', 'out');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-15', '160005', '《人间失格》', '10', '王五', 'out');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-27', '160005', '《人间失格》', '20', '张三', 'out');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-17', '170001', '水果刀', '20', 'Hulk', 'out');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-18', '130002', '罗技M100', '10', '凯文', 'out');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-29', '130001', '罗技G102', '50', '王五', 'in');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-18', '110004', '农夫山泉', '20', '陈宫', 'out');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-30', '160001', '《一只特立独行的猪》', '20', '曹操', 'in');
INSERT INTO "SCOTT"."record" VALUES ('2018-06-01', '130001', '罗技G102', '20', '张三', 'in');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-24', '160002', '《智能革命》', '200', '丘处机', 'in');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-25', '110002', '卫龙辣条', '10', 'Tony', 'in');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-26', '110002', '卫龙辣条', '300', '美国队长', 'in');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-23', '110002', '卫龙辣条', '50', '火娃', 'out');
INSERT INTO "SCOTT"."record" VALUES ('2018-05-16', '160008', '《大数据技术原理与应用》', '40', '张三', 'out');
INSERT INTO "SCOTT"."record" VALUES ('2018-06-03', '160002', '《智能革命》', '20', '李彦宏', 'in');
INSERT INTO "SCOTT"."record" VALUES ('2018-06-01', '110001', '可口可乐', '20', '关羽', 'out');

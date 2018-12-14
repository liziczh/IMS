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

Date: 2018-06-03 10:00:15
*/


-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE "SCOTT"."user";
CREATE TABLE "SCOTT"."user" (
"id" NUMBER NOT NULL ,
"username" VARCHAR2(255 BYTE) NOT NULL ,
"password" VARCHAR2(255 BYTE) NOT NULL ,
"mobileNumber" NUMBER NULL ,
"email" VARCHAR2(255 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO "SCOTT"."user" VALUES ('2', '1001', 'B8C37E33DEFDE51CF91E1E03E51657DA', '13068035749', 'liziczh@foxmail.com');
INSERT INTO "SCOTT"."user" VALUES ('3', '1002', 'FBA9D88164F3E2D9109EE770223212A0', '13068035749', 'liziczh@qq.com');
INSERT INTO "SCOTT"."user" VALUES ('5', '1003', 'AA68C75C4A77C87F97FB686B2F068676', '13068035749', 'liziczh@qq.com');
INSERT INTO "SCOTT"."user" VALUES ('6', 'lizi', '6B42D00C4CA6DDC33A604C54B8CE4ADC', '13068035749', 'liziczh@qq.com');
INSERT INTO "SCOTT"."user" VALUES ('7', 'manager', '1D0258C2440A8D19E716292B231E3190', '13068035749', 'liziczh@qq.com');
INSERT INTO "SCOTT"."user" VALUES ('10', 'username', '5F4DCC3B5AA765D61D8327DEB882CF99', '13068035749', 'liziczh@qq.com');
INSERT INTO "SCOTT"."user" VALUES ('11', 'admin', 'E10ADC3949BA59ABBE56E057F20F883E', '13068035749', 'liziczh@qq.com');
INSERT INTO "SCOTT"."user" VALUES ('12', 'A1001', 'B2599014839A9584BE552EAD780F83F0', '13068035749', 'liziczh@qq.com');

-- ----------------------------
-- Indexes structure for table user
-- ----------------------------

-- ----------------------------
-- Checks structure for table user
-- ----------------------------
ALTER TABLE "SCOTT"."user" ADD CHECK ("id" IS NOT NULL);
ALTER TABLE "SCOTT"."user" ADD CHECK ("username" IS NOT NULL);
ALTER TABLE "SCOTT"."user" ADD CHECK ("password" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table user
-- ----------------------------
ALTER TABLE "SCOTT"."user" ADD PRIMARY KEY ("id");

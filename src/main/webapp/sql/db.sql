CREATE TABLE `db_woyaxiy`.`Untitled`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT ''自增主键'',
  `uname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT ''留言名称'',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT ''电话'',
  `district` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT ''加盟区域'',
  `status` int(1) NULL DEFAULT NULL COMMENT ''状态 0为未读 1 为已读'',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT ''url地址'',
  `createtime` timestamp(0) NULL DEFAULT NULL COMMENT ''创建时间'',
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT ''访问ip地址'',
  `shoptype` int(1) NULL DEFAULT NULL COMMENT ''商家类型 1为粥员外'',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;



CREATE TABLE `db_woyaxiy`.`Untitled`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
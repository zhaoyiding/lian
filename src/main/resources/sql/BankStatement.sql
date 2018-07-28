DROP TABLE IF EXISTS `bank_statement`;
CREATE TABLE `bank_statement`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '流水号',
  `bankName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '银行名称',
  `personIdentification` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '用户身份证号',
  `operateDate` datetime(0) NOT NULL COMMENT '操作日期',
  `operateType` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '操作类型（存款，取款，转账）',
  `amount` decimal(10, 0) NOT NULL COMMENT '金额',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;

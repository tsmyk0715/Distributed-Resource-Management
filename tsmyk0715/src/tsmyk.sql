/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : tsmyk

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-04-07 18:57:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `number` varchar(20) NOT NULL DEFAULT '00000' COMMENT '客户编号',
  `customername` varchar(50) DEFAULT NULL COMMENT '客户名称',
  `postcode` varchar(20) DEFAULT NULL COMMENT '客户邮编',
  `address` varchar(50) DEFAULT NULL COMMENT '客户地址',
  `telephone` varchar(20) DEFAULT NULL COMMENT '客户电话',
  `connectperson` varchar(20) DEFAULT NULL COMMENT '联系人',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系人电话',
  `bank` varchar(50) DEFAULT NULL COMMENT '开户银行',
  `account` varchar(50) DEFAULT NULL COMMENT '银行账户',
  `email` varchar(50) DEFAULT NULL COMMENT '联系人邮箱',
  `fax` varchar(20) DEFAULT NULL COMMENT '客户传真',
  `description` varchar(100) DEFAULT NULL COMMENT '备注',
  `userid` int(20) DEFAULT NULL COMMENT '外键，表示该客户属于哪个分销商下的',
  PRIMARY KEY (`id`),
  KEY `USER_ID` (`userid`),
  CONSTRAINT `USER_ID` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', '00001', '九星股份有限公司', '	\r\n200000', '上海', '18373829382', '夏舒征', '18109287261', '工商银行', '698337637218736511', 'jiuxin@163.com', '5424563', '华东地区', '2');
INSERT INTO `customer` VALUES ('2', '00002', '赛诺股份有限公司', '510000', '广州', '15198274671', '凌霜华', '17837625198', '农业银行', '375874618329817456', 'sainuo@163.com', '2345643', '华南地区', '2');
INSERT INTO `customer` VALUES ('3', '00003', '帕特股份有限公司', '450000', '郑州', '18390283912', '景茵梦', '12425243523', '邮政储蓄', '332423478678632746', 'pate@163.com', '2345434', '华中地区', '2');
INSERT INTO `customer` VALUES ('4', '00004', '跃锐股份有限公司', '100000', '北京', '15345245234', '容柒雁', '15243523455', '建设银行', '342545789234783123', 'yueyue@163.com', '3424532', '华北地区', '2');
INSERT INTO `customer` VALUES ('5', '00005', '天量股份有限公司', '710000', '西安', '12452233452', '林墨瞳', '15625432252', '交通银行', '432523452345245416', 'tianliang@163.com', '6752432', '西北地区', '2');
INSERT INTO `customer` VALUES ('6', '00006', '万邦股份有限公司', '610000', '成都', '14937294829', '兰陵', '18103652568', '建设银行', '234234681384759427', 'wanbang@163.com', '7456244', '西南地区', '2');
INSERT INTO `customer` VALUES ('7', '00007', '海鑫股份有限公司', '150036', '哈尔滨', '15234524325', '洛离', '14324524523', '邮政储蓄', '546398524024829853', 'haixing@163.com', '3245365', '东北地区', '2');
INSERT INTO `customer` VALUES ('8', '00008', '安麟股份有限公司', 'Mr. WONG Yat-ming', '香港', '18103652568', '华诗', '12439489432', '北京银行', '435798743872584348', 'anlin@163.xom', '2345466', '港澳台地区', '2');
INSERT INTO `customer` VALUES ('9', '00001', '威航股份有限公司', '	\r\n200000', '青岛', '18373829382', '夏舒征', '18109287261', '工商银行', '698337637218736511', 'weihang@163.com', '5424563', '山东', '3');
INSERT INTO `customer` VALUES ('10', '00002', '华城股份有限公司', '510000', '青岛', '15198274671', '凌霜华', '17837625198', '农业银行', '375874618329817456', 'huacheng@163.com', '2345643', '山东', '3');
INSERT INTO `customer` VALUES ('11', '00003', '恩桌股份有限公司', '450000', '淄博', '18390283912', '景茵梦', '12425243523', '邮政储蓄', '332423478678632746', 'enzhuo@163.com', '2345434', '山东', '3');
INSERT INTO `customer` VALUES ('12', '00004', '新天股份有限公司', '100000', '南京', '15345245234', '容柒雁', '15243523455', '建设银行', '342545789234783123', 'xintian@163.com', '3424532', '江苏', '3');
INSERT INTO `customer` VALUES ('13', '00005', '天拓股份有限公司', '710000', '苏州', '12452233452', '林墨瞳', '15625432252', '交通银行', '432523452345245416', 'tiantuo@163.com', '6752432', '江苏', '3');
INSERT INTO `customer` VALUES ('14', '00006', '闪迪股份有限公司', '610000', '南京', '14937294829', '兰陵', '18103652568', '建设银行', '234234681384759427', 'shandi@163.com', '7456244', '江苏', '3');
INSERT INTO `customer` VALUES ('15', '00007', '海鑫股份有限公司', '150036', '合肥', '15234524325', '洛离', '14324524523', '邮政储蓄', '546398524024829853', 'haixing@163.com', '3245365', '安徽', '3');
INSERT INTO `customer` VALUES ('16', '00008', '捷泰安麟股份有限公司', '324543', '马鞍山', '18103652568', '华诗', '12439489432', '北京银行', '435798743872584348', 'jietai@163.xom', '2345466', '安徽', '3');
INSERT INTO `customer` VALUES ('17', '00001', '天畅股份有限公司', '	\r\n423545', '杭州', '18373829382', '夏舒征', '18109287261', '工商银行', '698337637218736511', 'tianchang@163.com', '5424563', '安徽', '3');
INSERT INTO `customer` VALUES ('18', '00002', '研翔股份有限公司', '524523', '杭州', '15198274671', '凌霜华', '17837625198', '农业银行', '375874618329817456', 'yanxiang@163.com', '2345643', '浙江', '3');
INSERT INTO `customer` VALUES ('19', '00003', '宇阳股份有限公司', '342232', '杭州', '18390283912', '景茵梦', '12425243523', '邮政储蓄', '332423478678632746', 'yuyang@163.com', '2345434', '浙江', '3');
INSERT INTO `customer` VALUES ('20', '00004', '徽雕股份有限公司', '435524', '宁波', '15345245234', '容柒雁', '15243523455', '建设银行', '342545789234783123', 'weidiao@163.com', '3424532', '浙江', '3');
INSERT INTO `customer` VALUES ('21', '00005', '海风股份有限公司', '452422', '泉州', '12452233452', '林墨瞳', '15625432252', '交通银行', '432523452345245416', 'haifen@163.com', '6752432', '福建', '3');
INSERT INTO `customer` VALUES ('22', '00006', '酷神股份有限公司', '432555', '厦门', '14937294829', '兰陵', '18103652568', '建设银行', '234234681384759427', 'kushen@163.com', '7456244', '福建', '3');
INSERT INTO `customer` VALUES ('23', '00007', '摩派股份有限公司', '345243', '莆田', '15234524325', '洛离', '14324524523', '邮政储蓄', '546398524024829853', 'mopai@163.com', '3245365', '福建', '3');
INSERT INTO `customer` VALUES ('24', '00008', '寅奕股份有限公司', '432543', '上海', '18103652568', '华诗', '12439489432', '北京银行', '435798743872584348', 'yanyan@163.xom', '2345466', '上海', '3');
INSERT INTO `customer` VALUES ('25', '00001', '天拓股份有限公司', '710000', '广州', '12452233452', '韩千叶', '15625432252', '交通银行', '432523452345245416', 'tiantuo@163.com', '6752432', '广东', '4');
INSERT INTO `customer` VALUES ('26', '00002', '科隆股份有限公司', '610000', '深圳', '14937294829', '夏舒征', '18103652568', '建设银行', '234234681384759427', 'kelong@163.com', '7456244', '广东', '4');
INSERT INTO `customer` VALUES ('27', '00003', '创安股份有限公司', '150036', '珠海', '15234524325', '慕容冲', '14324524523', '邮政储蓄', '546398524024829853', 'chuangan@163.com', '3245365', '广东', '4');
INSERT INTO `customer` VALUES ('28', '00004', '德赛股份有限公司', '324543', '韶山', '18103652568', '萧合凰', '12439489432', '北京银行', '435798743872584348', 'desai@163.xom', '2345466', '广东', '4');
INSERT INTO `customer` VALUES ('29', '00005', '领恒股份有限公司', '	\r\n423545', '韶关', '18373829382', '阮停', '18109287261', '工商银行', '698337637218736511', 'lingheng@163.com', '5424563', '广东', '4');
INSERT INTO `customer` VALUES ('30', '00006', '合创股份有限公司', '524523', '汕头', '15198274671', '西粼宿', '17837625198', '农业银行', '375874618329817456', 'hechuang@163.com', '2345643', '广东', '4');
INSERT INTO `customer` VALUES ('31', '00007', '博卡股份有限公司', '342232', '江门', '18390283912', '孙祈钒', '12425243523', '邮政储蓄', '332423478678632746', 'boka@163.com', '2345434', '广东', '4');
INSERT INTO `customer` VALUES ('32', '00008', '讯诺股份有限公司', '435524', '湛江', '15345245234', '狄云', '15243523455', '建设银行', '342545789234783123', 'xunnuo@163.com', '3424532', '广东', '4');
INSERT INTO `customer` VALUES ('33', '00009', '八洲股份有限公司', '452422', '茂名', '12452233452', '丁典', '15625432252', '交通银行', '432523452345245416', 'bazhou@163.com', '6752432', '广东', '4');
INSERT INTO `customer` VALUES ('34', '00010', '汉邦股份有限公司', '432555', '惠州', '14937294829', '花错', '18103652568', '建设银行', '234234681384759427', 'hanbang@163.com', '7456244', '广东', '4');
INSERT INTO `customer` VALUES ('35', '00011', '开疆股份有限公司', '345243', '梅州', '15234524325', '顾西风', '14324524523', '邮政储蓄', '546398524024829853', 'kaijiang@163.com', '3245365', '广东', '4');
INSERT INTO `customer` VALUES ('36', '00012', '金骏股份有限公司', '432543', '东莞', '18103652568', '统月', '12439489432', '北京银行', '435798743872584348', 'jinjun@163.xom', '2345466', '广东', '4');

-- ----------------------------
-- Table structure for function
-- ----------------------------
DROP TABLE IF EXISTS `function`;
CREATE TABLE `function` (
  `funId` int(11) NOT NULL AUTO_INCREMENT,
  `funHref` varchar(255) DEFAULT NULL,
  `funValue` varchar(255) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`funId`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of function
-- ----------------------------
INSERT INTO `function` VALUES ('1', '', '库存管理模块', null);
INSERT INTO `function` VALUES ('2', 'storeInit', '库存初始化功能', '1');
INSERT INTO `function` VALUES ('3', 'stockOut', '出库单功能', '1');
INSERT INTO `function` VALUES ('4', 'goodsManager', '物料维护管理功能', '1');
INSERT INTO `function` VALUES ('7', '', '订单管理模块', null);
INSERT INTO `function` VALUES ('8', 'order', '查询所有订单', '7');
INSERT INTO `function` VALUES ('9', 'addOrder', '生成订单功能', '7');
INSERT INTO `function` VALUES ('10', 'orderManager', '订单维护功能', '7');
INSERT INTO `function` VALUES ('11', 'orderVerify', '订单审核功能', '7');
INSERT INTO `function` VALUES ('12', 'orderSearch', '订单查询功能', '7');
INSERT INTO `function` VALUES ('13', '', '分销渠道管理模块', null);
INSERT INTO `function` VALUES ('14', 'clientManager', '分销商维护功能', '13');
INSERT INTO `function` VALUES ('15', 'costCount', '分消费计算功能', '13');
INSERT INTO `function` VALUES ('16', 'costVerify', '分消费审核功能', '13');
INSERT INTO `function` VALUES ('17', ' costSearch', '分消费查询功能', '13');
INSERT INTO `function` VALUES ('18', 'payManager', '付款结算管理功能', '13');
INSERT INTO `function` VALUES ('19', '', '数据统计管理模块', null);
INSERT INTO `function` VALUES ('20', 'clientDiagram', '分销商分布图功能', '19');
INSERT INTO `function` VALUES ('21', ' main/content/data/writeVerify.jsp', '订单录入的审核报告', '19');
INSERT INTO `function` VALUES ('22', ' main/content/data/orderCheck.jsp', '订单的抽查报告', '19');
INSERT INTO `function` VALUES ('23', 'distrClearSheet', '月度/季度分销明细表', '19');
INSERT INTO `function` VALUES ('24', 'clientStoreSheet', '分销商的库存报表', '19');
INSERT INTO `function` VALUES ('25', '', '系统设置模块', null);
INSERT INTO `function` VALUES ('26', 'userManager', '用户管理', '25');
INSERT INTO `function` VALUES ('27', 'passwordFix', '密码修改', '25');
INSERT INTO `function` VALUES ('28', 'exportExcel', '打印库存初始化信息', '1');
INSERT INTO `function` VALUES ('29', 'exportOrderExcel', '打印订单信息', '7');
INSERT INTO `function` VALUES ('30', 'exportClientExcel', '打印分销商信息', '13');
INSERT INTO `function` VALUES ('31', 'exportStoreExcel', '打印库存报表', '19');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `number` varchar(5) NOT NULL DEFAULT '00000' COMMENT '商品编号',
  `name` varchar(50) DEFAULT NULL COMMENT '商品名称',
  `productplace` varchar(50) DEFAULT NULL COMMENT '产地',
  `size` varchar(50) DEFAULT NULL COMMENT '规格',
  `package` varchar(50) DEFAULT NULL COMMENT '包装',
  `productcode` varchar(50) DEFAULT NULL COMMENT '生产编号',
  `promitcode` varchar(50) DEFAULT NULL COMMENT '批准文号',
  `price` varchar(8) DEFAULT NULL COMMENT '价格',
  `goodsNum` varchar(11) DEFAULT NULL,
  `available` varchar(20) DEFAULT NULL COMMENT '状态',
  `description` varchar(100) DEFAULT NULL COMMENT '备注',
  `userid` int(100) DEFAULT NULL COMMENT '用户ID，标识该商品是哪个分销商的',
  PRIMARY KEY (`id`),
  KEY `USER_ID_GOODS` (`userid`),
  CONSTRAINT `USER_ID_GOODS` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '00001', '显示器', '深圳', '15.6', '防水、防潮、防震', '432543524', 'AB000006', '950.00', '200', '0', '', '2');
INSERT INTO `goods` VALUES ('2', '00002', '显示器', '广东', '14', '防水、防潮、防震', '324524354', 'AB000007', '800.00', '200', '0', '', '2');
INSERT INTO `goods` VALUES ('3', '00003', '显示器', '广东', '15.6', '防水、防潮、防震', '324546345', 'AB000008', '850.00', '200', '0', '', '2');
INSERT INTO `goods` VALUES ('4', '00004', '键盘', '东莞', '60%（机械）', '防水、防潮', '234523456', 'AB000009', '500.00', '300', '0', '', '2');
INSERT INTO `goods` VALUES ('5', '00005', '键盘', '东莞', '75%（机械）', '防水、防潮', '234514532', 'AB000010', '600.00', '300', '0', '', '2');
INSERT INTO `goods` VALUES ('6', '00006', '键盘', '浙江', '80%（机械）', '防水、防潮', '234556242', 'AB000011', '700.00', '300', '0', '', '2');
INSERT INTO `goods` VALUES ('7', '00007', '键盘', '浙江', '100%（机械）', '防水、防潮', '234573543', 'AB000012', '900.00', '300', '0', '', '2');
INSERT INTO `goods` VALUES ('8', '00008', '鼠标', '深圳', '有线', '防水、防潮', '345755432', 'AB000013', '50.00', '300', '0', '', '2');
INSERT INTO `goods` VALUES ('9', '00009', '鼠标', '深圳', '无限', '防水、防潮', '234537554', 'AB000014', '45.00', '300', '0', '', '2');
INSERT INTO `goods` VALUES ('10', '00010', '鼠标', '广州', '无限', '防水、防潮', '442532545', 'AB000015', '45.00', '300', '0', '', '2');
INSERT INTO `goods` VALUES ('11', '00011', '鼠标', '深圳', '有线', '防水、防潮', '456345645', 'AB000016', '50.00', '300', '0', '', '2');
INSERT INTO `goods` VALUES ('12', '00012', '打印机', '深圳', '分辨率：200 dpi', '防水、防潮，防震', '676987898', 'AB000017', '545.00', '300', '0', '', '2');
INSERT INTO `goods` VALUES ('13', '00013', '打印机', '深圳', '分辨率：300 dpi', '防水、防潮，防震', '345687765', 'AB000018', '545.00', '300', '0', '', '2');
INSERT INTO `goods` VALUES ('14', '00012', '打印机', '东莞', '分辨率：400 dpi、', '防水、防潮，防震', '345609244', 'AB000019', '485.00', '300', '0', '', '2');
INSERT INTO `goods` VALUES ('15', '00013', '打印机', '东莞', '分辨率：200 dpi', '防水、防潮，防震', '245928484', 'AB000020', '745.00', '300', '0', '', '2');
INSERT INTO `goods` VALUES ('16', '00001', '显示器', '深圳', '15.6', '防水、防潮、防震', '432543524', 'AB000006', '950.00', '200', '0', '', '3');
INSERT INTO `goods` VALUES ('17', '00002', '显示器', '广东', '14', '防水、防潮、防震', '324524354', 'AB000007', '800.00', '200', '0', '', '3');
INSERT INTO `goods` VALUES ('18', '00003', '显示器', '广东', '15.6', '防水、防潮、防震', '324546345', 'AB000008', '850.00', '200', '0', '', '3');
INSERT INTO `goods` VALUES ('19', '00004', '键盘', '东莞', '60%（机械）', '防水、防潮', '234523456', 'AB000009', '500.00', '300', '0', '', '3');
INSERT INTO `goods` VALUES ('20', '00005', '键盘', '东莞', '75%（机械）', '防水、防潮', '234514532', 'AB000010', '600.00', '300', '0', '', '3');
INSERT INTO `goods` VALUES ('21', '00006', '键盘', '浙江', '80%（机械）', '防水、防潮', '234556242', 'AB000011', '700.00', '300', '0', '', '3');
INSERT INTO `goods` VALUES ('22', '00007', '键盘', '浙江', '100%（机械）', '防水、防潮', '234573543', 'AB000012', '900.00', '300', '0', '', '3');
INSERT INTO `goods` VALUES ('23', '00008', '鼠标', '深圳', '有线', '防水、防潮', '345755432', 'AB000013', '50.00', '300', '0', '', '3');
INSERT INTO `goods` VALUES ('24', '00009', '鼠标', '深圳', '无限', '防水、防潮', '234537554', 'AB000014', '45.00', '300', '0', '', '3');
INSERT INTO `goods` VALUES ('25', '00010', '鼠标', '广州', '无限', '防水、防潮', '442532545', 'AB000015', '45.00', '300', '0', '', '3');
INSERT INTO `goods` VALUES ('26', '00011', '鼠标', '深圳', '有线', '防水、防潮', '456345645', 'AB000016', '50.00', '300', '0', '', '3');
INSERT INTO `goods` VALUES ('27', '00012', '打印机', '深圳', '分辨率：200 dpi', '防水、防潮，防震', '676987898', 'AB000017', '545.00', '300', '0', '', '3');
INSERT INTO `goods` VALUES ('28', '00013', '打印机', '深圳', '分辨率：300 dpi', '防水、防潮，防震', '345687765', 'AB000018', '545.00', '300', '0', '', '3');
INSERT INTO `goods` VALUES ('29', '00012', '打印机', '东莞', '分辨率：400 dpi、', '防水、防潮，防震', '345609244', 'AB000019', '485.00', '300', '0', '', '3');
INSERT INTO `goods` VALUES ('30', '00013', '打印机', '东莞', '分辨率：200 dpi', '防水、防潮，防震', '245928484', 'AB000020', '745.00', '300', '0', '', '3');
INSERT INTO `goods` VALUES ('31', '00001', '显示器', '深圳', '15.6', '防水、防潮、防震', '432543524', 'AB000006', '950.00', '200', '0', '', '4');
INSERT INTO `goods` VALUES ('32', '00002', '显示器', '广东', '14', '防水、防潮、防震', '324524354', 'AB000007', '800.00', '200', '0', '', '4');
INSERT INTO `goods` VALUES ('33', '00003', '显示器', '广东', '15.6', '防水、防潮、防震', '324546345', 'AB000008', '850.00', '200', '0', '', '4');
INSERT INTO `goods` VALUES ('34', '00004', '键盘', '东莞', '60%（机械）', '防水、防潮', '234523456', 'AB000009', '500.00', '300', '0', '', '4');
INSERT INTO `goods` VALUES ('35', '00005', '键盘', '东莞', '75%（机械）', '防水、防潮', '234514532', 'AB000010', '600.00', '300', '0', '', '4');
INSERT INTO `goods` VALUES ('36', '00006', '键盘', '浙江', '80%（机械）', '防水、防潮', '234556242', 'AB000011', '700.00', '300', '0', '', '4');
INSERT INTO `goods` VALUES ('37', '00007', '键盘', '浙江', '100%（机械）', '防水、防潮', '234573543', 'AB000012', '900.00', '300', '0', '', '4');
INSERT INTO `goods` VALUES ('38', '00008', '鼠标', '深圳', '有线', '防水、防潮', '345755432', 'AB000013', '50.00', '300', '0', '', '4');
INSERT INTO `goods` VALUES ('39', '00009', '鼠标', '深圳', '无限', '防水、防潮', '234537554', 'AB000014', '45.00', '300', '0', '', '4');
INSERT INTO `goods` VALUES ('40', '00010', '鼠标', '广州', '无限', '防水、防潮', '442532545', 'AB000015', '45.00', '300', '0', '', '4');
INSERT INTO `goods` VALUES ('41', '00011', '鼠标', '深圳', '有线', '防水、防潮', '456345645', 'AB000016', '50.00', '300', '0', '', '4');
INSERT INTO `goods` VALUES ('42', '00012', '打印机', '深圳', '分辨率：200 dpi', '防水、防潮，防震', '676987898', 'AB000017', '545.00', '300', '0', '', '4');
INSERT INTO `goods` VALUES ('43', '00013', '打印机', '深圳', '分辨率：300 dpi', '防水、防潮，防震', '345687765', 'AB000018', '545.00', '300', '0', '', '4');
INSERT INTO `goods` VALUES ('44', '00012', '打印机', '东莞', '分辨率：400 dpi、', '防水、防潮，防震', '345609244', 'AB000019', '485.00', '300', '0', '', '4');
INSERT INTO `goods` VALUES ('45', '00013', '打印机', '东莞', '分辨率：200 dpi', '防水、防潮，防震', '245928484', 'AB000020', '745.00', '300', '0', '', '4');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `number` varchar(10) NOT NULL DEFAULT '00000' COMMENT '订单编号',
  `clientId` int(11) NOT NULL COMMENT '客户ID',
  `goodsId` int(11) NOT NULL COMMENT '商品ID',
  `goodsNum` varchar(10) DEFAULT NULL COMMENT '商品数量',
  `orderTime` varchar(20) DEFAULT NULL COMMENT '生成订单时间',
  `sendTime` varchar(20) DEFAULT NULL COMMENT '发货时间',
  `payType` varchar(20) DEFAULT NULL COMMENT '付款方式',
  `description` varchar(100) DEFAULT NULL COMMENT '备注',
  `userid` int(10) DEFAULT NULL COMMENT '用户ID，属于哪个用户的订单',
  `fandian` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `orders_ibfk_1` (`clientId`),
  KEY `orders_ibfk_2` (`goodsId`),
  KEY `order_user_id` (`userid`),
  CONSTRAINT `order_user_id` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`clientId`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '234254', '1', '1', '43', '2017-2-1', '2017-11-1', '支票', '', '2', '5');
INSERT INTO `orders` VALUES ('2', '524524', '1', '2', '32', '2017-3-1', '2017-11-1', '现金', '', '2', '10');
INSERT INTO `orders` VALUES ('3', '324563', '2', '3', '25', '2017-5-1', '2017-11-1', '支票', '', '2', '3');
INSERT INTO `orders` VALUES ('4', '232425', '2', '4', '87', '2017-5-1', '2017-11-1', '现金', '', '2', '2');
INSERT INTO `orders` VALUES ('5', '245243', '3', '5', '35', '2017-6-1', '2017-11-1', '支票', '', '2', '5');
INSERT INTO `orders` VALUES ('6', '234532', '3', '6', '76', '2017-6-1', '2017-11-1', '现金', '', '2', '1');
INSERT INTO `orders` VALUES ('7', '326224', '4', '7', '13', '2017-8-1', '2017-11-1', '支票', '', '2', '2');
INSERT INTO `orders` VALUES ('8', '234523', '4', '8', '98', '2017-8-1', '2017-11-1', '现金', '', '2', '3');
INSERT INTO `orders` VALUES ('9', '243532', '5', '9', '65', '2017-9-1', '2017-11-1', '支票', '', '2', '4');
INSERT INTO `orders` VALUES ('10', '234532', '5', '10', '86', '2017-9-1', '2017-11-1', '现金', '', '2', '1');
INSERT INTO `orders` VALUES ('11', '342524', '6', '11', '45', '2017-10-1', '2017-11-1', '支票', '', '2', '4');
INSERT INTO `orders` VALUES ('12', '234522', '6', '12', '56', '2017-10-1', '2017-11-1', '现金', '', '2', '2');
INSERT INTO `orders` VALUES ('13', '234623', '7', '13', '35', '2017-11-1', '2017-11-1', '支票', '', '2', '4');
INSERT INTO `orders` VALUES ('14', '243522', '7', '14', '75', '2017-11-1', '2017-11-1', '现金', '', '2', '1');
INSERT INTO `orders` VALUES ('15', '245655', '8', '15', '87', '2017-12-1', '2017-11-1', '支票', '', '2', '4');
INSERT INTO `orders` VALUES ('16', '245542', '8', '15', '46', '2017-12-1', '2017-11-1', '现金', '', '2', '1');
INSERT INTO `orders` VALUES ('17', '654324', '8', '15', '44', '2017-1-28', '2017-04-20', '支票', '', '2', '3');
INSERT INTO `orders` VALUES ('27', '322313', '1', '4', '55', '2017-1-28', '2017-11-1', '现金', null, '2', '2');
INSERT INTO `orders` VALUES ('28', '321342', '2', '3', '66', '2017-2-28', '2017-11-1', '支票', null, '2', '2');
INSERT INTO `orders` VALUES ('29', '123433', '3', '3', '44', '2017-4-28', '2017-11-1', '现在', null, '2', '3');
INSERT INTO `orders` VALUES ('30', '234254', '9', '16', '43', '2017-2-1', '2017-11-1', '支票', '', '3', '5');
INSERT INTO `orders` VALUES ('31', '524524', '9', '16', '32', '2017-3-1', '2017-11-1', '现金', '', '3', '10');
INSERT INTO `orders` VALUES ('32', '324563', '10', '17', '25', '2017-5-1', '2017-11-1', '支票', '', '3', '3');
INSERT INTO `orders` VALUES ('33', '232425', '10', '17', '87', '2017-5-1', '2017-11-1', '现金', '', '3', '2');
INSERT INTO `orders` VALUES ('34', '245243', '11', '18', '35', '2017-6-1', '2017-11-1', '支票', '', '3', '5');
INSERT INTO `orders` VALUES ('35', '234532', '11', '18', '76', '2017-6-1', '2017-11-1', '现金', '', '3', '1');
INSERT INTO `orders` VALUES ('36', '326224', '12', '19', '13', '2017-8-1', '2017-11-1', '支票', '', '3', '2');
INSERT INTO `orders` VALUES ('37', '234523', '12', '19', '98', '2017-8-1', '2017-11-1', '现金', '', '3', '3');
INSERT INTO `orders` VALUES ('38', '243532', '13', '20', '65', '2017-9-1', '2017-11-1', '支票', '', '3', '4');
INSERT INTO `orders` VALUES ('39', '234532', '14', '20', '86', '2017-9-1', '2017-11-1', '现金', '', '3', '1');
INSERT INTO `orders` VALUES ('40', '342524', '15', '21', '45', '2017-10-1', '2017-11-1', '支票', '', '3', '4');
INSERT INTO `orders` VALUES ('41', '234522', '16', '21', '56', '2017-10-1', '2017-11-1', '现金', '', '3', '2');
INSERT INTO `orders` VALUES ('42', '234623', '17', '22', '35', '2017-11-1', '2017-11-1', '支票', '', '3', '4');
INSERT INTO `orders` VALUES ('43', '243522', '18', '22', '75', '2017-11-1', '2017-11-1', '现金', '', '3', '1');
INSERT INTO `orders` VALUES ('44', '245655', '19', '23', '87', '2017-12-1', '2017-11-1', '支票', '', '3', '4');
INSERT INTO `orders` VALUES ('45', '245542', '20', '23', '46', '2017-12-1', '2017-11-1', '现金', '', '3', '1');
INSERT INTO `orders` VALUES ('46', '654324', '21', '24', '44', '2017-1-28', '2017-04-20', '支票', '', '3', '3');
INSERT INTO `orders` VALUES ('47', '322313', '22', '24', '55', '2017-1-28', '2017-11-1', '现金', '', '3', '2');
INSERT INTO `orders` VALUES ('48', '321342', '23', '25', '66', '2017-2-28', '2017-11-1', '支票', '', '3', '2');
INSERT INTO `orders` VALUES ('49', '123433', '24', '25', '44', '2017-4-28', '2017-11-1', '现在', '', '3', '3');
INSERT INTO `orders` VALUES ('50', '232425', '25', '31', '87', '2017-5-1', '2017-11-1', '现金', '', '4', '2');
INSERT INTO `orders` VALUES ('51', '245243', '25', '32', '35', '2017-6-1', '2017-11-1', '支票', '', '4', '5');
INSERT INTO `orders` VALUES ('52', '234532', '26', '33', '76', '2017-6-1', '2017-11-1', '现金', '', '4', '1');
INSERT INTO `orders` VALUES ('53', '326224', '26', '34', '13', '2017-8-1', '2017-11-1', '支票', '', '4', '2');
INSERT INTO `orders` VALUES ('54', '234523', '27', '35', '98', '2017-8-1', '2017-11-1', '现金', '', '4', '3');
INSERT INTO `orders` VALUES ('55', '243532', '28', '36', '65', '2017-9-1', '2017-11-1', '支票', '', '4', '4');
INSERT INTO `orders` VALUES ('56', '234532', '29', '37', '86', '2017-9-1', '2017-11-1', '现金', '', '4', '1');
INSERT INTO `orders` VALUES ('57', '342524', '30', '38', '45', '2017-10-1', '2017-11-1', '支票', '', '4', '4');
INSERT INTO `orders` VALUES ('58', '234522', '31', '39', '56', '2017-10-1', '2017-11-1', '现金', '', '4', '2');
INSERT INTO `orders` VALUES ('59', '234623', '32', '40', '35', '2017-11-1', '2017-11-1', '支票', '', '4', '4');
INSERT INTO `orders` VALUES ('60', '243522', '33', '41', '75', '2017-11-1', '2017-11-1', '现金', '', '4', '1');
INSERT INTO `orders` VALUES ('61', '245655', '34', '42', '87', '2017-12-1', '2017-11-1', '支票', '', '4', '4');
INSERT INTO `orders` VALUES ('62', '245542', '35', '43', '46', '2017-12-1', '2017-11-1', '现金', '', '4', '1');
INSERT INTO `orders` VALUES ('63', '654324', '36', '44', '44', '2017-1-28', '2017-04-20', '支票', '', '4', '3');
INSERT INTO `orders` VALUES ('64', '322313', '36', '45', '55', '2017-1-28', '2017-11-1', '现金', '', '4', '2');
INSERT INTO `orders` VALUES ('65', '321342', '36', '45', '66', '2017-2-28', '2017-11-1', '支票', '', '4', '2');
INSERT INTO `orders` VALUES ('66', '123433', '36', '45', '44', '2017-4-28', '2017-11-1', '现在', '', '4', '3');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleId` int(11) NOT NULL,
  `roleName` varchar(255) NOT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'admin');
INSERT INTO `role` VALUES ('2', 'general_manager');
INSERT INTO `role` VALUES ('3', 'area_manager');
INSERT INTO `role` VALUES ('4', 'province_manager');
INSERT INTO `role` VALUES ('5', 'city_manager');

-- ----------------------------
-- Table structure for role_func
-- ----------------------------
DROP TABLE IF EXISTS `role_func`;
CREATE TABLE `role_func` (
  `roleId` int(11) DEFAULT NULL,
  `funcId` int(11) DEFAULT NULL,
  KEY `sdafdsav` (`roleId`),
  KEY `adsfadfeeer` (`funcId`),
  CONSTRAINT `adsfadfeeer` FOREIGN KEY (`funcId`) REFERENCES `function` (`funId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sdafdsav` FOREIGN KEY (`roleId`) REFERENCES `role` (`roleId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_func
-- ----------------------------
INSERT INTO `role_func` VALUES ('1', '27');
INSERT INTO `role_func` VALUES ('1', '27');
INSERT INTO `role_func` VALUES ('1', '27');
INSERT INTO `role_func` VALUES ('1', '27');
INSERT INTO `role_func` VALUES ('1', '27');
INSERT INTO `role_func` VALUES ('1', '27');
INSERT INTO `role_func` VALUES ('1', '27');
INSERT INTO `role_func` VALUES ('1', '27');
INSERT INTO `role_func` VALUES ('1', '27');
INSERT INTO `role_func` VALUES ('1', '27');
INSERT INTO `role_func` VALUES ('1', '27');
INSERT INTO `role_func` VALUES ('1', '27');
INSERT INTO `role_func` VALUES ('1', '27');
INSERT INTO `role_func` VALUES ('1', '27');
INSERT INTO `role_func` VALUES ('1', '27');
INSERT INTO `role_func` VALUES ('1', '27');
INSERT INTO `role_func` VALUES ('1', '27');
INSERT INTO `role_func` VALUES ('1', '27');
INSERT INTO `role_func` VALUES ('1', '27');
INSERT INTO `role_func` VALUES ('1', '27');
INSERT INTO `role_func` VALUES ('1', '27');
INSERT INTO `role_func` VALUES ('1', '27');
INSERT INTO `role_func` VALUES ('1', '27');
INSERT INTO `role_func` VALUES ('1', '27');
INSERT INTO `role_func` VALUES ('1', '27');
INSERT INTO `role_func` VALUES ('1', '27');
INSERT INTO `role_func` VALUES ('1', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');
INSERT INTO `role_func` VALUES ('5', '27');

-- ----------------------------
-- Table structure for stock_out_sheet
-- ----------------------------
DROP TABLE IF EXISTS `stock_out_sheet`;
CREATE TABLE `stock_out_sheet` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `number` varchar(50) NOT NULL DEFAULT '00000' COMMENT '出库单编号',
  `clientId` int(11) NOT NULL COMMENT '客户ID',
  `goodsId` int(11) NOT NULL COMMENT '商品ID',
  `goodsNumber` int(20) DEFAULT NULL COMMENT '商品数量',
  `outTime` varchar(50) DEFAULT NULL COMMENT '出库时间',
  `description` varchar(100) DEFAULT NULL COMMENT '备注',
  `userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `stock_out_sheet_ibfk_1` (`clientId`),
  KEY `stock_out_sheet_ibfk_2` (`goodsId`),
  KEY `asdfakdfbsdfue` (`userid`),
  CONSTRAINT `asdfakdfbsdfue` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `stock_out_sheet_ibfk_1` FOREIGN KEY (`clientId`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `stock_out_sheet_ibfk_2` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stock_out_sheet
-- ----------------------------
INSERT INTO `stock_out_sheet` VALUES ('1', '484948', '1', '1', '50', '2017-10-1', '', '2');
INSERT INTO `stock_out_sheet` VALUES ('2', '435254', '1', '2', '37', '2017-10-1', '', '2');
INSERT INTO `stock_out_sheet` VALUES ('3', '634564', '1', '3', '23', '2017-10-1', '', '2');
INSERT INTO `stock_out_sheet` VALUES ('4', '324524', '2', '4', '34', '2017-10-1', '', '2');
INSERT INTO `stock_out_sheet` VALUES ('5', '523452', '2', '5', '56', '2017-10-1', null, '2');
INSERT INTO `stock_out_sheet` VALUES ('11', '452443', '3', '6', '78', '2017-10-1', null, '2');
INSERT INTO `stock_out_sheet` VALUES ('12', '213431', '3', '7', '87', '2017-10-1', null, '2');
INSERT INTO `stock_out_sheet` VALUES ('13', '134254', '4', '8', '111', '2017-10-1', null, '2');
INSERT INTO `stock_out_sheet` VALUES ('14', '342652', '4', '9', '45', '2017-10-1', null, '2');
INSERT INTO `stock_out_sheet` VALUES ('15', '246546', '5', '10', '89', '2017-10-1', null, '2');
INSERT INTO `stock_out_sheet` VALUES ('16', '234654', '5', '11', '100', '2017-10-1', null, '2');
INSERT INTO `stock_out_sheet` VALUES ('17', '464524', '6', '12', '55', '2017-10-1', null, '2');
INSERT INTO `stock_out_sheet` VALUES ('18', '326542', '6', '13', '76', '2017-10-1', null, '2');
INSERT INTO `stock_out_sheet` VALUES ('19', '426547', '7', '14', '67', '2017-10-1', null, '2');
INSERT INTO `stock_out_sheet` VALUES ('20', '236544', '8', '15', '99', '2017-10-1', null, '2');
INSERT INTO `stock_out_sheet` VALUES ('21', '484948', '9', '1', '50', '2017-10-1', '', '3');
INSERT INTO `stock_out_sheet` VALUES ('22', '435254', '10', '2', '37', '2017-10-1', '', '3');
INSERT INTO `stock_out_sheet` VALUES ('23', '634564', '11', '3', '23', '2017-10-1', '', '3');
INSERT INTO `stock_out_sheet` VALUES ('24', '324524', '12', '4', '34', '2017-10-1', '', '3');
INSERT INTO `stock_out_sheet` VALUES ('25', '523452', '13', '5', '56', '2017-10-1', '', '3');
INSERT INTO `stock_out_sheet` VALUES ('26', '452443', '14', '6', '78', '2017-10-1', '', '3');
INSERT INTO `stock_out_sheet` VALUES ('27', '213431', '15', '7', '87', '2017-10-1', '', '3');
INSERT INTO `stock_out_sheet` VALUES ('28', '134254', '16', '8', '111', '2017-10-1', '', '3');
INSERT INTO `stock_out_sheet` VALUES ('29', '342652', '17', '9', '45', '2017-10-1', '', '3');
INSERT INTO `stock_out_sheet` VALUES ('30', '246546', '18', '10', '89', '2017-10-1', '', '3');
INSERT INTO `stock_out_sheet` VALUES ('31', '234654', '19', '11', '100', '2017-10-1', '', '3');
INSERT INTO `stock_out_sheet` VALUES ('32', '464524', '20', '12', '55', '2017-10-1', '', '3');
INSERT INTO `stock_out_sheet` VALUES ('33', '326542', '21', '13', '76', '2017-10-1', '', '3');
INSERT INTO `stock_out_sheet` VALUES ('34', '426547', '22', '14', '67', '2017-10-1', '', '3');
INSERT INTO `stock_out_sheet` VALUES ('35', '236544', '23', '15', '99', '2017-10-1', '', '3');
INSERT INTO `stock_out_sheet` VALUES ('36', '236544', '25', '31', '99', '2017-10-1', '', '4');
INSERT INTO `stock_out_sheet` VALUES ('37', '484948', '25', '32', '50', '2017-10-1', '', '4');
INSERT INTO `stock_out_sheet` VALUES ('38', '435254', '26', '33', '37', '2017-10-1', '', '4');
INSERT INTO `stock_out_sheet` VALUES ('39', '634564', '26', '34', '23', '2017-10-1', '', '4');
INSERT INTO `stock_out_sheet` VALUES ('40', '324524', '27', '35', '34', '2017-10-1', '', '4');
INSERT INTO `stock_out_sheet` VALUES ('41', '523452', '28', '36', '56', '2017-10-1', '', '4');
INSERT INTO `stock_out_sheet` VALUES ('42', '452443', '29', '37', '78', '2017-10-1', '', '4');
INSERT INTO `stock_out_sheet` VALUES ('43', '213431', '30', '38', '87', '2017-10-1', '', '4');
INSERT INTO `stock_out_sheet` VALUES ('44', '134254', '31', '39', '111', '2017-10-1', '', '4');
INSERT INTO `stock_out_sheet` VALUES ('45', '342652', '32', '40', '45', '2017-10-1', '', '4');
INSERT INTO `stock_out_sheet` VALUES ('46', '246546', '33', '41', '89', '2017-10-1', '', '4');
INSERT INTO `stock_out_sheet` VALUES ('47', '234654', '34', '42', '100', '2017-10-1', '', '4');
INSERT INTO `stock_out_sheet` VALUES ('48', '464524', '35', '43', '55', '2017-10-1', '', '4');
INSERT INTO `stock_out_sheet` VALUES ('49', '326542', '36', '44', '76', '2017-10-1', '', '4');
INSERT INTO `stock_out_sheet` VALUES ('50', '426547', '36', '45', '67', '2017-10-1', '', '4');
INSERT INTO `stock_out_sheet` VALUES ('51', '236544', '36', '45', '99', '2017-10-1', '', '4');

-- ----------------------------
-- Table structure for storecheck
-- ----------------------------
DROP TABLE IF EXISTS `storecheck`;
CREATE TABLE `storecheck` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `goodsId` int(11) NOT NULL COMMENT '商品ID',
  `number` int(20) NOT NULL COMMENT '商品数量',
  `description` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `storecheck_ibfk_1` (`goodsId`),
  CONSTRAINT `storecheck_ibfk_1` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of storecheck
-- ----------------------------
INSERT INTO `storecheck` VALUES ('6', '1', '200', '显示器');
INSERT INTO `storecheck` VALUES ('7', '2', '200', '显示器');
INSERT INTO `storecheck` VALUES ('8', '3', '200', '显示器');
INSERT INTO `storecheck` VALUES ('9', '4', '300', '键盘');
INSERT INTO `storecheck` VALUES ('10', '5', '300', '键盘');
INSERT INTO `storecheck` VALUES ('11', '6', '300', '键盘');
INSERT INTO `storecheck` VALUES ('12', '7', '300', '键盘');
INSERT INTO `storecheck` VALUES ('13', '8', '300', '鼠标');
INSERT INTO `storecheck` VALUES ('14', '9', '300', '鼠标');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `account` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `username` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '111111', '123456', '网管');
INSERT INTO `user` VALUES ('2', '222222', '123456', '张三');
INSERT INTO `user` VALUES ('3', '333333', '123456', '李四');
INSERT INTO `user` VALUES ('4', '444444', '123456', '王五');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `userId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`userId`),
  KEY `fdfadfa` (`roleId`),
  CONSTRAINT `adsf` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fdfadfa` FOREIGN KEY (`roleId`) REFERENCES `role` (`roleId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1');
INSERT INTO `user_role` VALUES ('2', '2');
INSERT INTO `user_role` VALUES ('3', '3');
INSERT INTO `user_role` VALUES ('4', '4');

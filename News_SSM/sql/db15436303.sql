/*
Navicat MySQL Data Transfer

Source Server         : 本地项目数据库(Maxcj)
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : db15436303

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-02-12 16:39:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cmenu
-- ----------------------------
DROP TABLE IF EXISTS `cmenu`;
CREATE TABLE `cmenu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '栏目id',
  `pid` int(11) NOT NULL DEFAULT '0' COMMENT '指定父级id',
  `name` varchar(50) DEFAULT NULL COMMENT '栏目名称',
  `url` varchar(100) DEFAULT NULL COMMENT '链接',
  `permission` varchar(50) DEFAULT NULL COMMENT '权限标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='菜单栏目';

-- ----------------------------
-- Records of cmenu
-- ----------------------------
INSERT INTO `cmenu` VALUES ('1', '0', '新闻管理', null, '1');
INSERT INTO `cmenu` VALUES ('2', '1', '新闻列表', '\r\nnews/goList\r\n', '1');
INSERT INTO `cmenu` VALUES ('3', '1', '添加新闻', 'news/\r\ngoAdd', '1');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `nid` int(100) DEFAULT NULL,
  `comment` text,
  `time` datetime DEFAULT NULL,
  `cname` tinytext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL DEFAULT '0',
  `content` text NOT NULL,
  `date` datetime NOT NULL COMMENT '提交日期',
  `cruser` varchar(50) NOT NULL COMMENT '作者',
  `hitnum` int(11) NOT NULL DEFAULT '0' COMMENT '点击量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8 COMMENT='新闻\r\n';

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('49', '我站在你左侧 却像隔着银河', '<p>我站在你左侧 却像隔着银河</p>', '2018-04-22 00:00:00', 'Maxcj', '16');
INSERT INTO `news` VALUES ('50', 'hold on', '<p>hold on</p>', '2018-04-22 00:00:00', 'Maxcj', '9');
INSERT INTO `news` VALUES ('51', '稻香', '<p>周杰伦</p>', '2018-04-22 00:00:00', 'Maxcj', '2');
INSERT INTO `news` VALUES ('52', '平凡之路', '<p><br/></p><p>2</p>', '2018-04-22 00:00:00', 'Maxcj', '9');
INSERT INTO `news` VALUES ('53', '好好地', '<p><br/></p><p>你好啊</p>', '2018-04-22 00:00:00', 'Maxcj', '14');
INSERT INTO `news` VALUES ('54', '本泽马', '<p><img src=\"/newsssh/upload/image/20180504/1525444296509053748.jpg\" title=\"1525444296509053748.jpg\" alt=\"RUl0-fzvpats0947232.jpg\"/></p><p><br/></p>', '2018-05-04 00:00:00', 'Maxcj', '15');
INSERT INTO `news` VALUES ('55', '西甲-梅西苏神进球C罗贝尔扳平 10人巴萨2-2皇马', '<p><img alt=\"10人巴萨2-2平皇马\" src=\"/newsssh/upload/image/20180508/1525746908237037938.jpg\"/></p><p style=\"margin-top: 0px; margin-bottom: 30px; padding: 0px; text-size-adjust: 100%; color: rgb(77, 79, 83); font-family: &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, 微软雅黑, SimSun, 宋体, Arial; font-size: 18px; letter-spacing: 1px; white-space: normal;\">　　北京时间5月7日02:45(西班牙当地时间6日20:45)，2017/18赛季西甲第36轮一场焦点战在诺坎普球场展开争夺，巴塞罗那主场2比2战平皇家马德里，苏亚雷斯和梅西进球，C罗和贝尔两度扳平，罗伯托半场补时被罚下。巴萨延续赛季不败。</p><p style=\"margin-top: 0px; margin-bottom: 30px; padding: 0px; text-size-adjust: 100%; color: rgb(77, 79, 83); font-family: &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, 微软雅黑, SimSun, 宋体, Arial; font-size: 18px; letter-spacing: 1px; white-space: normal;\">　　皇马在赛季初的超级杯中双杀巴萨，但在圣诞节前主场负于巴萨落后14分与联赛锦标渐行渐远。这是第238场正式比赛交锋，此前皇马95胜49平93负稍占上风。在其中的175场联赛中，皇马72胜33平70负，其中客场20胜18平49负。贝尔、纳乔和卡塞米罗轮换出场。巴萨方面，伊涅斯塔和罗伯托轮换出场。</p><p style=\"margin-top: 0px; margin-bottom: 30px; padding: 0px; text-size-adjust: 100%; color: rgb(77, 79, 83); font-family: &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, 微软雅黑, SimSun, 宋体, Arial; font-size: 18px; letter-spacing: 1px; white-space: normal;\">　　皇马并未列队欢迎提前夺冠的巴萨球员入场。梅西直传，苏亚雷斯禁区右肋10码处侧身扫射被瓦拉内及时挡出底线。随后摩德里奇传球，C罗左边路传射被特尔施特根没收。<strong>巴萨第10分钟取得领先，罗伯托右路传中，瓦拉内冒顶，无人防守的苏亚雷斯远点小禁区前扫射入网。</strong>这是他本赛季第24粒联赛入球。</p><p><img src=\"/newsssh/upload/image/20180508/1525746908346049543.gif\" alt=\"苏亚雷斯破门\"/><span class=\"img_descr\" style=\"line-height: 20px; padding: 6px 0px; font-size: 16px; margin: 5px auto; display: inline-block; zoom: 1; text-align: left; font-weight: bold;\">苏亚雷斯破门</span></p><p style=\"margin-top: 0px; margin-bottom: 30px; padding: 0px; text-size-adjust: 100%; color: rgb(77, 79, 83); font-family: &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, 微软雅黑, SimSun, 宋体, Arial; font-size: 18px; letter-spacing: 1px; white-space: normal;\">　　<strong>皇马第14分钟扳平，C罗脚后跟妙传，克罗斯禁区左侧传中，本泽马远点头球摆渡回门前，C罗近距离抢在皮克之前捅射入网，1-1。</strong>这是他本赛季第25粒联赛入球。这是他在国家德比的第18粒入球，追平皇马名宿迪斯蒂法诺的进球纪录。梅西长传，阿尔巴禁区左侧凌空弹射高出。</p><p><img src=\"http://n.sinaimg.cn/sports/transform/729/w471h258/20180507/ql-e-hacuuvu1842615.gif\" alt=\"C罗得分\"/><span class=\"img_descr\" style=\"line-height: 20px; padding: 6px 0px; font-size: 16px; margin: 5px auto; display: inline-block; zoom: 1; text-align: left; font-weight: bold;\">C罗得分</span></p><p style=\"margin-top: 0px; margin-bottom: 30px; padding: 0px; text-size-adjust: 100%; color: rgb(77, 79, 83); font-family: &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, 微软雅黑, SimSun, 宋体, Arial; font-size: 18px; letter-spacing: 1px; white-space: normal;\">　　纳乔右路传中，C罗10码处头球攻门高出。本泽马回传，克罗斯左路禁区前劲射偏出近角。皇马连续浪费得分机会，第27分钟，摩德里奇直传，C罗禁区右肋12码处单刀射门被特尔施特根出击救出。1分钟后，克罗斯直传，C罗禁区左侧12码处低射，皮球擦远角立柱稍稍偏出。马塞洛传中，C罗远点头球攻门稍稍高出。</p><p><br/></p><p>1</p>', '2018-05-08 00:00:00', 'Maxcj', '87');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` varchar(11) NOT NULL COMMENT '学号',
  `xm` varchar(20) NOT NULL COMMENT '姓名',
  `pwd` varchar(50) NOT NULL COMMENT '密码',
  `bj` varchar(20) NOT NULL COMMENT '班级',
  `role` char(1) NOT NULL COMMENT '角色',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='存储用户信息';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('15436303', 'Maxcj', 'whExiBk3Y8EzD7muzz/kE+IRd7vCndQtDqI1LLDU4OU=', '信息学院', '1');

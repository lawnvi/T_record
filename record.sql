-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- 主机： 127.0.0.1
-- 生成日期： 2020-02-16 06:08:30
-- 服务器版本： 10.1.38-MariaDB
-- PHP 版本： 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 数据库： `record`
--

-- --------------------------------------------------------

--
-- 表的结构 `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `psw` varchar(20) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `community`
--

CREATE TABLE `community` (
  `id` int(11) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  `Fnumber` int(11) DEFAULT NULL,
  `Mnumber` int(11) DEFAULT NULL,
  `infection` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `communitylog`
--

CREATE TABLE `communitylog` (
  `id` int(11) NOT NULL,
  `cid` int(11) DEFAULT NULL,
  `abnormal` int(11) DEFAULT NULL,
  `newTravel` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `family`
--

CREATE TABLE `family` (
  `id` int(11) NOT NULL,
  `name` varchar(25) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `reporter` varchar(255) DEFAULT NULL,
  `psw` varchar(20) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `family`
--

INSERT INTO `family` (`id`, `name`, `address`, `number`, `reporter`, `psw`, `cid`) VALUES
(2, 'IEEE A', '601', 0, '0', NULL, NULL);

-- --------------------------------------------------------

--
-- 表的结构 `member`
--

CREATE TABLE `member` (
  `id` int(11) NOT NULL,
  `name` varchar(25) DEFAULT NULL,
  `sex` enum('男','女') DEFAULT NULL,
  `tel` varchar(25) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `backTime` datetime DEFAULT NULL,
  `backFrom` varchar(128) DEFAULT NULL,
  `fid` int(11) NOT NULL,
  `psw` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `newtravel`
--

CREATE TABLE `newtravel` (
  `id` int(11) NOT NULL,
  `mid` int(11) DEFAULT NULL,
  `date1` datetime DEFAULT NULL,
  `from` varchar(128) DEFAULT NULL,
  `date2` datetime DEFAULT NULL,
  `to` varchar(128) DEFAULT NULL,
  `notes` varchar(512) DEFAULT NULL,
  `way` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `t_log`
--

CREATE TABLE `t_log` (
  `id` int(11) NOT NULL,
  `mid` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `t1` double DEFAULT NULL,
  `t2` double DEFAULT NULL,
  `t1t` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `t2t` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `notes` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转储表的索引
--

--
-- 表的索引 `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cid` (`cid`);

--
-- 表的索引 `community`
--
ALTER TABLE `community`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `communitylog`
--
ALTER TABLE `communitylog`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cid` (`cid`);

--
-- 表的索引 `family`
--
ALTER TABLE `family`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cid` (`cid`);

--
-- 表的索引 `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fid` (`fid`);

--
-- 表的索引 `newtravel`
--
ALTER TABLE `newtravel`
  ADD PRIMARY KEY (`id`),
  ADD KEY `mid` (`mid`);

--
-- 表的索引 `t_log`
--
ALTER TABLE `t_log`
  ADD PRIMARY KEY (`id`),
  ADD KEY `mid` (`mid`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `community`
--
ALTER TABLE `community`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `communitylog`
--
ALTER TABLE `communitylog`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `family`
--
ALTER TABLE `family`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- 使用表AUTO_INCREMENT `member`
--
ALTER TABLE `member`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `newtravel`
--
ALTER TABLE `newtravel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- 限制导出的表
--

--
-- 限制表 `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `community` (`id`);

--
-- 限制表 `communitylog`
--
ALTER TABLE `communitylog`
  ADD CONSTRAINT `communitylog_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `community` (`id`);

--
-- 限制表 `family`
--
ALTER TABLE `family`
  ADD CONSTRAINT `family_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `community` (`id`);

--
-- 限制表 `member`
--
ALTER TABLE `member`
  ADD CONSTRAINT `member_ibfk_1` FOREIGN KEY (`fid`) REFERENCES `family` (`id`);

--
-- 限制表 `newtravel`
--
ALTER TABLE `newtravel`
  ADD CONSTRAINT `newtravel_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `member` (`id`);

--
-- 限制表 `t_log`
--
ALTER TABLE `t_log`
  ADD CONSTRAINT `t_log_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `member` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

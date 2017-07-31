CREATE DATABASE  IF NOT EXISTS `rss_feed` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `rss_feed`;
-- MySQL dump 10.13  Distrib 5.5.9, for Win32 (x86)
--
-- Host: localhost    Database: rss_feed
-- ------------------------------------------------------
-- Server version	5.5.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `C_Name` varchar(45) NOT NULL,
  `C_Desc` varchar(2048) NOT NULL,
  `C_Photo` varchar(450) NOT NULL,
  PRIMARY KEY (`C_Name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES ('Auto Mobiles','News related to the Cars, Bikes etc.','C:\\Users\\VMM-63\\Desktop\\thZT7T26RL.jpg'),('Breaking News','This tell us about all breaking news that are held in our country','C:\\Users\\VMM-63\\Desktop\\breaking-news.jpg'),('Business','News related to the Business, Shares, Profits etc.','C:\\Users\\VMM-63\\Desktop\\6a00e54f95df92883401b8d0868a0d970c.gif'),('Cities','News related the various cities of India','C:\\Users\\VMM-63\\Desktop\\thO0O3DE57.jpg'),('Health','News related to the Health issues','C:\\Users\\VMM-63\\Desktop\\th0OAXHYFH.jpg'),('India','This cloumn tells us the News related to the India.','C:\\Users\\VMM-63\\Desktop\\thGLG9KLPI.jpg'),('Latest Stories','The Latest Knowledge about the News, Stories that are being running in the World','C:\\Users\\VMM-63\\Desktop\\news_mouse.jpg'),('Movies','News related to the Movies which are coming or presently running..','C:\\Users\\VMM-63\\Desktop\\6a00e54f95df92883401b8d0868a0d970c.gif'),('Sports','News related to the Sports, Sports Personality, Achievements in Sports','C:\\Users\\VMM-63\\Desktop\\1.jpg'),('Technology','News related to the Technologies, upcoming or trending. Like- Smartphones, Gadgets, Machinery Works etc. ','C:\\Users\\VMM-63\\Desktop\\thO0O3DE57.jpg'),('Top stories','Top stories description	','C:\\Users\\VMM-63\\Documents\\12.png'),('Videos','News Videos ','C:\\Users\\VMM-63\\Desktop\\th6C3FZJRO.jpg'),('World','This Column tell us the News related to the entire World','');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-09 16:19:41

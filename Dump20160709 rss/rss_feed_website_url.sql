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
-- Table structure for table `website_url`
--

DROP TABLE IF EXISTS `website_url`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `website_url` (
  `URL_id` int(11) NOT NULL AUTO_INCREMENT,
  `URL` varchar(450) DEFAULT NULL,
  `C_name` varchar(45) DEFAULT NULL,
  `Website Name` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`URL_id`),
  KEY `ufk` (`C_name`),
  CONSTRAINT `ufk` FOREIGN KEY (`C_name`) REFERENCES `category` (`C_Name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `website_url`
--

LOCK TABLES `website_url` WRITE;
/*!40000 ALTER TABLE `website_url` DISABLE KEYS */;
INSERT INTO `website_url` VALUES (13,'http://feeds.feedburner.com/ndtvnews-top-stories','Top stories','NDTV'),(14,'http://feeds.feedburner.com/carandbike-latest','Auto Mobiles','NDTV'),(15,'http://feeds.feedburner.com/ndtvnews-trending-news','Breaking News','NDTV'),(16,'http://feeds.feedburner.com/ndtvprofit-latest','Business','NDTV'),(17,'http://feeds.feedburner.com/ndtvnews-cities-news','Cities','NDTV'),(18,'http://feeds.feedburner.com/ndtvcooks-latest','Health','NDTV'),(19,'http://feeds.feedburner.com/ndtvnews-india-news','India','NDTV'),(20,'http://feeds.feedburner.com/ndtvnews-latest','Latest Stories','NDTV'),(21,'http://feeds.feedburner.com/ndtvmovies-latest','Movies','NDTV'),(22,'http://feeds.feedburner.com/ndtvsports-latest','Sports','NDTV'),(23,'http://feeds.feedburner.com/gadgets360-latest','Technology','NDTV'),(24,'http://feeds.feedburner.com/ndtv/videos','Videos','NDTV'),(25,'http://feeds.feedburner.com/ndtvnews-world-news','World','NDTV');
/*!40000 ALTER TABLE `website_url` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-09 16:19:42

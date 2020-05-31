-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: JavaWebDB
-- ------------------------------------------------------
-- Server version	5.7.18

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
-- Table structure for table `olist`
--

DROP TABLE IF EXISTS `olist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `olist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productname` varchar(45) NOT NULL,
  `product_id` varchar(45) NOT NULL,
  `number` varchar(45) NOT NULL,
  `price` int(11) NOT NULL,
  `total_price` double NOT NULL,
  `username` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `olist`
--

LOCK TABLES `olist` WRITE;
/*!40000 ALTER TABLE `olist` DISABLE KEYS */;
INSERT INTO `olist` VALUES (48,'Teapot','3','2',500,1000,'1'),(49,'Watch','5','1',1000,1000,'1'),(50,'Printer','1','1',2000,2000,'1'),(51,'Printer','1','1',2000,2000,'1'),(52,'Printer','1','1',2000,2000,'1'),(53,'Printer','1','1',2000,2000,'1'),(54,'Printer','1','2',2000,4000,'1'),(55,'Printer','1','2',2000,2000,'1'),(56,'Printer','1','2',2000,2000,'1'),(57,'Printer','1','1',2000,2000,'1'),(58,'Printer','1','1',2000,2000,'1'),(59,'Roadmaster','2','4',150,150,'1'),(60,'Roadmaster','2','4',150,150,'1'),(61,'Roadmaster','2','2',150,300,'1'),(62,'Roadmaster','2','2',150,300,'1'),(63,'Roadmaster','2','99',150,14850,'1'),(64,'Roadmaster','2','99',150,14850,'1'),(65,'Roadmaster','2','99',150,14850,'1'),(66,'Roadmaster','2','99',150,14850,'1'),(67,'Roadmaster','2','99',150,14850,'1'),(68,'Roadmaster','2','99',150,14850,'1'),(69,'Roadmaster','2','99',150,14850,'1'),(70,'Roadmaster','2','5',150,750,'1'),(71,'Roadmaster','2','5',150,750,'1'),(72,'Roadmaster','2','1',150,150,'1'),(73,'Roadmaster','2','1',150,150,'1'),(74,'Printer','1','1',2000,2000,'1'),(75,'Printer','1','1',2000,2000,'1'),(76,'Roadmaster','2','1',150,150,'1'),(77,'Roadmaster','2','82',150,12300,'1'),(78,'Robotic Arm','4','6',1500,1500,'1'),(79,'Roadmaster','2','1',150,150,'1'),(80,'Printer','1','1',2000,2000,'1'),(81,'Weight Lifting Robot','5','1',1000,1000,'1'),(82,'Printer','1','45',2000,90000,'111'),(83,'Bionic Robot','3','1',500,500,'111'),(84,'Printer','1','1',2000,2000,'1'),(85,'Printer','1','1',2000,2000,'1'),(86,'Roadmaster','2','1',150,150,'1'),(87,'Roadmaster','2','18',150,1200,'1'),(88,'Printer','1','134',2000,268000,'1'),(89,'Printer','1','3',2000,2000,'1'),(90,'Robotic Arm','4','1',1500,1500,'1'),(91,'Weight Lifting Robot','5','1',1000,1000,'1'),(92,'Bionic Robot','3','1',500,500,'1'),(93,'Roadmaster','2','2',150,300,'1'),(94,'Roadmaster','2','2',150,300,'1'),(95,'Printer','1','2',2000,4000,'1'),(96,'Bionic Robot','3','3',500,1500,'1'),(97,'Weight Lifting Robot','5','5',1000,5000,'1'),(98,'Printer','1','2',2000,4000,'1');
/*!40000 ALTER TABLE `olist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-12 18:06:05

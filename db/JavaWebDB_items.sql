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
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `picture` varchar(500) DEFAULT NULL,
  `details` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (1,'Printer',2000,301,'1','Feature: Simple Structure, Easy Operation, Strong Function and Simple Assenmbly\rSuitable Place: Science museum, science and technology innovation activity, Robot exhibition hall and lab, C-language and Automation course Parameter：One MINI driver, Two steering engines, Four AAA battery, Size: 125*85*85MM'),(2,'Roadmaster',150,76,'2','It is an off-road vehicle and belongs to fire robot, which is controlled under open network port RS232 system. It is designed with a high power motor(750W) and MIL tank vibration system to ensure high quality working in any extreme case. Contrary to traditional transport robot, maximum load reaches 100kg and steering capacity is more flexible.'),(3,'Bionic Robot',500,995,'3','We design this robot as spider model to simulate human legs. Six legs structure can ensure flexible moving and steering capacity. We use aluminium alloy as the product material and the weight of robot is only 1.92kg. 7.2V and 2200mAh lithium battery makes the stand-by time at least 2h. It can be controlled by traditional electronic devices like PS2, Phone and PC, also, it supports voice control and gesture control.'),(4,'Robotic Arm',1500,593,'4','Wireless handle control, Online debugging, Offline operation, Mouse remote, Online and Off online touch development and Detailed tutorials. This product includes 6 joints, 300g maximum load, 16M memory space and 60min stand-by time. The built-in system contains low voltage alarm and over-current protection.'),(5,'Weight Lifting Robot',1000,893,'5','This is lifting-robot with a cool look. It supports PS2 or APP controlling no matter an IOS user or Android user. A).Basic parameter: Size:  270*220*160MM, Weight: 1.3KG, Working voltage: 6.5V-7.4V, Stand-by time: 1h   B). Functional parameter: Maximum load: 7.5KG, Speed: 0.54M/S, PS2 and C). APP control:  within 15M, Support 17°slope , ultrasonic fault detection scope：2cm-450cm');
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
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

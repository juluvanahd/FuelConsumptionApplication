-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: restapi
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `data`
--

DROP TABLE IF EXISTS `data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `data` (
  `id` int NOT NULL AUTO_INCREMENT,
  `driverID` int NOT NULL,
  `fuelType` varchar(2) NOT NULL,
  `price` decimal(13,2) NOT NULL,
  `liters` decimal(13,2) NOT NULL,
  `date` date NOT NULL,
  `totalPrice` decimal(13,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data`
--

LOCK TABLES `data` WRITE;
/*!40000 ALTER TABLE `data` DISABLE KEYS */;
INSERT INTO `data` VALUES (1,16,'98',1.54,59.54,'2002-08-27',91.69),(2,1,'95',1.72,69.74,'2010-02-17',119.95),(3,17,'95',1.69,82.23,'2011-09-14',138.97),(4,16,'D',1.90,66.47,'2013-12-17',126.29),(5,19,'98',1.77,20.47,'2015-02-07',36.23),(6,13,'95',1.03,19.52,'2009-05-22',20.11),(7,6,'95',1.63,23.31,'2018-11-17',38.00),(8,13,'98',1.10,5.74,'2005-10-25',6.31),(9,10,'D',1.59,32.75,'2006-05-10',52.07),(10,18,'98',1.38,33.64,'2014-06-24',46.42),(11,11,'95',1.97,73.93,'2001-08-29',145.64),(12,11,'95',1.34,83.18,'2009-07-23',111.46),(13,0,'95',1.53,22.90,'2003-08-22',35.04),(14,7,'D',1.47,87.05,'2017-09-20',127.96),(15,11,'98',1.85,37.45,'2003-05-27',69.28),(16,10,'95',1.45,87.76,'2016-03-28',127.25),(17,18,'98',1.70,46.28,'2018-02-04',78.68),(18,13,'95',1.90,15.03,'2007-02-22',28.56),(19,13,'D',1.27,57.05,'2005-10-03',72.45),(20,8,'D',1.37,14.59,'2019-03-26',19.99),(21,10,'98',1.51,44.23,'2003-01-21',66.79),(22,6,'98',1.60,56.96,'2011-03-03',91.14),(23,19,'95',1.46,2.16,'2010-11-23',3.15),(24,6,'D',1.07,31.62,'2009-12-29',33.83),(25,15,'95',1.33,51.41,'2004-02-05',68.38),(26,13,'D',1.29,8.74,'2014-05-02',11.27),(27,11,'98',1.32,90.81,'2006-03-15',119.87),(28,13,'98',1.26,31.02,'2011-10-25',39.09),(29,17,'D',1.33,58.31,'2007-12-24',77.55),(30,2,'D',1.25,2.69,'2019-07-27',3.36),(31,1,'D',1.06,63.72,'2003-08-13',67.54),(32,19,'D',1.00,23.79,'2009-08-25',23.79),(33,6,'95',1.53,84.46,'2019-08-07',129.22),(34,13,'98',1.56,70.22,'2017-03-22',109.54),(35,2,'95',1.77,71.68,'2012-04-07',126.87),(36,16,'98',1.75,11.60,'2001-07-04',20.30),(37,4,'98',1.27,10.10,'2012-12-31',12.83),(38,14,'98',1.68,72.78,'2006-11-27',122.27),(39,15,'98',1.03,81.89,'2005-02-06',84.35),(40,7,'D',1.49,59.54,'2013-12-29',88.71),(41,17,'D',1.56,15.76,'2017-03-27',24.59),(42,18,'95',1.35,2.52,'2007-01-22',3.40),(43,15,'98',1.90,16.27,'2005-03-19',30.91),(44,12,'98',1.43,19.59,'2005-08-19',28.01),(45,9,'95',1.83,35.76,'2002-03-20',65.44),(46,18,'95',1.95,46.22,'2004-10-08',90.13),(47,7,'98',1.16,40.79,'2003-08-28',47.32),(48,6,'98',1.12,23.12,'2013-12-31',25.89),(49,12,'D',1.67,37.56,'2011-10-17',62.73),(50,11,'98',1.88,55.87,'2012-09-30',105.04),(51,2,'95',1.30,31.43,'2004-02-02',40.86),(52,6,'95',1.20,4.70,'2018-07-08',5.64),(53,17,'95',1.89,77.73,'2019-02-19',146.91),(54,0,'95',1.49,97.03,'2018-05-29',144.57),(55,8,'95',1.21,48.75,'2013-07-07',58.99),(56,13,'D',1.46,75.93,'2010-07-30',110.86),(57,12,'98',1.40,81.61,'2001-12-28',114.25),(58,7,'D',1.85,20.40,'2016-10-30',37.74),(59,5,'D',1.08,29.73,'2016-08-24',32.11),(60,9,'D',1.89,41.10,'2011-03-09',77.68),(61,11,'98',1.91,63.03,'2003-11-20',120.39),(62,0,'98',1.82,63.00,'2011-01-07',114.66),(63,8,'95',1.45,50.93,'2005-08-15',73.85),(64,13,'98',1.08,67.80,'2011-05-25',73.22),(65,12,'98',1.30,13.06,'2012-11-22',16.98),(66,9,'95',1.92,64.69,'2004-06-23',124.20),(67,13,'D',1.06,20.13,'2019-05-11',21.34),(68,17,'98',1.77,62.23,'2001-07-15',110.15),(69,11,'95',1.22,64.42,'2007-12-04',78.59),(70,13,'95',1.58,1.69,'2003-06-25',2.67),(71,14,'D',1.22,83.25,'2018-12-25',101.57),(72,7,'D',1.79,97.71,'2014-02-22',174.90),(73,19,'D',1.17,40.66,'2017-01-28',47.57),(74,9,'95',1.25,53.36,'2008-05-31',66.70),(75,7,'D',1.46,60.12,'2019-05-12',87.78),(76,0,'D',1.66,72.52,'2019-03-13',120.38),(77,19,'D',1.91,47.32,'2010-04-13',90.38),(78,16,'98',1.23,24.43,'2011-09-18',30.05),(79,7,'95',1.80,90.66,'2001-10-04',163.19),(80,14,'D',1.82,78.22,'2018-10-01',142.36),(81,2,'98',1.05,58.71,'2015-12-21',61.65),(82,14,'D',1.62,85.66,'2018-12-18',138.77),(83,8,'98',1.07,1.94,'2014-10-19',2.08),(84,10,'D',1.71,88.36,'2000-11-12',151.10),(85,13,'98',1.02,93.92,'2001-02-11',95.80),(86,17,'98',1.55,51.34,'2004-12-05',79.58),(87,11,'95',1.88,77.98,'2016-05-06',146.60),(88,14,'D',1.33,66.63,'2015-08-06',88.62),(89,7,'95',1.37,28.82,'2003-01-27',39.48),(90,10,'D',1.79,16.83,'2011-01-05',30.13),(91,15,'98',1.94,73.90,'2005-04-15',143.37),(92,16,'98',1.11,53.15,'2018-08-19',59.00),(93,11,'D',1.11,61.07,'2007-09-04',67.79),(94,6,'D',1.29,19.39,'2000-10-21',25.01),(95,2,'95',1.04,10.55,'2012-10-15',10.97),(96,10,'D',1.74,78.59,'2010-05-09',136.75),(97,8,'D',1.39,95.39,'2009-07-08',132.59),(98,16,'98',1.14,51.60,'2019-09-15',58.82),(99,9,'98',1.80,72.68,'2004-08-16',130.82),(100,10,'95',1.76,89.54,'2016-10-23',157.59);
/*!40000 ALTER TABLE `data` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-19 14:07:13

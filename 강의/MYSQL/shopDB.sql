CREATE DATABASE  IF NOT EXISTS `shopdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `shopdb`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: shopdb
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `summer_olympic_medal`
--

DROP TABLE IF EXISTS `summer_olympic_medal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `summer_olympic_medal` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nation` char(2) NOT NULL,
  `count` int NOT NULL,
  `year` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `summer_olympic_medal`
--

LOCK TABLES `summer_olympic_medal` WRITE;
/*!40000 ALTER TABLE `summer_olympic_medal` DISABLE KEYS */;
INSERT INTO `summer_olympic_medal` VALUES (1,'A',10,2012),(2,'A',7,2016),(3,'B',3,2012),(4,'B',4,2016),(5,'C',6,2012),(6,'C',9,2016),(7,'D',2,2012),(8,'D',13,2016);
/*!40000 ALTER TABLE `summer_olympic_medal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `winter_olympic_medal`
--

DROP TABLE IF EXISTS `winter_olympic_medal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `winter_olympic_medal` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nation` char(2) NOT NULL,
  `count` int NOT NULL,
  `location` varchar(45) NOT NULL,
  `first_rank_count` int NOT NULL,
  PRIMARY KEY (`id`,`first_rank_count`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `winter_olympic_medal`
--

LOCK TABLES `winter_olympic_medal` WRITE;
/*!40000 ALTER TABLE `winter_olympic_medal` DISABLE KEYS */;
INSERT INTO `winter_olympic_medal` VALUES (1,'A',7,'러시아 소치',29),(2,'A',9,'대한민국 평창',39),(3,'B',10,'러시아 소치',29),(4,'B',14,'대한민국 평창',39),(5,'C',5,'러시아 소치',29),(6,'C',9,'대한민국 평창',39),(7,'D',10,'러시아 소치',29),(8,'D',12,'대한민국 평창',39),(9,'E',4,'러시아 소치',29),(10,'E',5,'대한민국 평창',39);
/*!40000 ALTER TABLE `winter_olympic_medal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'shopdb'
--

--
-- Dumping routines for database 'shopdb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-27 23:40:22

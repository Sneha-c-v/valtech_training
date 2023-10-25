-- MySQL dump 10.13  Distrib 8.1.0, for Win64 (x86_64)
--
-- Host: localhost    Database: valtech2023
-- ------------------------------------------------------
-- Server version	8.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `did` int NOT NULL,
  `dname` varchar(20) DEFAULT NULL,
  `dlocation` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'ASD','Bangalore'),(2,'HR','New York'),(3,'Marketing','Los Angeles'),(4,'Finance','Chicago'),(5,'Research Development','Boston'),(6,'Sales','Miami');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `eid` int NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `experience` int DEFAULT NULL,
  `seniority` int DEFAULT NULL,
  `salary` int DEFAULT NULL,
  `did` int DEFAULT NULL,
  PRIMARY KEY (`eid`),
  KEY `did` (`did`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`did`) REFERENCES `department` (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'DHANUSH V',22,1,1,45000,1),(2,'Puneeth',22,1,1,45000,1),(3,'John Doe',30,5,3,60000,2),(4,'Jane Smith',28,3,2,45000,3),(5,'Bob Johnson',35,8,3,75000,4),(6,'Alice Brown',25,2,1,40000,5),(7,'Charlie Wilson',40,12,3,90000,6),(8,'Emily Davis',27,4,2,50000,2),(9,'David Lee',32,7,3,70000,3),(10,'Susan Miller',29,5,2,48000,4),(11,'Michael Taylor',37,10,3,80000,5),(12,'Lisa Anderson',26,3,2,46000,6),(13,'Mark Robinson',34,6,3,67000,2),(14,'Sarah White',31,4,2,52000,3),(15,'James Harris',33,8,3,75000,4),(16,'Olivia Jackson',28,3,2,45000,5),(17,'William Brown',29,7,3,72000,6),(18,'Emily Davis',27,4,2,50000,2),(19,'Matthew Clark',36,9,3,78000,3),(20,'Emma Garcia',26,2,1,42000,4),(21,'Daniel Martinez',38,11,3,82000,5),(22,'Grace Thompson',30,5,2,48000,6),(24,'Pranav',24,1,1,25000,1),(25,'Dekshith',23,2,2,345566,1);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-23 10:32:06

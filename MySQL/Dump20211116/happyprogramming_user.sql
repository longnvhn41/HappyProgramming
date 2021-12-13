-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: happyprogramming
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(100) DEFAULT NULL,
  `account` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `DOB` varchar(50) DEFAULT NULL,
  `gender` bit(1) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `role` int DEFAULT NULL,
  `ava` varchar(100) DEFAULT NULL,
  `framework` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'DangHoangTuan','TuanDang','1','tuandhhe153154@fpt.edu.vn','0354204177','29/06/1997',_binary '','Ha Giang',1,NULL,'SQL'),(2,'NguyenTuanDuong','Duongtd','1','Duongtd@fpt.edu.vn','12453315','29/06/1997',_binary '','Dien Bien',1,NULL,'.Net'),(3,'Nguyen Hoang Ha','ha12','1','hahaa@gmail.com','0354204199','29/06/1997',_binary '','Phu Tho',0,NULL,'java'),(4,'Duong Thu Uyen','uyen12','1','uyenhn@gmail.com','0354204188','29/06/1997',_binary '\0','Bac Kan',1,NULL,NULL),(5,'Nguyen Van Long','long41','1','longnvha140412@fpt.edu.vn','0865993669','04/01/1998',_binary '','Ha Noi',0,NULL,'C#'),(6,'Tran Quy Tung','tung1','1','tung12@gmail.com','0235204177','12/08/1995',_binary '','Yen Bai',1,NULL,'null'),(7,'Nguyen Thi Duyen','duyen12','12','duyen12@fpt.edu.vn','0389818823','30/01/1998',_binary '','Ha Nam',1,NULL,NULL),(8,'Tran Tuan','tuan1','1234','tuanaa@mentor.com','0912381234','22/04/1975',_binary '','Ha Noi',0,NULL,'C#'),(9,'Le Phuong Anh','anh12','1234','anhanh@gmail.com','0923244444','12/05/1982',_binary '\0','Nam Dinh',0,NULL,'C#'),(10,'Dao Hong Quang','quang123','1234','quangtuan12@gmail.com','0812742422','12/06/1988',_binary '','Nam Dinh',0,NULL,'C#'),(11,NULL,'admin','admin',NULL,NULL,NULL,NULL,NULL,2,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-16 19:44:58

-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: 5619pet
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrator` (
  `administratorId` int NOT NULL AUTO_INCREMENT,
  `administratorPermissions` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`administratorId`),
  UNIQUE KEY `administratorId_UNIQUE` (`administratorId`),
  CONSTRAINT `administrator` FOREIGN KEY (`administratorId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrator`
--

LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expert`
--

DROP TABLE IF EXISTS `expert`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expert` (
  `expertId` int NOT NULL AUTO_INCREMENT,
  `expertProfile` varchar(45) DEFAULT NULL,
  `expertRating` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`expertId`),
  UNIQUE KEY `ExpertID_UNIQUE` (`expertId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expert`
--

LOCK TABLES `expert` WRITE;
/*!40000 ALTER TABLE `expert` DISABLE KEYS */;
/*!40000 ALTER TABLE `expert` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expertdialogue`
--

DROP TABLE IF EXISTS `expertdialogue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expertdialogue` (
  `expertDialogueId` int NOT NULL AUTO_INCREMENT,
  `expertId` int NOT NULL,
  `userId` int NOT NULL,
  `info` varchar(45) NOT NULL,
  PRIMARY KEY (`expertDialogueId`),
  UNIQUE KEY `expertDialogueId_UNIQUE` (`expertDialogueId`),
  KEY `expertDialogueOfExpertId_idx` (`expertId`),
  KEY `expertDialogueOfUserId_idx` (`userId`),
  CONSTRAINT `expertDialogueOfExpertId` FOREIGN KEY (`expertId`) REFERENCES `expert` (`expertId`),
  CONSTRAINT `expertDialogueOfUserId` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expertdialogue`
--

LOCK TABLES `expertdialogue` WRITE;
/*!40000 ALTER TABLE `expertdialogue` DISABLE KEYS */;
/*!40000 ALTER TABLE `expertdialogue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `petdiary`
--

DROP TABLE IF EXISTS `petdiary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `petdiary` (
  `petDiaryId` int unsigned NOT NULL AUTO_INCREMENT,
  `value` varchar(45) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `userId` int DEFAULT NULL,
  PRIMARY KEY (`petDiaryId`),
  UNIQUE KEY `petDiaryId_UNIQUE` (`petDiaryId`),
  KEY `userId_idx` (`userId`),
  CONSTRAINT `userIdOfPetDiary` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=8557 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `petdiary`
--

LOCK TABLES `petdiary` WRITE;
/*!40000 ALTER TABLE `petdiary` DISABLE KEYS */;
INSERT INTO `petdiary` VALUES (1,'e','2023/10/26 00:00',456800),(3,'je','2023/10/26 00:00',1230),(5,'je','2023/10/26 00:00',1230),(6,'je','2023/10/26 00:00',1230),(7,'je','2023/10/26 00:00',1230),(8,'je555','2023/10/26 00:00',1230),(9,'je555','2023/10/26 00:00',1230),(10,'je456555','2023/10/26 00:00',1230),(325,'qqqqqq','2023/10/25 00:00',3790),(444,'wwww','20230405',3790),(748,'wohao','20230101',3790),(751,'151','2023/10/25 00:00',3790),(754,'666666','2023/10/26 00:00',3790),(8556,'88888888','2023/10/26 00:00',3790);
/*!40000 ALTER TABLE `petdiary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `postId` int NOT NULL AUTO_INCREMENT,
  `userId` int NOT NULL,
  `postTitle` varchar(45) NOT NULL,
  `postContent` varchar(45) DEFAULT NULL,
  `postImage` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`postId`),
  UNIQUE KEY `postId_UNIQUE` (`postId`),
  KEY `userIdofPost_idx` (`userId`),
  CONSTRAINT `userIdofPost` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=1252 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (1249,456800,'dog is cute','my dog is very cute',NULL),(1250,456800,'dog is cute','my dog is very cute',NULL),(1251,456800,'dog is cute','my dog is very cute',NULL);
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `productId` int NOT NULL AUTO_INCREMENT,
  `userId` int NOT NULL,
  `productName` varchar(45) NOT NULL,
  `pet` varchar(45) DEFAULT NULL,
  `productInformation` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`productId`),
  UNIQUE KEY `productId_UNIQUE` (`productId`),
  KEY `creatorIdOfProduct_idx` (`userId`),
  CONSTRAINT `creatorIdOfProduct` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productreview`
--

DROP TABLE IF EXISTS `productreview`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productreview` (
  `reviewId` int NOT NULL AUTO_INCREMENT,
  `productId` int NOT NULL,
  `userId` int NOT NULL,
  `reviewContent` varchar(45) DEFAULT NULL,
  `rating` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`reviewId`),
  UNIQUE KEY `reviewId_UNIQUE` (`reviewId`),
  KEY `reviewOfProductId_idx` (`productId`),
  KEY `reviewOfUserId_idx` (`userId`),
  CONSTRAINT `reviewOfProductId` FOREIGN KEY (`productId`) REFERENCES `product` (`productId`),
  CONSTRAINT `reviewOfUserId` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productreview`
--

LOCK TABLES `productreview` WRITE;
/*!40000 ALTER TABLE `productreview` DISABLE KEYS */;
/*!40000 ALTER TABLE `productreview` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reply`
--

DROP TABLE IF EXISTS `reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reply` (
  `replyId` int NOT NULL AUTO_INCREMENT,
  `userId` int NOT NULL,
  `postId` int NOT NULL,
  `replyContent` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`replyId`),
  UNIQUE KEY `replyId_UNIQUE` (`replyId`),
  KEY `userIdOfReply_idx` (`userId`),
  KEY `postIdOfReply_idx` (`postId`),
  CONSTRAINT `postIdOfReply` FOREIGN KEY (`postId`) REFERENCES `post` (`postId`),
  CONSTRAINT `userIdOfReply` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reply`
--

LOCK TABLES `reply` WRITE;
/*!40000 ALTER TABLE `reply` DISABLE KEYS */;
INSERT INTO `reply` VALUES (1,456800,1250,'sadfghj'),(9,456800,1250,'ohhhhhhhh'),(10,456800,1250,'ohhhhhhhh');
/*!40000 ALTER TABLE `reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `pet` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `userType` varchar(45) NOT NULL,
  `userState` tinyint DEFAULT '0',
  PRIMARY KEY (`userId`),
  UNIQUE KEY `userId_UNIQUE` (`userId`),
  UNIQUE KEY `userName_UNIQUE` (`userName`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=456905 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1230,'Alice','123456','cat','890@qq,com','individual',0),(1234,'Sam','Aa123','dog','123@qq.com','individual',0),(3456,'Jon','123','dog','789@qq.com','individual',0),(3790,'mimi','222','cat','234@qq.com','individual',1),(3791,'nanami','222','cat','2324@qq.com','individual',0),(456790,'Sam1','Aa123','dog','123456@qq.com','individual',0),(456791,'Sam12','Aa123','dog','156@qq.com','individual',0),(456793,'Sam127','Aa123',NULL,'1213@qq.com','individual',0),(456794,'Ssss','Aa123',NULL,'999@qq.com','individual',0),(456795,'Ss','Aa123',NULL,'112@qq.com','individual',0),(456796,'Sas','Aa123',NULL,'1512@qq.com','individual',0),(456797,'ABC','123456aA!','Cat','100@10.com','individual',0),(456798,'QWE','12345678Qq!','Dog','2@2.com','individual',0),(456799,'momo','123456aA!','cat','momo@mo.com','individual',0),(456800,'momo2','123456aA!','Dog','momo2@10.com','individual',0),(456900,'Ico','2223',NULL,'Ico@qq.com','individual',0),(456901,'mimi123','2222',NULL,'4567@qq.com','individual',0),(456902,'mim','2222',NULL,'45674@qq.com','individual',0),(456903,'omg','2222',NULL,'4567234@qq.com','individual',0),(456904,'osmg','2222',NULL,'4234@qq.com','individual',0);
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

-- Dump completed on 2023-10-26 18:32:06

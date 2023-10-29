-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 47.94.109.63    Database: 5619pet
-- ------------------------------------------------------
-- Server version	8.0.34

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
  `expertRating` float DEFAULT NULL,
  PRIMARY KEY (`expertId`),
  UNIQUE KEY `ExpertID_UNIQUE` (`expertId`),
  CONSTRAINT `expertId` FOREIGN KEY (`expertId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expert`
--

LOCK TABLES `expert` WRITE;
/*!40000 ALTER TABLE `expert` DISABLE KEYS */;
INSERT INTO `expert` VALUES (10,'A cat expert',10),(11,'A dog expert',9);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expertdialogue`
--

LOCK TABLES `expertdialogue` WRITE;
/*!40000 ALTER TABLE `expertdialogue` DISABLE KEYS */;
INSERT INTO `expertdialogue` VALUES (1,10,3790,'why my dog is so cute?'),(2,11,3790,'why my cat is so cute'),(3,10,3790,'what???');
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
) ENGINE=InnoDB AUTO_INCREMENT=8567 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `petdiary`
--

LOCK TABLES `petdiary` WRITE;
/*!40000 ALTER TABLE `petdiary` DISABLE KEYS */;
INSERT INTO `petdiary` VALUES (1,'e','2023/10/26 00:00',456800),(3,'je','2023/10/26 00:00',1230),(5,'je','2023/10/26 00:00',1230),(6,'je','2023/10/26 00:00',1230),(7,'je','2023/10/26 00:00',1230),(8,'je555','2023/10/26 00:00',1230),(9,'je555','2023/10/26 00:00',1230),(10,'je456555','2023/10/26 00:00',1230),(751,'151','2023/10/25 00:00',3790),(754,'666666','2023/10/26 00:00',3790),(8557,'dddd','2023/10/28 00:00',3790),(8564,'以前','2023/10/10 00:00',3790),(8565,'万圣节','2023/10/31 00:00',3790),(8566,'5619 ddl','2023/10/29 23:55',3790);
/*!40000 ALTER TABLE `petdiary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `petrescue`
--

DROP TABLE IF EXISTS `petrescue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `petrescue` (
  `petRescueId` int NOT NULL AUTO_INCREMENT,
  `petRescueTitle` varchar(45) DEFAULT NULL,
  `petRescueContent` text,
  `petRescueAuthor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`petRescueId`),
  UNIQUE KEY `petRescueId_UNIQUE` (`petRescueId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `petrescue`
--

LOCK TABLES `petrescue` WRITE;
/*!40000 ALTER TABLE `petrescue` DISABLE KEYS */;
INSERT INTO `petrescue` VALUES (1,'Animal cruelty in tourism','The lure of being able to observe a wild animal up close is undoubtedly real, and a holiday abroad can often provide such an opportunity.  Whilst some attractions can provide authentic, unobtrusive moments to experience such exhilaration from afar, of wild animals displaying natural behaviours in their own environments, other venues can hide a magnitude of sins beneath their dazzling and ‘creative’ marketing ploys. ### Research conducted by World Animal Protection found that three out of four wildlife tourist attractions involve some form of abuse or conservation concerns, with thousands of tourists simply unaware of what was happening behind the scenes, inadvertently contributing to the cruelty. ### When you arrive at your holiday destination, you might meet local operators trying to advertise their attractions with compelling and captivating stories of wonder. It can be hard not to get carried away in a beautiful destination, but tourists are often told they are supporting elephant conservation or tiger breeding by visiting a certain attraction, but in reality, would be unknowingly supporting animal abuse and the breeding of wildlife in captivity.  Unfortunately, tourists are often exploited for money whilst on their holidays, and the sales tactics used are renowned.  It would pay to think twice before committing.',NULL),(2,'African white-backed vulture ','Although they play a vital role in keeping their environment clean, by eating carrion (dead animals), vultures have gained a bad reputation in films and on TV. But, in reality, vultures are highly intelligent creatures whose populations have declined by 63-89% over the lifespan of three generations. ###African white-backed vultures are critically endangered. ### We’re supporting the Hawk Conservancy Trust in their conservation efforts, as they protect vultures around the world. ### One of the most significant threats to African white-backed vulture populations is poisoning by poachers. The Hawk Conservancy Trust supports Poison Action Response, which trains field staff (working within the habitats of wild vultures) to deal with poisoning events by using Poison Response Kits to save vultures’ lives. ',NULL),(3,'Natterjack toad','As one of the UK’s rarest amphibians, natterjack toads have been in decline for the last 70 years due to habitat loss. If natterjack toads become extinct, that will have a devastating impact on local ecosystems. Also, because they are linked to folklore, the disappearance of natterjack toads would seriously damage eco-tourism in the UK. ### The Amphibian and Reptile Conservation Trust (ARC) is our chosen charity for supporting the natterjack toad. ARC is dedicated to saving natterjack toads through their Species Action Plan, which involves conservation activities including the protection of toad habitats and improving research methods to strengthen natterjack toad populations. ',NULL),(4,'Pangolin','As the most illegally trafficked animal in the world, the pangolin is at risk of extinction. Despite their tough armour, and ability to roll into a ball when threatened, pangolins are repeatedly poached for their scales and meat. ### Fortunately for the pangolin, there are a number of conservation charities working hard to help and protect them. The charity we’ve chosen to partner with to help support the pangolin is the Tusk Trust. ### Created over 30 years ago, the Tusk Trust supports conservation projects that teach communities how to take care of local environments across Africa. ### The Pangolin Project is a non-profit organisation in Kenya that is supported by the Tusk Trust. Thanks to the charity, a Mobile Pangolin Technical Unit (MPTU) has been formed, to provide essential data about pangolin populations.',NULL),(5,'Proboscis monkey','Habit destruction has led to a decline in proboscis monkey populations of approximately 50% in the last 40 years. Proboscis monkeys are also docile yet social creatures, which makes them an easy target for hunters. ### World Land Trust is working hard to save proboscis monkeys, by supporting their conservation partner HUTAN to limit forest loss in Sabah and protect wildlife in its globally recognised Key Biodiversity Area (KBA). ### Top facts about the proboscis monkey: They’ve been known to leap into water from heights of up to 50ft! A group of proboscis monkeys is called a ‘troop’, ‘band’, or ‘harem’. In the wild, they can live for up to 20 years. ',NULL);
/*!40000 ALTER TABLE `petrescue` ENABLE KEYS */;
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
  `postDate` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`postId`),
  UNIQUE KEY `postId_UNIQUE` (`postId`),
  KEY `userIdofPost_idx` (`userId`),
  CONSTRAINT `userIdofPost` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=1254 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (1249,456799,'dog is cute','my dog is very cute',NULL,'2023/10/20 01:15'),(1250,456799,'dog is cute','my dog is very cute',NULL,'2023/10/21 01:15'),(1251,456799,'dog is cute','my dog is very cute',NULL,'2023/10/22 01:15'),(1252,3790,'啊啊啊啊啊','啊啊啊啊1',NULL,'2023/10/22 01:15');
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
  `userId` int DEFAULT NULL,
  `productName` varchar(45) NOT NULL,
  `pet` varchar(45) DEFAULT NULL,
  `productInformation` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`productId`),
  UNIQUE KEY `productId_UNIQUE` (`productId`),
  KEY `creatorIdOfProduct_idx` (`userId`),
  CONSTRAINT `creatorIdOfProduct` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,2222,'Cat boom','cat','Cat Cat Cat'),(2,NULL,'Dog Dog','dog','Dog');
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
  `rating` float DEFAULT NULL,
  PRIMARY KEY (`reviewId`),
  UNIQUE KEY `reviewId_UNIQUE` (`reviewId`),
  KEY `reviewOfProductId_idx` (`productId`),
  KEY `reviewOfUserId_idx` (`userId`),
  CONSTRAINT `reviewOfProductId` FOREIGN KEY (`productId`) REFERENCES `product` (`productId`),
  CONSTRAINT `reviewOfUserId` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productreview`
--

LOCK TABLES `productreview` WRITE;
/*!40000 ALTER TABLE `productreview` DISABLE KEYS */;
INSERT INTO `productreview` VALUES (1,1,3790,'good',9),(2,1,3791,'bad',1),(3,2,3790,'no!!!',5),(4,1,3790,'222',NULL),(5,1,3790,'222',NULL),(6,1,3790,'222',NULL),(7,1,3790,'222',NULL),(8,1,3790,'222',NULL),(9,1,3790,'222',NULL);
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
INSERT INTO `user` VALUES (10,'expert2','2222',NULL,'45674@qq.com','expert',0),(11,'expert1','Aa123',NULL,'999@qq.com','expert',0),(1230,'Alice','123456','cat','890@qq,com','individual',0),(1234,'Sam','Aa123','dog','123@qq.com','individual',0),(2222,'Sam1','Aa123','dog','123456@qq.com','individual',0),(3456,'Jon','123','dog','789@qq.com','individual',0),(3790,'mimi','222','cat','234@qq.com','individual',1),(3791,'nanami','222','cat','2324@qq.com','individual',0),(456791,'Sam12','Aa123','dog','156@qq.com','individual',0),(456793,'Sam127','Aa123',NULL,'1213@qq.com','individual',0),(456795,'Ss','Aa123',NULL,'112@qq.com','individual',0),(456796,'Sas','Aa123',NULL,'1512@qq.com','individual',0),(456797,'ABC','123456aA!','Cat','100@10.com','individual',0),(456798,'QWE','12345678Qq!','Dog','2@2.com','individual',0),(456799,'momo','123456aA!','cat','momo@mo.com','individual',0),(456800,'momo2','123456aA!','Dog','momo2@10.com','individual',0),(456900,'Ico','2223',NULL,'Ico@qq.com','individual',0),(456901,'mimi123','2222',NULL,'4567@qq.com','individual',0),(456903,'omg','2222',NULL,'4567234@qq.com','individual',0),(456904,'osmg','2222',NULL,'4234@qq.com','individual',0);
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

-- Dump completed on 2023-10-27 15:16:06

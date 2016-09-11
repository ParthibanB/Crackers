-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.28


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema crackers
--

CREATE DATABASE IF NOT EXISTS crackers;
USE crackers;

--
-- Definition of table `brand`
--

DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `brand`
--

/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` (`id`,`name`,`status`) VALUES 
 (1,'Standard',1);
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;

--
-- Definition of table `categorytype`
--

DROP TABLE IF EXISTS `categorytype`;
CREATE TABLE `categorytype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `categorytype`
--

/*!40000 ALTER TABLE `categorytype` DISABLE KEYS */;
INSERT INTO `categorytype` (`id`,`name`,`status`) VALUES 
 (1,'Crackers',1);
/*!40000 ALTER TABLE `categorytype` ENABLE KEYS */;

--
-- Definition of table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `categoryTypeId` int(11) NOT NULL,
  `showInMenu` int(1) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `categoryTypeId` (`categoryTypeId`) USING BTREE,
  CONSTRAINT `Crackers_CategoryType_FK` FOREIGN KEY (`categoryTypeId`) REFERENCES `categorytype` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `category`
--

/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`id`,`name`,`categoryTypeId`,`showInMenu`) VALUES 
 (1,'SPARKLER VARITIES',1,1),
 (2,'CHAKKAR & FLOWER POTS',1,1),
 (3,'FLOWER POTS',1,1),
 (4,'TWINKLING STAR & PENCIL VARIETIES',1,1),
 (5,'PENCILS',1,1),
 (6,'SINGLE SHOT & BOMBS',1,1),
 (7,'BOMBS',1,1),
 (8,'GARLAND & CHORSA CRACKERS',1,1),
 (9,'GIANT & DELUXE CRACKERS',1,1),
 (10,'ROCKET',1,1),
 (11,'CARTOON',1,1),
 (12,'SPECIAL WHEELS',1,1),
 (13,'SMALL FANCY ITEMS',1,1),
 (14,'FANCY FOUNTAINS',1,1),
 (15,'SPECIAL DELUXE FOUNTAINS',1,1),
 (16,'WHISTLING ITEMS',1,1),
 (17,'FANCY AERIAL SHOTS',1,1),
 (18,'REPEATING AERIAL ITEMS',1,1),
 (19,'COLOUR MATCHES',1,1);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;


--
-- Definition of table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `displayName` varchar(50) NOT NULL,
  `categoryId` int(11) NOT NULL,
  `price` decimal(9,2) DEFAULT NULL,
  `unitMeasure` varchar(50) DEFAULT NULL,
  `brandId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Crackers_Category_FK` (`categoryId`),
  KEY `Crackers_Brand_FK` (`brandId`),
  CONSTRAINT `Crackers_Category_FK` FOREIGN KEY (`categoryId`) REFERENCES `category` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Crackers_Brand_FK` FOREIGN KEY (`brandId`) REFERENCES `brand` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product`
--

/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`id`,`name`,`displayName`,`categoryId`,`price`,`unitMeasure`,`brandId`) VALUES 
 (1,'7CM ELECTRIC SPARKLERS','7CM ELECTRIC SPARKLERS',1,'70.00','10 / BOX',1),
 (2,'10CM ELECTRIC SPARKLERS','10CM ELECTRIC SPARKLERS',1,'60.00','10 / BOX',1),
 (3,'12CM ELECTRIC SPARKLERS','12CM ELECTRIC SPARKLERS',1,'18.00','10 / BOX',1),
 (4,'GROUND CHAKKAR BIG','GROUND CHAKKAR BIG',2,'23.00','10 / BOX',1),
 (5,'GROUND CHAKKAR ASOKA','GROUND CHAKKAR ASOKA',2,'32.00','10 / BOX',1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;


--
-- Definition of table `productdetails`
--

DROP TABLE IF EXISTS `productdetails`;
CREATE TABLE `productdetails` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productId` int(11) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `imageUrl` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Crackers_ProductDetails_FK` (`productId`),
  CONSTRAINT `Crackers_ProductDetails_FK` FOREIGN KEY (`productId`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `productdetails`
--

/*!40000 ALTER TABLE `productdetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `productdetails` ENABLE KEYS */;


--
-- Definition of table `order`
--

DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `refNo` varchar(10) NOT NULL,
  `emailId` varchar(50) NOT NULL,
  `shippingAddress` varchar(350) NOT NULL,
  `mobileNumber` varchar(350) NOT NULL,
  `totalAmount` decimal(9,2) DEFAULT NULL,
  `tax` decimal(9,2) DEFAULT NULL,
  `vat` decimal(9,2) DEFAULT NULL,
  `productTotal` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `order`
--

/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;


--
-- Definition of table `orderlistitem`
--

DROP TABLE IF EXISTS `orderlistitem`;
CREATE TABLE `orderlistitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderId` int(11) NOT NULL,
  `productId` int(11) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `amount` decimal(9,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Index_2` (`orderId`,`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `orderlistitem`
--

/*!40000 ALTER TABLE `orderlistitem` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderlistitem` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

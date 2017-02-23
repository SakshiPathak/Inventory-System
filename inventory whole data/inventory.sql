-- MySQL dump 10.11
--
-- Host: localhost    Database: inventory
-- ------------------------------------------------------
-- Server version	5.0.45-community-nt

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
-- Table structure for table `bill`
--

CREATE SCHEMA IF NOT EXISTS `inventory`;
USE `inventory`;

DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `ID` int(11) NOT NULL auto_increment,
  `User_ID` int(11) NOT NULL,
  `Customer_ID` int(11) NOT NULL,
  `Date` date default NULL,
  `Bill` float default NULL,
  `Status` tinyint(1) default NULL,
  `Pending` float default NULL,
  PRIMARY KEY  (`ID`),
  KEY `fk_Bill_Customer1_idx` (`Customer_ID`),
  KEY `fk_Bill_User1_idx` (`User_ID`),
  CONSTRAINT `fk_Bill_Customer1` FOREIGN KEY (`Customer_ID`) REFERENCES `customer` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Bill_User1` FOREIGN KEY (`User_ID`) REFERENCES `user` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `bill_detail`
--

DROP TABLE IF EXISTS `bill_detail`;
CREATE TABLE `bill_detail` (
  `Bill_ID` int(11) NOT NULL,
  `Product_ID` int(11) NOT NULL,
  `Quantity` int(11) default NULL,
  `Discount` float default NULL,
  `Amount` float default NULL,
  KEY `fk_Bill_Detail_Bill1_idx` (`Bill_ID`),
  KEY `fk_Bill_Detail_Product1_idx` (`Product_ID`),
  CONSTRAINT `fk_Bill_Detail_Bill1` FOREIGN KEY (`Bill_ID`) REFERENCES `bill` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Bill_Detail_Product1` FOREIGN KEY (`Product_ID`) REFERENCES `product` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `ID` int(11) NOT NULL auto_increment,
  `Name` varchar(45) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `ID` int(11) NOT NULL auto_increment,
  `First_Name` varchar(45) default NULL,
  `Last_Name` varchar(45) default NULL,
  `Gender` char(1) default NULL,
  `Email` varchar(255) default NULL,
  `Address` text,
  `City` varchar(45) default NULL,
  `Pincode` int(11) default NULL,
  `State` varchar(45) default NULL,
  `Phone` varchar(12) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `ID` int(11) NOT NULL auto_increment,
  `Name` varchar(45) default NULL,
  `Units` varchar(45) default NULL,
  `Quantity` int(11) default NULL,
  `Cost_Price` float default NULL,
  `Sale_Price` float default NULL,
  `MRP` float default NULL,
  `Status` tinyint(1) default NULL,
  `Re_Order_Level` int(11) default NULL,
  `Category_ID` int(11) NOT NULL,
  `Supplier_ID` int(11) NOT NULL,
  PRIMARY KEY  (`ID`),
  KEY `fk_Product_Category1_idx` (`Category_ID`),
  KEY `fk_Product_Supplier1_idx` (`Supplier_ID`),
  CONSTRAINT `fk_Product_Category1` FOREIGN KEY (`Category_ID`) REFERENCES `category` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Product_Supplier1` FOREIGN KEY (`Supplier_ID`) REFERENCES `supplier` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `ID` int(11) NOT NULL auto_increment,
  `Name` varchar(45) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `ID` int(11) NOT NULL auto_increment,
  `Name` varchar(45) default NULL,
  `Address` text,
  `City` varchar(45) default NULL,
  `Pincode` int(11) default NULL,
  `State` varchar(45) default NULL,
  `Phone` varchar(12) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` int(11) NOT NULL auto_increment,
  `Username` varchar(45) default NULL,
  `Password` varchar(45) default NULL,
  `Role_ID` int(11) NOT NULL,
  PRIMARY KEY  (`ID`),
  KEY `fk_User_Role_idx` (`Role_ID`),
  CONSTRAINT `fk_User_Role` FOREIGN KEY (`Role_ID`) REFERENCES `role` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-12 15:21:40

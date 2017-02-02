-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.45-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema inventory
--

CREATE DATABASE IF NOT EXISTS inventory;
USE inventory;

--
-- Definition of table `bill`
--

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
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bill`
--

/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` (`ID`,`User_ID`,`Customer_ID`,`Date`,`Bill`,`Status`,`Pending`) VALUES 
 (1,2,2,'2017-01-04',NULL,1,0),
 (2,2,1,'2017-01-04',NULL,0,829.3),
 (3,1,1,'2017-01-04',3314.7,1,0),
 (4,1,1,'2017-01-05',2743.2,0,743.2),
 (5,2,1,'2017-01-05',2971.8,1,0),
 (6,1,1,'2017-01-06',6743.7,1,0),
 (7,2,1,'2017-01-06',6172.2,1,0),
 (8,1,4,'2017-01-10',5486.4,0,86.4),
 (9,3,4,'2017-01-10',3771.9,1,0),
 (10,2,1,'2017-01-14',6057.9,0,57.9),
 (11,1,6,'2017-01-14',10744.2,1,0),
 (12,4,6,'2017-01-14',5029.2,1,0),
 (13,4,6,'2017-01-14',5143.5,1,0),
 (14,2,16,'2017-01-14',2857.5,1,0),
 (15,2,15,'2017-01-14',2171.7,1,0),
 (16,2,18,'2017-01-14',2057.4,0,57.4),
 (17,1,20,'2017-01-14',51792.8,0,50000),
 (18,1,12,'2017-01-16',2514.6,1,0),
 (19,2,22,'2017-01-16',31432.5,0,1432.5),
 (20,1,23,'2017-01-18',106800,1,0),
 (21,2,26,'2017-01-18',7000,1,0),
 (22,1,29,'2017-01-18',6000,1,0),
 (23,1,31,'2017-01-19',11800,1,0),
 (24,2,32,'2017-01-19',17000,1,0),
 (25,2,32,'2017-01-19',17000,1,0),
 (26,1,27,'2017-01-19',3400,1,0),
 (27,1,26,'2017-01-19',6200,1,0),
 (28,2,2,'2017-01-19',2200,1,0),
 (29,2,1,'2017-01-21',3700,1,0),
 (30,1,31,'2017-01-21',9800,1,0),
 (31,2,17,'2017-01-23',62500,0,20000),
 (32,2,17,'2017-01-23',17500,0,7500),
 (33,1,27,'2017-01-31',16700,0,3300),
 (34,1,23,'2017-02-01',341391,0,175642),
 (35,6,33,'2017-02-01',41765,1,0);
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;


--
-- Definition of table `bill_detail`
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
-- Dumping data for table `bill_detail`
--

/*!40000 ALTER TABLE `bill_detail` DISABLE KEYS */;
INSERT INTO `bill_detail` (`Bill_ID`,`Product_ID`,`Quantity`,`Discount`,`Amount`) VALUES 
 (1,1,2,200,2000),
 (5,1,1,200,1000),
 (5,2,2,200,1600),
 (6,1,3,100,3300),
 (6,2,2,100,1800),
 (6,2,1,200,800),
 (7,2,6,100,5400),
 (8,1,1,200,1000),
 (8,2,1,0,1000),
 (8,3,2,100,2800),
 (9,1,1,100,1100),
 (9,2,1,0,1000),
 (9,3,1,300,1200),
 (9,1,1,200,1000),
 (9,2,1,200,800),
 (9,3,2,50,2900),
 (9,4,2,200,3600),
 (9,1,2,0,2400),
 (9,2,1,0,1000),
 (9,3,1,100,1400),
 (9,4,1,200,1800),
 (10,1,1,0,1200),
 (10,2,1,0,1000),
 (10,3,1,100,1400),
 (10,4,1,300,1700),
 (11,5,2,400,4200),
 (11,1,1,0,1200),
 (11,2,1,100,900),
 (11,3,1,100,1400),
 (11,4,1,300,1700),
 (11,5,1,0,2500),
 (11,4,1,100,1900),
 (12,5,1,0,2500),
 (12,4,1,100,1900),
 (13,5,1,0,2500),
 (13,4,1,0,2000),
 (14,5,1,0,2500),
 (15,4,1,100,1900),
 (16,4,1,200,1800),
 (17,5,2,0,5000),
 (17,1,26,0,31200),
 (17,2,13,299,9113),
 (17,8,3,0,3000),
 (17,1,2,0,2400),
 (18,8,1,0,1000),
 (18,1,1,0,1200),
 (19,11,10,250,14500),
 (19,9,10,300,13000),
 (20,1,47,0,56400),
 (20,3,42,300,50400),
 (21,1,5,200,5000),
 (21,2,2,0,2000),
 (22,15,7,400,21000),
 (22,16,4,400,13600),
 (23,5,2,0,5000),
 (23,15,2,0,6800),
 (23,5,2,0,5000),
 (23,12,2,0,12000),
 (24,5,2,0,5000),
 (24,12,2,0,12000),
 (25,5,2,0,5000),
 (25,12,2,0,12000),
 (26,5,4,500,8000),
 (26,1,2,0,2400),
 (26,16,3,0,11400),
 (26,11,2,0,3400),
 (27,5,2,0,5000),
 (27,1,1,0,1200),
 (28,1,1,0,1200),
 (28,8,1,0,1000),
 (29,5,1,0,2500),
 (29,1,1,0,1200),
 (30,16,1,0,3800),
 (30,15,2,400,6000),
 (31,11,1,0,1700),
 (31,1,2,0,2400),
 (31,2,2,0,2000),
 (31,16,2,400,6800),
 (31,15,2,400,6000),
 (31,12,3,0,18000),
 (31,4,2,100,3800),
 (31,9,2,0,3200),
 (31,5,2,0,5000),
 (32,5,1,0,2500),
 (32,1,1,0,1200),
 (32,16,1,500,3300),
 (32,15,2,200,6400),
 (32,14,1,100,4100),
 (33,5,1,200,2300),
 (33,1,1,0,1200),
 (33,2,1,200,800),
 (33,15,1,300,3100),
 (33,12,1,500,5500),
 (33,4,2,100,3800),
 (33,8,1,0,1000),
 (33,13,1,200,3000),
 (33,14,1,0,4200),
 (33,9,1,0,1600),
 (33,5,1,150,2350),
 (33,13,1,450,2750),
 (33,2,1,175,825),
 (33,9,1,0,1600),
 (33,15,1,245,3155),
 (33,14,1,200,4000),
 (33,14,1,0,4200),
 (33,5,1,0,2500),
 (33,16,1,800,3000),
 (33,10,1,0,1000),
 (34,1,1,0,1200),
 (34,5,1,350,2150),
 (34,8,3,250,2250),
 (34,9,2,875,1450),
 (34,13,4,253.75,11785),
 (34,4,5,392.55,8037.25),
 (34,12,8,1489.65,36082.8),
 (34,15,12,534.61,34384.7),
 (34,16,4,949.23,11403.1),
 (34,8,7,471.59,3698.87),
 (34,9,14,844.82,10572.5),
 (34,4,13,921.39,14021.9),
 (34,16,5,1562.49,11187.5),
 (34,12,22,2467.84,77707.5),
 (34,15,18,2354.76,18814.3),
 (34,5,10,1364.81,11351.9),
 (34,1,16,0,19200),
 (34,9,21,741.36,18031.4),
 (34,8,24,0,24000),
 (34,15,17,1984.57,24062.3),
 (35,17,1,0,3200),
 (35,5,1,400,2100),
 (35,11,1,0,1700),
 (35,1,1,0,1200),
 (35,2,1,0,1000),
 (35,8,1,0,1000),
 (35,3,1,0,1500),
 (35,16,2,750,6100),
 (35,15,1,1360,2040),
 (35,12,1,2290,3710),
 (35,10,1,0,1000),
 (35,14,1,2676,1524),
 (35,4,1,0,2000),
 (35,13,1,1280,1920),
 (35,9,3,575,3075),
 (35,17,1,2150,1050),
 (35,5,1,0,2500),
 (35,9,1,0,1600),
 (35,4,1,0,2000),
 (35,15,1,1854,1546);
/*!40000 ALTER TABLE `bill_detail` ENABLE KEYS */;


--
-- Definition of table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `ID` int(11) NOT NULL auto_increment,
  `Name` varchar(45) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`ID`,`Name`) VALUES 
 (1,'AshiantPaint Boxes'),
 (2,'Brush Boxes'),
 (3,'Dulex Boxes'),
 (7,'Sico'),
 (8,'ABC'),
 (9,'xyz'),
 (10,'AAA'),
 (11,'PQR'),
 (12,'XXXX'),
 (13,'PQRS'),
 (14,'aaa'),
 (15,'qqq'),
 (16,'jjj'),
 (17,'paint'),
 (18,'abc'),
 (19,'sss'),
 (20,'ns tools'),
 (21,'master brush'),
 (22,'AB Paints');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;


--
-- Definition of table `customer`
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
  `Customer_Type` varchar(45) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`ID`,`First_Name`,`Last_Name`,`Gender`,`Email`,`Address`,`City`,`Pincode`,`State`,`Phone`,`Customer_Type`) VALUES 
 (1,'Rohan','Verma','M','rohanverma222@gmail.com','H.No.001,Commiittee Bazar,Hoshiarpur','Hoshiarpur',146001,'Punjab','9810034511','Regular Customer'),
 (2,'Aman','Sharma','M','sharma11aman@gmail.com','H.No.112, Kotwali Bazar, Hoshiarpur','Hoshiarpur',146001,'Punjab','9823345100','Normal Customer'),
 (4,'Kapil','Prasher','M','Kapil.prasher@gmail.com','H.No.0099,Session chownk,hsp','Hoshiarpur',146001,'Punjab','8933425112','Regular Customer'),
 (6,'rahul','mehra','M','rahul@gmail.com','h.no11,hoshiarpur','hsp',146001,'punjab','9834426344','Normal Customer'),
 (10,'xyz','uuuu','M','xyz@gmail.com','hsp','hsp',146001,'punjab','7777777777','Normal Customer'),
 (11,'hhh','hh','M','hhh@gmai.com','jj','jj',110010,'uuu','6666666666','Normal Customer'),
 (12,'hhh','hhh','M','hhh@nowhere.com','hhh','hh',888888,'yyyy','8888888888','Normal Customer'),
 (13,'aaa','ababab','M','ggg@gmail.com','hhhah','hhh',7766,'yyggf','6655445566','Frequent Customer'),
 (14,'abc','ABC','F','abc@gmail.com','h.no.11,hsp','hoshiarpur',146001,'punjab','9876543210','Regular Customer'),
 (15,'rahul','kapoor','M','kapoor.rahul@gmail.com','h.no111,new street,Hoshiarpur','Hoshiarpur',146001,'Punjab','9876546789','Frequent Customer'),
 (16,'rahul','vardant','M','vardant@gmail.com','#11,new colony,hoshiarpur','Hoshiarpur',146001,'punjab','8923309871','Normal Customer'),
 (17,'xxx','xyy','M','xxx@gmail.com','h.no.222,new hari nagar,hoshiarpur','Hoshiarpur',146001,'punjab','8900122345','Regular Customer'),
 (18,'Naman','Verma','M','namanverma@gmail.com','#111,mount evenue,Hsp','Hsp',146001,'Punjab','9870023511','Frequent Customer'),
 (19,'qqq','aaa','M','sss@gmail.com','#22,hsp','Hoshiarpur',146001,'punjab','8964423455','Normal Customer'),
 (20,'alumin','alumin','M','jdbs@sns.com','bioq','jdi',689559,'bjbojnj hb','1234567890','Normal Customer'),
 (21,'asdf','asdf','F','asdf@hsi.com','sjbaob','jobnin',1234,'jojno','3450067890','Normal Customer'),
 (22,'Sanjana','Kashyap','F','sanjana.111@gmail.com','H.NO. 111,new colony,Hoshiarpur','Hoshiarpur',146001,'Punjab','9810200003','Regular Customer'),
 (23,'Ajay','Bhatia','M','prof.ajaybhatia@gmail.com','xxx','xxx',666666,'punjab','9999999998','Normal Customer'),
 (24,'Rajan','Deep','M','rajandeep@nowhere.com','jjj','jjj',77777,'jjjjj','1111111111','Normal Customer'),
 (25,'gagan','deep','M','a@a.com','kk','kk',9999,'jjj','2222222222','Normal Customer'),
 (26,'arvind','pathak','M','ap@gmail.com','jfnjfb','hsp',146001,'punjab','9832240911','Normal Customer'),
 (27,'sakshi','pathak','F','sp@gmail.com','djfjhbfv','hsp',146001,'punjab','9800011233','Normal Customer'),
 (28,'mina','jdnd','F','jcnj@gmail.com','dhbjhbd','hsp',146001,'punjab','9801123400','Normal Customer'),
 (29,'anup','gautam','M','vjnigug@gmail.com','jvgf','hsp',146001,'punjab','8974434599','Normal Customer'),
 (30,'kavita','kumari','F','jfnf@gmail.com','juvfifv','hsp',146001,'punjab','8910000023','Normal Customer'),
 (31,'rajandeep','sohal','M','rajandeep.sohal@gmail.com','fatehgarh road,hoshiarpur','Hoshiarpur',146001,'Punjab','9087712077','Normal Customer'),
 (32,'supriya','thakur','F','surpiya_thakur@gmail.com','hfwfbwjg','hsp',146001,'punjab','8976654344','Regular Customer'),
 (33,'Hardeep','Singh','M','hardeepsingh@gmail.com','#1111,AAA,Hsp','Hoshiarpur',146001,'Punjab','9023301821','Normal Customer');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;


--
-- Definition of table `product`
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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`ID`,`Name`,`Units`,`Quantity`,`Cost_Price`,`Sale_Price`,`MRP`,`Status`,`Re_Order_Level`,`Category_ID`,`Supplier_ID`) VALUES 
 (1,'AsianPaint boxes','Leters',49,1000,1200,1500,0,10,1,2),
 (2,'Brushes','leters',59,800,1000,1200,1,20,2,1),
 (3,'Dulex Paints','Leters',69,1200,1500,1700,1,15,3,4),
 (4,'Sico','Leters',75,1800,2000,2500,1,25,7,5),
 (5,'ABC Paints','leters',78,2200,2500,3000,1,24,8,2),
 (6,'asd','hk',120,10,12,15,1,20,8,6),
 (7,'asd','hk',60,1000,1200,1550,1,20,8,6),
 (8,'dfdf','aa',69,500,1000,1200,1,20,11,8),
 (9,'XXXX','Leters',79,1300,1600,1800,1,35,12,9),
 (10,'PQRS','leters',75,800,1000,1100,1,20,11,4),
 (11,'ABCD','leters',74,1500,1700,2000,1,30,8,5),
 (12,'paints','leters',75,5500,6000,6500,1,20,17,9),
 (13,'SSS','dfmk',67,3000,3200,3500,1,18,15,8),
 (14,'qqw','leters',79,4100,4200,4500,1,25,19,6),
 (15,'NS Tools','leters',78,3000,3400,3900,1,30,11,1),
 (16,'master brushes','jf',73,3500,3800,4000,1,25,21,4),
 (17,'ab paints','leters',78,3000,3200,3500,1,35,22,10);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;


--
-- Definition of table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `ID` int(11) NOT NULL auto_increment,
  `Name` varchar(45) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`ID`,`Name`) VALUES 
 (1,'Karan'),
 (2,'Ankur'),
 (3,'Sumit'),
 (5,'naina'),
 (6,'naina'),
 (7,'kamal'),
 (8,'asd'),
 (9,'Gaurav');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;


--
-- Definition of table `supplier`
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` (`ID`,`Name`,`Address`,`City`,`Pincode`,`State`,`Phone`) VALUES 
 (1,'Anubhav','H.No.111,Gopal Nagar,Hoshiarpur','Hoshiarpur',146001,'Punjab','9845655389'),
 (2,'Vishal','H.No. 222201, Shalimaar Nagar, Hoshiarpur','Hoshiarpur',146001,'Punjab','9832298712'),
 (4,'Rohan','H.NO.0101, Fatehgarh Road, Hoshiarpur','Hoshiarpur',146001,'Punjab','9834427100'),
 (5,'Ritik Bansal','H.No.111 aaa,hsp','Hsp',146001,'Punjab','9876654344'),
 (6,'aaa','aaa,hsp','hsp',146001,'punjab','9845536277'),
 (7,'Vishal','#222,new hari nagar,hoshiarpur','Hoshiarpur',146001,'Punjab','8964434522'),
 (8,'qqq','#11111,Hsp','Hoshiarpur',146001,'punjab','7654432900'),
 (9,'alumi','dav college','hsp',146001,'punjab','0987654321'),
 (10,'mohit','#220,xxx,hsp','Hoshiarpur',146001,'punjab','9823301011');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;


--
-- Definition of table `user`
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`ID`,`Username`,`Password`,`Role_ID`) VALUES 
 (1,'Karan','karan123',1),
 (2,'sumit','sumit111',3),
 (3,'Ankur','ankur123',2),
 (4,'naina','naina123',5),
 (5,'asd','asd',8),
 (6,'Gaurav','gaurav11',9);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

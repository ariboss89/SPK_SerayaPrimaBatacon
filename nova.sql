# Host: localhost  (Version: 5.5.5-10.4.17-MariaDB)
# Date: 2021-09-24 13:43:05
# Generator: MySQL-Front 5.3  (Build 4.81)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "tb_admin"
#

DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `username` varchar(55) NOT NULL DEFAULT '',
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

#
# Data for table "tb_admin"
#

/*!40000 ALTER TABLE `tb_admin` DISABLE KEYS */;
INSERT INTO `tb_admin` VALUES ('admin','123456','ADMIN'),('admin2','123456','ADMIN'),('nova','123456','SUPERADMIN');
/*!40000 ALTER TABLE `tb_admin` ENABLE KEYS */;

#
# Structure for table "tb_alternatif"
#

DROP TABLE IF EXISTS `tb_alternatif`;
CREATE TABLE `tb_alternatif` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(50) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `kontak` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

#
# Data for table "tb_alternatif"
#

/*!40000 ALTER TABLE `tb_alternatif` DISABLE KEYS */;
INSERT INTO `tb_alternatif` VALUES (1,'Shirley','Jl Pelantar Datuk','081365316138'),(2,'Nova','Jl Kijang Lama','081122334455'),(3,'Leonardo','Pelantar Datuk','081234241111'),(4,'Sukri','Jl Km 11','081122335677'),(5,'Ahmadi','Jl Kijang','08123457828'),(6,'Ardizal','Jl Kijang Lama','082379399'),(7,'Edy Setiawan','Bukit Raya','08123241241'),(8,'Iderman','Jl Kijang Lama','081239122100'),(9,'Hermanto','Jl Kijang Lama','018312418478'),(10,'Johan Johana','Jl Kijang Lama','081367478231'),(11,'Julianto','Jl Km 7','0813791273'),(12,'Jefriadi','Jl Km 8','0813924129'),(13,'Harlius','Jl Km 9','083129741289'),(14,'Zahri Reza','Jl Km 11','085318382939');
/*!40000 ALTER TABLE `tb_alternatif` ENABLE KEYS */;

#
# Structure for table "tb_hasil"
#

DROP TABLE IF EXISTS `tb_hasil`;
CREATE TABLE `tb_hasil` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `alternatif` varchar(255) DEFAULT NULL,
  `ket` varchar(255) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `nilai` varchar(255) DEFAULT NULL,
  `id_riwayat` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=397 DEFAULT CHARSET=utf8mb4;

#
# Data for table "tb_hasil"
#

INSERT INTO `tb_hasil` VALUES (383,'Zahri Reza','Ranking 2 ','2021-09-24','1.0471','R001'),(384,'Harlius','Ranking 6 ','2021-09-24','0.8971','R001'),(385,'Jefriadi','Ranking 5 ','2021-09-24','0.9971','R001'),(386,'Julianto','Ranking 10 ','2021-09-24','0.7471','R001'),(387,'Johan Johana','Ranking 1 ','2021-09-24','1.1221','R001'),(388,'Hermanto','Ranking 8 ','2021-09-24','0.7971','R001'),(389,'Iderman','Ranking 12 ','2021-09-24','0.6711','R001'),(390,'Edy Setiawan','Ranking 13 ','2021-09-24','0.6701','R001'),(391,'Ardizal','Ranking 9 ','2021-09-24','0.7721','R001'),(392,'Ahmadi','Ranking 11 ','2021-09-24','0.6721','R001'),(393,'Sukri','Ranking 7 ','2021-09-24','0.8201','R001'),(394,'Leonardo','Ranking 14 ','2021-09-24','0.5951','R001'),(395,'Nova','Ranking 4 ','2021-09-24','1.0221','R001'),(396,'Shirley','Ranking 3 ','2021-09-24','1.0461','R001'),(397,'Zahri Reza','Ranking 2 ','2021-09-24','1.0471','R002'),(398,'Harlius','Ranking 6 ','2021-09-24','0.8971','R002'),(399,'Jefriadi','Ranking 5 ','2021-09-24','0.9971','R002'),(400,'Julianto','Ranking 10 ','2021-09-24','0.7471','R002'),(401,'Johan Johana','Ranking 1 ','2021-09-24','1.1221','R002'),(402,'Hermanto','Ranking 8 ','2021-09-24','0.7971','R002'),(403,'Iderman','Ranking 12 ','2021-09-24','0.6711','R002'),(404,'Edy Setiawan','Ranking 13 ','2021-09-24','0.6701','R002'),(405,'Ardizal','Ranking 9 ','2021-09-24','0.7721','R002'),(406,'Ahmadi','Ranking 11 ','2021-09-24','0.6721','R002'),(407,'Sukri','Ranking 7 ','2021-09-24','0.8201','R002'),(408,'Leonardo','Ranking 14 ','2021-09-24','0.5951','R002'),(409,'Nova','Ranking 4 ','2021-09-24','1.0221','R002'),(410,'Shirley','Ranking 3 ','2021-09-24','1.0461','R002'),(411,'Zahri Reza','Ranking 2 ','2021-09-24','1.0471','R003'),(412,'Harlius','Ranking 6 ','2021-09-24','0.8971','R003'),(413,'Jefriadi','Ranking 5 ','2021-09-24','0.9971','R003'),(414,'Julianto','Ranking 10 ','2021-09-24','0.7471','R003'),(415,'Johan Johana','Ranking 1 ','2021-09-24','1.1221','R003'),(416,'Hermanto','Ranking 8 ','2021-09-24','0.7971','R003'),(417,'Iderman','Ranking 12 ','2021-09-24','0.6711','R003'),(418,'Edy Setiawan','Ranking 13 ','2021-09-24','0.6701','R003'),(419,'Ardizal','Ranking 9 ','2021-09-24','0.7721','R003'),(420,'Ahmadi','Ranking 11 ','2021-09-24','0.6721','R003'),(421,'Sukri','Ranking 7 ','2021-09-24','0.8201','R003'),(422,'Leonardo','Ranking 14 ','2021-09-24','0.5951','R003'),(423,'Nova','Ranking 4 ','2021-09-24','1.0221','R003'),(424,'Shirley','Ranking 3 ','2021-09-24','1.0461','R003'),(425,'Zahri Reza','Ranking 2 ','2021-09-24','1.0471','R004'),(426,'Harlius','Ranking 6 ','2021-09-24','0.8971','R004'),(427,'Jefriadi','Ranking 5 ','2021-09-24','0.9971','R004'),(428,'Julianto','Ranking 10 ','2021-09-24','0.7471','R004'),(429,'Johan Johana','Ranking 1 ','2021-09-24','1.1221','R004'),(430,'Hermanto','Ranking 8 ','2021-09-24','0.7971','R004'),(431,'Iderman','Ranking 12 ','2021-09-24','0.6711','R004'),(432,'Edy Setiawan','Ranking 13 ','2021-09-24','0.6701','R004'),(433,'Ardizal','Ranking 9 ','2021-09-24','0.7721','R004'),(434,'Ahmadi','Ranking 11 ','2021-09-24','0.6721','R004'),(435,'Sukri','Ranking 7 ','2021-09-24','0.8201','R004'),(436,'Leonardo','Ranking 14 ','2021-09-24','0.5951','R004'),(437,'Nova','Ranking 4 ','2021-09-24','1.0221','R004'),(438,'Shirley','Ranking 3 ','2021-09-24','1.0461','R004');

#
# Structure for table "tb_keputusan"
#

DROP TABLE IF EXISTS `tb_keputusan`;
CREATE TABLE `tb_keputusan` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `alternatif` varchar(255) DEFAULT NULL,
  `kriteria` varchar(255) DEFAULT NULL,
  `nilai` double(6,4) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8mb4;

#
# Data for table "tb_keputusan"
#

INSERT INTO `tb_keputusan` VALUES (37,'Shirley','C1',5.0000),(38,'Shirley','C2',3.0000),(39,'Shirley','C3',5.0000),(40,'Shirley','C4',3.0000),(41,'Nova','C1',4.0000),(42,'Nova','C2',4.0000),(43,'Nova','C3',5.0000),(44,'Nova','C4',4.0000),(45,'Leonardo','C1',3.0000),(46,'Leonardo','C2',2.0000),(47,'Leonardo','C3',3.0000),(48,'Leonardo','C4',5.0000),(49,'Sukri','C1',3.0000),(50,'Sukri','C2',4.0000),(51,'Sukri','C3',4.0000),(52,'Sukri','C4',4.0000),(53,'Ahmadi','C1',4.0000),(54,'Ahmadi','C2',3.0000),(55,'Ahmadi','C3',3.0000),(56,'Ahmadi','C4',4.0000),(57,'Ardizal','C1',4.0000),(58,'Ardizal','C2',4.0000),(59,'Ardizal','C3',3.0000),(60,'Ardizal','C4',3.0000),(61,'Edy Setiawan','C1',3.0000),(62,'Edy Setiawan','C2',4.0000),(63,'Edy Setiawan','C3',3.0000),(64,'Edy Setiawan','C4',3.0000),(65,'Iderman','C1',2.0000),(66,'Iderman','C2',4.0000),(67,'Iderman','C3',4.0000),(68,'Iderman','C4',3.0000),(69,'Hermanto','C1',4.0000),(70,'Hermanto','C2',4.0000),(71,'Hermanto','C3',3.0000),(72,'Hermanto','C4',4.0000),(73,'Johan Johana','C1',4.0000),(74,'Johan Johana','C2',4.0000),(75,'Johan Johana','C3',5.0000),(76,'Johan Johana','C4',4.0000),(77,'Julianto','C1',4.0000),(78,'Julianto','C2',4.0000),(79,'Julianto','C3',3.0000),(80,'Julianto','C4',3.0000),(81,'Jefriadi','C1',4.0000),(82,'Jefriadi','C2',4.0000),(83,'Jefriadi','C3',5.0000),(84,'Jefriadi','C4',3.0000),(85,'Harlius','C4',4.0000),(86,'Harlius','C3',3.0000),(87,'Harlius','C2',4.0000),(88,'Harlius','C1',4.0000),(89,'Zahri Reza','C1',4.0000),(90,'Zahri Reza','C4',4.0000),(91,'Zahri Reza','C3',5.0000),(92,'Zahri Reza','C2',4.0000),(93,'Shirley','C5',1.0000),(94,'Nova','C5',5.0000),(95,'Leonardo','C5',3.0000),(96,'Sukri','C5',4.0000),(97,'Ahmadi','C5',5.0000),(98,'Ardizal','C5',2.0000),(99,'Edy Setiawan','C5',2.0000),(100,'Iderman','C5',3.0000),(101,'Hermanto','C5',4.0000),(102,'Johan Johana','C5',1.0000),(103,'Julianto','C5',3.0000),(104,'Jefriadi','C5',3.0000),(105,'Harlius','C5',1.0000),(106,'Zahri Reza','C5',4.0000);

#
# Structure for table "tb_kriteria"
#

DROP TABLE IF EXISTS `tb_kriteria`;
CREATE TABLE `tb_kriteria` (
  `id_kriteria` varchar(11) NOT NULL DEFAULT '',
  `nama_kriteria` varchar(255) DEFAULT NULL,
  `nilai_kriteria` double(3,2) DEFAULT NULL,
  `jenis` varchar(255) DEFAULT NULL,
  `min` int(10) DEFAULT NULL,
  `max` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_kriteria`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "tb_kriteria"
#

INSERT INTO `tb_kriteria` VALUES ('C1','Absensi',0.30,'Benefit',1,5),('C2','Perilaku',0.20,'Benefit',1,5),('C3','Hasil Kerja',0.25,'Benefit',1,5),('C4','Kerjasama Tim',0.15,'Benefit',1,5),('C5','Test',0.10,'Cost',1,5);

#
# Structure for table "tb_riwayat"
#

DROP TABLE IF EXISTS `tb_riwayat`;
CREATE TABLE `tb_riwayat` (
  `id_riwayat` varchar(11) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_riwayat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Data for table "tb_riwayat"
#

INSERT INTO `tb_riwayat` VALUES ('R001'),('R002'),('R003'),('R004');

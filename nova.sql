# Host: localhost  (Version: 5.5.5-10.4.17-MariaDB)
# Date: 2021-08-06 01:52:40
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
INSERT INTO `tb_admin` VALUES ('admin','123456','ADMIN'),('nova','123456','SUPERADMIN');
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
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

#
# Data for table "tb_alternatif"
#

/*!40000 ALTER TABLE `tb_alternatif` DISABLE KEYS */;
INSERT INTO `tb_alternatif` VALUES (1,'Ari Ramadhan','Jl. Gudang Minyak No.28','081268643631'),(2,'Brian Montegno','Ganet','0816564321'),(9,'Isron','Batu Hitam','081234241111');
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
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8mb4;

#
# Data for table "tb_hasil"
#

INSERT INTO `tb_hasil` VALUES (115,'Isron','Ranking 3 ','2021-08-06','0.7359627501361405'),(116,'Brian Montegno','Ranking 2 ','2021-08-06','0.9109627501361406'),(117,'Ari Ramadhan','Ranking 1 ','2021-08-06','0.9359627501361405');

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
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4;

#
# Data for table "tb_keputusan"
#

INSERT INTO `tb_keputusan` VALUES (25,'Ari Ramadhan','C1',4.0000),(26,'Ari Ramadhan','C2',3.0000),(27,'Ari Ramadhan','C3',3.0000),(28,'Ari Ramadhan','C4',3.0000),(29,'Brian Montegno','C1',3.0000),(30,'Brian Montegno','C2',4.0000),(31,'Brian Montegno','C3',3.0000),(32,'Brian Montegno','C4',4.0000),(33,'Isron','C1',3.0000),(34,'Isron','C2',3.0000),(35,'Isron','C3',4.0000),(36,'Isron','C4',2.0000);

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

INSERT INTO `tb_kriteria` VALUES ('C1','Absensi',0.30,'Benefit',1,5),('C2','Perilaku',0.20,'Benefit',1,5),('C3','Hasil Kerja',0.25,'Benefit',1,5),('C4','Kerjasama Tim',0.25,'Benefit',1,5);

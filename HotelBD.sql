CREATE DATABASE  IF NOT EXISTS `hotel_bd` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `hotel_bd`;
-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: hotel_bd
-- ------------------------------------------------------
-- Server version	8.0.41

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
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleados` (
  `id_empleado` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `cargo` varchar(50) NOT NULL,
  `salario` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id_empleado`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1,'Raúl Sánchez','Chef',15000.00),(2,'Patricia Díaz','Recepcionista',10000.00),(3,'Javier Hernández','Portero',8000.00),(4,'Marta Gómez','Gerente',20000.00),(5,'Iván Morales','Limpieza',8000.00);
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `habitaciones`
--

DROP TABLE IF EXISTS `habitaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `habitaciones` (
  `id_habitacion` int NOT NULL AUTO_INCREMENT,
  `tipo` varchar(50) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `capacidad` int NOT NULL,
  `estado` enum('disponible','ocupada','mantenimiento') DEFAULT 'disponible',
  PRIMARY KEY (`id_habitacion`),
  KEY `idx_tipo` (`tipo`),
  CONSTRAINT `habitaciones_chk_1` CHECK ((`estado` in (_utf8mb4'disponible',_utf8mb4'ocupada',_utf8mb4'mantenimiento')))
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habitaciones`
--

LOCK TABLES `habitaciones` WRITE;
/*!40000 ALTER TABLE `habitaciones` DISABLE KEYS */;
INSERT INTO `habitaciones` VALUES (1,'Doble',850.00,2,'disponible'),(2,'Suite',950.00,4,'ocupada'),(3,'Doble',1000.00,1,'mantenimiento'),(4,'Suite',550.00,4,'disponible'),(5,'Doble',900.00,2,'ocupada'),(7,'Sencilla',800.00,1,'disponible'),(9,'Doble',1200.00,4,'disponible');
/*!40000 ALTER TABLE `habitaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `huespedes`
--

DROP TABLE IF EXISTS `huespedes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `huespedes` (
  `id_huesped` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `fecha_registro` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_huesped`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `huespedes`
--

LOCK TABLES `huespedes` WRITE;
/*!40000 ALTER TABLE `huespedes` DISABLE KEYS */;
INSERT INTO `huespedes` VALUES (1,'Pedro García','pedrogarcia@email.com','98856325','2025-02-14 04:38:37'),(2,'Laura Ruiz','lauraruiz@email.com','94452368','2025-02-14 04:38:37'),(3,'Andrés Martínez','andresmartinez@email.com','89956345','2025-02-14 04:38:37'),(4,'Elena Pérez T','elenaperez@email.com','95426355','2025-02-13 06:00:00'),(5,'Carlos Gómez','carlos@email.com','99783261','2025-02-13 06:00:00'),(11,'Anthony Padilla','anthony@gmail.com','96623589','2025-04-03 06:00:00'),(12,'Carlos Madrid','carlos@gmail.com','95563325','2025-04-03 06:00:00');
/*!40000 ALTER TABLE `huespedes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagos`
--

DROP TABLE IF EXISTS `pagos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pagos` (
  `id_pago` int NOT NULL AUTO_INCREMENT,
  `id_reserva` int DEFAULT NULL,
  `monto` decimal(10,2) NOT NULL,
  `fecha_pago` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `metodo_pago` enum('tarjeta','efectivo','transferencia') NOT NULL,
  PRIMARY KEY (`id_pago`),
  KEY `id_reserva` (`id_reserva`),
  KEY `idx_pago_fecha` (`fecha_pago`),
  CONSTRAINT `pagos_ibfk_1` FOREIGN KEY (`id_reserva`) REFERENCES `reservas` (`id_reserva`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagos`
--

LOCK TABLES `pagos` WRITE;
/*!40000 ALTER TABLE `pagos` DISABLE KEYS */;
INSERT INTO `pagos` VALUES (16,3,75.00,'2025-02-14 05:00:37','efectivo'),(17,4,50.00,'2025-02-14 05:00:37','tarjeta'),(18,1,80.00,'2025-02-14 05:00:37','transferencia'),(19,5,45.00,'2025-02-14 05:00:37','tarjeta'),(20,2,30.00,'2025-02-14 05:00:37','efectivo'),(21,6,300.00,'2025-02-16 04:00:19','tarjeta');
/*!40000 ALTER TABLE `pagos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservas`
--

DROP TABLE IF EXISTS `reservas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservas` (
  `id_reserva` int NOT NULL AUTO_INCREMENT,
  `id_huesped` int NOT NULL,
  `id_habitacion` int NOT NULL,
  `fecha_entrada` date NOT NULL,
  `fecha_salida` date NOT NULL,
  `estado` enum('confirmada','cancelada','completada') DEFAULT 'confirmada',
  PRIMARY KEY (`id_reserva`),
  KEY `id_habitacion` (`id_habitacion`),
  KEY `idx_reserva_estado` (`estado`),
  KEY `fk_huesped_id` (`id_huesped`),
  CONSTRAINT `fk_huesped_id` FOREIGN KEY (`id_huesped`) REFERENCES `huespedes` (`id_huesped`) ON DELETE CASCADE,
  CONSTRAINT `reservas_ibfk_1` FOREIGN KEY (`id_huesped`) REFERENCES `huespedes` (`id_huesped`) ON DELETE CASCADE,
  CONSTRAINT `reservas_ibfk_2` FOREIGN KEY (`id_habitacion`) REFERENCES `habitaciones` (`id_habitacion`) ON DELETE CASCADE,
  CONSTRAINT `reservas_chk_1` CHECK ((`estado` in (_utf8mb4'confirmada',_utf8mb4'cancelada',_utf8mb4'completada')))
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservas`
--

LOCK TABLES `reservas` WRITE;
/*!40000 ALTER TABLE `reservas` DISABLE KEYS */;
INSERT INTO `reservas` VALUES (1,4,1,'2025-06-01','2025-06-05','confirmada'),(2,5,4,'2025-03-02','2025-03-12','confirmada'),(3,1,4,'2025-08-20','2025-08-25','confirmada'),(4,2,5,'2025-09-05','2025-09-10','cancelada'),(5,3,2,'2025-10-01','2025-10-05','cancelada'),(6,1,2,'2025-03-01','2025-03-05','confirmada'),(13,1,5,'2025-04-03','2025-04-10','confirmada'),(14,1,1,'2025-04-08','2025-04-10','confirmada');
/*!40000 ALTER TABLE `reservas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `usuario_nombre` varchar(100) NOT NULL,
  `usuario_clave` varchar(256) DEFAULT NULL,
  `usuario_estado` tinyint DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Maudy','492106edbbbc5b3a29fe59d21972ae154bc221be534fbcfc51f7c61d74880601',1);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'hotel_bd'
--

--
-- Dumping routines for database 'hotel_bd'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-03 22:58:18

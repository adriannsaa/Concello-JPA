DROP DATABASE IF EXISTS `Concello`;

CREATE DATABASE IF NOT EXISTS `Concello`
DEFAULT CHARACTER SET = utf8
DEFAULT COLLATE utf8_general_ci;

USE `Concello`;

--
-- User creation
--
GRANT ALL PRIVILEGES ON Concello TO root@localhost IDENTIFIED BY '1234';
FLUSH PRIVILEGES;

--
-- Table drops
--

DROP TABLE IF EXISTS `Alumno`;
DROP TABLE IF EXISTS `Monitor`;
DROP TABLE IF EXISTS `Actividad`;
DROP TABLE IF EXISTS `Asistir`;

--
-- Create tables
--

CREATE TABLE `Alumno` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `nombre` varchar(100) NOT NULL,
  `dni` varchar(9) NOT NULL UNIQUE,
  `edad` int(2) NOT NULL,
  `email` varchar(50),
  `direccion` varchar(100) NOT NULL,
  `cp` int(5) NOT NULL,
  `localidad` varchar(50) NOT NULL,
  `provincia` varchar(30) NOT NULL,
  `telefono` int(9) NOT NULL,
  `nombre_autorizador` varchar(100),
  `dni_autorizador` varchar(9),
  `descuento` varchar(6),
  `observaciones_alumno` varchar(255)
);

CREATE TABLE `Monitor` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `nombre` varchar(100) NOT NULL,
  `dni` varchar(9) NOT NULL UNIQUE,
  `email` varchar(50),
  `direccion` varchar(100) NOT NULL,
  `cp` int(5) NOT NULL,
  `localidad` varchar(50) NOT NULL,
  `provincia` varchar(30) NOT NULL,
  `telefono` int(9) NOT NULL,
  `sueldo` varchar(15) NOT NULL,
  `activo` bool NOT NULL,
  `contrato` enum('Concello','Autonomo','Subcontratado') NOT NULL,
  `observaciones_monitor` varchar(255)

);

CREATE TABLE `Actividad` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `nombre` varchar(100) NOT NULL UNIQUE,
  `participantes` int(3),
  `horario` datetime NOT NULL,
  `lugar` varchar(50) NOT NULL,
  `material` varchar(500) NOT NULL,
  `observaciones_actividad` varchar(255), 
  `actividad_monitor` int(11) NOT NULL,
  
  FOREIGN KEY (actividad_monitor) REFERENCES Monitor(id) ON DELETE CASCADE
);



CREATE TABLE `Asistir` (
  `alumno_id` int(11) NOT NULL,
  `actividad_id` int(11) NOT NULL,
  PRIMARY KEY (alumno_id, actividad_id),
  FOREIGN KEY (alumno_id) REFERENCES Alumno(id) ON DELETE CASCADE,
  FOREIGN KEY (actividad_id) REFERENCES Actividad(id) ON DELETE CASCADE
);

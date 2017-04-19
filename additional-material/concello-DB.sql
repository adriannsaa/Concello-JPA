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


--
-- Inserts
--

-- Alumnos

INSERT INTO `Alumno`(nombre,dni,edad,email,direccion,cp,localidad,provincia,telefono,nombre_autorizador,dni_autorizador,descuento,observaciones_alumno) 
VALUES ('Adrian', '33551492N', 28, 'asdf@gmail.com', 'BernardoCacha', 32004, 'Ourense', 'Ourense', 646867768,'Ramon' ,'33551498P' ,'30%' , 'Prueba1');
INSERT INTO `Alumno`(nombre,dni,edad,email,direccion,cp,localidad,provincia,telefono,nombre_autorizador,dni_autorizador,descuento,observaciones_alumno) 
VALUES ('Pablo', '13451492P', 21, 'afre4f@gmail.com', 'JoseteCalle', 32001, 'Lugo', 'Lugo', 555467768,'Manuel' ,'33551498X' ,'10%' , 'Prueba2');
INSERT INTO `Alumno`(nombre,dni,edad,email,direccion,cp,localidad,provincia,telefono,nombre_autorizador,dni_autorizador,descuento,observaciones_alumno) 
VALUES ('Julito', '44551492C', 24, 'agrettnth@gmail.com', 'BaaaCalle', 32003, 'Madrid', 'Navalcerrada', 464867768,'Juan' ,'22251498P' ,'50%' , 'Prueba3');

-- Monitores

INSERT INTO `Monitor`(nombre,dni,email,direccion,cp,localidad,provincia,telefono,sueldo,activo,contrato,observaciones_monitor) 
VALUES ('Kachalote', '14143492B','kacha@gmail.com', 'Avda Lugo', 27560, 'Monterroso', 'Lugo', 789867768,'1500' ,true ,'Concello' , 'Prueba Monitor 1');
INSERT INTO `Monitor`(nombre,dni,email,direccion,cp,localidad,provincia,telefono,sueldo,activo,contrato,observaciones_monitor) 
VALUES ('Pedro', '23563492B','Pedro@gmail.com', 'Avda Lugo', 27560, 'Monterroso', 'Lugo', 789867654,'1200' ,false ,'Autonomo' , 'Prueba Monitor 2');

-- Actividades

INSERT INTO `Actividad`(nombre,participantes,horario,lugar,material,observaciones_actividad,actividad_monitor) 
VALUES ('Futbol', 25, '2018-01-07 11:59:53', 'Cerdeiriños', 'Conos,Balones,Petos', 'Se necesita luz', '1');
INSERT INTO `Actividad`(nombre,participantes,horario,lugar,material,observaciones_actividad,actividad_monitor) 
VALUES ('Padel', 10, '2018-01-07 18:59:53', 'Poligono', 'Pelotas,palas', 'Se necesita luz', '2');

-- Asistir

INSERT INTO `Asistir`(alumno_id,actividad_id) 
VALUES ('1','1');
INSERT INTO `Asistir`(alumno_id,actividad_id) 
VALUES ('2','1');
INSERT INTO `Asistir`(alumno_id,actividad_id) 
VALUES ('3','2');

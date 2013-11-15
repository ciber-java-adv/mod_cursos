create database bd_curso;
USE `bd_curso`;
DROP TABLE IF EXISTS `curso`;
CREATE TABLE `curso` (
  `idcurso` int(11) NOT NULL AUTO_INCREMENT,
  `nombrecurso` varchar(45) DEFAULT NULL,
  `descripcioncurso` varchar(45) DEFAULT NULL,
  `tipocurso` char(1) DEFAULT NULL,
  `modalidadpago` char(1) DEFAULT NULL,
  `duracion` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`idCurso`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

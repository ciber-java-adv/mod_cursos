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
  `prerequisitos` varchar(50) DEFAULT NULL,
  `creditos` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`idCurso`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE usuario (
  idusuario INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NOT NULL,
  clave VARCHAR(45) NOT NULL,
  estado tinyint(1) NOT NULL,
  PRIMARY KEY (idusuario)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE rol (
	idrol INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(45) NOT NULL,
	PRIMARY KEY (idrol)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE usuario_rol (
	idusuariorol INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	idusuario INT(10) UNSIGNED NOT NULL,
	idrol INT(10) UNSIGNED NOT NULL,
	PRIMARY KEY (idusuariorol),
	CONSTRAINT FK_usuario_rol_usuario FOREIGN KEY (idusuario) REFERENCES usuario (idusuario),
	CONSTRAINT FK_usuario_rol_rol FOREIGN KEY (idrol) REFERENCES rol (idrol)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO usuario (nombre, clave, estado) VALUES ('admin', '12345', 1);
INSERT INTO rol (nombre) VALUES ('administradores');
INSERT INTO usuario_rol (idusuario, idrol) VALUES (1,1);

INSERT INTO usuario (nombre, clave, estado) VALUES ('usuario', '1234', 1);
INSERT INTO rol (nombre) VALUES ('usuarios');
INSERT INTO usuario_rol (idusuario, idrol) VALUES (2,2);

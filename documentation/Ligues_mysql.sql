-- Ici on a mis la ligne de création de la base de donnée en commentaire pour que chacun crée sa propre base de donnés :

-- CREATE DATABASE IF NOT EXISTS `LIGUES` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
-- USE `LIGUES`;



CREATE TABLE `EMPLOYÉ` (
  `idemployé`INT NOT NULL AUTO_INCREMENT,
  `date_d'entré` DATE,
  `date_de_sortie` DATE,
  `nom` VARCHAR(42),
  `prénom` VARCHAR(42),
  `mail` VARCHAR(42),
  `type` INT(11),
  `idligue` INT(11),
  PRIMARY KEY (`idemployé`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `LIGUE` (
  `idligue` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(42),
  PRIMARY KEY (`idligue`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `EMPLOYÉ` ADD FOREIGN KEY (`idligue`) REFERENCES `LIGUE` (`idligue`);

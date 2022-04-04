-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema future_soccer
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `future_soccer` ;

-- -----------------------------------------------------
-- Schema future_soccer
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `future_soccer` DEFAULT CHARACTER SET utf8 ;
USE `future_soccer` ;

-- -----------------------------------------------------
-- Table `future_soccer`.`CATEGORIA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `future_soccer`.`CATEGORIA` ;

CREATE TABLE IF NOT EXISTS `future_soccer`.`CATEGORIA` (
  `NumCategoria` INT NOT NULL,
  PRIMARY KEY (`NumCategoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `future_soccer`.`ACUDIENTE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `future_soccer`.`ACUDIENTE` ;

CREATE TABLE IF NOT EXISTS `future_soccer`.`ACUDIENTE` (
  `DocAcudiente` INT(10) NOT NULL,
  `NombresAcu` VARCHAR(45) NOT NULL,
  `ApellidosAcu` VARCHAR(45) NOT NULL,
  `TelCelularAcu` INT(10) NOT NULL,
  `CorreoAcu` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`DocAcudiente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `future_soccer`.`JUGADORA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `future_soccer`.`JUGADORA` ;

CREATE TABLE IF NOT EXISTS `future_soccer`.`JUGADORA` (
  `Documento` INT NOT NULL,
  `Nombres` VARCHAR(45) NOT NULL,
  `Apellidos` VARCHAR(45) NOT NULL,
  `Año de Nacimiento` INT(4) NOT NULL,
  `TipoSangre` VARCHAR(3) NOT NULL,
  `EPS` VARCHAR(45) NOT NULL,
  `Posición` VARCHAR(15) NOT NULL,
  `Piedominante` CHAR(10) NOT NULL,
  `TelFijoJugadora` VARCHAR(10) NOT NULL,
  `Tel Celular Jugadora` VARCHAR(10) NOT NULL,
  `NumCategoria` INT NOT NULL,
  `DocAcudiente` INT(10) NOT NULL,
  PRIMARY KEY (`Documento`, `NumCategoria`, `DocAcudiente`),
  UNIQUE INDEX `DocumentoTI/CC_UNIQUE` (`Documento` ASC) VISIBLE,
  INDEX `fk_JUGADORA_CATEGORÍA_idx` (`NumCategoria` ASC) VISIBLE,
  INDEX `fk_JUGADORA_ACUDIENTE1_idx` (`DocAcudiente` ASC) VISIBLE,
  CONSTRAINT `fk_JUGADORA_CATEGORÍA`
    FOREIGN KEY (`NumCategoria`)
    REFERENCES `future_soccer`.`CATEGORIA` (`NumCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_JUGADORA_ACUDIENTE1`
    FOREIGN KEY (`DocAcudiente`)
    REFERENCES `future_soccer`.`ACUDIENTE` (`DocAcudiente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `future_soccer`.`PROFESOR`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `future_soccer`.`PROFESOR` ;

CREATE TABLE IF NOT EXISTS `future_soccer`.`PROFESOR` (
  `numero_documento` INT NOT NULL,
  `nombre_profesor` VARCHAR(45) NOT NULL,
  `apellidos_profesor` VARCHAR(45) NOT NULL,
  `tel_fijo` INT(10) NOT NULL,
  `tel_celular` INT(10) NOT NULL,
  `correo` VARCHAR(100) NOT NULL,
  `edad` INT(2) NOT NULL,
  `NumCategoria` INT NOT NULL,
  PRIMARY KEY (`numero_documento`, `NumCategoria`),
  INDEX `fk_PROFESOR_CATEGORÍA1_idx` (`NumCategoria` ASC) VISIBLE,
  CONSTRAINT `fk_PROFESOR_CATEGORÍA1`
    FOREIGN KEY (`NumCategoria`)
    REFERENCES `future_soccer`.`CATEGORIA` (`NumCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- MySQL Script generated by MySQL Workbench
-- Sat Mar 18 21:41:04 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema casosacadtpi135
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema casosacadtpi135
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `casosacadtpi135` DEFAULT CHARACTER SET latin1 ;
USE `casosacadtpi135` ;

-- -----------------------------------------------------
-- Table `casosacadtpi135`.`solicitud`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `casosacadtpi135`.`solicitud` ;

CREATE TABLE IF NOT EXISTS `casosacadtpi135`.`solicitud` (
  `id_solicitud` INT NOT NULL,
  `encargado_solc` VARCHAR(10) NOT NULL,
  `Tipo_solic` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id_solicitud`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `casosacadtpi135`.`caso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `casosacadtpi135`.`caso` ;

CREATE TABLE IF NOT EXISTS `casosacadtpi135`.`caso` (
  `id_caso` INT NOT NULL,
  `id_solicitud` INT NOT NULL,
  `Nombre_caso` VARCHAR(10) NOT NULL,
  `Descripcion_caso` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id_caso`, `id_solicitud`),
  INDEX `fk_caso_solicitud1_idx` (`id_solicitud` ASC),
  CONSTRAINT `id_solicitudfk1`
    FOREIGN KEY (`id_solicitud`)
    REFERENCES `casosacadtpi135`.`solicitud` (`id_solicitud`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `casosacadtpi135`.`caso_detalle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `casosacadtpi135`.`caso_detalle` ;

CREATE TABLE IF NOT EXISTS `casosacadtpi135`.`caso_detalle` (
  `id_caso_detalle` INT NOT NULL,
  `id_caso` INT NOT NULL,
  `Encargado_caso` VARCHAR(10) NOT NULL,
  `Estado_caso` VARCHAR(10) NOT NULL,
  `Fecha_inicio_caso` DATE NOT NULL,
  PRIMARY KEY (`id_caso_detalle`, `id_caso`),
  INDEX `id_casofk2` (`id_caso` ASC),
  CONSTRAINT `id_casofk2`
    FOREIGN KEY (`id_caso`)
    REFERENCES `casosacadtpi135`.`caso` (`id_caso`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `casosacadtpi135`.`caso_detalle_requisito`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `casosacadtpi135`.`caso_detalle_requisito` ;

CREATE TABLE IF NOT EXISTS `casosacadtpi135`.`caso_detalle_requisito` (
  `id_caso_detalle_requisito` INT NOT NULL,
  `id_caso_detalle` INT NOT NULL,
  PRIMARY KEY (`id_caso_detalle_requisito`, `id_caso_detalle`),
  INDEX `Caso_detalle_requisito_Caso_detalle` (`id_caso_detalle` ASC),
  CONSTRAINT `Caso_detalle_requisito_Caso_detalle`
    FOREIGN KEY (`id_caso_detalle`)
    REFERENCES `casosacadtpi135`.`caso_detalle` (`id_caso_detalle`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `casosacadtpi135`.`caso_detalle_requisito_atestado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `casosacadtpi135`.`caso_detalle_requisito_atestado` ;

CREATE TABLE IF NOT EXISTS `casosacadtpi135`.`caso_detalle_requisito_atestado` (
  `id_caso_detalle_requisito_atestado` INT NOT NULL,
  `id_caso_detalle_requisito` INT NOT NULL,
  PRIMARY KEY (`id_caso_detalle_requisito_atestado`),
  INDEX `Caso_detalle_requisito_atestado_Caso_detalle_requisito` (`id_caso_detalle_requisito` ASC),
  CONSTRAINT `Caso_detalle_requisito_atestado_Caso_detalle_requisito`
    FOREIGN KEY (`id_caso_detalle_requisito`)
    REFERENCES `casosacadtpi135`.`caso_detalle_requisito` (`id_caso_detalle_requisito`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `casosacadtpi135`.`tipo_paso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `casosacadtpi135`.`tipo_paso` ;

CREATE TABLE IF NOT EXISTS `casosacadtpi135`.`tipo_paso` (
  `id_tipo_paso` INT NOT NULL,
  `Nombre_tipo_paso` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id_tipo_paso`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `casosacadtpi135`.`paso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `casosacadtpi135`.`paso` ;

CREATE TABLE IF NOT EXISTS `casosacadtpi135`.`paso` (
  `id_paso` INT NOT NULL,
  `id_tipo_paso` INT NOT NULL,
  `Descripcion_paso` VARCHAR(50) NOT NULL,
  `Fecha_inicio` DATE NOT NULL,
  `Fechas_final` DATE NOT NULL,
  `Estado_paso` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id_paso`, `id_tipo_paso`),
  INDEX `fk_paso_tipo_paso1_idx` (`id_tipo_paso` ASC),
  CONSTRAINT `id_tipo_pasofk1`
    FOREIGN KEY (`id_tipo_paso`)
    REFERENCES `casosacadtpi135`.`tipo_paso` (`id_tipo_paso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `casosacadtpi135`.`tipo_requisito`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `casosacadtpi135`.`tipo_requisito` ;

CREATE TABLE IF NOT EXISTS `casosacadtpi135`.`tipo_requisito` (
  `id_tipo_requisito` INT NOT NULL,
  `Nombre_tipo_requisito` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id_tipo_requisito`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `casosacadtpi135`.`requisito`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `casosacadtpi135`.`requisito` ;

CREATE TABLE IF NOT EXISTS `casosacadtpi135`.`requisito` (
  `id_requisito` INT NOT NULL,
  `id_tipo_requisito` INT NOT NULL,
  `Descripcion_requisito` VARCHAR(10) NOT NULL,
  `Nombre_requisito` VARCHAR(10) NOT NULL,
  `Expiracion` VARCHAR(10) NOT NULL,
  `Estado_requisito` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id_requisito`, `id_tipo_requisito`),
  INDEX `fk_requisito_tipo_requisito1_idx` (`id_tipo_requisito` ASC),
  CONSTRAINT `id_tipo_requisitofk1`
    FOREIGN KEY (`id_tipo_requisito`)
    REFERENCES `casosacadtpi135`.`tipo_requisito` (`id_tipo_requisito`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `casosacadtpi135`.`paso_requisito`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `casosacadtpi135`.`paso_requisito` ;

CREATE TABLE IF NOT EXISTS `casosacadtpi135`.`paso_requisito` (
  `id_paso` INT NOT NULL,
  `id_requisito` INT NOT NULL,
  `Finalizado` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id_paso`, `id_requisito`),
  INDEX `id_requisitofk` (`id_requisito` ASC),
  CONSTRAINT `id_pasofk1`
    FOREIGN KEY (`id_paso`)
    REFERENCES `casosacadtpi135`.`paso` (`id_paso`),
  CONSTRAINT `id_requisitofk`
    FOREIGN KEY (`id_requisito`)
    REFERENCES `casosacadtpi135`.`requisito` (`id_requisito`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `casosacadtpi135`.`proceso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `casosacadtpi135`.`proceso` ;

CREATE TABLE IF NOT EXISTS `casosacadtpi135`.`proceso` (
  `id_proceso` INT NOT NULL,
  `id_caso` INT NOT NULL,
  `Nombre_proceso` VARCHAR(10) NOT NULL,
  `Descripcion_proceso` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id_proceso`, `id_caso`),
  INDEX `id_casofk_idx` (`id_caso` ASC),
  CONSTRAINT `id_casofk1`
    FOREIGN KEY (`id_caso`)
    REFERENCES `casosacadtpi135`.`caso` (`id_caso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `casosacadtpi135`.`proceso_detalle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `casosacadtpi135`.`proceso_detalle` ;

CREATE TABLE IF NOT EXISTS `casosacadtpi135`.`proceso_detalle` (
  `id_proceso` INT NOT NULL,
  `id_paso` INT NOT NULL,
  `inicio_proceso` DATE NOT NULL,
  `final_proceso` DATE NOT NULL,
  `Estado_proceso` VARCHAR(10) NOT NULL,
  `Encargado_proceso` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id_proceso`, `id_paso`),
  INDEX `id_pasofk2` (`id_paso` ASC),
  INDEX `fk_proceso_detalle_proceso1_idx` (`id_proceso` ASC),
  CONSTRAINT `id_pasofk2`
    FOREIGN KEY (`id_paso`)
    REFERENCES `casosacadtpi135`.`paso` (`id_paso`),
  CONSTRAINT `id_procesofk`
    FOREIGN KEY (`id_proceso`)
    REFERENCES `casosacadtpi135`.`proceso` (`id_proceso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
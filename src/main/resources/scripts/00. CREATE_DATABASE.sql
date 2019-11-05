-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema juanbody_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema juanbody_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `juanbody_db` DEFAULT CHARACTER SET latin1 ;
USE `juanbody_db` ;

-- -----------------------------------------------------
-- Table `juanbody_db`.`training`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `juanbody_db`.`training` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `status` BIT(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `juanbody_db`.`muscle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `juanbody_db`.`muscle` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `juanbody_db`.`exercise`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `juanbody_db`.`exercise` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `muscle_id` BIGINT(20) NOT NULL,
  `training_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKlxm7ovttlsdc7tsh66lkv73ma` (`muscle_id` ASC),
  INDEX `FKdgf11138wea34dd612056iuds` (`training_id` ASC),
  CONSTRAINT `FKdgf11138wea34dd612056iuds`
    FOREIGN KEY (`training_id`)
    REFERENCES `juanbody_db`.`training` (`id`),
  CONSTRAINT `FKlxm7ovttlsdc7tsh66lkv73ma`
    FOREIGN KEY (`muscle_id`)
    REFERENCES `juanbody_db`.`muscle` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `juanbody_db`.`goal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `juanbody_db`.`goal` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `exercise_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK2sh8drf0n2dk8er3lj99exyy1` (`exercise_id` ASC),
  CONSTRAINT `FK2sh8drf0n2dk8er3lj99exyy1`
    FOREIGN KEY (`exercise_id`)
    REFERENCES `juanbody_db`.`exercise` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `juanbody_db`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `juanbody_db`.`user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `age` VARCHAR(255) NOT NULL,
  `first_name` VARCHAR(255) NULL DEFAULT NULL,
  `height` VARCHAR(255) NOT NULL,
  `last_name` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NOT NULL,
  `user_name` VARCHAR(255) NOT NULL,
  `weight` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `juanbody_db`.`practice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `juanbody_db`.`practice` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `time` DOUBLE NOT NULL,
  `exercise_id` BIGINT(20) NOT NULL,
  `goal_id` BIGINT(20) NULL DEFAULT NULL,
  `user_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKtibr289xx4mx993t96ky5bqdh` (`exercise_id` ASC),
  INDEX `FKbh0kfdiyhcfkmmnxoj2ync80c` (`goal_id` ASC),
  INDEX `FK6imtt0a723sdy5abwpe8rh9u2` (`user_id` ASC),
  CONSTRAINT `FK6imtt0a723sdy5abwpe8rh9u2`
    FOREIGN KEY (`user_id`)
    REFERENCES `juanbody_db`.`user` (`id`),
  CONSTRAINT `FKbh0kfdiyhcfkmmnxoj2ync80c`
    FOREIGN KEY (`goal_id`)
    REFERENCES `juanbody_db`.`goal` (`id`),
  CONSTRAINT `FKtibr289xx4mx993t96ky5bqdh`
    FOREIGN KEY (`exercise_id`)
    REFERENCES `juanbody_db`.`exercise` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

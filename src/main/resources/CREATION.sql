-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema edTech
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema edTech
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `edTech` DEFAULT CHARACTER SET utf8 ;
USE `edTech` ;

-- -----------------------------------------------------
-- Table `edTech`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `edTech`.`user` (
  `user_Id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(255) NULL,
  `last_name` VARCHAR(255) NULL,
  `user_name` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`user_Id`),
  UNIQUE INDEX `userId_UNIQUE` (`user_Id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `edTech`.`subject`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `edTech`.`subject` (
  `subject_Id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  PRIMARY KEY (`subject_Id`),
  UNIQUE INDEX `subjectId_UNIQUE` (`subject_Id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `edTech`.`classroom`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `edTech`.`classroom` (
  `classroom_id` INT NOT NULL AUTO_INCREMENT,
  `user_userId` INT NOT NULL,
  `subject_subjectId` INT NOT NULL,
  PRIMARY KEY (`classroom_id`),
  INDEX `fk_classroom_user_idx` (`user_userId` ASC) VISIBLE,
  INDEX `fk_classroom_subject1_idx` (`subject_subjectId` ASC) VISIBLE,
  CONSTRAINT `fk_classroom_user`
    FOREIGN KEY (`user_userId`)
    REFERENCES `edTech`.`user` (`user_Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_classroom_subject1`
    FOREIGN KEY (`subject_subjectId`)
    REFERENCES `edTech`.`subject` (`subject_Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

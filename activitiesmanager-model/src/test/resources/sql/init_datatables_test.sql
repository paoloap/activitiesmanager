-- -----------------------------------------------------
-- Schema amdb
--
-- Activities Manager Database
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `amdb` DEFAULT CHARACTER SET utf8 ;
USE `amdb` ;

-- -----------------------------------------------------
-- Table `amdb`.`ActivityType`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amdb`.`ActivityType` (
  `TYPE_ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `T_NAME` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`TYPE_ID`),
  UNIQUE INDEX `TYPE_ID_UNIQUE` (`TYPE_ID` ASC),
  UNIQUE INDEX `T_NAME_UNIQUE` (`T_NAME` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `amdb`.`ActivityStatus`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amdb`.`ActivityStatus` (
  `STATUS_ID` INT UNSIGNED NOT NULL,
  `S_NAME` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`STATUS_ID`),
  UNIQUE INDEX `STATUS_ID_UNIQUE` (`STATUS_ID` ASC),
  UNIQUE INDEX `S_NAME_UNIQUE` (`S_NAME` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `amdb`.`Role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amdb`.`Role` (
  `ROLE_ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `R_NAME` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`ROLE_ID`),
  UNIQUE INDEX `ROLE_ID_UNIQUE` (`ROLE_ID` ASC),
  UNIQUE INDEX `R_NAME_UNIQUE` (`R_NAME` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `amdb`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amdb`.`User` (
  `USER_ID` INT UNSIGNED NOT NULL,
  `U_LOGIN` VARCHAR(45) NOT NULL,
  `U_PWD` VARCHAR(45) NOT NULL,
  `U_NAME` VARCHAR(45) NOT NULL,
  `U_ADDRESS` VARCHAR(45) NOT NULL,
  `U_BIRTHDAY` DATE NOT NULL,
  `U_CITY` VARCHAR(45) NOT NULL,
  `U_ROLE_ID` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`USER_ID`),
  UNIQUE INDEX `USER_ID_UNIQUE` (`USER_ID` ASC),
  UNIQUE INDEX `U_LOGIN_UNIQUE` (`U_LOGIN` ASC),
  INDEX `fk_User_Role1_idx` (`U_ROLE_ID` ASC),
  CONSTRAINT `fk_User_Role1`
    FOREIGN KEY (`U_ROLE_ID`)
    REFERENCES `amdb`.`Role` (`ROLE_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `amdb`.`Activity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amdb`.`Activity` (
  `ACTIVITY_ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `A_NAME` VARCHAR(45) NOT NULL,
  `A_DESCRIPTION` VARCHAR(500) NOT NULL,
  `A_STATUS_ID` INT UNSIGNED NOT NULL,
  `A_USER_ID` INT UNSIGNED NOT NULL,
  `A_TYPE_ID` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`ACTIVITY_ID`),
  UNIQUE INDEX `Id_UNIQUE` (`ACTIVITY_ID` ASC),
  INDEX `fk_Activity_ActivityType_idx` (`A_TYPE_ID` ASC),
  INDEX `fk_Activity_ActivityStatus_idx` (`A_STATUS_ID` ASC),
  INDEX `fk_Activity_User_idx` (`A_USER_ID` ASC),
  CONSTRAINT `fk_Activity_ActivityType`
    FOREIGN KEY (`A_TYPE_ID`)
    REFERENCES `amdb`.`ActivityType` (`TYPE_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Activity_ActivityStatus`
    FOREIGN KEY (`A_STATUS_ID`)
    REFERENCES `amdb`.`ActivityStatus` (`STATUS_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Activity_User`
    FOREIGN KEY (`A_USER_ID`)
    REFERENCES `amdb`.`User` (`USER_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Tabella \'Activity\'';


-- -----------------------------------------------------
-- Table `amdb`.`Permission`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amdb`.`Permission` (
  `PERMISSION_ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `P_NAME` VARCHAR(20) NOT NULL,
  UNIQUE INDEX `P_NAME_UNIQUE` (`P_NAME` ASC),
  PRIMARY KEY (`PERMISSION_ID`),
  UNIQUE INDEX `PERMISSION_ID_UNIQUE` (`PERMISSION_ID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `amdb`.`Role_has_Permission`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amdb`.`Role_has_Permission` (
  `ROLE_ID` INT UNSIGNED NOT NULL,
  `PERMISSION_ID` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`ROLE_ID`, `PERMISSION_ID`),
  INDEX `fk_Role_has_Permission_Permission1_idx` (`PERMISSION_ID` ASC),
  INDEX `fk_Role_has_Permission_Role1_idx` (`ROLE_ID` ASC),
  CONSTRAINT `fk_Role_has_Permission_Role1`
    FOREIGN KEY (`ROLE_ID`)
    REFERENCES `amdb`.`Role` (`ROLE_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Role_has_Permission_Permission1`
    FOREIGN KEY (`PERMISSION_ID`)
    REFERENCES `amdb`.`Permission` (`PERMISSION_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

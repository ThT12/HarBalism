CREATE SCHEMA `harbase` ;


CREATE TABLE `harbase`.`plant` (
  `id_plant` INT NOT NULL COMMENT '',
  `name_plant` VARCHAR(45) NOT NULL COMMENT '',
  `start_harvest_date` VARCHAR(45) NOT NULL COMMENT '',
  `end_harvest_date` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`id_plant`)  COMMENT '',
  UNIQUE INDEX `id_plant_UNIQUE` (`id_plant` ASC)  COMMENT '');


CREATE TABLE `harbase`.`user` (
  `id_user` INT NOT NULL COMMENT '',
  `name_user` VARCHAR(45) NOT NULL COMMENT '',
  `password` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`id_user`)  COMMENT '',
  UNIQUE INDEX `id_user_UNIQUE` (`id_user` ASC)  COMMENT '');
  
  
  CREATE TABLE `harbase`.`hiking` (
  `id_hiking` INT NOT NULL COMMENT '',
  `id_user` INT NOT NULL COMMENT '',
  `hiking_name` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`id_hiking`)  COMMENT '',
  UNIQUE INDEX `id_hiking_UNIQUE` (`id_hiking` ASC)  COMMENT '');


ALTER TABLE `harbase`.`hiking` 
ADD CONSTRAINT `id_user`
  FOREIGN KEY (`id_user`)
  REFERENCES `harbase`.`user` (`id_user`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;

CREATE TABLE `harbase`.`harvest_area` (
  `id_harvest_area` INT NOT NULL COMMENT '',
  `name_harvest_area` VARCHAR(45) NOT NULL COMMENT '',
  `id_plant` INT NOT NULL COMMENT '',
  `size` ENUM('SMALL', 'MEDIUM', 'LARGE') NOT NULL COMMENT '',
  `disponibility` DECIMAL(3,2) NOT NULL COMMENT '',
  `latitude` DECIMAL(5,2) NOT NULL COMMENT '',
  `longitude` DECIMAL(5,2) NOT NULL COMMENT '',
  PRIMARY KEY (`id_harvest_area`)  COMMENT '',
  UNIQUE INDEX `id_harvest_area_UNIQUE` (`id_harvest_area` ASC)  COMMENT '',
  INDEX `id_plant_idx` (`id_plant` ASC)  COMMENT '',
  CONSTRAINT `id_plant`
    FOREIGN KEY (`id_plant`)
    REFERENCES `harbase`.`plant` (`id_plant`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);

CREATE TABLE `harbase`.`hiking_to_area` (
  `id_hiking` INT NOT NULL COMMENT '',
  `id_harvest_area` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id_hiking`, `id_harvest_area`)  COMMENT '',
  INDEX `id_harvest_area_idx` (`id_harvest_area` ASC)  COMMENT '',
  CONSTRAINT `id_hiking`
    FOREIGN KEY (`id_hiking`)
    REFERENCES `harbase`.`hiking` (`id_hiking`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_harvest_area`
    FOREIGN KEY (`id_harvest_area`)
    REFERENCES `harbase`.`harvest_area` (`id_harvest_area`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

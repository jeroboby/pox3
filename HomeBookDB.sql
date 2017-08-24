drop database if exists `HomeBookDB`;

create database `HomeBookDB`;
use `HomeBookDB`;

create table `cities` (
	`zip_code` INT(5) NOT NULL,
	`name` TEXT,
	PRIMARY KEY(`zip_code`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

create table `homes` (
<<<<<<< HEAD
	`id` INT,
=======
	`id` INT NOT NULL auto_increment,
>>>>>>> e01829761845dae56e2ff050d81c96eb555d76a4
    `zip_code` INT,
	`surface` INT,
    `price` INT,
	PRIMARY KEY(`id`),
    FOREIGN KEY (`zip_code`) REFERENCES `cities` (`zip_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

create table `counties` (
	`zip_county` INT,
    `name` VARCHAR(50),
    PRIMARY KEY(`zip_county`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT into `cities` VALUES (66666,"CityExample");
<<<<<<< HEAD
INSERT into `homes` VALUES (48258,66666,666,666);
=======
INSERT into `homes` VALUES (0,66666,42,51);
>>>>>>> e01829761845dae56e2ff050d81c96eb555d76a4
INSERT into `counties` VALUES (66,"CountyExample");
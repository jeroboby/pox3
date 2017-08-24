drop database if exists `HomeBookDB`;

create database `HomeBookDB`;
use `HomeBookDB`;

create table `cities` (
	`zip_code` INT(5) NOT NULL,
	`name` TEXT,
	PRIMARY KEY(`zip_code`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

create table `homes` (
	`id` INT NOT NULL auto_increment,
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
INSERT into `homes` VALUES (0,66666,42,51);
INSERT into `counties` VALUES (66,"CountyExample");
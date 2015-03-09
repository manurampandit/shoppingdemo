--<ScriptOptions statementTerminator=";"/>

ALTER TABLE `userdb`.`user` DROP PRIMARY KEY;

DROP TABLE `userdb`.`user`;

CREATE TABLE `userdb`.`user` (
	`UserId` INT NOT NULL,
	`first_name` VARCHAR(100),
	`last_name` VARCHAR(100),
	`gender` VARCHAR(30),
	`city` VARCHAR(30),
	PRIMARY KEY (`UserId`)
) ENGINE=InnoDB;


ALTER TABLE `parkinggarage`.`customers` CHANGE COLUMN `customerID` `customerID` INT NOT NULL;

ALTER TABLE `parkinggarage`.`customers` DROP PRIMARY KEY;

DROP TABLE `parkinggarage`.`customers`;

CREATE TABLE `parkinggarage`.`customers` (
	`customerID` INT NOT NULL AUTO_INCREMENT,
	`customerName` VARCHAR(60),
	`currentBalance` FLOAT,
	`carID1` INT,
	`carID2` INT,
	`carID3` INT,
	`carID4` INT,
	`carID5` INT,
	`pref_floor` INT,
	`pref_handicap` INT,
	`pref_space` INT,
	`currentReservationID` INT,
	`upcomingReservationID1` INT,
	`upcomingReservationID2` INT,
	`upcomingReservationID3` INT,
	`pastReservationID1` INT,
	`pastReservationID2` INT,
	`pastReservationID3` INT,
	PRIMARY KEY (`customerID`)
);


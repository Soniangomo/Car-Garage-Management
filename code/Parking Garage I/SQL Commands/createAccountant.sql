/*Sonia Ngomo*/
USE parkinggarage;

DROP TABLE Accountant;

CREATE TABLE Accountant (
	transcationID INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	charge FLOAT(8,2),
	hours FLOAT (8,2),
	parkingSpot INT(10),
	userID INT(10),
	userName VARCHAR(60),
	carID INT(10),
	licensePlate VARCHAR(10),
	newLineBalance FLOAT(10,2)
);

INSERT INTO Accountant (charge, hours, parkingSpot, userID, userName, carID, licensePlate, newLineBalance) VALUES (0,0,0,0,'XXX',0,'XXX',0);
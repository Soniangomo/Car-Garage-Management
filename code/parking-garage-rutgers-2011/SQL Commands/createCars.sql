/*Brian Goodacre*/
use parkinggarage;

DROP TABLE cars;

CREATE TABLE cars(
	/*Basic Car Information*/
	carID INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	licensePlate VARCHAR(10),
	
	/*Customers Associated with this user*/
	customerID1 INT(10),
	customerID2 INT(10),
	customerID3 INT(10),
	customerID4 INT(10),
	customerID5 INT(10)
);
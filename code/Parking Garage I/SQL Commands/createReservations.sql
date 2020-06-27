/*Brian Goodacre*/

/*This is for single reservations*/
use parkinggarage;

DROP TABLE reservations;

CREATE TABLE Reservations(

	reservationID INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	
	/*0 for walk-in, 1 for reserved, 2 for long-term*/
	reservation_type INT(10), 
	
	customerID INT(10),
	carID INT(10),
	
	parkingSpaceID INT(10),
	
	arrivalTime DATETIME,
	departureTime DATETIME,
	
	actualArrivalTime DATETIME,
	actualDepartureTime DATETIME
);


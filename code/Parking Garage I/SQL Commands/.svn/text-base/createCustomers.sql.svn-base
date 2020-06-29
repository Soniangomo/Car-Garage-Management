/*Sonia Ngomo*/
use parkinggarage;

DROP TABLE Customers;

CREATE TABLE Customers (
	/*Standard information about the Customer*/
	customerID INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	customerName VARCHAR(60),
	currentBalance FLOAT(8,2),
	
	/*Cars Associated with this Customer*/
	carID1 INT(10),
	carID2 INT(10),
	carID3 INT(10),
	carID4 INT(10),
	carID5 INT(10),
	
	/*Preferences*/
	pref_floor INT(10),
	pref_handicap INT(1),
	pref_space INT(10),
	
	/*Who is currently in the spot?*/
	currentReservationID INT(10),
	
	/*Upcoming Reservations*/
	upcomingReservationID1 INT(10),
	upcomingReservationID2 INT(10),
	upcomingReservationID3 INT(10),
	
	/*Past Reservations for Reference*/
	pastReservationID1 INT(10),
	pastReservationID2 INT(10),
	pastReservationID3 INT(10)
);

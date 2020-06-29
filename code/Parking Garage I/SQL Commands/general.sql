use parkinggarage;

SELECT  * FROM customers WHERE customerID = 1;

SELECT carID FROM cars WHERE licensePlate LIKE 'ABC123'; 

UPDATE parkingspaces SET time20110101_0045=NULL;

SELECT time20110101_0130 FROM parkingspaces WHERE time20110101_0130 IS NOT NULL;

SELECT reservationID  FROM reservations  WHERE arrivalTime='2020 29 06 :15:00.0'

SELECT customerID1 FROM cars WHERE	licensePlate LIKE "ABC123"

SELECT  * FROM customers WHERE customerID LIKE 1

INSERT INTO cars(carID, licensePlate, customerID1) VALUES ('1', 'ABC123',1);

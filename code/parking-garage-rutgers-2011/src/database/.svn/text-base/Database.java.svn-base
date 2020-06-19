package database;

import java.sql.*;
import money.Accountant;

public class Database {
	/*class variables*/
	protected static Connection con=null;
	protected static Statement stmt=null;
	protected static ResultSet rs=null;
	protected static int numLicensePlates=5;
	protected static int spotsPerFloor=26;
	protected static int numFloors=4;
	protected static int numParkingSpots = numFloors * spotsPerFloor;
	protected static int parkingStartNumber = 0;
	protected static int maxCarsPerCustomer = 5;
	protected static int maxCustomersPerCar = 5;
	protected static int maxReservationsPerCustomer = 3;

	/*Constructor*/
	public Database(){}
	
	
	/*Purpose: Open connection to database*/
	public static boolean connectToDatabase() throws ClassNotFoundException, SQLException{
		String username = "root";
		String password = "park";
		String url = "jdbc:mysql://localhost:3306/";
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url+"parkinggarage", username, password);
		stmt = con.createStatement();
		
		//set values for new line balance
		//Assumption - Only deposits.
		rs=stmt.executeQuery("SELECT MAX(newLineBalance) FROM Accountant");
		rs.next();
		Accountant.addToBalance(rs.getFloat(1));
		
		
		return true; //assume this works
	}
	
	/*Purpose: Close connection to database*/
	public static boolean closeDatabase() throws ClassNotFoundException, SQLException{
		rs.close();
		stmt.close();
		con.close();
		return true;//assume this works
	}

	/*	Use Customer.plate_to_Customers(inputPlate) instead of licensePlate_to_Customer(String inputPlate)*/
	/*	Use Car.plate_to_Car(plate) instead of licensePlate_to_Car (String plate) */
	/*	Use Customer.ID_to_Customer instead of userID_to_Customer (int id)*/
	/*	Use Car.ID_to_Car instead of carID_to_car*/
	/*	Use Reservation.ID_to_Reservation instead of reservationID_to_Reservation(int id)*/
	/*	Use LotMonitor.availableParkingSpot(in,out) instead of availableParkingSpot(in,out)*/
	/*	Use LotMonitor.garageOccupancy(Calendar time) == garageOccupancy(Calendar time)*/
	/*	Use LotMonitor.isCurrentFull(Calendar time) == isCurrentFull(Calendar time)*/
	

}
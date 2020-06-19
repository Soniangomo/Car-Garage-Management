package databases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import dataStructures.*;
import database.*;

public class Database_Constructors extends Database{
	
	//	Purpose: 	Converts a (int) Customer ID to a Customer Object by reading from the database
	public static Customer ID_to_Customer (int id) throws ClassNotFoundException, SQLException{
		int temp1;

		//get row related to the customer
		rs = stmt.executeQuery("" +
				" SELECT  * " +
				" FROM customers" +
				" WHERE customerID = " + id + " ;");
		
		if(rs.next()==false){
			return null;
		}
		
		ArrayList<Integer> tempCarIDs = new ArrayList<Integer>();
		ArrayList<Integer> tempUpRes = new ArrayList<Integer>();
		ArrayList<Integer> tempPastRes = new ArrayList<Integer>();
		ArrayList<Integer> tempPrefs = new ArrayList<Integer>();
		
		//columns 4 to 8 - add car reservations to an ArrayList
		for (int i = 4; i<=8; i++){
			temp1 = rs.getInt(i);
			if (temp1!=0){
				tempCarIDs.add(rs.getInt(i));
			}
		}
		//columns 9 to 11 - add preferences
		for (int i = 9; i<=11; i++){
			temp1 = rs.getInt(i);
			if (temp1!=0){
				tempPrefs.add(rs.getInt(i));
			}
		}
		
		//columns 13 to 15 - add upcoming reservation
		for (int i = 13; i<=15; i++){
			temp1 = rs.getInt(i);
			if (temp1!=0){
				tempUpRes.add(rs.getInt(i));
			}
		}
		//columns 16 to 18 - add past reservation
		for (int i = 16; i<=18; i++){
			temp1 = rs.getInt(i);
			if (temp1!=0){
				tempPastRes.add(rs.getInt(i));
			}
		}
		//create new Customer
		Customer temp = new Customer(
				rs.getInt(1), //customerID
				rs.getString(2), //name
				rs.getFloat(3), //balance
				tempCarIDs, //carIDs
				tempPrefs, //preferences
				rs.getInt(12), //current reservation
				tempUpRes, //upcoming reservations
				tempPastRes //past reservations
		);
		return temp;
	}

	// Purpose:		Convert a (int) Reservation ID to a Reservation Object by reading from the database
	public static Reservation ID_to_Reservation (int id) throws ClassNotFoundException, SQLException{

		//get entire row from database for an object
		rs = stmt.executeQuery("" +
				" SELECT  * " +
				" FROM reservations" +
				" WHERE reservationID  = " + id);

		if(rs.next()==false){
			return null;
		}
		Reservation temp = null;

		//making Calendar Objects
		Calendar arrTime = Database_Helpers.SQLTime_to_Calendar(rs.getDate(6), rs.getTime(6));
		Calendar depTime = Database_Helpers.SQLTime_to_Calendar(rs.getDate(7), rs.getTime(7));
		Calendar ACarrTime = Database_Helpers.SQLTime_to_Calendar(rs.getDate(8), rs.getTime(8));
		Calendar ACdepTime = Database_Helpers.SQLTime_to_Calendar(rs.getDate(9), rs.getTime(9));

		//making Reservation Object
		temp = new Reservation(
				rs.getInt(1), //reservationID
				rs.getInt(2), //reservationType
				rs.getInt(3), //customerID
				rs.getInt(4), //carID
				rs.getInt(5), //parkingSpaceID
				arrTime,
				depTime,
				ACarrTime,
				ACdepTime					
		);
		return temp; //return
	}

	//	Purpose:	Converts a (int) Car ID to a Car Object by reading from the database 
	public static Car ID_to_Car (int id) throws ClassNotFoundException, SQLException{
		Car temp = null;
		//get from database
		rs = stmt.executeQuery("" +
				" SELECT  * " +
				" FROM cars" +
				" WHERE carID " +
				" LIKE " + id);
		
		int temp2;
		if(rs.next()){
			ArrayList<Integer> cIDs= new ArrayList<Integer>(5);
			for(int i =3; i<=7; i++){
				temp2 = rs.getInt(i);
				if(temp2!=0){
					cIDs.add(temp2);
				}
			}
			//making Car
			temp = new Car(
					rs.getInt(1),
					rs.getString(2),
					cIDs
					);
		}
		return temp; //return
	}
	
	//	Purpose:	Convert a Generic Car Object to a Generic Database row
	public static void Car_to_Database (Car c) throws ClassNotFoundException, SQLException{
		//license plate
		stmt.executeUpdate("" +
				" UPDATE cars " +
				" SET licensePlate = '"+c.getLicensePlate()+"'" +
				" WHERE carID = " + c.getCarID());
		
		//Customer IDs
		String value="";
		for (int j = 1; j<=5; j++){
			if(c.getCustomerIDs().size()>=j){//update it
				value = Integer.toString(c.getCustomerIDsIntegers().get(j-1));
			}
			else{//set NULL
				value="NULL";
			}
			
			//update the database
			stmt.executeUpdate("" +
					" UPDATE cars " +
					" SET customerID"+j+" = "+value+
					" WHERE carID = " + c.getCarID());
		}
	}
	
	//	Purpose:	Convert a Generic Reservation Object to a Generic Database Row
	public static void Reservation_to_Database (Reservation r) throws ClassNotFoundException, SQLException{
		String value;
		
		//reservation_type
		stmt.executeUpdate("" +
				" UPDATE reservations " +
				" SET reservation_type = "+r.getReservationType()+
				" WHERE reservationID = " + r.getReservationID());
		//customerID
		stmt.executeUpdate("" +
				" UPDATE reservations " +
				" SET customerID = "+r.getCustomerID()+
				" WHERE reservationID = " + r.getReservationID());
		//carID
		stmt.executeUpdate("" +
				" UPDATE reservations " +
				" SET carID = "+r.getCarID()+
				" WHERE reservationID = " + r.getReservationID());
		//parkingSpaceID
		stmt.executeUpdate("" +
				" UPDATE reservations " +
				" SET parkingSpaceID = "+r.getParkingSpot()+
				" WHERE reservationID = " + r.getReservationID());
		//arrivalTime
		System.out.println("brian: " + Database_Helpers.Calendar_to_SQLTime(r.reservationInformation().get(0)));
		stmt.executeUpdate("" +
				" UPDATE reservations " +
				" SET arrivalTime = '"+Database_Helpers.Calendar_to_SQLTime(r.reservationInformation().get(0))+ "' " + 
				" WHERE reservationID = " + r.getReservationID());
		//departureTime
		stmt.executeUpdate("" +
				" UPDATE reservations " +
				" SET departureTime = '"+Database_Helpers.Calendar_to_SQLTime(r.reservationInformation().get(1))+ "' " +
				" WHERE reservationID = " + r.getReservationID());
		//actualArrivalTime
		if(r.reservationInformation().get(2)==null){
			value="NULL";
			stmt.executeUpdate("" +
					" UPDATE reservations " +
					" SET actualArrivalTime = "+value+ " " + 
					" WHERE reservationID = " + r.getReservationID());
		}
		else{
			value = Database_Helpers.Calendar_to_SQLTime(r.reservationInformation().get(2));
			stmt.executeUpdate("" +
					" UPDATE reservations " +
					" SET actualArrivalTime = '"+value+ "' " + 
					" WHERE reservationID = " + r.getReservationID());
		}
		//actualDeparatureTime
		if(r.reservationInformation().get(3)==null){
			value = "NULL";
			stmt.executeUpdate("" +
					" UPDATE reservations " +
					" SET actualDepartureTime = "+value+" " + 
					" WHERE reservationID = " + r.getReservationID());
		}
		else{
			value = Database_Helpers.Calendar_to_SQLTime(r.reservationInformation().get(3));
			stmt.executeUpdate("" +
					" UPDATE reservations " +
					" SET actualDepartureTime = '"+value+"' " + 
					" WHERE reservationID = " + r.getReservationID());
		}
		
	}

	//	Purpose:	Convert a Generic Customer Object to a Generic Database Row
	public static void Customer_to_Database (Customer c) throws ClassNotFoundException, SQLException{
		String value="";
		
		//customerName
		stmt.executeUpdate("" +
				" UPDATE customers " +
				" SET customerName = '"+c.getCustomerName()+ "' " + 
				" WHERE customerID = " + c.getCustomerID());
		//currentBalance
		stmt.executeUpdate("" +
				" UPDATE customers " +
				" SET currentBalance = "+c.getCurrentBalance()+
				" WHERE customerID = " + c.getCustomerID());
		//carIDs
		for (int j = 1; j<=5; j++){
			if(c.getCarIDs().size()>=j){//update it
				value = Integer.toString(c.getCarIDs().get(j-1));
			}
			else{//set NULL
				value="NULL";
			}
			//update the database
			stmt.executeUpdate("" +
					" UPDATE customers " +
					" SET carID"+j+" = "+value+
					" WHERE customerID = " + c.getCustomerID());
		}
		//preferences
		/*Preferences are stored as -1 if they are not entered*/
		String value01="NULL";
		String value02="NULL";
		String value03="NULL";
			//checking for a zero value
		if (c.getPreferences().get(0)!=0) //floor
			value01=Integer.toString(c.getPreferences().get(0));
		if (c.getPreferences().get(1)!=0) //handicap
			value02=Integer.toString(c.getPreferences().get(1));
		if (c.getPreferences().get(2)!=0) //space
			value03=Integer.toString(c.getPreferences().get(2));
			//updating the database
		stmt.executeUpdate("" + //floor
				" UPDATE customers " +
				" SET pref_floor = "+value01+
				" WHERE customerID = " + c.getCustomerID());
		stmt.executeUpdate("" + //handicap
				" UPDATE customers " +
				" SET pref_handicap = "+value02+
				" WHERE customerID = " + c.getCustomerID());
		stmt.executeUpdate("" + //space
				" UPDATE customers " +
				" SET pref_space = "+value03+
				" WHERE customerID = " + c.getCustomerID());
		//currentReservation
		if (c.getCurrentReservationID() == -1 || c.getCurrentReservationID() == 0)
			value = "NULL";
		else
			value = Integer.toString(c.getCurrentReservationID());
		
		stmt.executeUpdate("" +
				" UPDATE customers " +
				" SET currentReservationID = "+value+
				" WHERE customerID = " + c.getCustomerID());
		//upcomingReservations
		for (int j = 1; j<=3; j++){
			if(c.getUpcomingReservationsID().size()>=j){//update it
				value = Integer.toString(c.getUpcomingReservationsID().get(j-1));
			}
			else{//set NULL
				value="NULL";
			}
			//update the database
			stmt.executeUpdate("" +
					" UPDATE customers " +
					" SET upcomingReservationID"+j+" = "+value+
					" WHERE customerID = " + c.getCustomerID());
		}
		//pastReservations
		for (int j = 1; j<=3; j++){
			if(c.getPastReservationsID().size()>=j){//update it
				value = Integer.toString(c.getPastReservationsID().get(j-1));
			}
			else{//set NULL
				value="NULL";
			}
			//update the database
			stmt.executeUpdate("" +
					" UPDATE customers " +
					" SET pastReservationID"+j+" = "+value+
					" WHERE customerID = " + c.getCustomerID());
		}
	}

}

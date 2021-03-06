package dataStructures;

import java.sql.*;
import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Collections;
import database.*;
import databases.*;

public class Customer extends Database{
	
	/**Variables*/
	private int customerID;
	private String customerName;
	private float currentBalance;
	private ArrayList<Integer> carIDs;
	private ArrayList<Integer> preferences;
	private int currentReservation; //-1 for no current Reservation
	private ArrayList<Integer> upcomingReservations;
	private ArrayList<Integer> pastReservations;

	
	/**Constructors*/
	//	Purpose:	Create a Customer when everything is known
	public Customer(int cID, String cName, float cBalance, 
			ArrayList<Integer> cIDs, 
			ArrayList<Integer> pref,
			int cReservation, 
			ArrayList<Integer> uReservations, 
			ArrayList<Integer> pReservations){
		customerID=cID;
		customerName=cName;
		currentBalance=cBalance;
		carIDs=cIDs;
		preferences=pref;
		currentReservation=cReservation;
		upcomingReservations=uReservations;
		pastReservations=pReservations;
	}
	/*	Purpose:	Constructor a new Customer
	 * 	Input:		Name and preferences (-1 if not known)
	 * 	Output:		Customer Object
	 * */
	public Customer(String name, int floor, int handicap, int space) throws SQLException{
		customerName = name;
		currentBalance=0;
		currentReservation = -1;

		preferences = new ArrayList<Integer>();
		preferences.add(floor); 
		preferences.add(handicap);
		preferences.add(space);

		carIDs = new ArrayList<Integer>();
		upcomingReservations = new ArrayList<Integer>();
		pastReservations = new ArrayList<Integer>();

		//create new user ID
		stmt.executeUpdate(
				" INSERT INTO Customers " +
				" (customerName, currentBalance,pref_floor,pref_handicap,pref_space) " + 
				" VALUES ('" + name + "',0,"+floor+","+handicap+","+space+");");

		//get customerID
		rs=stmt.executeQuery("SELECT MAX(customerID) FROM Customers");
		rs.next();
		customerID=rs.getInt(1);
	}

	
	/**Functions that affect the Database
	 * @throws SQLException 
	 * @throws ClassNotFoundException */
	//update Balance
	public void updateBalance(float newBalance) throws ClassNotFoundException, SQLException {
		currentBalance = newBalance;
		Customer.Customer_to_Database(this);
	}
	//add car to the customer
	public boolean addCar(int cID) throws ClassNotFoundException, SQLException{
		//if there are too many cars, return false
		if(carIDs.size()>=maxCarsPerCustomer){
			return false;
		}
		else{
			Car tempCar = Database_Constructors.ID_to_Car(cID); //car object
			if(tempCar.getCustomerIDs().size()>=maxCustomersPerCar){ //cannot add 
				return false;
			}
			//update Customer Object
			carIDs.add(cID);
			//update Car Object
			tempCar.getCustomerIDsIntegers().add(customerID);
			//update Customer Database
			Database_Constructors.Customer_to_Database(this);
			//update Car Database
			Database_Constructors.Car_to_Database(tempCar);
		}
		return true;
	}
	//remove car from customer
	// TODO - Complete
//	public boolean removeCar (int cID) throws ClassNotFoundException, SQLException{
//		if (carIDs.size()==0){//error - not enough cars
//			return false;
//		}
//		else{
//			Car tempCar = Database_Constructors.ID_to_Car(cID);
//			if(tempCar.getCustomerIDsIntegers().size()==0){
//				return false;
//			}
//			//update Customer Object
//			carIDs.remove(carIDs.indexOf(cID));
//			//update Car Object
//			tempCar.getCustomerIDsIntegers().remove(
//					tempCar.getCustomerIDsIntegers().indexOf(customerID));
//			//update Customer Database
//			Database_Constructors.Customer_to_Database(this);
//			//update Car Database
//			Database_Constructors.Car_to_Database(tempCar);
//			//TODO - Update Reservation Database
//			//TODO - Check reservations that the Customer has with this car and cancel them as well
//		}
//		return true;
//	}
	/*	Purpose:	Have the customer check into his reservation
	 * 	Input:		current time
	 * 	Output:		True if successful check in, false if the check in fails.
	 */


	/**Functions that Read the Database but do not affect it*/
	//	Purpose:	simply returns the parking spot of a car
	public int getCarLocation() throws ClassNotFoundException, SQLException{
		Reservation r = Database_Constructors.ID_to_Reservation(currentReservation);
		return (r.getParkingSpot());
	}
	//	Purpose:	Given a license plate, return all users associated with that plate
	public static ArrayList<Customer> plate_to_Customers(String plate) throws ClassNotFoundException, SQLException{
		Car temp = Car.plate_to_Car(plate);
		if (temp==null){
			return null;
		}
		return temp.getCustomerIDs();
	}
	//	Purpose:	Given a userID, return a Customer
	public static Customer ID_to_Customer(int id) throws ClassNotFoundException, SQLException{
		return Database_Constructors.ID_to_Customer(id);
	}
	//	Purpose:	Update Database, given a Customer Object
	public static void Customer_to_Database(Customer c) throws ClassNotFoundException, SQLException{
		Database_Constructors.Customer_to_Database(c);
	}


	/**Functions that Return Customer Values*/
	public int getCustomerID(){
		return customerID;
	}
	public String getCustomerName(){
		return customerName;
	}
	public double getCurrentBalance(){
		return currentBalance;
	}
	public int getCurrentReservationID(){
		return currentReservation;
	}
	public ArrayList<Integer> getCarIDs(){
		return carIDs;
	}	
	public ArrayList<Integer> getPreferences(){
		return preferences;
	}	
	public ArrayList<Integer> getUpcomingReservationsID(){
		return upcomingReservations;
	}
	public ArrayList<Integer> getPastReservationsID(){
		return pastReservations;
	} 
	public Reservation getCurrentReservation() throws ClassNotFoundException, SQLException{
		return Reservation.ID_to_Reservation(currentReservation);
	}
	public ArrayList<Car> getCars() throws ClassNotFoundException, SQLException{
		ArrayList<Car> temp = new ArrayList<Car>();
		for (int i=0; i<carIDs.size(); i++){
			temp.add(Car.ID_to_Car(carIDs.get(i)));
		}
		return temp;
	}
	public ArrayList<Reservation> getUpcomingReservations() throws ClassNotFoundException, SQLException{
		//return upcomingReservations; 
		//for returning an ArrayList of Reservations and not Integers
		ArrayList<Reservation> temp = new ArrayList<Reservation>();
		for (int i=0; i<upcomingReservations.size(); i++){
			temp.add(Reservation.ID_to_Reservation(upcomingReservations.get(i)));
		}
		return temp;
	}
	public ArrayList<Reservation> getPastReservations() throws ClassNotFoundException, SQLException{
		ArrayList<Reservation> temp = new ArrayList<Reservation>();
		for (int i=0; i<pastReservations.size(); i++){
			temp.add(Reservation.ID_to_Reservation(pastReservations.get(i)));
		}
		return temp;
	}
	public void setCurrentReservationID(int id){
		currentReservation=id;
	}
	
//	// TODO - Is this necassary?? 
//	public boolean checkIn (Calendar currentTime) throws ClassNotFoundException, SQLException{
//		// sort the reservations of the currentUser
//		Collections.sort(upcomingReservations); //closest to oldest
//		Collections.sort(pastReservations); //oldest to newest
//
//		//get current reservation
//		currentReservation = upcomingReservations.get(0);
//		Reservation tempRes = Reservation.ID_to_Reservation(currentReservation);
//
//		// TODO - Car arrives earlier/late, check for rescheduling
//		if(tempRes.reservationInformation().get(0).compareTo(currentTime) < 0 || 
//				tempRes.reservationInformation().get(0).compareTo(currentTime) > 0){ //early or late
//			//create reservation object
//			Reservation temp5 = new Reservation (customerID, -1, tempRes.getCarID(), currentTime, tempRes.reservationInformation().get(1));
//			
//			if(temp5.reservationInformation().get(1).compareTo(currentTime) > 0){
//				return false; //came after reservation has ended
//			}
//			else if (temp5.getReservationID() == -1) //no parking spaces
//				return false;
//			else if (temp5.getReservationID() == -2){ //too many parking spaces
//				if (LotMonitor.availableParkingSpot(currentTime, tempRes.reservationInformation().get(1)) != -1){ //check for a spot
//					tempRes.deleteReservation(); //delete
//					temp5 = new Reservation (customerID, -1, tempRes.getCarID(), currentTime, tempRes.reservationInformation().get(1)); //try again
//					tempRes = temp5;
//				}
//				else if (temp5.getReservationID() == -1){
//					return false; //no spots
//				}
//				else { //extend reservation
//					tempRes.changeReservation(currentTime, tempRes.reservationInformation().get(1));
//				}
//			}
//		}
//
//		// take the first reservation time and make it the current reservation for the customer
//		currentReservation = upcomingReservations.get(0);
//		upcomingReservations.remove(0);
//		Customer.Customer_to_Database(this);
//
//		// update the actual check in time for the reservation ticket
//		tempRes.setActualTimeIn(currentTime); 
//		Reservation.Reservation_to_Database(tempRes);
//
//		// update the Lot Monitor that the car is in its spot
//		LotMonitor.reservationCheckIn(currentReservation,tempRes.getParkingSpot());
//
//		return true;
//	}
	
}

//written by: Brian Goodacre
//assisted by:
//debugged by: Brian Goodacre

package dataStructures;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import database.*;
import databases.*;

public class Car  extends Database{
	private int carID;
	private String licensePlate;
	private ArrayList<Integer> customerIDs;
	
	/*Constructors*/
	//know everything so creating a car is easy
	public Car (int cID, String lPlate, ArrayList<Integer> cusID){
		carID=cID;
		licensePlate=lPlate;
		customerIDs=cusID;
	}
	/*	Purpose:	Create a new Car and update the database
	 * 	Input:		License Plate
	 * 				# of customer ID if they have it, -1 otherwise 	
	 * 	Output:		New Car Object
	 * 				carID=-1 if CustomerID is full
	 * */
	public Car (String lPlate, int customerID) throws SQLException, ClassNotFoundException{
		//check if we can add a car to the customer
		boolean canAddCar = true;
		Customer tempCust;
		if (customerID!=-1){
			tempCust = Database_Constructors.ID_to_Customer(customerID);
			if(tempCust.getCarIDs().size()>=maxCarsPerCustomer){
				canAddCar=false;
				carID = -1;
			}
		}
		//Move on if we can add a car to this customer
		if (canAddCar){
			customerIDs = new ArrayList<Integer>(5);
			licensePlate = lPlate;

			//create new carID
			stmt.executeUpdate(
					" INSERT INTO Cars " +
					" (licensePlate) " + 
					" VALUES ('" + lPlate + "');");
			//get carID
			rs=stmt.executeQuery("SELECT MAX(carID) FROM Cars");
			rs.next();
			carID=rs.getInt(1);
			
			Customer tempC;
			//create customer or use existing customer
			if(customerID==-1){
				tempC = new Customer("Temporary",1,-1,-1); //create temporary customer
			}
			else{
				tempC = Database_Constructors.ID_to_Customer(customerID);
			}
			tempC.getCarIDs().add(carID); //add car to customer
			customerIDs.add(tempC.getCustomerID()); //add customer to car

			//update Car Database
			Database_Constructors.Car_to_Database(this);
			//Update Customer Database
			Database_Constructors.Customer_to_Database(tempC);
		}
	}
	
	/*Functions that affect the Database*/
	/*	Purpose:	Remove a Customer from a Car
	 * 	Input:		A customerID
	 * 	Output:		true if successful
	 * 	How:		If it is the last customer or there are no customers, 
	 * 					then the car is deleted*/
	public boolean removeCustomer(int custID) throws ClassNotFoundException, SQLException{
		//remove customer
		customerIDs.remove(customerIDs.indexOf(custID));
		
		//delete entire car
		if (customerIDs.size()==0){
			stmt.executeUpdate("" +
					" DELETE FROM cars " +
					" WHERE carID="+carID);
		}
		//remove the customer from the car
		else{
			//update Car Database
			Database_Constructors.Car_to_Database(this);
		}
		
		//update Customer Object
		Customer tempCust = Database_Constructors.ID_to_Customer(custID);
		tempCust.getCarIDs().remove(
				tempCust.getCarIDs().indexOf(this.carID));
		
		//update Customer Database
		Database_Constructors.Customer_to_Database(tempCust);
		
		return true;
	}
	/* 	Purpose:	add a customer to a car
	 * 	Input:		Customer ID
	 * 	Output:		true if it can be added, false if it cannot be added
	 * */
	public boolean addCustomer(int custID) throws ClassNotFoundException, SQLException{
		Customer tempCust;
		if(customerIDs.size()>=maxCustomersPerCar){
			return false; //cannot add - too many Customers for this Car
		}
		else{
			tempCust = Database_Constructors.ID_to_Customer(custID);
			if(tempCust.getCarIDs().size()<maxCarsPerCustomer){//can add to both car and customer
				customerIDs.add(custID); //add to car object
				tempCust.addCar(this.getCarID()); //add to customer object
			}
			else{
				return false; //cannot add - too many Cars for this Customer
			}
		}
		
		//update - Car Object = ABOVE
		//update - Customer Object = ABOVE
		//update Car database
		Database_Constructors.Car_to_Database(this);
		//update Customer database
		Database_Constructors.Customer_to_Database(tempCust);
		
		return true; //Able to add
	}
	
	//	Purpose:	Given a license Plate, prepare the car for leaving
	//	Input:		License Plate
	//	Output:		Reservation Object
	public static Reservation checkOut(String plate1, Calendar time) throws ClassNotFoundException, SQLException{
		//determine which customer/reservation this is
		Car current = Car.plate_to_Car(plate1);
		Customer tempCust = Customer.ID_to_Customer(current.getCustomerIDsIntegers().get(0));
		Reservation tempRes = tempCust.getCurrentReservation();
			//look at all the current reservations of the car
			for (int i =0; i<current.getCustomerIDs().size(); i++){
				tempCust = Customer.ID_to_Customer(current.getCustomerIDs().get(i).getCustomerID());
				tempRes = tempCust.getCurrentReservation();
				//determine which one has a carID == this car ID
				if(tempRes != null && tempRes.getCarID() == current.getCarID())
					System.out.println("bg");
					break;
			}
		// sort the reservations of the currentUser
			Collections.sort(tempCust.getUpcomingReservations()); //closest to oldest
			Collections.sort(tempCust.getPastReservations()); //oldest to newest
		//update customer object
			//update current reservation
			int tempCustReservation = tempCust.getCurrentReservationID();
			tempCust.setCurrentReservationID(-1);
			//update past reservations (max)
			if (tempCust.getPastReservationsID().size()==3)
				tempCust.getPastReservationsID().remove(0);
			tempCust.getPastReservationsID().add(tempCustReservation);
		//update reservation object
			//update actual Time Out
			tempRes.setActualTimeOut(time);
		//update parking spaces database
			int tempParkingSpot = tempRes.getParkingSpot();
			//free early spots if they are leaving early
			if (tempRes.reservationInformation().get(1).compareTo(time)>0) //earlier
				LotMonitor.unReserveParkingSpace(tempParkingSpot, time, tempRes.reservationInformation().get(1));
			//remove current occupant
			LotMonitor.reservationCheckOut(tempRes.getParkingSpot());
		//update reservation database
			Reservation.Reservation_to_Database(tempRes);
		//update customer database
			Customer.Customer_to_Database(tempCust);
		return tempRes;
	}
	
	/*Functions that access the Database but do not use affect it*/
	//	Purpose:	Given a String plate, return the car associated with it.
	public static Car plate_to_Car (String plate) throws ClassNotFoundException, SQLException{
		int id;
		
		//query
		rs=stmt.executeQuery("" +
				"SELECT carID " +
				"FROM cars " +
				"WHERE licensePlate " +
				"LIKE "+ "\""+plate+"\"");
		
		//put for output
		if(rs.next()){
			id=rs.getInt(1);
		}
		else{
			return null;
		}		
		
		//return car
		Car temp = Car.ID_to_Car(id);
		return temp ;
	}
	//	Purpose:	Given a ID for a Car, return the Car
	public static Car ID_to_Car (int id) throws ClassNotFoundException, SQLException{
		return Database_Constructors.ID_to_Car(id);
	}
//	Purpose:	Update Database, given a Car Object
	public static void Car_to_Database(Car c) throws ClassNotFoundException, SQLException{
		Database_Constructors.Car_to_Database(c);
	}
	
	/*	Functions that return information	*/
	public int getCarID(){
		return carID;
	}
	public String getLicensePlate(){
		return licensePlate;
	}
	public ArrayList<Integer> getCustomerIDsIntegers(){
		return customerIDs;
	}
	public ArrayList<Customer> getCustomerIDs() throws ClassNotFoundException, SQLException{
		ArrayList<Customer> temp = new ArrayList <Customer>();
		for (int i =0; i<customerIDs.size(); i++){
			temp.add(Database_Constructors.ID_to_Customer(customerIDs.get(i)));
		}
		return temp;
	}
	
	public void setLicensePlate(String s){
		licensePlate = s;
	}
	public void setCustomerIDsIntegers(ArrayList<Integer> cid){
		customerIDs = cid;
	}
}

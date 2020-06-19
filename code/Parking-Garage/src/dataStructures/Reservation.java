/*Brian Goodacre*/

package dataStructures;

import java.sql.*;
import java.util.Calendar;
import java.util.ArrayList;
import database.*;
import databases.*;


public class Reservation extends Database{
	/**Fields**/
	private int reservationID;
	private int reservationType; //0 for walk-in, 1 for reserved, 2 for long-term
	private int customerID;
	private int carID;
	private int parkingSpot;
	private Calendar reservationTimeIn;
	private Calendar reservationTimeOut;
	private Calendar actualTimeIn;
	private Calendar actualTimeOut;
	
	
	/**Constructors**/
	//everything known, create this object.
	public Reservation(
			int revID, int resType, int custID, int crID, int pSpot, 
			Calendar in, Calendar out, Calendar aIn, Calendar aOut){
		reservationID = revID;
		reservationType = resType; 
		customerID = custID;
		carID = crID;
		parkingSpot=pSpot;
		reservationTimeIn = in;
		reservationTimeOut = out;
		actualTimeIn = aIn;
		actualTimeOut = aOut;
	}
	/*	Purpose:	Make a reservation
	 * 	Input:		Customer ID
	 * 				int Reservation type
	 * 				Calendar timeIn
	 * 				Calendar timeOut
	 * 	Output:		Reservation Object if successful
	 * 				no parking spots: -1 for reservationID
	 * 				too many reservation: -2 for reservationID*/
	public Reservation(int custID, int type, int car_ID, Calendar in, Calendar out) throws ClassNotFoundException, SQLException{
		parkingSpot = LotMonitor.availableParkingSpot(in, out);
		//No parking spot
		if (parkingSpot == -1){
			reservationID=-1;
		}
		//Too many reservations
		else if (Database_Constructors.ID_to_Customer(custID).
				getUpcomingReservationsID().size()==maxReservationsPerCustomer){
			reservationID=-2;
		}
		else{//There is a parking spot and can make the reservation
			stmt.executeUpdate("" +
					" INSERT INTO Reservations " +
					" (reservation_type, customerID, carID, arrivalTime, departureTime, parkingSpaceID)" +
					" VALUES " +
					" ("+type+", " + custID+", "+car_ID+", '"+Database_Helpers.Calendar_to_SQLTime(in) +"', '" + Database_Helpers.Calendar_to_SQLTime(out) + "', " + parkingSpot+ ");");
			rs=stmt.executeQuery("SELECT MAX(reservationID) FROM Reservations");
			rs.next();
			
			/*update Reservation object*/
			reservationID=rs.getInt(1);
			customerID = custID;
			carID = car_ID; //if known
			//parkingSpot is known
			reservationTimeIn = in;
			reservationTimeOut = out;
			//actualTimeIn is updated later
			//actualTimeOut is updated later
			
			/*Update Customer Database*/
			Customer tempCust = Database_Constructors.ID_to_Customer(custID);
			tempCust.getUpcomingReservationsID().add(reservationID);
			Database_Constructors.Customer_to_Database(tempCust);
			
			/*Update Parking Space Database*/
			LotMonitor.reserveParkingSpace(parkingSpot, reservationID, reservationTimeIn, reservationTimeOut);
		}
	}
	
	
	/**Functions that edit the Database**/
	//	Purpose:	When a car has confirmed their reservation information, they call this function
	public void confirmArrival(Calendar  in) throws SQLException, ClassNotFoundException{
		//update reservation object - add actual Arrival Time
		actualTimeIn=in;
		
		//update reservation database
		Reservation.Reservation_to_Database(this);
		
		//update customer database - current reservation
		Customer tempCust = Customer.ID_to_Customer(customerID);
		tempCust.setCurrentReservationID(reservationID);
		tempCust.getUpcomingReservationsID().remove(tempCust.getUpcomingReservationsID().indexOf(reservationID));
		Customer.Customer_to_Database(tempCust);
		
		//update parkingspaces - current reservation ID
		LotMonitor.reservationCheckIn (reservationID, parkingSpot);
	}
	
	/*purpose: 	update reservation
	 * output:	new reservationID
	 * 				Can find new spot: 		positive*reservationID
	 * 				Cannot Find new spot	negative*reservationID*/
	public int changeReservation(Calendar newIn, Calendar newOut) throws SQLException, ClassNotFoundException{
		// save the parking spot, arrival Time, departure Time
		int cur_reservationType=reservationType;
		int cur_customerID = customerID;
		int cur_carID = carID;
		Calendar cur_reservationTimeIn = reservationTimeIn;
		Calendar cur_reservationTimeOut = reservationTimeOut;
		
		// delete the current reservation
		this.deleteReservation();
		
		// check for a new reservation for the new given times
		Reservation tempRes = new Reservation(cur_customerID, cur_reservationType, cur_carID, newIn, newOut);
		if(tempRes.getReservationID()==-1){	// if there are no parking spaces available, recreate the current one
			tempRes = new Reservation(cur_customerID, cur_reservationType, cur_carID, cur_reservationTimeIn, cur_reservationTimeOut);
			return tempRes.getReservationID();
		}
		else{
			return tempRes.getReservationID();
		}
	}
	/*	Purpose:	Delete a reservation
	 * 	Input:		None - call via the Reservation Object
	 * 	Output:		boolean true*/
	public boolean deleteReservation() throws ClassNotFoundException, SQLException{
		/*Update Parking Space Database*/
		LotMonitor.unReserveParkingSpace(parkingSpot, reservationTimeIn, reservationTimeOut);
		
		/*Update Customer Database*/
		Customer tempCust = Customer.ID_to_Customer(customerID); //create
		tempCust.getUpcomingReservationsID().remove(
				tempCust.getUpcomingReservationsID().indexOf(reservationID)); //remove Reservation
		Customer.Customer_to_Database(tempCust); //update Database
		
		/*Delete from Reservation Database*/
		stmt.executeUpdate("" +
				" DELETE FROM reservations " +
				" WHERE reservationID = " + reservationID);
		
		/*delete fields of this object*/
		reservationID=-1;
		
		return true;
	}
	
	
	/**Functions that access the Database but do not affect it**/
	/*	Purpose:	Given a time, return all reservations starting at that time*/
	public static ArrayList<Reservation> getAllStartReservations (Calendar c) throws SQLException, ClassNotFoundException{
		//return object
		ArrayList<Reservation> alr= new ArrayList<Reservation>(); 
		ArrayList<Integer> temp1 = new ArrayList<Integer>();
		String temp = Database_Helpers.Calendar_to_SQLTime(c);
		
		//query database
		ResultSet rs2 = stmt.executeQuery("" +
				" SELECT reservationID " +
				" FROM reservations " +
				" WHERE arrivalTime ='" +temp+"'");
		
		//get reservation IDs
		while (rs2.next()){
			temp1.add(rs2.getInt(1));
		}
		//convert
		for (int i=0; i<temp1.size(); i++){
			alr.add(Database_Constructors.ID_to_Reservation(temp1.get(i)));
		}
		rs2.close();
		
		return alr;
	}
	/*	Purpose:	Given a time, return all end reservations at that time*/
	public static ArrayList<Reservation> getAllEndReservations (Calendar c) throws SQLException, ClassNotFoundException{
		//return object
		ArrayList<Reservation> alr= new ArrayList<Reservation>(); 
		ArrayList<Integer> temp1 = new ArrayList<Integer>();
		String temp = Database_Helpers.Calendar_to_SQLTime(c);
		
		//query database
		ResultSet rs2 = stmt.executeQuery("" +
				" SELECT reservationID " +
				" FROM reservations " +
				" WHERE departureTime ='" +temp+"'");
		
		//get reservation IDs
		while (rs2.next()){
			temp1.add(rs2.getInt(1));
		}
		//convert
		for (int i=0; i<temp1.size(); i++){
			alr.add(Database_Constructors.ID_to_Reservation(temp1.get(i)));
		}
		rs2.close();
		
		return alr;
	}
	/*	Purpose:	Given a time, return all reservations of that are during that time*/
	public static ArrayList<Integer> getAllCurrentReservationsID (Calendar c) throws SQLException, ClassNotFoundException{
		//return object
		ArrayList<Integer> temp1 = new ArrayList<Integer>();
		String column = "currentReservationID";
		
		//query database
		ResultSet rs2 = stmt.executeQuery("" +
				" SELECT " + column + 
				" FROM parkingspaces " +
				" WHERE " + column + " IS NOT NULL");
		
		//get reservationIDs
		while (rs2.next()){
			temp1.add(rs2.getInt(1));
		}
		rs2.close();
		
		return temp1;
	}
	//See above getAllCurrentReservationsID 
	public static ArrayList<Reservation> getAllCurrentReservations (Calendar c) throws SQLException, ClassNotFoundException{
		ArrayList<Integer> temp1 = getAllCurrentReservationsID (c);
		ArrayList<Reservation> alr = new ArrayList<Reservation>();
		
		//convert
			for (int i=0; i<temp1.size(); i++){
				alr.add(Database_Constructors.ID_to_Reservation(temp1.get(i)));
			}
		
		return alr;
	}
	//	Purpose:	Given an ID for a Reservation, return the Reservation
	public static Reservation ID_to_Reservation (int id) throws SQLException, ClassNotFoundException{
		return Database_Constructors.ID_to_Reservation(id);
	}
	//	Purpose:	Update Database, given a Reservation Object
	public static void Reservation_to_Database(Reservation r) throws ClassNotFoundException, SQLException{
		Database_Constructors.Reservation_to_Database(r);
	}
	
	
	/**Helper Functions*/
	public int getReservationID(){
		return reservationID;
	}
	public int getCustomerID(){
		return customerID;
	}
	public int getCarID(){
		return carID;
	}
	public int getReservationType(){
		return reservationType;
	}
	public int getParkingSpot(){
		return parkingSpot;
	}
	public int getFloorNumber(){
		return parkingSpot/spotsPerFloor+1;
	}
	public void setActualTimeIn(Calendar c){
		actualTimeIn=c;
	}
	public void setActualTimeOut(Calendar c){
		actualTimeOut=c;
	}
	/*purpose: returns ArrayList of Calendar objects:
	 * 1	reservationTimeIn;
	 * 2	reservationTimeOut
	 * 3	actualTimeIn
	 * 4	actualTimeOut
	 * 	*/
	public ArrayList<Calendar> reservationInformation(){
		ArrayList<Calendar> output = new ArrayList<Calendar>();
		output.add(reservationTimeIn);
		output.add(reservationTimeOut);
		output.add(actualTimeIn);
		output.add(actualTimeOut);
		return output;
	}
}

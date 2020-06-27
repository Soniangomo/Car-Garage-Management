package dataStructures;

import java.util.ArrayList;
import java.util.Calendar;
import java.sql.*;

import database.*;
//import databases.*;
//import java.util.ArrayList;

public class LotMonitor extends Database{
	protected static int overbook = 0; //Used for overbooking
	
	/* Purpose:	Search database for an available parking space during the requested times
	 * Input:	Calendar objects: start time and end time
	 * Output:	parking spot # that is available during this time, -1 if no space
	 * How:		Given the request period, function searches parking garage for possible spots.
	 * 			Returns the first spot that is available during this given time. 
	 * Future:	
	 */
	public static int availableParkingSpot (Calendar start, Calendar end) throws ClassNotFoundException, SQLException{
		//TODO - Add buffers for parking spots
		parkingStartNumber++; //changes so that an incremently new parking Space is started with
		String databaseEntry="";
		int numTimes=0; //get track of the amount of 15 minute intervals there in the date given
		
		/*	Create currentColumn from date	*/
		String time_start=Database_Helpers.Calendar_to_DatabaseCalendar(start);
		String time_end=Database_Helpers.Calendar_to_DatabaseCalendar(end);
		String currentColumn=Database_Helpers.incrementDateColumn(time_start);
	
		databaseEntry=time_start;
		numTimes++;
		//make massive string for database
		while(!currentColumn.equals(time_end)){
			databaseEntry=databaseEntry+","+currentColumn;
			numTimes++;
			currentColumn=Database_Helpers.incrementDateColumn(currentColumn);
		}
		//add the last column
		databaseEntry=databaseEntry+","+time_end; //add last one
		numTimes++;
		
		//get only the parking spaces for a certain time
		rs = stmt.executeQuery(
				" SELECT " + databaseEntry + 
				" FROM parkingSpaces");
		
		//find an available parking space now
		int currentParkingSpot=parkingStartNumber-1;
		boolean good=true;
		while(rs.next()){
			good = true; //reset
			//increment the parking spot
			currentParkingSpot=(currentParkingSpot+1)%numParkingSpots;
			if(currentParkingSpot==0){
				currentParkingSpot++;
			}
			
			//search through the return values
			for (int j=1; j<=numTimes; j++){
				if (rs.getInt(j)!=0){
					good=false;
					break; //not an available parking space
				}
			}
			if(good){
				return currentParkingSpot; //answer! done!
			}
		}
		return -1; //none available 
	}
	
	/*	Purpose:	Check if a parking spot is unreserved during a specific time*/
	public static boolean availablityForAParkingSpot (int pSpot, Calendar time1, Calendar time2) throws ClassNotFoundException, SQLException{

		parkingStartNumber++; //changes so that an incremently new parking Space is started with
		String databaseEntry="";
		int numTimes=0; //get track of the amount of 15 minute intervals there in the date given
		
		/*	Create currentColumn from date	*/
		String time_start=Database_Helpers.Calendar_to_DatabaseCalendar(time1);
		String time_end=Database_Helpers.Calendar_to_DatabaseCalendar(time2);
		String currentColumn=time_start;
		databaseEntry=" ";
		//make massive string for database
		while(!currentColumn.equals(time_end)){
			
			if (numTimes!=0){
				databaseEntry = databaseEntry + ",";
			}
			databaseEntry=databaseEntry+currentColumn;
			numTimes++;
			currentColumn=Database_Helpers.incrementDateColumn(currentColumn);
			
		}
		//add the last column
		if(numTimes!=0){
			databaseEntry=databaseEntry+",";
		}
		databaseEntry=databaseEntry+time_end; //add last one
		numTimes++;
		
		//get only the parking spaces for a certain time
		rs = stmt.executeQuery(
				" SELECT " + databaseEntry + 
				" FROM parkingSpaces " +
				" WHERE parkingSpaceID = " + pSpot);
		//error
		if(rs.next()==false)
			return false;

		//search through the return values
		for (int j=1; j<=numTimes; j++){
			if (rs.getInt(j)!=0){
				return false;
			}
		}
		return true;
		
	}
	
	/*	Purpose:	Reserves a parking space in the database*/
	public static boolean reserveParkingSpace(int pSpot, int resID, Calendar start, Calendar finish) throws ClassNotFoundException, SQLException{
		//double check that the spot is open
		if(false == availablityForAParkingSpot(pSpot, start, finish))
			return false;
		
		//strings for columns
		String currentColumn 	=	Database_Helpers.Calendar_to_DatabaseCalendar(start);
		String finishCol 		= 	Database_Helpers.Calendar_to_DatabaseCalendar(finish);
		
		//update database
		while (!currentColumn.equals(finishCol)){
			stmt.executeUpdate("" +
					" UPDATE parkingspaces " +
					" SET "+ currentColumn + "=" + resID +
					" WHERE parkingSpaceID = " + pSpot);
			currentColumn=Database_Helpers.incrementDateColumn(currentColumn);
		}
		stmt.executeUpdate("" +
				" UPDATE parkingspaces " +
				" SET "+ currentColumn + "=" + resID +
				" WHERE parkingSpaceID = " + pSpot);
		return true;
	}
	
	/*	Purpose:	Opens up a parking space in the database*/
	public static boolean unReserveParkingSpace(int pSpot, Calendar start, Calendar finish) throws ClassNotFoundException, SQLException{
		//strings for columns
		
		String currentColumn 	=	Database_Helpers.Calendar_to_DatabaseCalendar(start);
		String finishCol 		= 	Database_Helpers.Calendar_to_DatabaseCalendar(finish);
		
		//update database
		while (!currentColumn.equals(finishCol)){
			stmt.executeUpdate("" +
					" UPDATE parkingspaces " +
					" SET "+ currentColumn + "= NULL " +
					" WHERE parkingSpaceID = " + pSpot);
			currentColumn=Database_Helpers.incrementDateColumn(currentColumn);
		}
		stmt.executeUpdate("" +
				" UPDATE parkingspaces " +
				" SET "+ currentColumn + "= NULL " +
				" WHERE parkingSpaceID = " + pSpot);
		return true;
	}
	
	//	Purpose:	Checks a reservation into the database into a spot
	public static void reservationCheckIn (int resID, int spotID) throws ClassNotFoundException, SQLException{	
		stmt.executeUpdate("" +
				" UPDATE parkingspaces " +
				" SET currentReservationID = " + resID + 
				" WHERE parkingSpaceID = " + spotID);
	}
	
	//	Purpose:	Checks a reservation out in the database from a spot
	public static void reservationCheckOut (int spotID) throws ClassNotFoundException, SQLException{	
		stmt.executeUpdate("" +
				" UPDATE parkingspaces " +
				" SET currentReservationID = NULL "  + 
				" WHERE parkingSpaceID = " + spotID);
	}
	
	/*	Purpose:	Tell caller how full the garage is at a certain time
	 * 	Input:		Time
	 * 	Output:		Percentage
	 * */
	public static float garageOccupancy (Calendar time) throws ClassNotFoundException, SQLException{
			float percentage;
			float numTaken=0;
			
			rs = stmt.executeQuery(
					" SELECT " + Database_Helpers.Calendar_to_DatabaseCalendar(time) + 
					" FROM parkingSpaces");
			while (rs.next()){
				if(rs.getInt(1)!=0){
					numTaken++;
				}
			}
			percentage = numTaken/numParkingSpots*100;
			
			return percentage;
	}
	
	/*	Purpose:	If the garage is full at a certain time, return true
	 * 	Input:		Time
	 * 	Output:		true if full, false is not full
	 * */
	public static boolean isCurrentlyFull (Calendar time) throws ClassNotFoundException, SQLException{
		if (garageOccupancy(time)==100){
			return true;
		}
		return false;
	}

	/*	Purpose:	Returns an ArrayList of all the Current Reservations
	 * 	Input:		N/A
	 * 	Output:		if ArrayList.get(i) >  0 , then parking spot 'i' is taken
	 * 				if ArrayList.get(i) == 0 , then parking spot 'i' is vacant
	*/
	
	public static ArrayList<Integer> currentStatusOfParkingSpaces() throws SQLException{
		if(numParkingSpots == 0)
			return null;
		ArrayList<Integer> returnList = new ArrayList<Integer>(numParkingSpots);
		rs=stmt.executeQuery("SELECT currentReservationID from parkingspaces"); //get from database
		while(rs.next()){ //add to arrayList
			returnList.add(rs.getInt(1));
		}
		System.out.println(returnList);
		return returnList; //return
	}
}

//written by: Brian Goodacre
//assisted by:
//debugged by: Brian Goodacre

package databases;

import java.sql.*;
import java.util.Calendar;
import database.*;

public class ParkingSpace extends Database{
	public static boolean reserveParkingSpace(int pSpot, int resID, Calendar start, Calendar finish) throws ClassNotFoundException, SQLException{
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
	//TODO
	/*	Purpose:	Optimize the database for a given day
	 * 	Input:		Time
	 * 	Output:		Number of new parking spaces*/
	public static int optimizeParking (Calendar c){
		return 0;
	}
}

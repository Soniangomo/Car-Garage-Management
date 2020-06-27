package money;

import java.sql.SQLException;
import java.util.Calendar;
import dataStructures.*;

public class Accountant {
	private static final float RATE = 4; //Dollars per hour
	private static final float OVER_RATE = (float) 4.5; //Dollars per hour
	private static final float MAX_DAY = 30;
	public static float newLineBalance = 0;
	
	//	Purpose:	Takes two calendar objects and returns the difference in time

	public static float getTimeDifference(Calendar calFirst, Calendar calSecond){
		if(calFirst.after(calSecond)){
			return 0;
		}
		float time_in_milli = calFirst.getTimeInMillis();
		float time_out_milli = calSecond.getTimeInMillis();
		float time_total_milli = time_out_milli - time_in_milli;
		float time_total_hour = time_total_milli/1000/60/60; //convert milliseconds to hour
		return time_total_hour;
	}


	public static float getOverStayTime(Reservation r){
		Calendar reservedTimeOut	=	r.reservationInformation().get(1);
		Calendar actualTimeOut		= 	r.reservationInformation().get(3);
		return getTimeDifference(reservedTimeOut,actualTimeOut);
	}

	public static float getPrice(Reservation r){
		Calendar reservedTimeIn 	=	r.reservationInformation().get(0);
		Calendar reservedTimeOut	=	r.reservationInformation().get(1);
		Calendar actualTimeIn 		= 	r.reservationInformation().get(2);
		Calendar actualTimeOut		= 	r.reservationInformation().get(3);
		
		float earlyTime = getTimeDifference(actualTimeIn,reservedTimeIn);
		float reservedTime = getTimeDifference(reservedTimeIn,reservedTimeOut);
		float extraTime	=	getTimeDifference(reservedTimeOut,actualTimeOut);
		
		float totalCost = (RATE * earlyTime) + (RATE * reservedTime) + (OVER_RATE * extraTime);
		
		if (totalCost > MAX_DAY){
			totalCost = MAX_DAY;
		}
		
		return totalCost;
	}
	
	public static float chargeCustomer(Reservation r) throws ClassNotFoundException, SQLException{
		// Calculate price
		double price = Accountant.getPrice(r);
		
		// update Customer Database
		Customer tempCust = Customer.ID_to_Customer(r.getCustomerID());
		double newBalance = tempCust.getCurrentBalance()+price;
		tempCust.updateBalance((float) newBalance);
		Customer.Customer_to_Database(tempCust);
		
		/*	update Reservation Object
			update Reservation Database
			There is nothing to do for this */
		return (float) price;
	}

	//Increases/decreases the new line balance
	public static float addToBalance(float newCharge){
		newLineBalance = newLineBalance + newCharge;
		return newLineBalance;
	}
}
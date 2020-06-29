package databases;

import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.GregorianCalendar;
import dataStructures.*;
import database.*;

public class DatabaseTestDriver extends Database{
	public static void main(String args[]) throws ClassNotFoundException, SQLException{
		//Database()
		System.out.println("-----");
		System.out.println("Database()");
		System.out.println("Success");
		@SuppressWarnings("unused")
		Database dbd = new Database();
		System.out.println("-----\n");
		
		//connectToDatabase()
		System.out.println("-----");
		System.out.println("connectToDatabase()");
		System.out.println("Success");
		Database.connectToDatabase();
		System.out.println("-----\n");		
		
/*		//Create a Customer
		System.out.println("-----");
		System.out.println("Create a Customer");
		Customer temp554 = new Customer ("Joe Grossmann");
		System.out.println("Customer ID: " + temp554.getCustomerID());
		System.out.println("Customer Name: " + temp554.getCustomerName());
		System.out.println("Current Balance: " + temp554.getCurrentBalance());
		System.out.println("-----\n");
		
		//Create a Car
		System.out.println("-----");
		System.out.println("Create a Car");
		Car temp665 = new Car("BRI615",8);
		if(temp665.getCarID()!=-1){
			System.out.println("Car ID: " + temp665.getCarID());
			System.out.println("Car ID: " + temp665.getLicensePlate());
			System.out.println("Customer Name: " + ((temp665.getCustomerIDs()).get(0)).getCustomerName());
		}
		System.out.println("-----\n");
		
		//Create a Reservation
		System.out.println("-----");
		System.out.println("Create a Resrvation");
		GregorianCalendar temp_start4 = new GregorianCalendar(2011,1,1,1,15);
		GregorianCalendar temp_end4 = new GregorianCalendar(2011,1,1,2,00);
		Reservation temp11 = new Reservation (1,1,temp_start4,temp_end4);
		System.out.println("Parking Spot: " + temp11.getParkingSpot());
		System.out.println("-----\n");
		
		//ID_To_Customer(id)
		System.out.println("-----");
		System.out.println("ID_To_Customer(1)");
		Customer temp44 = Database_Constructors.ID_to_Customer(1);
		System.out.println(temp44.getCustomerName()+" ");
		System.out.println(temp44.getCustomerID()+" ");
		System.out.println("etc");
		System.out.println("-----\n");
		
		//licensePlate_to_Customer(plate)
		System.out.println("-----");
		System.out.println("licensePlate_to_Customer(plate)");
		ArrayList<Customer>temp3 = dbd.licensePlate_to_Customer("ABC123");
		System.out.println(temp3);
		if(temp3!=null){
			for (int i =0; i<temp3.size(); i++){
				if(temp3.get(i)!=null){
					System.out.print((temp3.get(i)).getCustomerName()+" ");
					System.out.print((temp3.get(i)).getCustomerID()+" etc\n");
				}
			}
		}
		System.out.println("-----\n");
		
		//ID_to_Reservation(id)
		System.out.println("-----");
		System.out.println("ID_to_Reservation(id)");
		Reservation temp55 = Database_Constructors.ID_to_Reservation(1);
		System.out.println(temp55.getCarID());
		System.out.println(temp55.getCustomerID());
		System.out.println(((temp55.reservationInformation()).get(1)).getTime());
		System.out.println("-----\n");
		
		//ID_to_Car(id)
		System.out.println("-----");
		System.out.println("ID_to_Car(id)");
		Car temp66 = Database_Constructors.ID_to_Car(1);
		System.out.println(temp66.getCarID());
		System.out.println(temp66.getLicensePlate());
		System.out.println(temp66.getCustomerIDs());
		System.out.println("-----\n");
		
		//licensePlate_to_Car(String plate)
		System.out.println("-----");
		System.out.println("licensePlate_to_Car");
		Car temp32=Database.licensePlate_to_Car("ABC123");
		if (temp32!=null){
			System.out.println(temp32.getCarID());
			System.out.println(temp32.getLicensePlate());
			System.out.println(temp32.getCustomerIDs());
		}
		else{
			System.out.println(temp32);
		}
		System.out.println("-----\n");
		
		//Calendar_to_DatabaseCalendar
		System.out.println("-----");
		System.out.println("Calendar_to_DatabaseCalendar");
		Calendar rightNow = Calendar.getInstance();
		System.out.println(Database_Helpers.Calendar_to_DatabaseCalendar(rightNow));
		System.out.println("-----\n");
		
		//availableParkingSpot
		System.out.println("-----");
		System.out.println("availableParkingSpot");
		GregorianCalendar temp_start = new GregorianCalendar(2011,1,1,1,15);
		GregorianCalendar temp_end = new GregorianCalendar(2011,1,1,2,00);
		System.out.println(Database_Helpers.Calendar_to_DatabaseCalendar(temp_start));
		System.out.println(Database_Helpers.Calendar_to_DatabaseCalendar(temp_end));
		int tempAPS = Database.availableParkingSpot(temp_start,temp_end);
		System.out.println(tempAPS);
		System.out.println("-----\n");
		
		//garageOccupancy
		System.out.println("-----");
		System.out.println("garageOccupancy");
		GregorianCalendar temp_start2 = new GregorianCalendar(2011,1,1,1,15);
		GregorianCalendar temp_end2 = new GregorianCalendar(2011,1,1,2,00);
		System.out.println(Database.garageOccupancy(temp_start2));
		System.out.println(Database.garageOccupancy(temp_end2));
		System.out.println("-----\n");
		
		//updateBalance(float newBalance)
		System.out.println("-----");
		System.out.println("updateBalance(float newBalance)");
		Customer temp765 = Database_Constructors.ID_to_Customer(1);
		temp765.updateBalance(50);
		System.out.println("-----\n");
		
		
		
		//Database_Helpers.numReservations(Database_Constructors.ID_to_Customer(custID))
		System.out.println("-----");
		System.out.println("numReservations");
		System.out.println("numReservations = "+ Database_Helpers.numReservations(Database_Constructors.ID_to_Customer(1)));
		System.out.println("-----\n");
		
		//reserveParkingSpace
		System.out.println("-----");
		System.out.println("reserveParkingSpace");
		GregorianCalendar temp_start3 = new GregorianCalendar(2011,1,1,1,15);
		GregorianCalendar temp_end3 = new GregorianCalendar(2011,1,1,2,00);
		System.out.println(ParkingSpace.reserveParkingSpace(5, 3, temp_start3, temp_end3));
		System.out.println("-----\n");
			
		//Get all Reservations that start at a given time
		System.out.println("-----");
		System.out.println("Get All Starting Reservations");
		GregorianCalendar temp_start5 = new GregorianCalendar(2011,1,1,1,15);
		ArrayList<Reservation> temp49 = Reservation.getAllStartReservations(temp_start5);
		for (int i=0; i<temp49.size(); i++){
			System.out.print(temp49.get(i).getReservationID() + " ");
		}
		System.out.println("\n-----\n");
		
		//getAllReservations - Get all Reservations at a given time
		System.out.println("-----");
		System.out.println("Get All Reservations");
		GregorianCalendar temp_start6 = new GregorianCalendar(2011,1,1,1,30);
		ArrayList<Reservation> temp50 = Reservation.getAllReservations(temp_start6);
		for (int i=0; i<temp50.size(); i++){
			System.out.print(temp50.get(i).getReservationID() + " ");
		}
		System.out.println("\n-----\n");
		
		System.out.println("Test Adding/Removing Car");
		//Car y = new Car("HHH123", 5);
		//Customer z = Database_Constructors.ID_to_Customer(1);
		//z.addCar(y.getCarID());
		//Customer zz = Database_Constructors.ID_to_Customer(3);
		//zz.removeCar(84);
		//Database_Constructors.ID_to_Customer(8).removeCar(91);
*/		
		//update car object to database
		Car car1=new Car("ARCLAB",15);
		car1.addCustomer(3);
		//Database_Constructors.Car_to_Database(car1);
		
		//close database
		System.out.println("closeDatabase()");
		System.out.println("-----");
		System.out.println("Database()");
		System.out.println("Success");
		Database.closeDatabase();
		System.out.println("-----\n");
		System.out.println("end");
		}
}

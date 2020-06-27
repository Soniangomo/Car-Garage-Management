package databases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import dataStructures.*;
import database.*;

public class DatabaseTestDriver2 extends Database{
	public static void main(String args[]) throws ClassNotFoundException, SQLException{
		System.out.println("...Start...");
		System.out.println("Database Test Driver");
		
		Database.connectToDatabase();

		Customer bg = new Customer("Brian Goodacre", 2, -1, -1);
		System.out.println("Create a customer");
		
		Customer rr = new Customer("Richard Romanowski", 3, -1, -1);
		System.out.println("Create a customer");
		
		Customer jj = new Customer("James Jacob", 3, -1, -1);
		System.out.println("Create a customer");
		
		bg.updateBalance(50);
		System.out.println("Update Brian's balance");
		
		Car car1 = new Car("ABC54E", bg.getCustomerID());
		System.out.println("Create a car for Brian");
		
		Car car2 = new Car("YER666", bg.getCustomerID());
		System.out.println("Create a car for Brian");
		
		Car car4 = new Car("FUCK1", rr.getCustomerID());
		System.out.println("Create a car for Rich");
		
		Car car5 = new Car("8===>", jj.getCustomerID());
		System.out.println("Create a car for James");
		
		car1.addCustomer(rr.getCustomerID());
		System.out.println("Add car to Richard");
		
		car2.addCustomer(rr.getCustomerID());
		System.out.println("Add car to Richard");
		
		car4.addCustomer(jj.getCustomerID());
		System.out.println("Add car to James");
		
		car1.removeCustomer(bg.getCustomerID());
		System.out.println("Remove car from Brian");
		
		car1.addCustomer(bg.getCustomerID());
		System.out.println("Add car to Brian");
		
		car1.addCustomer(jj.getCustomerID());
		System.out.println("Add car to James");
		
		car2.addCustomer(jj.getCustomerID());
		System.out.println("Add car to James");
		
		Customer aa = new Customer("Adam Asshole", 4, -1, -1);
		System.out.println("Create a customer");
		
		System.out.println("Testing - Car.plate_to_Car(String Plate)");
		Car tempCar1 = Car.plate_to_Car(car1.getLicensePlate());
		int tempCarID1 = tempCar1.getCarID();
		System.out.println("\tCar ID: " + tempCarID1 + "\n\tCustomers: " + tempCar1.getCustomerIDsIntegers());
		
		System.out.println("Testing - Customer.plate_to_Customers(String Plate)");
		ArrayList<Customer> tempALCustomer1 = Customer.plate_to_Customers(car2.getLicensePlate());
		for (int i = 0; i<tempALCustomer1.size(); i++)
			System.out.println("\tCustomer "+(i+1)+" = " + tempALCustomer1.get(i).getCustomerName());
		
		//MAKING RESERVATIONS NOW
		GregorianCalendar timein1 = new GregorianCalendar();
		GregorianCalendar timeout1 = new GregorianCalendar();
		
		timein1.set(2011,1,1,1,30);
		timeout1.set(2011,1,1,2,45);
		Reservation r1 = new Reservation (1,2,6,timein1,timeout1);
		System.out.println("Making a reservation for Brian");
		
		timein1.set(2011,1,1,0,15);
		timeout1.set(2011,1,1,1,45);
		Reservation r2 = new Reservation (2,2,4,timein1,timeout1);
		System.out.println("Making a reservation for Rich");
		
		timein1.set(2011,1,1,3,15);
		timeout1.set(2011,1,1,3,45);
		Reservation r3 = new Reservation (1,2,4,timein1,timeout1);
		System.out.println("Making a reservation for Brian");
		
		timein1.set(2011,1,1,2,00);
		timeout1.set(2011,1,1,3,30);
		Reservation r4 = new Reservation (3,2,4,timein1,timeout1);
		System.out.println("Making a reservation for James");
		
		timein1.set(2011,1,1,2,45);
		timeout1.set(2011,1,1,3,45);
		Reservation r5 = new Reservation (2,2,4,timein1,timeout1);
		System.out.println("Making a reservation for Rich");

		r1.deleteReservation();
		System.out.println("Deleting reservation for Brian");
		
		r2.deleteReservation();
		System.out.println("Deleting reservation for Rich");
		
		bg = Customer.ID_to_Customer(1);
		System.out.println("Reloading Brian");
		rr = Customer.ID_to_Customer(2);
		System.out.println("Reloading Rich");
		jj = Customer.ID_to_Customer(3);
		System.out.println("Reloading James");

		timein1.set(2011,1,1,3,15);
		bg.checkIn(timein1);
		System.out.println("Checking in for Brian");
		
		//System.out.println("Checking out");
		
		System.out.println("...End...");
	}
}
	
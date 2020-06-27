package databases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import dataStructures.*;
import database.*;
import java.io.*;

public class DatabaseTestDriver2 extends Database{
	public static void main(String args[]) throws ClassNotFoundException, SQLException, IOException{
		Database.connectToDatabase();
		System.out.println("...Start...");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "a";
		String input2 = "a";
		String input3 = "a";
		Customer cusTemp;
		Car carTemp;
		Reservation resTemp;
		GregorianCalendar cal1 = new GregorianCalendar();
		GregorianCalendar cal2 = new GregorianCalendar();
		
		
		while (!input.equals("exit")){
		//  prompt the user to enter their name
				System.out.println("\n\n\n\n\n\n\n\n\n\n");
				System.out.println("-------------------------------------");
				System.out.println("a - Create Customer");
				System.out.println("aa- Add Car to Customer");
				System.out.println("b - Create Car");
				System.out.println("c - Add Customer to Car");
				System.out.println("d - Remove Customer from Car");
				System.out.println("e - Make Reservation");
				System.out.println("f - Extend Reservation");
				System.out.println("g - Delete Reservation");
				System.out.println("h - Users with License Plate");
				System.out.println("i - Confirm Arrival");
				System.out.println("j - Confirm Exit and Leave");
				System.out.println("k - Get all end reservations");
				System.out.println("l - Current Garage Status");
				System.out.println("m - Change Reservation");
				System.out.println("n - Garage Occupancy");
				System.out.println("exit");
				System.out.print("\nChoice: ");		      
		         input = br.readLine();
		      
		      if(input.equals("a")){
				System.out.println("a - Create Customer");
				System.out.println("Name...");
				input = br.readLine();
				cusTemp = new Customer(input,-1,-1,-1);
				System.out.println("Created Customer");
		      }
		      else if(input.equals("aa")){
		    	  System.out.println("aa- Add Car to Customer");
		    	  System.out.println("Customer ID...");
				  input = br.readLine();
				  System.out.println("Car ID...");
				  input2 = br.readLine();
				  Customer aa = Customer.ID_to_Customer(Integer.parseInt(input));
				  if(aa.addCar(Integer.parseInt(input2)))				  
					  System.out.println("Added Car to Customer");
				  else
					  System.out.println("Failed - Added Car to Customer");
		      }
		      else if(input.equals("b")){
		    	  System.out.println("b - Create Car");
					System.out.println("Plate...");
					input = br.readLine();
					System.out.println("Customer ID...");
					input2 = br.readLine();
					carTemp = new Car(input,Integer.parseInt(input2));
					System.out.println("Created Car");
			      }
		      else if(input.equals("c")){
					System.out.println("c - Add Customer to Car");
					System.out.println("Car ID...");
					input2 = br.readLine();
					System.out.println("Customer ID...");
					input = br.readLine();
					carTemp = Car.ID_to_Car(Integer.parseInt(input2));
					cusTemp = Customer.ID_to_Customer(Integer.parseInt(input)); 
					carTemp.addCustomer(cusTemp.getCustomerID());
					System.out.println("Added car to " + cusTemp.getCustomerName());
		      }
		      else if(input.equals("d")){
		    	  System.out.println("d - Remove Customer from Car");
		    	  System.out.println("Car ID...");
					input2 = br.readLine();
		    	  System.out.println("Customer ID...");
					input = br.readLine();
					carTemp = Car.ID_to_Car(Integer.parseInt(input2));
					cusTemp = Customer.ID_to_Customer(Integer.parseInt(input)); 
					carTemp.removeCustomer(cusTemp.getCustomerID());
					System.out.println("Removed car to " + cusTemp.getCustomerName());
		      }
		      else if(input.equals("e")){
					System.out.println("e - Make Reservation");
					System.out.println("Reservation Made");
					System.out.println("Hour In...");
					input = br.readLine();
					System.out.println("Minute In...");
					input2 = br.readLine();
					cal1.set(2011,1,1,Integer.parseInt(input),Integer.parseInt(input2));
					System.out.println("Hour Out...");
					input = br.readLine();
					System.out.println("Minute Out...");
					input2 = br.readLine();
					cal2.set(2011,1,1,Integer.parseInt(input),Integer.parseInt(input2));
					System.out.println("Customer ID...");
					input = br.readLine();
					System.out.println("Car ID...");
					input2 = br.readLine();
					resTemp = new Reservation (Integer.parseInt(input),-1,Integer.parseInt(input2),cal1,cal2);
					System.out.println("Reservation made.");
		      }
		      else if(input.equals("f")){
		    	  	System.out.println("f - Extend Reservation");
		    	  	System.out.println("Reservation ID...");
					input = br.readLine();
					resTemp = Reservation.ID_to_Reservation(Integer.parseInt(input));
					System.out.println("Current Time: " + resTemp.getReservedTimeOut().get(Calendar.HOUR)+resTemp.getReservedTimeOut().get(Calendar.MINUTE));
		    	  	System.out.println("Extend Hour To...");
					input = br.readLine();
					System.out.println("Extend Minute To...");
					input2 = br.readLine();
		  			cal1.set(2011, 1, 1, Integer.parseInt(input),Integer.parseInt(input2));
		  			resTemp.extendReservation(cal1);
		  			System.out.println("Extending Reservation for " + resTemp.getCustomer().getCustomerName());
		      }
		      else if(input.equals("g")){
					System.out.println("g - Delete Reservation");
					System.out.println("Reservation ID...");
					input = br.readLine();
					Reservation.ID_to_Reservation(Integer.parseInt(input)).deleteReservation();
					System.out.println("Reservation deleted");
		      }
		      else if(input.equals("h")){
		    	  	System.out.println("h - Users with License Plate");
		    	  	System.out.println("Plate...");
		    	  	input = br.readLine();
		  			carTemp = Car.plate_to_Car(input);
		  			int tempCarID = carTemp.getCarID();
		  			System.out.println("\tCar ID: " + tempCarID + "\n\tCustomers: ");
		  			for (int i =0;i < carTemp.getCustomerIDs().size(); i++){
		  				System.out.print(carTemp.getCustomerIDs().get(i).getCustomerName() + ", ");
		  			}
		  			System.out.println();
		      }
		      else if(input.equals("i")){
					System.out.println("i - Confirm Arrival");
					System.out.println("Reservation ID...");
		    	  	input = br.readLine();
		    	  	resTemp = Reservation.ID_to_Reservation(Integer.parseInt(input));
		    	  	System.out.println("Arrival Hour In...");
		    	  	input = br.readLine();
		    	  	System.out.println("Arrival Minute In...");
		    	  	input2 = br.readLine();
		    	  	cal1.set(2011,1,1,Integer.parseInt(input),Integer.parseInt(input2));
		    	  	resTemp.confirmArrival(cal1);
		    	  	System.out.println("Confirmed Arrival");
		      }
		      else if(input.equals("j")){
		    	  System.out.println("j - Confirm Exit and Leave");
		    	  System.out.println("License Plate...");
		    	  input3 = br.readLine();
		    	  System.out.println("Exit Hour Out...");
		    	  input = br.readLine();
		    	  System.out.println("Exit Minute Out...");
		    	  input2 = br.readLine();
		    	  cal1.set(2011,1,1,Integer.parseInt(input),Integer.parseInt(input2));
		    	  resTemp = Car.checkOut(input3, cal1);
		    	  System.out.println("Exit confirmed");
		    	  resTemp.confirmExit();
		    	  System.out.println("Paid and Left");
		      }
		      else if(input.equals("k")){
		    	  System.out.println("k - Get all end reservations");
		    	  ArrayList<Reservation> ggg= new ArrayList<Reservation>();
		    	  System.out.println("Hour...");
		    	  input = br.readLine();
		    	  System.out.println("Minute..");
		    	  input2 = br.readLine();
		    	  cal1.set(2011,1,1,Integer.parseInt(input),Integer.parseInt(input2));
		    	  ggg = Reservation.getAllEndReservations(cal1);
		    	  for (int i =0; i < ggg.size(); i++){
		    		  System.out.println("Reservation ID: " + ggg.get(i).getReservationID());
		    	  }
		      }
		      else if(input.equals("l")){
		    	  System.out.println("l - Current Garage Status");
		    	  ArrayList<Integer> aa = LotMonitor.currentStatusOfParkingSpaces();
		    	  Customer a;
		    	  for (int i = 0; i< aa.size(); i++){
		    		  if (aa.get(i)!=0){
		    			  a=Customer.ID_to_Customer(Reservation.ID_to_Reservation(aa.get(i)).getCustomerID());
		    			  System.out.println("ResID = " + aa.get(i) + "\tSpot: " + Reservation.ID_to_Reservation(aa.get(i)).getParkingSpot() + "\t Name: " + a.getCustomerName());
		    		  }
		    	  }
		      }
		      else if(input.equals("m")){
		    	  System.out.println("m - Change Reservation");
		    	  System.out.println("Reservation ID...");
		    	  input = br.readLine();
		    	  resTemp = Reservation.ID_to_Reservation(Integer.parseInt(input));
		    	  System.out.println("Hour In...");
		    	  input = br.readLine();
		    	  System.out.println("Minute In...");
		    	  input2 = br.readLine();
		    	  cal1.set(2011,1,1,Integer.parseInt(input),Integer.parseInt(input2));
		    	  System.out.println("Hour Out...");
		    	  input = br.readLine();
		    	  System.out.println("Minute Out...");
		    	  input2 = br.readLine();
		    	  cal2.set(2011,1,1,Integer.parseInt(input),Integer.parseInt(input2));
		    	  int bbb = resTemp.changeReservation(cal1,cal2);
		    	  	if(bbb<-1)
		    		  System.out.println("Unsuccessful - Changed Reservation");
		    	  	else
		    	  		System.out.println("Successful - " + bbb);
		    	  	System.out.println("Reservation (not) changed");
		      }
		      else if(input.equals("n")){
		    	  System.out.println("n - garageOccupancy");
		    	  System.out.println("Hour...");
		    	  input = br.readLine();
		    	  System.out.println("Minute...");
		    	  input2 = br.readLine();
		    	  cal1.set(2011,1,1,Integer.parseInt(input),Integer.parseInt(input2));
		    	  System.out.println("Occupancy: " + LotMonitor.garageOccupancy(cal1));
		      }
		      
				

			
		}
		/*
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
		
		Customer aa = new Customer("Adam Apple", 4, -1, -1);
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
		
		timein1.set(2011,1,1,0,15);
		timeout1.set(2011,1,1,0,45);
		Reservation r3 = new Reservation (1,2,4,timein1,timeout1);
		System.out.println("Making a reservation for Brian");
		
		timein1.set(2011,1,1,2,00);
		timeout1.set(2011,1,1,2,45);
		Reservation r4 = new Reservation (3,2,4,timein1,timeout1);
		System.out.println("Making a reservation for James");
		
		timein1.set(2011,1,1,2,30);
		timeout1.set(2011,1,1,2,45);
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
		
		GregorianCalendar cal1 = new GregorianCalendar();
		cal1.set(2011, 1, 1, 1,30);
		bg.getUpcomingReservations().get(0).extendReservation(cal1);
		System.out.println("Extending Reservation for Brian");
		
		*/
		System.out.println("...End...");
		
	}
}
	
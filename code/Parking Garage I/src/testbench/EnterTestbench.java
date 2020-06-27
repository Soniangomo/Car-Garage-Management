//written by: James Jacob
//assisted by: Richard Romanowksi
//debugged by: James Jacob and Richard Romanowski

package testbench;

import java.sql.SQLException;
import java.util.*;

import classes.Main;

import dataStructures.*;
//import inputDevices.*;
//import interfaces.*;
//import mechanics.Elevator;

public class EnterTestbench implements Runnable{
	
	int hour = 0;
	int min = 0;
	int parkingSpace = 0;
	
	ArrayList<Reservation> reserveInput = new ArrayList<Reservation>();
	ArrayList<String> walkInInput = new ArrayList<String>();
	
	static Calendar now = new GregorianCalendar();
	
	Scanner scan = new Scanner(System.in);
	
	public static Thread testbenchInThread;
		
	//Methods
	public void initializeArrayListTB(){
		walkInInput.add("I<3IVAN");
		walkInInput.add("DBR109");
		walkInInput.add("KVD936");
		walkInInput.add("JFN423");
		walkInInput.add("DEW735");
		walkInInput.add("UXN526");
		walkInInput.add("QOX297");
		walkInInput.add("BHE373");
		walkInInput.add("NVR093");
		walkInInput.add("CES464");
	}
	
	public EnterTestbench() {
		testbenchInThread = new Thread(this, "first");
		initializeArrayListTB();
		testbenchInThread.start();
	}
	
	public static Calendar getTime() {
		return now;
	}
	
	public void setParkingSpace( int space ) {
		parkingSpace = space;
	}
	
	@SuppressWarnings("deprecation")
	public void run() {
		int choice;
		testbenchInThread.suspend();
		while(true) {
			choice = 0;
			// call database for reservation data
			// update list/array of reservations
			System.out.print("Entrance Testing Menu:\n1. Check reservations\n2. Walk-in customer\nEnter choice: ");
			choice = scan.nextInt();
			switch(choice) {
			case 1:
				now.set(Calendar.HOUR, hour);
				now.set(Calendar.MINUTE, min);
				try {
						reserveInput = Reservation.getAllStartReservations(now);
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
				if( reserveInput.size() == 0 ) {
					if( hour < 24 ) {
						if( min == 45 ) {
							min = 0;
							hour++;
							continue;
						}
						else {
							min = min + 15;
							continue;
						}
					}
					else {
						testbenchInThread.stop();
					}
				}				
				else if( reserveInput.size() != 0 ) {
					try {
						while( reserveInput.get(0).getCustomer().getCustomerName().equals("temp")) {
							reserveInput.remove(0);
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					try {
						Main.frontCamera.setLP(reserveInput.get(0).getCar().getLicensePlate() );
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					reserveInput.remove(0);
				}
				break;
			case 2:
				now.set(2011, 4, 4, hour, min);
				if( walkInInput.size() != 0 ) {
					Main.frontCamera.setLP(walkInInput.get(0) );
					walkInInput.remove(0);
				}
				else if( walkInInput.size() == 0 ) {
					if( hour < 24 ) {
						if( min == 45 ) {
							min = 0;
							hour++;
						}
						else {
							min = min + 15;
						}
					}
					else {
						testbenchInThread.stop();
					}					
				}
				break;
			case 3:
				if( hour < 24 ) {
					if( min == 45 ) {
						min = 0;
						hour++;
					}
					else {
						min = min + 15;
					}
				}
				
				now.set(Calendar.HOUR, hour);
				now.set(Calendar.MINUTE, min);
				ExitTestbench.testbenchOutThread.resume();
				System.out.println("Time is now: " + hour + ":" + min);
				break;
			default:
				break;
			}
			
			if( choice != 3 ) {
				Main.elevator.setOccupancy( true );
				testbenchInThread.suspend();
			/*
			while( Elevator.isReady() == false ) {
				this.sleep(100);
			}
			*/
				Main.elevator.setOccupancy( false );
			}
			/*
			set sensor to occupied parking space
			or does the database do this?
			*/
		}
	}
}

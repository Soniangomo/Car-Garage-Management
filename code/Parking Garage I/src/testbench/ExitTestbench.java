package testbench;

import java.sql.SQLException;
import java.util.*;

import dataStructures.*;
//import testbench.*;
//import inputDevices.*;
import classes.Main;

public class ExitTestbench implements Runnable{
	
	private int hour;
	@SuppressWarnings("unused")
	private int min;
	
	ArrayList<Reservation> reserveOutput = new ArrayList<Reservation>();
	
	public static Thread testbenchOutThread;
	
	Calendar then = new GregorianCalendar();
	
	public ExitTestbench() {
		testbenchOutThread = new Thread(this, "third");
		testbenchOutThread.start();
	}
	
	@SuppressWarnings("deprecation")
	public void run() {
		while( true ) {
			
			then = EnterTestbench.getTime();
			hour = then.get(Calendar.HOUR);
			min = then.get(Calendar.MINUTE);
			try {
				reserveOutput = Reservation.getAllEndReservations(EnterTestbench.now);
				System.out.println("" + EnterTestbench.now);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			if( reserveOutput.size() != 0 ) {
				System.out.println("Exit Testing Menu:");
				try {
					System.out.println(reserveOutput.get(0).getCar().getLicensePlate());
					Main.backCamera.setLP(reserveOutput.get(0).getCar().getLicensePlate() );
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				reserveOutput.remove(0);
			}
			else if( reserveOutput.size() == 0 && hour > 24 ) {
				testbenchOutThread.stop();
			}
			testbenchOutThread.suspend();
			
		}
	}
	
}

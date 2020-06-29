package hardwareController;

//import testbench.*;
//import interfaces.*;
import java.sql.SQLException;

import dataStructures.*;
//import mechanics.*;
import classes.*;
import testbench.EnterTestbench;

public class Controller implements Runnable {
	private String lp;
	private int floor;
	public boolean isEnterInterfaceBusy = false;
	
	Reservation current;
	
	public static Thread controllerThread;
	
	public Controller() {
		controllerThread = new Thread(this, "second");
		controllerThread.start();
	}
	
	@SuppressWarnings("deprecation")
	public void run() {
		while(true) {
			while( lp == null ) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				lp = Main.frontCamera.getLP();
				Main.frontCamera.setLP(null);
			}
			try {
				Main.enterGUI.goToLPScreen(lp);
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			lp = null;

			controllerThread.suspend();

			current = Main.enterGUI.getCurrentReservation();
			floor = current.getFloorNumber();
			Main.TestbenchIn.setParkingSpace( current.getParkingSpot() );
			Main.elevator.entryDoor.closeDoor();
			Main.elevator.goToFloor( floor );
			Main.elevator.exitDoor.openDoor();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Main.elevator.exitDoor.closeDoor();
			Main.elevator.goToFloor( 1 );
			Main.elevator.entryDoor.openDoor();
			EnterTestbench.testbenchInThread.resume();
		}
	}
}
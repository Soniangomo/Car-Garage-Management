package classes;

import java.util.*;
import java.sql.SQLException;

import testbench.*;
import hardwareController.*;
import mechanics.*;
import database.Database;
//import dataStructures.*;
import inputDevices.*;
import interfaces.*;

public class Main {
	
	private final static int NUM_OF_SPOTS = 104;
	public static Vector<Sensor> sensors = new Vector<Sensor>(NUM_OF_SPOTS,1);
	public static Controller garageController;
	public static ControllerOut outController;
	public static Elevator elevator;
	public static Camera frontCamera;
	public static Camera backCamera;
	public static Gate backGate;
	public static EnterTestbench TestbenchIn;
	public static ExitTestbench TestbenchOut;
	public static EnterInterface enterGUI;
	public static ExitInterface exitGUI;
	
	
	@SuppressWarnings("deprecation")
	public static void main(String args[]) throws ClassNotFoundException, SQLException, InterruptedException {
		
		Database.connectToDatabase();
		createSensors(NUM_OF_SPOTS);
		
	    //Create all devices and mechanics
		garageController = createController();
		outController = createOController();
		
		elevator = createElevator();
		frontCamera = createCamera();
		backCamera = createCamera();
		backGate = createGate();
					
		//Create GUIs:
		enterGUI = new EnterInterface();
	    exitGUI = new ExitInterface();
	    
	    //Create and run the testbench
	    TestbenchIn = createEnterTestbench();
	    TestbenchOut = createExitTestbench();
		
		enterGUI.createAndShowGUI();
		exitGUI.createAndShowGUI();
		TestbenchIn.testbenchInThread.resume();
	}
	
	public static Controller createController(){
		System.out.print("Creating Controller...");
		Controller garageController = new Controller();
		System.out.println("Done.\n");
		return garageController;
	}
	
	public static ControllerOut createOController() {
		System.out.print("Creating 2nd Controller");
		ControllerOut garageController = new ControllerOut();
		System.out.println("Done.\n");
		return garageController;
	}
	
	public static EnterTestbench createEnterTestbench(){
		System.out.print("Creating Enter Testbench...");
		EnterTestbench testbench = new EnterTestbench();
		System.out.println("Done.\n");
		return testbench;
	}
	
	public static ExitTestbench createExitTestbench(){
		System.out.print("Creating Exit Testbench...");
		ExitTestbench testbench = new ExitTestbench();
		System.out.println("Done.\n");
		return testbench;
	}
	
	public static Database createDatabase(){
		System.out.print("Creating Database...");
		Database theDatabase = new Database();
		System.out.println("Done.");
		return theDatabase;
	}
	
	public static void createSensors(int i){
		System.out.print("Creating " + i + " sensors...");
		for (int ii = 0; ii<i; ii++){
			Sensor s = new Sensor(ii);
			sensors.add(s);
		}
		System.out.println("Done.");
	}
	
	public static Camera createCamera(){
		System.out.print("Creating Cameras...");
		Camera camera = new Camera();
		camera.setLP(null);
		System.out.println("Done.");
		return camera;
	}
	
	public static Elevator createElevator(){
		System.out.print("Creating Elevator...");
		Elevator elevator = new Elevator();
		System.out.println("Done.");
		return elevator;
	}
	
	public static Gate createGate() {
		System.out.println("Creating Gate...");
		Gate gate = new Gate();
		System.out.println("Done");
		return gate;
	}
}
package mobile;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dataStructures.Customer;
import dataStructures.Reservation;
import database.Database;


public class MobileInterface {
	private static void createAndShowGUI() throws ClassNotFoundException, SQLException {
		Database.connectToDatabase();
		
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(false);

        //Create and set up the window.
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel everything = new JPanel();
        	everything.setLayout(new GridBagLayout());
	        GridBagConstraints c = new GridBagConstraints();
	        c.weightx = 0.5;
	        c.weighty = 0.5;
        
        JLabel label = new JLabel("<html><p>Mobile Interface</p></html>",JLabel.CENTER);
        	label.setFont(new Font("Dialog",1,24));
        	//label.setAlignmentX(JLabel.CENTER);
        	c.gridx = 0; 
        	c.gridy = 0;
        	c.gridwidth = 2;
        	c.gridheight = 1;
        	c.ipadx = 500;
        everything.add(label,c);
        
        JLabel inputLabel = new JLabel("Input:",JLabel.CENTER);
        	inputLabel.setAlignmentX(JLabel.CENTER);
        	c.gridx = 0; 
        	c.gridy = 1;
        	c.gridwidth = 1;
        	c.gridheight = 1;
        everything.add(inputLabel,c);
        	
    	JLabel outputLabel = new JLabel("Output:",JLabel.CENTER);
    		outputLabel.setAlignmentX(JLabel.CENTER);
        	c.gridx = 1; 
        	c.gridy = 1;
        	c.gridwidth = 1;
        	c.gridheight = 1;
        everything.add(outputLabel,c);
        
    	final JTextField inputField = new JTextField();
			c.gridx = 0; 
			c.gridy = 2;
			c.gridwidth = 1;
			c.gridheight = 1;
			c.fill = GridBagConstraints.HORIZONTAL;
    	everything.add(inputField,c);
    	
    	final JTextField outputField = new JTextField();
    		outputField.setEditable(false);
    		c.gridx = 1; 
	    	c.gridy = 2;
	    	c.gridwidth = 1;
	    	c.gridheight = 1;
	    	c.fill = GridBagConstraints.HORIZONTAL;
    	everything.add(outputField,c);    
    	
    	JButton enterB = new JButton("Send");
    		enterB.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0)  {
                	//On Click:
	        		String stringToBeTokenized = inputField.getText();
	        		if ( !stringToBeTokenized.equals("") ){
    					Customer customer = null;
    					Reservation reservation = null;
	        			int argument = 0;
	        			int MAKE_EXTEND = 0;
	        			int time;
	        			int customerID = 0;
	        			int carID = 0;
	        			final int  MAKE = 100;
	        			final int EXTEND = 99;
		        		//parse string
	        			StringTokenizer st = new StringTokenizer(stringToBeTokenized," ");
	        			
	        			while(st.hasMoreTokens()){
	        				String nextToken = st.nextToken();
	        				if ( argument == 0  && isInteger(nextToken) ){
	        					customerID = Integer.parseInt(nextToken);
	        					try {
									customer = Customer.ID_to_Customer(customerID);
								} catch (ClassNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
	        					//if they don't exist
								//find out what a nonexistent customer is
	        					if (customer == null){
	        						//tell user it is not a valid userID
	        						outputField.setText("This is not a valid user ID");
	        						inputField.setText("");
	        						break;
	        					}	        					
	        				}
	        				else if ( argument == 1 ){
	        					if( nextToken.equals("make") ){
	        						MAKE_EXTEND = MAKE;
	        					}
	        					else if ( nextToken.equals("extend")){
	        						MAKE_EXTEND = EXTEND;
	        					}
	        					else{
	        						outputField.setText("Not a valid command. Must be of form '<userID> <command> <time> [time]'.");
	        						inputField.setText("");
	        						break;
	        					}
	        				}
	        				else if ( argument == 2 ){
	        					int i ;
								if ( MAKE_EXTEND == MAKE && st.hasMoreTokens()){
	        						String lastToken = st.nextToken();
	        						if ( isInteger(nextToken) && isInteger(lastToken)){
	        							int startTime = Integer.parseInt(nextToken);
	        							int endTime = Integer.parseInt(lastToken);
	        							if (startTime > endTime){
	    	        						outputField.setText("Start time must occur before end time.");
	    	        						inputField.setText("");
	    	        						break;
	        							}
	        							else if ( startTime < 0 || startTime > 2359 || endTime < 0 || endTime > 2359 || ((startTime % 100) > 60) || ((endTime % 100) > 60) ){
	    	        						outputField.setText("Not a valid time.");
	    	        						inputField.setText("");
	    	        						break;
	        							}
	        							else{	//valid time inputs
	        								startTime = roundTimeDown(startTime);
	        								endTime = roundTimeUp(endTime);
	        								Calendar cs = new GregorianCalendar();
	        									cs.set(2011,01,01,startTime/100,startTime%100);
		        								//cs.set(Calendar.HOUR,startTime/100);
		        								//cs.set(Calendar.MINUTE,startTime % 100);
	        								Calendar ce = new GregorianCalendar();
	        									ce.set(2011,01,01,endTime/100,endTime%100);
		        								//ce.set(Calendar.HOUR,endTime/100);
		        								//ce.set(Calendar.MINUTE,endTime % 100);
	        								try {
	        									//I don't have a car
	        									carID = customer.getCarIDs().get(0);
												reservation = new Reservation(customerID, -1, carID, cs, ce);
											} catch (ClassNotFoundException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
	        								if ( reservation.getReservationID() < 0){
		    	        						outputField.setText("Reservation cannot be made for those times.");
		    	        						inputField.setText("");
		    	        						break;
	        								}
	        								else{
	        									String min1;
	        									String min2;
	        									i = reservation.reservationInformation().get(0).get(Calendar.MINUTE);
	        									if ( i == 0){
	        										min1 = "00";
	        									}
	        									else{
	        										min1 = Integer.toString(i);
	        									}
	        									i = reservation.reservationInformation().get(1).get(Calendar.MINUTE);
	        									if ( i == 0){
	        										min2 = "00";
	        									}
	        									else{
	        										min2 = Integer.toString(i);
	        									}
	        									outputField.setText("A reservation from " + reservation.reservationInformation().get(0).get(Calendar.HOUR) + ":" + min1 + " to " + reservation.reservationInformation().get(1).get(Calendar.HOUR) + ":" + min2 + " has been successfully made.");
	        								}
	        							}
	        						}
	        						else{
	        							outputField.setText("The two arguments for the command 'make' must be 4 digit integers.");
		        						inputField.setText("");
		        						break;
	        						}	
	        					}
	        					else if (isInteger(nextToken)){
	        						time = Integer.parseInt(nextToken);
	        						if ( time > 2359){
										outputField.setText("The one argument for the command 'extend' must be less than 1000 minutes.");
										inputField.setText("");
										break;
    								}
	        						int addTime = Integer.parseInt(nextToken);
	        						try {
										reservation = customer.getCurrentReservation();
									} catch (ClassNotFoundException e) {
										e.printStackTrace();
									} catch (SQLException e) {
										e.printStackTrace();
									}
									try {
										reservation=Reservation.ID_to_Reservation(6);
									} catch (SQLException e1) {
										e1.printStackTrace();
									} catch (ClassNotFoundException e1) {
										e1.printStackTrace();
									}
									
									//Calendar oldCal = reservation.reservationInformation().get(0);
									Calendar newCal = Calendar.getInstance(); 
									Calendar a = reservation.reservationInformation().get(1);
									newCal.set(a.get(Calendar.YEAR), a.get(Calendar.MONTH), a.get(Calendar.DATE), a.get(Calendar.HOUR), addTime + a.get(Calendar.MINUTE));
									try {
										reservation.extendReservation(newCal);
									} catch (SQLException e) {
										e.printStackTrace();
									} catch (ClassNotFoundException e) {
										e.printStackTrace();
									}
									i = reservation.reservationInformation().get(0).get(Calendar.MINUTE);
									String min1;
									String min2;
									if ( i == 0){
										min1 = "00";
									}
									else{
										min1 = Integer.toString(i);
									}
									i = reservation.reservationInformation().get(1).get(Calendar.MINUTE);
									if ( i == 0){
										min2 = "00";
									}
									else{
										min2 = Integer.toString(i);
									}
									outputField.setText("A reservation from " + reservation.reservationInformation().get(0).get(Calendar.HOUR) + ":" + min1 + " to " + reservation.reservationInformation().get(1).get(Calendar.HOUR) + ":" + min2 + " has been successfully made.");
	        					}
	        				}
	        				argument++;
        				}
		        		//call appropriate functions
		        		//tell user the correct format
		        		
		        		//Clear inputField
		        		inputField.setText("");
	        		}
	        	}
	        });
			c.gridx = 0; 
	    	c.gridy = 3;
	    	c.gridwidth = 0;
	    	c.gridheight = 1;
	    	c.fill = GridBagConstraints.VERTICAL;
	    	c.anchor = GridBagConstraints.CENTER;
    	everything.add(enterB,c);

        //Display the window.
        frame.getContentPane().add(everything);
        frame.pack();
        frame.setVisible(true);
}
    public static int roundTimeDown(int time){
    	int hours = time / 100;
    	int minutes = time % 100;
    	
    	if( minutes > 0 && minutes < 15){
    		minutes = 0;
    	}
    	else if ( minutes > 15 && minutes < 30){
    		minutes = 15;
    	}
    	else if ( minutes > 30 && minutes < 45){
    		minutes = 30;
    	}
    	else if ( minutes > 45 && minutes < 60){
    		minutes = 45;
    	}
    	time = (hours * 100) + minutes;
    	return time;    	
    }
    public static int roundTimeUp(int time){
    	int hours = time / 100;
    	int minutes = time % 100;
    	
    	if( minutes > 0 && minutes < 15){
    		minutes = 15;
    	}
    	else if ( minutes > 15 && minutes < 30){
    		minutes = 30;
    	}
    	else if ( minutes > 30 && minutes < 45){
    		minutes = 45;
    	}
    	else if ( minutes > 45 && minutes < 60){
    		minutes = 60;
    		hours++;
    		if (hours == 24){
    			hours = 0;
    		}
    	}
    	time = (hours * 100) + minutes;
    	return time; 
    }
    public static boolean isInteger(String input){
    	boolean retVal = false;
    	try{
    		Integer.parseInt(input);
    		retVal = true;
    	}
    	catch (Exception e) {}
    		return retVal;
	}
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
					createAndShowGUI();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }
}
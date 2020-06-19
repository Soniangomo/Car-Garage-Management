//written by: Richard Romanowksi
//assisted by: James Jacob
//debugged by: Richard Romanowski and James Jacob 

package interfaces;

import hardwareController.ControllerOut;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dataStructures.Car;
import dataStructures.Reservation;

import money.Accountant;

public class ExitInterface {
	//Placeholders in memory
	public static Reservation curReservation;
	static Calendar now;
	
	//Textfields
	private static JTextField total = new JTextField("", 20); 
	private static JTextField overstay = new JTextField("", 20);
	
	static JPanel exitCards;	//All the screens a user sees when they pay and leave
	    final static String CHARGEPANEL = "Swipe your Card";
		final static String BYEPANEL = "Exiting Card";
	

	public void addComponentToPane(Container pane) {	
		
		JPanel chargeCard = new JPanel();
	        chargeCard.setLayout(new BoxLayout(chargeCard, BoxLayout.Y_AXIS));
	        chargeCard.add(new JLabel("<html><p>Your total is:</p></html>"));
	        total.setEditable(false);
	        total.setHorizontalAlignment(JTextField.CENTER);
	        chargeCard.add(total);
	        chargeCard.add(new JLabel("<html><p>You overstayed by:</p></html>"));
	        overstay.setEditable(false);
	        overstay.setHorizontalAlignment(JTextField.CENTER);
	        chargeCard.add(overstay);
	        chargeCard.add(new JLabel("<html><p>Please swipe your credit card to confirm.</p></html>"));
	        JButton okB = new JButton("OK");
	        okB.addActionListener(new ActionListener() {
	            @SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent arg0) {
	                goToCard(BYEPANEL);
	                //updateCustomerBalance
	                //get current exit time
	                try {
	                	//System.out.println("Three hours left: " + regID);
	                	
	                	//Reservation curReservation2 = Reservation.ID_to_Reservation(regID);  
						curReservation.confirmExit();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
	                //TODO tell james that exit interface is available
	                ControllerOut.controllerOutThread.resume();
	            }
	        });
	        chargeCard.add(okB);
        
        JPanel goodbyeCard = new JPanel();
	        goodbyeCard.setLayout(new BoxLayout(goodbyeCard, BoxLayout.X_AXIS));
	        JLabel goodbyeMessage = new JLabel("<html><p>Thank you for parking!</p></html>",JLabel.CENTER);
	        goodbyeMessage.setFont(new Font("Dialog",1,32));
	        goodbyeMessage.setHorizontalTextPosition(JLabel.CENTER);
	        goodbyeCard.add(goodbyeMessage);

		exitCards = new JPanel(new CardLayout());
			exitCards.add(goodbyeCard, BYEPANEL);
			exitCards.add(chargeCard, CHARGEPANEL);
        pane.add(exitCards, BorderLayout.CENTER);

	}

	/* Purpose: allow controller to easily go to pay screen
	 * Input: license
	 * Output: 
	 */
	public void goToPayScreen (String lp, Calendar c) throws ClassNotFoundException, SQLException{
		System.out.println("Calling goToPayScreen(" + lp + "," + c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ")...");
		ExitInterface.now = c;
		ExitInterface.curReservation = Car.checkOut(lp, c);
		//regID = curReservation.getReservationID();
		//System.out.println("regId: " + regID + "| cusID: " + curReservation.getCustomerID());
		float ot = Accountant.getOverStayTime(curReservation);
		float price = Accountant.getPrice(curReservation);
		setTotal(price);
		setOverstay(ot);
		goToCard(CHARGEPANEL);
				//tell james exit interface is busy
	}
	public static void goToCard(String s){
		CardLayout cl = (CardLayout)(exitCards.getLayout());
    	cl.show(exitCards,s);
	}
	
	/* Purpose: set price to pay to display
	 * Input: time overstayed in hours
	 * Output: no output, but changes the overstay textfield to display the time
	 */
	public void setTotal(float f){
		total.setText("$" + f);
	}
	
	/* Purpose: set overstay time to display to the customer, so they know why they are being charged more.
	 * Input: time overstayed in hours
	 * Output: no output, but changes the overstay textfield to display the time
	 */
	public void setOverstay(float f){
		overstay.setText(f + " hours");
	}
	public void createAndShowGUI() {
		//Create and set up the window.
		JFrame exitFrame = new JFrame("Exit Gate");
		exitFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		exitFrame.setLocation(800,100);
		exitFrame.setSize(800,600);
		
		//Create and set up the content pane.
		ExitInterface exitInterface = new ExitInterface();
		exitInterface.addComponentToPane(exitFrame.getContentPane());
	
			//Display the window.
			//exitFrame.pack();
			exitFrame.setVisible(true);
	}
}

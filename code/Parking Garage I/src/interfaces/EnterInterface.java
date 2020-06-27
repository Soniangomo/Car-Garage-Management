//written by: Richard Romanowksi
//assisted by: James Jacob
//debugged by: Richard Romanowski and James Jacob 

package interfaces;

import hardwareController.Controller;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import dataStructures.Car;
import dataStructures.Customer;
import dataStructures.Reservation;

public class EnterInterface  {
	//CONSTANTS
	private String[] hours = {"1","2","3","4","5","6","7","8","9","10","11","12"};
	private String[] minutes = {"00","15","30","45"};
	private String[] ampm = {"AM","PM"};
	protected long BUFFER = 15;
	
	//Buttons
	JButton imnothereB = new JButton("I'M NOT HERE");
	
	//Cards
	JPanel multipleCard = new JPanel();
	JPanel regidCard = new JPanel();
	JPanel thanksCard = new JPanel();
	JPanel createCard = new JPanel();
	JPanel welcomeCard = new JPanel();
	JPanel lpCard = new JPanel();
	JPanel personalCard = new JPanel();
	

	//Fonts
	@SuppressWarnings("unused")
	private Font tinyFont = new Font("Dialog",1,14);
	private Font smallFont = new Font("Dialog",1,24);
	private Font medFont = new Font("Dialog",1,36);
	@SuppressWarnings("unused")
	private Font bigFont = new Font("Dialog",1,48);
	private Font largeFont = new Font("Dialog",1,72);

	//Combo Boxes for the create/edit screen
	JComboBox startHours = new JComboBox(hours);
	JComboBox startMinutes = new JComboBox(minutes);
	JComboBox startAmPm = new JComboBox(ampm);
	JComboBox endHours = new JComboBox(hours);
	JComboBox endMinutes = new JComboBox(minutes);
	JComboBox endAmPm = new JComboBox(ampm);

	//This was for the radio buttons, but need to figure out if this doable.
	ButtonGroup bg = new ButtonGroup();
	JButton yB2 = new JButton("YES");

	//Allows us to hold a customer, car, reservation
	private Customer curCustomer;
	private Car curCar;
	private static Reservation curReservation;

	//Textfields and Functions
	JTextField spotField = new JTextField();
	private static JTextField lpField = new JTextField("", 20);
	public static void setlpField(String s){
		lpField.setText(s);
	}
	public static String getlpField(){
		return lpField.getText();
	}
	private static JTextField startTime = new JTextField("", 20);
	public static void setstartTime(String s){
		startTime.setText(s);
	}
	public static String getstartTime(){
		return startTime.getText();
	}
	private static JTextField endTime = new JTextField("", 20);
	public static void setendTime(String s){
		endTime.setText(s);
	}
	public static String getendTime(){
		return endTime.getText();
	}
	private static JTextField name = new JTextField("", 20);
	public static void setname(String s){
		name.setText(s);
	}
	public static String getname(){
		return name.getText();
	}
	private static JTextField startRTime = new JTextField(":", 20);
	public static void setstartRTime(String s){
		startRTime.setText(s);
	}
	public static String getstartRTime(){
		return startRTime.getText();
	}
	private static JTextField endRTime = new JTextField(":", 20);
	public static void setendRTime(String s){
		endRTime.setText(s);
	}
	public static String getendRTime(){
		return endRTime.getText();
	}
	private static JTextField regid = new JPasswordField("",20);
	public static void setregid(String s){
		regid.setText(s);
	}
	public static String getregid(){
		return regid.getText();
	}

	static JPanel entryCards;	//All the screens a user sees when they are in the elevator
	final static String WELCOMEPANEL = "Welcome Card";
	final static String LPPANEL = "LP Card";
	final static String PERSONALPANEL = "Individual Driver Card";
	final static String MULTIPLEPANEL = "Multi-Driver Card";
	final static String REGIDPANEL = "Registration ID Keypad";
	final static String THANKSPANEL = "Drive Forward";
	final static String CREATEPANEL = "Create a new Reservation";
	final static String EDITPANEL = "Create a new Reservation";

	public void addComponentToPane(Container pane) throws ClassNotFoundException, SQLException{	
		makeWelcomeScreen();
		makeLicensePlateScreen();
		makePersonalScreen();
		makeRegistrationIDScreen();
		makeThankYouScreen();
		makeCreateScreen();

		//Create the panel that contains the "cards".
		entryCards = new JPanel(new CardLayout());
		entryCards.add(welcomeCard, WELCOMEPANEL);	//looks good
		entryCards.add(lpCard, LPPANEL);			//looks good
		entryCards.add(personalCard, PERSONALPANEL);//looks good
		entryCards.add(multipleCard, MULTIPLEPANEL);//UNKNOWN
		entryCards.add(regidCard, REGIDPANEL);		//looks good
		entryCards.add(thanksCard, THANKSPANEL);	//UNKNOWN
		entryCards.add(createCard, CREATEPANEL);	//looks good
		entryCards.add(createCard, EDITPANEL);		//looks good

		//pane.add(comboBoxPane, BorderLayout.PAGE_START);
		pane.add(entryCards, BorderLayout.CENTER);
	}
	
	/* Time Functions */
	public Calendar add15min(Calendar cal){
		cal.add(Calendar.MINUTE,15);
		return cal;
	}
	public Calendar[] getNewTimes(){
		//@Brian:
		//This only sets the time since you said to assume Jan 1. so just ignore the date categories until you decide to change that.
		Calendar[] times = {Calendar.getInstance(),Calendar.getInstance()};
		//Calendar startTime = Calendar.getInstance();
		//Calendar endTime = Calendar.getInstance();

		int sH = Integer.parseInt(startHours.getSelectedItem().toString());
		int sM = Integer.parseInt(startMinutes.getSelectedItem().toString());
		int sT;
		if ( (startAmPm.getSelectedItem().toString()).equals(ampm[0]) )
			sT = Calendar.AM;
		else
			sT = Calendar.PM;

		int eH = Integer.parseInt(endHours.getSelectedItem().toString());
		int eM = Integer.parseInt(endMinutes.getSelectedItem().toString());
		int eT;
		if ( (endAmPm.getSelectedItem().toString()).equals(ampm[0]) )
			eT = Calendar.AM;
		else
			eT = Calendar.PM;

		times[0].set(Calendar.HOUR, sH);
		times[0].set(Calendar.MINUTE, sM);
		times[0].set(Calendar.AM_PM, sT);

		times[1].set(Calendar.HOUR, eH);
		times[1].set(Calendar.MINUTE, eM);
		times[1].set(Calendar.AM_PM, eT);

		return times;
	}
	public int[] add15min(int[] times){
		times[1] = times[1] + 15;
		if (times[1] >= 60){
			times[1] = times[1] - 60;
			times[0]++;

			if ( times[0] == 13)
				times[0] = 1;
			else if ( times[0] == 12)
				times[2] = 1 - times[2];
		}

		return times;
	}
	public int[] RoundTime(int[] times){
		int hour = times[0];
		int minute = times[1];

		if ( 0<= minute && minute <15)
			minute = 0;
		else if ( 15 <= minute && minute < 30 )
			minute = 15;
		else if ( 30 <= minute && minute < 45 )
			minute = 30;
		else if ( 45<= minute && minute < 60 )
			minute = 45;

		if(hour == 0) //if 12am or 12pm
		hour = 12;

		times[0] = hour;
		times[1] = minute;
		//System.out.println("Rounded time is: " + times[0] + ":" + times[1] + " " + times[2] + ".");
		return times;
	}
	public Calendar RoundTimeUp(Calendar c){
		int hour;
		int minute;
		hour = c.get(Calendar.HOUR_OF_DAY);
		minute = c.get(Calendar.MINUTE);
		if ( 0<= minute && minute <15)
			minute = 15;
		else if ( 15 <= minute && minute < 30 )
			minute = 30;
		else if ( 30 <= minute && minute < 45 )
			minute = 45;
		else if ( 45<= minute && minute < 60 ){
			minute = 0;
			hour++;
		}
		if ( hour == 24)
			hour = 0;
		
		c.set(Calendar.HOUR_OF_DAY,hour);
		c.set(Calendar.MINUTE, minute);
		return c;
	}
	public Calendar RoundTimeDown(Calendar c){
		int hour; 
		int minute;
		hour = c.get(Calendar.HOUR_OF_DAY);
		minute = c.get(Calendar.MINUTE);
		
		if ( 0<= minute && minute <15)
			minute = 0;
		else if ( 15 <= minute && minute < 30 )
			minute = 15;
		else if ( 30 <= minute && minute < 45 )
			minute = 30;
		else if ( 45<= minute && minute < 60 )
			minute = 45;
		
		c.set(Calendar.HOUR_OF_DAY,hour);
		c.set(Calendar.MINUTE, minute);
		return c;
	}
	public int[] getCurrentTime(){
		Calendar cal = new GregorianCalendar();
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int ampm = cal.get(Calendar.AM_PM);
		int times[] = {hour,minute,ampm};
		//System.out.println("Current time is: " + hour + ":" + minute + " " + ampm + ".");
		return times;
	}
	public void setComboBoxes(){
		int[] curTimes = RoundTime(getCurrentTime());
		System.out.println(curTimes[0] + ":" + curTimes[1]);
		startAmPm.setSelectedIndex(curTimes[2]);
		startHours.setSelectedIndex(curTimes[0] - 1);
		startMinutes.setSelectedIndex(curTimes[1]/15);

		int[] laterTimes = add15min(curTimes);
		endAmPm.setSelectedIndex(laterTimes[2]);
		endHours.setSelectedIndex(laterTimes[0] - 1);
		endMinutes.setSelectedIndex(laterTimes[1]/15);
	}

	/* Helper Functions */
	public static void goToCard(String s){
		CardLayout cl = (CardLayout)(entryCards.getLayout());
		cl.show(entryCards,s);
	}
	public Reservation getCurrentReservation(){
		return curReservation;
	}
	public void goToLPScreen(String s) throws SQLException, ClassNotFoundException{
		goToCard(LPPANEL);
		setlpField(s);
	}
	
	/* Make GUI functions */
	public void makeLicensePlateScreen(){
		lpCard.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.weightx = 0.5;
			c.weighty = 0.5;

		//lpTitle
		JLabel lpTitle = new JLabel("We have determined your license plate to be:",JLabel.CENTER);
			lpTitle.setFont(medFont);
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 1;
			c.gridwidth = 2;
			c.gridy = 0;
			c.anchor = GridBagConstraints.PAGE_START;
		lpCard.add(lpTitle, c);

		//lpField
			lpField.setEditable(false);
			lpField.setHorizontalAlignment(JTextField.CENTER);
			lpField.setFont(largeFont);
			c.gridx = 1;
			c.gridwidth = 2;
			c.gridy = 1;
		lpCard.add(lpField, c);

		JLabel question = new JLabel("Is this correct?",JLabel.CENTER);
			question.setFont(medFont);
			c.fill = GridBagConstraints.VERTICAL;
			c.gridx = 1;
			c.gridwidth = 2;
			c.gridy = 2;
			c.fill = GridBagConstraints.BOTH;
		lpCard.add(question, c);

		JButton yB = new JButton("YES");
		yB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//  - Fetch customer information from database via license plate
				ArrayList<Customer> customers = null;
				ArrayList<Reservation> reservations = null;
				int numOfCustomers = 0;

				try {
					customers = Customer.plate_to_Customers(lpField.getText());
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				if (customers!=null){
					numOfCustomers = customers.size();
				}
				else{
					numOfCustomers = 0;
				}
				System.out.println("1..");
				System.out.println("numCustomers: " + numOfCustomers);
				if (numOfCustomers == 0){
					System.out.println("2..");
					try {
						System.out.println("3..");
						curCustomer = new Customer("temp", -1, -1, -1);
						curCar = new Car(getlpField(),curCustomer.getCustomerID());
						//System.out.println("curCar: " + curCar.getCarID());
					} catch (SQLException e) {
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					setComboBoxes();
					goToCard(CREATEPANEL);
				}
				else if(numOfCustomers == 1){
					//  - Fetch reservation information and sets the time fields
					curCustomer = customers.get(0);
					try {
						reservations = curCustomer.getUpcomingReservations();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					if ( reservations.size() > 0){
						curReservation = reservations.get(0);							
						Calendar rti = curReservation.reservationInformation().get(0);
						Calendar rto = curReservation.reservationInformation().get(1);
						Calendar now = new GregorianCalendar();
						//Check if rti is close to current time
						long rtiTime = rti.getTimeInMillis();
						long nowTime = now.getTimeInMillis();

						if (nowTime - rtiTime < BUFFER ){
							//Customer arrives close enough to reservation
							//fill in data
							String c = customers.get(0).getCustomerName();
							String s = rti.get(Calendar.HOUR) + ":" + rti.get(Calendar.MINUTE);
							String e = rto.get(Calendar.HOUR) + ":" + rto.get(Calendar.MINUTE);
							name.setText(c);
							startTime.setText(s);
							endTime.setText(e);
							goToCard(PERSONALPANEL);
						}
						else{
							//Assume they want to make a new reservation
							goToCard(CREATEPANEL);
						}
					}
					else{
						goToCard(CREATEPANEL);
					}
				}
				else{
					//Create a radio button for each customer
					ButtonGroup bg = new ButtonGroup();
					for ( int i = 0; i < numOfCustomers; i++){
						bg.add(new JRadioButton(customers.get(i).getCustomerName()));
						multipleCard.add(new JRadioButton(customers.get(i).getCustomerName()));
					}
					;
					multipleCard.add(yB2);
					multipleCard.add(imnothereB);
					goToCard(MULTIPLEPANEL);		        			
				}	                	
			}
		});

		JButton nB = new JButton("NO");
		nB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				goToCard(REGIDPANEL);
			}
		});
		//c.fill = GridBagConstraints.HORIZONTAL;
		/*	   			c.gridx = 2;
	   			c.gridy = 3;
	   			c.gridwidth = 1;
	   			c.gridheight = 1;
	   			c.ipady = 100;
	   			c.ipadx = 75;
	        lpCard.add(nB, c);*/

		JPanel buttons = new JPanel();
			buttons.setLayout(new GridLayout(0, 2));
			buttons.setBackground(Color.black);
			buttons.add(yB);
			buttons.add(nB);
			c.gridx = 1;
			c.gridwidth = 2;
			c.gridy = 3;
			c.gridheight = 1;
			c.fill = GridBagConstraints.BOTH;
		lpCard.add(buttons, c);
	}
	public void makePersonalScreen(){
		GridBagConstraints c = new GridBagConstraints();
		personalCard.setLayout(new GridBagLayout());

		JLabel pTitle = new JLabel("Welcome,",JLabel.CENTER);
			pTitle.setFont(medFont);
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 0;
			c.gridwidth = 3;
			c.gridy = 0;
			c.anchor = GridBagConstraints.PAGE_START;
		personalCard.add(pTitle, c);

			name.setEditable(false);
			name.setFont(medFont);
			c.gridx = 0;
			c.gridwidth = 3;
			c.gridy = 1;
			c.fill = GridBagConstraints.BOTH;
		personalCard.add(name,c);

		JLabel curRes= new JLabel("Your current reservations is:",JLabel.CENTER);
			curRes.setFont(medFont);
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 0;
			c.gridwidth = 3;
			c.gridy = 2;
		personalCard.add(curRes, c);

		JPanel times = new JPanel();
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 0;
			c.gridwidth = 3;
			c.gridy = 3;
			times.setLayout(new GridLayout(0,3));
				startTime.setEditable(false);
				startTime.setHorizontalAlignment(JTextField.CENTER);
				startTime.setFont(medFont);
			times.add(startTime);
			
			JLabel tooo = new JLabel("to",JLabel.CENTER);
				tooo.setFont(smallFont);
				//WHY WON"T THIS APPEAR?
						//times.add(tooo);
				//BUT THIS WILL
			times.add(new JLabel("to",JLabel.CENTER));
			
				endTime.setEditable(false);
				endTime.setHorizontalAlignment(JTextField.CENTER);
				endTime.setFont(medFont);
			times.add(endTime);
		personalCard.add(times,c);

		JPanel buttons2 = new JPanel();
			buttons2.setLayout(new GridLayout(0,3));
			c.gridx = 0;
			c.gridwidth = 3;
			c.gridy = 4;

			JButton editB = new JButton("EDIT");
				editB.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setComboBoxes();
						goToCard(EDITPANEL);
					}
				});
			buttons2.add(editB);
			
			JButton confirmB = new JButton("CONFIRM");
				confirmB.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent arg0) {
					//Get current time - gets a calendar object of fake current time
					//update database
					System.out.println(curReservation.getReservationID() + "");
					spotField.setText(Integer.toString(curReservation.getParkingSpot()));
	
					//curReservation.confirmArrival(Controller.getCurrentTime());
					//Inside function must return a calendar - JAMES
					try {
						curReservation.confirmArrival(RoundTimeDown(new GregorianCalendar()));
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
					goToCard(THANKSPANEL);
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					goToCard(WELCOMEPANEL);
					//wake up james
					Controller.controllerThread.resume();
					//set elevator in motion
					//update reservation
					//change sensor (OPTIONAL)
				}
			});
			buttons2.add(confirmB);
			JButton notmeB = new JButton("NOT ME");
				notmeB.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						goToCard(REGIDPANEL);
					}
				});
			buttons2.add(notmeB);
		personalCard.add(buttons2,c);
	}
	public void makeRegistrationIDScreen(){
		regidCard.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridwidth = 5;
		c.gridy = 0;
		c.anchor = GridBagConstraints.PAGE_START;
		JLabel enterregid = new JLabel("Please enter your registration ID:",JLabel.CENTER);
		regidCard.add(enterregid,c);
		c.gridx = 1;
		c.gridwidth = 3;
		c.gridy = 1;
		c.gridheight = 1;
		regidCard.add(regid,c);
		c.gridx = 1;
		c.gridwidth = 3;
		c.gridy = 2;
		c.gridheight = 4;
		JPanel keypad = new JPanel();
		keypad.setLayout(new GridLayout(4,3));
		JButton b1 = new JButton("1");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				regid.setText(regid.getText()+"1");
			}
		});
		JButton b2 = new JButton("2");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				regid.setText(regid.getText()+"2");
			}
		});
		JButton b3 = new JButton("3");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				regid.setText(regid.getText()+"3");
			}
		});
		JButton b4 = new JButton("4");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				regid.setText(regid.getText()+"4");
			}
		});
		JButton b5 = new JButton("5");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				regid.setText(regid.getText()+"5");
			}
		});
		JButton b6 = new JButton("6");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				regid.setText(regid.getText()+"6");
			}
		});
		JButton b7 = new JButton("7");
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				regid.setText(regid.getText()+"7");
			}
		});
		JButton b8 = new JButton("8");
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				regid.setText(regid.getText()+"8");
			}
		});
		JButton b9 = new JButton("9");
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				regid.setText(regid.getText()+"9");
			}
		});
		JButton b0 = new JButton("0");
		b0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				regid.setText(regid.getText()+"0");
			}
		});
		JButton delB = new JButton("DEL");
		delB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = regid.getText();
				if(s.length()>0){
					regid.setText(s.substring(0, s.length()-1));
				}
			}
		});
		JButton clrB = new JButton("CLR");
		clrB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				regid.setText("");
			}
		});

		keypad.add(b1);
		keypad.add(b2);
		keypad.add(b3);
		keypad.add(b4);
		keypad.add(b5);
		keypad.add(b6);
		keypad.add(b7);
		keypad.add(b8);
		keypad.add(b9);
		keypad.add(b0);
		keypad.add(delB);
		keypad.add(clrB);
		regidCard.add(keypad,c);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridwidth = 3;
		c.gridy = 6;
		c.gridheight = 1;
		JButton enterB = new JButton("ENTER");
		enterB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//- Send registration ID to database and fetch customer info
				//- Go to personal screen
				//- Fill in customer name
				//- Fill in reservation
				try {
					curCustomer = Customer.ID_to_Customer(Integer.parseInt(regid.getText()));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}	                

				if(curCustomer != null){
					name.setText(curCustomer.getCustomerName());
					try {
						curReservation = curCustomer.getUpcomingReservations().get(0);
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					startTime.setText(curReservation.reservationInformation().get(0).get(Calendar.HOUR) + ":" +curReservation.reservationInformation().get(0).get(Calendar.MINUTE));
					endTime.setText(curReservation.reservationInformation().get(1).get(Calendar.HOUR) + ":" +curReservation.reservationInformation().get(1).get(Calendar.MINUTE));
					goToCard(PERSONALPANEL);	                	
				}
				else{
					//Not a valid ID number
					regidCard.add(new JLabel("<html><p>Not a valid ID number.</p><p>Please try again.</p></html>"));
					regid.setText("");
				}
			}
		});
		regidCard.add(enterB,c);
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 2;
		c.gridwidth = 3;
		c.gridy = 7;
		JLabel dontHave = new JLabel("I don't have a registration ID.",JLabel.CENTER);
		dontHave.setFont(medFont);
		dontHave.setAlignmentX(JLabel.CENTER);
		regidCard.add(dontHave,c);
		JButton skipB = new JButton("SKIP");
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 2;
		c.gridwidth = 3;
		c.gridy = 8;
		regidCard.add(skipB,c);

		skipB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setComboBoxes();
				goToCard(EDITPANEL);
			}
		});
	}
	public void makeThankYouScreen(){
		thanksCard.setLayout(new GridLayout(3,1));
		JLabel thanksMsg = new JLabel();
		thanksMsg.setText("<html><center><p>Thank you!</p><p>Please drive forward</p></center></html>");
		thanksMsg.setFont(largeFont);
		thanksCard.add(thanksMsg);
		thanksCard.add(new JLabel("Please park in spot:",JLabel.CENTER));
		spotField.setEditable(false);
		thanksCard.add(spotField);
	}
	public void makeCreateScreen(){
		GridBagConstraints c = new GridBagConstraints();
		createCard.setLayout(new GridBagLayout());
		
		JLabel errorMsg = new JLabel("");
			c.gridx = 0;
			c.gridy = 0;
			c.gridwidth = 7;
			c.fill = GridBagConstraints.BOTH;
		createCard.add(errorMsg,c);
		
		JLabel cTitle = new JLabel("Please enter the starting time and ending time of your reservation:",JLabel.CENTER); 
			cTitle.setFont(new Font("Dialog",1,20));
			c.gridx = 0;
			c.gridy = 1;
			c.gridwidth = 7;
			c.fill = GridBagConstraints.BOTH;
		createCard.add(cTitle,c);
		
		JPanel startAndEnd = new JPanel();
			startAndEnd.setLayout(new GridLayout(1,2));
			JLabel starttime = new JLabel("Start time:",JLabel.CENTER);
				starttime.setFont(new Font("Dialog",1,20));
			startAndEnd.add(starttime);
			JLabel endtime = new JLabel("End time:",JLabel.CENTER);
				endtime.setFont(new Font("Dialog",1,20));
			startAndEnd.add(endtime);
			c.gridx = 0;
			c.gridy = 2;
			c.gridwidth = 7;
			c.fill = GridBagConstraints.BOTH;
		createCard.add(startAndEnd,c);
		
		JPanel cBoxes = new JPanel();
			cBoxes.setLayout(new GridLayout(1,7));
			cBoxes.add(startHours);
			cBoxes.add(startMinutes);
			cBoxes.add(startAmPm);
			JLabel tooo = new JLabel("to",JLabel.CENTER);
				tooo.setFont(medFont);
			cBoxes.add(tooo);
			cBoxes.add(endHours);
			cBoxes.add(endMinutes);
			cBoxes.add(endAmPm);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 3;
			c.gridwidth = 7;
			c.anchor = GridBagConstraints.CENTER;
		createCard.add(cBoxes,c);

		JButton confirmReservationB = new JButton("OK");
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 3;
			c.gridy = 4;
			c.gridwidth = 4;
		createCard.add(confirmReservationB,c);
		confirmReservationB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Create calendar objects from the times
				Calendar newStartTime = getNewTimes()[0];
				Calendar newEndTime = getNewTimes()[1];
				@SuppressWarnings("unused")
				Reservation newReservation = null;

				//See how many reservations current customer has
				int numOfReservations = 0;
				numOfReservations = curCustomer.getUpcomingReservationsID().size();
				ArrayList<Car> cars = null;
				try {
					cars = curCustomer.getCars();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if ( cars.size() == 0 ) {
					try {
						curCar = new Car(getlpField(),curCustomer.getCustomerID());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else{
					curCar = cars.get(0);
				}
				if (numOfReservations == 0){
					try {
						curCar.getCarID();
						curCustomer.getCustomerID();
						curReservation = new Reservation(curCustomer.getCustomerID(), -1, curCar.getCarID(), newStartTime, newEndTime);
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					if (curReservation.getReservationID() < 0 ){
						//not valid
						createCard.add(new JLabel("<html><p>Not a valid reservation time.</p><p>Try a smaller interval.</p></html>"));
						setComboBoxes();
					}
					else{
						//valid							
						//move to screen
						//fill fields
						String hour1, hour2;
						String min1, min2;
						String ampm1, ampm2;
						hour1 = Integer.toString(curReservation.reservationInformation().get(0).get(Calendar.HOUR));
						hour2 = Integer.toString(curReservation.reservationInformation().get(1).get(Calendar.HOUR));
						min1 = Integer.toString(curReservation.reservationInformation().get(0).get(Calendar.MINUTE));
						if (min1.equals("0")){
							min1 = "00";
						}
						min2 = Integer.toString(curReservation.reservationInformation().get(1).get(Calendar.MINUTE));
						if (min2.equals("0")){
							min2 = "00";
						}
						if ( curReservation.reservationInformation().get(0).get(Calendar.AM_PM) == Calendar.AM){
							ampm1 = "AM";
						}
						else{
							ampm1 = "PM";
						}
						if ( curReservation.reservationInformation().get(1).get(Calendar.AM_PM) == Calendar.AM){
							ampm2 = "AM";
						}
						else{
							ampm2 = "PM";
						}
							
						startTime.setText(hour1 + ":" + min1 + " " + ampm1);
						endTime.setText(hour2 + ":" + min2 + " " + ampm2);
						goToCard(PERSONALPANEL);
					}	
				}
				else{	//There is at least one reservation
					if (newStartTime.before(curReservation.reservationInformation().get(1)) && newEndTime.after(curReservation.reservationInformation().get(0))){
						//Overlap
						try {
							curReservation.changeReservation(newStartTime, newEndTime);
						} catch (SQLException e) {
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
					}
					else{
						//No overlap
						try {
							curReservation = new Reservation(curCustomer.getCustomerID(), -1, curCar.getCarID(), newStartTime, newEndTime);
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					String hour1, hour2;
					String min1, min2;
					hour1 = Integer.toString(curReservation.reservationInformation().get(0).get(Calendar.HOUR));
					hour2 = Integer.toString(curReservation.reservationInformation().get(1).get(Calendar.HOUR));
					min1 = Integer.toString(curReservation.reservationInformation().get(0).get(Calendar.MINUTE));
					if (min1.equals("0")){
						min1.concat("0");
					}
					min2 = Integer.toString(curReservation.reservationInformation().get(1).get(Calendar.MINUTE));
					if (min2.equals("0")){
						min2.concat("0");
					}
					startTime.setText(hour1 + ":" + min1);
					endTime.setText(hour2 + ":" + min2);
					goToCard(PERSONALPANEL);
				}              
			}
		});
	}
	public void makeWelcomeScreen(){
		welcomeCard.setLayout(new BoxLayout(welcomeCard, BoxLayout.Y_AXIS));

		JLabel title = new JLabel("<html><p>Welcome to Park-a-lot</p><html>",JLabel.CENTER);
		title.setFont(new Font("Dialog",1,28));
		title.setMinimumSize(new Dimension(800, 100));

		ImageIcon icon = new ImageIcon("C:\\Users\\Admin\\Pictures\\car.jpg");
		//icon.

		welcomeCard.add(title);
		welcomeCard.add(new JLabel(icon));

		//We need to get rid of this
		//JButton continueB = new JButton("Continue");
		/*continueB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				goToCard(LPPANEL);
				goToCard(MULTIPLEPANEL);
			}
		});
		welcomeCard.add(continueB);
		*/
	}
	public void makeMultiplePersonScreen(){
		multipleCard.setLayout(new BoxLayout(multipleCard, BoxLayout.Y_AXIS));
		multipleCard.add(new JLabel("There are multiple drivers associated with this vehicle. Are you:"));
		
		yB2.setEnabled(false);
			yB2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					// TODO get the number of the button selected
					//save to curCustomer
					//update fields
					goToCard(PERSONALPANEL);
				}
			});		
		multipleCard.add(yB2);
		
		imnothereB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				goToCard(REGIDPANEL);
			}
		});
		multipleCard.add(imnothereB);
	}
	public void createAndShowGUI() throws ClassNotFoundException, SQLException {
		JFrame entryFrame = new JFrame("Elevator Keypad");
		entryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		entryFrame.setLocation(100,100);
		entryFrame.setSize(800,600);

		//Create and set up the content pane.
		EnterInterface enterInterface = new EnterInterface();
		enterInterface.addComponentToPane(entryFrame.getContentPane());

		//Display the window.
		//entryFrame.pack();
		entryFrame.setVisible(true);
	}
}
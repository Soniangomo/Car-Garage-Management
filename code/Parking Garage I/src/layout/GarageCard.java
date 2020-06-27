//written by: Matthew Rodriguez
//assisted by: Richard Romanowksi
//debugged by: Matthew Rodriguez and Richard Romanowski

package layout;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import database.*;

import javax.swing.*;

import dataStructures.LotMonitor;

public class GarageCard implements ItemListener{
    JPanel cards; //a panel that uses CardLayout
    final static String FLOOR1 = "Floor #1";
    final static String FLOOR2 = "Floor #2";
    final static String FLOOR3 = "Floor #3";
    final static String FLOOR4 = "Floor #4";
    
    final static int maxGap=100;
	@SuppressWarnings("unused")
	private static final ArrayList<JButton> ArrayList = null;
	GridLayout experimentLayout = new GridLayout(0,6);

	 
    
    public void addComponentToPane(Container pane) throws SQLException {
        //Put the JComboBox in a JPanel to get a nicer look.
        JPanel comboBoxPane = new JPanel(); //use FlowLayout
        String comboBoxItems[] = { FLOOR1, FLOOR2, FLOOR3, FLOOR4 };
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);    	
        
        
        //Create the "cards".
        final JPanel card1 = new JPanel();
        card1.setLayout(experimentLayout);
        JPanel controls = new JPanel();
        controls.setLayout(new GridLayout(2,3));
        
        JButton b = new JButton("Just fake button");
        Dimension buttonSize = b.getPreferredSize();
        card1.setPreferredSize(new Dimension((int)(buttonSize.getWidth() * 2.5)+maxGap,
                (int)(buttonSize.getHeight() * 3.5)+maxGap * 2));
        
        ArrayList<JButton> parkingspaces = new ArrayList<JButton>();
        
        ArrayList<Integer> parkingCurrentLot = LotMonitor.currentStatusOfParkingSpaces();
        
        for (int i = 0; i <104; i++){
        	parkingspaces.add(new JButton("" +(i+1)));
            parkingspaces.get(i).setBackground(Color.green);
            if(parkingCurrentLot.get(i)>0){
                parkingspaces.get(i).setBackground(Color.red);
            }
            
        }
        
        ArrayList<JButton> emptyspaces = new ArrayList<JButton>();
        
        for (int j = 0; j < 100; j++){
        	emptyspaces.add(new JButton(""+j));
            emptyspaces.get(j);
            emptyspaces.get(j).setVisible(false);
            emptyspaces.get(j).setBackground(Color.green);
        }
        
        int j=0;
        card1.add(emptyspaces.get(j));j++;
        card1.add(parkingspaces.get(6));
        card1.add(parkingspaces.get(7));
        card1.add(parkingspaces.get(8));
        card1.add(parkingspaces.get(9));
        card1.add(emptyspaces.get(j));j++;
        card1.add(parkingspaces.get(5));
        card1.add(emptyspaces.get(j));j++;
        card1.add(emptyspaces.get(j));j++;
        card1.add(emptyspaces.get(j));j++;
        card1.add(emptyspaces.get(j));j++;
        card1.add(parkingspaces.get(10));
        card1.add(parkingspaces.get(4));
        card1.add(emptyspaces.get(j));j++;
        card1.add(parkingspaces.get(20));
        card1.add(parkingspaces.get(21));;
        card1.add(emptyspaces.get(j));j++;
        card1.add(parkingspaces.get(11));
        card1.add(parkingspaces.get(3));
        card1.add(emptyspaces.get(j));j++;
        card1.add(parkingspaces.get(19));
        card1.add(parkingspaces.get(22));
        card1.add(emptyspaces.get(j));j++;
        card1.add(parkingspaces.get(12));
        card1.add(parkingspaces.get(2));
        card1.add(emptyspaces.get(j));j++;
        card1.add(parkingspaces.get(18));
        card1.add(parkingspaces.get(23));
        card1.add(emptyspaces.get(j));j++;
        card1.add(parkingspaces.get(13));
        card1.add(parkingspaces.get(1));
        card1.add(emptyspaces.get(j));j++;
        card1.add(parkingspaces.get(17));
        card1.add(parkingspaces.get(24));
        card1.add(emptyspaces.get(j));j++;
        card1.add(parkingspaces.get(14));
        card1.add(parkingspaces.get(0));
        card1.add(emptyspaces.get(j));j++;
        card1.add(parkingspaces.get(16));
        card1.add(parkingspaces.get(25));
        card1.add(emptyspaces.get(j));j++;
        card1.add(parkingspaces.get(15));
        
        pane.add(card1, BorderLayout.NORTH);
        pane.add(new JSeparator(), BorderLayout.CENTER);
        pane.add(controls, BorderLayout.SOUTH);
        
        final JPanel card2 = new JPanel();
        card2.setLayout(experimentLayout);    
        card2.setPreferredSize(new Dimension((int)(buttonSize.getWidth() * 2.5)+maxGap,
                (int)(buttonSize.getHeight() * 3.5)+maxGap * 2));
        
        card2.add(emptyspaces.get(j));j++;
        card2.add(parkingspaces.get(32));
        card2.add(parkingspaces.get(33));
        card2.add(parkingspaces.get(34));
        card2.add(parkingspaces.get(35));
        card2.add(emptyspaces.get(j));j++;
        card2.add(parkingspaces.get(31));
        card2.add(emptyspaces.get(j));j++;
        card2.add(emptyspaces.get(j));j++;
        card2.add(emptyspaces.get(j));j++;
        card2.add(emptyspaces.get(j));j++;
        card2.add(parkingspaces.get(36));
        card2.add(parkingspaces.get(30));
        card2.add(emptyspaces.get(j));j++;
        card2.add(parkingspaces.get(46));
        card2.add(parkingspaces.get(47));
        card2.add(emptyspaces.get(j));j++;
        card2.add(parkingspaces.get(37));
        card2.add(parkingspaces.get(29));
        card2.add(emptyspaces.get(j));j++;
        card2.add(parkingspaces.get(45));
        card2.add(parkingspaces.get(48));
        card2.add(emptyspaces.get(j));j++;
        card2.add(parkingspaces.get(38));
        card2.add(parkingspaces.get(28));
        card2.add(emptyspaces.get(j));j++;
        card2.add(parkingspaces.get(44));
        card2.add(parkingspaces.get(49));
        card2.add(emptyspaces.get(j));j++;
        card2.add(parkingspaces.get(39));
        card2.add(parkingspaces.get(27));
        card2.add(emptyspaces.get(j));j++;
        card2.add(parkingspaces.get(43));
        card2.add(parkingspaces.get(50));
        card2.add(emptyspaces.get(j));j++;
        card2.add(parkingspaces.get(40));
        card2.add(parkingspaces.get(26));
        card2.add(emptyspaces.get(j));j++;
        card2.add(parkingspaces.get(42));
        card2.add(parkingspaces.get(51));
        card2.add(emptyspaces.get(j));j++;
        card2.add(parkingspaces.get(41));
        
        pane.add(card2, BorderLayout.NORTH);

        final JPanel card3 = new JPanel();
        card3.setLayout(experimentLayout);    
        card3.setPreferredSize(new Dimension((int)(buttonSize.getWidth() * 2.5)+maxGap,
                (int)(buttonSize.getHeight() * 3.5)+maxGap * 2));
        
        card3.add(emptyspaces.get(j));j++;
        card3.add(parkingspaces.get(58));
        card3.add(parkingspaces.get(59));
        card3.add(parkingspaces.get(60));
        card3.add(parkingspaces.get(61));
        card3.add(emptyspaces.get(j));j++;
        card3.add(parkingspaces.get(57));
        card3.add(emptyspaces.get(j));j++;
        card3.add(emptyspaces.get(j));j++;
        card3.add(emptyspaces.get(j));j++;
        card3.add(emptyspaces.get(j));j++;
        card3.add(parkingspaces.get(62));
        card3.add(parkingspaces.get(56));
        card3.add(emptyspaces.get(j));j++;
        card3.add(parkingspaces.get(72));
        card3.add(parkingspaces.get(73));
        card3.add(emptyspaces.get(j));j++;
        card3.add(parkingspaces.get(63));
        card3.add(parkingspaces.get(55));
        card3.add(emptyspaces.get(j));j++;
        card3.add(parkingspaces.get(71));
        card3.add(parkingspaces.get(74));
        card3.add(emptyspaces.get(j));j++;
        card3.add(parkingspaces.get(64));
        card3.add(parkingspaces.get(54));
        card3.add(emptyspaces.get(j));j++;
        card3.add(parkingspaces.get(70));
        card3.add(parkingspaces.get(75));
        card3.add(emptyspaces.get(j));j++;
        card3.add(parkingspaces.get(65));
        card3.add(parkingspaces.get(53));
        card3.add(emptyspaces.get(j));j++;
        card3.add(parkingspaces.get(69));
        card3.add(parkingspaces.get(76));
        card3.add(emptyspaces.get(j));j++;
        card3.add(parkingspaces.get(66));
        card3.add(parkingspaces.get(52));
        card3.add(emptyspaces.get(j));j++;
        card3.add(parkingspaces.get(68));
        card3.add(parkingspaces.get(77));
        card3.add(emptyspaces.get(j));j++;
        card3.add(parkingspaces.get(67));
        
        pane.add(card3, BorderLayout.NORTH);
        
        final JPanel card4 = new JPanel();
        card4.setLayout(experimentLayout);    
        card4.setPreferredSize(new Dimension((int)(buttonSize.getWidth() * 2.5)+maxGap,
                (int)(buttonSize.getHeight() * 3.5)+maxGap * 2));
        
        card4.add(emptyspaces.get(j));j++;
        card4.add(parkingspaces.get(84));
        card4.add(parkingspaces.get(85));
        card4.add(parkingspaces.get(86));
        card4.add(parkingspaces.get(87));
        card4.add(emptyspaces.get(j));j++;
        card4.add(parkingspaces.get(83));
        card4.add(emptyspaces.get(j));j++;
        card4.add(emptyspaces.get(j));j++;
        card4.add(emptyspaces.get(j));j++;
        card4.add(emptyspaces.get(j));j++;
        card4.add(parkingspaces.get(88));
        card4.add(parkingspaces.get(82));
        card4.add(emptyspaces.get(j));j++;
        card4.add(parkingspaces.get(98));
        card4.add(parkingspaces.get(99));
        card4.add(emptyspaces.get(j));j++;
        card4.add(parkingspaces.get(89));
        card4.add(parkingspaces.get(81));
        card4.add(emptyspaces.get(j));j++;
        card4.add(parkingspaces.get(97));
        card4.add(parkingspaces.get(100));
        card4.add(emptyspaces.get(j));j++;
        card4.add(parkingspaces.get(90));
        card4.add(parkingspaces.get(80));
        card4.add(emptyspaces.get(j));j++;
        card4.add(parkingspaces.get(96));
        card4.add(parkingspaces.get(101));
        card4.add(emptyspaces.get(j));j++;
        card4.add(parkingspaces.get(91));
        card4.add(parkingspaces.get(79));
        card4.add(emptyspaces.get(j));j++;
        card4.add(parkingspaces.get(95));
        card4.add(parkingspaces.get(102));
        card4.add(emptyspaces.get(j));j++;
        card4.add(parkingspaces.get(92));
        card4.add(parkingspaces.get(78));
        card4.add(emptyspaces.get(j));j++;
        card4.add(parkingspaces.get(94));
        card4.add(parkingspaces.get(103));
        card4.add(emptyspaces.get(j));j++;
        card4.add(parkingspaces.get(93));
        
        pane.add(card4, BorderLayout.NORTH);
        
        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card1, FLOOR1);
        cards.add(card2, FLOOR2);
        cards.add(card3, FLOOR3);
        cards.add(card4, FLOOR4);
        
        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }
    
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     * @throws SQLException 
     */
    private static void createAndShowGUI() throws SQLException {
        //Create and set up the window.
        JFrame frame = new JFrame("GarageCard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create and set up the content pane.
        GarageCard demo = new GarageCard();
        demo.addComponentToPane(frame.getContentPane());
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
    	Database.connectToDatabase();
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
					createAndShowGUI();
				} catch (SQLException e) {
					e.printStackTrace();
				}
            }
        });
    }
}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 
 * Partial implementation of the Stats GUI
 *
 * @author Romil Dhagat
 */
public class StatsGUI implements ActionListener {
	private JTextField inputField;
	private JTextArea display;
	private JButton reset, displayStats;
	// TODO: Add stats instance variable
	private Stats stats;

	public StatsGUI(String title) { 
		
		//TODO: Instantiate stats object
		stats = new Stats();
		
		JFrame jfrm = new JFrame(title);
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(300, 200);  
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel prompt = new JLabel("Next Grade (press ENTER)");
		jfrm.add(prompt);
		
		this.inputField = new JTextField(4); 
		this.inputField.setText("");
		this.inputField.addActionListener( this ); 
		jfrm.add(inputField);
		
		this.display = new JTextArea (5 ,20);
		jfrm.add(display);
		
		displayStats = new JButton("STATS");
		displayStats.addActionListener(this);
		jfrm.add(displayStats);

		reset = new JButton("RESET");
		reset.addActionListener(this);
		jfrm.add(reset);
		
		jfrm.setVisible(true);	
		
		
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == inputField) {
			int number = Integer.parseInt(inputField.getText());
			// TODO: ADD THE GRADE TO stats
			stats.add(number);
			this.display.setText("");
			
			this.display.append(stats.toString());
			
		} else if (e.getSource() == displayStats) {
		//TODO: Add handling of display button -  DISPLAY THE RESULTS
		stats.sort();
		this.display.append("\n" + stats.toString() + "\n");
		this.display.append("Mean: " + stats.getMean() + "\n");
		this.display.append("Median: " + stats.getMedian() + "\n");
		} else if (e.getSource() == reset) {
		// TODO: Add handling of reset button - CREATE A NEW stats
		stats = new Stats();
		display.setText("");
		inputField.setText("");
		}	

	}

	public static void main(String[] args) {
		//Starting the GUI application
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new StatsGUI("Grades statistics");
			}
		});
	}
}

import java.awt.*;
import java .awt. event .*;
import javax.swing.*; 

public class MonthGUI implements ActionListener{
	
	private JTextField inputField; 
	private JTextArea display;

	public MonthGUI(String title)  {
	
		JFrame jfrm = new JFrame(title);
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(450, 100 );  
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		JLabel prompt = new JLabel("Input a month between 1 and 12 and press return:");
		jfrm.add(prompt);
		
		inputField = new JTextField(2); 
		inputField.setText("0");
		inputField.addActionListener( this ); 
		jfrm.add(inputField);
		
		display = new JTextArea (1 ,30);
		jfrm.add(display);
		
		jfrm.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae)  { 
		if ( ae.getSource() == inputField) { 
			//TODO: convert user input to an integer
			int month = Integer.parseInt(inputField.getText());
			
			//TODO: update display with number chosen and days calculated
			display.append("There are " + Days.howManyDaysInMonth(month) + " days in month " + month + "\n");
			
		}
	}
	
	public static void main(String[] args) {
		
		//Starting the GUI application
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MonthGUI("Days of Months");
			}
		});

	}

}

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * @author Romil Dhagat
 * Creates a GUI for the user to input sentences that are analyzed and outputs the number of words and sentences 
 *
 */
public class TextAnalysisGUI implements ActionListener{
	
	private JTextArea inputTextArea; 
	private JTextArea outputTextArea;
	private JButton clear, analysis;
	private TextAnalyzer TextAnalyzer;

	
	public TextAnalysisGUI(String title) {
		
		TextAnalyzer = new TextAnalyzer("");
		
		JFrame jfrm = new JFrame(title);
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(800, 600);  
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        JPanel inputPanel = new JPanel(new BorderLayout());		
		JLabel inputLabel = new JLabel("Enter or copy text.");
		inputPanel.add(inputLabel, BorderLayout.NORTH);
		
		inputTextArea = new JTextArea(25, 60);
		JScrollPane inputScrollPane = new JScrollPane(inputTextArea);
	    inputPanel.add(inputScrollPane, BorderLayout.CENTER);
	    jfrm.add(inputPanel, BorderLayout.CENTER);
		this.inputTextArea.setText("");
		jfrm.add(inputPanel, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		analysis = new JButton("Analysis");
		analysis.addActionListener(this);
		buttonPanel.add(analysis);
		jfrm.add(analysis, BorderLayout.SOUTH);
		
		clear = new JButton("Clear");
		clear.addActionListener(this);
		buttonPanel.add(clear);
		jfrm.add(clear, BorderLayout.SOUTH);

		this.outputTextArea = new JTextArea (5 ,20);
		jfrm.add(outputTextArea, BorderLayout.CENTER);
		
		jfrm.setVisible(true);	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == analysis) { 
			
			String inputText = inputTextArea.getText();
			TextAnalyzer = new TextAnalyzer(inputText);
			outputTextArea.setText(TextAnalyzer.toString());
			
		} else if (e.getSource() == clear) {
			
			TextAnalyzer = new TextAnalyzer("");
            inputTextArea.setText("");
            outputTextArea.setText("");
            
		}
	}

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TextAnalysisGUI("Text Statistics");
			}
		});
	}
}
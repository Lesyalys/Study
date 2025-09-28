package java4;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;

public class form1 {
	public static void main(String s[]) {
		JFrame frame = new JFrame("FrameDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		header(frame);
		bodyBtn(frame);
		bodyCenter(frame);
		bodyRight(frame);
		sliderFooter(frame);
		
		frame.setVisible(true);
				
 }
	
	public static void header(JFrame frame) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,3));
		ArrayList <JTextField> listText = new ArrayList <JTextField>();
//		JTextField field = new JTextField();
		for (int i = 0; i < 6; i++) {			
			listText.add(new JTextField("Text field "+ (i+1)));
			panel.add(listText.get(i));
//			panel.add(field);
		}
		frame.add(panel,BorderLayout.NORTH);
	}
	
	public static void bodyBtn(JFrame frame) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(9,1));
		ArrayList <JCheckBox> listText = new ArrayList <JCheckBox>();
		for (int i = 0; i < 9; i++) {			
			listText.add(new JCheckBox("Btn "+i));
			panel.add(listText.get(i));
		}
		frame.add(panel,BorderLayout.WEST);
	}
	public static void bodyCenter(JFrame frame) {
		JPanel panel = new JPanel(new GridLayout(2,3));
		JSpinner spinner = new JSpinner ();
		JSpinner spinne2 = new JSpinner ();
		JRadioButton rbBtn = new JRadioButton ();
		JRadioButton rbBtn2 = new JRadioButton ();
		panel.add(spinner);
		panel.add(spinne2);
		panel.add(rbBtn);
		
		panel.add(new JLabel());
		panel.add(rbBtn2,BorderLayout.CENTER);
		panel.add(new JLabel());
		frame.add(panel,BorderLayout.CENTER);
	}
	
	 public static void bodyRight(JFrame frame) {
	        JPanel panel = new JPanel(new BorderLayout());
	        JTextArea textArea = new JTextArea(10, 15); 
	        JScrollPane scrollPane = new JScrollPane(textArea);
	        panel.add(scrollPane, BorderLayout.CENTER);
	        frame.add(panel, BorderLayout.EAST);
	    }
	
	public static void sliderFooter(JFrame frame) {
		JPanel panel = new JPanel(new BorderLayout());
		JSlider slider = new JSlider();
		panel.add(slider);
		frame.add(panel,BorderLayout.SOUTH);
	}
}

package java4;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;

public class form2 {
	public static void main(String s[]) {
		JFrame frame = new JFrame("FrameDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		header(frame);
		bodyBtn(frame);
		bodyCenter(frame);
		bodyRight(frame);
		footer(frame);
		
		frame.setVisible(true);
				
 }
	
	public static void header(JFrame frame) {
	    JPanel panel = new JPanel(new BorderLayout());
	    
	    JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    for (int i = 1; i <= 3; i++) {            
	        leftPanel.add(new JLabel("Text field " + i));
	    }
	    
	    JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	    for (int i = 4; i <= 6; i++) {            
	        rightPanel.add(new JLabel("Text field " + i));
	    }
	    
	    panel.add(leftPanel, BorderLayout.WEST);
	    panel.add(rightPanel, BorderLayout.EAST);
	    
	    frame.add(panel, BorderLayout.NORTH);
	}
	
	public static void bodyBtn(JFrame frame) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(9,1,0,5));
		ArrayList <JButton> listText = new ArrayList <JButton>();
		for (int i = 0; i < 9; i++) {			
			listText.add(new JButton("Btn "+ (i+1)));
			panel.add(listText.get(i));
		}
		frame.add(panel,BorderLayout.WEST);
	}
	
	public static void bodyCenter(JFrame frame) {
	    JPanel panel = new JPanel(new BorderLayout());
	    JPanel panelr = new JPanel(new  FlowLayout(FlowLayout.RIGHT));
	    JPanel panell = new JPanel(new  FlowLayout(FlowLayout.LEFT));
	    JTextField textField = new JTextField();
	    
	    textField.setPreferredSize(new Dimension(400, 150));
	     
	    JButton btn1 = new JButton("btn1");
	    JButton btn2 = new JButton("btn2");
	    
	    panel.add(textField, BorderLayout.NORTH);
	    
	    JPanel buttonPanel = new JPanel(new FlowLayout());
	    panelr.add(btn1);
	    panell.add(btn2);
	    buttonPanel.add(panelr);
	    buttonPanel.add(panell);
	    
	    panelr.add(Box.createHorizontalStrut(80));
	    panel.add(buttonPanel, BorderLayout.CENTER);
	    
	    frame.add(panel, BorderLayout.CENTER);
	}
	
	 public static void bodyRight(JFrame frame) {
		 JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(9,1));
			ArrayList <JRadioButton> listText = new ArrayList <JRadioButton>();
			for (int i = 0; i < 9; i++) {			
				listText.add(new JRadioButton("Btn "+ (i+1)));
				panel.add(listText.get(i));
			}
	        frame.add(panel, BorderLayout.EAST);
	    }
	
	public static void footer(JFrame frame) {
		JPanel panel = new JPanel(new BorderLayout());
		JButton btn = new JButton("btn");
		JEditorPane htmlPane = new JEditorPane("text/html", "<input type='password'></input>");
		
		JPanel rigtPanel = new JPanel(new  FlowLayout(FlowLayout.RIGHT));
		rigtPanel.add(htmlPane);
		rigtPanel.add(btn);
		panel.add(rigtPanel);
		frame.add(panel,BorderLayout.SOUTH);
	}
}

package java4;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;

public class form4 {
	public static void main(String s[]) {
		JFrame frame = new JFrame("FrameDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		header(frame);
//		underHeader(frame);
//		bodyBtn(frame);
		bodyCenter(frame);
		bodyRight(frame);
//		footer(frame);
		
		frame.setVisible(true);
				
 }
	
	public static void header(JFrame frame) {
	    JPanel panel = new JPanel(new GridLayout(2,1));
	    JPanel topPanel = new JPanel(new BorderLayout());
	    JPanel panelr = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	    JPanel panell = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    JSlider slider = new JSlider();
	    JLabel label1 = new JLabel("label1");
	    JLabel label2 = new JLabel("label2");
	    JTextField textField = new JTextField();
	    
//	    panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	    
	    panelr.add(label1);
	    panell.add(label2);
	    
	    topPanel.add(panelr, BorderLayout.EAST);  
	    topPanel.add(panell, BorderLayout.WEST);   
	    
	    JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    centerPanel.add(slider);
	    topPanel.add(centerPanel, BorderLayout.CENTER);
	    
	    panel.add(topPanel, BorderLayout.CENTER);
	    panel.add(textField, BorderLayout.CENTER); 
	    
	    frame.add(panel, BorderLayout.NORTH);
	}

	
	public static void bodyCenter(JFrame frame) {
		JPanel panel = new JPanel(new GridLayout(4, 3, 10, 10));
//		JButton btn = new JButton();
		ArrayList<JButton> btnList = new ArrayList<JButton>();
		for (int i = 1; i <= 9; i++) {
			btnList.add(new JButton(""+i));
			panel.add(btnList.get(i-1));
		}
		 panel.add(new JPanel());
		btnList.add(new JButton("0"));
	    panel.add(btnList.get(9));
	    panel.add(new JPanel());
	    
		
		frame.add(panel,BorderLayout.WEST);
	}
	
	 public static void bodyRight(JFrame frame) {
		 JPanel panel = new JPanel(new GridLayout(4, 3, 10, 10));
			panel.setLayout(new GridLayout(9,1));
			JButton btn1 = new JButton("+");
			JButton btn2 = new JButton("-");
			JButton btn3 = new JButton("=");
			panel.add(btn1);
			panel.add(btn2);
			panel.add(btn3);
	        frame.add(panel, BorderLayout.EAST);
	    }
	
}

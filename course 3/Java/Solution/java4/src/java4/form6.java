package java4;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;

public class form6 {
	public static void main(String s[]) {
		JFrame frame = new JFrame("FrameDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		header(frame);
		bodyRight(frame);
		footer(frame);
		
		frame.setVisible(true);
				
 }
	
	public static void header(JFrame frame) {
	    JPanel panel = new JPanel(); // 2 строки, 1 столбец
	    
	    JTextField textL = new JTextField();
	    
	    panel.add(textL);

	    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	    panel.add(buttonPanel);
	    
	    frame.add(panel, BorderLayout.WEST);
	}

	
	 public static void bodyRight(JFrame frame) {
		 JPanel panel = new JPanel(new GridLayout(5, 3));
		 for (int i =0; i <= 15; i++) {
			 if (i % 2 != 0) {
				 JTextField tfild = new JTextField();
				 panel.add(tfild);
			 } else {
				 JButton btns = new JButton("btn"+i);
				 panel.add(btns);
			 }
		 }
		    
			
			frame.add(panel,BorderLayout.CENTER);
	    }
	 
	 public static void footer(JFrame frame) {
			JPanel panel = new JPanel(new BorderLayout());
			JLabel jp = new JLabel("label");
			panel.add(jp,BorderLayout.CENTER);
			frame.add(panel,BorderLayout.SOUTH);
		}
	

}
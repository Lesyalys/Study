package java4;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;

public class form2 {
	private static JTextField textField = new JTextField();
	public static void main(String s[]) {
		JFrame frame = new JFrame("💖 Lesya Valentyukevich 3312 💖");
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
//		JPanel panel = new JPanel();
		Box panelr = new Box(BoxLayout.Y_AXIS);
		 ActionListener enterNum = new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 JButton source = (JButton) e.getSource();
				 String buttonText = source.getText();
				 
				 String text = textField.getText();
				 textField.setText(text + buttonText);
			 }
		 };
//		 panelr.setLayout(new GridLayout(9,1,0,5));
		ArrayList <JButton> listText = new ArrayList <JButton>();
		for (int i = 0; i < 9; i++) {			
			listText.add(new JButton("Btn "+ (i+1)));
			if (i != 0) panelr.add(Box.createVerticalGlue());
			listText.get(i).addActionListener(enterNum);
			panelr.add(listText.get(i));
		}
		frame.add(panelr,BorderLayout.WEST);
	}
	
	public static void bodyCenter(JFrame frame) {
	    JPanel panel = new JPanel(new GridLayout(2,1));
	    JPanel panel2 = new JPanel(new BorderLayout());
	    Box panelr = new Box(BoxLayout.X_AXIS);
	    textField = new JTextField();
	    
	    textField.setPreferredSize(new Dimension(400, 150));
	     
	    JButton btn1 = new JButton("btn1");
	    JButton btn2 = new JButton("btn2");
	    btn1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		textField.setText("this btn1");
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		textField.setText("");
        	}
        });
	    btn2.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		textField.setText("this btn2");
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		textField.setText("");
        	}
        });
	    
	    panel.add(textField);
//	    panelr.add(textField);
	    
	    JPanel buttonPanel = new JPanel(new FlowLayout());
	    
	    panelr.add(btn1);
	    panelr.add(Box.createRigidArea(new Dimension(100,0)));
	    panelr.add(btn2);
	    buttonPanel.add(panelr);
	    panel2.add(buttonPanel,BorderLayout.NORTH);
//	    all.add(buttonPanel);
	    panel.add(panel2);

	    
	    frame.add(panel, BorderLayout.CENTER);
	}
	
	 public static void bodyRight(JFrame frame) {
//		 JPanel panel = new JPanel();
		 Box panelr = new Box(BoxLayout.Y_AXIS);
		 ActionListener clearTextListener = new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	textField.setText(""); 
	            }
	        };
//			panel.setLayout(new GridLayout(9,1));
			ArrayList <JRadioButton> listText = new ArrayList <JRadioButton>();
			for (int i = 0; i < 9; i++) {			
				listText.add(new JRadioButton("Btn "+ (i+1)));
				if (i != 0) panelr.add(Box.createVerticalGlue());
				listText.get(i).addActionListener(clearTextListener);
				panelr.add(listText.get(i));
			}
	        frame.add(panelr, BorderLayout.EAST);
	    }
	
	 public static void footer(JFrame frame) {
		    JPanel panel = new JPanel(new BorderLayout());
		    JButton btn = new JButton("btn");
		    
		    JPasswordField passwordField = new JPasswordField(15);
		    passwordField.setEchoChar('♡');
		    
		    btn.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		            if (passwordField.getEchoChar() == '♡') {
		                passwordField.setEchoChar((char)0);
		            } else {
		                passwordField.setEchoChar('♡');
		            }
		        }
		    });
		    
		    JPanel rigtPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		    rigtPanel.add(passwordField);
		    rigtPanel.add(btn);
		    panel.add(rigtPanel);
		    frame.add(panel, BorderLayout.SOUTH);
		}
}

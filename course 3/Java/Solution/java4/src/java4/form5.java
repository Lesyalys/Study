package java4;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;

public class form5 {
	private static JTextField textL;
	public static void main(String s[]) {
		JFrame frame = new JFrame("FrameDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,500);
		header(frame);
		bodyRight(frame);
		
		frame.setVisible(true);
				
 }
	
	public static void header(JFrame frame) {
	    JPanel panel = new JPanel(new GridLayout(2, 1)); // 2 строки, 1 столбец
	    
	    textL = new JTextField();
	    JButton btn = new JButton("Button 1");
	    JButton btn2 = new JButton("Menu");
	    JButton btn3 = new JButton("Button 3");
	    
	    ActionListener clearTextListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textL.setText(""); 
            }
        };
        btn.addActionListener(clearTextListener);
        btn3.addActionListener(clearTextListener);
        btn2.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		textL.setText("this menu btn");
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		textL.setText("");
        	}
        });
	    
	    panel.add(textL);

	    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    buttonPanel.add(btn);
	    buttonPanel.add(btn2);
	    buttonPanel.add(btn3);
	    panel.add(buttonPanel);
	    
	    frame.add(panel, BorderLayout.NORTH);
	}

	
	 public static void bodyRight(JFrame frame) {
		 JPanel panel = new JPanel(new GridLayout(4, 3));
		 
		 ActionListener enterNum = new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 JButton source = (JButton) e.getSource();
				 String buttonText = source.getText();
				 
				 String text = textL.getText();
				 textL.setText(text + buttonText);
			 }
		 };
		 String[] Buttons = {
				 "1", "2 ABC", "3 DEF",
			        "4 GHI", "5 JKL", "6 MNO", 
			        "7 PQRS", "8 TUV", "9 WXZY",
			        "*", "0", "#"
		 };
		 for (String btn : Buttons) {
			 JButton btns = new JButton(btn);
			 btns.addActionListener(enterNum);
			 panel.add(btns);
		 }
		    
			
			frame.add(panel,BorderLayout.CENTER);
	    }
	

}
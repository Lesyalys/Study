package java7;

import javax.swing.*;
import java.awt.*;
public class main {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(700,700);
		header(frame);
		home(frame);
		
		frame.setVisible(true);

	}
	public static void header(JFrame frame) {
		JPanel panel = new JPanel(new BorderLayout());
		JTextField text = new JTextField();
		panel.add(text);
		
		frame.add(panel, BorderLayout.NORTH);
	}
	
	public static void home(JFrame frame) {
		JPanel panel = new JPanel(new BorderLayout());
		Box box = new Box(BoxLayout.Y_AXIS);
		Box box2 = new Box(BoxLayout.X_AXIS);
		JTextField text = new JTextField();
		for(int i=0;i<3;i++) {
			box2.add(new JButton("btn"+(i+1)));
		}
		box.add(text,BorderLayout.SOUTH);
		box.add(box2,BorderLayout.WEST);
		panel.add(box);
		
		frame.add(panel);
		
	}

}

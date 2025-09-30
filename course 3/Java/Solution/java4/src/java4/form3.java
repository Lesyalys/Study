package java4;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;

public class form3 {
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
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 4, 10, 15));
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 0));
		ArrayList <JLabel> listText = new ArrayList <JLabel>();
		for (int i = 0; i < 7; i++) {			
			listText.add(new JLabel("Text field "+ i));
			panel.add(listText.get(i));
		}
		frame.add(panel,BorderLayout.NORTH);
	}
	
	public static void bodyBtn(JFrame frame) {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 0));
	    JSlider slider = new JSlider(JSlider.VERTICAL);
	    panel.add(slider);
//	    frame.add(panel);
	    
		frame.add(panel,BorderLayout.WEST);
	}
	
	public static void bodyCenter(JFrame frame) {
	    JPanel panel = new JPanel(new BorderLayout());
//	    JFileChooser path = new JFileChooser();
	    JTree path = new JTree();
	    panel.add(path);
	    frame.add(panel, BorderLayout.CENTER);
	}
	
	 public static void bodyRight(JFrame frame) {
		 JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(8,1));
			ArrayList <JTextField> listText = new ArrayList <JTextField>();
			for (int i = 0; i < 8; i++) {			
				listText.add(new JTextField("Text field "+ (i+1)));
				panel.add(listText.get(i));
			}
	        frame.add(panel, BorderLayout.EAST);
	    }
	
	public static void footer(JFrame frame) {
		JPanel panel = new JPanel();
//		panel.setLayout(new GridLayout(1, 4, 10, 0));
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); 
		JCheckBox  btnCheck = new JCheckBox ("Chenge 1");
		JRadioButton btnRadio = new JRadioButton("Chenge 2");
		JButton btn = new JButton("btn");
		JEditorPane htmlPane = new JEditorPane("text/html", "<input type='text'></input>");
		
//		JPanel rigtPanel = new JPanel(new  FlowLayout(FlowLayout.RIGHT));

		panel.add(btnCheck);
		panel.add(btnRadio);
		panel.add(btn);
		panel.add(htmlPane);
		frame.add(panel,BorderLayout.SOUTH);
	}
}

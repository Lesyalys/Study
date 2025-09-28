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
		bodyBtn(frame);
		bodyCenter(frame);
		bodyRight(frame);
		footer(frame);
		
		frame.setVisible(true);
				
 }
	
	public static void header(JFrame frame) {
	    JPanel panel = new JPanel(new BorderLayout());
	    JPanel panelr = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	    JPanel panell = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    JSlider slider = new JSlider();
	    JLabel label1 = new JLabel("label1");
	    JLabel label2 = new JLabel("label2");
	    
	    panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	    
	    panelr.add(label1);
	    panell.add(label2);
	    
	    panel.add(panelr, BorderLayout.EAST);  
	    panel.add(slider, BorderLayout.CENTER); 
	    panel.add(panell, BorderLayout.WEST);   
	    
	    frame.add(panel, BorderLayout.NORTH);
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
			panel.setLayout(new GridLayout(9,1));
			ArrayList <JTextField> listText = new ArrayList <JTextField>();
			for (int i = 0; i < 9; i++) {			
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

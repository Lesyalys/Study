package java6;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.*;


public class graphic {

	public static void main(String s[]) {
		JFrame frame = new JFrame("💖 Lesya Valentyukevich 3312 💖");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(700,700);
		
		menu(frame);
		frame.setVisible(true);
	}
	
	public static void menu(JFrame frame) {
		JMenuBar menuBar = new JMenuBar();
		JMyPanel panel = new JMyPanel();
		frame.add(panel,BorderLayout.CENTER);
		String[][] mname = {
			    {"LINE", "| LINE |"},
			    {"OVAL", "⊂ OVAL ⊃"},
			    {"RECT", "⌜ RECT ⌝"},
			    {"ROUNDRECT", "◜ROUNDRECT◝"},
			    {"MYLASTNAME", "⁎ MYLASTNAME ⁎"},
			    {"CLEAR", "↻ CLEAR ↺"}
			};
		for (String[] i : mname) {
			JMenuItem item = new JMenuItem(i[1]);
			item.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent  e) {
					panel.ris(i[0]);
					}
				});
			menuBar.add(item);
		}

		frame.setJMenuBar(menuBar);
		
	}
}

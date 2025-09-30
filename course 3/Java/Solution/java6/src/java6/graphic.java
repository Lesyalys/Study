package java6;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.*;
import javax.swing.JPanel;


public class graphic {
	
	public class JMyPanel extends JPanel{
		public static enum Figure{LINE,OVAL,RECT,ROUNDRECT,CLEAR}
		private Figure vibor=Figure.CLEAR;
		public JMyPanel() { } 
		public void ris(String s) {//метод, вызов которого приводит к перерисовке панели
			//параметр s принимает значение во время вызова данного метода (см. MyGraph.java)
			vibor=Figure.valueOf(s); //устанавливаем, что нужно нарисовать
			repaint(); //перерисовываем нашу панель, т.е. вызываем метод paintComponent
			 }
	}
	
	public static void main(String s[]) {
		JFrame frame = new JFrame("💖 Lesya Valentyukevich 3312💖");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setVisible(true);
		
		menu(frame);
	}
	
	public static void menu(JFrame frame) {
		JMenuBar menus = new JMenuBar();
		ArrayList <JMenu> listMneu = new ArrayList <JMenu>();
		for (int i =0; i < 3; i++) {
			listMneu.add(new JMenu("Menu"+(i+1)));
			menus.add(listMneu.get(i));
		}
		frame.add(menus);
	}
}

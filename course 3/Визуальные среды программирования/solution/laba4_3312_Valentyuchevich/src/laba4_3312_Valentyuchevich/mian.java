package laba4_3312_Valentyuchevich;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class mian {

	public static void main(String[] args) {
		JFrame fr=new JFrame("Вращение треугольника вокруг своего центра тяжести");
		fr.setPreferredSize( new Dimension(300,300));
		final JPanel pan= new JPanel();
		fr.add(pan);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.pack();
		
		Timer tm= new Timer(500, new ActionListener(){
		int i=0;
		@Override
		public void actionPerformed(ActionEvent arg0) {
		Graphics2D gr=(Graphics2D)pan.getRootPane().getGraphics();
		pan.update(gr);
		GeneralPath path=new GeneralPath();
		path.append(new Polygon(new int []{60,-80,50},new int[]{-60,-50,40},3),true);
		int x=(60-80+50)/3,y=(-60-50+40)/3;
		gr.translate(150, 150);
		AffineTransform tranforms = AffineTransform.getRotateInstance((i++)*0.07, x, y);
		gr.transform(tranforms);
		gr.draw(path);
		}});
		tm.start();

	}

}

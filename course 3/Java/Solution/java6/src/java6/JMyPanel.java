package java6;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;


	public class JMyPanel extends JPanel{
		
			public static enum Figure{LINE,OVAL,RECT,ROUNDRECT,MYLASTNAME,CLEAR}
			private Figure vibor=Figure.MYLASTNAME;
			
			public JMyPanel() { 
				setBackground(Color.BLACK);
			} 	
			public void ris(String s) {
				vibor=Figure.valueOf(s); 
				repaint();
				 }
			
			@Override
			protected void paintComponent(Graphics  g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D ) g;
				switch(vibor) {
				case LINE:
					GradientPaint g0 = new GradientPaint(50,50,Color.CYAN,getWidth(), getHeight(), Color.MAGENTA);
	                g2d.setPaint(g0);
	                g2d.setStroke(new BasicStroke(5));
					g2d.drawLine(50, 50, getWidth() - 50, getHeight() - 50);
	                break;
	            case OVAL:
	        		GradientPaint g1 = new GradientPaint(50,50,Color.PINK,getWidth(), getHeight(), Color.CYAN);
	                g2d.setPaint(g1);
	                g2d.fillOval(50, 50, getWidth() - 100, getHeight() - 100);
	                break;
	            case RECT:
	            	GradientPaint g3 = new GradientPaint(50,50,Color.GREEN,getWidth(), getHeight(), Color.YELLOW);
	                g2d.setPaint(g3);
	                g2d.fillRect(50, 50, getWidth() - 100, getHeight() - 100);
	                break;
	            case ROUNDRECT:
	            	GradientPaint g5 = new GradientPaint(50,50,Color.CYAN,getWidth(), getHeight(), Color.MAGENTA);
	                g2d.setPaint(g5);
	                g2d.setStroke(new BasicStroke(10));
	                g2d.drawRoundRect(50, 50, getWidth() - 100, getHeight() - 100, 30, 30);
	                break;
	            case MYLASTNAME:
	            	g2d.setColor(Color.MAGENTA);
	                int x = 50; 
	                
	                // V
	                g2d.setStroke(new BasicStroke(5));
	                g2d.drawLine(x, 50, x+10, 100);
	                g2d.setStroke(new BasicStroke(1));
	                g2d.drawLine(x+10, 100, x+20, 50);
	                x += 25;
	                
	                // A
	                
	                g2d.setStroke(new BasicStroke(5));
	                g2d.drawLine(x, 100, x+10, 50);
	                g2d.setStroke(new BasicStroke(1));
	                g2d.drawLine(x+10, 50, x+20, 100);
	                g2d.drawLine(x+5, 75, x+15, 75);
	                x += 25;
	                
	                // L

	                g2d.setStroke(new BasicStroke(5));
	                g2d.drawLine(x, 50, x, 100);
	                g2d.setStroke(new BasicStroke(1));
	                g2d.drawLine(x, 100, x+15, 100);
	                x += 20;
	                
	                // E
	                
	                g2d.setStroke(new BasicStroke(5));
	                g2d.drawLine(x, 50, x, 100);
	                g2d.setStroke(new BasicStroke(1));
	                g2d.drawLine(x, 50, x+15, 50);
	                g2d.drawLine(x, 75, x+12, 75);
	                g2d.drawLine(x, 100, x+15, 100);
	                x += 20;
	                
	                // N
	                
	                g2d.setStroke(new BasicStroke(5));
	                g2d.drawLine(x, 50, x, 100);
	                g2d.setStroke(new BasicStroke(1));
	                g2d.drawLine(x, 50, x+15, 100);
	                g2d.drawLine(x+15, 50, x+15, 100);
	                x += 20;
	                
	                // T
	                
	                g2d.setStroke(new BasicStroke(5));
	                g2d.drawLine(x, 50, x+15, 50);
	                g2d.drawLine(x+7, 50, x+7, 100);
	                x += 20;
	                
	                // Y
	                
	                g2d.drawLine(x, 50, x+7, 75);
	                g2d.setStroke(new BasicStroke(1));
	                g2d.drawLine(x+14, 50, x+7, 75);
	                g2d.setStroke(new BasicStroke(5));
	                g2d.drawLine(x+7, 75, x+7, 100);
	                x += 20;
	                
	                // U
	                
	                g2d.setStroke(new BasicStroke(5));
	                g2d.drawLine(x, 50, x, 85);
	                g2d.setStroke(new BasicStroke(1));
	                g2d.drawLine(x+15, 50, x+15, 85);
	                g2d.drawArc(x, 75, 15, 20, 180, 180);
	                x += 20;
	                
	                // K
	                
	                g2d.setStroke(new BasicStroke(5));
	                g2d.drawLine(x, 50, x, 100);
	                g2d.setStroke(new BasicStroke(1));
	                g2d.drawLine(x, 75, x+12, 50);
	                g2d.drawLine(x, 75, x+12, 100);
	                x += 17;
	                
	                // E
	                
	                g2d.setStroke(new BasicStroke(5));
	                g2d.drawLine(x, 50, x, 100);
	                g2d.setStroke(new BasicStroke(1));
	                g2d.drawLine(x, 50, x+12, 50);
	                g2d.drawLine(x, 75, x+10, 75);
	                g2d.drawLine(x, 100, x+12, 100);
	                x += 17;
	                
	                // V
	                
	                g2d.setStroke(new BasicStroke(5));
	                g2d.drawLine(x, 50, x+7, 100);
	                g2d.setStroke(new BasicStroke(1));
	                g2d.drawLine(x+7, 100, x+14, 50);
	                x += 19;
	                
	                // I
	                
	                g2d.drawLine(x, 50, x, 100);
	                x += 10;
	                
	                // C
	                
	                g2d.setStroke(new BasicStroke(1));
	                g2d.drawArc(x, 50, 15, 50, 60, 240);
	                x += 20;
	                
	                // H
	                
	                g2d.setStroke(new BasicStroke(5));
	                g2d.drawLine(x, 50, x, 100);
	                g2d.setStroke(new BasicStroke(1));
	                g2d.drawLine(x+15, 50, x+15, 100);
	                g2d.drawLine(x, 75, x+15, 75);
	                
	                break;
				case CLEAR:
					
					break;
				
				}
			}

		}



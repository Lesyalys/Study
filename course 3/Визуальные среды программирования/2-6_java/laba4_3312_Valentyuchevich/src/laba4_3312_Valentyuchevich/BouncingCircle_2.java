package laba4_3312_Valentyuchevich;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class BouncingCircle_2 extends JPanel implements Runnable {
    private Thread animationThread;
    private Random random;
    
    // Параметры окружности
    private int circleX, circleY;          // текущие координаты центра
    private int circleRadius = 30;         // радиус окружности
    private int baseRadius = 30;           // базовый радиус (без сжатия)
    private int dx = 3, dy = 2;            // скорость движения
    private Color circleColor;
    
    // Параметры для эффекта сжатия
    private boolean isCompressing = false;
    private int compressionFrames = 0;
    private final int MAX_COMPRESSION_FRAMES = 10;
    private double compressionRatio = 1.0;
    
    // Размеры панели
    private final int PANEL_WIDTH = 800;
    private final int PANEL_HEIGHT = 600;

    public BouncingCircle_2() {
        random = new Random();
       
        circleX = PANEL_WIDTH / 2;
        circleY = PANEL_HEIGHT / 2;

        circleColor = new Color(
            random.nextInt(200) + 55,
            random.nextInt(200) + 55,
            random.nextInt(200) + 55
        );

        dx = random.nextInt(5) + 2;
        dy = random.nextInt(5) + 2;
        if (random.nextBoolean()) dx = -dx;
        if (random.nextBoolean()) dy = -dy;
        
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                circleColor = new Color(
                    random.nextInt(200) + 55,
                    random.nextInt(200) + 55,
                    random.nextInt(200) + 55
                );
            }
        });
    }

    public void start() {
        if (animationThread == null) {
            animationThread = new Thread(this);
            animationThread.start();
        }
    }

    public void stop() {
        if (animationThread != null) {
            animationThread = null;
        }
    }

    public void run() {
        while (Thread.currentThread() == animationThread) {
            updateCircle();
            repaint();
            try {
                Thread.sleep(20); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateCircle() {
        int width = getWidth() > 0 ? getWidth() : PANEL_WIDTH;
        int height = getHeight() > 0 ? getHeight() : PANEL_HEIGHT;
        
        circleX += dx;
        circleY += dy;
        
        if (circleX - circleRadius <= 0) {
            circleX = circleRadius; 
            dx = -dx; 
            startCompression(true); 
        } else if (circleX + circleRadius >= width) {
            circleX = width - circleRadius; 
            dx = -dx; 
            startCompression(true); 
        }
        
        if (circleY - circleRadius <= 0) {
            circleY = circleRadius;
            dy = -dy; 
            startCompression(false);
        } else if (circleY + circleRadius >= height) {
            circleY = height - circleRadius;
            dy = -dy; 
            startCompression(false); 
        }
        
        updateCompression();
    }
    
    private void startCompression(boolean horizontal) {
        isCompressing = true;
        compressionFrames = 0;
    }
    
    private void updateCompression() {
        if (isCompressing) {
            compressionFrames++;
            
            if (compressionFrames <= MAX_COMPRESSION_FRAMES / 2) {
                compressionRatio = 1.0 - (0.3 * compressionFrames / (MAX_COMPRESSION_FRAMES / 2.0));
            } else if (compressionFrames <= MAX_COMPRESSION_FRAMES) {
                compressionRatio = 0.7 + (0.3 * (compressionFrames - MAX_COMPRESSION_FRAMES / 2) / (MAX_COMPRESSION_FRAMES / 2.0));
            } else {
                isCompressing = false;
                compressionRatio = 1.0;
            }
            
            circleRadius = (int)(baseRadius * compressionRatio);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawCircle(g);
        drawInfo(g);
    }
    
    private void drawCircle(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2d.setColor(circleColor);
        g2d.fillOval(circleX - circleRadius, circleY - circleRadius, 
                     circleRadius * 2, circleRadius * 2);
        
        g2d.setColor(Color.WHITE);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawOval(circleX - circleRadius, circleY - circleRadius, 
                     circleRadius * 2, circleRadius * 2);
        
        g2d.setColor(Color.YELLOW);
        g2d.fillOval(circleX - 3, circleY - 3, 6, 6);
    }
    
    private void drawInfo(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 12));
        
        int width = getWidth() > 0 ? getWidth() : PANEL_WIDTH;
        int height = getHeight() > 0 ? getHeight() : PANEL_HEIGHT;
        
        String info = String.format("Position: (%d, %d) | Speed: (%d, %d) | Radius: %d", 
                                   circleX, circleY, dx, dy, circleRadius);
        g.drawString(info, 10, 20);
        
        String instructions = "Click to change color";
        g.drawString(instructions, 10, height - 10);
        
        g.setColor(Color.GRAY);
        g.drawRect(0, 0, width - 1, height - 1);
    }

    @Override
    public void addNotify() {
        super.addNotify();
        int width = getWidth();
        int height = getHeight();
        if (width > 0 && height > 0) {
            circleX = Math.min(circleX, width - circleRadius);
            circleY = Math.min(circleY, height - circleRadius);
        }
    }
}
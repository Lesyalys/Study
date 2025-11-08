package laba4_3312_Valentyuchevich;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class RotatingLine_4 extends JPanel implements Runnable {
    private Thread animationThread;
    private Random random;
    
    private int centerX, centerY;    // точка вращения (центр)
    private int endX, endY;          // конечная точка
    private int lineLength = 150;    // длина отрезка
    private double angle = 0;        // текущий угол в радианах
    private double rotationSpeed = 0.05; // скорость вращения
    
    private Color currentColor;
    private Color[] colors = {
        Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
        Color.CYAN, Color.BLUE, Color.MAGENTA, Color.PINK
    };
    private int colorIndex = 0;
    private int colorChangeCounter = 0;
    private final int COLOR_CHANGE_INTERVAL = 5; // смена цвета каждые N кадров
    
    private final int PANEL_WIDTH = 800;
    private final int PANEL_HEIGHT = 600;

    public RotatingLine_4() {
        random = new Random();
        
        centerX = PANEL_WIDTH / 2;
        centerY = PANEL_HEIGHT / 2;
        updateEndPoint();
    
        currentColor = colors[0];
        
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
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
            updateRotation();
            repaint();
            try {
                Thread.sleep(30); // ~33 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateRotation() {
        angle += rotationSpeed;
        if (angle > 2 * Math.PI) {
            angle -= 2 * Math.PI;
        }

        updateEndPoint();

        updateColor();
    }
    
    private void updateEndPoint() {
        int width = getWidth() > 0 ? getWidth() : PANEL_WIDTH;
        int height = getHeight() > 0 ? getHeight() : PANEL_HEIGHT;
        
        centerX = Math.max(lineLength, Math.min(width - lineLength, centerX));
        centerY = Math.max(lineLength, Math.min(height - lineLength, centerY));
        
        endX = centerX + (int)(lineLength * Math.cos(angle));
        endY = centerY + (int)(lineLength * Math.sin(angle));
    }
    
    private void updateColor() {
        colorChangeCounter++;
        if (colorChangeCounter >= COLOR_CHANGE_INTERVAL) {
            colorChangeCounter = 0;
            colorIndex = (colorIndex + 1) % colors.length;
            currentColor = colors[colorIndex];
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawLine(g);
        drawInfo(g);
    }
    
    private void drawLine(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(currentColor);
        g2d.setStroke(new BasicStroke(3)); 
        g2d.drawLine(centerX, centerY, endX, endY);
 
        g2d.setColor(Color.RED);
        g2d.fillOval(centerX - 5, centerY - 5, 10, 10);
        
        g2d.setColor(Color.GREEN);
        g2d.fillOval(endX - 4, endY - 4, 8, 8);
    }
    
    private void drawInfo(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 14));
        
        int width = getWidth() > 0 ? getWidth() : PANEL_WIDTH;
        int height = getHeight() > 0 ? getHeight() : PANEL_HEIGHT;
        
        // Информация об угле и скорости
        String angleInfo = String.format("Angle: %.2f rad (%.1f°)", angle, Math.toDegrees(angle));
        String speedInfo = String.format("Speed: %.3f rad/frame", rotationSpeed);
        String colorInfo = String.format("Color: RGB(%d, %d, %d)", 
            currentColor.getRed(), currentColor.getGreen(), currentColor.getBlue());
        
        g.drawString(angleInfo, 10, 20);
        g.drawString(speedInfo, 10, 40);
        g.drawString(colorInfo, 10, 60);
                

        g.setColor(Color.GRAY);
        g.drawLine(centerX, 0, centerX, height); // вертикальная ось
        g.drawLine(0, centerY, width, centerY);  // горизонтальная ось
    }

    @Override
    public void addNotify() {
        super.addNotify();
        int width = getWidth();
        int height = getHeight();
        if (width > 0 && height > 0) {
            centerX = Math.max(lineLength, Math.min(width - lineLength, centerX));
            centerY = Math.max(lineLength, Math.min(height - lineLength, centerY));
            updateEndPoint();
        }
    }
}
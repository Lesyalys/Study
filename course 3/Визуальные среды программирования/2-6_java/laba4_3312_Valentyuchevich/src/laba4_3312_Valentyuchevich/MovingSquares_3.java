package laba4_3312_Valentyuchevich;

import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class MovingSquares_3 extends JPanel implements Runnable {
    private Thread animationThread;
    private Random random;
    
    // Параметры для приближающегося квадрата
    private int approachingSize = 10;
    private int approachingX, approachingY;
    private Color approachingColor;
    private final int APPROACHING_SPEED = 2;
    private final int MAX_APPROACHING_SIZE = 300;
    
    // Параметры для удаляющегося квадрата
    private int recedingSize = 200;
    private int recedingX, recedingY;
    private Color recedingColor;
    private final int RECEDING_SPEED = 2;
    private final int MIN_RECEDING_SIZE = 20;
    
    // Размеры панели
    private final int PANEL_WIDTH = 800;
    private final int PANEL_HEIGHT = 600;

    public MovingSquares_3() {
        random = new Random();
        
        approachingColor = new Color(
            random.nextInt(200) + 55,
            random.nextInt(200) + 55,
            random.nextInt(200) + 55
        );
        
        recedingColor = new Color(
            random.nextInt(200) + 55,
            random.nextInt(200) + 55,
            random.nextInt(200) + 55
        );
        
        resetApproachingSquare();
        resetRecedingSquare();
        
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
            updateSquares();
            repaint();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateSquares() {
        updateApproachingSquare();
        updateRecedingSquare();
    }
    
    private void updateApproachingSquare() {
        approachingSize += APPROACHING_SPEED;
        
        int width = getWidth() > 0 ? getWidth() : PANEL_WIDTH;
        int height = getHeight() > 0 ? getHeight() : PANEL_HEIGHT;
        approachingX = (width - approachingSize) / 2;
        approachingY = (height - approachingSize) / 2;
        
        if (approachingSize >= MAX_APPROACHING_SIZE) {
            resetApproachingSquare();
        }
    }
    
    private void updateRecedingSquare() {
        recedingSize -= RECEDING_SPEED;
        
        int width = getWidth() > 0 ? getWidth() : PANEL_WIDTH;
        int height = getHeight() > 0 ? getHeight() : PANEL_HEIGHT;
        recedingX = (width - recedingSize) / 2;
        recedingY = (height - recedingSize) / 2;
        
        if (recedingSize <= MIN_RECEDING_SIZE) {
            resetRecedingSquare();
        }
    }
    
    private void resetApproachingSquare() {
        approachingSize = 10;
        int width = getWidth() > 0 ? getWidth() : PANEL_WIDTH;
        int height = getHeight() > 0 ? getHeight() : PANEL_HEIGHT;
        approachingX = (width - approachingSize) / 2;
        approachingY = (height - approachingSize) / 2;
        
        approachingColor = new Color(
            random.nextInt(200) + 55,
            random.nextInt(200) + 55,
            random.nextInt(200) + 55
        );
    }
    
    private void resetRecedingSquare() {
        recedingSize = 200;
        int width = getWidth() > 0 ? getWidth() : PANEL_WIDTH;
        int height = getHeight() > 0 ? getHeight() : PANEL_HEIGHT;
        recedingX = (width - recedingSize) / 2;
        recedingY = (height - recedingSize) / 2;
        
        recedingColor = new Color(
            random.nextInt(200) + 55,
            random.nextInt(200) + 55,
            random.nextInt(200) + 55
        );
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawSquares(g);
        drawInfo(g);
    }
    
    private void drawSquares(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        Color transparentReceding = new Color(
            recedingColor.getRed(),
            recedingColor.getGreen(),
            recedingColor.getBlue(),
            150
        );
        g2d.setColor(transparentReceding);
        g2d.fillRect(recedingX, recedingY, recedingSize, recedingSize);
        
        g2d.setColor(recedingColor.brighter());
        g2d.setStroke(new BasicStroke(2));
        g2d.drawRect(recedingX, recedingY, recedingSize, recedingSize);
        
        g2d.setColor(approachingColor);
        g2d.fillRect(approachingX, approachingY, approachingSize, approachingSize);
        
        g2d.setColor(approachingColor.brighter());
        g2d.setStroke(new BasicStroke(3));
        g2d.drawRect(approachingX, approachingY, approachingSize, approachingSize);
        
        int centerX = getWidth() > 0 ? getWidth() / 2 : PANEL_WIDTH / 2;
        int centerY = getHeight() > 0 ? getHeight() / 2 : PANEL_HEIGHT / 2;
        g2d.setColor(Color.YELLOW);
        g2d.fillOval(centerX - 3, centerY - 3, 6, 6);
    }
    
    private void drawInfo(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 14));
        
        int width = getWidth() > 0 ? getWidth() : PANEL_WIDTH;
        int height = getHeight() > 0 ? getHeight() : PANEL_HEIGHT;
        
        String approachingInfo = String.format("Approaching: %dx%d (Speed: +%d)", 
            approachingSize, approachingSize, APPROACHING_SPEED);
        String recedingInfo = String.format("Receding: %dx%d (Speed: -%d)", 
            recedingSize, recedingSize, RECEDING_SPEED);
        
        g.drawString(approachingInfo, 10, 20);
        g.drawString(recedingInfo, 10, 40);
        
        double approachingPercent = (double)approachingSize / width * 100;
        double recedingPercent = (double)recedingSize / width * 100;
        
        String approachingPercentStr = String.format("Approaching: %.1f%% of screen", approachingPercent);
        String recedingPercentStr = String.format("Receding: %.1f%% of screen", recedingPercent);
        
        g.drawString(approachingPercentStr, 10, height - 60);
        g.drawString(recedingPercentStr, 10, height - 40);
        
        g.setColor(approachingColor);
        g.fillRect(10, height - 90, 15, 15);
        g.setColor(Color.WHITE);
        g.drawString("Approaching Square", 30, height - 80);
        
        g.setColor(recedingColor);
        g.fillRect(200, height - 90, 15, 15);
        g.setColor(Color.WHITE);
        g.drawString("Receding Square", 220, height - 80);
    }

    @Override
    public void addNotify() {
        super.addNotify();
        resetApproachingSquare();
        resetRecedingSquare();
    }
}
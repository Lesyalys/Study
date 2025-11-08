package laba4_3312_Valentyuchevich;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class EllipsePoints_5 extends JPanel implements Runnable {
    private Thread animationThread;
    
    private int focus1X, focus1Y; // первый фокус
    private int focus2X, focus2Y; // второй фокус
    private final int SEGMENT_LENGTH = 200; // длина отрезка между фокусами
    
    private final double CONSTANT_SUM = 300; // постоянная сумма расстояний (больше длины отрезка)
    private List<Point> ellipsePoints;
    private List<Point> visiblePoints;
    private int currentPointIndex = 0;
    
    private final int POINTS_ADD_RATE = 5; // сколько точек добавлять за кадр
    private boolean animationComplete = false;
    
    private Color segmentColor = Color.RED;
    private Color pointsColor = Color.CYAN;
    private Color currentPointColor = Color.YELLOW;
    
    private final int PANEL_WIDTH = 800;
    private final int PANEL_HEIGHT = 600;

    public EllipsePoints_5() {
        focus1X = PANEL_WIDTH / 2 - SEGMENT_LENGTH / 2;
        focus1Y = PANEL_HEIGHT / 2;
        focus2X = PANEL_WIDTH / 2 + SEGMENT_LENGTH / 2;
        focus2Y = PANEL_HEIGHT / 2;
        
        //все точки эллипса
        calculateEllipsePoints();
        visiblePoints = new ArrayList<>();
        
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
            updateAnimation();
            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void calculateEllipsePoints() {
        ellipsePoints = new ArrayList<>();
        
        // параметры эллипса
        double a = CONSTANT_SUM / 2; // большая полуось
        double c = SEGMENT_LENGTH / 2; // фокальное расстояние
        double b = Math.sqrt(a * a - c * c); // малая полуось
        
        int centerX = (focus1X + focus2X) / 2;
        int centerY = (focus1Y + focus2Y) / 2;
        
        // Угол наклона отрезка
        double angle = Math.atan2(focus2Y - focus1Y, focus2X - focus1X);
        
        for (int x = 0; x < PANEL_WIDTH; x += 2) {
            for (int y = 0; y < PANEL_HEIGHT; y += 2) {
                // в систему координат эллипса
                double dx = x - centerX;
                double dy = y - centerY;
                
                double rotatedX = dx * Math.cos(-angle) - dy * Math.sin(-angle);
                double rotatedY = dx * Math.sin(-angle) + dy * Math.cos(-angle);
                
                // условие эллипса: (x²/a²) + (y²/b²) = 1
                double value = (rotatedX * rotatedX) / (a * a) + (rotatedY * rotatedY) / (b * b);
                
                if (Math.abs(value - 1) < 0.1) { // допуск для визуализации
                    ellipsePoints.add(new Point(x, y));
                }
            }
        }
        
        // Сорт  по X , затем по Y 
        ellipsePoints.sort((p1, p2) -> {
            if (p1.x != p2.x) {
                return Integer.compare(p1.x, p2.x);
            }
            return Integer.compare(p1.y, p2.y);
        });
    }

    private void updateAnimation() {
        if (animationComplete) {
            return;
        }
        
        for (int i = 0; i < POINTS_ADD_RATE; i++) {
            if (currentPointIndex < ellipsePoints.size()) {
                visiblePoints.add(ellipsePoints.get(currentPointIndex));
                currentPointIndex++;
            } else {
                animationComplete = true;
                break;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawSegment(g);
        drawPoints(g);
        drawInfo(g);
    }
    
    private void drawSegment(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2d.setColor(segmentColor);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(focus1X, focus1Y, focus2X, focus2Y);

        g2d.setColor(Color.RED);
        g2d.fillOval(focus1X - 5, focus1Y - 5, 10, 10);
        g2d.fillOval(focus2X - 5, focus2Y - 5, 10, 10);

        g2d.setColor(Color.WHITE);
        g2d.drawString("F1", focus1X - 15, focus1Y - 10);
        g2d.drawString("F2", focus2X + 10, focus2Y - 10);
    }
    
    private void drawPoints(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2d.setColor(pointsColor);
        for (Point p : visiblePoints) {
            g2d.fillOval(p.x - 1, p.y - 1, 3, 3);
        }
        
        if (!visiblePoints.isEmpty()) {
            Point lastPoint = visiblePoints.get(visiblePoints.size() - 1);
            g2d.setColor(currentPointColor);
            g2d.fillOval(lastPoint.x - 3, lastPoint.y - 3, 6, 6);
            
            // расстояния до фокусов для последней точки
            double dist1 = distance(lastPoint.x, lastPoint.y, focus1X, focus1Y);
            double dist2 = distance(lastPoint.x, lastPoint.y, focus2X, focus2Y);
            
            g2d.setColor(Color.WHITE);
            g2d.drawString(String.format("d1=%.1f", dist1), lastPoint.x + 10, lastPoint.y - 10);
            g2d.drawString(String.format("d2=%.1f", dist2), lastPoint.x + 10, lastPoint.y + 5);
            g2d.drawString(String.format("sum=%.1f", dist1 + dist2), lastPoint.x + 10, lastPoint.y + 20);
        }
    }
    
    private void drawInfo(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 14));
        
        int width = getWidth() > 0 ? getWidth() : PANEL_WIDTH;
        int height = getHeight() > 0 ? getHeight() : PANEL_HEIGHT;
        
        // Информация
        String segmentInfo = String.format("Segment length: %d", SEGMENT_LENGTH);
        String sumInfo = String.format("Constant sum: %.1f", CONSTANT_SUM);
        String pointsInfo = String.format("Points: %d/%d", visiblePoints.size(), ellipsePoints.size());
        String progressInfo = String.format("Progress: %.1f%%", 
            (double)visiblePoints.size() / ellipsePoints.size() * 100);
        
        g.drawString("Geometric Locus: Points where distance(F1,P) + distance(F2,P) = constant", 10, 20);
        g.drawString(segmentInfo, 10, 40);
        g.drawString(sumInfo, 10, 60);
        g.drawString(pointsInfo, 10, 80);
        g.drawString(progressInfo, 10, 100);
        
        // Статус анимации
        if (animationComplete) {
            g.setColor(Color.GREEN);
            g.drawString("Animation Complete!", 10, height - 20);
        } else {
            g.setColor(Color.YELLOW);
            g.drawString("Animating... Points appearing from top-left to bottom-right", 10, height - 20);
        }
        
        // Уравнение эллипса
        g.setColor(Color.CYAN);
        g.drawString("Ellipse equation: distance(F1,P) + distance(F2,P) = " + CONSTANT_SUM, 10, height - 50);
    }
    
    private double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    @Override
    public void addNotify() {
        super.addNotify();
        calculateEllipsePoints();
    }
}
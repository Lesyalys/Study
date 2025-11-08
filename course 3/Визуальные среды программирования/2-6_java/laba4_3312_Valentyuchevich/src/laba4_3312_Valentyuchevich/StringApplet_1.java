package laba4_3312_Valentyuchevich;

import java.awt.*;
import javax.swing.*;

public class StringApplet_1 extends JPanel implements Runnable {
    private String[] strings = {
        "Hello World!", "Java Programming", "Moving Text",
        "Applet Animation", "Random Movement"
    };
    
    private Thread animationThread;
    private java.util.Random random;
    
    private int[] x, y, dx, dy;    
    private Color[] colors;
    private boolean[] active;
    private String[] currentText; // Добавляем массив для хранения текста каждой строки
    
    private final int FONT_SIZE = 20;
    private final int MAX_STRINGS = 5;
    private final int DEFAULT_WIDTH = 800;
    private final int DEFAULT_HEIGHT = 600;

    public StringApplet_1() {
        random = new java.util.Random();
        
        x = new int[MAX_STRINGS];
        y = new int[MAX_STRINGS];
        dx = new int[MAX_STRINGS];
        dy = new int[MAX_STRINGS];
        colors = new Color[MAX_STRINGS];
        active = new boolean[MAX_STRINGS];
        currentText = new String[MAX_STRINGS];
        
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        
    }

    public void start() {
        if (animationThread == null) {
            // Инициализируем строки только когда компонент уже отображен
            initializeStrings();
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
            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        updateStrings();
        drawStrings(g);
    }

    private void initializeStrings() {
        for (int i = 0; i < MAX_STRINGS; i++) {
            activateString(i);
        }
    }

    private void activateString(int index) {
        if (!active[index]) {
            currentText[index] = strings[random.nextInt(strings.length)];

            int width = getWidth() > 0 ? getWidth() : DEFAULT_WIDTH;
            int height = getHeight() > 0 ? getHeight() : DEFAULT_HEIGHT;
            
            int side = random.nextInt(4);
            switch (side) {
                case 0: // сверху
                    x[index] = random.nextInt(Math.max(1, width));
                    y[index] = -FONT_SIZE;
                    break;
                case 1: // справа
                    x[index] = width + 100;
                    y[index] = random.nextInt(Math.max(1, height));
                    break;
                case 2: // снизу
                    x[index] = random.nextInt(Math.max(1, width));
                    y[index] = height + FONT_SIZE;
                    break;
                case 3: // слева
                    x[index] = -100;
                    y[index] = random.nextInt(Math.max(1, height));
                    break;
            }
            
            // ненулевые скорости
            dx[index] = getNonZeroSpeed();
            dy[index] = getNonZeroSpeed();
            
            colors[index] = new Color(
                random.nextInt(200) + 55,
                random.nextInt(200) + 55,
                random.nextInt(200) + 55
            );
            
            active[index] = true;
        }
    }
    
    private int getNonZeroSpeed() {
        int speed;
        do {
            speed = random.nextInt(7) - 3; // от -3 до +3
        } while (speed == 0);
        return speed;
    }

    private void updateStrings() {
        int width = getWidth() > 0 ? getWidth() : DEFAULT_WIDTH;
        int height = getHeight() > 0 ? getHeight() : DEFAULT_HEIGHT;
        
        for (int i = 0; i < MAX_STRINGS; i++) {
            if (active[i]) {
                x[i] += dx[i];
                y[i] += dy[i];
                
                if (x[i] < -200 || x[i] > width + 200 || 
                    y[i] < -50 || y[i] > height + 50) {
                    active[i] = false;
                    activateString(i);
                }
            } else {
                activateString(i);
            }
        }
    }

    private void drawStrings(Graphics g) {
        Font font = new Font("Arial", Font.BOLD, FONT_SIZE);
        g.setFont(font);
        
        for (int i = 0; i < MAX_STRINGS; i++) {
            if (active[i]) {
                g.setColor(colors[i]);
                g.drawString(currentText[i], x[i], y[i]);
            }
        }
    }
    
    @Override
    public void addNotify() {
        super.addNotify();
        if (animationThread == null) {
            initializeStrings();
        }
    }
}
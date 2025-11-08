package laba4_3312_Valentyuchevich;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class DrawingApp_6 extends JFrame {
    private DrawingPanel drawingPanel;
    private JMenuBar menuBar;
    private JToolBar toolBar;
    
    private Color[] colors = {
        Color.BLACK, Color.WHITE, Color.RED, Color.GREEN, Color.BLUE,
        Color.YELLOW, Color.CYAN, Color.MAGENTA, Color.ORANGE, Color.PINK,
        Color.GRAY, Color.DARK_GRAY, Color.LIGHT_GRAY
    };
    
    private float[] strokeWidths = {1.0f, 2.0f, 3.0f, 5.0f, 8.0f, 10.0f, 15.0f};

    public DrawingApp_6() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Drawing App with Pen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);

        drawingPanel = new DrawingPanel();
        
        createMenuBar();
        
        createToolBar();

        setLayout(new BorderLayout());
        add(toolBar, BorderLayout.NORTH);
        add(new JScrollPane(drawingPanel), BorderLayout.CENTER);
        
        setJMenuBar(menuBar);
    }

    private void createMenuBar() {
        menuBar = new JMenuBar();
        
        JMenu fileMenu = new JMenu("File");
        
        JMenuItem newItem = new JMenuItem("New");
        newItem.addActionListener(e -> drawingPanel.clear());
        newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));

        
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        
        fileMenu.add(newItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        
        JMenu colorMenu = new JMenu("Color");
        
        for (Color color : colors) {
            JMenuItem colorItem = createColorMenuItem(color);
            colorMenu.add(colorItem);
        }
        
        JMenuItem customColorItem = new JMenuItem("Custom Color...");
        customColorItem.addActionListener(e -> chooseCustomColor());
        colorMenu.addSeparator();
        colorMenu.add(customColorItem);
        
        JMenu thicknessMenu = new JMenu("Thickness");
        
        for (float width : strokeWidths) {
            JMenuItem thicknessItem = createThicknessMenuItem(width);
            thicknessMenu.add(thicknessItem);
        }
        
        JMenu toolsMenu = new JMenu("Tools");
        
        JMenuItem clearItem = new JMenuItem("Clear Canvas");
        clearItem.addActionListener(e -> drawingPanel.clear());
        
        JCheckBoxMenuItem antialiasingItem = new JCheckBoxMenuItem("Antialiasing", true);
        antialiasingItem.addActionListener(e -> 
            drawingPanel.setAntialiasing(antialiasingItem.isSelected()));
        
        toolsMenu.add(clearItem);
        toolsMenu.addSeparator();
        toolsMenu.add(antialiasingItem);
        
        menuBar.add(fileMenu);
        menuBar.add(colorMenu);
        menuBar.add(thicknessMenu);
        menuBar.add(toolsMenu);
    }

    private void createToolBar() {
        toolBar = new JToolBar();
        toolBar.setFloatable(false);
        

        JButton clearButton = new JButton(new ImageIcon());
        clearButton.setToolTipText("Clear Canvas");
        clearButton.addActionListener(e -> drawingPanel.clear());

        for (Color color : colors) {
            JButton colorButton = new JButton(createIcon(color, 20, 20));
            colorButton.setToolTipText(getColorName(color));
            colorButton.addActionListener(e -> drawingPanel.setCurrentColor(color));
            toolBar.add(colorButton);
        }

        JButton customColorButton = new JButton("Custom");
        customColorButton.addActionListener(e -> chooseCustomColor());
        
        JComboBox<Float> thicknessCombo = new JComboBox<>();
        for (float width : strokeWidths) {
            thicknessCombo.addItem(width);
        }
        thicknessCombo.setSelectedItem(3.0f);
        thicknessCombo.addActionListener(e -> 
            drawingPanel.setCurrentStrokeWidth((Float)thicknessCombo.getSelectedItem()));

        JLabel statusLabel = new JLabel("Color: Black | Thickness: 3.0");
        drawingPanel.setStatusLabel(statusLabel);
        
        toolBar.add(clearButton);
        toolBar.addSeparator();
        toolBar.add(new JLabel("Colors:"));
        toolBar.addSeparator();
        toolBar.add(customColorButton);
        toolBar.addSeparator();
        toolBar.add(new JLabel("Thickness:"));
        toolBar.add(thicknessCombo);
        toolBar.addSeparator();
        toolBar.add(statusLabel);
    }

    private JMenuItem createColorMenuItem(Color color) {
        JMenuItem item = new JMenuItem(getColorName(color));
        item.setIcon(createIcon(color, 16, 16));
        item.addActionListener(e -> drawingPanel.setCurrentColor(color));
        return item;
    }

    private JMenuItem createThicknessMenuItem(float width) {
        JMenuItem item = new JMenuItem(width + " px");
        item.addActionListener(e -> drawingPanel.setCurrentStrokeWidth(width));
        return item;
    }

    private void chooseCustomColor() {
        Color chosenColor = JColorChooser.showDialog(this, "Choose Color", drawingPanel.getCurrentColor());
        if (chosenColor != null) {
            drawingPanel.setCurrentColor(chosenColor);
        }
    }


    private ImageIcon createIcon(Color color, int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(color);
        g2d.fillRect(0, 0, width, height);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(0, 0, width - 1, height - 1);
        g2d.dispose();
        return new ImageIcon(image);
    }

    private String getColorName(Color color) {
        if (color.equals(Color.BLACK)) return "Black";
        if (color.equals(Color.WHITE)) return "White";
        if (color.equals(Color.RED)) return "Red";
        if (color.equals(Color.GREEN)) return "Green";
        if (color.equals(Color.BLUE)) return "Blue";
        if (color.equals(Color.YELLOW)) return "Yellow";
        if (color.equals(Color.CYAN)) return "Cyan";
        if (color.equals(Color.MAGENTA)) return "Magenta";
        if (color.equals(Color.ORANGE)) return "Orange";
        if (color.equals(Color.PINK)) return "Pink";
        if (color.equals(Color.GRAY)) return "Gray";
        if (color.equals(Color.DARK_GRAY)) return "Dark Gray";
        if (color.equals(Color.LIGHT_GRAY)) return "Light Gray";
        return "Custom Color";
    }

    public static void start() {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getLookAndFeel());
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            new DrawingApp_6().setVisible(true);
        });
    }
}

class DrawingPanel extends JPanel {
    private List<DrawingStroke> strokes;
    private DrawingStroke currentStroke;
    private Color currentColor = Color.BLACK;
    private float currentStrokeWidth = 3.0f;
    private boolean antialiasing = true;
    private JLabel statusLabel;

    public DrawingPanel() {
        strokes = new ArrayList<>();
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(800, 600));
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                currentStroke = new DrawingStroke(currentColor, currentStrokeWidth);
                currentStroke.addPoint(e.getPoint());
                strokes.add(currentStroke);
                repaint();
            }
        });
        
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (currentStroke != null) {
                    currentStroke.addPoint(e.getPoint());
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        if (antialiasing) {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        }
        
        for (DrawingStroke stroke : strokes) {
            stroke.draw(g2d);
        }
    }

    public void clear() {
        strokes.clear();
        repaint();
    }

    public void setCurrentColor(Color color) {
        this.currentColor = color;
        updateStatus();
    }

    public void setCurrentStrokeWidth(float width) {
        this.currentStrokeWidth = width;
        updateStatus();
    }

    public void setAntialiasing(boolean enabled) {
        this.antialiasing = enabled;
        repaint();
    }

    public void setStatusLabel(JLabel label) {
        this.statusLabel = label;
        updateStatus();
    }

    public Color getCurrentColor() {
        return currentColor;
    }

    private void updateStatus() {
        if (statusLabel != null) {
            statusLabel.setText(String.format("Color: %s | Thickness: %.1f", 
                getColorName(currentColor), currentStrokeWidth));
        }
    }

    private String getColorName(Color color) {
        if (color.equals(Color.BLACK)) return "Black";
        if (color.equals(Color.RED)) return "Red";
        if (color.equals(Color.GREEN)) return "Green";
        if (color.equals(Color.BLUE)) return "Blue";
        if (color.equals(Color.YELLOW)) return "Yellow";
        return "Custom";
    }
}

class DrawingStroke {
    private List<Point> points;
    private Color color;
    private float strokeWidth;

    public DrawingStroke(Color color, float strokeWidth) {
        this.points = new ArrayList<>();
        this.color = color;
        this.strokeWidth = strokeWidth;
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public void draw(Graphics2D g2d) {
        if (points.size() < 2) return;
        
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        for (int i = 1; i < points.size(); i++) {
            Point p1 = points.get(i - 1);
            Point p2 = points.get(i);
            g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
        
        g2d.setStroke(new BasicStroke(strokeWidth / 2));
        for (Point p : points) {
            g2d.fillOval(p.x - (int)(strokeWidth / 4), p.y - (int)(strokeWidth / 4), 
                         (int)(strokeWidth / 2), (int)(strokeWidth / 2));
        }
    }
}
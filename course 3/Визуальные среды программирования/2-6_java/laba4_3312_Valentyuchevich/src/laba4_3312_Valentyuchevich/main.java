package laba4_3312_Valentyuchevich;

import javax.swing.*;

public class main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Moving Strings");
            StringApplet_1 panel = new StringApplet_1();
            BouncingCircle_2 panel2= new BouncingCircle_2();
            MovingSquares_3 panel3 = new MovingSquares_3();
            RotatingLine_4 panel4 = new RotatingLine_4();
            EllipsePoints_5 panel5 = new EllipsePoints_5();
            DrawingApp_6 plane6 = new DrawingApp_6();
            
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.getContentPane().add(panel5);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            
//            panel.start();
            plane6.start();
        });
    }
}
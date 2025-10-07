package java7.UI;

import javax.swing.*;
import java.awt.*;

public class Header {
    public static void createHeader(JFrame frame) {
        JPanel panel = new JPanel(new BorderLayout());
        JTextField text = new JTextField("Система управления списком студентов группы");
        text.setEditable(false);
        text.setHorizontalAlignment(JTextField.CENTER);
        text.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(text);
        
        frame.add(panel, BorderLayout.NORTH);
    }
}
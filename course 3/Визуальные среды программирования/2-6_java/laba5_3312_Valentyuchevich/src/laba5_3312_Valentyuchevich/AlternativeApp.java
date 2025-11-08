package laba5_3312_Valentyuchevich;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AlternativeApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Альтернатива апплету - Текстовый ввод");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 200);
            frame.setLayout(new FlowLayout());
            
            JTextField textField = new JTextField(20);
            JButton button = new JButton("Добавить");
            JLabel label = new JLabel("Введенные символы: ");
            StringBuilder history = new StringBuilder();
            
            frame.add(new JLabel("Ввод:"));
            frame.add(textField);
            frame.add(button);
            frame.add(label);
            
            // Обработчик события
            ActionListener actionListener = e -> {
                String input = textField.getText().trim();
                if (!input.isEmpty()) {
                    for (char c : input.toCharArray()) {
                        history.append(c).append(" ");
                    }
                    label.setText("Введенные символы: " + history.toString());
                    textField.setText("");
                    System.out.println("Добавлены символы: " + input);
                }
            };
            
            button.addActionListener(actionListener);
            textField.addActionListener(actionListener);
            
            frame.setVisible(true);
            System.out.println("Альтернативное приложение запущено!");
        });
    }
}
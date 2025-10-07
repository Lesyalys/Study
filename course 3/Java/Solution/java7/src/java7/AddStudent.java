package java7;

import javax.swing.*;
import java.util.HashMap;
import java7.DB.Student;

public class AddStudent {
    public static void addStudent(HashMap<String, Student> studentsMap, 
                                 Runnable updateListModel, 
                                 JTextArea studentDetails) {
        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField addressField = new JTextField();
        
        Object[] message = {
            "ФИО студента:", nameField,
            "Возраст:", ageField,
            "Адрес:", addressField
        };
        
        int option = JOptionPane.showConfirmDialog(null, message, "Добавить студента", 
                                                  JOptionPane.OK_CANCEL_OPTION);
        
        if (option == JOptionPane.OK_OPTION) {
            String name = nameField.getText().trim();
            String ageStr = ageField.getText().trim();
            String address = addressField.getText().trim();
            
            if (name.isEmpty() || ageStr.isEmpty() || address.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Все поля должны быть заполнены!");
                return;
            }
            
            try {
                int age = Integer.parseInt(ageStr);
                Student student = new Student(name, age, address);
                studentsMap.put(name, student);
                updateListModel.run();
                Main.saveToFile(); //вызывается из Main
                JOptionPane.showMessageDialog(null, "Студент добавлен!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Возраст должен быть числом!");
            }
        }
    }
}
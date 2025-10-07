package java7;

import javax.swing.*;

import java.util.HashMap;
import java7.DB.Student;
import java7.DB.FileOperations;
import java7.UI.Header;
import java7.UI.Home;
import java7.UI.Button;

public class Main {
    private static HashMap<String, Student> studentsMap;
    
    public static void main(String[] args) {
        studentsMap = FileOperations.loadFromFile(); // данные из файла 
        
        JFrame frame = new JFrame("Список студентов группы");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        
        Header.createHeader(frame);
        
        Button.setupButtonListeners(studentsMap, frame);
        
        frame.setVisible(true);
    }
    
    
    public static void updateListModel() {
        Home.updateListModel(studentsMap);
    }
    
    public static void saveToFile() {
        FileOperations.saveToFile(studentsMap);
    }
    
    public static HashMap<String, Student> getStudentsMap() {
        return studentsMap;
    }
}
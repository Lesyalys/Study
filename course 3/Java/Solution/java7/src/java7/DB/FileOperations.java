package java7.DB;

import javax.swing.JOptionPane;
import java.io.*;
import java.util.HashMap;

public class FileOperations {
    private static final String FILE_NAME = "students.dat";
    
    public static void saveToFile(HashMap<String, Student> studentsMap) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(studentsMap);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ошибка при сохранении данных: " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    public static HashMap<String, Student> loadFromFile() {
        HashMap<String, Student> studentsMap = new HashMap<>();
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
                studentsMap = (HashMap<String, Student>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Ошибка при загрузке данных: " + e.getMessage());
            }
        }
        return studentsMap;
    }
}
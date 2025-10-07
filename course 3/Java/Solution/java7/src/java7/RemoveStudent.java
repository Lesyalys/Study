package java7;

import java.util.HashMap;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java7.UI.Home;
import java7.DB.FileOperations;

import java7.DB.Student;

public class RemoveStudent {

	public static void removeStudent(HashMap<String, Student> studentsMap, JList<String> jList, JTextArea jTextArea) {
        String selectedStudent = Home.getStudentList().getSelectedValue();
        if (selectedStudent != null) {
            studentsMap.remove(selectedStudent);
            Home.updateListModel(studentsMap);
            Home.getStudentDetails().setText("Выберите студента из списка для просмотра данных");
            FileOperations.saveToFile(studentsMap); // save файл после удаления
        } else {
            JOptionPane.showMessageDialog(null, "Выберите студента для удаления!");
        }
    }

}

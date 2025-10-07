package java7;

import java.util.HashMap;

import javax.swing.JOptionPane;
import java7.UI.Home;

import java7.DB.Student;
import java7.DB.FileOperations;

public class ClearList {
	 public static void clearList(HashMap<String, Student> studentsMap) {
	        int result = JOptionPane.showConfirmDialog(null, 
	            "Вы уверены, что хотите очистить весь список?", 
	            "Подтверждение", 
	            JOptionPane.YES_NO_OPTION);
	        
	        if (result == JOptionPane.YES_OPTION) {
	            studentsMap.clear();
	            Home.updateListModel(studentsMap);
//	            studentDetails.setText("Выберите студента из списка для просмотра данных");
	            FileOperations.saveToFile(studentsMap); // Сохраняем в файл после очистки
	        }
	    }

}

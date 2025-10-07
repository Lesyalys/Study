package java7.UI;

import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java7.AddStudent;
import java7.ClearList;
import java7.Main;
import java7.RemoveStudent;
import java7.DB.Student;

public class Button {
	public static void setupButtonListeners(HashMap<String,Student>studentsMap,JFrame frame) {
        ActionListener addListener = e -> 
            AddStudent.addStudent(studentsMap, Main::updateListModel, Home.getStudentDetails());
        
        ActionListener removeListener = e -> 
            RemoveStudent.removeStudent(studentsMap, Home.getStudentList(), Home.getStudentDetails());
        
        ActionListener clearListener = e -> 
            ClearList.clearList(studentsMap);
        
        // Передаем обработчики в Home
        JPanel homePanel = Home.createHome(frame, studentsMap, addListener, removeListener, clearListener);
        frame.add(homePanel);
    }

}

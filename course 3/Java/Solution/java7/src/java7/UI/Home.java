package java7.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java7.DB.Student;

public class Home {
    private static DefaultListModel<String> listModel;
    private static JList<String> studentList;
    private static JTextArea studentDetails;
    
    public static  JPanel createHome(JFrame frame, HashMap<String, Student> studentsMap,
            ActionListener addListener, 
            ActionListener removeListener,
            ActionListener clearListener) {
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        // Панель с кнопками
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Добавить в список");
        JButton removeButton = new JButton("Убрать из списка");
        JButton clearButton = new JButton("Очистить список");
        
        addButton.addActionListener(addListener);
        removeButton.addActionListener(removeListener);
        clearButton.addActionListener(clearListener);
        
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(clearButton);
        
        // Панель с данными студентов
        JPanel dataPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        
        // Левая панель - список студентов
        JPanel listPanel = new JPanel(new BorderLayout());
        
        listModel = new DefaultListModel<>();
        updateListModel(studentsMap);
        
        studentList = new JList<>(listModel);
        studentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(studentList);
        listPanel.add(listScrollPane, BorderLayout.CENTER);
        
        // Правая панель - детали студента
        JPanel detailsPanel = new JPanel(new BorderLayout());
        
        studentDetails = new JTextArea();
        studentDetails.setEditable(false);
        studentDetails.setFont(new Font("Arial", Font.PLAIN, 14));
        studentDetails.setText("Выберите студента из списка для просмотра данных");
        JScrollPane detailsScrollPane = new JScrollPane(studentDetails);
        detailsPanel.add(detailsScrollPane, BorderLayout.CENTER);
        
        dataPanel.add(listPanel);
        dataPanel.add(detailsPanel);
        
        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        mainPanel.add(dataPanel, BorderLayout.CENTER);
        
        frame.add(mainPanel);
        
        studentList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedStudent = studentList.getSelectedValue();
                if (selectedStudent != null) {
                    Student student = studentsMap.get(selectedStudent);
                    if (student != null) {
                        studentDetails.setText("ФИО: " + student.getName() + "\n" +
                                              "Возраст: " + student.getAge() + "\n" +
                                              "Адрес: " + student.getAddress());
                    }
                }
            }
        });
        return mainPanel;

    }
    
    public static DefaultListModel<String> getListModel() { return listModel; }
    public static JList<String> getStudentList() { return studentList; }
    public static JTextArea getStudentDetails() { return studentDetails; }
    
    public static void updateListModel(HashMap<String, Student> studentsMap) {
        listModel.clear();
        for (String name : studentsMap.keySet()) {
            listModel.addElement(name);
        }
    }
}
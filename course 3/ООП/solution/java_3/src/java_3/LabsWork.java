package java_3;

import java.time.LocalTime;

public class LabsWork extends Lesson {
    private String labName;
    private int labNumber;
    private String equipment; 
    
    public LabsWork() {
        super();
        this.labName = "Не указана";
        this.labNumber = 1;
        this.equipment = "Не указано";
        System.out.println("Вызван конструктор LabsWork без параметров");
    }
    
    public LabsWork(String name, String dayOfWeek, LocalTime time, String labName, int labNumber, String equipment) {
        super(name, dayOfWeek, time); 
        this.labName = labName;
        this.labNumber = labNumber;
        this.equipment = equipment;
        System.out.println("Вызван конструктор LabsWork с параметрами: " + name + ", " + labName + ", " + labNumber);
    }
    
    // Конструктор копирования
    public LabsWork(LabsWork labsWork) {
        super(labsWork); 
        this.labName = labsWork.labName;
        this.labNumber = labsWork.labNumber;
        this.equipment = labsWork.equipment;
        System.out.println("Вызван конструктор копирования LabsWork для: " + labsWork.getName());
    }
    
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Вызван деструктор LabsWork для: " + getName());
        super.finalize();
    }
    
    @Override
    public void getallFeelds() {
        super.getallFeelds(); 
        System.out.println("Название лабораторной: " + labName);
        System.out.println("Номер работы: " + labNumber);
        System.out.println("Оборудование: " + equipment);
        System.out.println("Тип: Лабораторная работа");
    }
    
    public void printLessonData() {
        System.out.println("=== ЛАБОРАТОРНАЯ РАБОТА ===");
        System.out.println("Название: " + getName());
        System.out.println("День: " + getDayOfWeek());
        System.out.println("Время: " + getTime());
        System.out.println("Лабораторная: " + labName);
        System.out.println("Номер работы: " + labNumber);
        System.out.println("Оборудование: " + equipment);
    }
    
    public String getLabName() {
        return labName;
    }
    
    public void setLabName(String labName) {
        this.labName = labName;
    }
    
    public int getLabNumber() {
        return labNumber;
    }
    
    public void setLabNumber(int labNumber) {
        this.labNumber = labNumber;
    }
    
    public String getEquipment() {
        return equipment;
    }
    
    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }
}
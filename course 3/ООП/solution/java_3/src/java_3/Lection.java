package java_3;

import java.time.LocalTime;

public class Lection extends Lesson {
    private String teacher;
    private String subject;
    private int duration;
    
    public Lection() {
        super();
        this.teacher = "Не указан";
        this.subject = "Не указан";
        this.duration = 90; 
        System.out.println("Вызван конструктор Lection без параметров");
    }
    
    public Lection(String name, String dayOfWeek, LocalTime time, String teacher, String subject, int duration) {
        super(name, dayOfWeek, time); 
        this.teacher = teacher;
        this.subject = subject;
        this.duration = duration;
        System.out.println("Вызван конструктор Lection с параметрами: " + name + ", " + teacher + ", " + subject);
    }
    
    public Lection(Lection lection) {
        super(lection);
        this.teacher = lection.teacher;
        this.subject = lection.subject;
        this.duration = lection.duration;
        System.out.println("Вызван конструктор копирования Lection для: " + lection.getName());
    }
    
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Вызван деструктор Lection для: " + getName());
        super.finalize();
    }
    
    @Override
    public void getallFeelds() {
        super.getallFeelds();
        System.out.println("Преподаватель: " + teacher);
        System.out.println("Предмет: " + subject);
        System.out.println("Продолжительность: " + duration + " минут");
        System.out.println("Тип: Лекция");
    }

    public void printLessonData() {
        System.out.println("=== ЛЕКЦИЯ ===");
        System.out.println("Название: " + getName());
        System.out.println("День: " + getDayOfWeek());
        System.out.println("Время: " + getTime());
        System.out.println("Преподаватель: " + teacher);
        System.out.println("Предмет: " + subject);
        System.out.println("Продолжительность: " + duration + " мин");
    }
    
    // Геттеры и сеттеры
    public String getTeacher() {
        return teacher;
    }
    
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
    
    public String getSubject() {
        return subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    public int getDuration() {
        return duration;
    }
    
    public void setDuration(int duration) {
        this.duration = duration;
    }
}
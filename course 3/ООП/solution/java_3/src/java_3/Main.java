package java_3;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== ДЕМОНСТРАЦИЯ КОНСТРУКТОРОВ ===");
        
        System.out.println("\n=== КОНСТРУКТОР КЛАССА Lesson БЕЗ ПАРАМЕТРОВ ===");
        Lesson lesson = new Lesson();
        lesson.getallFeelds();
        
        System.out.println("\n=== КОНСТРУКТОР КЛАССА Schedule С ПАРАМЕТРАМИ ===");
        List<Lesson> lessonList = new ArrayList<>();
        lessonList.add(new Lesson("Математика", "Понедельник", LocalTime.of(9, 0)));
        lessonList.add(new Lesson("Физика", "Понедельник", LocalTime.of(10, 30)));
        
        Schedule schedule2 = new Schedule("123", "ул. Ленина, д. 10", lessonList);
        schedule2.getAllFeeldSchedule();
        
        System.out.println("\n=== ДОБАВЛЕНИЕ ЗАНЯТИЙ ЧЕРЕЗ КОНСТРУКТОР С ПАРАМЕТРАМИ ===");
        schedule2.addLessonWithParams("Химия", "Среда", LocalTime.of(11, 0)); 
        schedule2.addLessonWithParams("Биология", "Четверг", LocalTime.of(13, 30));
        
        System.out.println("\n=== СОЗДАНИЕ ОБЪЕКТА ДЛЯ КОПИРОВАНИЯ ===");
        Lesson originalLesson = new Lesson("История", "Вторник", LocalTime.of(14, 0));
        
        System.out.println("\n=== СОЗДАНИЕ КОПИЙ ОБЪЕКТА ===");
        System.out.print("Введите количество копий: ");
        int count = scanner.nextInt();
        scanner.nextLine(); 
        
        schedule2.addLessonCopies(originalLesson, count);
        
        System.out.println("\n=== ДЕМОНСТРАЦИЯ КОНСТРУКТОРА КОПИРОВАНИЯ SCHEDULE ===");
        Schedule scheduleCopy = new Schedule(schedule2);
        scheduleCopy.getAllFeeldSchedule(); 
        
        
        
        System.out.println("=== ИНФОРМАЦИЯ О ДНЯХ НЕДЕЛИ ЗАНЯТИЙ В РАСПИСАНИИ ===");
        schedule2.getAllNameDayOfWeek();
        
        System.out.println("=== ВВЕДИТЕ НАИМЕНОВАНИЯ ДНЯ НЕДЕЛИ ДЛЯ ПОИСКА РАСПИСАНИЯ===");
        String weekName = scanner.nextLine().trim();
        List<Lesson> lessonsForDay = schedule2.getLessonsByDay(weekName);
System.out.println("Занятия в " + weekName + ":");
        
        if (lessonsForDay.isEmpty()) {
            System.out.println("Занятий не найдено");
        } else {
            for (Lesson les : lessonsForDay) {
                System.out.println(" - " + les.getName() + " в " + les.getTime());
            }
        }

 // ========== НОВЫЙ ФУНКЦИОНАЛ НАСЛЕДОВАНИЯ ==========

                
                System.out.println("=== ДЕМОНСТРАЦИЯ НАСЛЕДОВАНИЯ ОТ LESSON ===");
                
                System.out.println("\n=== БАЗОВЫЙ КЛАСС LESSON ===");
                Lesson basicLesson = new Lesson("Математика", "Понедельник", LocalTime.of(9, 0));
                basicLesson.getallFeelds();
                
                System.out.println("\n=== КЛАСС-НАСЛЕДНИК LECTION ===");
                Lection lection = new Lection("Программирование", "Вторник", LocalTime.of(10, 0), 
                                            "Иванов И.И.", "Java основы", 90);
                lection.getallFeelds();
                
                System.out.println("\n=== КЛАСС-НАСЛЕДНИК LABSWORK ===");
                LabsWork labWork = new LabsWork("Физика", "Среда", LocalTime.of(14, 0), 
                                              "Механика жидкостей", 3, "Гидравлическая установка");
                labWork.getallFeelds();
                
                // Демонстрация полиморфизма
                System.out.println("\n=== ПОЛИМОРФИЗМ С LESSON ===");
                List<Lesson> lessons = new ArrayList<>();
                lessons.add(basicLesson);
                lessons.add(lection);    // Lection как Lesson
                lessons.add(labWork);    // LabsWork как Lesson
                
                System.out.println("Все занятия:");
                for (Lesson lessonItem : lessons) {
                    System.out.println("- " + lessonItem.getName() + " в " + lesson.getTime());
                }
                
                System.out.println("\n=== РАСПИСАНИЕ С РАЗНЫМИ ТИПАМИ ЗАНЯТИЙ ===");
                Schedule schedule = new Schedule("УНИВ-001", "Главный корпус");
                
                schedule.addLesson(basicLesson);
                schedule.addLesson(lection);
                schedule.addLesson(labWork);
                
                System.out.println("\n=== КОПИРОВАНИЕ НАСЛЕДНИКОВ ===");
                Lection lectionCopy = new Lection(lection);
                LabsWork labWorkCopy = new LabsWork(labWork);
                
                System.out.println("\n=== ВЫВОД ДАННЫХ РАЗНЫХ ТИПОВ ===");
                System.out.println("Базовое занятие:");
                basicLesson.getallFeelds();
                
                System.out.println("\nЛекция:");
                lection.printLessonData();
                
                System.out.println("\nЛабораторная работа:");
                labWork.printLessonData();
                
                System.out.println("\n=== УНИКАЛЬНЫЕ МЕТОДЫ НАСЛЕДНИКОВ ===");
                System.out.println("Преподаватель лекции: " + lection.getTeacher());
                System.out.println("Предмет лекции: " + lection.getSubject());
                System.out.println("Продолжительность лекции: " + lection.getDuration() + " минут");
                System.out.println("Номер лабораторной: " + labWork.getLabNumber());
                System.out.println("Название лабораторной: " + labWork.getLabName());
                System.out.println("Оборудование для лабы: " + labWork.getEquipment());
                
                System.out.println("\n=== МАССИВ РАЗНЫХ ТИПОВ ЗАНЯТИЙ ===");
                Lesson[] mixedLessons = new Lesson[4];
                mixedLessons[0] = basicLesson;
                mixedLessons[1] = lection;
                mixedLessons[2] = labWork;
                mixedLessons[3] = new Lection("Базы данных", "Пятница", LocalTime.of(11, 0), 
                                            "Петров П.П.", "SQL", 120);
                
                System.out.println("Смешанный массив занятий:");
                for (int i = 0; i < mixedLessons.length; i++) {
                    System.out.println((i + 1) + ". " + mixedLessons[i].getName() + 
                                     " (" + mixedLessons[i].getClass().getSimpleName() + ")");
                }
                
                // Принудительный вызов GC для демонстрации деструкторов
                System.out.println("\n=== ЗАВЕРШЕНИЕ ПРОГРАММЫ ===");
                System.gc();
                
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                scanner.close();
                System.out.println("Программа завершена!");
            }
        
}
package java_1;

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
        
        scanner.close();
        
	}
}

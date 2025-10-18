package java_1_1;

import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Schedule schedule = new Schedule("123", "ул. Ленина, д. 10");
		Scanner scanner = new Scanner(System.in);
		
		schedule.addLesson(new Lesson("Математика", "понедельник", LocalTime.of(9, 0)));
        schedule.addLesson(new Lesson("Физика", "понедельник", LocalTime.of(10, 30)));
        schedule.addLesson(new Lesson("История", "вторник", LocalTime.of(10, 30)));
        schedule.addLesson(new Lesson("Химия", "среда", LocalTime.of(10, 30)));
        schedule.addLesson(new Lesson("Литература", "вторник", LocalTime.of(10, 30)));
        
        
        
        System.out.println("=== ИНФОРМАЦИЯ О ДНЯХ НЕДЕЛИ ЗАНЯТИЙ В РАСПИСАНИИ ===");
        schedule.getAllSchedule().forEach(e -> System.out.println(e.getName()));
        
        System.out.println("=== ВВЕДИТЕ НАИМЕНОВАНИЯ ДНЯ НЕДЕЛИ ДЛЯ ПОИСКА РАСПИСАНИЯ===");
        String weekName = scanner.nextLine().toLowerCase().trim();
        List<Lesson> lessonsForDay = schedule.getLessonsByDay(weekName);
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
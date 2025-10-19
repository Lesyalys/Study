package java_3;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Schedule {
	private String auditNumber;
	private String adress;
	private List<Lesson> lessons;
	
	public Schedule() {
        this.auditNumber = "000";
        this.adress = "Не указан";
        this.lessons = new ArrayList<>();
        System.out.println("Вызван конструктор Schedule без параметров");
    }
	
	public Schedule(String auditNumber,String adress, List<Lesson> lessons) {
		this.auditNumber = auditNumber;
		this.adress = adress;
		this.lessons = lessons;
		System.out.println("Вызван конструктор Schedule с параметрами: " + auditNumber + ", " + adress);
	}
	
	public Schedule(Schedule sch) {
        this.auditNumber = sch.auditNumber;
        this.adress = sch.adress;
        this.lessons = new ArrayList<>(sch.lessons);
        System.out.println("Вызван конструктор копирования Schedule");
    }
	 public Schedule(String auditNumber, String adress) { 
	        this.auditNumber = auditNumber;
	        this.adress = adress;
	        this.lessons = new ArrayList<>();
	        System.out.println("Вызван конструктор Schedule с параметрами: " + auditNumber + ", " + adress);
	    }
	@Override
	public void finalize() throws Throwable {
		System.out.println("Вызван деструктор Schedule для объекта: "+auditNumber);
		super.finalize();
	}
	
	public void addLessonWithParams(String name, String dayOfWeek, LocalTime localTime) {
		Lesson les = new Lesson(name,dayOfWeek,localTime);
		lessons.addLast(les);
		System.out.println("Добавлено занятие через конструктор с параметрами: " + name);
	}
	
	public void addLessonCopies(Lesson original, int count) {
		for (int i =0; i < count; i++) {
			Lesson cope = new Lesson(original);
			lessons.add(cope);
			System.out.println("Создана копия занятия: " + cope.getName() + " (копия " + (i + 1) + ")");
		}
	}
	
	public String getAdress() {
		return adress;
	}
	
	public Lesson findLessonByName(String name) {
		return (lessons.stream()
				.filter(les -> les.getName().equals(name)))
				.findFirst()
				.orElse(null);
				
	}
	
	public List<Lesson> getLessonsByDay(String dayOfWeek){
		return lessons.stream()
				.filter(les -> les.getDayOfWeek().equals(dayOfWeek))
				.collect(Collectors.toList());
	}
	
	public List<Lesson> getAllSchedule(){
		return(lessons.stream().collect(Collectors.toList()));
	}
	
	public void getAllFeeldSchedule() {
	    String lessonNames = lessons.stream()
	        .map(Lesson::getName)
	        .collect(Collectors.joining(", "));
	    
	    System.out.println("\nauditNumber: " + auditNumber + 
	        "\nadress: " + adress + 
	        "\nlessons: " + lessonNames);
	}
	
	public void getAllNameDayOfWeek() {
		lessons.stream()
		.map(Lesson::getDayOfWeek)
		.distinct()
		.forEach(System.out::println);
	}
	public void removeLesson(Lesson lesson) {
		lessons.remove(lesson);
	}
	public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }
	

	
	
}

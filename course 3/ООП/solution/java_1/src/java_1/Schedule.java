package java_1;

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
    }
	
	public Schedule(String auditNumber,String adress) {
		this.auditNumber = auditNumber;
		this.adress = adress;
		this.lessons = new ArrayList<>();
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
	
	public void removeLesson(Lesson lesson) {
		lessons.remove(lesson);
	}
	public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }
	

	
	
}

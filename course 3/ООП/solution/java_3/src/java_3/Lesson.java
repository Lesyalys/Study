package java_3;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Lesson {
	private String name;
	protected String labsWork;
	protected String lection;
	private String dayOfWeek;
	private LocalTime time;
	
    public Lesson() {
        this.name = "Не указано";
        this.dayOfWeek = "Понедельник";
        this.time = LocalTime.of(9, 0);
        System.out.println("Вызван конструктор Lesson без параметров");
    }
    
    public Lesson(String name, String dayOfWeek, LocalTime time) {
        this.name = name;
        this.dayOfWeek = dayOfWeek;
        this.time = time;
        System.out.println("Вызван конструктор Lesson с параметрами: " + name + ", " + dayOfWeek + ", " + time);
    }
    
    public Lesson(Lesson lesson) {
        this.name = lesson.name + " (копия)";
        this.dayOfWeek = lesson.dayOfWeek;
        this.time = lesson.time;
        System.out.println("Вызван конструктор копирования Lesson для: " + lesson.name);
    }
    
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Вызван деструктор Lesson для: " + name);
        super.finalize();
    }
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDayOfWeek() {
        return dayOfWeek;
    }
	
	public void getallFeelds() {
		System.out.println("\nName: "+ name + "\nDay of week: " + dayOfWeek + "\nTime: " + time);
	}
    
    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
    
    public LocalTime getTime() {
        return time;
    }
    
    public void setTime(LocalTime time) {
        this.time = time;
    }
    
    public void setTime(String timeString) {
        this.time = LocalTime.parse(timeString, DateTimeFormatter.ofPattern("HH:mm"));
    }

}

package java_1;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Lesson {
	private String name;
	private String dayOfWeek;
	private LocalTime time;
	
	public Lesson(String name, String dayOfWeek, LocalTime time) {
		this.name = name;
		this.dayOfWeek = dayOfWeek;
		this.time = time;
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

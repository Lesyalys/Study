package java7.DB;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int age;
    private String address;
    
    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getAddress() { return address; }
    
    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", address='" + address + "'}";
    }
}
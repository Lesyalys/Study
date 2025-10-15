package java8;

public class MainClass {
public static void main(String[] args) {
String curPath = System.getProperty("user.dir");
System.out.println("Working Directory = " + curPath);
DBClass myDB = new DBClass(curPath); 
//myDB.showTable("student"); //показываем содержимое нужной таблицы - student
}
}

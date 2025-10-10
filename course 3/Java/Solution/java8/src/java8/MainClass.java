package java8;

public class MainClass {
public static void main(String[] args) {
String curPath = System.getProperty("user.dir"); //переменная для пути к папке проекта
System.out.println("Working Directory = " + curPath);
DBClass myDB = new DBClass(curPath); //объект для работы с БД
myDB.showTable("student"); //показываем содержимое нужной таблицы - student
}
}

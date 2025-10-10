package java8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class H2Demo {

    // JDBC URL для встроенной базы данных.
    // '~' означает вашу домашнюю директорию.
    private static final String JDBC_URL = "jdbc:h2:~/test";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static void main(String[] args) throws Exception {
        // Загружаем драйвер (в современных версиях Java это часто необязательно)
        Class.forName("org.h2.Driver");

        // Устанавливаем соединение с БД
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            // Создаем тестовую таблицу
            statement.execute("CREATE TABLE IF NOT EXISTS users(id INT PRIMARY KEY, name VARCHAR(255))");

            // Вставляем данные
            statement.executeUpdate("INSERT INTO users VALUES(1, 'Alice')");
            statement.executeUpdate("INSERT INTO users VALUES(2, 'Bob')");

            // Выполняем запрос и выводим результат
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name"));
            }
        }
        System.out.println("Готово!");
    }
}
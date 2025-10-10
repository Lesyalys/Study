package java8;
import org.h2.tools.Server;
import java.sql.SQLException;

public class java8 {
    public static void main(String[] args) throws SQLException {
        Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082").start();
        System.out.println("Консоль H2 запущена по адресу: http://localhost:8082");
    }
}

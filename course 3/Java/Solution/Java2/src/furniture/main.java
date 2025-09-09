package furniture;
import java.util.Scanner;

/**
 * ❗Главный класс приложения для демонстрации работы с мебелью в комнате❗.
 * Содержит точку входа в программу (main метод).
 * 
 * @author 💫 Lesya Valentyukevich group 3312 🌠
 * @version 1.0
 * @see Room класс комнаты для хранения мебели 💒
 * @see Sofa класс дивана 🛋️
 * @see Wardrobe класс шкафа 🚪
 * @see furniture базовый класс мебели 🛏️
 */
public class main {

    /**
     * Основной метод приложения.
     * Демонстрирует работу с системой учета мебели в комнате:
     * - Ввод количества мебели
     * - Добавление мебели в комнату
     * - Подсчет количества мебели по типам
     * - Обработка исключений ввода
     * 
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        int count = 0;
        Room room = new Room();
        
        Scanner scan = new Scanner(System.in);
        
        try {
            // Запрос количества диванов для добавления
            System.out.println("Enter do you want add in room Sofa count : ");    
            count = scan.nextInt();
            Sofa sofa = new Sofa("s1");
            room.AddFur(sofa, count);
            
            // Запрос количества шкафов для добавления
            System.out.println("Enter do you want add in room Wardrobe count: ");
            count = scan.nextInt();
            Wardrobe wardrobe = new Wardrobe("w2");
            room.AddFur(wardrobe, count);
            
        } catch(Exception ex) {
            // Обработка ошибок ввода
            System.out.println("Error!" + ex);
        } finally {
            // Закрытие Scanner для предотвращения утечек ресурсов
            scan.close();
        }
        
        // Вывод результатов подсчета мебели
        System.out.println("Wardrobe: " + room.countWardrobe());
        System.out.println("Sofa: " + room.coutSofa());
        System.out.println("all: "+ room.sumAllFurniture());
        
        // Закомментированный вывод всей мебели (можно раскомментировать для отладки)
        // room.showAllFurniture();
    }
}
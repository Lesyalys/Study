package furniture;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

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
     * - Ввод характеристик мебели
     * - Добавление мебели в комнату
     * - Подсчет количества мебели по типам
     * - Обработка исключений ввода
     * 
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        Room room = new Room();
        Scanner scan = new Scanner(System.in);
        List<furniture> allSofas = new ArrayList<>();
        List<furniture> allWardrobes = new ArrayList<>();
        
        try {
            // Ввод данных для диванов
            System.out.println("Введите количество диванов: ");
            int sofaCount = scan.nextInt();
            scan.nextLine(); // очистка буфера
            
            for (int i = 0; i < sofaCount; i++) {
                System.out.println("Диван #" + (i + 1));
                System.out.println("Введите название дивана: ");
                String sofaName = scan.nextLine();
                
                System.out.println("Введите материал дивана: ");
                String sofaMaterial = scan.nextLine();
                
                System.out.println("Введите цвет дивана: ");
                String sofaColor = scan.nextLine();
                
                Sofa sofa = new Sofa(sofaName, sofaMaterial, sofaColor);
//                List<furniture> addedSofas = room.AddFur(sofa, 1);
//                allSofas.addAll(addedSofas);
                room.AddFur(sofa, 1);
                allSofas.add(sofa);
            }
            
            // Ввод данных для шкафов
            System.out.println("Введите количество шкафов: ");
            int wardrobeCount = scan.nextInt();
            scan.nextLine(); // очистка буфера
            
            for (int i = 0; i < wardrobeCount; i++) {
                System.out.println("Шкаф #" + (i + 1));
                System.out.println("Введите название шкафа: ");
                String wardrobeName = scan.nextLine();
                
                System.out.println("Введите материал шкафа: ");
                String wardrobeMaterial = scan.nextLine();
                
                System.out.println("Введите количество дверей: ");
                int doorsCount = scan.nextInt();
                scan.nextLine(); // очистка буфера
                
                Wardrobe wardrobe = new Wardrobe(wardrobeName, wardrobeMaterial, doorsCount);
//                List<furniture> addedWardrobes = room.AddFur(wardrobe, 1);
//                allWardrobes.addAll(addedWardrobes);
                room.AddFur(wardrobe, 1);
                allWardrobes.add(wardrobe);
            }
            
            // Вывод результатов
            System.out.println("\n=== ВСЯ МЕБЕЛЬ В КОМНАТЕ ===");
            room.showAllFurniture();
            
            System.out.println("\n=== СТАТИСТИКА ===");
            System.out.println("Всего предметов мебели: " + room.sumAllFurniture());
            
            // Вывод всех диванов
            System.out.println("\n=== ВСЕ ДИВАНЫ ===");
            for (furniture sofa : allSofas) {
                System.out.println(sofa.toString());
            }
            
            // Вывод всех шкафов
            System.out.println("\n=== ВСЕ ШКАФЫ ===");
            for (furniture wardrobe : allWardrobes) {
                System.out.println(wardrobe.toString());
            }
            
            
        } catch(Exception ex) {
            System.out.println("Ошибка ввода данных: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            scan.close();
        }
    }
}
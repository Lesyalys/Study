package furniture;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

/**
* Главный класс приложения для демонстрации работы с мебелью в комнате.
* Содержит точку входа в программу (main метод).
* 
* @author Lesya Valentyukevich group 3312
* @version 1.0
*/
public class main {
	public main() {
        // Конструктор по умолчанию
    }
	/**
     * Конструктор по умолчанию класса main.
     * Используется для создания экземпляра главного класса приложения.
     */
	public static void main(String[] args) {
    	
        Room room = new Room();
        Scanner scan = new Scanner(System.in);
        List<furniture> allSofas = new ArrayList<>();
        List<furniture> allWardrobes = new ArrayList<>();
        
        try {
            // Ввод данных для диванов
//            System.out.println("Введите количество диванов: ");
            int sofaCount = 3;
//            scan.nextLine(); // очистка буфера
            
            for (int i = 0; i < sofaCount; i++) {
//                System.out.println("Диван #" + (i + 1));
//                System.out.println("Введите название дивана: ");
                String sofaName = "num2";
                
//                System.out.println("Введите материал дивана: ");
                String sofaMaterial = "1";
                
//                System.out.println("Введите цвет дивана: ");
                String sofaColor = "red";
                
                Sofa sofa = new Sofa(sofaName, sofaMaterial, sofaColor);
//                List<furniture> addedSofas = room.AddFur(sofa, 1);
//                allSofas.addAll(addedSofas);
                room.AddFur(sofa, 1);
                allSofas.add(sofa);
            }
            
            // Ввод данных для шкафов
//            System.out.println("Введите количество шкафов: ");
            int wardrobeCount = 2;
//            scan.nextLine(); // очистка буфера
            
            for (int i = 0; i < wardrobeCount; i++) {
//                System.out.println("Шкаф #" + (i + 1));
//                System.out.println("Введите название шкафа: ");
                String wardrobeName = "num 1";
                
//                System.out.println("Введите материал шкафа: ");
                String wardrobeMaterial = "wood";
                
//                System.out.println("Введите количество дверей: ");
                int doorsCount = 3;
//                scan.nextLine(); // очистка буфера
                
                Wardrobe wardrobe = new Wardrobe(wardrobeName, wardrobeMaterial, doorsCount);
//                List<furniture> addedWardrobes = room.AddFur(wardrobe, 1);
//                allWardrobes.addAll(addedWardrobes);
                room.AddFur(wardrobe, 1);
                allWardrobes.add(wardrobe);
            }
            
            // Вывод результатов
            System.out.println("\n=== ВСЯ МЕБЕЛЬ В КОМНАТЕ ===");
//            room.showAllFurniture();
            
//            System.out.println("\n=== СТАТИСТИКА ===");
            System.out.println("Всего предметов мебели: " + room.sumAllFurniture());
            
            // Вывод всех диванов
            
            System.out.println("\n=== ВСЕ ДИВАНЫ ===");
            System.out.println("Всего диванов: " + room.coutSofa());
            for (furniture sofa : allSofas) {
                System.out.println( sofa.toString());
            }
            
            // Вывод всех шкафов
            System.out.println("\n=== ВСЕ ШКАФЫ ===");
            System.out.println("Всего шкафов: " + room.countWardrobe());
            for (furniture wardrobe : allWardrobes) {
                System.out.println( wardrobe.toString());
            }
            
            System.out.println("\nВедите наименование шкафа для поиска по имени: ");
            room.ReturnName(scan.nextLine());
            
            
            
        } catch(Exception ex) {
            System.out.println("Ошибка ввода данных: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            scan.close();
        }
    }
}
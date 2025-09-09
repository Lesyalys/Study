package furniture;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс Room представляет комнату, которая может содержать различные предметы мебели.
 * Обеспечивает функциональность для добавления мебели, подсчета конкретных типов мебели
 * и отображения всей мебели в комнате.
 * @author 💫 Lesya Valentyukevich group 3312 🌠
 */
public class Room {
    // Список для хранения всех предметов мебели в комнате
    private List<furniture> furList;
    
    /**
     * Конструктор по умолчанию. Инициализирует пустой список для хранения мебели.
     */
    public Room() {
        furList = new ArrayList<>();
    }
    
    /**
     * Добавляет указанный предмет мебели в комнату заданное количество раз.
     * 
     * @param fur объект мебели для добавления (диван или шкаф)
     * @param count количество экземпляров для добавления
     */
    public void AddFur(furniture fur, int count) {
        for (int i = 0; i < count; i++) {
            furList.add(fur);
        }
    }
    
    /**
     * Подсчитывает количество диванов в комнате.
     * Использует оператор instanceof для проверки типа мебели.
     * 
     * @return количество диванов в комнате
     */
    public int coutSofa() {
        int count = 0;
        for (furniture f: furList) {
            if (f instanceof Sofa) {
                count ++;
            }
        }
        return count;
    }
    
    /**
     * Подсчитывает количество шкафов в комнате.
     * Использует оператор instanceof для проверки типа мебели.
     * 
     * @return количество шкафов в комнате
     */
    public int countWardrobe() {
        int count = 0;
        for (furniture f : furList) {
            if (f instanceof Wardrobe) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * Отображает все предметы мебели в комнате.
     * Для каждого предмета вызывает метод toString().
     */
    public void showAllFurniture() {
        for (furniture fur: furList) {            
            System.out.println(fur);
        }
    }
    
    /**
     * Подсчитывает общее количество предметов мебели в комнате.
     * 
     * @return общее количество мебели в комнате
     */
    public int sumAllFurniture() {
        int count = 0;
        for (int i = 0; i < furList.size(); i++) {
            count++;
        }
        return count;
    }
}
package furniture;
import java.util.List;
import java.util.ArrayList;

/**
 * Класс комнаты для хранения мебели.
 * Предоставляет методы для добавления и подсчета мебели.
 * 
 * @author Lesya Valentyukevich group 3312
 * @version 1.0
 */
public class Room {
    /** Список мебели в комнате */
    private List<furniture> furList;

    /**
     * Конструктор класса Room.
     * Инициализирует список мебели.
     */
    public Room() {
        furList = new ArrayList<>();
    }

    /**
     * Добавляет мебель в комнату.
     *
     * @param fur объект мебели для добавления
     * @param count количество экземпляров для добавления
     * @return список добавленной мебели
     */
    public List<furniture> AddFur(furniture fur, int count) {
        List<furniture> addedFurniture = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            furList.add(fur);
            addedFurniture.add(fur);
        }
        return addedFurniture;
    }
    
    public int ReturnName(String name) {
    	int count = (int) furList.stream().filter(ful -> ful.getName().equals(name)).count();
    	System.out.println("Шкаф с именем: "+name+" колличество: "+count);
    	return count;
    }
    

    /**
     * Подсчитывает общее количество мебели в комнате.
     *
     * @return общее количество мебели
     */
    public int sumAllFurniture() {
        return furList.size();
    }
    

    /**
     * Подсчитывает количество диванов в комнате.
     *
     * @return количество диванов
     */
    public int coutSofa() {
        int count = 0;
        for (furniture fur : furList) {
            if (fur instanceof Sofa) {
                count++;
            }
        }
        return count;
    }

    /**
     * Подсчитывает количество шкафов в комнате.
     *
     * @return количество шкафов
     */
    public int countWardrobe() {
        int count = 0;
        for (furniture fur : furList) {
            if (fur instanceof Wardrobe) {
                count++;
            }
        }
        return count;
    }

    /**
     * Отображает всю мебель в комнате.
     */
    public void showAllFurniture() {
        for (furniture fur : furList) {
            System.out.println(fur.toString());
        }
    }
}
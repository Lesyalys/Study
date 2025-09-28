package furniture;
import java.util.List;

/**
 * Класс шкафа, наследуется от базового класса мебели.
 * Представляет шкаф с дополнительными характеристиками: материал и количество дверей.
 * 
 * @author Lesya Valentyukevich group 3312
 * @version 1.0
 */
public class Wardrobe extends furniture {
    /** Наименование материала шкафа */
    private String wardrobeMaterial;
    
    /** Количество дверей у шкафа */
    private Integer doorsCount;

    /**
     * Конструктор класса Wardrobe.
     *
     * @param wardrobeName название шкафа
     * @param wardrobeMaterial материал шкафа
     * @param doorsCount количество дверей у шкафа
     */
    public Wardrobe(String wardrobeName, String wardrobeMaterial, int doorsCount) {
        super(wardrobeName);
        this.wardrobeMaterial = wardrobeMaterial;
        this.doorsCount = doorsCount;
    }

    /**
     * Получает материал шкафа.
     *
     * @return материал шкафа
     */
    public String getWardrobeMaterial() {
        return wardrobeMaterial;
    }

    /**
     * Получает количество дверей шкафа.
     *
     * @return количество дверей
     */
    public Integer getDoorsCount() {
        return doorsCount;
    }

    /**
     * Подсчитывает количество шкафов в списке мебели.
     *
     * @param furList список мебели для анализа
     * @return количество шкафов
     */
    public int countWardrobe(List<furniture> furList) {
        int count = 0;
        for (furniture fur : furList) {
            if (fur instanceof Wardrobe) {
                count++;
            }
        }
        return count;
    }

    /**
     * Возвращает строковое представление шкафа.
     *
     * @return строка с информацией о шкафе
     */
    @Override
    public String toString() {
        return "Шкаф: Name: " + getName() + ", Material: " + wardrobeMaterial + ", CountDoor: " + doorsCount;
    }
}
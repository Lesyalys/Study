package furniture;
import java.util.List;

/**
 * Класс дивана, наследуется от базового класса мебели.
 * Представляет диван с дополнительными характеристиками: материал и цвет.
 * 
 * @author Lesya Valentyukevich group 3312
 * @version 1.0
 */
public class Sofa extends furniture {
    /** Наименование материала дивана */
    private String material;
    
    /** Цвет дивана */
    private String color;

    /**
     * Конструктор класса Sofa.
     *
     * @param name название дивана
     * @param material материал дивана
     * @param color цвет дивана
     */
    public Sofa(String name, String material, String color) {
        super(name);
        this.material = material;
        this.color = color;
    }

    /**
     * Получает материал дивана.
     *
     * @return материал дивана
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Получает цвет дивана.
     *
     * @return цвет дивана
     */
    public String getColor() {
        return color;
    }

    /**
     * Подсчитывает количество диванов в списке мебели.
     *
     * @param furList список мебели для анализа
     * @return количество диванов
     */
    public int countSofa(List<furniture> furList) {
        int count = 0;
        for (furniture fur : furList) {
            if (fur instanceof Sofa) {
                count++;
            }
        }
        return count;
    }

    /**
     * Возвращает строковое представление дивана.
     *
     * @return строка с информацией о диване
     */
    @Override
    public String toString() {
        return "Диван: Name: " + getName() + ", Material: " + material + ", Color: " + color;
    }

    /**
     * Получает информацию о всех диванах в списке.
     *
     * @param furList список мебели для анализа
     * @return строка с информацией о диванах
     */
    public static String getSofaInfo(List<furniture> furList) {
        StringBuilder info = new StringBuilder();
        for (furniture fur : furList) {
            if (fur instanceof Sofa) {
                info.append(fur.toString()).append("\n");
            }
        }
        return info.toString();
    }
}
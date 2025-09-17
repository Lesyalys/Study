package furniture;

import java.util.List;

/**
 * 🛋️ Класс, представляющий диван как вид мебели 🛋️.
 * Наследуется от базового класса Furniture и реализует специфические свойства дивана.
 * 
 * @author 💫 Lesya Valentyukevich group 3312 🌠
 * @version 1.0
 * @see Furniture базовый класс мебели
 */
public class Sofa extends furniture {
    private String material;
    private String color;

    /**
     * Конструктор класса Sofa.
     * Создает объект дивана с указанными параметрами.
     * 
     * @param sofaName наименование дивана
     * @param sofaMaterial материал дивана
     * @param sofaColor цвет дивана
     */
    public Sofa(String sofaName, String sofaMaterial, String sofaColor) {
        super(sofaName); // Вызов конструктора родительского класса
        this.material = sofaMaterial;
        this.color = sofaColor;
    }

    /**
     * Подсчитывает количество диванов в списке мебели
     */
    public int countSofa(List<furniture> furList) {
        int count = 0;
        for (furniture f : furList) {
            if (f instanceof Sofa) {
                count++;
            }
        }
        return count;
    }

    /**
     * Возвращает материал дивана
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Возвращает цвет дивана
     */
    public String getColor() {
        return color;
    }

    /**
     * Возвращает строковое представление объекта дивана.
     */
    @Override
    public String toString() {
        return "🛋️ Диван: " + getName() + 
               "\n📦 Материал: " + material + 
               "\n🎨 Цвет: " + color;
    }

    /**
     * Статический метод для получения информации о диванах в списке
     */
    public static String getSofaInfo(List<furniture> furList) {
        int count = 0;
        for (furniture f : furList) {
            if (f instanceof Sofa) {
                count++;
            }
        }
        return "🔢 Количество диванов: " + count;
    }
}
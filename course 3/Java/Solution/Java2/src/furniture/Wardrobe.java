package furniture;

import java.util.List;

/**
 * 🚪 Класс, представляющий шкаф как вид мебели 🚪.
 * Наследуется от базового класса furniture и реализует специфические свойства шкафа.
 * 
 * @author 💫 Lesya Valentyukevich group 3312 🌠
 * @version 1.0
 * @see furniture базовый класс мебели
 */
public class Wardrobe extends furniture {
	private String wardrobeMaterial;
	private Integer doorsCount; 
    
    /**
     * Конструктор класса Wardrobe.
     * Создает объект шкафа с указанным наименованием.
     * 
     * @param name наименование шкафа (например, "Гардеробный шкаф", "Книжный шкаф", "Встроенный шкаф")
     */
    public Wardrobe(String wardrobeName, String wardrobeMaterial, int doorsCount) {
        super(wardrobeName); // Вызов конструктора родительского класса
        this.wardrobeMaterial = wardrobeMaterial;
        this.doorsCount = doorsCount;
    }
    
    public int countWardrobe(List<furniture> furList) {
        int count = 0;
        for (furniture f : furList) {
            if (f instanceof Wardrobe) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * Возвращает строковое представление объекта шкафа.
     * Переопределяет метод toString() родительского класса furniture.
     * Предоставляет более специфичное описание для объектов типа шкаф.
     * 
     * @return строковое описание шкафа в формате: "Шкаф: [наименование]"
     */
    @Override
    public String toString() {
        return("🛋️ Шкаф: " + getName() + 
                "\n📦 Материал: " + wardrobeMaterial + 
                "\n🎨 Кол-во дверей: " + doorsCount);
    }
}
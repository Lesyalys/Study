package furniture;

import java.util.List;

/**
 * 🛋️ Класс, представляющий диван как вид мебели 🛋️.
 * Наследуется от базового класса furniture и реализует специфические свойства дивана.
 * 
 * @author 💫 Lesya Valentyukevich group 3312 🌠
 * @version 1.0
 * @see furniture базовый класс мебели
 */
public class Sofa extends furniture {

    /**
     * Конструктор класса Sofa.
     * Создает объект дивана с указанным наименованием.
     * 
     * @param name наименование дивана (например, "Угловой диван", "Диван-кровать")
     */
    public Sofa(String sofaName, String sofaMaterial, String sofaColor) {
        super(sofaName); // Вызов конструктора родительского класса
    }
    

    public int coutSofa(List<furniture> furList) {
        int count = 0;
        for (furniture f: furList) {
            if (f instanceof Sofa) {
                count ++;
            }
        }
        return count;
    }
    
    /**
     * Возвращает строковое представление объекта дивана.
     * Переопределяет метод toString() родительского класса furniture.
     * Предоставляет более специфичное описание для объектов типа диван.
     * 
     * @return строковое описание дивана в формате: "Диван: [наименование]"
     */
//    @Override
//    public String toString() {
//        return ("Sofa: " + nameMaterial);
//    }
    
    public String toString(Sofa s, List<furniture> furList) {
        return("\n🔢count: "+ s.coutSofa(furList)+"\n☁️materials: ?"+"\nName: "+s.name);
    }
}
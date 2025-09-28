package furniture;

/**
 * Базовый класс мебели.
 * Содержит общие характеристики для всех видов мебели.
 * 
 * @author Lesya Valentyukevich group 3312
 * @version 1.0
 */
public class furniture {
    /** Название мебели */
    private String name;

    /**
     * Конструктор класса furniture.
     *
     * @param name название мебели
     */
    public furniture(String name) {
        this.name = name;
    }

    /**
     * Получает название мебели.
     *
     * @return название мебели
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает название мебели.
     *
     * @param name новое название мебели
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Возвращает строковое представление мебели.
     *
     * @return строка с названием мебели
     */
    @Override
    public String toString() {
        return "Мебель: " + name;
    }
}
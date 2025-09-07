//9. Базовый класс – мебель. 
//Производные – диван и шкаф. 
//Создать класс Комната, который может содержать оба вида объектов. 
//Предусмотреть метод подсчета отдельно диванов и шкафов (использовать оператор instanceof).

package furniture;

public class furniture {
	protected String name;
	
	public furniture(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return ("Мебель: "+ name);
	}
	
	
}

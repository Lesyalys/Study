//9. Задать хешмап вида (человек)-(место работы). 
//Организовать поиск людей с местом работы, введенным пользователем. 
//Посчитать людей, работающих в одном месте.
package java3;
import java.util.*;

public class hashMap1 {
	public static void main(String[] args) {
		main();
	}
	
	public static void main() {
		HashMap<String, String> manWork = new HashMap<String, String>();
		List<String> employer = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		
		manWork.put("Иван Петров", "Google");
        manWork.put("Мария Сидорова", "Microsoft");
        manWork.put("Петр Иванов", "Google");
        manWork.put("Анна Козлова", "Apple");
        manWork.put("Сергей Смирнов", "Microsoft");
        manWork.put("Ольга Волкова", "Google");
        manWork.put("Дмитрий Попов", "Amazon");
        manWork.put("Елена Новикова", "Microsoft");
        manWork.put("Алексей Морозов", "Google");
        manWork.put("Наталья Орлова", "Apple");
        
        System.out.println("Все сотрудники и компании:");
        manWork.forEach((name,company) -> System.out.println("name: "+name+"| company: "+company));
		
		System.out.println("Enter name for select work place: ");
		String input = scan.nextLine();
		manWork.entrySet().stream()
		.filter(entry -> entry.getValue().equals(input))
		.forEach(entry -> employer.add(entry.getKey()));
		System.out.println("Сотрудники компании " + input + ": " + employer);
		System.out.println("Количество людей из "+ input +": " + employer.size());
	}
}

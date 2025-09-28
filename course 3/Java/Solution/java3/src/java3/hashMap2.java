//1. Задать хешмап вида (английское слово)-(набор русских слов), т.е. словарь для перевода.
//Организовать перевод введенного пользователем с консоли слова.

package java3;
import java.util.*;

public class hashMap2 {
	public static void main(String[] args) {
		Scanner();
	}
	
	public static void Scanner() {
	Scanner scan = new Scanner(System.in);
	
	HashMap<String, String> dictionary = new HashMap<String, String>();
	
	dictionary.put("book", "книга");
    dictionary.put("house", "дом");
    dictionary.put("cat", "кот, кошка");
    dictionary.put("dog", "собака");
    dictionary.put("apple", "яблоко");
    dictionary.put("computer", "компьютер");
    dictionary.put("sun", "солнце");
    dictionary.put("water", "вода");
    dictionary.put("tree", "дерево");
    dictionary.put("car", "машина");	
	
	System.out.println("Доступные английские слова: "+dictionary.keySet());
	
	System.out.println("Введите английское слово для перевода: ");
	String input = scan.nextLine().toLowerCase().trim();
	if (dictionary.containsKey(input)) {
		System.out.println("Перевод: " + input + " -> " + dictionary.get(input));
	} else {
		System.out.println("Перевод не найден: ");
	}
	
	
	
	}
	

}

//9. Сформировать множество, в которое входят только латинские буквы, встретившиеся во входной
//строке, и множество знаков препинания из входной строки.

package java3;
import java.util.*;

public class many {
	public static void main (String[] args) {
		manysLats();
	}
	
	public static void manysLats() {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		Set<Character> inStrokeWords = new HashSet<>();
		Set<Character> inStrokeElement = new HashSet<>();
		
		String punctuation = ".,!?;:-()\"'";
		
		for (char c: input.toCharArray()) {
			if ((c >= 'a' && c <= 'z') 
					|| (c >= 'A' && c <= 'Z'))
//					(c >= 'А' && c <= 'Я') 
//					|| (c >= 'а' && c <= 'я')) 
			{
				inStrokeWords.add(c);
			} else if (punctuation.indexOf(c) != -1) {
				inStrokeElement.add(c);
			}
		}
		
		System.out.println("Латинские буквы во входной строке: " + inStrokeWords);
        System.out.println("Знаки препинания во входной строке: " + inStrokeElement);
		
		scan.close();
		
		
	}

}

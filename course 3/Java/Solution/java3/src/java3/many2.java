//1. Сформировать множество, элементами которого являются буквы от а до f и от x до z. Требуется
//ввести с клавиатуры некую последовательность символов, и выяснить, какие из них входят в
//заданное множество.

package java3;
import java.util.*;

public class many2 {
	public static void main (String[] args) {
		main();
	} 
	
	public static void main() {
		Scanner scan = new Scanner(System.in);
		String 	input = scan.nextLine();
		String 	fromAtoFList = "ABCDFabcdfXYZxyz";
		Set<Character> newManyAF = new HashSet<>();
		
		
		for(char c: input.toCharArray()) {
			if (fromAtoFList.indexOf(c) != -1 ) {
				newManyAF.add(c);
			}
		}
		System.out.println("Входная строка: "+ input);
		System.out.println("В множество от а до f от x до z: "+ newManyAF);

	}
}

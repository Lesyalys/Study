package Ex1;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class main2 {
	public static void main(String[] args) {
		
		int size = 0;
		ArrayTwo A2 = new ArrayTwo();
		System.out.println("Введите размер массива: ");
		Scanner in = new Scanner(System.in);
		
		try {
			size = in.nextInt();
			if (size > 0) {
				int[][] arraTwo = new int[size][size];
				
				Random random = new Random();
				
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j ++) {						
						arraTwo[i][j] = random.nextInt(3);
					}
				}
				System.out.println(Arrays.deepToString(arraTwo).replace("],", "],\n"));
				
				
				System.out.println("\n┌──────────────────────────────────────────────┐");
				System.out.println("│           ДВУМЕРНЫЕ МАССИВЫ               │");
				System.out.println("├──────────────────────────────────────────────┤");
				System.out.println("│ № 9  - Диагональные элементы                │");
				System.out.println("└──────────────────────────────────────────────┘");
				A2.dioganalArray(arraTwo);
				
				System.out.println("\n┌──────────────────────────────────────────────┐");
				System.out.println("│ № 19 - Столбцы с одинаковой суммой          │");
				System.out.println("└──────────────────────────────────────────────┘");
				A2.SumElement(arraTwo);
				System.out.println("────────────────────────────────────────────────");
			}
		} catch(Exception ex) {
			System.out.println("Неверное значение массива: "+ex.getMessage()); 
			}
		}
		

}

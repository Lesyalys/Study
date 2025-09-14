package Ex1;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
public class main {

	public static void main(String[] args) {
		int size = 0,sortArr[];
		
		ArrayOne A1 = new ArrayOne();

		
		System.out.println("Введите размер массива: ");
		Scanner in = new Scanner(System.in);
		
		try {
			size = in.nextInt();
			if (size > 0) {
				int[] arrayOne = new int[size];
				
				Random random = new Random();
				
				for (int i = 0; i < size; i++) {
					arrayOne[i] = random.nextInt(3);
				}

				System.out.println("Исходный массив: "+Arrays.toString(arrayOne));
				
				sortArr = A1.sort(arrayOne);
				
				System.out.println("\n┌──────────────────────────────────────────────┐");
				System.out.println("│           ОДНОМЕРНЫЕ МАССИВЫ              │");
				System.out.println("├──────────────────────────────────────────────┤");
				System.out.println("│ № 9  - Повторяющиеся элементы               │");
				System.out.println("└──────────────────────────────────────────────┘");
				System.out.println("Исходный ( Отсортированный ) массив: "+Arrays.toString(arrayOne));
				A1.selectMoreOne(sortArr);

				System.out.println("\n┌──────────────────────────────────────────────┐");
				System.out.println("│ № 19 - Сжатие массива                       │");
				System.out.println("└──────────────────────────────────────────────┘");
				System.out.println("Исходный ( Отсортированный ) массив: "+Arrays.toString(arrayOne));
				A1.cutArray(sortArr);

				
				
				in.close();
			} else {
				System.out.println("Размер массива не должен быть меньше или равен 0!");
			}
			
		} catch(Exception ex) {
			System.out.println("Неверное значение массива: "+ex.getMessage());
		}
		
		

	}

}

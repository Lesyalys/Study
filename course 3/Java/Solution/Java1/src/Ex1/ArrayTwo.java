package Ex1;
import java.util.Arrays;

public class ArrayTwo {

	//9. Для заданной квадратной матрицы сформировать одномерный массив из ее диагональных элементов.
	public void dioganalArray(int[][] array) {
    	System.out.println(Arrays.deepToString(array).replace("],", "],\n"));
        
        int n = array.length;
        int[] diagonal = new int[n];
        
        for (int i = 0; i < n; i++) {
            diagonal[i] = array[i][i]; 
        }
        
        System.out.println("Диагональные элементы: " + Arrays.toString(diagonal));
    }
	
	//19. Дан двумерный массив. Выяснить, есть ли столбцы с одинаковой суммой элементов. Если есть, вывести их номера
	public void SumElement(int[][] array) {
        
        int n = array.length;
        int[] diagonal = new int[n];
        int rows = array.length, cols = array[0].length;
        int[] colsSum = new int[cols];
        
        for (int j = 0; j < cols; j++) {
        	int sum = 0;
        	for (int i = 0; i < rows; i++) {
        		sum += array[i][j];
        	}
        	colsSum[j] = sum;
        }
        boolean found = false;
        for (int i = 0; i < cols; i++) {
            for (int j = i + 1; j < cols; j++) {
                if (colsSum[i] == colsSum[j]) {
                    System.out.println("│ Столбцы " + i + " и " + j + " имеют сумму: " + colsSum[i]);
                    found = true;
                }
            }
        }
        
        if (!found) {
            System.out.println("│ Столбцов с одинаковой суммой не найдено");
        }
        
    }
}
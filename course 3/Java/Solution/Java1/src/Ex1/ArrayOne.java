package Ex1;
import java.util.Arrays;

public class ArrayOne {

	//9. Задается массив. Узнать, какие элементы встречаются в массиве больше одного раза.
	public void selectMoreOne(int [] array) {
		
		boolean found = false;
	    int currentCount = 1;
		for (int i = 1; i < array.length; i++) {
	        if (array[i] == array[i - 1]) {
	            currentCount++;
	        } else {
	            if (currentCount > 1) {
	                System.out.println("Элемент " + array[i - 1] + " встречается " + currentCount + " раз");
	                found = true;
	            }
	            currentCount = 1;
	        }
	    }
		//last
	    if (currentCount > 1) {
	        System.out.println("Элемент " + array[array.length - 1] + " встречается " + currentCount + " раз");
	        found = true;
	    }
	    
	    if (!found) {
	        System.out.println("Повторяющихся элементов не найдено");
	    }
	
		

	}
	
	//19. Дан целочисленный массив с количеством элементов n. Сжать массив, выбросив из него каждый второй элемент.
	public void cutArray(int[] array) {
			
			int newSize = (array.length + 1) / 2;
			int[] newArray = new int[newSize];
			
			int newIndex = 0;
	        for (int i = 0; i < array.length; i += 2) {
	            newArray[newIndex] = array[i];
	            newIndex++;
	        }
			 System.out.println("Сжатый массив: " + Arrays.toString(newArray));
	
		}
	
	//sort
	public int[] sort(int[] mass) {
		int swap = 0;
		for (int i = 0; i< mass.length - 1; i++) {
			for (int j = 0; j < mass.length -1 -i; j++) {
				if (mass[j]> mass [j+1]) {
					swap = mass[j];
					mass[j] = mass[j+1];
					mass[j+1] = swap;
				}
			}	
		}
		return (mass);
		
	}
}

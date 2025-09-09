package furniture;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		int  count = 0;
		Room room = new Room();
		
		Scanner scan = new Scanner(System.in);
		
		try {
			System.out.println("Enter do you want add in room Sofa count : ");	
			count = scan.nextInt();
				Sofa sofa = new Sofa("s1");
				room.AddFur(sofa,count);
				
				System.out.println("Enter do you want add in room Warderbore coutn: ");
				count = scan.nextInt();
				Wardrobe  wardrove = new Wardrobe ("w2");
				room.AddFur(wardrove,count);
			
			
		}catch(Exception  ex) {
			System.out.println("Error!" + ex);
		} 
		
		System.out.println("Wardrobe: " + room.countWardrobe());
		System.out.println("Sofa: " + room.coutSofa());
		System.out.println("all: "+ room.sumAllFurniture());
//		room.showAllFurniture();
	} 
	

}

package furniture;
import java.util.ArrayList;
import java.util.List;

public class Room {
	private List<furniture> furList;
	
	public Room() {
		furList = new ArrayList<>();
	}
	
	public void AddFur(furniture fur,int count) {
		for (int i = 0; i < count; i++) {
			furList.add(fur);
		}
	}
	
	public int coutSofa() {
		int count = 0;
		for (furniture f: furList) {
			if (f instanceof Sofa) {
				count ++;
			}
		}
		return count;
	}
	public int countWardrobe() {
		int count = 0;
		for (furniture f : furList) {
			if (f instanceof Wardrobe) {
				count++;
			}
		}
		return count;
	}
	
	public void showAllFurniture() {
		for (furniture fur: furList) {			
			System.out.println(fur);
		}
	}
	
	public int sumAllFurniture() {
		int count = 0;
		for (int i = 0; i < furList.size(); i++) {
			count++;
		}
		return count;
	}
}

package furniture;

public class Wardrobe extends furniture{
	
	public Wardrobe(String name) {
		super(name);
	}
	
	@Override
	public String toString() {
		return("Шкаф: "+name);
	}
	
}

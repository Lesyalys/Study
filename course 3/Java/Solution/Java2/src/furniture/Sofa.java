package furniture;

public class Sofa extends furniture{

	public Sofa(String name) {
		super(name);
	}
	@Override
	public String toString() {
		return ("Диван: "+name);
	}

}

package laba3_3312_Valentyuchevich;

public class fclass2 extends fclass3 {
	
	private String s = "Private feelds from fclass2";
	
	public static void main(String args[]) {
	fclass1 fc2 = new fclass2();
	fclass1 fc1 = new fclass1();
	fclass3 fc3 = new fclass3();
	fc3.voice();
	fc2.voice();
	fc1.voice();
	
}
	@Override
	public void voice() {
		System.out.println("Im fclass2. My private: "+ s);
	}
}
package laba3_3312_Valentyuchevich;

public class fclass3 extends fclass1{
	private String s = "Private feelds from fclass3";
	
		public static void main(String args[]) {
		fclass1 fc1 = new fclass1();
		fclass3 fc3 = new fclass3();
		fc1.voice();
		fc3.voice();
		
	}
		@Override
		public void voice() {
			System.out.println("Im fclass3. My private: "+ s);
		}
}

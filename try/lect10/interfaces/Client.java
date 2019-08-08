package lect10.interfaces;

public class Client {

	public static void main(String[] args) {
		I1 obj1 = new Impl1();
		
		obj1.Fun();
		obj1.Fun1();
//		obj1.Fun2();  not allowed
		((Impl1)obj1).Fun3();
		
		// I2 reference not allowed for Impl1
		
		I3 obj3 = new Impl1();
		
		obj3.Fun();
		obj3.Fun1();
		obj3.Fun3();
		
		Impl1 obj4 = new Impl1();
		// can get everything in the class.
		
		

	}

}

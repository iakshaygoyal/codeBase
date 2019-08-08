package lect9.inpol;

public class C extends P {
	int d2 = 10;
	int d = -1;
	
	public C(){
		System.out.println("Inside C's constructor");
	}
	
	public void Fun2(){
		System.out.println("Inside C's Fun2.");
	}
	
	public void Fun(){
		System.out.println("Inside C's Fun.");
	}
	
	// Can't override a final function
//	public void finalFun(){
//		
//	}
	
	// statics don't get overriden
	public static void staticFun(){
		System.out.println("Inside C's static fun");
	}
}

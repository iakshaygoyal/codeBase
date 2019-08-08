package lect9;

// If it is declared final, C can't derive
//public final class P {
public class P {
	int d1 = 10;
	int d = 0;
	
	public P(){
		System.out.println("Inside P's constructors");
	}
	
	public void Fun1(){
		System.out.println("Inside P's Fun1.");
	}
	
	public void Fun(){
		System.out.println("Inside P's Fun.");
	}
	
	public final void finalFun(){
		System.out.println("C cannot override you");
	}
	
	public static void staticFun(){
		System.out.println("Inside P's static fun");
	}
}

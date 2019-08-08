package lect9;

public abstract class PA {
	public PA(){
		System.out.println("Inside PA's constructors");
	}
	
	public void Fun1(){
		System.out.println("Inside PA's Fun1.");
	}
	
	public abstract void Fun();
}

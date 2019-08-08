package interfaces;

public class Activity1 implements Fragment1.I{

	public static void main(String[] args) {
		System.out.println("Inside Activity1 main");
		Activity1 activity1=new Activity1();
		activity1.f();
	}
	
	void f(){
		System.out.println("Inside Activity1 f");
		Fragment1 fragment1=new Fragment1();
		fragment1.f1(this);
	}

	@Override
	public void method() {
		System.out.println("Inside Activity1 method");
	}

}

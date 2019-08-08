package oops;

//You cannot over-ride a static or final method

class ABCD{
	void func1(){
		System.out.println("Inside ABC func1");
	}
	static void func2(){
		System.out.println("Inside ABC func2");
	}
	final void func3(){
		System.out.println("Inside ABC func3");
	}
}

class DEFG extends ABCD{
	void func1(){
		System.out.println("Inside ABC func1");
	}
	void func2(){
		System.out.println("Inside ABC func2");
	}
	void func3(){
		System.out.println("Inside ABC func3");
	}
}

public class OverrideStaticMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

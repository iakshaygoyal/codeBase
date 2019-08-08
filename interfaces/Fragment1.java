package interfaces;

public class Fragment1 {

	interface I{
		void method();
	}
	I i;
	void initialize(I i){
		this.i=i;
	}
	
	//Its useless
//	void method(){
//		System.out.println("Inside Fragment1 method");
//	}
	
	public static void main(String[] args) {
		System.out.println("Inside Fragment1 main");
	}
	void f1(Activity1 a){
		System.out.println("Inside Fragment1 f1");
		initialize(a);
		this.i.method();
	}

}

package oops;

class Employee{
	void A(){
		throw new ArithmeticException("shit!!");
	}
	
	void B(){
		A();
	}
	
	void C(){
		B();
	}
}

public class UnExceptionPropagation{
	
	public static void main(String[] args) {
		Employee student=new Employee();
		try{
			student.C();
		}
		catch(ArithmeticException arithmeticException){
			System.out.println(arithmeticException);
		}
	}
}


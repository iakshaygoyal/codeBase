package Stack.Interfaces;

public class stackEmptyException extends Exception {
	public stackEmptyException(){
		super("Stack is Empty");
	}
	public String toString(){
		return super.getMessage();
	}

}

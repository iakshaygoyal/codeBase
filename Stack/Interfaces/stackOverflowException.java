package Stack.Interfaces;

public class stackOverflowException extends Exception {
	public stackOverflowException(){
		super("Stack Overflow");
	}
	public String toString(){
		return super.getMessage();
	}

}

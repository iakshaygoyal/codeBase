package lect13.shared;

public class StackOverflowException extends Exception {
	public StackOverflowException(){
		super("Stack is full");
	}
	
	public String toString(){
		return super.getMessage();
	}
}

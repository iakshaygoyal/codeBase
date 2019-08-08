package lect13.shared;

public class StackEmptyException extends Exception {
	public StackEmptyException(){
		super("Stack is empty");
	}
	
	public String toString(){
		return super.getMessage();
	}
}

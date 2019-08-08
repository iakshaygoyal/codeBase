package lect13.shared;

public class QueueOverflowException extends Exception {
	public QueueOverflowException(){
		super("Queue is full");
	}
	
	public String toString(){
		return super.getMessage();
	}
}

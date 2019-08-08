package lect13.shared;

public class QueueEmptyException extends Exception {
	public QueueEmptyException(){
		super("Queue is empty");
	}
	
	public String toString(){
		return super.getMessage();
	}
}

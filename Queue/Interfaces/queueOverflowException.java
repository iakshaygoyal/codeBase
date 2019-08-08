package Queue.Interfaces;

public class queueOverflowException extends Exception {
	public queueOverflowException(){
		super("Queue Overflow");
	}
	public String toString(){
		return super.getMessage();
	}

}

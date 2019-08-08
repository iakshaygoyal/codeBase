package Queue.Interfaces;

public class queueEmptyException extends Exception {
	public queueEmptyException(){
		super("Queue is Empty");
	}
	public String toString(){
		return super.getMessage();
	}

}

package Queue.Interfaces;

public interface iQueue<T> {
	int size();
	boolean isEmpty();
	T front() throws queueEmptyException;
	void enqueue(T data) throws queueOverflowException;
	T dequeue() throws queueEmptyException;
	void display();
}
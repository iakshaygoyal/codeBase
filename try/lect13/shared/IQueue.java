package lect13.shared;

public interface IQueue<T> {
	int size();
	boolean isEmpty();
	T front() throws QueueEmptyException; // get
	void enqueue(T item) throws QueueOverflowException; // add
	T dequeue() throws QueueEmptyException; // remove
	void display();
	void reverse();
}

package lect13.shared;

public interface IStack<T> {
	int size();
	boolean isEmpty();
	T top() throws StackEmptyException; // get
	void push(T data) throws StackOverflowException; // add
	T pop() throws StackEmptyException; // remove
	void display();
}

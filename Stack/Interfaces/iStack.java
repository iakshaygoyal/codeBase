package Stack.Interfaces;

public interface iStack<T> {
	int size();
	boolean isEmpty();
	T top() throws stackEmptyException;
	T pop() throws stackEmptyException;
	void push(T data) throws stackOverflowException;
	void display();
}
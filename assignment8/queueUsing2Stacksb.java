package assignment8;

import Queue.Interfaces.iQueue;
import Queue.Interfaces.queueEmptyException;
import Queue.Interfaces.queueOverflowException;
import Stack.DifferentStacks.stackUsingLinkedList;
import Stack.Interfaces.stackEmptyException;

public class queueUsing2Stacksb<T> implements iQueue<T> {
	
	stackUsingLinkedList<T> stk1;
	stackUsingLinkedList<T> stk2;
	
	queueUsing2Stacksb(){
		this.stk1 = new stackUsingLinkedList<>();
		this.stk2 = new stackUsingLinkedList<>();
	}

	@Override
	public int size() {
		return this.stk1.size();
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public T front() throws queueEmptyException {
		T retval;
		try {
			retval = this.stk1.top();
		} catch (stackEmptyException e) {
			throw new queueEmptyException(); 
		}
		return retval;
	}

	@Override
	public void enqueue(T data) throws queueOverflowException {
		while(!this.isEmpty()){
			try {
				this.stk2.push(this.stk1.pop());
			} catch (stackEmptyException e) {
				//Unreachable code
			}
		}
		this.stk2.push(data);
		while(!this.stk2.isEmpty()){
			try {
				this.stk1.push(this.stk2.pop());
			} catch (stackEmptyException e) {
				//Unreachable code
			}
		}
		
	}

	@Override
	public T dequeue() throws queueEmptyException {
		T retval;
		try {
			retval = this.stk1.pop();
		} catch (stackEmptyException e) {
			throw new queueEmptyException();
		}
		return retval;
	}

	@Override
	public void display() {
		this.stk1.display();
		
	}

	@Override
	public void reverse() {
		// TODO Auto-generated method stub
		
	}

}

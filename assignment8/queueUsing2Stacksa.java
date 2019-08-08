package assignment8;

import Queue.Interfaces.iQueue;
import Queue.Interfaces.queueEmptyException;
import Queue.Interfaces.queueOverflowException;
import Stack.DifferentStacks.stackUsingLinkedList;
import Stack.Interfaces.stackEmptyException;

public class queueUsing2Stacksa<T> implements iQueue<T>{
	
	stackUsingLinkedList<T> stk1;
	stackUsingLinkedList<T> stk2;
	
	queueUsing2Stacksa(){
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
		if(this.isEmpty()){
			throw new queueEmptyException();
		}
		while(this.size() > 1){
			try {
				this.stk2.push(this.stk1.pop());
			} catch (stackEmptyException e) {
				// Unreachable Code
			}
		}
		T retval = null;
		try {
			 retval = this.stk1.top();
		} catch (stackEmptyException e) {
			// Unreachable Code
		}
		
		while(!this.stk2.isEmpty()){
			try {
				this.stk1.push(this.stk2.pop());
			} catch (stackEmptyException e) {
				// Unreachable Code
			}
		}
		return retval;
	}

	@Override
	public void enqueue(T data) throws queueOverflowException {
		this.stk1.push(data);
		
	}

	@Override
	public T dequeue() throws queueEmptyException {
		if(this.isEmpty()){
			throw new queueEmptyException();
		}
		while(this.size() > 1){
			try {
				this.stk2.push(this.stk1.pop());
			} catch (stackEmptyException e) {
				//Unreachable Code
			}
		}
		T retval = null;
		try {
			 retval = this.stk1.pop();
		} catch (stackEmptyException e) {
			// Unreachable Code
		}
		
		while(!this.stk2.isEmpty()){
			try {
				this.stk1.push(this.stk2.pop());
			} catch (stackEmptyException e) {
				// Unreachable Code
			}
		}
		return retval;
	}

	@Override
	public void display() {
		this.stk1.reverse();
		this.stk1.display();
		this.stk1.reverse();
	}

	@Override
	public void reverse() {
		// TODO Auto-generated method stub
		
	}

}

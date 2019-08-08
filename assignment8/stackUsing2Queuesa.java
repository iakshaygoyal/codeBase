package assignment8;

import Queue.DifferentQueues.queueUsingLinkedList;
import Queue.Interfaces.queueEmptyException;
import Queue.Interfaces.queueOverflowException;
import Stack.Interfaces.iStack;
import Stack.Interfaces.stackEmptyException;
import Stack.Interfaces.stackOverflowException;

public class stackUsing2Queuesa<T> implements iStack<T> {
	
	queueUsingLinkedList<T> cue1;
	queueUsingLinkedList<T> cue2;

	stackUsing2Queuesa(){
		this.cue1 = new queueUsingLinkedList<>();
		this.cue2 = new queueUsingLinkedList<>();
	}
	
	@Override
	public int size() {
		return this.cue1.size();
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public T top() throws stackEmptyException {
		if(this.isEmpty()){
			throw new stackEmptyException();
		}
		while(this.size() > 1){
			try {
				this.cue2.enqueue(this.cue1.dequeue());
			} catch (queueOverflowException e) {
				// Unreachable Code
				e.printStackTrace();
			} catch (queueEmptyException e) {
				// Unreachable Code
			}
		}
		T retval = null;
		try {
			retval = this.cue1.front();
			this.cue2.enqueue(this.cue1.dequeue());
		} catch (Exception e) {
			// Unreachable Code
		}
		
		queueUsingLinkedList<T> cue3 = this.cue1;
		this.cue1 = this.cue2;
		this.cue2 = cue3;		
	
		return retval;
	}

	@Override
	public T pop() throws stackEmptyException {
		if(this.isEmpty()){
			throw new stackEmptyException();
		}
		while(this.size() > 1){
			try {
				this.cue2.enqueue(this.cue1.dequeue());
			} catch (queueOverflowException e) {
				// Unreachable Code
				e.printStackTrace();
			} catch (queueEmptyException e) {
				// Unreachable Code
			}
		}
		T retval = null;
		try {
			retval = this.cue1.dequeue();
		} catch (queueEmptyException e) {
			// Unreachable Code
		}
		
		queueUsingLinkedList<T> cue3 = this.cue1;
		this.cue1 = this.cue2;
		this.cue2 = cue3;	
		
		return retval;
	}

	@Override
	public void push(T data) throws stackOverflowException {
		try {
			this.cue1.enqueue(data);
		} catch (queueOverflowException e) {
			// Unreachable Code
		}
		
	}

	@Override
	public void display() {
		this.cue1.reverse();
		this.cue1.display();
		this.cue1.reverse();
		
	}
	
	

	@Override
	public void reverse() {
		// TODO Auto-generated method stub
		
	}

}

package assignment8;

import Queue.DifferentQueues.queueUsingLinkedList;
import Queue.Interfaces.queueEmptyException;
import Queue.Interfaces.queueOverflowException;
import Stack.Interfaces.iStack;
import Stack.Interfaces.stackEmptyException;
import Stack.Interfaces.stackOverflowException;

public class stackUsing2Queuesb<T> implements iStack<T> {
	
	queueUsingLinkedList<T> cue1;
	queueUsingLinkedList<T> cue2;

	stackUsing2Queuesb(){
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
		T retval;
		try {
			retval = this.cue1.front();
		} catch (queueEmptyException e) {
			throw new stackEmptyException(); 
		}
		return retval;
	}

	@Override
	public T pop() throws stackEmptyException {
		T retval;
		try {
			retval = this.cue1.dequeue();
		} catch (queueEmptyException e) {
			throw new stackEmptyException(); 
		}
		return retval;
	}

	@Override
	public void push(T data) throws stackOverflowException {
		queueUsingLinkedList<T> cue3 = this.cue1;
		this.cue1 = this.cue2;
		this.cue2 = cue3;
		
		try {
			this.cue1.enqueue(data);
		} catch (queueOverflowException e) {
			//Unreachable Code
		}
		
		while(!this.cue2.isEmpty()){
			try {
				this.cue1.enqueue(this.cue2.dequeue());
			} catch (queueOverflowException e) {
				//Unreachable Code
			} catch (queueEmptyException e) {
				//Unreachable Code
			}
		}
	}

	@Override
	public void display() {
		this.cue1.display();
		
	}

	@Override
	public void reverse() {
		// TODO Auto-generated method stub
		
	}
	

}

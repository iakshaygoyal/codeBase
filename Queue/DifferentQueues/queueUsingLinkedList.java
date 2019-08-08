package Queue.DifferentQueues;

import LL.LinkedList;
import Queue.Interfaces.iQueue;
import Queue.Interfaces.queueEmptyException;
import Queue.Interfaces.queueOverflowException;

public class queueUsingLinkedList<T> implements iQueue<T> {
	
	private LinkedList<T> list;
	
	public queueUsingLinkedList(){
		this.list=new LinkedList<>();
	}

	public int size() {
		return this.list.size();
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public T front() throws queueEmptyException {
		try{
		T retval=this.list.getFirst();
		return retval;
		}catch(Exception e){
			throw new queueEmptyException();
		}
		
	}

	public void enqueue(T data) throws queueOverflowException {
		this.list.addLast(data);
	}

	public T dequeue() throws queueEmptyException {
		try{
			T retval=this.list.removeFirst();
			return retval;
		}
		catch(Exception e){
			throw new queueEmptyException();
		}
	}

	public void display() {
		System.out.println(this);
	}
	
	public String toString(){
		return this.list.toString();
	}
	
	public void reverse(){
		if(this.isEmpty()){
			return;
		}
		T retval = null;
		try {
			retval=this.dequeue();
		} catch (queueEmptyException e) {
			//Unreachable Code
		}
		this.reverse();
		try {
			this.enqueue(retval);
		} catch (queueOverflowException e) {
			//Unreachable Code

		}
	}

}

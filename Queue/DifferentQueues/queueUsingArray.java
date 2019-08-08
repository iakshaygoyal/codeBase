package Queue.DifferentQueues;

import Queue.Interfaces.iQueue;
import Queue.Interfaces.queueEmptyException;
import Queue.Interfaces.queueOverflowException;

public class queueUsingArray<T> implements iQueue<T> {
	
	protected T[] data;
	protected int front;
	protected int size;
	public static final int DEFAULT_VALUE=5;
	
	public queueUsingArray(){
		this(queueUsingArray.DEFAULT_VALUE);
	}
	
	public queueUsingArray(int capacity){
		this.data=(T[]) new Object[capacity];
		this.front=0;
		this.size=0;
	}

	public int size() {
		return this.size;
	}

	
	public boolean isEmpty() {
		return this.size() == 0;
	}

	public T front() throws queueEmptyException {
		if(this.isEmpty()){
			throw new queueEmptyException();
		}
		T retval=this.data[this.front];
		return retval;
	}

	public void enqueue(T data) throws queueOverflowException {
		if(this.size()==this.data.length){
			throw new queueOverflowException(); 
		}
		int idx=(this.front+this.size())%this.data.length;
		this.data[idx]=data;
		this.size++;
		
	}

	public T dequeue() throws queueEmptyException {
		if(this.isEmpty()){
			throw new queueEmptyException();
		}
		T retval=this.data[this.front];
		this.data[this.front] = null;
		this.front=(this.front+1)%this.data.length;
		this.size--;
		return retval;
	}

	public void display() {
		System.out.println(this);
	}
	
	public String toString(){
		String retval="";
		for(int i=0;i<this.size;i++){
			retval+=(this.front+i)%this.data.length+"=>";
		}
		retval+="END";
		return retval;
	}

}

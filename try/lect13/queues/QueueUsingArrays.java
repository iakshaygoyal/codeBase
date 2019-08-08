package lect13.queues;

import lect13.shared.*;

public class QueueUsingArrays<T> implements IQueue<T> {
	protected T[] data;
	protected int front;
	protected int size;
	public static final int DEFAULT_CAPACITY = 5;
	
	public QueueUsingArrays() {
		this(DEFAULT_CAPACITY);
	}
	
	public QueueUsingArrays(int capacity){
		this.data = (T[])new Object[capacity];
		this.front = 0;
		this.size = 0;
	}
	
	@Override
	public int size() {
		return this.size;
	}
	
	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}
	
	@Override
	public T front() throws QueueEmptyException {
		if(this.isEmpty()){
			throw new QueueEmptyException();
		}
		
		T retVal = this.data[this.front];
		return retVal;
	}
	
	@Override
	public void enqueue(T item) throws QueueOverflowException {
		if(this.size() == this.data.length){
			throw new QueueOverflowException();
		}
		
		int aI = (this.front + this.size()) % this.data.length;
		this.data[aI] = item;
		this.size++;
	}
	
	@Override
	public T dequeue() throws QueueEmptyException {
		if(this.isEmpty()){
			throw new QueueEmptyException();
		}
		
		T retVal = this.data[this.front];
		
		this.data[this.front] = null;
		this.front = (this.front + 1) % this.data.length;
		this.size--;
		
		return retVal;
	}
	
	@Override
	public void display() {
		System.out.println(this);
	}
	
	public String toString(){
		String retVal = "";
		
		for(int i = 0; i < this.size(); i++){
			int aI = (this.front + i) % this.data.length;
			retVal += this.data[aI] + ", ";
		}
		
		retVal += "END";
		
		return retVal;
	}
	
	@Override
	public void reverse() {
		// TODO Auto-generated method stub
		
	}
}

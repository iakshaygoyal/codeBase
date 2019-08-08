package Queue.DifferentQueues;

import Queue.Interfaces.iQueue;

public class queueUsingDynamicArray<T> extends queueUsingArray<T> implements iQueue<T> {
	public queueUsingDynamicArray(){
		super();
	}
	
	public queueUsingDynamicArray(int capacity){
		super(capacity);
	}
	
	public void enqueue(T data){
		if(this.size == this.data.length){
			T[] temp=(T[]) new Object[2*this.size];
			for(int i=0;i<this.size;i++){
				int idx=(this.front+i)%this.data.length;
				temp[i]=this.data[idx];
			}
			this.data=temp;
			this.front=0;
		}
		int idx=(this.front+this.size)%this.data.length;
		this.data[idx]=data;
		this.size++;
	}
}
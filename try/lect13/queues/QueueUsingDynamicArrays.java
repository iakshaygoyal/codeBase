package lect13.queues;

import lect13.shared.*;

public class QueueUsingDynamicArrays<T> extends QueueUsingArrays<T> implements IQueue<T> {
	public QueueUsingDynamicArrays() {
		super();
	}
	
	public QueueUsingDynamicArrays(int capacity){
		super(capacity);
	}
	
	@Override
	public void enqueue(T item) {
		if(this.size() == this.data.length){
			T[] temp = (T[]) new Object[2 * this.data.length];
			
			for(int i = 0; i < this.size(); i++){
				int ai = (this.front + i) % this.data.length;
				temp[i] = this.data[ai];
			}
			
			this.data = temp;
			this.front = 0;
		}
		
		int aI = (this.front + this.size()) % this.data.length;
		this.data[aI] = item;
		this.size++;
	}
}

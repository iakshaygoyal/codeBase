package again;

import Queue.Interfaces.iQueue;
import Queue.Interfaces.queueEmptyException;

public class queue<T extends Comparable<T>> implements iQueue<T> {
	private LinkedList<T> list;

	public queue() {
		this.list = new LinkedList<>();
	}

	@Override
	public int size() {
		return this.list.size();
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public T front() throws queueEmptyException {
		try {
			T retVal = this.list.getFirst();
			return retVal;
		} catch (Exception ex) {
			throw new queueEmptyException();
		}
	}

	@Override
	public void enqueue(T item) {
		this.list.addLast(item);
	}

	@Override
	public T dequeue() throws queueEmptyException {
		try {
			T retVal = this.list.removeFirst();
			return retVal;
		} catch (Exception ex) {
			throw new queueEmptyException();
		}
	}

	@Override
	public void display() {
		System.out.println(this);
	}
	
	public String toString(){
		return this.list.toString();
	}

	public void reverse() {
		this.reverse(this);
	}
	
	private void reverse(queue<T> q){
		if(q.isEmpty()){
			return;
		}
		
		T data = null;
		try {
			data = q.dequeue();
		} catch (queueEmptyException e) {
			// Unreachable Code
		}
		reverse(q);
		q.enqueue(data);
	}
}


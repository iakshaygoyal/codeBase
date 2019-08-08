package lect13.queues;

import lect11.linkedlists.*;
import lect13.shared.*;

public class QueueUsingLinkedLists<T extends Comparable<T>> implements IQueue<T> {
	private LinkedList<T> list;

	public QueueUsingLinkedLists() {
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
	public T front() throws QueueEmptyException {
		try {
			T retVal = this.list.getFirst();
			return retVal;
		} catch (Exception ex) {
			throw new QueueEmptyException();
		}
	}

	@Override
	public void enqueue(T item) {
		this.list.addLast(item);
	}

	@Override
	public T dequeue() throws QueueEmptyException {
		try {
			T retVal = this.list.removeFirst();
			return retVal;
		} catch (Exception ex) {
			throw new QueueEmptyException();
		}
	}

	@Override
	public void display() {
		System.out.println(this);
	}
	
	public String toString(){
		return this.list.toString();
	}

	@Override
	public void reverse() {
	}
}

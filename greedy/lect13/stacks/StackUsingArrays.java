package lect13.stacks;

import lect13.shared.*;

public class StackUsingArrays<T> implements IStack<T> {
	protected T[] data;
	protected int tos;
	private static final int DEFAULT_CAPACITY = 10;

	public StackUsingArrays() {
		this(StackUsingArrays.DEFAULT_CAPACITY);
	}

	public StackUsingArrays(int capacity) {
		this.data = (T[]) new Object[capacity];
		this.tos = -1;
	}

	public int size() {
		return this.tos + 1;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public T top() throws StackEmptyException {
		if (this.isEmpty()) {
			throw new StackEmptyException();
		}

		T retVal = this.data[this.tos];
		return retVal;
	}

	public void push(T data) throws StackOverflowException {
		if (this.size() == this.data.length) {
			throw new StackOverflowException();
		}

		this.tos++;
		this.data[this.tos] = data;
	}

	public T pop() throws StackEmptyException {
		if (this.isEmpty()) {
			throw new StackEmptyException();
		}

		T retVal = this.data[this.tos];

		this.data[this.tos] = null;
		this.tos--;

		return retVal;
	}

	public void display() {
		System.out.println(this);
	}

	public String toString() {
		String retVal = "";

		for (int i = this.tos; i >= 0; i--) {
			retVal += this.data[i] + " => ";
		}
		retVal += "END";

		return retVal;
	}
}

package Stack.DifferentStacks;

import Stack.Interfaces.iStack;
import Stack.Interfaces.stackEmptyException;
import Stack.Interfaces.stackOverflowException;

public class stackUsingArray<T> implements iStack<T> {
	protected T[] data;
	protected int tos;
	public static final int DEFAULT_VALUE=10;
	
	public stackUsingArray(){
		this(stackUsingArray.DEFAULT_VALUE);
	}
	
	public stackUsingArray(int capacity){
		this.data=(T[])new Object[capacity];
		this.tos=-1;
	}

	public int size() {
		return this.tos+1;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public T top() throws stackEmptyException {
		if(this.isEmpty()){
			throw new stackEmptyException();
		}
		T retval=this.data[this.tos];
		return retval;
	}

	public T pop() throws stackEmptyException {
		if(this.isEmpty()){
			throw new stackEmptyException();
		}
		T retval=this.data[this.tos];
		this.data[this.tos] = null;
		this.tos--;
		return retval;
	}

	public void push(T data) throws stackOverflowException {
		if(this.size() == this.data.length){
			throw new stackOverflowException();
		}
		this.tos++;
		this.data[this.tos] = data;
		
	}

	public void display() {
		System.out.println(this);
	}
	
	public String toString(){
		String retval="";
		for(int i=this.tos;i>=0;i--){
			retval+=this.data[i]+"=>";
		}
		retval+="END";
		return retval;
	}


}

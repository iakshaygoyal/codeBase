package lect13.stacks;

import lect13.shared.*;

public class StackUsingDynamicArrays<T> extends StackUsingArrays<T> implements IStack<T> {
	public StackUsingDynamicArrays(){
		super();
	}
	
	public StackUsingDynamicArrays(int capacity){
		super(capacity);
	}
	public void push(T data) {
		if(this.size() == this.data.length){
			T[] temp = (T[])new Object[2 * this.data.length];
			
			for(int i = 0; i < this.data.length; i++){
				temp[i] = this.data[i];
			}
			
			this.data = temp;
		}
		
		this.tos++;
		this.data[this.tos] = data;
	}
}

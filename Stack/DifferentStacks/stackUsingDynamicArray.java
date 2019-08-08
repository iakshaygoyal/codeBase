package Stack.DifferentStacks;

import Stack.Interfaces.iStack;

public class stackUsingDynamicArray<T> extends stackUsingArray<T> implements iStack<T> {
	
	public stackUsingDynamicArray(){
		super();
	}
	public stackUsingDynamicArray(int capacity){
		super(capacity);
	}
	
	public void push(T data){
		if(this.size()==this.data.length){
			T[] temp=(T[]) new Object[2*this.size()];
			for(int i=0;i<this.size();i++){
				temp[i]=this.data[i];
			}
			this.data=temp;
		}
		this.tos++;
		this.data[this.tos]=data;
	}

}

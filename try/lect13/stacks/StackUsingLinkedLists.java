package lect13.stacks;

import lect11.linkedlists.*;
import lect13.shared.*;

public class StackUsingLinkedLists<T extends Comparable<T>>  implements IStack<T> {
	private LinkedList<T> list;
	
	public StackUsingLinkedLists() {
		this.list = new LinkedList<>();
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.list.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.size() == 0;
	}

	@Override
	public T top() throws StackEmptyException {
		try {
			T retVal = this.list.getFirst();
			return retVal;
		} catch (Exception e) {
			throw new StackEmptyException();
		}
	}

	@Override
	public void push(T data) {
		this.list.addFirst(data);
	}

	@Override
	public T pop() throws StackEmptyException {
		try {
			T retVal = this.list.removeFirst();
			return retVal;
		} catch (Exception e) {
			throw new StackEmptyException();
		}
	}

	@Override
	public void display() {
		System.out.println(this);
	}

	public String toString(){
		return this.list.toString();
	}
	
	public void reverse(){
		IStack<T> helper = new StackUsingLinkedLists<>();
		
		try
		{
			while(!this.isEmpty()){
				helper.push(this.pop());
			}
			reverse(helper);
		}
		catch(StackEmptyException eEx){
			// never going to come here
		}
		catch(StackOverflowException oEx){
			// never going to come here
		}
	}
	
	private void reverse(IStack<T> helper) throws StackEmptyException{
		if(helper.isEmpty()){
			return;
		}
		
		T data = helper.pop();
		reverse(helper);
		this.push(data);
	}
}

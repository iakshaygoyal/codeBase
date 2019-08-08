package lect13.stacks;

import LL.LinkedList;
import lect13.shared.*;

public class StackUsingLinkedList<T extends Comparable<T>>  implements IStack<T> {
	private LinkedList<T> list;
	
	public StackUsingLinkedList() {
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
	
	public static boolean isBalanced(String s){
		IStack<Character> stk=new StackUsingLinkedList<>();
		
		for(int i=0;i<s.length();i++){
			Character c=s.charAt(i);
			
			if("[{(".indexOf(c) != -1){
				try {
					stk.push(c);
				} catch (StackOverflowException e) {
					
				}
			}
			else if(")}]".indexOf(c) != -1){
				try {
					Character tos=stk.pop();
					
					if((c=='[' && tos!=']') || (c=='{' && tos!='}') || (c=='(' && tos!=')')){
						return false;
					}
					
				} catch (StackEmptyException e) {
					return false;
				}
			}
		}
		return stk.isEmpty();
	}
	
	public void reverse(){
		IStack<T> helper=new StackUsingLinkedList<>();
		while(!this.isEmpty()){
			try {
				helper.push(this.pop());
			} catch (StackOverflowException e) {
				//Unreachable
			} catch (StackEmptyException e) {
				System.out.println(e);
			}
		}
		rereverse(helper);
		
	}
	
	public void rereverse(IStack<T> temp){
		if(temp.isEmpty()){
			return;
		}
		T data = null;
		try {
			data=temp.pop();
		} catch (StackEmptyException e) {
			System.out.println(e);
		}
		rereverse(temp);
		this.push(data);
	}
	
}

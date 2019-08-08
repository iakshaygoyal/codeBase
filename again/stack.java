package again;

import Stack.Interfaces.iStack;
import Stack.Interfaces.stackEmptyException;
import Stack.Interfaces.stackOverflowException;

public class stack<T extends Comparable<T>>  implements iStack<T> {
	private LinkedList<T> list;
	
	public stack() {
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
	public T top() throws stackEmptyException {
		try {
			T retVal = this.list.getFirst();
			return retVal;
		} catch (Exception e) {
			throw new stackEmptyException();
		}
	}

	@Override
	public void push(T data) {
		this.list.addFirst(data);
	}

	@Override
	public T pop() throws stackEmptyException {
		try {
			T retVal = this.list.removeFirst();
			return retVal;
		} catch (Exception e) {
			throw new stackEmptyException();
		}
	}

	@Override
	public void display() {
		System.out.println(this);
	}

	public String toString(){
		return this.list.toString();
	}
	
	public static boolean isBracketsBalanced(String s){
		stack<Character> stk = new stack<>();
		
		for(int i=0; i<s.length(); i++){
			char currentChar = s.charAt(i);
			
			if(currentChar == '{' || currentChar == '[' || currentChar == '('){
				stk.push(currentChar);
			}
			else if(currentChar == '}' || currentChar == ']' || currentChar == ')'){
				if(stk.isEmpty()){
					return false;
				}
				else{
					char popChar='a';
					try {
						popChar = stk.pop();
					} catch (stackEmptyException e) {
						// Unreachable Code
					}
					
					if((currentChar == '{' && popChar != '}') && (currentChar == '[' && popChar != ']') && (currentChar == '(' && popChar != ')')){
						return false;
					}
				}
			}
		}
		if(stk.isEmpty()){
			return true;
		}
		else{
			return false;
		}	
	}
	
	@Override
	public void reverse() {
		stack<T> stk = new stack<>();
		
		while(!this.isEmpty()){
			try {
				stk.push(this.pop());
			} catch (stackEmptyException e) {
				// Unreachable Code
			}
		}
		reverseHelper(stk);
	}
	
	private void reverseHelper(stack<T> stk){
		if(stk.isEmpty()){
			return;
		}
		T data = null;
		try {
			 data = stk.pop();
		} catch (stackEmptyException e) {
			// Unreachable Code
		}
		reverseHelper(stk);
		this.push(data);
	}
}

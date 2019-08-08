package Stack.DifferentStacks;

import java.util.ArrayList;

import LL.LinkedList;
import Stack.Interfaces.iStack;
import Stack.Interfaces.stackEmptyException;
import Stack.Interfaces.stackOverflowException;

public class stackUsingLinkedList<T> implements iStack<T> {
	
	private LinkedList<T> list;
	
	public stackUsingLinkedList(){
		this.list=new LinkedList<>();
	}

	public int size() {
		return this.list.size();
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public T top() throws stackEmptyException {
		try{
			T retval=this.list.getFirst();
			return retval;
		}catch(Exception e){
			throw new stackEmptyException();
		}
	}

	public T pop() throws stackEmptyException {
		try{
			T retval=this.list.removeFirst();
			return retval;
		}catch(Exception e){
			throw new stackEmptyException();
		}
	}

	public void push(T data) {
		this.list.addFirst(data);
	}


	public void display() {
		System.out.println(this);
	}
	
	public String toString(){
		return this.list.toString();
	}
	
	public static boolean isBracketsBalanced(String s){
		iStack<Character> stk=new stackUsingLinkedList<>();
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			if(c=='{' || c=='[' || c=='('){
				try {
					stk.push(c);
				} catch (stackOverflowException e) {
					// Unreachable Code
				}
				
			}
			else if(c=='}' || c==']' || c==')'){
				try {
					char tos=stk.pop();
					if((c=='{' && tos!='}') || (c=='[' && tos!=']') || (c=='(' && tos!=')')){
						return false;
					}
					
				} catch (stackEmptyException e) {
					return false;
				}
			}
		}
		System.out.println(s);
		return stk.isEmpty();
	}
	
//	public static boolean isDuplicateParenthesis(String s){
//		if((!stackUsingLinkedList.isBracketsBalanced(s))){
//			System.out.println("Brackets Not Balanced");
//			return false;
//		}
//		iStack<Character> stk = new stackUsingLinkedList<>();
//		ArrayList<String> arr = new ArrayList<String>();
//		for(int i=0;i<s.length();i++){
//			char c=s.charAt(i);
//			if(c=='{' || c=='[' || c=='('){
//				try {
//					stk.push(c);
//				} catch (stackOverflowException e) {
//					// Unreachable Code
//				}
//			}
//			else if(c=='}' || c==']' || c==')'){
//				String x;
//				try {
//					x = stk.pop()+ ""+c;
//					arr.add(x);
//				} catch (stackEmptyException e) {
//					//Unreachable Code				
//				}
//			}	
//		}
//		for(int i=0;i<arr.size();i++){
//			for(int j=i+1;j<arr.size();j++){
//				if(arr.get(i).equals(arr.get(j))){
//					return true;
//				}
//			}
//		}
//		return false;
//	}
	
	public static boolean isDuplicateParenthesis(String s){
		if((!stackUsingLinkedList.isBracketsBalanced(s))){
			System.out.println("Brackets Not Balanced");
			return false;
		}
		iStack<Character> stk = new stackUsingLinkedList<>();
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			if(c == ')' || c == '}' || c == ']'){
				char d = 'a';
				try {
					d = stk.top();
				} catch (stackEmptyException e) {
					System.out.println(e);
				}
				if(d == '(' || d == '{' || d == '['){
					return true;
				}
				else{
					while(d != '(' && d != '{' && d != '['){
						try {
							d = stk.pop();
						} catch (stackEmptyException e) {
							// Unreachable Code
							System.out.println(e);
						}
					}
				}
			}
			else{
				try {
					stk.push(c);
				} catch (stackOverflowException e) {
					// Unreachable Code
					System.out.println(e);
				}
			}
		}
		
		return false;
	}
	
	public void reverse() throws stackEmptyException,stackOverflowException{
		iStack<T> helper=new stackUsingLinkedList<>();
		while(this.size()!=0){
			helper.push(this.pop());
		}
		reReverse(helper);
	}
	
	public void reReverse(iStack<T> helper){
		if(helper.size() == 0){
			return;
		}
		T data = null;
		try {
			data=helper.pop();
		} catch (stackEmptyException e) {
			// Unreachable Code
		}
		reReverse(helper);
		this.push(data);
	}

}
